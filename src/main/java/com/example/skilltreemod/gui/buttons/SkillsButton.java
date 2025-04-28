package com.example.skilltreemod.gui.buttons;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class SkillsButton extends Button {
    public SkillsButton(Screen parentScreen, int x, int y){
        super(
                x, y, 25, 25, Component.literal("≡"), button -> {
                    // В разработке
                },
                Button.DEFAULT_NARRATION
        );
    }

    public static SkillsButton createMiddle(Screen screen){
        int x = screen.width - 30;
        int y = 3 + screen.width / 4;
        return new SkillsButton(screen, x, y);
    }
}
