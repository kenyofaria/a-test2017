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
public class TestB1032 extends BaristaTest<Activity> {
  public TestB1032() {
    super(BaristaTest.getClassFromString("org.epstudios.epmobile.EpMobile"));
  }
  public void setUp()
      throws Exception {
    super.setUp();
    setCurrentActivity(getActivity());
  }
  public void testB1032() {
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.list")).perform(ViewActions.scroll(0));
    onData(Matchers.anything()).inAdapterView(ViewMatchers.withId("org.epstudios.epmobile.R.id.list")).atPosition(0).loadData();
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.TextView[1]")).perform(ViewActions.click());
    onData(Matchers.anything()).inAdapterView(ViewMatchers.withId("org.epstudios.epmobile.R.id.list")).atPosition(2).loadData();
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.TextView[3]")).perform(ViewActions.click());
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView[2]/android.widget.LinearLayout/android.widget.DatePicker[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[3]/android.widget.EditText[1]")).check(ViewAssertions.matches(ViewMatchers.withText("2015")));
  }
}
