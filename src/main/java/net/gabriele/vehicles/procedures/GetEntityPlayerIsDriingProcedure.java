package net.gabriele.vehicles.procedures;

import net.minecraft.world.entity.Entity;

public class GetEntityPlayerIsDriingProcedure {
	public static Entity execute(Entity entity) {
		if (entity == null)
			return null;
		return entity.getVehicle();
	}
}
