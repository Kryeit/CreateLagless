package com.kryeit.createlagless.mixin.create;

import com.simibubi.create.content.contraptions.AbstractContraptionEntity;

import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;

import net.minecraft.entity.Entity;

import net.minecraft.entity.ItemEntity;

import net.minecraft.item.Item;

import net.minecraft.item.Items;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(AbstractContraptionEntity.class)
public class AbstractContraptionEntityMixin {

	@Inject(
			method = "collidesWith",
			at = @At("HEAD"),
			cancellable = true
	)
	private void hasCollision(Entity e, CallbackInfoReturnable<Boolean> cir) {


		if (e instanceof ItemEntity ie) {
			List<Item> collideBypass = List.of(
					Items.COBBLESTONE,
					Items.STONE,
					Items.CALCITE,
					AllPaletteStoneTypes.SCORCHIA.baseBlock.get().asItem(),
					AllPaletteStoneTypes.SCORIA.baseBlock.get().asItem()
			);

			if (collideBypass.contains(ie.getStack().getItem())) {
				cir.setReturnValue(false);
			}
		}
	}
}
