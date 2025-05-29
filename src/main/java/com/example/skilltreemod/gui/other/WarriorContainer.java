package com.example.skilltreemod.gui.other;

import com.example.skilltreemod.gui.subscreens.WarriorClassScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.resources.ResourceLocation;

public class WarriorContainer extends ClassContainer {
    public WarriorContainer(int x, int y, int width, int height, Screen parentScreen){
        super(x,y,width,height,parentScreen);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        Minecraft.getInstance().setScreen(new WarriorClassScreen(parentScreen));
    }

    @Override
    public void renderBackground(GuiGraphics guiGraphics) {
        ResourceLocation texture = new ResourceLocation("skilltreemod", "textures/gui/warrior_background.jpg");
        guiGraphics.blit(texture, this.getX(), this.getY(), 0, 0, this.width, this.height, this.width, this.height);
    }
}
