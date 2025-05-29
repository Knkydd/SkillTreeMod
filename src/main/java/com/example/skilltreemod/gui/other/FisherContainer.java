package com.example.skilltreemod.gui.other;

import com.example.skilltreemod.gui.subscreens.FisherClassScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.resources.ResourceLocation;

public class FisherContainer extends ClassContainer {
    public FisherContainer(int x, int y, int width, int height, Screen parentScreen){
        super(x,y,width,height,parentScreen);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        Minecraft.getInstance().setScreen(new FisherClassScreen(parentScreen));
    }

    @Override
    public void renderBackground(GuiGraphics guiGraphics) {
        ResourceLocation texture = new ResourceLocation("skilltreemod", "textures/gui/fisher_background.jpg");
        guiGraphics.blit(texture, this.getX(), this.getY(), 0, 0, this.width, this.height, this.width, this.height);
    }
}
