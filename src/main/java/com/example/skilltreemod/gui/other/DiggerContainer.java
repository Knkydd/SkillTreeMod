package com.example.skilltreemod.gui.other;

import com.example.skilltreemod.gui.subscreens.DiggerClassScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;

public class DiggerContainer extends ClassContainer {
    public DiggerContainer(int x, int y, int width, int height, Screen parentScreen){
        super(x,y,width,height,parentScreen);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        Minecraft.getInstance().setScreen(new DiggerClassScreen(parentScreen));
    }
}
