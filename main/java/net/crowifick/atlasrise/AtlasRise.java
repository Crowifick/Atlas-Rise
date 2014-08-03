package net.crowifick.atlasrise;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.crowifick.atlasrise.blocks.ARBlocks;
import net.crowifick.atlasrise.entitys.AREntitys;
import net.crowifick.atlasrise.items.ARItems;
import net.crowifick.atlasrise.proxys.CommonProxy;
import net.crowifick.atlasrise.recipes.ARRecipes;
import net.crowifick.atlasrise.utils.Reference;
import net.crowifick.atlasrise.world.ARWorlds;

/**
 * User: Crowifick
 * Date: 7/31/14
 * Time: 10:38 PM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
@Mod(name = Reference.NAME, modid = Reference.MODID, version = Reference.VERSION)
public class AtlasRise {

    @Mod.Instance(Reference.MODID)
    public static AtlasRise instance;

    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {

        ARBlocks.init();
        ARItems.init();
        AREntitys.init();
        ARRecipes.init();
        ARWorlds.init();

    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {



    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {



    }

}
