package com.example.skilltreemod.gui.subscreens;

import com.example.skilltreemod.gui.buttons.CloseButton;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

public class InfoScreen extends Screen {
    private final Screen parentScreen;
    private int windowWidth = 200;
    private int windowHeight = 250;
    private int leftPos;
    private int topPos;

    public InfoScreen(Screen parentScreen) {
        super(Component.literal("Информация"));
        this.parentScreen = parentScreen;
    }

    @Override
    protected void init() {
        super.init();

        this.leftPos = (this.width - windowWidth) / 2;
        this.topPos = (this.height - windowHeight) / 2;

        this.addRenderableWidget(
                CloseButton.createTopRight(this, leftPos + 30, topPos + 5));
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.parentScreen.render(guiGraphics, mouseX, mouseY, partialTicks);
        guiGraphics.fill(0, 0, this.width, this.height, 0x80000000);

        guiGraphics.fill(leftPos, topPos, leftPos + windowWidth, topPos + windowHeight, 0xFF222222);
        guiGraphics.fill(leftPos + 1, topPos + 1, leftPos + windowWidth - 1, topPos + windowHeight - 1, 0xFF555555);

        guiGraphics.drawCenteredString(this.font, this.title,
                leftPos + windowWidth / 2, topPos + 10, 0xFFFFFF);

        guiGraphics.drawCenteredString(this.font,
                Component.literal("В разработке").withStyle(ChatFormatting.WHITE),
                leftPos + windowWidth / 2, topPos + windowHeight / 2 - 10, 0xFFFFFF);

        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }

    @Override
    public void onClose() {
        assert this.minecraft != null;
        this.minecraft.setScreen(parentScreen);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}