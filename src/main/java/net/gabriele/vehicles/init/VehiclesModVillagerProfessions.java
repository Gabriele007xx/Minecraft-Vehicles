
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.gabriele.vehicles.init;

import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Holder;

import net.gabriele.vehicles.VehiclesMod;

import java.util.function.Supplier;
import java.util.function.Predicate;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

import com.google.common.collect.ImmutableSet;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VehiclesModVillagerProfessions {
	private static final Map<String, ProfessionPoiType> POI_TYPES = new HashMap<>();
	public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(Registries.VILLAGER_PROFESSION, VehiclesMod.MODID);
	public static final DeferredHolder<VillagerProfession, VillagerProfession> CHARRIOTER = registerProfession("charrioter", () -> VehiclesModBlocks.WHEEL_REINFORCER.get(),
			() -> BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.villager.work_armorer")));

	private static DeferredHolder<VillagerProfession, VillagerProfession> registerProfession(String name, Supplier<Block> block, Supplier<SoundEvent> soundEvent) {
		POI_TYPES.put(name, new ProfessionPoiType(block, null));
		return PROFESSIONS.register(name, () -> {
			Predicate<Holder<PoiType>> poiPredicate = poiTypeHolder -> (POI_TYPES.get(name).poiType != null) && (poiTypeHolder.value() == POI_TYPES.get(name).poiType.value());
			return new VillagerProfession(VehiclesMod.MODID + ":" + name, poiPredicate, poiPredicate, ImmutableSet.of(), ImmutableSet.of(), soundEvent.get());
		});
	}

	@SubscribeEvent
	public static void registerProfessionPointsOfInterest(RegisterEvent event) {
		event.register(Registries.POINT_OF_INTEREST_TYPE, registerHelper -> {
			for (Map.Entry<String, ProfessionPoiType> entry : POI_TYPES.entrySet()) {
				Block block = entry.getValue().block.get();
				String name = entry.getKey();
				Optional<Holder<PoiType>> existingCheck = PoiTypes.forState(block.defaultBlockState());
				if (existingCheck.isPresent()) {
					VehiclesMod.LOGGER.error("Skipping villager profession " + name + " that uses POI block " + block + " that is already in use by " + existingCheck);
					continue;
				}
				PoiType poiType = new PoiType(ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates()), 1, 1);
				registerHelper.register(new ResourceLocation("vehicles", name), poiType);
				entry.getValue().poiType = BuiltInRegistries.POINT_OF_INTEREST_TYPE.wrapAsHolder(poiType);
			}
		});
	}

	private static class ProfessionPoiType {
		final Supplier<Block> block;
		Holder<PoiType> poiType;

		ProfessionPoiType(Supplier<Block> block, Holder<PoiType> poiType) {
			this.block = block;
			this.poiType = poiType;
		}
	}
}
