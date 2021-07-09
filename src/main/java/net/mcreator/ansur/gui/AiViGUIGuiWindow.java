
package net.mcreator.ansur.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.ansur.AnsurMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class AiViGUIGuiWindow extends ContainerScreen<AiViGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public AiViGUIGuiWindow(AiViGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 177;
		this.ySize = 196;
	}
	private static final ResourceLocation texture = new ResourceLocation("ansur:textures/ai_vi_gui.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ansur:textures/ginta_item.png"));
		this.blit(ms, this.guiLeft + 129, this.guiTop + 18, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ansur:textures/ginta_berries.png"));
		this.blit(ms, this.guiLeft + 149, this.guiTop + 18, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ansur:textures/ginta_berries.png"));
		this.blit(ms, this.guiLeft + 128, this.guiTop + 32, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ansur:textures/bullet.png"));
		this.blit(ms, this.guiLeft + 148, this.guiTop + 34, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ansur:textures/ginta_berries.png"));
		this.blit(ms, this.guiLeft + 128, this.guiTop + 47, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ansur:textures/ginta_berries.png"));
		this.blit(ms, this.guiLeft + 128, this.guiTop + 63, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ansur:textures/rogue_soul.png"));
		this.blit(ms, this.guiLeft + 149, this.guiTop + 63, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("ansur:textures/gun.png"));
		this.blit(ms, this.guiLeft + 142, this.guiTop + 44, 0, 0, 24, 24, 24, 24);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Aiden Villager", 7, 4, -12829636);
		this.font.drawString(ms, "IN", 16, 24, -16776961);
		this.font.drawString(ms, "OUT", 52, 24, -65536);
		this.font.drawString(ms, "Prices", 133, 8, -12829636);
		this.font.drawString(ms, "12", 119, 21, -12829636);
		this.font.drawString(ms, "1", 164, 21, -12829636);
		this.font.drawString(ms, "9", 122, 36, -12829636);
		this.font.drawString(ms, "24", 161, 37, -12829636);
		this.font.drawString(ms, "24", 118, 50, -12829636);
		this.font.drawString(ms, "1", 167, 51, -12829636);
		this.font.drawString(ms, "48", 118, 66, -12829636);
		this.font.drawString(ms, "1", 166, 67, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 26, this.guiTop + 64, 30, 20, new StringTextComponent("Trade"), e -> {
			if (true) {
				AnsurMod.PACKET_HANDLER.sendToServer(new AiViGUIGui.ButtonPressedMessage(0, x, y, z));
				AiViGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
