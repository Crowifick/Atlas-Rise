package net.crowifick.atlasrise.utils.items;

import net.crowifick.atlasrise.items.ARItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * User: Crowifick
 * Date: 8/3/14
 * Time: 7:04 PM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
public class ARArmor extends ItemArmor {

    public ARArmor(ArmorMaterial material, int armorType, int renderIndex, String name, Item item) {

        super(material, armorType, renderIndex);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTabs.tabCombat);

    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {

        if ((stack.getItem()  == ARItems.cloriteHelmet) || (stack.getItem()  == ARItems.cloriteChestPlate) || (stack.getItem()  == ARItems.cloriteBoots)) {
            return "SoMuchArmor:textures/models/armor/WoodenArmor_1.png";
        }
        if (stack.getItem() == ARItems.cloriteLeggings) {
            return "SoMuchArmor:textures/models/armor/WoodenArmor_2.png";
        }
        return null;

    }

}
