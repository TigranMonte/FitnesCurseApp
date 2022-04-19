package ru.tikodvlp.fitnesscurseapp.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.tikodvlp.fitnesscurseapp.adapters.ExerciseModel

class MainViewModel : ViewModel() {

    val mutableListExercise = MutableLiveData<ArrayList<ExerciseModel>> ()
}