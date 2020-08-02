package co.ke.biofit.haemotyping.util;

import co.ke.biofit.haemotyping.R;

public class TabUtils {
    public static final int TAB_COUNT = 4;

    private static int currentTabPosition = 0;

    private static boolean updateCurrentTab = true;

    private static final int[] tabsTitlesIds = {
            R.string.title_home_tab,
    };

    public static void setCurrentTabPosition(int position) {
        if (updateCurrentTab) currentTabPosition = position;
    }

    public static int getTabTitleId(int position) {
        return tabsTitlesIds[position];

    }
    public static int getCurrentTabPosition() {
        return currentTabPosition;
    }
    public static void setUpdateCurrentTab(boolean update) {
        updateCurrentTab = update;
    }

}
