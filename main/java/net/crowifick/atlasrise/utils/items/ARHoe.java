package net.crowifick.atlasrise.utils.items;

import net.crowifick.atlasrise.utils.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;

/**
 * User: Crowifick
 * Date: 8/3/14
 * Time: 2:33 AM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
public class ARHoe extends ItemHoe {

    public ARHoe(Item.ToolMaterial toolMaterial1, String name) {

        super(toolMaterial1);
        setUnlocalizedName(name);
        setTextureName(Reference.MODID + ":" + name);
        setCreativeTab(CreativeTabs.tabTools);

    }


}
