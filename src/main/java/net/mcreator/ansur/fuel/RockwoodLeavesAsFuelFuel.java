
package net.mcreator.ansur.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.ansur.block.RockwoodLeavesBlock;
import net.mcreator.ansur.AnsurModElements;

@AnsurModElements.ModElement.Tag
public class RockwoodLeavesAsFuelFuel extends AnsurModElements.ModElement {
	public RockwoodLeavesAsFuelFuel(AnsurModElements instance) {
		super(instance, 193);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(RockwoodLeavesBlock.block, (int) (1)).getItem())
			event.setBurnTime(35);
	}
}
