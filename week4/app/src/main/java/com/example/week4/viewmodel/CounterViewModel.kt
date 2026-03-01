package com.example.week4.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

// ============================================================
// Exercise 4 — Shared ViewModel
// ============================================================

/*
 Why ViewModel is useful here:
   ViewModel survives configuration changes (like screen rotation) and provides
   a single source of truth for UI state. Without it, the counter would reset
   every time the screen rotates or navigates.

 Why shared ViewModel instead of two separate ones:
   Both screens need to display and modify the SAME counter value. If each screen
   had its own ViewModel, they would each have an independent counter, incrementing
   on Screen A would not be visible on Screen B. A shared ViewModel ensures both
   screens read from and write to the same state.

 What would happen with separate ViewModels:
   Each screen would have its own counter starting at 0. Changes on one screen
   would be invisible to the other. The user would see different values on each
   screen, which defeats the purpose.

 Where should ViewModel be created:
   The ViewModel should be scoped to the Activity (or the NavGraph) so it lives
   as long as both screens exist. In Compose, we create it at the activity level
   using viewModel() and pass it down to both screens.

 Why is ViewModel lifecycle important when navigating?
   When navigating between screens, Compose may destroy and recreate composables.
   If state lived inside the composable, it would be lost on navigation. ViewModel
   persists across navigation events, so the counter value survives screen switches.
*/

class CounterViewModel : ViewModel() {
    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count

    fun increment() {
        _count.value++
    }

    fun decrement() {
        _count.value--
    }
}
