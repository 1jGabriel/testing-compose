package com.example.composeplayground

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.ui.test.assertIsDisplayed
import androidx.ui.test.createAndroidComposeRule
import androidx.ui.test.onNodeWithText
import androidx.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class MyActivityTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun MyTest() {
        // Start the app
        var vaalue = 0
        composeTestRule.setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val counterState = remember { mutableStateOf(0) }
                GreetingText(name = counterState.value.toString())
                AddOneButton(func = counterState)
            }
        }


        onNodeWithText("add one", true).performClick()
        onNodeWithText("Value is 1!", true).assertIsDisplayed()
        onNodeWithText("add one", true).performClick()
        onNodeWithText("Value is 2!", true).assertIsDisplayed()
    }
}
