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
public class TestB1022 extends BaristaTest<Activity> {
  public TestB1022() {
    super(BaristaTest.getClassFromString("org.epstudios.epmobile.EpMobile"));
  }
  public void setUp()
      throws Exception {
    super.setUp();
    setCurrentActivity(getActivity());
  }
  public void testB1022() {
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.list")).perform(ViewActions.scroll(0));
    onData(Matchers.anything()).inAdapterView(ViewMatchers.withId("org.epstudios.epmobile.R.id.list")).atPosition(0).loadData();
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.TextView[1]")).perform(ViewActions.click());
    onData(Matchers.anything()).inAdapterView(ViewMatchers.withId("org.epstudios.epmobile.R.id.list")).atPosition(1).loadData();
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.TextView[2]")).perform(ViewActions.click());
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.weight_spinner")).perform(ViewActions.selection(0));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.creatinine_spinner")).perform(ViewActions.selection(0));
    onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard(), ViewActions.sleep(100));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.female")).perform(ViewActions.click());
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.female")).check(ViewAssertions.matches(ViewMatchers.isChecked()));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.ageEditText")).perform(ViewActions.click());
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.ageEditText")).perform(ViewActions.clearText(), ViewActions.sleep(100), ViewActions.typeTextIntoFocusedView("64"));
    onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard(), ViewActions.sleep(100));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.weightEditText")).perform(ViewActions.requestFocus());
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.weightEditText")).perform(ViewActions.clearText(), ViewActions.sleep(100), ViewActions.typeTextIntoFocusedView("59"));
    onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard(), ViewActions.sleep(100));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.creatinine_spinner")).perform(ViewActions.click());
    onData(Matchers.anything()).inAdapterView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.ListView")).atPosition(0).loadData();
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")).perform(ViewActions.click());
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView[2]/android.widget.LinearLayout/android.widget.TableLayout[1]/android.widget.TableRow[4]/android.widget.Spinner[2]/android.widget.TextView")).check(ViewAssertions.matches(ViewMatchers.withText("Cr (mg/dL)")));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.calculate_dose_button")).perform(ViewActions.click());
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.calculated_dose")).check(ViewAssertions.matches(ViewMatchers.withText("Invalid!")));
  }
}
