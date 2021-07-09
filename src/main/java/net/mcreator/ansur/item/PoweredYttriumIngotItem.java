
package net.mcreator.ansur.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.ansur.procedures.PoweredYttriumIngotQuandLitemEstDansLinventaireParTickProcedure;
import net.mcreator.ansur.AnsurModElements;

import java.util.Map;
import java.util.HashMap;

@AnsurModElements.ModElement.Tag
public class PoweredYttriumIngotItem extends AnsurModElements.ModElement {
	@ObjectHolder("ansur:powered_yttrium_ingot")
	public static final Item block = null;
	public PoweredYttriumIngotItem(AnsurModElements instance) {
		super(instance, 71);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MATERIALS).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("powered_yttrium_ingot");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				PoweredYttriumIngotQuandLitemEstDansLinventaireParTickProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
