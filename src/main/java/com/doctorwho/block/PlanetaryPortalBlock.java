package com.doctorwho.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import com.doctorwho.world.ModDimensions;

import java.util.HashMap;
import java.util.Map;

public class PlanetaryPortalBlock extends Block {
    
    private static final Map<String, net.minecraft.util.Identifier> PLANET_KEYS = new HashMap<>();
    
    static {
        PLANET_KEYS.put("skaro", new net.minecraft.util.Identifier("doctorwho", "skaro"));
        PLANET_KEYS.put("cybus", new net.minecraft.util.Identifier("doctorwho", "cybus"));
        PLANET_KEYS.put("mondas", new net.minecraft.util.Identifier("doctorwho", "mondas"));
        PLANET_KEYS.put("clom", new net.minecraft.util.Identifier("doctorwho", "clom"));
        PLANET_KEYS.put("ravenous", new net.minecraft.util.Identifier("doctorwho", "ravenous"));
        PLANET_KEYS.put("midnight", new net.minecraft.util.Identifier("doctorwho", "midnight"));
        PLANET_KEYS.put("trenzalore", new net.minecraft.util.Identifier("doctorwho", "trenzalore"));
        PLANET_KEYS.put("omega", new net.minecraft.util.Identifier("doctorwho", "omega"));
    }
    
    private final String targetPlanet;
    
    public PlanetaryPortalBlock(Settings settings, String targetPlanet) {
        super(settings);
        this.targetPlanet = targetPlanet;
    }
    
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        }
        
        ServerWorld targetWorld = getTargetWorld(world, targetPlanet);
        if (targetWorld != null) {
            world.playSound(null, pos, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 0.8F);
            player.moveToWorld(targetWorld);
            targetWorld.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.2F);
            return ActionResult.SUCCESS;
        }
        
        return ActionResult.PASS;
    }
    
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            if (player.getVehicle() == null) {
                ServerWorld targetWorld = getTargetWorld(world, targetPlanet);
                if (targetWorld != null) {
                    world.playSound(null, pos, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 0.8F);
                    player.moveToWorld(targetWorld);
                    targetWorld.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.2F);
                }
            }
        }
    }
    
    private ServerWorld getTargetWorld(World world, String planet) {
        net.minecraft.util.Identifier key = PLANET_KEYS.get(planet);
        if (key != null) {
            return world.getServer().getWorld(
                    net.minecraft.registry.RegistryKey.of(
                            net.minecraft.registry.RegistryKeys.WORLD, key));
        }
        return null;
    }
}
