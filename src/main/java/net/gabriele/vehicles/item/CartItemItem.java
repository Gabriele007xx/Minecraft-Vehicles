
package net.gabriele.vehicles.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CartItemItem extends Item {
	public CartItemItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
