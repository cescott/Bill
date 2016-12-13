package com.andersonescott.bill.objects.items;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class WeaponFactory {

    /*
    -
    -
    -
    -
    All weapon types should be capitalized,
    or you could like
    fix it
    or something
    idc
    -
    -
    -
    -
     */

    protected String[] sword = {
            "Swanky",
            "S-s-s-",
            "Slippery",
            "Serpent",
            "Silly",
            "Super",
            "Dord",
            "Sword",
            "Stabby",
            "Purple",
            "Sonofa",
            "Sparkle",
            "Radish",
            "Smol",
    };
    protected String[] dagger = {
            "D-d-d-",
            "Dagger",
            "Purple",
            "Dingle",
            "Dongle",
            "Didgeri",
            "Dad-",
    };
    protected String[] staff = {
            "Swanky",
            "S-s-s-",
            "Slippery",
            "Serpent",
            "Silly",
            "Super",
            "Stabby",
            "Purple",
            "Sonofa",
            "Sparkle",
            "Staff",
            "Smol",
    };
    protected String[] hammer = {
            "Hella",
            "Hhhh",
            "Hammer",
            "Purple",
            "Yuuge",

    };
    protected static ArrayList<String> swordNames;
    protected static ArrayList<String> daggerNames;
    protected static ArrayList<String> staffNames;
    protected static ArrayList<String> hammerNames;

    protected String[] effects = {
            "Power",    "Power",    "Power",
            "Mana",     "Mana",     "Mana",     "Mana",     "Mana",     "Mana",
            "Health",   "Health",   "Health",   "Health",   "Health",
            "HealthRep",
            "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A",
            "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A"
    };

    public WeaponFactory() {
        for (int i = 0; i < sword.length; i++) {
            swordNames.add(sword[i]);
        }
        for (int i = 0; i < dagger.length; i++) {
            daggerNames.add(dagger[i]);
        }
        for (int i = 0; i < staff.length; i++) {
            staffNames.add(staff[i]);
        }
        for (int i = 0; i < hammer.length; i++) {
            hammerNames.add(hammer[i]);
        }
    }

    public Weapon makeWeapon(int playerLvl, String weaponType) {
        while (true) {
        int level;
        String type;
        String name;

        int dmgInt = (int)(Math.random()*80) + 20;
        int critInt = (int)(Math.random()*80) + 20;
        int manaRepInt = (int)(Math.random()*80) + 20;

        double dmgPercent = dmgInt/(dmgInt + critInt + manaRepInt);
        double critPercent = critInt/(dmgInt + critInt + manaRepInt);
        double manaRepPercent = manaRepInt/(dmgInt + critInt + manaRepInt);

        if (dmgPercent >= .5) {
            type = "Hammer";
            if (!weaponType.equals("Hammer")) {
                continue;
            }
                name = hammerNames.remove((int) (Math.random() * hammerNames.size())) + "hammer";
                if (hammerNames.size() == 0) {
                    for (int i = 0; i < hammer.length; i++) {
                        hammerNames.add(hammer[i]);
                    }
                }
            }
        else if (critPercent >= .5) {
            if (!weaponType.equals("Dagger")) {
                continue;
            }
                type = "Dagger";
                name = daggerNames.remove((int) (Math.random() * daggerNames.size())) + "dagger";
                if (daggerNames.size() == 0) {
                    for (int i = 0; i < dagger.length; i++) {
                        daggerNames.add(dagger[i]);
                    }
                }
            }
        else if (manaRepPercent >= .5) {
            if (!weaponType.equals("Staff")) {
                continue;
            }
                type = "Staff";
                name = staffNames.remove((int) (Math.random() * staffNames.size())) + "staff";
                if (staffNames.size() == 0) {
                    for (int i = 0; i < staff.length; i++) {
                        staffNames.add(staff[i]);
                    }
                }
            }
        else {
            if (!weaponType.equals("Sword") && (weaponType.equals("Staff") || weaponType.equals("Hammer") || weaponType.equals("Dagger"))) {
                continue;
            }
            type = "Sword";
            name = swordNames.remove((int) (Math.random() * swordNames.size())) + "sword";
            if (swordNames.size() == 0) {
                for (int i = 0; i < sword.length; i++) {
                    swordNames.add(sword[i]);
                }
            }
        }

            int bonusHealth = 0;
            int healthRep = 0;
            int bonusMana = 0;
            int rare = (int) (Math.random() * 100);
            Item.Rarity rarity;
            double rarityScale = 1;

            if (playerLvl > 2) {
                level = playerLvl + (int) (Math.random() * 5) - 2;
            } else {
                level = playerLvl;
            }

            double levelScale = Math.pow(1.1, (level - 1));

            if (rare >= 98) {
                rarity = Item.Rarity.LEGENDARY;
                rarityScale = 1.6;
            } else if (rare >= 85) {
                rarity = Item.Rarity.RARE;
                rarityScale = 1.25;
            } else if (rare >= 50) {
                rarity = Item.Rarity.UNCOMMON;
                rarityScale = 1.1;
            } else {
                rarity = Item.Rarity.COMMON;
                rarityScale = 1;
            }

            String effect = effects[(int) (Math.random() * effects.length)];

            if (effect.equals("Power")) {
                dmgPercent += .1;
                name = "Extra pokey " + name;
            } else if (effect.equals("Mana")) {
                bonusMana = (int) (30 * levelScale * rarityScale);
                name = "Sparkly " + name;
            } else if (effect.equals("Health")) {
                bonusHealth = (int) (15 * levelScale * rarityScale);
                name = name + " of Gains";
            } else if (effect.equals("HealthRep")) {
                healthRep = (int) (2.5 * levelScale * rarityScale);
                name = "Overpowered " + name;
            }

            int damage = (int) (dmgPercent * rarityScale * levelScale * 30);
            int critChance = (int) (critPercent * 100) - 9;
            int manaRep = (int) (manaRepPercent * rarityScale * levelScale * 30);

            Texture image = new Texture("badlogic.jpg");

            return new Weapon(level, rarity, name, type, image, damage, manaRep, critChance, bonusHealth, healthRep, bonusMana);
        }
    }

    public Weapon makeWeapon(int playerLvl){
        int level;
        String type;
        String name;
        int bonusHealth = 0;
        int healthRep = 0;
        int bonusMana = 0;
        int rare = (int)(Math.random() * 100);
        Item.Rarity rarity;
        double rarityScale = 1;

        if (playerLvl > 2) {
            level = playerLvl + (int) (Math.random() * 5) - 2;
        }
        else {
            level = playerLvl;
        }

        double levelScale = Math.pow(1.1, (level-1));

        if (rare >= 98) {
            rarity = Item.Rarity.LEGENDARY;
            rarityScale = 1.6;
        }
        else if (rare >= 85) {
            rarity = Item.Rarity.RARE;
            rarityScale = 1.25;
        }
        else if (rare >= 50) {
            rarity = Item.Rarity.UNCOMMON;
            rarityScale = 1.1;
        }
        else {
            rarity = Item.Rarity.COMMON;
            rarityScale = 1;
        }

        int dmgInt = (int)(Math.random()*80) + 20;
        int critInt = (int)(Math.random()*80) + 20;
        int manaRepInt = (int)(Math.random()*80) + 20;

        double dmgPercent = dmgInt/(dmgInt + critInt + manaRepInt);
        double critPercent = critInt/(dmgInt + critInt + manaRepInt);
        double manaRepPercent = manaRepInt/(dmgInt + critInt + manaRepInt);

        if (dmgPercent >= .5) {
            type = "Hammer";
            name = hammerNames.remove((int)(Math.random()*hammerNames.size())) + "hammer";
            if (hammerNames.size() == 0) {
                for (int i = 0; i < hammer.length; i++) {
                    hammerNames.add(hammer[i]);
                }
            }
        }
        else if (critPercent >= .5) {
            type = "Dagger";
            name = daggerNames.remove((int)(Math.random()*daggerNames.size())) + "dagger";
            if (daggerNames.size() == 0) {
                for (int i = 0; i < dagger.length; i++) {
                    daggerNames.add(dagger[i]);
                }
            }
        }
        else if (manaRepPercent >= .5) {
            type = "Staff";
            name = staffNames.remove((int)(Math.random()*staffNames.size())) + "staff";
            if (staffNames.size() == 0) {
                for (int i = 0; i < staff.length; i++) {
                    staffNames.add(staff[i]);
                }
            }
        }
        else {
            type = "Sword";
            name = swordNames.remove((int)(Math.random()*swordNames.size())) + "sword";
            if (swordNames.size() == 0) {
                for (int i = 0; i < sword.length; i++) {
                    swordNames.add(sword[i]);
                }
            }
        }

        String effect = effects[(int)(Math.random()*effects.length)];

        if (effect.equals("Power")) {
            dmgPercent += .1;
            name = "Extra pokey " + name;
        }
        else if (effect.equals("Mana")) {
            bonusMana = (int)(30 * levelScale * rarityScale);
            name = "Sparkly " + name;
        }
        else if (effect.equals("Health")) {
            bonusHealth = (int)(15 * levelScale * rarityScale);
            name = name + " of Gains";
        }
        else if (effect.equals("HealthRep")) {
            healthRep = (int) (2.5 * levelScale * rarityScale);
            name = "Overpowered " + name;
        }

        int damage = (int)(dmgPercent*rarityScale*levelScale*30);
        int critChance = (int)(critPercent*100) - 9;
        int manaRep = (int)(manaRepPercent*rarityScale*levelScale*30);

        Texture image =  new Texture("badlogic.jpg");

        return new Weapon(level, rarity, name, type, image, damage, manaRep, critChance, bonusHealth, healthRep, bonusMana);
    }
}
