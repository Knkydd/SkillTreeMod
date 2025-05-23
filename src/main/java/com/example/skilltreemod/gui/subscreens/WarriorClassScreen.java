package com.example.skilltreemod.gui.subscreens;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class WarriorClassScreen extends ClassesScreen {
    private int availablePoints = 3;
    public WarriorClassScreen(Screen parentScreen) {
        super(parentScreen);
    }

    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {

        super.render(guiGraphics, mouseX, mouseY, partialTick);

        renderTitle(guiGraphics);

        renderContentArea(guiGraphics);
    }

    private void renderTitle(GuiGraphics guiGraphics) {
        Component title = Component.literal("Воин").withStyle(ChatFormatting.BOLD);
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

        Component pointsText = Component.literal("Доступно очков: " + availablePoints)
                .withStyle(ChatFormatting.BOLD);

        int pointsX = leftPos + (windowWidth - font.width(pointsText)) / 2;
        int pointsY = contentTop + 35;

        guiGraphics.drawString(
                font,
                pointsText,
                pointsX,
                pointsY,
                0xffffff,
                false
        );

        int skillsAreaTop = contentTop + 55;
        guiGraphics.fill(
                contentLeft,
                skillsAreaTop,
                contentLeft + contentWidth,
                contentTop + contentHeight,
                0xFF0F0F0F
        );
    }
}
