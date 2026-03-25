package com.doctorwho.world.biome;

import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.SpawnSettings;
import com.doctorwho.DoctorWhoMod;

public class GallifreyBiomes {
    
    public static void registerAll() {
        DoctorWhoMod.LOGGER.info("Registering Gallifrey biomes");
    }
    
    public static SpawnSettings createGallifreySpawnSettings() {
        SpawnSettings.Builder builder = new SpawnSettings.Builder();
        
        builder.spawn(
                com.doctorwho.entity.ModEntities.DALEK.getSpawnGroup(),
                new SpawnSettings.SpawnEntry(
                        com.doctorwho.entity.ModEntities.DALEK,
                        10, 1, 3
                )
        );
        
        return builder.build();
    }
}
