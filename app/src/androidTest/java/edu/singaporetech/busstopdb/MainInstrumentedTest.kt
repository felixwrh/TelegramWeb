package edu.singaporetech.busstopdb

import android.util.Log
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class MainInstrumentedTest {
    companion object {
        private const val TAG = "MainInstrumentedTest"
    }

    @get:Rule
    var activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun youNeedToEnsureThisWillCompile() {
        Log.i(
            TAG, "\n### 1. UI elements all exist in MainInstrumentedTest" +
                    "\n- fabAdd exist" +
                    "\n- recyclerViewBusStops exist" +
                    "\n- textViewBusStopCode, textViewRoadName textViewBusStopDesc exist within recyclerViewBusStops"
        )

        onView(withId(R.id.fabAdd)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerViewBusStops)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerViewBusStops)).check(matches(hasDescendant(withId(R.id.textViewBusStopCode))))
        onView(withId(R.id.recyclerViewBusStops)).check(matches(hasDescendant(withId(R.id.textViewRoadName))))
        onView(withId(R.id.recyclerViewBusStops)).check(matches(hasDescendant(withId(R.id.textViewBusStopDesc))))

    }
}