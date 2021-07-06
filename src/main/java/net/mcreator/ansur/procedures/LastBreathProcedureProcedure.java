package net.mcreator.ansur.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.ansur.enchantment.LastBreathEnchantment;
import net.mcreator.ansur.AnsurModElements;
import net.mcreator.ansur.AnsurMod;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

@AnsurModElements.ModElement.Tag
public class LastBreathProcedureProcedure extends AnsurModElements.ModElement {
	public LastBreathProcedureProcedure(AnsurModElements instance) {
		super(instance, 79);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AnsurMod.LOGGER.warn("Failed to load dependency entity for procedure LastBreathProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = 0;
		String y = "";
		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
				/ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)) < 0.2)) {
			y = (String) "0";
			while ((!(((y)).equals("0000")))) {
				if (((((((entity instanceof LivingEntity)
						? ((LivingEntity) entity)
								.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) ((y)).length()))
						: ItemStack.EMPTY)).isEnchanted())
						&& ((EnchantmentHelper.getEnchantmentLevel(LastBreathEnchantment.enchantment,
								((entity instanceof LivingEntity)
										? ((LivingEntity) entity).getItemStackFromSlot(
												EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) ((y)).length()))
										: ItemStack.EMPTY))) > 0))
						&& (!(new Object() {
							boolean check(Entity _entity) {
								if (_entity instanceof LivingEntity) {
									Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
									for (EffectInstance effect : effects) {
										if (effect.getPotion() == Effects.REGENERATION)
											return true;
									}
								}
								return false;
							}
						}.check(entity))))) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 20,
								(int) (EnchantmentHelper.getEnchantmentLevel(LastBreathEnchantment.enchantment,
										((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getItemStackFromSlot(
														EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) ((y)).length()))
												: ItemStack.EMPTY)))));
				}
				y = (String) (((y)) + "" + ("0"));
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
