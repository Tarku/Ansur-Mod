package net.mcreator.ansur.procedures;

import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.FluidStack;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.Blocks;

import net.mcreator.ansur.AnsurModElements;
import net.mcreator.ansur.AnsurMod;

import java.util.Map;

@AnsurModElements.ModElement.Tag
public class FluidTankMiseAJourDuTickProcedure extends AnsurModElements.ModElement {
	public FluidTankMiseAJourDuTickProcedure(AnsurModElements instance) {
		super(instance, 205);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AnsurMod.LOGGER.warn("Failed to load dependency x for procedure FluidTankMiseAJourDuTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AnsurMod.LOGGER.warn("Failed to load dependency y for procedure FluidTankMiseAJourDuTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AnsurMod.LOGGER.warn("Failed to load dependency z for procedure FluidTankMiseAJourDuTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AnsurMod.LOGGER.warn("Failed to load dependency world for procedure FluidTankMiseAJourDuTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() instanceof FlowingFluidBlock)
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() instanceof FlowingFluidBlock))) {
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				int _amount = (int) 1000;
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> capability.fill(new FluidStack(Fluids.WATER, _amount), IFluidHandler.FluidAction.EXECUTE));
			}
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), Blocks.AIR.getDefaultState(), 3);
		}
	}
}
