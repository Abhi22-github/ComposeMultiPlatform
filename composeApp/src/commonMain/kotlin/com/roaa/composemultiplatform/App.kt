package com.roaa.composemultiplatform

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(onConditionReachedCallback: (counter: Int) -> Unit = {}) {
    MaterialTheme {
        var counter by remember { mutableIntStateOf(0) }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = counter.toString(),
                fontSize = 96.sp
            )
            Spacer(modifier = Modifier.height(40.dp))
            Row {
                Button(
                    onClick = { counter-- }
                ) {
                    Text(text = "Decrease Counter")
                }
                Spacer(modifier = Modifier.width(40.dp))
                Button(
                    onClick = {
                        counter++
                        onConditionReachedCallback(counter)
                    }
                ) {
                    Text(text = "Increase Counter")
                }
            }
        }


    }
}

