
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.gabriele.vehicles.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.item.Item;
import net.minecraft.core.registries.BuiltInRegistries;

import net.gabriele.vehicles.item.WoodenWheelItem;
import net.gabriele.vehicles.item.CartItemItem;
import net.gabriele.vehicles.VehiclesMod;

public class VehiclesModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(BuiltInRegistries.ITEM, VehiclesMod.MODID);
	public static final DeferredHolder<Item, Item> WOODEN_WHEEL = REGISTRY.register("wooden_wheel", () -> new WoodenWheelItem());
	public static final DeferredHolder<Item, Item> CART_ITEM = REGISTRY.register("cart_item", () -> new CartItemItem());

	// Start of user code block custom items
	// End of user code block custom items
	public static void register(IEventBus bus) {
		REGISTRY.register(bus);
	}
}
