package rtg.world.biome.realistic.flowercraft;

import net.minecraft.world.biome.Biome;

import rtg.api.util.Logger;
import rtg.util.ModCompat.Mods;
import rtg.world.biome.realistic.RealisticBiomeBase;


@SuppressWarnings("WeakerAccess")
public abstract class RealisticBiomeFCBase extends RealisticBiomeBase {

    public static RealisticBiomeBase fcPhantasia;

    public RealisticBiomeFCBase(Biome b, Biome riverbiome) {

        super(b, riverbiome);
    }

    @Override
    public int waterSurfaceLakeChance() {
        return 0;
    }

    public static void addBiomes() {

        if (Mods.flowercraftmod.isLoaded()) {

// TODO: 1.12 Clean up how these rBiomes are initialised. Migrate to looking up ResourceLocations in the registry.
            for (Biome biome : Biome.REGISTRY) {

                if (biome.getBiomeName().isEmpty()) {
                    Logger.warn("Biome ID %d has no name.", Biome.getIdForBiome(biome));
                    continue;
                }

                String biomeName = biome.getBiomeName();
                String biomeClass = biome.getBiomeClass().getName();

                if (biomeName.equals("Phantasia") && biomeClass.equals("flowercraftmod.world.biome.BiomeGenFCPhantasia")) {
                    fcPhantasia = new RealisticBiomeFCPhantasia(biome);
                }
            }
        }
    }
}
