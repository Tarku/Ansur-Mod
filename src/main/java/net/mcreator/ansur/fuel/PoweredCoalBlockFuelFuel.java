
package net.mcreator.ansur.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.ansur.block.PoweredCoalBlockBlock;
import net.mcreator.ansur.AnsurModElements;

@AnsurModElements.ModElement.Tag
public class PoweredCoalBlockFuelFuel extends AnsurModElements.ModElement {
	public PoweredCoalBlockFuelFuel(AnsurModElements instance) {
		super(instance, 183);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(PoweredCoalBlockBlock.block, (int) (1)).getItem())
			event.setBurnTime(99000);
	}
}
