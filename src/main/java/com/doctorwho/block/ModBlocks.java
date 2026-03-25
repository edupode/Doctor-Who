package com.doctorwho.block;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.doctorwho.DoctorWhoMod;

public class ModBlocks {
    
    public static final Block GALLIFREY_PORTAL = Registry.register(
            Registries.BLOCK,
            new Identifier(DoctorWhoMod.MOD_ID, "gallifrey_portal"),
            new GallifreyPortalBlock(Block.Settings.create().noCollision().nonOpaque())
    );
    
    public static final Block TARDIS = Registry.register(
            Registries.BLOCK,
            new Identifier(DoctorWhoMod.MOD_ID, "tardis"),
            new TardisBlock(Block.Settings.create().strength(3.0F, 3600000.0F).nonOpaque())
    );
    
    // Planetary Portal Blocks
    public static final Block SKARO_PORTAL = Registry.register(
            Registries.BLOCK,
            new Identifier(DoctorWhoMod.MOD_ID, "skaro_portal"),
            new PlanetaryPortalBlock(Block.Settings.create().noCollision().nonOpaque(), "skaro")
    );
    
    public static final Block CYBUS_PORTAL = Registry.register(
            Registries.BLOCK,
            new Identifier(DoctorWhoMod.MOD_ID, "cybus_portal"),
            new PlanetaryPortalBlock(Block.Settings.create().noCollision().nonOpaque(), "cybus")
    );
    
    public static final Block MONDAS_PORTAL = Registry.register(
            Registries.BLOCK,
            new Identifier(DoctorWhoMod.MOD_ID, "mondas_portal"),
            new PlanetaryPortalBlock(Block.Settings.create().noCollision().nonOpaque(), "mondas")
    );
    
    public static final Block CLOM_PORTAL = Registry.register(
            Registries.BLOCK,
            new Identifier(DoctorWhoMod.MOD_ID, "clom_portal"),
            new PlanetaryPortalBlock(Block.Settings.create().noCollision().nonOpaque(), "clom")
    );
    
    public static final Block RAVENOUS_PORTAL = Registry.register(
            Registries.BLOCK,
            new Identifier(DoctorWhoMod.MOD_ID, "ravenous_portal"),
            new PlanetaryPortalBlock(Block.Settings.create().noCollision().nonOpaque(), "ravenous")
    );
    
    public static final Block MIDNIGHT_PORTAL = Registry.register(
            Registries.BLOCK,
            new Identifier(DoctorWhoMod.MOD_ID, "midnight_portal"),
            new PlanetaryPortalBlock(Block.Settings.create().noCollision().nonOpaque(), "midnight")
    );
    
    public static final Block TRENZALORE_PORTAL = Registry.register(
            Registries.BLOCK,
            new Identifier(DoctorWhoMod.MOD_ID, "trenzalore_portal"),
            new PlanetaryPortalBlock(Block.Settings.create().noCollision().nonOpaque(), "trenzalore")
    );
    
    public static final Block OMEGA_PORTAL = Registry.register(
            Registries.BLOCK,
            new Identifier(DoctorWhoMod.MOD_ID, "omega_portal"),
            new PlanetaryPortalBlock(Block.Settings.create().noCollision().nonOpaque(), "omega")
    );

    public static void registerBlocks() {
        DoctorWhoMod.LOGGER.info("Registering blocks for " + DoctorWhoMod.MOD_ID);
    }
}
