package com.doctorwho;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import com.doctorwho.block.ModBlocks;
import com.doctorwho.entity.CybermanEntity;
import com.doctorwho.entity.DalekEntity;
import com.doctorwho.entity.ModEntities;
import com.doctorwho.entity.SontaranEntity;
import com.doctorwho.entity.TimeLordEntity;
import com.doctorwho.entity.WeepingAngelEntity;
import com.doctorwho.item.ModItems;
import com.doctorwho.world.ModWorldGen;
import com.doctorwho.world.loot.ModLootTables;

public final class DoctorWhoMod implements ModInitializer {
    public static final String MOD_ID = "doctorwho";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing {} v{}", MOD_ID, DoctorWhoMod.class.getPackage().getImplementationVersion());

        // Register dimension
        ModWorldGen.registerDimensions();

        // Register biomes
        ModWorldGen.registerBiomes();

        // Register blocks
        ModBlocks.registerBlocks();
        
        // Register items
        ModItems.registerItems();

        // Register entities
        ModEntities.registerEntities();
        
        // Register entity attributes
        FabricDefaultAttributeRegistry.register(ModEntities.DALEK, DalekEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.CYBERMAN, CybermanEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.WEEPING_ANGEL, WeepingAngelEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.SONTARAN, SontaranEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.TIME_LORD, TimeLordEntity.createMobAttributes());

        // Register loot tables
        ModLootTables.registerLootTables();

        // Register spawns
        ModWorldGen.registerMobSpawns();

        // Register commands
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("doctorwho")
                    .executes(ctx -> {
                        ctx.getSource().sendFeedback(() -> Text.literal("Exterminate! The Doctor Who mod is running!"), false);
                        return 1;
                    }));
            
            dispatcher.register(CommandManager.literal("goto_gallifrey")
                    .executes(ctx -> {
                        ctx.getSource().sendFeedback(() -> Text.literal("Use a Gallifrey Portal or TARDIS to travel to Gallifrey!"), false);
                        return 1;
                    }));
            
            // Dimension travel commands
            dispatcher.register(CommandManager.literal("tardis")
                    .then(CommandManager.literal("travel")
                            .executes(ctx -> {
                                ctx.getSource().sendFeedback(() -> Text.literal("Place a TARDIS or use a Planetary Key to travel!"), false);
                                return 1;
                            })));
            
            dispatcher.register(CommandManager.literal("list_planets")
                    .executes(ctx -> {
                        ctx.getSource().sendFeedback(() -> Text.literal("Planets: Gallifrey, Skaro, Cybus, Mondas, Clom, Ravenous, Midnight, Trenzalore, Omega"), false);
                        return 1;
                    }));
        });

        LOGGER.info("Doctor Who mod loaded! EXTERMINATE!");
    }
}
