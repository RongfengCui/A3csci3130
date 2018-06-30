package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;

public class UpdateTest {
    @Rule
    public final ActivityTestRule<MainActivity> main = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void updateTest() throws Exception {
        Thread.sleep(1000);
        onView(withId((R.id.listView)));
        onData(org.hamcrest.Matchers.anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.province)).perform(replaceText("BC"));
        onView(withId(R.id.updateButton)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.listView)).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.province)).check(matches(withText("BC")));
    }
}
