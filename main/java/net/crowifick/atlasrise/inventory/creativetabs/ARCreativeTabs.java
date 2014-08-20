package net.crowifick.atlasrise.inventory.creativetabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.crowifick.atlasrise.blocks.ARBlocks;
import net.crowifick.atlasrise.items.ARItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * User: Crowifick
 * Date: 8/19/14
 * Time: 6:43 PM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
public class ARCreativeTabs {

    public static CreativeTabs arItems = new CreativeTabs("arItems") {

        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {

            return ARItems.cloriteIngot;

        }

    };

    public static CreativeTabs arBlocks = new CreativeTabs("arBlocks") {

        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {

            return Item.getItemFromBlock(ARBlocks.cloriteOre);

        }

    };

    public static CreativeTabs arTools = new CreativeTabs("arTools") {

        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {

            return ARItems.cloritePickaxe;

        }

    };

    public static CreativeTabs arArmor = new CreativeTabs("arArmor") {

        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {

            return ARItems.cloriteHelmet;

        }

    };

}
