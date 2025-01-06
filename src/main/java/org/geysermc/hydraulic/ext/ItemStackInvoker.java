package org.geysermc.hydraulic.ext;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BlockBehaviour.class)
public interface ItemStackInvoker {
    @Invoker("getCloneItemStack")
    public ItemStack getCloneItemStack(LevelReader reader, BlockPos pos, BlockState state, boolean bl);
}
