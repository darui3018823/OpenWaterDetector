package com.daruks.openwaterdetector.mixin

import net.minecraft.core.BlockPos
import net.minecraft.world.entity.projectile.FishingHook
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.gen.Invoker

@Mixin(FishingHook::class)
interface OpenWaterDetectorFishingHookAccessor {
    @Invoker("calculateOpenWater")
    fun `openWaterDetector$calculateOpenWater`(bobberPosition: BlockPos): Boolean
}
