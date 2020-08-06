package co.ke.biofit.haemotyping;

import android.widget.ListView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import co.ke.biofit.haemotyping.ui.CollectedSampleActivity;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public class CollectedSampleActivityTest {
    private CollectedSampleActivity activity;
    private ListView mCollectedListView;

    @Before
    public void setup(){
        activity = Robolectric.setupActivity(CollectedSampleActivity.class);
        mCollectedListView = (ListView) activity.findViewById(R.id.listView);
    }

    @Test
    public void CollectedSampleListViewPopulates() {
        assertNotNull(mCollectedListView.getAdapter());
        assertEquals(mCollectedListView.getAdapter().getCount(), 12);
    }

}
