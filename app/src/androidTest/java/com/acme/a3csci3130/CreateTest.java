package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class CreateTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void createTest() throws Exception {
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.number)).perform(typeText("123456789"));
        onView(withId(R.id.name)).perform(typeText("jeffery"));
        onView(withId(R.id.primaryBusiness)).perform(typeText("Fisher"));

        onView(withId(R.id.address)).perform(typeText("robie"));
        onView(withId(R.id.province)).perform(typeText("NS"));
        onView(withId(R.id.province)).perform(closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());
        onData(org.hamcrest.Matchers.anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.number)).check(matches(withText("123456789")));
        onView(withId(R.id.name)).check(matches(withText("jeffery")));
        onView(withId(R.id.primaryBusiness)).check(matches(withText("Fisher")));
        onView(withId(R.id.address)).check(matches(withText("robie")));
        onView(withId(R.id.province)).check(matches(withText("NS")));

    }
}
