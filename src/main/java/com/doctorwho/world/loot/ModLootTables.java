package com.doctorwho.world.loot;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.EnchantWithLevelsLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import com.doctorwho.DoctorWhoMod;
import com.doctorwho.item.ModItems;
import com.doctorwho.entity.ModEntities;
import net.minecraft.loot.LootTables;

public class ModLootTables {
    
    public static void registerLootTables() {
        DoctorWhoMod.LOGGER.info("Registering loot tables for " + DoctorWhoMod.MOD_ID);
    }
    
    // Helper methods for creating loot table entries
    public static LeafEntry.Builder<?> itemEntry(Item item, int weight) {
        return ItemEntry.builder(item).weight(weight);
    }
    
    public static LeafEntry.Builder<?> itemEntryWithCount(Item item, int minCount, int maxCount, int weight) {
        return ItemEntry.builder(item)
                .weight(weight)
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minCount, maxCount)));
    }
}
