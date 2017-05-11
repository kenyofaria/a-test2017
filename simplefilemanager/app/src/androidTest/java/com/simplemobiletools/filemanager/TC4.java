package com.simplemobiletools.filemanager;

import com.simplemobiletools.filemanager.activities.MainActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static org.hamcrest.Matchers.*;
import android.test.suitebuilder.annotation.LargeTest;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class TC4 {

   @Rule
   public final ActivityTestRule<com.simplemobiletools.filemanager.activities.MainActivity> main = new ActivityTestRule<>(com.simplemobiletools.filemanager.activities.MainActivity.class);

   @Test
   public void test_TC4() {
     onView(withText("File Manager")).check(matches(withText("File Manager")));
     onView(withContentDescription("More options")).check(matches(isDisplayed()));
     onView(withContentDescription("More options")).perform(click());

   }
}