package com.example.daniel.roll20;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.daniel.roll20.activities.CharacterDisplayActivity;
import com.example.daniel.roll20.activities.CreateCharacterActivity;
import com.example.daniel.roll20.activities.MainActivity;
import com.example.daniel.roll20.activities.RollerActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends ActivityTestRule {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Test
    public void diceRollerActivityCalledSuccessfully() {
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation()
            .addMonitor(RollerActivity.class.getName(), null, false);
        onView(withId(R.id.RollButton)).perform(click());
        Activity rollerActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        assertNotNull(rollerActivity);
        rollerActivity.finish();
    }

    @Test
    public void loadCharacterActivityCalledSuccessfully() {
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation()
            .addMonitor(CharacterDisplayActivity.class.getName(), null, false);
        onView(withId(R.id.LoadCharacterButton)).perform(click());
        Activity characterDisplayActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        assertNotNull(characterDisplayActivity);
        characterDisplayActivity.finish();
    }

    @Test
    public void createCharacterActivityCalledSuccessfully() {
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation()
            .addMonitor(CreateCharacterActivity.class.getName(), null, false);
        onView(withId(R.id.CreateCharacterButton)).perform(click());
        Activity createCharacterActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        assertNotNull(createCharacterActivity);
        createCharacterActivity.finish();
    }

}
