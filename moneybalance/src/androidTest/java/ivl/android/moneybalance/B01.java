package ivl.android.moneybalance;

import ivl.android.moneybalance.CalculationListActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static org.hamcrest.Matchers.*;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;

import java.io.File;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class B01 {


   @Rule
   public final ActivityTestRule<ivl.android.moneybalance.CalculationListActivity> main = new ActivityTestRule<>(ivl.android.moneybalance.CalculationListActivity.class, false, false);


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
   public void test_B01() {
     //onView(withId("android.R.id.action_bar_title")).check(matches(withText("MoneyBalance")));
     onView(withText("MoneyBalance")).check(matches(withText("MoneyBalance")));
     //onView(withContentDescription("More options")).check(matches(isClickable()));
     //onView(withContentDescription("More options")).perform(click());

   }
}