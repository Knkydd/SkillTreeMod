package com.example.skilltreemod.gui.buttons;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ProgressStatsButton extends Button {
    public ProgressStatsButton(Screen parentScreen, int x, int y){
        super(
                x, y, 25, 25, Component.literal("^"), button -> {
                    // В разработке
                },
                Button.DEFAULT_NARRATION
        );
    }

    public static ProgressStatsButton createDown(Screen screen){
        int x = 3 + screen.width / 2;
        int y = 3 + screen.width / 2;
        return new ProgressStatsButton(screen, x, y);
    }
}
