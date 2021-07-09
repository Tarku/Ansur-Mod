
package net.mcreator.ansur.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;

import net.mcreator.ansur.procedures.FriendlySpiderThisEntityKillsAnotherOneProcedure;
import net.mcreator.ansur.procedures.FriendlySpiderEntityDiesProcedure;
import net.mcreator.ansur.item.SpiderSwordItem;
import net.mcreator.ansur.entity.renderer.FriendlySpiderRenderer;
import net.mcreator.ansur.AnsurModElements;

import java.util.Map;
import java.util.HashMap;

@AnsurModElements.ModElement.Tag
public class FriendlySpiderEntity extends AnsurModElements.ModElement {
	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
			.size(1.4f, 0.9f)).build("friendly_spider").setRegistryName("friendly_spider");
	public FriendlySpiderEntity(AnsurModElements instance) {
		super(instance, 53);
		FMLJavaModLoadingContext.get().getModEventBus().register(new FriendlySpiderRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}
	private static class EntityAttributesRegisterHandler {
		@SubscribeEvent
		public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.4);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 16);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 1);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 5);
			event.put(entity, ammma.create());
		}
	}

	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, (float) 0.8));
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, RockwoodRogueEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, DaneZombieEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, ForrockSpiderEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, ForwoodSpiderEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, ZombieEntity.class, false, false));
			this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, SkeletonEntity.class, false, false));
			this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, CreeperEntity.class, false, false));
			this.targetSelector.addGoal(10, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(11,
					new TemptGoal(this, 1.2, Ingredient.fromItems(new ItemStack(SpiderSwordItem.block, (int) (1)).getItem()), false));
			this.goalSelector.addGoal(12, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.ARTHROPOD;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.break"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof PlayerEntity)
				return false;
			if (source == DamageSource.FALL)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void onDeath(DamageSource source) {
			super.onDeath(source);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity sourceentity = source.getTrueSource();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				FriendlySpiderEntityDiesProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
			super.awardKillScore(entity, score, damageSource);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity sourceentity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				FriendlySpiderThisEntityKillsAnotherOneProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
