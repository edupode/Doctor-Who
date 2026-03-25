package com.doctorwho.world;

import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import com.doctorwho.DoctorWhoMod;

public class ModDimensions {

    // Gallifrey - Home planet of the Time Lords
    public static final RegistryKey<World> GALLIFREY_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(DoctorWhoMod.MOD_ID, "gallifrey"));
    public static final RegistryKey<DimensionOptions> GALLIFREY_DIMENSION_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(DoctorWhoMod.MOD_ID, "gallifrey"));
    public static final RegistryKey<DimensionType> GALLIFREY_DIMENSION_TYPE_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(DoctorWhoMod.MOD_ID, "gallifrey"));
    
    // Skaro - Home planet of the Daleks
    public static final RegistryKey<World> SKARO_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(DoctorWhoMod.MOD_ID, "skaro"));
    public static final RegistryKey<DimensionOptions> SKARO_DIMENSION_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(DoctorWhoMod.MOD_ID, "skaro"));
    public static final RegistryKey<DimensionType> SKARO_DIMENSION_TYPE_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(DoctorWhoMod.MOD_ID, "skaro"));
    
    // Cybus - Home planet of the Cybermen (parallel Earth)
    public static final RegistryKey<World> CYBUS_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(DoctorWhoMod.MOD_ID, "cybus"));
    public static final RegistryKey<DimensionOptions> CYBUS_DIMENSION_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(DoctorWhoMod.MOD_ID, "cybus"));
    public static final RegistryKey<DimensionType> CYBUS_DIMENSION_TYPE_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(DoctorWhoMod.MOD_ID, "cybus"));
    
    // Mondas - Cybermen origin planet
    public static final RegistryKey<World> MONDAS_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(DoctorWhoMod.MOD_ID, "mondas"));
    public static final RegistryKey<DimensionOptions> MONDAS_DIMENSION_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(DoctorWhoMod.MOD_ID, "mondas"));
    public static final RegistryKey<DimensionType> MONDAS_DIMENSION_TYPE_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(DoctorWhoMod.MOD_ID, "mondas"));
    
    // Clom - Planet of the Clom
    public static final RegistryKey<World> CLOM_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(DoctorWhoMod.MOD_ID, "clom"));
    public static final RegistryKey<DimensionOptions> CLOM_DIMENSION_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(DoctorWhoMod.MOD_ID, "clom"));
    public static final RegistryKey<DimensionType> CLOM_DIMENSION_TYPE_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(DoctorWhoMod.MOD_ID, "clom"));
    
    // Ravenous - Planet of the Ravenous
    public static final RegistryKey<World> RAVENOUS_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(DoctorWhoMod.MOD_ID, "ravenous"));
    public static final RegistryKey<DimensionOptions> RAVENOUS_DIMENSION_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(DoctorWhoMod.MOD_ID, "ravenous"));
    public static final RegistryKey<DimensionType> RAVENOUS_DIMENSION_TYPE_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(DoctorWhoMod.MOD_ID, "ravenous"));
    
    // Midnight - Leisure planet
    public static final RegistryKey<World> MIDNIGHT_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(DoctorWhoMod.MOD_ID, "midnight"));
    public static final RegistryKey<DimensionOptions> MIDNIGHT_DIMENSION_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(DoctorWhoMod.MOD_ID, "midnight"));
    public static final RegistryKey<DimensionType> MIDNIGHT_DIMENSION_TYPE_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(DoctorWhoMod.MOD_ID, "midnight"));
    
    // Trenzalore - The Doctor's tomb
    public static final RegistryKey<World> TRENZALORE_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(DoctorWhoMod.MOD_ID, "trenzalore"));
    public static final RegistryKey<DimensionOptions> TRENZALORE_DIMENSION_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(DoctorWhoMod.MOD_ID, "trenzalore"));
    public static final RegistryKey<DimensionType> TRENZALORE_DIMENSION_TYPE_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(DoctorWhoMod.MOD_ID, "trenzalore"));
    
    // Omega's Domain - The volcanic realm of Omega
    public static final RegistryKey<World> OMEGA_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(DoctorWhoMod.MOD_ID, "omega"));
    public static final RegistryKey<DimensionOptions> OMEGA_DIMENSION_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(DoctorWhoMod.MOD_ID, "omega"));
    public static final RegistryKey<DimensionType> OMEGA_DIMENSION_TYPE_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(DoctorWhoMod.MOD_ID, "omega"));

    public static void register() {
        DoctorWhoMod.LOGGER.info("Registering all Doctor Who dimensions");
    }
}
