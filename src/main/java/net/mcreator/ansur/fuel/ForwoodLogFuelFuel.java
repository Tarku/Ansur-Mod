
package net.mcreator.ansur.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.ansur.block.ForwoodBlock;
import net.mcreator.ansur.AnsurModElements;

@AnsurModElements.ModElement.Tag
public class ForwoodLogFuelFuel extends AnsurModElements.ModElement {
	public ForwoodLogFuelFuel(AnsurModElements instance) {
		super(instance, 169);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(ForwoodBlock.block, (int) (1)).getItem())
			event.setBurnTime(300);
	}
}
