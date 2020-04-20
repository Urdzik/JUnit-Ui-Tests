package com.example.testing

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Before
    fun setup() {
        // Setting up before every test
    }

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun changeText() {
        val text = "my test text"
        onView(withId(R.id.edit)).perform(typeText(text))
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.text)).check(matches(withText(text)))
    }
    @Test
    fun changeTextEmpty(){
       onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.text)).check(matches(withText("Парень, это поле пустое. Ты идеот! А я просто не могу нажать точку")))
    }

}