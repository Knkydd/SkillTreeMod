package com.example.skilltreemod.gui.other;

import com.example.skilltreemod.gui.subscreens.TankClassScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;

public class TankContainer extends ClassContainer {
    public TankContainer(int x, int y, int width, int height, Screen parentScreen){
        super(x,y,width,height,parentScreen);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        Minecraft.getInstance().setScreen(new TankClassScreen(parentScreen));
    }
}
