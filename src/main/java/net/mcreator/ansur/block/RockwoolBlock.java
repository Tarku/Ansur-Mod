
package net.mcreator.ansur.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.ansur.AnsurModElements;

import java.util.List;
import java.util.Collections;

@AnsurModElements.ModElement.Tag
public class RockwoolBlock extends AnsurModElements.ModElement {
	@ObjectHolder("ansur:rockwool")
	public static final Block block = null;
	public RockwoolBlock(AnsurModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ORGANIC).sound(SoundType.STONE).hardnessAndResistance(1.7f, 42069f).setLightLevel(s -> 0)
					.harvestLevel(1).harvestTool(ToolType.PICKAXE).setRequiresTool().slipperiness(0.5f));
			setRegistryName("rockwool");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
