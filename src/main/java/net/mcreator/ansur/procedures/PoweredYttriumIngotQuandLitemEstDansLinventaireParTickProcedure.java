package net.mcreator.ansur.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.ansur.AnsurModElements;
import net.mcreator.ansur.AnsurMod;

import java.util.Map;
import java.util.Iterator;

@AnsurModElements.ModElement.Tag
public class PoweredYttriumIngotQuandLitemEstDansLinventaireParTickProcedure extends AnsurModElements.ModElement {
	public PoweredYttriumIngotQuandLitemEstDansLinventaireParTickProcedure(AnsurModElements instance) {
		super(instance, 210);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AnsurMod.LOGGER.warn("Failed to load dependency entity for procedure PoweredYttriumIngotQuandLitemEstDansLinventaireParTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof ServerPlayerEntity) {
			Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
					.getAdvancement(new ResourceLocation("ansur:powered_yttrium_get"));
			AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
			if (!_ap.isDone()) {
				Iterator _iterator = _ap.getRemaningCriteria().iterator();
				while (_iterator.hasNext()) {
					String _criterion = (String) _iterator.next();
					((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
				}
			}
		}
	}
}
