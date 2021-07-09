
package net.mcreator.ansur.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.ansur.AnsurModElements;

@AnsurModElements.ModElement.Tag
public class PowerHammerItem extends AnsurModElements.ModElement {
	@ObjectHolder("ansur:power_hammer")
	public static final Item block = null;
	public PowerHammerItem(AnsurModElements instance) {
		super(instance, 67);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.TOOLS).maxDamage(250).rarity(Rarity.COMMON));
			setRegistryName("power_hammer");
		}

		@Override
		public boolean hasContainerItem() {
			return true;
		}

		@Override
		public ItemStack getContainerItem(ItemStack itemstack) {
			ItemStack retval = new ItemStack(this);
			retval.setDamage(itemstack.getDamage() + 1);
			if (retval.getDamage() >= retval.getMaxDamage()) {
				return ItemStack.EMPTY;
			}
			return retval;
		}

		@Override
		public boolean isRepairable(ItemStack itemstack) {
			return false;
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 2;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 3F;
		}
	}
}
