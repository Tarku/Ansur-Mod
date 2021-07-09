package net.mcreator.ansur.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.ansur.AnsurModElements;
import net.mcreator.ansur.AnsurMod;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;

@AnsurModElements.ModElement.Tag
public class FriendlySpiderEntityDiesProcedure extends AnsurModElements.ModElement {
	public FriendlySpiderEntityDiesProcedure(AnsurModElements instance) {
		super(instance, 127);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AnsurMod.LOGGER.warn("Failed to load dependency x for procedure FriendlySpiderEntityDies!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AnsurMod.LOGGER.warn("Failed to load dependency y for procedure FriendlySpiderEntityDies!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AnsurMod.LOGGER.warn("Failed to load dependency z for procedure FriendlySpiderEntityDies!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AnsurMod.LOGGER.warn("Failed to load dependency world for procedure FriendlySpiderEntityDies!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((Entity) world
				.getEntitiesWithinAABB(PlayerEntity.class,
						new AxisAlignedBB(x - (1000 / 2d), y - (1000 / 2d), z - (1000 / 2d), x + (1000 / 2d), y + (1000 / 2d), z + (1000 / 2d)), null)
				.stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof PlayerEntity
				&& !((Entity) world.getEntitiesWithinAABB(PlayerEntity.class,
						new AxisAlignedBB(x - (1000 / 2d), y - (1000 / 2d), z - (1000 / 2d), x + (1000 / 2d), y + (1000 / 2d), z + (1000 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).world.isRemote()) {
			((PlayerEntity) ((Entity) world.getEntitiesWithinAABB(PlayerEntity.class,
					new AxisAlignedBB(x - (1000 / 2d), y - (1000 / 2d), z - (1000 / 2d), x + (1000 / 2d), y + (1000 / 2d), z + (1000 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)))
							.sendStatusMessage(new StringTextComponent("One of your friendly spiders has just been killed."), (false));
		}
	}
}
