package net.crowifick.atlasrise.utils.items;

import net.crowifick.atlasrise.utils.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

/**
 * User: Crowifick
 * Date: 8/1/14
 * Time: 10:46 PM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
public class ARSword extends ItemSword {

    public ARSword(ToolMaterial toolMaterial1, String name) {

        super(toolMaterial1);
        setUnlocalizedName(name);
        setTextureName(Reference.MODID + ":" + name);
        setCreativeTab(CreativeTabs.tabCombat);

    }

}
