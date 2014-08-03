package net.crowifick.atlasrise.world;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crowifick.atlasrise.world.gen.AROreGen;

/**
 * User: Crowifick
 * Date: 8/1/14
 * Time: 2:34 PM
 * This mod is open source but do not come to me with problems
 * on how *insert code here* won't work on your side.
 */
public class ARWorlds {

    public static void init() {

        GameRegistry.registerWorldGenerator(new AROreGen(), 2);

    }

}
