package com.example.uitestingviewpagernavigation

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.uitestingviewpagernavigation.R.id
import org.hamcrest.*
import org.hamcrest.core.AllOf.*
import org.junit.*
import org.junit.Assert.*
import org.junit.runner.*

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @get : Rule
    val activityScenario = ActivityScenarioRule(MainActivity::class.java)

    /**
     * Testing the functionality of viewpager
     */

    @Test
    fun test_FragmentOne_isDisplayed_onStartUp() {
        onView(
            allOf(
                ViewMatchers.withId(id.FragmentOne_rootLayout),
                ViewMatchers.isDescendantOfA(ViewMatchers.withId(id.MainActivity_viewPager))
            )
        )
    }

    @Test
    fun test_navigation_ViewPager() {

        //Action
        onView(ViewMatchers.withId(id.MainActivity_viewPager)).perform(ViewActions.swipeLeft())

        //Check View
        onView(
            CoreMatchers.allOf(
                ViewMatchers.withId(id.FragmentTwo_rootLayout),
                ViewMatchers.isDescendantOfA(ViewMatchers.withId(id.MainActivity_viewPager))
            )
        )

        //Action
        onView(ViewMatchers.withId(id.MainActivity_viewPager)).perform(ViewActions.swipeLeft())

        //Check View
        onView(
            CoreMatchers.allOf(
                ViewMatchers.withId(id.FragmentThree_rootLayout),
                ViewMatchers.isDescendantOfA(ViewMatchers.withId(id.MainActivity_viewPager))
            )
        )
    }




}