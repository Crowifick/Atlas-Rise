package net.crowifick.atlasrise.utils.items;

import net.crowifick.atlasrise.utils.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * User: Crowifick
 * Date: 8/1/14
 * Time: 12:41 PM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
public class ARItem extends Item {

    public ARItem(String name, int maxStack, CreativeTabs tab) {

        setUnlocalizedName(name);
        setTextureName(Reference.MODID + ":" + name);
        setMaxStackSize(maxStack);
        setCreativeTab(tab);

    }

}
