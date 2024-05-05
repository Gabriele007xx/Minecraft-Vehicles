
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.gabriele.vehicles.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.core.registries.BuiltInRegistries;

import net.gabriele.vehicles.item.WoodenWheelItem;
import net.gabriele.vehicles.item.ReinforcedWheelItem;
import net.gabriele.vehicles.item.CartItemItem;
import net.gabriele.vehicles.VehiclesMod;

public class VehiclesModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(BuiltInRegistries.ITEM, VehiclesMod.MODID);
	public static final DeferredHolder<Item, Item> WOODEN_WHEEL = REGISTRY.register("wooden_wheel", () -> new WoodenWheelItem());
	public static final DeferredHolder<Item, Item> CART_ITEM = REGISTRY.register("cart_item", () -> new CartItemItem());
	public static final DeferredHolder<Item, Item> WHEEL_REINFORCER = block(VehiclesModBlocks.WHEEL_REINFORCER);
	public static final DeferredHolder<Item, Item> REINFORCED_WHEEL = REGISTRY.register("reinforced_wheel", () -> new ReinforcedWheelItem());
	public static final DeferredHolder<Item, Item> WORKSHOP = block(VehiclesModBlocks.WORKSHOP);

	// Start of user code block custom items
	// End of user code block custom items
	public static void register(IEventBus bus) {
		REGISTRY.register(bus);
	}

	private static DeferredHolder<Item, Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
