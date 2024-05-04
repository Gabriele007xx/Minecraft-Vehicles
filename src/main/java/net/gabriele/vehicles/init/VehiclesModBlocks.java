
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.gabriele.vehicles.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.gabriele.vehicles.block.WheelReinforcerBlock;
import net.gabriele.vehicles.VehiclesMod;

public class VehiclesModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK, VehiclesMod.MODID);
	public static final DeferredHolder<Block, Block> WHEEL_REINFORCER = REGISTRY.register("wheel_reinforcer", () -> new WheelReinforcerBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
