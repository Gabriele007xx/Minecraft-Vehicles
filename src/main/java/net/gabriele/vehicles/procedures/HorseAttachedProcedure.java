package net.gabriele.vehicles.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.gabriele.vehicles.init.VehiclesModItems;
import net.gabriele.vehicles.init.VehiclesModEntities;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HorseAttachedProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == VehiclesModItems.CART_ITEM.get() && entity instanceof Horse) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = VehiclesModEntities.CART.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(entity.getYRot());
					entityToSpawn.setYBodyRot(entity.getYRot());
					entityToSpawn.setYHeadRot(entity.getYRot());
					entityToSpawn.setXRot(entity.getXRot());
				}
			}
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
