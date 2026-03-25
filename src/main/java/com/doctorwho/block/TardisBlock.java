package com.doctorwho.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import com.doctorwho.world.ModDimensions;

public class TardisBlock extends Block {
    
    public TardisBlock(Settings settings) {
        super(settings.noCollision());
    }
    
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        }
        
        // Show GUI or teleport options - use SoundEvent directly from registry
        world.playSound(null, pos, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.BLOCKS, 1.0F, 1.5F);
        
        // Teleport to Gallifrey by default (can be expanded for destination selection)
        ServerWorld gallifreyWorld = world.getServer().getWorld(ModDimensions.GALLIFREY_KEY);
        if (gallifreyWorld != null) {
            world.playSound(null, pos, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 0.8F);
            player.moveToWorld(gallifreyWorld);
            gallifreyWorld.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.2F);
            return ActionResult.SUCCESS;
        }
        
        return ActionResult.PASS;
    }
    
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            if (player.getVehicle() == null) {
                ServerWorld gallifreyWorld = world.getServer().getWorld(ModDimensions.GALLIFREY_KEY);
                if (gallifreyWorld != null) {
                    SoundEvent teleportSound = SoundEvents.ENTITY_ENDERMAN_TELEPORT;
                    world.playSound(null, pos, teleportSound, SoundCategory.PLAYERS, 1.0F, 0.8F);
                    player.moveToWorld(gallifreyWorld);
                    gallifreyWorld.playSound(null, player.getBlockPos(), teleportSound, SoundCategory.PLAYERS, 1.0F, 1.2F);
                }
            }
        }
    }
}
