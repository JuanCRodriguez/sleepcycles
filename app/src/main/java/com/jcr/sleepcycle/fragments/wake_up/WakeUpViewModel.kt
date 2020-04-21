package com.jcr.sleepcycle.fragments.wake_up

import android.widget.Toast
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcr.sleepcycle.db.Hour
import com.jcr.sleepcycle.db.HourRepository
import kotlinx.coroutines.launch

class WakeUpViewModel(private val repository: HourRepository) : ViewModel(), Observable {

    @Bindable
    val inputHour = MutableLiveData<String>()

    val hours = repository.hours

    val isEditing = MutableLiveData<Boolean>()
    private lateinit var editHour: Hour

    init {
        isEditing.value = false
    }

    fun insert(hour: Hour) = viewModelScope.launch {
        repository.insert(hour)
    }

    fun update(hour: Hour) = viewModelScope.launch {
        repository.update(hour)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    fun delete(hour: Hour) = viewModelScope.launch {
        repository.delete(hour)
    }

    fun clearAll() = viewModelScope.launch {
        if (isEditing.value!!) finishEdit()
        repository.deleteAll()
    }

    fun saveHour() {
        insert(Hour(0, inputHour.value!!))
        inputHour.value = null
    }

    fun initUpdate(hour: Hour) {
        editHour = hour
        inputHour.value = editHour.hour
        isEditing.value = true
    }

    fun commitUpdate(){
        editHour.hour = inputHour.value!!
        update(editHour)
        finishEdit()
//        Toast.makeText(, "Hour edited succesfully", Toast.LENGTH_LONG).show()
    }

    fun finishEdit() {
        inputHour.value = null
        isEditing.value = false
    }

}