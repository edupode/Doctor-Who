package com.doctorwho.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.World;
import com.doctorwho.DoctorWhoMod;
import com.doctorwho.world.ModDimensions;

public class SonicScrewdriverItem extends Item {
    
    public SonicScrewdriverItem(Settings settings) {
        super(settings);
    }
    
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState state = world.getBlockState(pos);
        PlayerEntity player = context.getPlayer();
        
        if (!world.isClient && player != null) {
            // Play sonic sound
            world.playSound(null, pos, SoundEvents.ENTITY_IRON_GOLEM_REPAIR, SoundCategory.PLAYERS, 1.0F, 1.5F);
            
            // Attempt to open doors, activate switches, etc.
            Block block = state.getBlock();
            String blockId = Registries.BLOCK.getId(block).toString();
            
            // Sonic can interact with certain blocks
            if (blockId.contains("door") || blockId.contains("button") || blockId.contains("lever")) {
                world.updateNeighbor(state, pos, world.getBlockState(pos).getBlock(), pos, false);
                return ActionResult.SUCCESS;
            }
        }
        
        return ActionResult.PASS;
    }
}
