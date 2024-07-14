package com.kryeit.createlagless;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class Main implements ModInitializer {
    public static final String MOD_ID = "createlagless";
    public static final Logger LOGGER = LoggerFactory.getLogger("Create: Lagless");

	public static final List<Item> collideBypass = List.of(
			Items.COBBLESTONE,
			Items.STONE,
			Items.CALCITE,
			AllPaletteStoneTypes.SCORCHIA.baseBlock.get().asItem(),
			AllPaletteStoneTypes.SCORIA.baseBlock.get().asItem()
	);

	@Override
	public void onInitialize() {}
}
