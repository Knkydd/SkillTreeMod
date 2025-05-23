package com.example.skilltreemod.gui.buttons;

import com.example.skilltreemod.gui.subscreens.InfoScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class InfoButton extends Button {

    public InfoButton(Screen screen, int x, int y) {
        super(
                x,
                y,
                25,
                25,
                Component.literal("?"),
                button -> {
                    screen.getMinecraft().setScreen(new InfoScreen(screen));
                },
                Button.DEFAULT_NARRATION
        );
    }

    public static InfoButton createInfoButton(Screen screen, int rightOffset, int topOffset) {
        int x = screen.width - rightOffset;
        int y = topOffset;
        return new InfoButton(screen, x, y);
    }
}