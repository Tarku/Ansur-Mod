package net.mcreator.ansur.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.ansur.block.GintaTopBerriesBlock;
import net.mcreator.ansur.AnsurModElements;
import net.mcreator.ansur.AnsurMod;

import java.util.Map;

@AnsurModElements.ModElement.Tag
public class GintaUpdateTickProcedure extends AnsurModElements.ModElement {
	public GintaUpdateTickProcedure(AnsurModElements instance) {
		super(instance, 242);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AnsurMod.LOGGER.warn("Failed to load dependency x for procedure GintaUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AnsurMod.LOGGER.warn("Failed to load dependency y for procedure GintaUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AnsurMod.LOGGER.warn("Failed to load dependency z for procedure GintaUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AnsurMod.LOGGER.warn("Failed to load dependency world for procedure GintaUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((Math.random() * 80) < 2)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), GintaTopBerriesBlock.block.getDefaultState(), 3);
		}
	}
}
