package game;

import java.util.ArrayList;

public final class Constants {
    /**Kind angels.*/
    public static final ArrayList<String>
            KIND_ANGELS = new ArrayList<String>() {
        {
            add("DamageAngel");
            add("GoodBoy");
            add("LevelUpAngel");
            add("LifeGiver");
            add("SmallAngel");
            add("Spawner");
            add("XPAngel");
        }
    };
    /**.*/
    public static final int STRATEGY_KNIGHT_MIN_HP = 3;
    /**.*/
    public static final int STRATEGY_KNIGHT_MAX_HP = 2;
    /**.*/
    public static final int STRATEGY_KNIGHT_DELETE_HP = 5;
    /**.*/
    public static final float STRATEGY_KNIGHT_COEF_INCREASE = 0.5f;
    /**.*/
    public static final float STRATEGY_KNIGHT_COEF_DECREASE = 0.2f;
    /**.*/
    public static final int STRATEGY_KNIGHT_GAIN_HP = 4;

    /**.*/
    public static final int STRATEGY_PYROMANCER_MIN_HP = 4;
    /**.*/
    public static final int STRATEGY_PYROMANCER_MAX_HP = 3;
    /**.*/
    public static final int STRATEGY_PYROMANCER_DELETE_HP = 4;
    /**.*/
    public static final float STRATEGY_PYROMANCER_COEF_INCREASE = 0.7f;
    /**.*/
    public static final float STRATEGY_PYROMANCER_COEF_DECREASE = 0.3f;
    /**.*/
    public static final int STRATEGY_PYROMANCER_GAIN_HP = 3;

    /**.*/
    public static final int STRATEGY_ROGUE_MIN_HP = 7;
    /**.*/
    public static final int STRATEGY_ROGUE_MAX_HP = 5;
    /**.*/
    public static final int STRATEGY_ROGUE_DELETE_HP = 7;
    /**.*/
    public static final float STRATEGY_ROGUE_COEF_INCREASE = 0.4f;
    /**.*/
    public static final float STRATEGY_ROGUE_COEF_DECREASE = 0.1f;
    /**.*/
    public static final int STRATEGY_ROGUE_GAIN_HP = 2;

    /**.*/
    public static final int STRATEGY_WIZARD_MIN_HP = 4;
    /**.*/
    public static final int STRATEGY_WIZARD_MAX_HP = 2;
    /**.*/
    public static final int STRATEGY_WIZARD_DELETE_HP = 10;
    /**.*/
    public static final float STRATEGY_WIZARD_COEF_INCREASE = 0.6f;
    /**.*/
    public static final float STRATEGY_WIZARD_COEF_DECREASE = 0.2f;
    /**.*/
    public static final int STRATEGY_WIZARD_GAIN_HP = 5;

