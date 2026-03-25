package com.doctorwho.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.BlockView;
import com.doctorwho.world.ModDimensions;

public class GallifreyPortalBlock extends Block {
    
    public GallifreyPortalBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState());
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        }
        
        ServerWorld serverWorld = world.getServer().getWorld(ModDimensions.GALLIFREY_KEY);
        if (serverWorld != null) {
            world.playSound(null, pos, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 0.8F);
            player.moveToWorld(serverWorld);
            serverWorld.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.2F);
            return ActionResult.SUCCESS;
        }
        
        return ActionResult.PASS;
    }

    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            if (player.getVehicle() == null) {
                ServerWorld serverWorld = world.getServer().getWorld(ModDimensions.GALLIFREY_KEY);
                if (serverWorld != null) {
                    world.playSound(null, pos, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 0.8F);
                    player.moveToWorld(serverWorld);
                    serverWorld.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.2F);
                }
            }
        }
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }
}
