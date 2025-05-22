package com.example.skilltreemod.gui.subscreens;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class WarriorClassScreen extends ClassesScreen {
    public WarriorClassScreen(Screen parentScreen) {
        super(parentScreen);
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        guiGraphics.drawCenteredString(this.font, this.title,
                leftPos + windowWidth / 2, topPos + 10, 0xFFFFFF);

        guiGraphics.drawCenteredString(this.font,
                Component.literal("Воин").withStyle(ChatFormatting.WHITE),
                leftPos + windowWidth / 2, topPos + windowHeight / 2 - 10, 0xFFFFFF);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }
}
