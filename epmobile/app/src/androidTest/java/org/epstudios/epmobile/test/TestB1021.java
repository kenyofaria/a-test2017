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
public class TestB1021 extends BaristaTest<Activity> {
  public TestB1021() {
    super(BaristaTest.getClassFromString("org.epstudios.epmobile.EpMobile"));
  }
  public void setUp()
      throws Exception {
    super.setUp();
    setCurrentActivity(getActivity());
  }
  public void testB1021() {
    onView(ViewMatchers.withId("org.epstudios.epmobile.R.id.list")).perform(ViewActions.scroll(0));
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View[1]/android.support.v7.widget.LinearLayoutCompat[1]/android.widget.ImageView")).perform(ViewActions.click());
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView")).perform(ViewActions.click());
    onView(ViewMatchers.withId(android.R.id.title)).check(ViewAssertions.matches(ViewMatchers.withText("About EP Mobile")));
    onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack());
    onView(ViewMatchers.withXPath("/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View[1]/android.widget.TextView[2]")).check(ViewAssertions.matches(ViewMatchers.withText("EP Mobile")));
  }
}
