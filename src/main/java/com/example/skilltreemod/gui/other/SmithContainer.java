package com.example.skilltreemod.gui.other;

import com.example.skilltreemod.gui.subscreens.SmithClassScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;

public class SmithContainer extends ClassContainer {
    public SmithContainer(int x, int y, int width, int height, Screen parentScreen){
        super(x,y,width,height,parentScreen);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        Minecraft.getInstance().setScreen(new SmithClassScreen(parentScreen));
    }
}
