
package net.mcreator.ansur.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.ansur.block.DanewoodLogBlock;
import net.mcreator.ansur.AnsurModElements;

@AnsurModElements.ModElement.Tag
public class DanewoodLogFuelFuel extends AnsurModElements.ModElement {
	public DanewoodLogFuelFuel(AnsurModElements instance) {
		super(instance, 170);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(DanewoodLogBlock.block, (int) (1)).getItem())
			event.setBurnTime(300);
	}
}
