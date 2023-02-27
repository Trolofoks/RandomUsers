package com.honey.randomusers.screens.main

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun HandleBackPress(enabled: Boolean = true, onBackPressed: () -> Unit) {
    val backCallback = remember(enabled) {
        object : OnBackPressedCallback(enabled) {
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        }
    }
    val dispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    backCallback.isEnabled = enabled
    backCallback.remove()
    backCallback.isEnabled = enabled
//    backCallback.onBackPressedDispatcher = dispatcher
}