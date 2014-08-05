package net.crowifick.atlasrise.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.crowifick.atlasrise.inventory.blocks.ContainerAtlasConvoy;
import net.crowifick.atlasrise.tiles.TileEntityAtlasConvoy;
import net.crowifick.atlasrise.utils.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * User: Crowifick
 * Date: 8/5/14
 * Time: 3:04 PM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
@SideOnly(Side.CLIENT)
public class GuiAtlasConvoy extends GuiContainer {

    private static final ResourceLocation atlasConvoyTexture = new ResourceLocation(Reference.MODID + ":textures/gui/AtlasConvoy.png");
    private TileEntityAtlasConvoy tileAtlasConvoy;

    public GuiAtlasConvoy(InventoryPlayer player, TileEntityAtlasConvoy tileEntityAtlasConvoy) {

        super(new ContainerAtlasConvoy(player, tileEntityAtlasConvoy));

        tileAtlasConvoy = tileEntityAtlasConvoy;

    }

    protected void drawGuiContainerForegroundLayer(int par1, int par2) {

        String s = tileAtlasConvoy.hasCustomInventoryName() ? tileAtlasConvoy.getInventoryName() : I18n.format(tileAtlasConvoy.getInventoryName(), new Object[0]);

        fontRendererObj.drawString(s, xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, ySize - 96 + 2, 4210752);

    }

    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        mc.getTextureManager().bindTexture(atlasConvoyTexture);

        int k = (width - xSize) / 2;
        int l = (height - ySize) / 2;

        drawTexturedModalRect(k, l, 0, 0, xSize, ySize);

        if (tileAtlasConvoy.isBurning()) {

            int il = tileAtlasConvoy.getBurnTimeRemainingScaled(13);
            drawTexturedModalRect(k + 56, l + 36 + 12 - il, 176, 12 - il, 14, il + l);

            il = tileAtlasConvoy.getCookProgressScaled(24);
            this.drawTexturedModalRect(k + 79, l + 34, 176, 14, il + 1, 16);

        }

    }

}
