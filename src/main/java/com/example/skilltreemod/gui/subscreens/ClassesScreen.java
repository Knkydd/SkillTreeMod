package com.example.skilltreemod.gui.subscreens;

import com.example.skilltreemod.gui.buttons.CloseButton;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ClassesScreen extends Screen {
    protected final Screen parentScreen;
    protected int windowWidth = 200;
    protected int windowHeight = 250;
    protected int leftPos;
    protected int topPos;

    public ClassesScreen(Screen parentScreen) {
        super(Component.literal(""));
        this.parentScreen = parentScreen;
    }

    @Override
    public void init() {
        super.init();

        this.leftPos = (this.width - windowWidth) / 2;
        this.topPos = (this.height - windowHeight) / 2;

        this.addRenderableWidget(CloseButton.createTopRight(this, leftPos + 30, topPos + 5));
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.parentScreen.render(guiGraphics, mouseX, mouseY, partialTicks);

        guiGraphics.fill(0, 0, this.width, this.height, 0x80000000);

        guiGraphics.fill(leftPos, topPos, leftPos + windowWidth, topPos + windowHeight, 0xFF222222);
        guiGraphics.fill(leftPos + 1, topPos + 1, leftPos + windowWidth - 1, topPos + windowHeight - 1, 0xFF555555);

        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public void onClose() {
        assert this.minecraft != null;
        this.minecraft.setScreen(parentScreen);
    }
}
