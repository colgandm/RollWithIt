// package com.example.daniel.rollwithit.activities;
//
// import static android.support.test.InstrumentationRegistry.getInstrumentation;
// import static android.support.test.espresso.Espresso.onView;
// import static android.support.test.espresso.action.ViewActions.click;
// import static android.support.test.espresso.action.ViewActions.scrollTo;
// import static android.support.test.espresso.matcher.ViewMatchers.withId;
// import static java.lang.String.valueOf;
// import static java.lang.Thread.sleep;
//
// import java.util.Random;
//
// import org.junit.Rule;
// import org.junit.Test;
// import org.junit.runner.RunWith;
//
// import com.example.daniel.rollwithit.R;
//
// import android.app.Activity;
// import android.app.Instrumentation;
// import android.support.test.rule.ActivityTestRule;
// import android.support.test.runner.AndroidJUnit4;
// import android.util.Log;
// import android.widget.EditText;
//
// @RunWith(AndroidJUnit4.class)
// public class CreateCharacterActivityTest extends ActivityTestRule {
//
// // private static final String CHARACTER_NAME = "Hippy";
// private static final String PLAYER_NAME = "Daniel Colgan";
// private static final String BACKGROUND = "Urchin";
// private static final String ALIGNMENT = "LG";
// private static final String RACE = "Elf";
// private static final String DND_CLASS = "Rogue";
// private static final int MAX_ATT_VALUE = 18;
// // private static final String PROFICIENCY_BONUS = "3";
// // private static final String ARMOUR_CLASS = "16";
// // private static final String SPEED = "30";
// // private static final String HIT_POINTS = "48";
// // private static final String LEVEL;
// // private static final String XP = "17500";
// // private static final String STRENGTH = "10";
// // private static final String DEXTERITY = "18";
// // private static final String CONSTITUTION = "14";
// // private static final String INTELLIGENCE = "11";
// // private static final String WISDOM = "11";
// // private static final String CHARISMA = "12";
//
// @Rule
// public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
//
// public CreateCharacterActivityTest() {
// super(MainActivity.class);
// }
//
// @Test
// public void successfullyCreateAndLoadNewCharacter() {
// Instrumentation.ActivityMonitor activityMonitor = getInstrumentation()
// .addMonitor(CreateCharacterActivity.class.getName(), null, false);
// onView(withId(R.id.create_character_button)).perform(click());
// Activity createCharacterActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
// createNewCharacter(createCharacterActivity);
// onView(withId(R.id.save_character_button)).perform(scrollTo(), click());
// createCharacterActivity.finish();
// }
//
// private void createNewCharacter(Activity activity) {
// final EditText characterName = (EditText)activity.findViewById(R.id.character_name_value);
// final EditText playerName = (EditText)activity.findViewById(R.id.player_name_value);
// final EditText dndClass = (EditText)activity.findViewById(R.id.dnd_class_value);
// final EditText background = (EditText)activity.findViewById(R.id.background_value);
// final EditText race = (EditText)activity.findViewById(R.id.race_value);
// final EditText alignment = (EditText)activity.findViewById(R.id.alignment_value);
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
// activity.runOnUiThread(new Runnable() {
//
// public void run() {
// characterName.setText(getSaltString());
// dndClass.setText(DND_CLASS);
// background.setText(BACKGROUND);
// playerName.setText(PLAYER_NAME);
// race.setText(RACE);
// alignment.setText(ALIGNMENT);
// strength.setText(valueOf(randomWithRange(MAX_ATT_VALUE)));
// dexterity.setText(valueOf(randomWithRange(MAX_ATT_VALUE)));
// constitution.setText(valueOf(randomWithRange(MAX_ATT_VALUE)));
// intelligence.setText(valueOf(randomWithRange(MAX_ATT_VALUE)));
// wisdom.setText(valueOf(randomWithRange(MAX_ATT_VALUE)));
// charisma.setText(valueOf(randomWithRange(MAX_ATT_VALUE)));
// armourClass.setText(valueOf(randomWithRange(MAX_ATT_VALUE)));
// speed.setText(valueOf(randomWithRange(MAX_ATT_VALUE)));
// hitPoints.setText(valueOf(randomWithRange(MAX_ATT_VALUE)));
// level.setText(valueOf(randomWithRange(MAX_ATT_VALUE)));
// xp.setText(valueOf(randomWithRange(MAX_ATT_VALUE)));
// proficiencyBonus.setText(valueOf(randomWithRange(MAX_ATT_VALUE)));
// initiative.setText(valueOf(randomWithRange(MAX_ATT_VALUE)));
// }
// });
// try {
// sleep(2000);
// } catch (InterruptedException e) {
// e.printStackTrace();
// }
// }
//
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
