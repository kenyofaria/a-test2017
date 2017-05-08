package org.epstudios.epmobile.test;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.Espresso.onData;
import android.app.Activity;
import org.hamcrest.Matchers;
import com.google.android.apps.common.testing.ui.espresso.action.ViewActions;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;
import com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions;
import com.google.android.apps.common.testing.ui.espresso.test.BaristaTest;
import android.test.suitebuilder.annotation.LargeTest;
@LargeTest
public class TestB1012 extends BaristaTest<Activity> {
  public TestB1012() {
    super(BaristaTest.getClassFromString("org.epstudios.epmobile.EpMobile"));
  }
  public void setUp()
      throws Exception {
    super.setUp();
    setCurrentActivity(getActivity());
  }
  public void testB1012() {
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.list")).perform(ViewActions.scroll(0));
    onData(Matchers.anything()).inAdapterView(ViewMatchers.withId("org.epstudios.epmobile.R.id.list")).atPosition(0).loadData();
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.TextView[1]")).perform(ViewActions.click());
    onData(Matchers.anything()).inAdapterView(ViewMatchers.withId("org.epstudios.epmobile.R.id.list")).atPosition(0).loadData();
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.TextView[1]")).perform(ViewActions.click());
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.weight_spinner")).perform(ViewActions.selection(0));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.height_spinner")).perform(ViewActions.selection(0));
    onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard(), ViewActions.sleep(100));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.weightEditText")).check(ViewAssertions.matches(ViewMatchers.isEnabled()));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.weightEditText")).perform(ViewActions.click());
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.weightEditText")).perform(ViewActions.clearText(), ViewActions.sleep(100), ViewActions.typeTextIntoFocusedView("80"));
    onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard(), ViewActions.sleep(100));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.heightEditText")).check(ViewAssertions.matches(ViewMatchers.isEnabled()));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.heightEditText")).perform(ViewActions.requestFocus());
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.heightEditText")).perform(ViewActions.clearText(), ViewActions.sleep(100), ViewActions.typeTextIntoFocusedView("180"));
    onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard(), ViewActions.sleep(100));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.calculate_button")).check(ViewAssertions.matches(ViewMatchers.isEnabled()));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.calculate_button")).perform(ViewActions.click());
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.ibwResultTextView")).check(ViewAssertions.matches(ViewMatchers.withText("75")));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.abwResultTextView")).check(ViewAssertions.matches(ViewMatchers.withText("77")));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.weightEditText")).perform(ViewActions.requestFocus());
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.clear_button")).perform(ViewActions.click());
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.weightEditText")).check(ViewAssertions.matches(ViewMatchers.withText("Weight (kg)")));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.heightEditText")).check(ViewAssertions.matches(ViewMatchers.withText("Height (cm)")));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.ibwResultTextView")).check(ViewAssertions.matches(ViewMatchers.withText("IBW (kg)")));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.abwResultTextView")).check(ViewAssertions.matches(ViewMatchers.withText("ABW (kg)")));
  }
}
