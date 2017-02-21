// package com.example.daniel.rollwithit.utils;
//
// import static java.lang.String.valueOf;
//
// import java.util.Random;
//
// import com.example.daniel.rollwithit.R;
//
// import android.app.Activity;
// import android.util.Log;
// import android.widget.EditText;
// import android.widget.Spinner;
//
// public class CharacterUtils {
//
// private final DiceRoller diceRoller = new DiceRoller();
//
// private static final String PLAYER_NAME = "Daniel Colgan";
// private static final int MAX_ATT_VALUE = 18;
//
// public void createNewCharacter(Activity activity) {
// final EditText characterName = (EditText)activity.findViewById(R.id.character_name_value);
// final EditText playerName = (EditText)activity.findViewById(R.id.player_name_value);
// final Spinner dndClass = (Spinner)activity.findViewById(R.id.dnd_class_value);
// final Spinner background = (Spinner)activity.findViewById(R.id.background_value);
// final Spinner race = (Spinner)activity.findViewById(R.id.race_value);
// final Spinner alignment = (Spinner)activity.findViewById(R.id.alignment_value);
// final EditText strength = (EditText)activity.findViewById(R.id.strength_value);
// final EditText dexterity = (EditText)activity.findViewById(R.id.dexterity_value);
// final EditText constitution = (EditText)activity.findViewById(R.id.constitution_value);
// final EditText intelligence = (EditText)activity.findViewById(R.id.intelligence_value);
// final EditText wisdom = (EditText)activity.findViewById(R.id.wisdom_value);
// final EditText charisma = (EditText)activity.findViewById(R.id.charisma_value);
// final EditText armourClass = (EditText)activity.findViewById(R.id.armour_class_value);
// final EditText speed = (EditText)activity.findViewById(R.id.speed_value);
// final EditText hitPoints = (EditText)activity.findViewById(R.id.hit_points_value);
// final EditText level = (EditText)activity.findViewById(R.id.level_value);
// final EditText xp = (EditText)activity.findViewById(R.id.xp_value);
// final EditText proficiencyBonus = (EditText)activity.findViewById(R.id.proficiency_bonus_value);
// final EditText initiative = (EditText)activity.findViewById(R.id.initiative_value);
// //characterName.setText(getSaltString());
// //playerName.setText(PLAYER_NAME);
//
// dndClass.setSelection(randomWithRange(11));
// background.setSelection(randomWithRange(9));
// race.setSelection(randomWithRange(7));
// alignment.setSelection(randomWithRange(9));
//
//
// strength.setText(valueOf(diceRoller.roll4d6DropLowest()));
// dexterity.setText(valueOf(diceRoller.roll4d6DropLowest()));
// constitution.setText(valueOf(diceRoller.roll4d6DropLowest()));
// intelligence.setText(valueOf(diceRoller.roll4d6DropLowest()));
// wisdom.setText(valueOf(diceRoller.roll4d6DropLowest()));
// charisma.setText(valueOf(diceRoller.roll4d6DropLowest()));
//
// armourClass.setText(valueOf(randomWithRange(MAX_ATT_VALUE)));
//
// speed.setText(valueOf(randomWithRange(MAX_ATT_VALUE)));
//
// hitPoints.setText(valueOf(randomWithRange(MAX_ATT_VALUE)));
// xp.setText(valueOf(randomWithRange(MAX_ATT_VALUE)));
//
// level.setText(valueOf(randomWithRange(MAX_ATT_VALUE)));
//
// proficiencyBonus.setText(valueOf(randomWithRange(MAX_ATT_VALUE)));
//
// initiative.setText(valueOf(randomWithRange(MAX_ATT_VALUE)));
//
// }
//
// public int setHitPoints() {
// return 0;
// }
//
// public int setProficiencyBonus() {
// switch (level) {
// case 1:
// case 2:
// case 3:
// case 4:
// return 2;
// case 5:
// case 6:
// case 7:
// case 8:
// return 3;
// case 9:
// case 10:
// case 11:
// case 12:
// return 4;
// case 13:
// case 14:
// case 15:
// case 16:
// return 5;
// case 17:
// case 18:
// case 19:
// case 20:
// return 6;
// default:
// return 0;
// }
// }
//
// public int setSpeed() {
// switch (race) {
// case "Human":
// return 30;
// case "Dwarf":
// return 25;
// case "Elf":
// return 30;
// case "Gnome":
// return 25;
// case "HalfElf":
// return 30;
// case "HalfOrc":
// return 30;
// case "Halfling":
// return 25;
// }
// return 0;
// }
// private String getSaltString() {
// String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
// StringBuilder salt = new StringBuilder();
// Random rnd = new Random();
// while (salt.length() < 5) {
// int index = (int)(rnd.nextFloat() * alpha.length());
// salt.append(alpha.charAt(index));
// }
// Log.i("INFO", "CharacterName: " + salt.toString());
// return salt.toString();
// }
//
// private int randomWithRange(int max) {
// int range = ((max - 1) + 1);
// return (int)(Math.random() * range) + 1;
// }
// }
