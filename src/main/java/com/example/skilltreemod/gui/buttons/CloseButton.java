package com.example.skilltreemod.gui.buttons;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class CloseButton extends Button {

    public CloseButton(Screen screen, int x, int y) {
        super(
                x,
                y,
                25,
                25,
                Component.literal("×"),
                button -> {
                    screen.onClose();
                },
                Button.DEFAULT_NARRATION
        );
    }

    public static CloseButton createTopRight(Screen screen, int rightOffset, int topOffset) {
        int x = screen.width - rightOffset;
        int y = topOffset;
        return new CloseButton(screen, x, y);
    }
}