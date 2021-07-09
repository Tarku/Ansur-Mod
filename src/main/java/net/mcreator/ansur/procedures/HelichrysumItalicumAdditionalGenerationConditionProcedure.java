package net.mcreator.ansur.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.ansur.block.RockwoodLeavesBlock;
import net.mcreator.ansur.block.ForwoodLeavesBlock;
import net.mcreator.ansur.block.DanewoodLeavesBlock;
import net.mcreator.ansur.AnsurModElements;
import net.mcreator.ansur.AnsurMod;

import java.util.Map;

@AnsurModElements.ModElement.Tag
public class HelichrysumItalicumAdditionalGenerationConditionProcedure extends AnsurModElements.ModElement {
	public HelichrysumItalicumAdditionalGenerationConditionProcedure(AnsurModElements instance) {
		super(instance, 157);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AnsurMod.LOGGER.warn("Failed to load dependency x for procedure HelichrysumItalicumAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AnsurMod.LOGGER.warn("Failed to load dependency y for procedure HelichrysumItalicumAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AnsurMod.LOGGER.warn("Failed to load dependency z for procedure HelichrysumItalicumAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AnsurMod.LOGGER.warn("Failed to load dependency world for procedure HelichrysumItalicumAdditionalGenerationCondition!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		return ((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == DanewoodLeavesBlock.block.getDefaultState()
				.getBlock()))
				&& ((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == ForwoodLeavesBlock.block.getDefaultState()
						.getBlock()))
						&& (!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == RockwoodLeavesBlock.block
								.getDefaultState().getBlock()))));
	}
}
