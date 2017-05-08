package de.baumann.quitsmoking;

import de.baumann.quitsmoking.MainActivity;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

@RunWith(AndroidJUnit4.class)
public class D03 {

   @Rule
   public final ActivityTestRule<de.baumann.quitsmoking.MainActivity> main = new ActivityTestRule<>(de.baumann.quitsmoking.MainActivity.class, false, false);

    @Before
    public void initActivity(){
        File root = InstrumentationRegistry.getTargetContext().getFilesDir().getParentFile();
        String[] sharedPreferencesFileNames = new File(root, "shared_prefs").list();
        if(sharedPreferencesFileNames!=null) {
            for (String fileName : sharedPreferencesFileNames) {
                InstrumentationRegistry.getTargetContext().getSharedPreferences(fileName.replace(".xml", ""), Context.MODE_PRIVATE).edit().clear().commit();
            }
        }
        main.launchActivity(new Intent());
    }

   @Test
   public void test_D03() {
       onView(withText("Settings")).check(matches(withText("Settings")));
       ViewInteraction appCompatImageButton = onView(
               allOf(withContentDescription("Navegar para cima"),
                       withParent(allOf(withId(R.id.action_bar),
                               withParent(withId(R.id.action_bar_container)))),
                       isDisplayed()));
       appCompatImageButton.perform(click());
       if(onView(withText("NO")).exists()){
           onView(withText("NO")).perform(click());
       }
       onView(withText("Quit Smoking")).check(matches(withText("Quit Smoking")));
       ViewInteraction appCompatTextView = onView(
               allOf(withText("Diary"), isDisplayed()));
       appCompatTextView.perform(click());
       ViewInteraction appCompatEditText = onView(
               allOf(withId(R.id.editText),
                       withParent(withId(R.id.swipe)),
                       isDisplayed()));
       appCompatEditText.perform(replaceText("Test1"), closeSoftKeyboard());
       openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
       onView(withText("Add current date")).check(matches(isDisplayed()));
       onView(withText("Add current time")).check(matches(isDisplayed()));
       onView(withText("Add a separator line")).check(matches(isDisplayed()));
       onView(withText("Settings")).check(matches(isDisplayed()));
   }
}