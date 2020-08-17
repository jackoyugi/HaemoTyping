package co.ke.biofit.haemotyping;

import android.view.View;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.ke.biofit.haemotyping.ui.MakeUpListActivity;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class CollectedSampleActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<MakeUpListActivity> activityTestRule =
            new ActivityTestRule<>(MakeUpListActivity.class);


    @Test
    public void listItemClickDisplaysToastWithCorrectCollectedSample() {
        View activityDecorView = activityTestRule.getActivity().getWindow().getDecorView();
        String collectedSample = "Winnie the Bleck";
        onData(anything())
                .inAdapterView(withId(R.id.listView))
                .atPosition(0)
                .perform(click());
        onView(withText(collectedSample)).inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(collectedSample)));
    }
}
