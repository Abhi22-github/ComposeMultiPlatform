package com.roaa.composemultiplatform

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIAlertAction
import platform.UIKit.UIAlertActionStyleDefault
import platform.UIKit.UIAlertController
import platform.UIKit.UIAlertControllerStyleAlert
import platform.UIKit.UIApplication

fun MainViewController() = ComposeUIViewController {
    App(onConditionReachedCallback = { counter ->
        if (counter == 10) {
            showIosAlert(
                title = "Condition Reached", message = "Counter value is $counter"
            )
        }
    })
}

fun showIosAlert(title: String, message: String) {
    val rootController = UIApplication.sharedApplication.keyWindow?.rootViewController ?: return

    val alert = UIAlertController.alertControllerWithTitle(
        title = title, message = message, preferredStyle = UIAlertControllerStyleAlert
    )

    alert.addAction(
        UIAlertAction.actionWithTitle(
            "OK", UIAlertActionStyleDefault
        ) { _ -> })

    rootController.presentViewController(alert, animated = true, completion = null)
}

