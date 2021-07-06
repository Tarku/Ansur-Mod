
package net.mcreator.ansur.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.ansur.AnsurModElements;

@AnsurModElements.ModElement.Tag
public class PoweredYttriumStuffAxeItem extends AnsurModElements.ModElement {
	@ObjectHolder("ansur:powered_yttrium_stuff_axe")
	public static final Item block = null;
	public PoweredYttriumStuffAxeItem(AnsurModElements instance) {
		super(instance, 66);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2380;
			}

			public float getEfficiency() {
				return 16f;
			}

			public float getAttackDamage() {
				return 28f;
			}

			public int getHarvestLevel() {
				return 10;
			}

			public int getEnchantability() {
				return 70;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -2.5f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("powered_yttrium_stuff_axe"));
	}
}
