package com.doctorwho.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.doctorwho.DoctorWhoMod;

public class ModEntities {
    
    // Dalek Entity
    public static final EntityType<DalekEntity> DALEK = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(DoctorWhoMod.MOD_ID, "dalek"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, DalekEntity::new)
                    .dimensions(EntityDimensions.fixed(0.8f, 1.5f))
                    .build()
    );
    
    // Cyberman Entity
    public static final EntityType<CybermanEntity> CYBERMAN = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(DoctorWhoMod.MOD_ID, "cyberman"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CybermanEntity::new)
                    .dimensions(EntityDimensions.fixed(0.8f, 2.0f))
                    .build()
    );
    
    // Weeping Angel Entity
    public static final EntityType<WeepingAngelEntity> WEEPING_ANGEL = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(DoctorWhoMod.MOD_ID, "weeping_angel"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WeepingAngelEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 2.4f))
                    .build()
    );
    
    // Sontaran Entity
    public static final EntityType<SontaranEntity> SONTARAN = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(DoctorWhoMod.MOD_ID, "sontaran"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SontaranEntity::new)
                    .dimensions(EntityDimensions.fixed(0.7f, 1.4f))
                    .build()
    );
    
    // Time Lord Entity (friendly NPC)
    public static final EntityType<TimeLordEntity> TIME_LORD = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(DoctorWhoMod.MOD_ID, "time_lord"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TimeLordEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.8f))
                    .build()
    );

    public static void registerEntities() {
        DoctorWhoMod.LOGGER.info("Registering entities for " + DoctorWhoMod.MOD_ID);
    }
}
