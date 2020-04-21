package com.jcr.sleepcycle.fragments.wake_up

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jcr.sleepcycle.db.HourRepository
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class WakeUpViewModelFactory(private val repository: HourRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WakeUpViewModel::class.java)) {
            return WakeUpViewModel(repository) as T
        }
        throw IllegalArgumentException()
    }
}