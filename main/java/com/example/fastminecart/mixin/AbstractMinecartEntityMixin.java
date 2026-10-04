package com.example.fastminecart.mixin;

import net.minecraft.world.entity.vehicle.AbstractMinecart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractMinecart.class)
public class AbstractMinecartEntityMixin {

    @Inject(method = "getMaxSpeed", at = @At("HEAD"), cancellable = true)
    private void onGetMaxSpeed(CallbackInfoReturnable<Double> cir) {
        // 10.0 代表每刻移動 10 格（每秒 200 格）。
        // 超越常規限制，達到極限高速
        cir.setReturnValue(10.0); 
    }
}