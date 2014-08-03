package net.crowifick.atlasrise.utils.items;

import net.crowifick.atlasrise.utils.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

/**
 * User: Crowifick
 * Date: 8/3/14
 * Time: 2:32 AM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
public class ARShovel extends ItemSpade {

    public ARShovel(ToolMaterial toolMaterial1, String name) {

        super(toolMaterial1);
        setUnlocalizedName(name);
        setTextureName(Reference.MODID + ":" + name);
        setCreativeTab(CreativeTabs.tabTools);

    }


}
