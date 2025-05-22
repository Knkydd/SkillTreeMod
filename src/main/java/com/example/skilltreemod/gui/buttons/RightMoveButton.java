package com.example.skilltreemod.gui.buttons;

import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

public class RightMoveButton extends Button {
    private RightMoveButton(int x, int y){
        super(
                x,y,25,25, Component.literal(">"), button -> {

                }, Button.DEFAULT_NARRATION
        );
    }

    public static RightMoveButton createLeftMoveButton(int x, int y){
        return new RightMoveButton(x, y);
    }
}
