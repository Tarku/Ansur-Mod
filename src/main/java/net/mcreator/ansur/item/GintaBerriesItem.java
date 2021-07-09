
package net.mcreator.ansur.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.ansur.AnsurModElements;

@AnsurModElements.ModElement.Tag
public class GintaBerriesItem extends AnsurModElements.ModElement {
	@ObjectHolder("ansur:ginta_berries")
	public static final Item block = null;
	public GintaBerriesItem(AnsurModElements instance) {
		super(instance, 234);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(3).saturation(1.2000000000000002f).build()));
			setRegistryName("ginta_berries");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
