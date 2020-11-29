package com.example.composeplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.composeplayground.ui.ComposePlaygroundTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val counterState = remember { mutableStateOf(0) }
                GreetingText(counterState.value.toString())
                AddOneButton(counterState)
            }
        }
    }
}

@Composable
fun GreetingText(name: String) {
    Text(text = "Value is $name!")
}

@Composable
fun AddOneButton(func: MutableState<Int>) {
    Button(
        onClick = {
            func.value++
        },
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Add One")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePlaygroundTheme {
        val counterState = remember { mutableStateOf(0) }
        GreetingText(counterState.value.toString())
        AddOneButton(counterState)
    }
}