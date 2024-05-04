
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.gabriele.vehicles.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.gabriele.vehicles.world.inventory.CartGUIMenu;
import net.gabriele.vehicles.VehiclesMod;

public class VehiclesModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, VehiclesMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<CartGUIMenu>> CART_GUI = REGISTRY.register("cart_gui", () -> IMenuTypeExtension.create(CartGUIMenu::new));
}
