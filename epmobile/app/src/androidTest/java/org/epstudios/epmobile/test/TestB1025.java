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
public class TestB1025 extends BaristaTest<Activity> {
  public TestB1025() {
    super(BaristaTest.getClassFromString("org.epstudios.epmobile.EpMobile"));
  }
  public void setUp()
      throws Exception {
    super.setUp();
    setCurrentActivity(getActivity());
  }
  public void testB1025() {
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.list")).perform(ViewActions.scroll(0));
    onData(Matchers.anything()).inAdapterView(ViewMatchers.withId("org.epstudios.epmobile.R.id.list")).atPosition(3).loadData();
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.TextView[4]")).perform(ViewActions.click());
    onData(Matchers.anything()).inAdapterView(ViewMatchers.withId("org.epstudios.epmobile.R.id.list")).atPosition(0).loadData();
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.TextView[1]")).perform(ViewActions.click());
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.age75")).perform(ViewActions.click());
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.diabetes")).perform(ViewActions.click());
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.diabetes")).perform(ViewActions.click());
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.diabetes")).check(ViewAssertions.matches(ViewMatchers.isNotChecked()));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.calculate_button")).perform(ViewActions.click());
    onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack());
  }
}
