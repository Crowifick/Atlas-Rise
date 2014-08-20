package net.crowifick.atlasrise.utils.items;

import net.crowifick.atlasrise.inventory.creativetabs.ARCreativeTabs;
import net.crowifick.atlasrise.utils.Reference;
import net.minecraft.item.ItemAxe;

/**
 * User: Crowifick
 * Date: 8/3/14
 * Time: 2:32 AM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
public class ARAxe extends ItemAxe {

    public ARAxe(ToolMaterial toolMaterial1, String name) {

        super(toolMaterial1);
        setUnlocalizedName(name);
        setTextureName(Reference.MODID + ":" + name);
        setCreativeTab(ARCreativeTabs.arTools);

    }

}
