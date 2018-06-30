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

/**
 * This test ia aim to creating a business listitem
 * Checking the value is existed or not after creating the listitem
 */
public class CreateTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void createTest() throws Exception {

        //click the button to create a new business
        onView(withId(R.id.submitButton)).perform(click());

        //add the value
        onView(withId(R.id.number)).perform(typeText("123456789"));
        onView(withId(R.id.name)).perform(typeText("jeffery"));
        onView(withId(R.id.primaryBusiness)).perform(typeText("Fisher"));

        onView(withId(R.id.address)).perform(typeText("robie"));
        onView(withId(R.id.province)).perform(typeText("NS"));
        onView(withId(R.id.province)).perform(closeSoftKeyboard());

        //click the button to submit
        onView(withId(R.id.submitButton)).perform(click());

        //click the business we submitted just now
        onData(org.hamcrest.Matchers.anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());

        //check the value in this business are same or not
        onView(withId(R.id.number)).check(matches(withText("123456789")));
        onView(withId(R.id.name)).check(matches(withText("jeffery")));
        onView(withId(R.id.primaryBusiness)).check(matches(withText("Fisher")));
        onView(withId(R.id.address)).check(matches(withText("robie")));
        onView(withId(R.id.province)).check(matches(withText("NS")));

    }
}
