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
public class TestB1011 extends BaristaTest<Activity> {
  public TestB1011() {
    super(BaristaTest.getClassFromString("org.epstudios.epmobile.EpMobile"));
  }
  public void setUp()
      throws Exception {
    super.setUp();
    setCurrentActivity(getActivity());
  }
  public void testB1011() {
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.list")).perform(ViewActions.scroll(0));
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View[1]/android.support.v7.widget.LinearLayoutCompat[1]/android.widget.ImageView")).perform(ViewActions.click());
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView")).perform(ViewActions.click());
    onView(ViewMatchers.withId(android.R.id.list)).perform(ViewActions.scroll(0));
    onView(ViewMatchers.withId(android.R.id.list)).perform(ViewActions.scroll(2));
    onData(Matchers.anything()).inAdapterView(ViewMatchers.withId(android.R.id.list)).atPosition(8).loadData();
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[7]")).perform(ViewActions.click());
    onView(Matchers.allOf(ViewMatchers.isAssignableFrom("android.widget.CheckedTextView"), ViewMatchers.withText("Weight (lb)"), ViewMatchers.withParent(Matchers.allOf(ViewMatchers.isAssignableFrom("android.widget.ListView"))))).perform(ViewActions.click());
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[7]/android.widget.RelativeLayout/android.widget.TextView[2]")).check(ViewAssertions.matches(ViewMatchers.withText("LB")));
    onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack());
    onData(Matchers.anything()).inAdapterView(ViewMatchers.withId("org.epstudios.epmobile.R.id.list")).atPosition(0).loadData();
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.TextView[1]")).perform(ViewActions.click());
    onData(Matchers.anything()).inAdapterView(ViewMatchers.withId("org.epstudios.epmobile.R.id.list")).atPosition(0).loadData();
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.TextView[1]")).perform(ViewActions.click());
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.weight_spinner")).perform(ViewActions.selection(1));
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.height_spinner")).perform(ViewActions.selection(0));
    onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard(), ViewActions.sleep(100));
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView[2]/android.widget.LinearLayout/android.widget.TableLayout[1]/android.widget.TableRow[2]/android.widget.Spinner[2]/android.widget.TextView")).check(ViewAssertions.matches(ViewMatchers.withText("Weight (lb)")));
  }
}
