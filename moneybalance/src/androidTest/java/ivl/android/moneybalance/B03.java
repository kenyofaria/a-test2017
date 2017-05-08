package ivl.android.moneybalance;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ExpandableListView;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.AllOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;


@RunWith(AndroidJUnit4.class)
public class B03 {


    @Rule
    public ActivityTestRule<CalculationListActivity> mActivityTestRule = new ActivityTestRule<>(CalculationListActivity.class, false, false);


    @Before
    public void initActivity(){
        File root = InstrumentationRegistry.getTargetContext().getFilesDir().getParentFile();
        String[] sharedPreferencesFileNames = new File(root, "shared_prefs").list();
        if(sharedPreferencesFileNames!=null) {
            for (String fileName : sharedPreferencesFileNames) {
                InstrumentationRegistry.getTargetContext().getSharedPreferences(fileName.replace(".xml", ""), Context.MODE_PRIVATE).edit().clear().commit();
            }
        }
        mActivityTestRule.launchActivity(new Intent());
    }

    @Test
    public void test_B03() {
        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.new_calculation), withContentDescription("New Calculation"), isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction appCompatEditText = onView(
                withId(R.id.calculation_title));
        appCompatEditText.perform(scrollTo(), replaceText("test1"), closeSoftKeyboard());

        ViewInteraction appCompatSpinner = onView(
                withId(R.id.calculation_currency));
        appCompatSpinner.perform(scrollTo(), click());

        ViewInteraction appCompatCheckedTextView = onView(
                allOf(withId(android.R.id.text1), withText("Rial iemenita (YER)"), isDisplayed()));
        appCompatCheckedTextView.perform(click());

        onView(withIndex(withClassName(is("android.support.v7.widget.AppCompatEditText")), 1)).perform(click());
        onView(withIndex(withClassName(is("android.support.v7.widget.AppCompatEditText")), 1)).perform(typeText("kenyo"));

        onView(withIndex(withClassName(is("android.support.v7.widget.AppCompatEditText")), 2)).perform(click());
        onView(withIndex(withClassName(is("android.support.v7.widget.AppCompatEditText")), 2)).perform(typeText("auri"));

        ViewInteraction actionMenuItemView2 = onView(
                allOf(withId(R.id.menu_save), withContentDescription("Save"), isDisplayed()));
        actionMenuItemView2.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(android.R.id.text1), withText("kenyo"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.expense_list),
                                        0),
                                0),
                        isDisplayed()));
        Espresso.onView(ViewMatchers.withText("kenyo")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        ViewInteraction textView2 = onView(
                allOf(withId(android.R.id.text1), withText("auri"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.expense_list),
                                        1),
                                0),
                        isDisplayed()));
        Espresso.onView(ViewMatchers.withText("auri")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

    }


    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            int currentIndex = 0;

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }
        };
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    private static ViewInteraction matchTexView(CharSequence text) {
        return onView(isAssignableFrom(TextView.class))
                .check(matches(withTextInTextView(is(text))));
    }

    private static Matcher<Object> withTextInTextView(final Matcher<CharSequence> textMatcher) {
        return new BoundedMatcher<Object, TextView>(TextView.class) {
            @Override
            protected boolean matchesSafely(TextView textView) {
                return textMatcher.matches(textView.getText());
            }

            @Override public void describeTo(Description description) {
                description.appendText("with text: ");
                textMatcher.describeTo(description);
            }
        };
    }
}
