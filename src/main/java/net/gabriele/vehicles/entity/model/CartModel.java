package net.gabriele.vehicles.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.gabriele.vehicles.entity.CartEntity;

public class CartModel extends GeoModel<CartEntity> {
	@Override
	public ResourceLocation getAnimationResource(CartEntity entity) {
		return new ResourceLocation("vehicles", "animations/cart.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CartEntity entity) {
		return new ResourceLocation("vehicles", "geo/cart.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CartEntity entity) {
		return new ResourceLocation("vehicles", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(CartEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("Head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
