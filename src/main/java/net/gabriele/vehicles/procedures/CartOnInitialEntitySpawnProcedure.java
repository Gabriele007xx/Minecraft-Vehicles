package net.gabriele.vehicles.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.gabriele.vehicles.init.VehiclesModItems;

public class CartOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerEntSetSlot) {
			ItemStack _setstack = new ItemStack(VehiclesModItems.WOODEN_WHEEL.get()).copy();
			_setstack.setCount(1);
			_modHandlerEntSetSlot.setStackInSlot(9, _setstack);
		}
	}
}
