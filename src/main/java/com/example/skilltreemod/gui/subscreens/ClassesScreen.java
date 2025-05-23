package com.example.skilltreemod.gui.subscreens;

import com.example.skilltreemod.gui.buttons.CloseButton;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ClassesScreen extends Screen {
    protected final Screen parentScreen;
    protected int windowWidth;
    protected int windowHeight;
    protected int leftPos;
    protected int topPos;

    protected static final int BACKGROUND_COLOR = 0x90000000;
    protected static final int WINDOW_COLOR = 0xFF1A1A1A;
    protected static final int BORDER_COLOR = 0xFF3A3A3A;
    protected static final int TITLE_COLOR = 0xFFD7D7D7;
    protected static final int CONTENT_COLOR = 0xFF121212;

    public ClassesScreen(Screen parentScreen) {
        super(Component.literal(""));
        this.parentScreen = parentScreen;
    }

    @Override
    public void init() {
        super.init();

        this.windowWidth = (int)(this.width * 0.8f);
        this.windowHeight = (int)(this.height * 0.8f);
        this.leftPos = (this.width - windowWidth) / 2;
        this.topPos = (this.height - windowHeight) / 2;

        // Добавляем кнопку закрытия
        this.addRenderableWidget(CloseButton.createTopRight(this, leftPos, topPos));
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.parentScreen.render(guiGraphics,mouseX,mouseY,partialTick);

        renderBackground(guiGraphics);

        renderMainWindow(guiGraphics);

        renderTitle(guiGraphics);

        renderContentArea(guiGraphics);

        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }

    public void renderBackground(GuiGraphics guiGraphics) {
        guiGraphics.fill(0, 0, width, height, BACKGROUND_COLOR);
    }

    private void renderMainWindow(GuiGraphics guiGraphics) {
        guiGraphics.fill(leftPos, topPos, leftPos + windowWidth, topPos + windowHeight, WINDOW_COLOR);

        guiGraphics.renderOutline(leftPos, topPos, windowWidth, windowHeight, BORDER_COLOR);
    }

    private void renderTitle(GuiGraphics guiGraphics) {
        Component title = Component.literal("").withStyle(ChatFormatting.BOLD);
        int titleX = leftPos + (windowWidth - font.width(title)) / 2;
        int titleY = topPos + 15;

        guiGraphics.drawString(font, title, titleX, titleY, TITLE_COLOR, false);
    }

    private void renderContentArea(GuiGraphics guiGraphics) {
        int contentLeft = leftPos + 10;
        int contentTop = topPos + 40;
        int contentWidth = windowWidth - 20;
        int contentHeight = windowHeight - 50;

        guiGraphics.fill(contentLeft, contentTop, contentLeft + contentWidth, contentTop + contentHeight, CONTENT_COLOR);

        guiGraphics.hLine(contentLeft, contentLeft + contentWidth, contentTop + 30, BORDER_COLOR);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void onClose() {
        assert this.minecraft != null;
        this.minecraft.setScreen(parentScreen);
    }
}
