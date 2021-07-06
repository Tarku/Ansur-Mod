
package net.mcreator.ansur.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.ansur.item.PoweredCoalItem;
import net.mcreator.ansur.AnsurModElements;

@AnsurModElements.ModElement.Tag
public class PoweredCoalFuelFuel extends AnsurModElements.ModElement {
	public PoweredCoalFuelFuel(AnsurModElements instance) {
		super(instance, 182);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(PoweredCoalItem.block, (int) (1)).getItem())
			event.setBurnTime(11000);
	}
}
