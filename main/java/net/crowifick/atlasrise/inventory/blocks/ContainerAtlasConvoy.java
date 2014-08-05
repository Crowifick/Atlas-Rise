package net.crowifick.atlasrise.inventory.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.crowifick.atlasrise.inventory.slots.SlotAtlasConvoy;
import net.crowifick.atlasrise.recipes.AtlasConvoyRecipes;
import net.crowifick.atlasrise.tiles.TileEntityAtlasConvoy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * User: Crowifick
 * Date: 8/5/14
 * Time: 1:59 PM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
public class ContainerAtlasConvoy extends Container {

    private TileEntityAtlasConvoy tileAtlasConvoy;

    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;

    public ContainerAtlasConvoy(InventoryPlayer inventory, TileEntityAtlasConvoy tileEntityAtlasConvoy) {

        tileAtlasConvoy = tileEntityAtlasConvoy;

        addSlotToContainer(new Slot(tileEntityAtlasConvoy, 0, 56, 17));
        addSlotToContainer(new Slot(tileEntityAtlasConvoy, 1, 56, 53));
        addSlotToContainer(new SlotAtlasConvoy(inventory.player, tileEntityAtlasConvoy, 2, 116, 35));

        int i;

        for (i = 0; i < 3; ++i)
            for (int j = 0; j < 9; ++j)
                addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 83 + i * 18));

        for (i = 0; i < 9; ++i)
            addSlotToContainer(new Slot(inventory, i, 8 + i * 16, 142));

    }

    public void addCraftingToCrafters(ICrafting crafter) {

        super.addCraftingToCrafters(crafter);

        crafter.sendProgressBarUpdate(this, 0, this.tileAtlasConvoy.atlasConvoyCookTime);
        crafter.sendProgressBarUpdate(this, 1, this.tileAtlasConvoy.atlasConvoyBurnTime);
        crafter.sendProgressBarUpdate(this, 2, this.tileAtlasConvoy.currentItemBurnTime);

    }

    public void detectAndSendChanges() {

        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i) {

            ICrafting iCrafting = (ICrafting)this.crafters.get(i);

            if (lastCookTime != tileAtlasConvoy.atlasConvoyCookTime)
                iCrafting.sendProgressBarUpdate(this, 0, tileAtlasConvoy.atlasConvoyCookTime);

            if (lastBurnTime != tileAtlasConvoy.atlasConvoyBurnTime)
                iCrafting.sendProgressBarUpdate(this, 1, tileAtlasConvoy.atlasConvoyBurnTime);

            if (lastItemBurnTime != tileAtlasConvoy.currentItemBurnTime)
                iCrafting.sendProgressBarUpdate(this, 2, tileAtlasConvoy.currentItemBurnTime);

            lastCookTime = tileAtlasConvoy.atlasConvoyCookTime;
            lastBurnTime = tileAtlasConvoy.atlasConvoyBurnTime;
            lastItemBurnTime = tileAtlasConvoy.currentItemBurnTime;

        }

    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2) {

        if (par1 == 0)
            tileAtlasConvoy.atlasConvoyCookTime = par2;

        if (par1 == 1)
            tileAtlasConvoy.atlasConvoyBurnTime = par2;

        if (par1 == 2)
            tileAtlasConvoy.currentItemBurnTime = par2;

    }

    public boolean canInteractWith(EntityPlayer player) {

        return  tileAtlasConvoy.isUseableByPlayer(player);

    }

    public ItemStack transferStackInSlot(EntityPlayer player, int par2) {

        ItemStack itemStack = null;

        Slot slot = (Slot)inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()) {

            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            if (par2 == 2)
                if (!mergeItemStack(itemStack1, 3, 39, true))
                    return  null;

            else if (par2 != 1 && par2 != 0)
                    if (AtlasConvoyRecipes.smelting().getSmeltingResult(itemStack1) != null)
                        if (!mergeItemStack(itemStack1, 0, 1, false))
                            return  null;
            else if (TileEntityAtlasConvoy.isItemFuel(itemStack1))
                            if (!mergeItemStack(itemStack1, 1, 2, false))
                                return null;
            else if (par2 >= 3 && par2 < 30)
                                if (!mergeItemStack(itemStack1, 30, 39, false))
                                    return null;
            else if (par2 >= 30 && par2 < 39 && mergeItemStack(itemStack1, 3, 30, false))
                                    return  null;
            else if (mergeItemStack(itemStack1, 3, 39, false))
                                    return null;

            if (itemStack1.stackSize == 0)
                slot.putStack((ItemStack)null);
            else
                slot.onSlotChanged();

            if (itemStack1.stackSize == itemStack.stackSize)
                return null;

            slot.onPickupFromSlot(player, itemStack1);

        }

        return itemStack;

    }

}
