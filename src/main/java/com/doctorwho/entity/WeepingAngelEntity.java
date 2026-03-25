package com.doctorwho.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.EnumSet;

public class WeepingAngelEntity extends HostileEntity {
    
    private boolean isObserved = false;
    private Entity observedBy = null;

    public WeepingAngelEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, 16.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
    }

    public static DefaultAttributeContainer.Builder createMobAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 60.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20.0D);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AngelAttackGoal(this));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 12.0F));
        this.goalSelector.add(3, new LookAroundGoal(this));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 0.5D));
        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true, false));
    }
    
    @Override
    public void tick() {
        super.tick();
        
        // Check if being observed by any player
        World world = this.getWorld();
        if (!world.isClient) {
            boolean wasObserved = isObserved;
            isObserved = false;
            
            for (PlayerEntity player : world.getEntitiesByClass(PlayerEntity.class, 
                    this.getBoundingBox().expand(30.0), p -> true)) {
                if (this.isLookingAtMe(player)) {
                    isObserved = true;
                    observedBy = player;
                    break;
                }
            }
            
            // If was observed and now not, teleport closer to observer
            if (wasObserved && !isObserved && observedBy != null) {
                this.teleportNear(observedBy);
            }
        }
    }
    
    private boolean isLookingAtMe(PlayerEntity player) {
        Vec3d lookVec = player.getRotationVec(1.0F);
        Vec3d toEntity = this.getPos().relativize(player.getPos());
        double dist = toEntity.length();
        if (dist > 30) return false;
        
        double dot = lookVec.dotProduct(toEntity.normalize());
        return dot > 0.9; // Approximately 25 degree cone
    }
    
    private void teleportNear(Entity target) {
        double offsetX = (random.nextDouble() - 0.5) * 4;
        double offsetZ = (random.nextDouble() - 0.5) * 4;
        
        this.requestTeleport(target.getX() + offsetX, target.getY(), target.getZ() + offsetZ);
        World world = this.getWorld();
        world.playSound(null, this.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, 
                net.minecraft.sound.SoundCategory.HOSTILE, 1.0F, 1.0F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_GHAST_HURT;
    }

    protected SoundEvent getHurtSound() {
        return SoundEvents.ENTITY_GENERIC_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_GENERIC_DEATH;
    }
    
    static class AngelAttackGoal extends Goal {
        private final WeepingAngelEntity angel;
        
        public AngelAttackGoal(WeepingAngelEntity angel) {
            this.angel = angel;
            this.setControls(EnumSet.of(Goal.Control.LOOK, Goal.Control.MOVE));
        }
        
        @Override
        public boolean canStart() {
            return !angel.isObserved; // Only move when not being observed
        }
        
        @Override
        public void tick() {
            // Angel slowly approaches target when not observed
            this.angel.getNavigation().tick();
        }
    }
}
