package edu.singaporetech.busstopdb

import android.util.Log
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.equalToIgnoringCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class AddBusStopActivityTest {
    companion object {
        private const val TAG = "AddBusStopActivityTest"
    }

    @get:Rule
    var activityRule = activityScenarioRule<AddBusStopActivity>()

    @Test
    fun youNeedToEnsureThisWillCompile() {
        Log.i(
            TAG, "\n### 2. UI elements all exist in AddBusStopActivityTest" +
                    "\n- editTextBusStopCode, editTextRoadName, editTextBusStopDesc exist within popup xml" +
                    "\n- buttons with labels \"ADD\" and \"CLEAR\" exist"
        )

        onView(withId(R.id.editTextBusStopCode)).check(matches(isDisplayed()))
        onView(withId(R.id.editTextRoadName)).check(matches(isDisplayed()))
        onView(withId(R.id.editTextBusStopDesc)).check(matches(isDisplayed()))
        onView(withText(equalToIgnoringCase("ADD"))).check(matches(isDisplayed()))
        onView(withText(equalToIgnoringCase("CLEAR"))).check(matches(isDisplayed()))
    }
}
