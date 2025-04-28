package com.example.skilltreemod.gui.subscreens;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class SkillPointsScreen extends Screen {
    public SkillPointsScreen(){
        super(Component.literal(""));
    }

    @Override
    protected void init(){

    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks){
        guiGraphics.fill(3, 3, 100, 150, 0);
        guiGraphics.drawString(
                Minecraft.getInstance().font,
                "Очки Навыков: 0",
                20, 20,
                0x00FF00
        );
    }

    public boolean isPauseScreen(){
        return false;
    }
}