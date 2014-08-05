package net.crowifick.atlasrise.tiles;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crowifick.atlasrise.blocks.ARBlocks;
import net.crowifick.atlasrise.items.ARItems;
import net.crowifick.atlasrise.recipes.AtlasConvoyRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.*;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;

/**
 * User: Crowifick
 * Date: 8/4/14
 * Time: 11:47 PM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
public class TileEntityAtlasConvoy extends TileEntity implements ISidedInventory {

    private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsBottom = new int[] {2, 1};
    private static final int[] slotsSides = new int[] {1};

    private ItemStack[] atlasConvoyItemStacks = new ItemStack[3];

    public int atlasConvoyBurnTime;

    public int currentItemBurnTime;

    public int atlasConvoyCookTime;

    private String inventoryName;

    @Override
    public int getSizeInventory() {

        return atlasConvoyItemStacks.length;

    }

    @Override
    public ItemStack getStackInSlot(int par1) {

        return atlasConvoyItemStacks[par1];

    }

    @Override
    public ItemStack decrStackSize(int par1, int par2) {

        if (atlasConvoyItemStacks[par1] != null) {

            ItemStack itemstack;

            if (atlasConvoyItemStacks[par1].stackSize <= par2) {

                itemstack = atlasConvoyItemStacks[par1];
                atlasConvoyItemStacks[par1] = null;
                return itemstack;

            } else {

                itemstack = atlasConvoyItemStacks[par1].splitStack(par2);

                if (atlasConvoyItemStacks[par1].stackSize == 0) {

                    atlasConvoyItemStacks[par1] = null;

                }

                return itemstack;

            }

        } else {

            return null;

        }

    }

    @Override
    public ItemStack getStackInSlotOnClosing(int par1) {

        if (atlasConvoyItemStacks[par1] != null) {

            ItemStack itemstack = atlasConvoyItemStacks[par1];

            atlasConvoyItemStacks[par1] = null;

            return itemstack;

        } else {

            return null;

        }

    }

    @Override
    public void setInventorySlotContents(int par1, ItemStack itemStack) {

        atlasConvoyItemStacks[par1] = itemStack;

        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {

            itemStack.stackSize = this.getInventoryStackLimit();

        }

    }

    public boolean isBurning() {

        return atlasConvoyBurnTime > 0;

    }

    public void updateEntity()
    {
        boolean flag = this.furnaceBurnTime > 0;
        boolean flag1 = false;

        if (this.furnaceBurnTime > 0)
        {
            --this.furnaceBurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.furnaceBurnTime != 0 || this.furnaceItemStacks[1] != null && this.furnaceItemStacks[0] != null)
            {
                if (this.furnaceBurnTime == 0 && this.canSmelt())
                {
                    this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);

                    if (this.furnaceBurnTime > 0)
                    {
                        flag1 = true;

                        if (this.furnaceItemStacks[1] != null)
                        {
                            --this.furnaceItemStacks[1].stackSize;

                            if (this.furnaceItemStacks[1].stackSize == 0)
                            {
                                this.furnaceItemStacks[1] = furnaceItemStacks[1].getItem().getContainerItem(furnaceItemStacks[1]);
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canSmelt())
                {
                    ++this.furnaceCookTime;

                    if (this.furnaceCookTime == 200)
                    {
                        this.furnaceCookTime = 0;
                        this.smeltItem();
                        flag1 = true;
                    }
                }
                else
                {
                    this.furnaceCookTime = 0;
                }
            }

            if (flag != this.furnaceBurnTime > 0)
            {
                flag1 = true;
                BlockFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (flag1)
        {
            this.markDirty();
        }
    }

    @Override
    public String getInventoryName() {

        return this.hasCustomInventoryName() ? this.inventoryName : "container.atlasconvoy";

    }

    @Override
    public boolean hasCustomInventoryName() {

        return this.inventoryName != null && this.inventoryName.length() > 0;

    }

    public void func_145951_a(String name) {

        inventoryName = name;

    }

    @Override
    public int getInventoryStackLimit() {

        return 64;

    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {

        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;

    }

    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {}

    @Override
    public boolean isItemValidForSlot(int par1, ItemStack itemStack) {

        return par1 == 2 ? false : (par1 == 1 ? isItemFuel(itemStack) : true);

    }

    private boolean isItemFuel(ItemStack itemStack) {

        return getItemBurnTime(itemStack) > 0;

    }

    private boolean canSmelt() {

        if (atlasConvoyItemStacks[0] == null) {

            return false;

        } else {

            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(atlasConvoyItemStacks[0]);
            if (itemstack == null) return false;
            if (atlasConvoyItemStacks[2] == null) return true;
            if (!atlasConvoyItemStacks[2].isItemEqual(itemstack)) return false;
            int result = atlasConvoyItemStacks[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= atlasConvoyItemStacks[2].getMaxStackSize();

        }

    }


    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack itemstack = AtlasConvoyRecipes.smelting().getSmeltingResult(atlasConvoyItemStacks[0]);

            if (atlasConvoyItemStacks[2] == null)
            {
                atlasConvoyItemStacks[2] = itemstack.copy();
            }
            else if (atlasConvoyItemStacks[2].getItem() == itemstack.getItem())
            {
                this.atlasConvoyItemStacks[2].stackSize += itemstack.stackSize;
            }

            --atlasConvoyItemStacks[0].stackSize;

            if (atlasConvoyItemStacks[0].stackSize <= 0)
            {
                atlasConvoyItemStacks[0] = null;
            }
        }
    }

    private int getItemBurnTime(ItemStack itemStack) {

        if (itemStack == null) {

            return 0;

        } else {

            Item item = itemStack.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {

                Block block = Block.getBlockFromItem(item);

                if (block == ARBlocks.clorite) {

                    return 16000;

                }

            }

            if (item == ARItems.cloriteIngot) return 1600;

            return GameRegistry.getFuelValue(itemStack);

        }

    }

}
