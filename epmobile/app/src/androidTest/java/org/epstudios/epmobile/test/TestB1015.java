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
public class TestB1015 extends BaristaTest<Activity> {
  public TestB1015() {
    super(BaristaTest.getClassFromString("org.epstudios.epmobile.EpMobile"));
  }
  public void setUp()
      throws Exception {
    super.setUp();
    setCurrentActivity(getActivity());
  }
  public void testB1015() {
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.list")).perform(ViewActions.scroll(0));
    onData(Matchers.anything()).inAdapterView(ViewMatchers.withId("org.epstudios.epmobile.R.id.list")).atPosition(0).loadData();
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.TextView[1]")).perform(ViewActions.click());
    onData(Matchers.anything()).inAdapterView(ViewMatchers.withId("org.epstudios.epmobile.R.id.list")).atPosition(2).loadData();
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.TextView[3]")).perform(ViewActions.click());
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView[2]/android.widget.LinearLayout/android.widget.DatePicker[2]/android.widget.LinearLayout/android.widget.LinearLayout")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.numberOfDaysEditText")).perform(ViewActions.requestFocus());
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView[2]")).perform(ViewActions.scrollPercentage(0.5230352303523035));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.numberOfDaysEditText")).perform(ViewActions.click());
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.numberOfDaysEditText")).perform(ViewActions.clearText(), ViewActions.sleep(100), ViewActions.typeTextIntoFocusedView("40"));
    onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard(), ViewActions.sleep(100));
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView[2]")).perform(ViewActions.scrollPercentage(1.0));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.calculate_date_button")).perform(ViewActions.click());
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.calculated_date")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
  }
}
