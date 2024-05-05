package net.gabriele.vehicles.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class CartOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getDeltaMovement().x() > 0 || entity.getDeltaMovement().z() > 0) && (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && (new Object() {
			public ItemStack getItemStack(int sltid, Entity entity) {
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerEntGetSlot)
					return _modHandlerEntGetSlot.getStackInSlot(sltid).copy();
				return ItemStack.EMPTY;
			}
		}.getItemStack(9, entity)).getDamageValue() != 59) {
			{
				ItemStack _ist = (new Object() {
					public ItemStack getItemStack(int sltid, Entity entity) {
						if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerEntGetSlot)
							return _modHandlerEntGetSlot.getStackInSlot(sltid).copy();
						return ItemStack.EMPTY;
					}
				}.getItemStack(9, entity));
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
		}
	}
}
