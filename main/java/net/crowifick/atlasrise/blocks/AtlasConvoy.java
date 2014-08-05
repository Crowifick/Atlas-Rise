package net.crowifick.atlasrise.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.crowifick.atlasrise.AtlasRise;
import net.crowifick.atlasrise.tiles.TileEntityAtlasConvoy;
import net.crowifick.atlasrise.utils.GuiIDs;
import net.crowifick.atlasrise.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

/**
 * User: Crowifick
 * Date: 8/4/14
 * Time: 11:33 PM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
public class AtlasConvoy extends BlockContainer {

    private static String name = "AtlasConvoy";

    public static boolean isActive;
    public static final boolean canKeepInventory = false;

    private final Random random = new Random();

    public AtlasConvoy(boolean active) {

        super(Material.iron);
        isActive = active;
        setBlockName(name);
        setBlockTextureName(Reference.MODID + ":" + name);

    }

    public Item getItemDropped(int par1, Random random, int par2) {

        return Item.getItemFromBlock(ARBlocks.atlasConvoyInActive);

    }

    public void onBlockAdded(World world, int x, int y, int z) {

        super.onBlockAdded(world, x, y, z);

        this.setDefaultDirection(world, x, y, z);

    }

    private void setDefaultDirection(World world, int x, int y, int z) {

        if (!world.isRemote) {

            Block block = world.getBlock(x, y, z - 1);
            Block block1 = world.getBlock(x, y, z + 1);
            Block block2 = world.getBlock(x - 1, y, z);
            Block block3 = world.getBlock(x + 1, y, z);
            byte b0 = 3;

            if (block.func_149730_j() && !block1.func_149730_j()) {

                b0 = 3;

            }

            if (block1.func_149730_j() && !block.func_149730_j()) {

                b0 = 2;

            }

            if (block2.func_149730_j() && !block3.func_149730_j()) {

                b0 = 5;

            }

            if (block3.func_149730_j() && !block2.func_149730_j()) {

                b0 = 4;

            }

            world.setBlockMetadataWithNotify(x, y, z, b0, 2);

        }

    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float j, float k, float h)
    {

        if (world.isRemote) {

            return true;

        } else {

            TileEntityAtlasConvoy tileEntityAtlasConvoy = (TileEntityAtlasConvoy)world.getTileEntity(x, y, z);

            if (tileEntityAtlasConvoy != null) {

                player.openGui(AtlasRise.instance, GuiIDs.atlasConvoy, world, x, y, z);

            }

            return true;

        }

    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack)
    {
        int l = MathHelper.floor_double((double) (entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (l == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (l == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (l == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }

        if (itemStack.hasDisplayName())
        {
            ((TileEntityAtlasConvoy)world.getTileEntity(x, y, z)).func_145951_a(itemStack.getDisplayName());
        }
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int j)
    {
        if (!canKeepInventory)
        {
            TileEntityAtlasConvoy tileEntityAtlasConvoy = (TileEntityAtlasConvoy)world.getTileEntity(x, y, z);

            if (tileEntityAtlasConvoy != null)
            {
                for (int i1 = 0; i1 < tileEntityAtlasConvoy.getSizeInventory(); ++i1)
                {
                    ItemStack itemstack = tileEntityAtlasConvoy.getStackInSlot(i1);

                    if (itemstack != null)
                    {
                        float f = this.random.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.random.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.random.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0)
                        {
                            int j1 = this.random.nextInt(21) + 10;

                            if (j1 > itemstack.stackSize)
                            {
                                j1 = itemstack.stackSize;
                            }

                            itemstack.stackSize -= j1;
                            EntityItem entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound())
                            {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float f3 = 0.05F;
                            entityitem.motionX = (double)((float)this.random.nextGaussian() * f3);
                            entityitem.motionY = (double)((float)this.random.nextGaussian() * f3 + 0.2F);
                            entityitem.motionZ = (double)((float)this.random.nextGaussian() * f3);
                            world.spawnEntityInWorld(entityitem);
                        }
                    }
                }

                world.func_147453_f(x, y, z, block);
            }
        }

        super.breakBlock(world, x, y, z, block, j);
    }

    public boolean hasComparatorInputOverride() {

        return true;

    }

    public int getComparatorInputOverride(World world, int x, int y, int z, int j) {

        return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(x, y, z));

    }

    @Override
    public TileEntity createNewTileEntity(World world, int par1) {

        return new TileEntityAtlasConvoy();

    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z) {

        return Item.getItemFromBlock(ARBlocks.atlasConvoyInActive);

    }

}