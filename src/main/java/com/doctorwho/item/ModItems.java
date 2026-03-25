package com.doctorwho.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import com.doctorwho.DoctorWhoMod;

public class ModItems {
    
    public static final Item GALLIFREY_PORTAL_ITEM = Registry.register(
            Registries.ITEM,
            new Identifier(DoctorWhoMod.MOD_ID, "gallifrey_portal"),
            new net.minecraft.item.BlockItem(com.doctorwho.block.ModBlocks.GALLIFREY_PORTAL, new Item.Settings())
    );
    
    // TARDIS Item
    public static final Item TARDIS_ITEM = Registry.register(
            Registries.ITEM,
            new Identifier(DoctorWhoMod.MOD_ID, "tardis"),
            new net.minecraft.item.BlockItem(com.doctorwho.block.ModBlocks.TARDIS, new Item.Settings().maxCount(1))
    );
    
    // Dalek Parts
    public static final Item DALEK_Circuitry = Registry.register(
            Registries.ITEM,
            new Identifier(DoctorWhoMod.MOD_ID, "dalek_circuitry"),
            new Item(new Item.Settings())
    );
    
    public static final Item DALEK_Plunger = Registry.register(
            Registries.ITEM,
            new Identifier(DoctorWhoMod.MOD_ID, "dalek_plunger"),
            new Item(new Item.Settings())
    );
    
    // Cyberman Parts
    public static final Item CYBERMAN_Head = Registry.register(
            Registries.ITEM,
            new Identifier(DoctorWhoMod.MOD_ID, "cyberman_head"),
            new Item(new Item.Settings())
    );
    
    public static final Item CYBER_Circuitry = Registry.register(
            Registries.ITEM,
            new Identifier(DoctorWhoMod.MOD_ID, "cyber_circuitry"),
            new Item(new Item.Settings())
    );
    
    // Time Lord Items
    public static final Item TIME_LORD_ROBE = Registry.register(
            Registries.ITEM,
            new Identifier(DoctorWhoMod.MOD_ID, "time_lord_robe"),
            new Item(new Item.Settings())
    );
    
    public static final Item SONIC_SCREWDRIVER = Registry.register(
            Registries.ITEM,
            new Identifier(DoctorWhoMod.MOD_ID, "sonic_screwdriver"),
            new com.doctorwho.item.SonicScrewdriverItem(new Item.Settings().maxCount(1).maxDamage(256))
    );
    
    // Weeping Angel Parts
    public static final Item ANGEL_STONE_Fragment = Registry.register(
            Registries.ITEM,
            new Identifier(DoctorWhoMod.MOD_ID, "angel_stone_fragment"),
            new Item(new Item.Settings())
    );
    
    // Sontaran Items
    public static final Item SONTARAN_Helm = Registry.register(
            Registries.ITEM,
            new Identifier(DoctorWhoMod.MOD_ID, "sontaran_helm"),
            new Item(new Item.Settings())
    );
    
    // Planetary Keys
    public static final Item SKARO_KEY = Registry.register(
            Registries.ITEM,
            new Identifier(DoctorWhoMod.MOD_ID, "skaro_key"),
            new com.doctorwho.item.PlanetaryKeyItem(new Item.Settings().maxCount(1), "skaro")
    );
    
    public static final Item CYBUS_KEY = Registry.register(
            Registries.ITEM,
            new Identifier(DoctorWhoMod.MOD_ID, "cybus_key"),
            new com.doctorwho.item.PlanetaryKeyItem(new Item.Settings().maxCount(1), "cybus")
    );
    
    public static final Item MONDAS_KEY = Registry.register(
            Registries.ITEM,
            new Identifier(DoctorWhoMod.MOD_ID, "mondas_key"),
            new com.doctorwho.item.PlanetaryKeyItem(new Item.Settings().maxCount(1), "mondas")
    );
    
    public static final Item CLOM_KEY = Registry.register(
            Registries.ITEM,
            new Identifier(DoctorWhoMod.MOD_ID, "clom_key"),
            new com.doctorwho.item.PlanetaryKeyItem(new Item.Settings().maxCount(1), "clom")
    );
    
    public static final Item RAVENous_KEY = Registry.register(
            Registries.ITEM,
            new Identifier(DoctorWhoMod.MOD_ID, "ravenous_key"),
            new com.doctorwho.item.PlanetaryKeyItem(new Item.Settings().maxCount(1), "ravenous")
    );
    
    public static final Item MIDNIGHT_KEY = Registry.register(
            Registries.ITEM,
            new Identifier(DoctorWhoMod.MOD_ID, "midnight_key"),
            new com.doctorwho.item.PlanetaryKeyItem(new Item.Settings().maxCount(1), "midnight")
    );
    
    public static final Item TRENZALORE_KEY = Registry.register(
            Registries.ITEM,
            new Identifier(DoctorWhoMod.MOD_ID, "trenzalore_key"),
            new com.doctorwho.item.PlanetaryKeyItem(new Item.Settings().maxCount(1), "trenzalore")
    );
    
    public static final Item OMEGA_KEY = Registry.register(
            Registries.ITEM,
            new Identifier(DoctorWhoMod.MOD_ID, "omega_key"),
            new com.doctorwho.item.PlanetaryKeyItem(new Item.Settings().maxCount(1), "omega")
    );

    public static void registerItems() {
        DoctorWhoMod.LOGGER.info("Registering items for " + DoctorWhoMod.MOD_ID);
    }
}