    /**.*/
    public static final int XP_ANGEL_KNIGHT_XP = 45;
    /**.*/
    public static final int XP_ANGEL_PYROMANCER_XP = 50;
    /**.*/
    public static final int XP_ANGEL_ROGUE_XP = 40;
    /**.*/
    public static final int XP_ANGEL_WIZARD_XP = 60;
    /**.*/
    public static final int SPAWNER_KNIGHT_HP = 200;
    /**.*/
    public static final int SPAWNER_PYROMANCER_HP = 150;
    /**.*/
    public static final int SPAWNER_ROGUE_HP = 180;
    /**.*/
    public static final int SPAWNER_WIZARD_HP = 120;
    /**.*/
    public static final int SMALL_ANGEL_KNIGHT_HP = 10;
    /**.*/
    public static final float SMALL_ANGEL_KNIGHT_DMG = 0.1f;
    /**.*/
    public static final int SMALL_ANGEL_PYROMANCER_HP = 15;
    /**.*/
    public static final float SMALL_ANGEL_PYROMANCER_DMG = 0.15f;
    /**.*/
    public static final int SMALL_ANGEL_ROGUE_HP = 20;
    /**.*/
    public static final float SMALL_ANGEL_ROGUE_DMG = 0.05f;
    /**.*/
    public static final int SMALL_ANGEL_WIZARD_HP = 25;
    /**.*/
    public static final float SMALL_ANGEL_WIZARD_DMG = 0.1f;
    /**.*/
    public static final int LIFE_GIVER_KNIGHT_HP = 100;
    /**.*/
    public static final int LIFE_GIVER_PYROMANCER_HP = 80;
    /**.*/
    public static final int LIFE_GIVER_ROGUE_HP = 90;
    /**.*/
    public static final int LIFE_GIVER_WIZARD_HP = 120;
    /**.*/
    public static final float LEVEL_UP_ANGEL_KNIGHT_DMG = 0.1f;
    /**.*/
    public static final float LEVEL_UP_ANGEL_PYROMANCER_DMG = 0.2f;
    /**.*/
    public static final float LEVEL_UP_ANGEL_ROGUE_DMG = 0.15f;
    /**.*/
    public static final float LEVEL_UP_ANGEL_WIZARD_DMG = 0.25f;
    /**.*/
    public static final int GOOD_BOY_KNIGHT_HP = 20;
    /**.*/
    public static final float GOOD_BOY_KNIGHT_DMG = 0.4f;
    /**.*/
    public static final int GOOD_BOY_PYROMANCER_HP = 30;
    /**.*/
    public static final float GOOD_BOY_PYROMANCER_DMG = 0.5f;
    /**.*/
    public static final int GOOD_BOY_ROGUE_HP = 40;
    /**.*/
    public static final float GOOD_BOY_ROGUE_DMG = 0.4f;
    /**.*/
    public static final int GOOD_BOY_WIZARD_HP = 50;
    /**.*/
    public static final float GOOD_BOY_WIZARD_DMG = 0.3f;
    /**.*/
    public static final int DRACULA_KNIGHT_HP = 60;
    /**.*/
    public static final float DRACULA_KNIGHT_DMG = -0.2f;
    /**.*/
    public static final int DRACULA_PYROMANCER_HP = 40;
    /**.*/
    public static final float DRACULA_PYROMANCER_DMG = -0.3f;
    /**.*/
    public static final int DRACULA_ROGUE_HP = 35;
    /**.*/
    public static final float DRACULA_ROGUE_DMG = -0.1f;
    /**.*/
    public static final int DRACULA_WIZARD_HP = 20;
    /**.*/
    public static final float DRACULA_WIZARD_DMG = -0.4f;
    /**.*/
    public static final int DARK_ANGEL_KNIGHT = 40;
    /**.*/
    public static final int DARK_ANGEL_PYROMANCER = 30;
    /**.*/
    public static final int DARK_ANGEL_ROGUE = 10;
    /**.*/
    public static final int DARK_ANGEL_WIZARD = 20;
    /**.*/
    public static final float DAMAGE_ANGEL_PYROMANCER = 0.20f;
    /**.*/
    public static final float DAMAGE_ANGEL_KNIGHT = 0.15f;
    /**.*/
    public static final float DAMAGE_ANGEL_ROGUE = 0.3f;
    /**.*/
    public static final float DAMAGE_ANGEL_WIZARD = 0.4f;
    /**.*/
    public static final int PYROMANCER_BASE_HP = 500;
    /**.*/
    public static final int PYROMANCER_PER_LEVEL_HP = 50;
    /**.*/
    public static final float PYROANCER_LAND_AMPLIFIER = 1.25f;
    /**.*/
    public static final int FIREBLAST = 350;
    /**.*/
    public static final int FIREBLAST_PER_LEVEL = 50;
    /**.*/
    public  static final float FIREBLAST_PYROMANCER_AMPLIFIER = 0.9f;
    /**.*/
    public  static final float FIREBLAST_KNIGHT_AMPLIFIER = 1.2f;
    /**.*/
    public  static final float FIREBLAST_WIZARD_AMPLIFIER = 1.05f;
    /**.*/
    public  static final float FIREBLAST_ROGUE_AMPLIFIER = 0.8f;
    /**.*/
    public static final int IGNITE = 150;
    /**.*/
    public static final int IGNITE_PER_LEVEL = 20;
    /**.*/
    public  static final float IGNITE_PYROMANCER_AMPLIFIER = 0.9f;
    /**.*/
    public  static final float IGNITE_KNIGHT_AMPLIFIER = 1.2f;
    /**.*/
    public  static final float IGNITE_WIZARD_AMPLIFIER = 1.05f;
    /**.*/
    public  static final float IGNITE_ROGUE_AMPLIFIER = 0.8f;
    /**.*/
    public static final int IGNITE_NEXT_ROUND = 50;
    /**.*/
    public static final int IGNITE_NEXT_ROUND_PER_LEVEL = 30;

