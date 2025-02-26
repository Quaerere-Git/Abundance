package com.teamaurora.abundance.common.item;

import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class SaguaroFlowerItem extends BlockItem {
    public SaguaroFlowerItem(Properties properties) {
        super(AbundanceBlocks.SAGUARO_SPROUT.get(), properties);
    }

    @Nullable
    @Override
    protected BlockState getStateForPlacement(BlockItemUseContext context) {
        if (context.getFace() != Direction.UP) return null;
        World world = context.getWorld();
        Block blockDown = world.getBlockState(context.getPos().down()).getBlock();
        BlockState blockstate = null;
        if (blockDown.isIn(BlockTags.SAND)) {
            blockstate = AbundanceBlocks.SAGUARO_SPROUT.get().getStateForPlacement(context);
        } else if (blockDown == AbundanceBlocks.SAGUARO_CACTUS.get() || blockDown == AbundanceBlocks.SMALL_SAGUARO_CACTUS.get()) {
            blockstate = AbundanceBlocks.SAGUARO_FLOWER.get().getStateForPlacement(context);
        }
        return blockstate != null && this.canPlace(context, blockstate) ? blockstate : null;
    }
}
