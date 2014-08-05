package net.crowifick.atlasrise.inventory.slots;

import cpw.mods.fml.common.FMLCommonHandler;
import net.crowifick.atlasrise.recipes.AtlasConvoyRecipes;
import net.crowifick.atlasrise.tiles.TileEntityAtlasConvoy;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

/**
 * User: Crowifick
 * Date: 8/5/14
 * Time: 2:05 PM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
public class SlotAtlasConvoy extends Slot {

    private  EntityPlayer thePlayer;
    private int idk;

    public SlotAtlasConvoy(EntityPlayer player, TileEntityAtlasConvoy tileEntityAtlasConvoy, int i, int i1, int i2) {

        super(tileEntityAtlasConvoy, i, i1, i2);

        thePlayer = player;

    }

    public boolean isItemValid(ItemStack itemStack) {

        return false;

    }

    public ItemStack decrStackSize(int par1) {

        if (getHasStack())
            idk += Math.min(par1, getStack().stackSize);

        return super.decrStackSize(par1);

    }

    public void onPickupFromSlot(EntityPlayer player, ItemStack itemStack) {

        onCrafting(itemStack);
        onPickupFromSlot(player, itemStack);

    }

    protected void onCrafting(ItemStack itemStack, int par2) {

        idk += par2;
        onCrafting(itemStack);

    }

    protected void onCrafting(ItemStack itemStack) {

        itemStack.onCrafting(thePlayer.worldObj, thePlayer, idk);

        if (!thePlayer.worldObj.isRemote) {

            int i = idk;
            int j;

            float a = AtlasConvoyRecipes.smelting().func_151398_b(itemStack);

            if (a == 0.0F)
                i = 0;
            else if (a < 1.0F) {

                j = MathHelper.floor_float((float)i * a);

                if (j < MathHelper.ceiling_float_int((float)i * a) && (float)Math.random() < (float)i * a - (float)j)
                    ++j;

                i = j;

            }

            while (i > 0) {

                j = EntityXPOrb.getXPSplit(i);
                i -= j;
                thePlayer.worldObj.spawnEntityInWorld(new EntityXPOrb(thePlayer.worldObj, thePlayer.posX, thePlayer.posY + 0.5D, thePlayer.posZ + 0.5D, j));

            }

        }

        idk = 0;

        FMLCommonHandler.instance().firePlayerSmeltedEvent(thePlayer, itemStack);

    }

}
