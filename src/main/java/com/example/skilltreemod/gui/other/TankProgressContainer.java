package com.example.skilltreemod.gui.other;

import com.example.skilltreemod.gui.subscreens.TankClassScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;

public class TankProgressContainer extends ProgressContainer{
    public TankProgressContainer(int x, int y, int width, int height, Screen parentScreen){
        super(x,y,width,height,parentScreen);
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        // 1. Рендер основного фона
        renderBackground(guiGraphics);

        // 2. Рендер дополнительных элементов
        renderContent(guiGraphics, mouseX, mouseY, delta);

        // 3. Рендер прогресс-бара
        renderProgressBar(guiGraphics);

        // 4. Обработка hover-эффектов
        if (isHovered()) {
            renderHoverEffect(guiGraphics, mouseX, mouseY);
        }
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        Minecraft.getInstance().setScreen(new TankClassScreen(parentScreen));
    }
}
