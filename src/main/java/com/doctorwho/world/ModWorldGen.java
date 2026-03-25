package com.doctorwho.world;

import com.doctorwho.DoctorWhoMod;
import com.doctorwho.world.biome.GallifreyBiomes;
import com.doctorwho.world.biome.PlanetBiomes;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;
import com.doctorwho.entity.ModEntities;

public class ModWorldGen {
    
    // Biome Tags
    public static final TagKey<Biome> HAS_GALLIFREY_PORTAL = TagKey.of(RegistryKeys.BIOME,
            new Identifier(DoctorWhoMod.MOD_ID, "has_structure/gallifrey_portal"));
    public static final TagKey<Biome> DALEK_SPAWNS = TagKey.of(RegistryKeys.BIOME,
            new Identifier(DoctorWhoMod.MOD_ID, "has_mob/dalek_spawns"));
    public static final TagKey<Biome> CYBERMAN_SPAWNS = TagKey.of(RegistryKeys.BIOME,
            new Identifier(DoctorWhoMod.MOD_ID, "has_mob/cyberman_spawns"));
    public static final TagKey<Biome> ANGEL_SPAWNS = TagKey.of(RegistryKeys.BIOME,
            new Identifier(DoctorWhoMod.MOD_ID, "has_mob/angel_spawns"));
    public static final TagKey<Biome> SONTARAN_SPAWNS = TagKey.of(RegistryKeys.BIOME,
            new Identifier(DoctorWhoMod.MOD_ID, "has_mob/sontaran_spawns"));
    
    public static void registerDimensions() {
        ModDimensions.register();
        registerDimensionSettings();
    }

    private static void registerDimensionSettings() {
        DoctorWhoMod.LOGGER.info("Setting up all Doctor Who dimensions");
    }

    public static void registerBiomes() {
        GallifreyBiomes.registerAll();
        PlanetBiomes.registerAll();
    }

    public static void registerMobSpawns() {
        // Dalek spawns
        BiomeModifications.create(new Identifier(DoctorWhoMod.MOD_ID, "dalek_spawns"))
                .add(ModificationPhase.ADDITIONS,
                        biomeSelectionContext -> biomeSelectionContext.hasTag(DALEK_SPAWNS),
                        biomeModificationContext -> {
                            biomeModificationContext.getSpawnSettings()
                                    .addSpawn(
                                            ModEntities.DALEK.getSpawnGroup(),
                                            new SpawnSettings.SpawnEntry(
                                                    ModEntities.DALEK,
                                                    10, 1, 3
                                            )
                                    );
                        });
        
        // Cyberman spawns
        BiomeModifications.create(new Identifier(DoctorWhoMod.MOD_ID, "cyberman_spawns"))
                .add(ModificationPhase.ADDITIONS,
                        biomeSelectionContext -> biomeSelectionContext.hasTag(CYBERMAN_SPAWNS),
                        biomeModificationContext -> {
                            biomeModificationContext.getSpawnSettings()
                                    .addSpawn(
                                            ModEntities.CYBERMAN.getSpawnGroup(),
                                            new SpawnSettings.SpawnEntry(
                                                    ModEntities.CYBERMAN,
                                                    8, 1, 2
                                            )
                                    );
                        });
        
        // Weeping Angel spawns (rare)
        BiomeModifications.create(new Identifier(DoctorWhoMod.MOD_ID, "angel_spawns"))
                .add(ModificationPhase.ADDITIONS,
                        biomeSelectionContext -> biomeSelectionContext.hasTag(ANGEL_SPAWNS),
                        biomeModificationContext -> {
                            biomeModificationContext.getSpawnSettings()
                                    .addSpawn(
                                            ModEntities.WEEPING_ANGEL.getSpawnGroup(),
                                            new SpawnSettings.SpawnEntry(
                                                    ModEntities.WEEPING_ANGEL,
                                                    3, 1, 1
                                            )
                                    );
                        });
        
        // Sontaran spawns
        BiomeModifications.create(new Identifier(DoctorWhoMod.MOD_ID, "sontaran_spawns"))
                .add(ModificationPhase.ADDITIONS,
                        biomeSelectionContext -> biomeSelectionContext.hasTag(SONTARAN_SPAWNS),
                        biomeModificationContext -> {
                            biomeModificationContext.getSpawnSettings()
                                    .addSpawn(
                                            ModEntities.SONTARAN.getSpawnGroup(),
                                            new SpawnSettings.SpawnEntry(
                                                    ModEntities.SONTARAN,
                                                    5, 1, 2
                                            )
                                    );
                        });
    }
}
