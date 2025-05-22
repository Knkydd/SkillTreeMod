package com.example.skilltreemod.gui.other;

import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ProgressContainer extends AbstractWidget {
    private float progress;
    protected Screen parentScreen;
    private int progressColor = 0xFF00FF00;
    //private final ResourceLocation texture = new ResourceLocation("skilltreemod", "textures/gui/background.png");

    public ProgressContainer(int x, int y, int width, int height, Screen parentScreen) {
        super(x, y, width, height, Component.empty());
        this.progress = 0.0f;
        this.parentScreen = parentScreen;
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);

        renderContent(guiGraphics, mouseX, mouseY, delta);

        renderProgressBar(guiGraphics);

        if (isHovered()) {
            renderHoverEffect(guiGraphics, mouseX, mouseY);
        }
    }

    protected void renderBackground(GuiGraphics guiGraphics) {
//        guiGraphics.blitNineSliced(
//                texture,
//                getX(), getY(),
//                width, height,
//                10, 10, 10, 10, // Границы (top, right, bottom, left)
//                256, 256 // Размер исходной текстуры
//        );
        guiGraphics.fill(
                getX(), getY(),
                getX() + width, getY() + height,
                0xFF252525 // Тёмный фон
        );
    }

    protected void renderProgressBar(GuiGraphics guiGraphics) {
        int progressWidth = (int)(width * progress);
        guiGraphics.fill(
                getX(), getY() + height - 4,
                getX() + progressWidth, getY() + height,
                progressColor
        );
    }

    protected void renderContent(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        // ...
    }

    protected void renderHoverEffect(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.renderOutline(getX(), getY(), width, height, 0x80FFFFFF);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        // ...
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput output) {
        // ...
    }
}