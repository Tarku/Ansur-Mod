
package net.mcreator.ansur;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;

import net.mcreator.ansur.item.HastePotionItem;
import net.mcreator.ansur.item.GintaBerriesItem;
import net.mcreator.ansur.item.AidenPotionItem;

@AnsurModElements.ModElement.Tag
public class HaPo2RecipeBrewingRecipe extends AnsurModElements.ModElement {
	public HaPo2RecipeBrewingRecipe(AnsurModElements instance) {
		super(instance, 241);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(AidenPotionItem.block, (int) (1))),
				Ingredient.fromStacks(new ItemStack(GintaBerriesItem.block, (int) (1))), new ItemStack(HastePotionItem.block, (int) (1)));
	}
}
