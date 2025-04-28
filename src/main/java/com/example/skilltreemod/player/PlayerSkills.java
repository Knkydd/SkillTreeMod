package com.example.skilltreemod.player;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PlayerSkills {
    private int playerID;
    private int minerSkill;
    private int warriorSkill;
    private int archerSkill;
    private int blacksmithSkill;
    private int travelerSkill;

    public PlayerSkills() {
        this.minerSkill = 0;
        this.warriorSkill = 0;
        this.archerSkill = 0;
        this.blacksmithSkill = 0;
        this.travelerSkill = 0;
    }
}
