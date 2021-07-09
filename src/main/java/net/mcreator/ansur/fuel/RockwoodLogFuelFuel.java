
package net.mcreator.ansur.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.ansur.block.RockwoodLogBlock;
import net.mcreator.ansur.AnsurModElements;

@AnsurModElements.ModElement.Tag
public class RockwoodLogFuelFuel extends AnsurModElements.ModElement {
	public RockwoodLogFuelFuel(AnsurModElements instance) {
		super(instance, 171);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(RockwoodLogBlock.block, (int) (1)).getItem())
			event.setBurnTime(300);
	}
}
