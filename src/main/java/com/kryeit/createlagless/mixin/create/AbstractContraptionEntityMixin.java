package com.kryeit.createlagless.mixin.create;

import static com.kryeit.createlagless.Main.collideBypass;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.simibubi.create.content.contraptions.AbstractContraptionEntity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;

@Mixin(AbstractContraptionEntity.class)
public class AbstractContraptionEntityMixin {

	@Inject(
			method = "collidesWith",
			at = @At("HEAD"),
			cancellable = true
	)
	private void hasCollision(Entity e, CallbackInfoReturnable<Boolean> cir) {


		if (e instanceof ItemEntity ie) {
			if (collideBypass.contains(ie.getStack().getItem())) {
				cir.setReturnValue(false);
			}
		}
	}
}
