package com.mendhie.c2capp.presentation.activities

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.mendhie.c2capp.R
import com.mendhie.c2capp.data.models.Exhibit
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{
    /**
     * Get activityScenerioRule for the MainActivity
     */
    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
    /**
     * Test that the recyclerView on the MainActivity is visible
     */
    @Test
    fun testIsRecyclerViewVisible(){
        Thread.sleep(2000)
        onView(withId(R.id.lstAllExhibits)).check(matches(isDisplayed()))
    }

    /**
     * Test that the recylerView is populated
     */
    @Test
    fun testRecyclerViewIsPopulated(){
        Thread.sleep(2000)
        activityRule.scenario.onActivity { activity ->
            val recyclerView: RecyclerView = activity.findViewById(R.id.lstAllExhibits)
            val itemCount = (recyclerView.adapter)?.itemCount ?: 0
            assertEquals(true, itemCount>0)
        }
    }

    /**
     * Test that the recylerView is scrolling
     */
    @Test
    fun testRecyclerViewIsScrolling(){
        Thread.sleep(2000)
        onView(withId(R.id.lstAllExhibits)).perform(ScrollToBottom())
    }

    class ScrollToBottom: ViewAction{
        override fun getConstraints(): Matcher<View> {
            return allOf(isAssignableFrom(RecyclerView::class.java))
        }

        override fun getDescription(): String {
            return "scroll RecyclerView to bottom"
        }

        override fun perform(uiController: UiController?, view: View?) {
            val recyclerView = view as RecyclerView
            val itemCount = recyclerView.adapter?.itemCount
            val position =  itemCount?.minus(1) ?: 0
            recyclerView.scrollToPosition(position)
            uiController?.loopMainThreadUntilIdle()
        }
    }
}