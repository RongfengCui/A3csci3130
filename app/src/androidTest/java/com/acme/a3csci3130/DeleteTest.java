package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


/**
 * This test is aim to delete one of business from listview
 * The app will open the first business from listview
 * Clicking the delete button
 */


public class DeleteTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void deleteTest() throws Exception {
        Thread.sleep(1000);
        onView(withId(R.id.listView));

        //click the first business in listview
        onData(org.hamcrest.Matchers.anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());

        //click the delete button
        onView(withId(R.id.deleteButton)).perform(click());
    }
}
