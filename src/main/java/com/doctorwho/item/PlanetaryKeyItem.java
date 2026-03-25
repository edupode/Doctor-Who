package com.doctorwho.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import com.doctorwho.DoctorWhoMod;
import com.doctorwho.world.ModDimensions;

import java.util.HashMap;
import java.util.Map;

public class PlanetaryKeyItem extends Item {
    
    private static final Map<String, RegistryKey<World>> PLANET_DIMENSIONS = new HashMap<>();
    
    static {
        PLANET_DIMENSIONS.put("skaro", ModDimensions.SKARO_KEY);
        PLANET_DIMENSIONS.put("cybus", ModDimensions.CYBUS_KEY);
        PLANET_DIMENSIONS.put("mondas", ModDimensions.MONDAS_KEY);
        PLANET_DIMENSIONS.put("clom", ModDimensions.CLOM_KEY);
        PLANET_DIMENSIONS.put("ravenous", ModDimensions.RAVENOUS_KEY);
        PLANET_DIMENSIONS.put("midnight", ModDimensions.MIDNIGHT_KEY);
        PLANET_DIMENSIONS.put("trenzalore", ModDimensions.TRENZALORE_KEY);
        PLANET_DIMENSIONS.put("omega", ModDimensions.OMEGA_KEY);
    }
    
    private final String targetPlanet;
    
    public PlanetaryKeyItem(Settings settings, String targetPlanet) {
        super(settings);
        this.targetPlanet = targetPlanet;
    }
    
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        
        if (!world.isClient && player != null) {
            RegistryKey<World> targetDimension = PLANET_DIMENSIONS.get(targetPlanet);
            
            if (targetDimension != null) {
                ServerWorld targetWorld = world.getServer().getWorld(targetDimension);
                
                if (targetWorld != null) {
                    // Play tardis travel sound effect
                    world.playSound(null, player.getBlockPos(), 
                            SoundEvents.ENTITY_ENDERMAN_TELEPORT, 
                            SoundCategory.PLAYERS, 1.0F, 0.8F);
                    
                    // Teleport the player
                    double x = player.getX();
                    double y = player.getY();
                    double z = player.getZ();
                    
                    player.moveToWorld(targetWorld);
                    player.setPosition(x, y + 1, z);
                    
                    // Play arrival sound
                    targetWorld.playSound(null, player.getBlockPos(), 
                            SoundEvents.ENTITY_ENDERMAN_TELEPORT, 
                            SoundCategory.PLAYERS, 1.0F, 1.2F);
                    
                    // Damage the key slightly
                    ItemStack stack = context.getStack();
                    if (!player.getAbilities().creativeMode) {
                        stack.damage(1, player, p -> {});
                    }
                    
                    return ActionResult.SUCCESS;
                }
            }
        }
        
        return ActionResult.PASS;
    }
    
    public String getTargetPlanet() {
        return targetPlanet;
    }
}
