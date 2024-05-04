
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.gabriele.vehicles.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.gabriele.vehicles.client.gui.CartGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class VehiclesModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(VehiclesModMenus.CART_GUI.get(), CartGUIScreen::new);
	}
}
