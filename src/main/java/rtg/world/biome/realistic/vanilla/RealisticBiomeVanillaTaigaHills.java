package rtg.world.biome.realistic.vanilla;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

import rtg.api.biome.BiomeConfig;
import rtg.api.biome.vanilla.config.BiomeConfigVanillaTaigaHills;
import rtg.world.biome.deco.collection.DecoCollectionTaiga;
import rtg.world.gen.surface.vanilla.SurfaceVanillaTaigaHills;
import rtg.world.gen.terrain.vanilla.TerrainVanillaTaigaHills;

public class RealisticBiomeVanillaTaigaHills extends RealisticBiomeVanillaBase {

    public static IBlockState topBlock = BiomeGenBase.taigaHills.topBlock;
    public static IBlockState fillerBlock = BiomeGenBase.taigaHills.fillerBlock;

    public RealisticBiomeVanillaTaigaHills(BiomeConfig config) {

        super(config,
            BiomeGenBase.taigaHills,
            BiomeGenBase.river,
            new TerrainVanillaTaigaHills(),
            new SurfaceVanillaTaigaHills(config, Blocks.grass.getDefaultState(), Blocks.dirt.getDefaultState(), true, Blocks.gravel.getDefaultState(), 0.2f)
        );

        this.noLakes = true;

        this.addDecoCollection(new DecoCollectionTaiga(this.config._boolean(BiomeConfigVanillaTaigaHills.decorationLogsId), 10f));
    }
}
