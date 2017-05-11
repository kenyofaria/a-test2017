package com.simplemobiletools.filemanager;


import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.simplemobiletools.filemanager.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TC2 {

    @Rule
    public ActivityTestRule<com.simplemobiletools.filemanager.activities.MainActivity> mActivityTestRule = new ActivityTestRule<>(com.simplemobiletools.filemanager.activities.MainActivity.class, false, false);


    @Before
    public void initActivity(){
        File root = InstrumentationRegistry.getTargetContext().getFilesDir().getParentFile();
        String[] sharedPreferencesFileNames = new File(root, "shared_prefs").list();
        if(sharedPreferencesFileNames!=null) {
            for (String fileName : sharedPreferencesFileNames) {
                InstrumentationRegistry.getTargetContext().getSharedPreferences(fileName.replace(".xml", ""), Context.MODE_PRIVATE).edit().clear().commit();
            }
        }
        mActivityTestRule.launchActivity(new Intent());
    }

    @Test
    public void test_TC2() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.title), withText("Settings"), isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction relativeLayout = onView(
                allOf(withId(R.id.settings_dark_theme_holder),
                        withParent(allOf(withId(R.id.settings_holder),
                                withParent(withId(R.id.settings_scrollview))))));
        relativeLayout.perform(scrollTo(), click());

        ViewInteraction relativeLayout2 = onView(
                allOf(withId(R.id.settings_show_hidden_holder),
                        withParent(allOf(withId(R.id.settings_holder),
                                withParent(withId(R.id.settings_scrollview))))));
        relativeLayout2.perform(scrollTo(), click());

        ViewInteraction imageButton = onView(
                allOf(withContentDescription("Navegar para cima"),
                        withParent(allOf(withId(R.id.action_bar),
                                withParent(withId(R.id.action_bar_container)))),
                        isDisplayed()));
        imageButton.perform(click());

    }

}