    /**.*/
    public static final int KNIGHT_BASE_HP = 900;
    /**.*/
    public static final int KNIGHT_PER_LEVEL_HP = 80;
    /**.*/
    public static final float KNIGHT_LAND_AMPLIFIER = 1.15f;
    /**.*/
    public static final int EXECUTE = 200;
    /**.*/
    public static final int EXECUTE_PER_LEVEL = 30;
    /**.*/
    public static final float EXECUTE_HP_LIMIT = 0.2f;
    /**.*/
    public static final float EXECUTE_BONUS = 0.01f;
    /**.*/
    public static final float EXECUTE_MAX_PERCENTAGE = 0.4f;
    /**.*/
    public static final float EXECUTE_PYROMANCER_AMPLIFIER = 1.1f;
    /**.*/
    public static final float EXECUTE_KNIGHT_AMPLIFIER = 1f;
    /**.*/
    public static final float EXECUTE_WIZARD_AMPLIFIER = 0.8f;
    /**.*/
    public static final float EXECUTE_ROGUE_AMPLIFIER = 1.15f;
    /**.*/
    public static final int SLAM = 100;
    /**.*/
    public static final int SLAM_PER_LEVEL_HP = 40;
    /**.*/
    public static final float SLAM_PYROMANCER_AMPLIFIER = 0.9f;
    /**.*/
    public static final float SLAM_KNIGHT_AMPLIFIER = 1.2f;
    /**.*/
    public static final float SLAM_WIZARD_AMPLIFIER = 1.05f;
    /**.*/
    public static final float SLAM_ROGUE_AMPLIFIER = 0.8f;

    /**.*/
    public static final int WIZARD_BASE_HP = 400;
    /**.*/
    public static final int WIZARD_PER_LEVEL_HP = 30;
    /**.*/
    public static final float WIZARD_LAND_AMPLIFIER = 1.1f;
    /**.*/
    public static final float DRAIN = 0.2f;
    /**.*/
    public static final float DRAIN_PERCENT = 0.3f;
    /**.*/
    public static final float DRAIN_PER_LEVEL = 0.05f;
    /**.*/
    public static final float DRAIN_PYROMANCER_AMPLIFIER = 0.9f;
    /**.*/
    public static final float DRAIN_KNIGHT_AMPLIFIER = 1.20f;
    /**.*/
    public static final float DRAIN_WIZARD_AMPLIFIER = 1.05f;
    /**.*/
    public static final float DRAIN_ROGUE_AMPLIFIER = 0.8f;
    /**.*/
    public static final float DEFLECT = 0.35f;
    /**.*/
    public static final float DEFLECT_MAX = 0.7f;
    /**.*/
    public static final float DEFLECT_PER_LEVEL = 0.02f;
    /**.*/
    public static final float DEFLECT_ROGUE_AMPLIFIER = 1.2f;
    /**.*/
    public static final float DEFLECT_KNIGHT_AMPLIFIER = 1.4f;
    /**.*/
    public static final float DEFLECT_PYROMANCER_AMPLIFIER = 1.3f;

    /**.*/
    public static final int ROGUE_BASE_HP = 600;
    /**.*/
    public static final int ROGUE_PER_LEVEL_HP = 40;
    /**.*/
    public static final float ROGUE_LAND_AMPLIFIER = 1.15f;
    /**.*/
    public static final int BACKSTAB = 200;
    /**.*/
    public static final int BACKSTAB_PER_LEVEL = 20;
    /**.*/
    public static final float BACKSTAB_PYROMANCER_AMPLIFIER = 1.25f;
    /**.*/
    public static final float BACKSTAB_KNIGHT_AMPLIFIER = 0.9f;
    /**.*/
    public static final float BACKSTAB_BONUS_AMPLIFIER = 1.5f;
    /**.*/
    public static final int BACKSTAB_ROUND_CRITICAL = 3;
    /**.*/
    public static final int PARALYSIS_DURATION = 3;
    /**.*/
    public static final float BACKSTAB_WIZARD_AMPLIFIER = 1.25f;
    /**.*/
    public static final float BACKSTAB_ROGUE_AMPLIFIER = 1.20f;
    /**.*/
    public static final int PARALYSIS = 40;
    /**.*/
    public static final int PARALYSIS_PER_LEVEL = 10;
    /**.*/
    public static final float PARALYSIS_PYROMANCER_AMPLIFIER = 1.2f;
    /**.*/
    public static final float PARALYSIS_KNIGHT_AMPLIFIER = 0.8f;
    /**.*/
    public static final float PARALYSIS_WIZARD_AMPLIFIER = 1.25f;
    /**.*/
    public static final float PARALYSIS_ROGUE_AMPLIFIER = 0.9f;

    /**.*/
    public static final int EXP_BONUS = 200;
    /**.*/
    public static final int EXP_LEVEL_UP = 250;
    /**.*/
    public static final int EXP_UP1 = 40;
    /**.*/
    public static final int EXP_UP2 = 50;

    private Constants() { }
}
