package com.example.skilltreemod.gui.buttons;

import com.example.skilltreemod.gui.subscreens.InfoScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class InfoButton extends Button {

    public InfoButton(Screen parentScreen, int x, int y) {
        super(
                x,
                y,
                25,
                25,
                Component.literal("?"),
                button -> {
                    parentScreen.getMinecraft().setScreen(new InfoScreen(parentScreen));
                },
                Button.DEFAULT_NARRATION
        );
    }

    public static InfoButton createTopRight(Screen screen, int rightOffset, int topOffset) {
        int x = screen.width - rightOffset;
        int y = topOffset;
        return new InfoButton(screen, x, y);
    }
}