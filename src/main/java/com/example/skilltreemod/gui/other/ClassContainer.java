package com.example.skilltreemod.gui.other;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;

public class ClassContainer extends AbstractWidget {
    private float progress;
    protected Screen parentScreen;
    private int progressColor = 0xFF00FF7F;
    private int remainingColor = 0xFF3A3A3A;
    private boolean isHovered = false;
    private boolean isProgressBarHovered = false;

    private final int progressBarHeight = 20;
    private final int progressBarWidthReduction = 10;
    private final int progressBarTopMargin = 10;

    public ClassContainer(int x, int y, int width, int height, Screen parentScreen) {
        super(x, y, width, height, Component.empty());
        this.progress = 0.4f; // пока так для тестов
        this.parentScreen = parentScreen;
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        updateHoverState(mouseX, mouseY);
        renderBackground(guiGraphics);
        renderContent(guiGraphics, mouseX, mouseY, delta);

        if (shouldShowProgressBar()) {
            renderFullProgressBar(guiGraphics);
        }

        renderHoverEffects(guiGraphics, mouseX, mouseY);
    }

    private void renderFullProgressBar(GuiGraphics guiGraphics) {
        int innerWidth = width - progressBarWidthReduction * 2;
        int progressWidth = (int)(innerWidth * progress);
        int progressY = getY() + height - progressBarHeight - progressBarTopMargin;

        guiGraphics.fill(
                getX() + progressBarWidthReduction,
                progressY,
                getX() + progressBarWidthReduction + innerWidth,
                progressY + progressBarHeight,
                remainingColor
        );

        if (progress > 0) {
            // Основная заливка
            guiGraphics.fill(
                    getX() + progressBarWidthReduction,
                    progressY,
                    getX() + progressBarWidthReduction + progressWidth,
                    progressY + progressBarHeight,
                    progressColor
            );

            guiGraphics.fill(
                    getX() + progressBarWidthReduction,
                    progressY,
                    getX() + progressBarWidthReduction + progressWidth,
                    progressY + 1,
                    0x80FFFFFF
            );

            if (isProgressBarHovered) {
                guiGraphics.fill(
                        getX() + progressBarWidthReduction,
                        progressY + progressBarHeight - 2,
                        getX() + progressBarWidthReduction + progressWidth,
                        progressY + progressBarHeight,
                        0x4000FFAA
                );
            }
        }
    }

    private void updateHoverState(double mouseX, double mouseY) {
        this.isHovered = isMouseOver(mouseX, mouseY);
        this.isProgressBarHovered = isMouseOverProgressBar(mouseX, mouseY);
    }

    private boolean isMouseOverProgressBar(double mouseX, double mouseY) {
        return mouseX >= getX() + progressBarWidthReduction &&
                mouseX <= getX() + width - progressBarWidthReduction &&
                mouseY >= getY() + height - progressBarHeight - progressBarTopMargin &&
                mouseY <= getY() + height - progressBarTopMargin;
    }

    private boolean shouldShowProgressBar() {
        return isHovered || isProgressBarHovered;
    }

    protected void renderBackground(GuiGraphics guiGraphics) {
        guiGraphics.fill(
                getX(), getY(),
                getX() + width, getY() + height,
                0xFF252525
        );
    }

    protected void renderContent(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        // ...
    }

    protected void renderHoverEffects(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        if (isHovered) {
            guiGraphics.renderOutline(getX(), getY(), width, height, 0x80FFFFFF);
        }

        if (isProgressBarHovered) {
            renderProgressTooltip(guiGraphics, mouseX, mouseY);
        }
    }

    private void renderProgressTooltip(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.renderTooltip(
                Minecraft.getInstance().font,
                Component.literal("Прогресс: " + (int)(progress * 100) + "%"),
                mouseX, mouseY
        );
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