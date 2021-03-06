
package net.mcreator.ansur.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.ansur.AnsurModElements;

@AnsurModElements.ModElement.Tag
public class PoweredYttriumStuffSwordItem extends AnsurModElements.ModElement {
	@ObjectHolder("ansur:powered_yttrium_stuff_sword")
	public static final Item block = null;
	public PoweredYttriumStuffSwordItem(AnsurModElements instance) {
		super(instance, 80);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2380;
			}

			public float getEfficiency() {
				return 16f;
			}

			public float getAttackDamage() {
				return 8f;
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
		}, 3, -1.5f, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("powered_yttrium_stuff_sword"));
	}
}
