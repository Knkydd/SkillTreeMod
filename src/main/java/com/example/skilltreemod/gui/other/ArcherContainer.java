package com.example.skilltreemod.gui.other;

import com.example.skilltreemod.gui.subscreens.ArcherClassScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.resources.ResourceLocation;

public class ArcherContainer extends ClassContainer {
    public ArcherContainer(int x, int y, int width, int height, Screen parentScreen){
        super(x,y,width,height,parentScreen);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        Minecraft.getInstance().setScreen(new ArcherClassScreen(parentScreen));
    }

    @Override
    protected void renderBackground(GuiGraphics guiGraphics) {
        ResourceLocation texture = new ResourceLocation("skilltreemod", "textures/gui/archer_background.jpg");
        guiGraphics.blit(texture, this.getX(), this.getY(), 0, 0, this.width, this.height, this.width, this.height);
    }
}
