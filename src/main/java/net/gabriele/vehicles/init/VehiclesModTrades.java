
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.gabriele.vehicles.init;

import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class VehiclesModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == VehiclesModVillagerProfessions.CHARRIOTER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.COPPER_INGOT),

					new ItemStack(VehiclesModItems.WOODEN_WHEEL.get(), 2), 5, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.IRON_NUGGET, 2),

					new ItemStack(Items.STICK, 8), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.IRON_NUGGET, 3), new ItemStack(Items.FLINT), new ItemStack(VehiclesModItems.CART_ITEM.get()), 2, 10, 0.05f));
		}
	}
}
