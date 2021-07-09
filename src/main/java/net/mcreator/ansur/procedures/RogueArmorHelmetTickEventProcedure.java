package net.mcreator.ansur.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.ansur.AnsurModElements;
import net.mcreator.ansur.AnsurMod;

import java.util.Map;

@AnsurModElements.ModElement.Tag
public class RogueArmorHelmetTickEventProcedure extends AnsurModElements.ModElement {
	public RogueArmorHelmetTickEventProcedure(AnsurModElements instance) {
		super(instance, 122);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AnsurMod.LOGGER.warn("Failed to load dependency entity for procedure RogueArmorHelmetTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 12, (int) 0, (true), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 12, (int) 0, (true), (false)));
	}
}
