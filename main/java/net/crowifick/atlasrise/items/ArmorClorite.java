package net.crowifick.atlasrise.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.crowifick.atlasrise.utils.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * User: Crowifick
 * Date: 8/3/14
 * Time: 7:04 PM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
public class ArmorClorite extends ItemArmor {

    private String iconNames;

    public ArmorClorite(ArmorMaterial material, int armorType, int renderIndex, String name) {

        super(material, armorType, renderIndex);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTabs.tabCombat);
        iconNames = name;

    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {

        if ((stack.getItem()  == ARItems.cloriteHelmet) || (stack.getItem()  == ARItems.cloriteChestPlate) || (stack.getItem()  == ARItems.cloriteBoots)) {

            return Reference.MODID + ":textures/models/armor/CloriteArmor_1.png";

        }

        if (stack.getItem() == ARItems.cloriteLeggings) {

            return Reference.MODID + ":textures/models/armor/CloriteArmor_2.png";
        }

        return null;

    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister icon) {

        this.itemIcon = icon.registerIcon(Reference.MODID + ":" + iconNames);

    }

}
