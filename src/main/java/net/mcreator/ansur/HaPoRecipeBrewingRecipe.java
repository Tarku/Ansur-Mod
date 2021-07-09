
package net.mcreator.ansur;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.mcreator.ansur.item.AidenPotionItem;
import net.mcreator.ansur.block.FibrousMushroomBlock;

@AnsurModElements.ModElement.Tag
public class HaPoRecipeBrewingRecipe extends AnsurModElements.ModElement {
	public HaPoRecipeBrewingRecipe(AnsurModElements instance) {
		super(instance, 231);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(Items.POTION, (int) (1))),
				Ingredient.fromStacks(new ItemStack(FibrousMushroomBlock.block, (int) (1))), new ItemStack(AidenPotionItem.block, (int) (1)));
	}
}
