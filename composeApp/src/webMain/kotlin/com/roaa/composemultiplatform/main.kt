package com.roaa.composemultiplatform

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport {
        var showDialog by remember { mutableStateOf(false) }
        App(onConditionReachedCallback = { counter ->
            if (counter == 10) {
                showDialog = true
            }
        })
        if (showDialog) {
            PlatformAlertDialog(
                title = "Condition Reached",
                message = "Counter value is $10",
                onDismiss = { showDialog = !showDialog }
            )
        }
    }
}

@Composable
fun PlatformAlertDialog(
    title: String,
    message: String,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title) },
        text = { Text(message) },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("OK")
            }
        }
    )
}