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
public class FriendlySpiderThisEntityKillsAnotherOneProcedure extends AnsurModElements.ModElement {
	public FriendlySpiderThisEntityKillsAnotherOneProcedure(AnsurModElements instance) {
		super(instance, 128);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AnsurMod.LOGGER.warn("Failed to load dependency entity for procedure FriendlySpiderThisEntityKillsAnotherOne!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AnsurMod.LOGGER.warn("Failed to load dependency x for procedure FriendlySpiderThisEntityKillsAnotherOne!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AnsurMod.LOGGER.warn("Failed to load dependency y for procedure FriendlySpiderThisEntityKillsAnotherOne!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AnsurMod.LOGGER.warn("Failed to load dependency z for procedure FriendlySpiderThisEntityKillsAnotherOne!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AnsurMod.LOGGER.warn("Failed to load dependency world for procedure FriendlySpiderThisEntityKillsAnotherOne!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		String deathVerb = "";
		if ((Math.random() < 0.2)) {
			deathVerb = (String) "eviscerated a ";
		} else if (((Math.random() > 0.2) && (Math.random() < 0.4))) {
			deathVerb = (String) "bited to death a ";
		} else if (((Math.random() > 0.4) && (Math.random() < 0.6))) {
			deathVerb = (String) "fractured the skull of a ";
		} else if (((Math.random() > 0.6) && (Math.random() < 0.8))) {
			deathVerb = (String) "teared down the spine of a ";
		} else if ((Math.random() > 0.8)) {
			deathVerb = (String) "killed a ";
		}
		if (((Entity) world
				.getEntitiesWithinAABB(PlayerEntity.class,
						new AxisAlignedBB(x - (500 / 2d), y - (500 / 2d), z - (500 / 2d), x + (500 / 2d), y + (500 / 2d), z + (500 / 2d)), null)
				.stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof PlayerEntity
				&& !((Entity) world.getEntitiesWithinAABB(PlayerEntity.class,
						new AxisAlignedBB(x - (500 / 2d), y - (500 / 2d), z - (500 / 2d), x + (500 / 2d), y + (500 / 2d), z + (500 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).world.isRemote()) {
			((PlayerEntity) ((Entity) world
					.getEntitiesWithinAABB(PlayerEntity.class,
							new AxisAlignedBB(x - (500 / 2d), y - (500 / 2d), z - (500 / 2d), x + (500 / 2d), y + (500 / 2d), z + (500 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)))
							.sendStatusMessage(new StringTextComponent((("One of your friendly spiders has succesfully ") + ""
									+ ((((deathVerb)) + "" + ((((entity.getDisplayName().getString())) + "" + ("."))))))), (false));
		}
	}
}
