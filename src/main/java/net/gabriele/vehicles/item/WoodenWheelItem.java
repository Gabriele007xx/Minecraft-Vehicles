
package net.gabriele.vehicles.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class WoodenWheelItem extends Item {
	public WoodenWheelItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
