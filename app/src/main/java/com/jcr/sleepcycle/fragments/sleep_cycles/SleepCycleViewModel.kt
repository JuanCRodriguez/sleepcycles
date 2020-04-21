package com.jcr.sleepcycle.fragments.sleep_cycles

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jcr.sleepcycle.db.Hour
import com.jcr.sleepcycle.db.HourRepository

class SleepCycleViewModel : ViewModel() {

    val message = MutableLiveData<String>()

    val hours = MutableLiveData<List<String>>()


}