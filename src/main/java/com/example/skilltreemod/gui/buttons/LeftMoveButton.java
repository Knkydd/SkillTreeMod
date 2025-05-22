package com.example.skilltreemod.gui.buttons;

import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

public class LeftMoveButton extends Button {
    private LeftMoveButton(int x, int y){
        super(
                x,y,25,25, Component.literal("<"), button -> {

                }, Button.DEFAULT_NARRATION
        );
    }

    public static LeftMoveButton createLeftMoveButton(int x, int y){
        return new LeftMoveButton(x, y);
    }
}
