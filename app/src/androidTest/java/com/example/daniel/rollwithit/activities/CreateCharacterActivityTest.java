package com.example.daniel.rollwithit.activities;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static java.lang.Thread.sleep;

import java.util.Random;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.daniel.rollwithit.R;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.widget.EditText;

@RunWith(AndroidJUnit4.class)
public class CreateCharacterActivityTest extends ActivityTestRule {

    // private static final String CHARACTER_NAME = "Hippy";
    private static final String PLAYER_NAME = "Daniel Colgan";
    private static final String BACKGROUND = "Urchin";
    private static final String ALIGNMENT = "LG";
    private static final String RACE = "Elf";
    private static final String DND_CLASS = "Rouge";
    // private static final String PROFICIENCY_BONUS = "3";
    // private static final String ARMOUR_CLASS = "16";
    // private static final String SPEED = "30";
    // private static final String HIT_POINTS = "48";
    // private static final String LEVEL;
    // private static final String XP = "17500";
    // private static final String STRENGTH = "10";
    // private static final String DEXTERITY = "18";
    // private static final String CONSTITUTION = "14";
    // private static final String INTELLIGENCE = "11";
    // private static final String WISDOM = "11";
    // private static final String CHARISMA = "12";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    public CreateCharacterActivityTest() {
        super(MainActivity.class);
    }

    @Test
    public void successfullyCreateAndLoadNewCharacter() {
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation()
            .addMonitor(CreateCharacterActivity.class.getName(), null, false);
        onView(withId(R.id.CreateCharacterButton)).perform(click());
        Activity createCharacterActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        createNewCharacter(createCharacterActivity);
        onView(withId(R.id.SaveCharacterButton)).perform(scrollTo(), click());
        createCharacterActivity.finish();
    }

    private void createNewCharacter(Activity activity) {
        final EditText characterName = (EditText)activity.findViewById(R.id.characterName);
        final EditText playerName = (EditText)activity.findViewById(R.id.playerName);
        final EditText dndClass = (EditText)activity.findViewById(R.id.dndClass);
        final EditText background = (EditText)activity.findViewById(R.id.background);
        final EditText race = (EditText)activity.findViewById(R.id.race);
        final EditText alignment = (EditText)activity.findViewById(R.id.alignment);
        final EditText strength = (EditText)activity.findViewById(R.id.strength);
        final EditText dexterity = (EditText)activity.findViewById(R.id.dexterity);
        final EditText constitution = (EditText)activity.findViewById(R.id.constitution);
        final EditText intelligence = (EditText)activity.findViewById(R.id.intelligence);
        final EditText wisdom = (EditText)activity.findViewById(R.id.wisdom);
        final EditText charisma = (EditText)activity.findViewById(R.id.charisma);
        final EditText armourClass = (EditText)activity.findViewById(R.id.armourClass);
        final EditText speed = (EditText)activity.findViewById(R.id.speed);
        final EditText hitPoints = (EditText)activity.findViewById(R.id.hitPoints);
        final EditText level = (EditText)activity.findViewById(R.id.level);
        final EditText xp = (EditText)activity.findViewById(R.id.xp);
        final EditText proficiencyBonus = (EditText)activity.findViewById(R.id.proficiencyBonus);
        activity.runOnUiThread(new Runnable() {

            public void run() {
                characterName.setText(getSaltString());
                dndClass.setText(DND_CLASS);
                background.setText(BACKGROUND);
                playerName.setText(PLAYER_NAME);
                race.setText(RACE);
                alignment.setText(ALIGNMENT);
                strength.setText(String.valueOf(randomWithRange(18)));
                dexterity.setText(String.valueOf(randomWithRange(18)));
                constitution.setText(String.valueOf(randomWithRange(18)));
                intelligence.setText(String.valueOf(randomWithRange(18)));
                wisdom.setText(String.valueOf(randomWithRange(18)));
                charisma.setText(String.valueOf(randomWithRange(18)));
                armourClass.setText(String.valueOf(randomWithRange(18)));
                speed.setText(String.valueOf(randomWithRange(18)));
                hitPoints.setText(String.valueOf(randomWithRange(18)));
                level.setText(String.valueOf(randomWithRange(18)));
                xp.setText(String.valueOf(randomWithRange(18)));
                proficiencyBonus.setText(String.valueOf(randomWithRange(18)));
            }
        });
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getSaltString() {
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) {
            int index = (int)(rnd.nextFloat() * alpha.length());
            salt.append(alpha.charAt(index));
        }
        Log.i("INFO", "CharacterName: " + salt.toString());
        return salt.toString();
    }

    private int randomWithRange(int max) {
        int range = ((max - 1) + 1);
        return (int)(Math.random() * range) + 1;
    }
}
