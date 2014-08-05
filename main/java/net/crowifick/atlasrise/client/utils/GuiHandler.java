package net.crowifick.atlasrise.client.utils;

import cpw.mods.fml.common.network.IGuiHandler;
import net.crowifick.atlasrise.client.gui.GuiAtlasConvoy;
import net.crowifick.atlasrise.inventory.blocks.ContainerAtlasConvoy;
import net.crowifick.atlasrise.tiles.TileEntityAtlasConvoy;
import net.crowifick.atlasrise.utils.GuiIDs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * User: Crowifick
 * Date: 8/5/14
 * Time: 3:24 PM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
public class GuiHandler implements IGuiHandler {

    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity tileEntity = world.getTileEntity(x, y, z);

        if (tileEntity != null) {

            switch(ID) {

                case GuiIDs.atlasConvoy : return new ContainerAtlasConvoy(player.inventory, ((TileEntityAtlasConvoy)tileEntity));

            }

        }

        return null;

    }

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity tileEntity = world.getTileEntity(x, y, z);

        if (tileEntity != null) {

            switch(ID) {

                case GuiIDs.atlasConvoy : return new GuiAtlasConvoy(player.inventory, ((TileEntityAtlasConvoy)tileEntity));

            }

        }

        return null;

    }

}
