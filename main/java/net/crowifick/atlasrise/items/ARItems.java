package net.crowifick.atlasrise.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crowifick.atlasrise.inventory.creativetabs.ARCreativeTabs;
import net.crowifick.atlasrise.utils.Reference;
import net.crowifick.atlasrise.utils.items.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

/**
 * User: Crowifick
 * Date: 8/1/14
 * Time: 11:36 AM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
@GameRegistry.ObjectHolder(Reference.MODID)
public class ARItems {

    public static Item.ToolMaterial clorite = EnumHelper.addToolMaterial("Clorite", 4, 500, 10.0F, 6.0F, 15);
    public static ItemArmor.ArmorMaterial cloriteArmor = EnumHelper.addArmorMaterial("Clorite", 43, new int[]{5, 10, 8, 6}, 12);

    //Tier 0
    public static ARItem cloriteIngot = new ARItem("CloriteIngot", 64, ARCreativeTabs.arItems);
    public static ARItem cloritePlate = new ARItem("CloritePlate", 64, ARCreativeTabs.arItems);
    public static ARItem cloritePickaxeHead = new ARItem("CloritePickaxeHead", 1, ARCreativeTabs.arItems);
    public static ARItem cloriteSwordHead = new ARItem("CloriteSwordHead", 1, ARCreativeTabs.arItems);
    public static ARItem cloriteAxeHead = new ARItem("CloriteAxeHead", 1, ARCreativeTabs.arItems);
    public static ARItem cloriteShovelHead = new ARItem("CloriteShovelHead", 1, ARCreativeTabs.arItems);
    public static ARItem cloriteHoeHead = new ARItem("CloriteHoeHead", 1, ARCreativeTabs.arItems);
    public static ARPickaxe cloritePickaxe = new ARPickaxe(clorite, "CloritePickaxe");
    public static ARSword cloriteSword = new ARSword(clorite, "CloriteSword");
    public static ARAxe cloriteAxe = new ARAxe(clorite, "CloriteAxe");
    public static ARShovel cloriteShovel = new ARShovel(clorite, "CloriteShovel");
    public static ARHoe cloriteHoe = new ARHoe(clorite, "CloriteHoe");
    public static ArmorClorite cloriteHelmet = new ArmorClorite(cloriteArmor, 0, 0, "CloriteHelmet");
    public static ArmorClorite cloriteChestPlate = new ArmorClorite(cloriteArmor, 0, 1, "CloriteChestPlate");
    public static ArmorClorite cloriteLeggings = new ArmorClorite(cloriteArmor, 0, 2, "CloriteLeggings");
    public static ArmorClorite cloriteBoots = new ArmorClorite(cloriteArmor, 0, 3, "CloriteBoots");

    //Tier 1

    public static ARItem ianOrb = new ARItem("IanOrb", 1, ARCreativeTabs.arItems);
    public static ARItem staggeredRock = new ARItem("StaggeredRock", 16, ARCreativeTabs.arItems);
    public static ARItem unifiedRock = new ARItem("UnifiedRock", 16, ARCreativeTabs.arItems);
    public static ARItem phenomRock = new ARItem("PhenomRock", 16, ARCreativeTabs.arItems);
    public static ARItem anchientRelicOfDawn = new ARItem("AnchientRelicOfDawn", 1, ARCreativeTabs.arItems);
    public static ARItem sandDonf = new ARItem("SandDonf", 64, ARCreativeTabs.arItems);
    public static ARItem redFireString = new ARItem("RedFireString", 64, ARCreativeTabs.arItems);

    public static ARItem redFireFabric = new ARItem("RedFireFabric", 64, ARCreativeTabs.arItems);

    public static ARItem insonum = new ARItem("Insonum", 64, ARCreativeTabs.arItems);

    public static ARItem ghesumDust = new ARItem("GhesumDust", 64, ARCreativeTabs.arItems);

    public static ARItem redocoleMix = new ARItem("RedocoleMix", 64, ARCreativeTabs.arItems);
    public static ARItem redocolePlate = new ARItem("RedocolePlate", 64, ARCreativeTabs.arItems);
    public static ARItem redocoleIngot = new ARItem("RedocoleIngot", 64, ARCreativeTabs.arItems);
    //TODO add redocole Armor and tools

    public static ARItem colaxMix = new ARItem("ColaxMix", 64, ARCreativeTabs.arItems);
    public static ARItem colax = new ARItem("Colax", 64, ARCreativeTabs.arItems);
    public static ARItem infusedColax = new ARItem("InfusedColax", 64, ARCreativeTabs.arItems);
    public static ARItem heatedInfusedColax = new ARItem("HeatedInfuedColax", 64, ARCreativeTabs.arItems);

    public static ARItem lascriteMix = new ARItem("LascriteMix", 64, ARCreativeTabs.arItems);



    public static void init() {

        GameRegistry.registerItem(cloriteIngot, "CloriteIngot");
        GameRegistry.registerItem(cloritePlate, "CloritePlate");
        GameRegistry.registerItem(cloritePickaxeHead, "CloritePickaxeHead");
        GameRegistry.registerItem(cloriteSwordHead, "CloriteSwordHead");
        GameRegistry.registerItem(cloriteAxeHead, "CloriteAxeHead");
        GameRegistry.registerItem(cloriteShovelHead, "CloriteShovelHead");
        GameRegistry.registerItem(cloriteHoeHead, "CloriteHoeHead");
        GameRegistry.registerItem(cloritePickaxe, "CloritePickaxe");
        GameRegistry.registerItem(cloriteSword, "CloriteSword");
        GameRegistry.registerItem(cloriteAxe, "CloriteAxe");
        GameRegistry.registerItem(cloriteShovel, "CloriteShovel");
        GameRegistry.registerItem(cloriteHoe, "CloriteHoe");
        GameRegistry.registerItem(cloriteHelmet, "CloriteHelmet");
        GameRegistry.registerItem(cloriteChestPlate, "CloriteChestPlate");
        GameRegistry.registerItem(cloriteLeggings, "CloriteLeggings");
        GameRegistry.registerItem(cloriteBoots, "CloriteBoots");

        GameRegistry.registerItem(ianOrb, "IanOrb");
        GameRegistry.registerItem(staggeredRock, "StaggeredRock");
        GameRegistry.registerItem(unifiedRock, "UnifiedRock");
        GameRegistry.registerItem(phenomRock, "PhenomRock");
        GameRegistry.registerItem(anchientRelicOfDawn, "AnchientRelicOfDawn");
        GameRegistry.registerItem(sandDonf, "SandDonf");
        GameRegistry.registerItem(redFireString, "RedFireString");

        GameRegistry.registerItem(redFireFabric, "RedFireFabric");

        GameRegistry.registerItem(insonum, "Insonum");

        GameRegistry.registerItem(ghesumDust, "GhesumDust");

        GameRegistry.registerItem(redocoleMix, "RedocoleMix");
        GameRegistry.registerItem(redocolePlate, "RedocolePlate");
        GameRegistry.registerItem(redocoleIngot, "RedocoleIngot");

        GameRegistry.registerItem(colaxMix, "ColaxMix");
        GameRegistry.registerItem(colax, "Colax");
        GameRegistry.registerItem(infusedColax, "InfusedColax");
        GameRegistry.registerItem(heatedInfusedColax, "HeatedInfusedColax");

        GameRegistry.registerItem(lascriteMix, "LascriteMix");

    }

}
