
package net.mcreator.ansur.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.Block;

import net.mcreator.ansur.AnsurModElements;

@AnsurModElements.ModElement.Tag
public class ForwoodLeavesBlock extends AnsurModElements.ModElement {
	@ObjectHolder("ansur:forwood_leaves")
	public static final Block block = null;
	public ForwoodLeavesBlock(AnsurModElements instance) {
		super(instance, 38);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends LeavesBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(0.1f, 5f).setLightLevel(s -> 0)
					.slipperiness(0.4f).notSolid());
			setRegistryName("forwood_leaves");
		}
	}
}
