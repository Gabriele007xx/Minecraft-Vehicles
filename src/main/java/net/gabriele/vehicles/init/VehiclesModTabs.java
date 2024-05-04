
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.gabriele.vehicles.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.gabriele.vehicles.VehiclesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VehiclesModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VehiclesMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> VEHICLES = REGISTRY.register("vehicles",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.vehicles.vehicles")).icon(() -> new ItemStack(VehiclesModItems.CART_ITEM.get())).displayItems((parameters, tabData) -> {
				tabData.accept(VehiclesModItems.CART_ITEM.get());
			})

					.build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			tabData.accept(VehiclesModBlocks.WHEEL_REINFORCER.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(VehiclesModItems.WOODEN_WHEEL.get());
		}
	}
}
