package ru.tikodvlp.fitnesscurseapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.tikodvlp.fitnesscurseapp.R
import ru.tikodvlp.fitnesscurseapp.adapters.DayModel
import ru.tikodvlp.fitnesscurseapp.adapters.DaysAdapter
import ru.tikodvlp.fitnesscurseapp.adapters.ExerciseModel
import ru.tikodvlp.fitnesscurseapp.databinding.FragmentDaysBinding
import ru.tikodvlp.fitnesscurseapp.utils.FragmentManager
import ru.tikodvlp.fitnesscurseapp.utils.MainViewModel

class DaysFragment : Fragment(), DaysAdapter.Listener {

    private lateinit var binding: FragmentDaysBinding
    private val model: MainViewModel by activityViewModels()
    private var ab: ActionBar? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDaysBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.currentDay = 0
        initRcView()
    }

    private fun initRcView() = with(binding) {
        val adapter = DaysAdapter(this@DaysFragment)
        ab = (activity as AppCompatActivity).supportActionBar
        ab?.title = getString(R.string.days_train)
        rcViewDays.layoutManager = LinearLayoutManager(activity as AppCompatActivity)
        rcViewDays.adapter = adapter
        adapter.submitList(fillDaysArray())
    }

    private fun fillDaysArray(): ArrayList<DayModel> {
        val tempArray = ArrayList<DayModel>() // временный экземпляр класса для послед. заполнения
        var daysDoneCounter = 0
        resources.getStringArray(R.array.day_exercises).forEach {
            model.currentDay++
            val exCounter = it.split(",").size
            tempArray.add(DayModel(it, 0,model.getExerciseCount() == exCounter))
        }
        binding.progressBar.max = tempArray.size
        tempArray.forEach {
            if (it.isDone) daysDoneCounter++
        }
        updateRestDaysUI(tempArray.size - daysDoneCounter, tempArray.size)
        return tempArray
    }

    private fun updateRestDaysUI(restDays: Int, days: Int)= with (binding) {
        val rDays = getString(R.string.rest) + " $restDays " + getString(R.string.rest_days)
        tvRestDays.text = rDays
        progressBar.progress = days - restDays
    }

    private fun fillExerciseList(day: DayModel) {
        val tempList = ArrayList<ExerciseModel>()
        day.exercises.split(",").forEach{
            val exerciseList = resources.getStringArray(R.array.exercise)
            val exercise = exerciseList[it.toInt()]
            val exerciseArray = exercise.split("|")
            tempList.add(ExerciseModel(exerciseArray[0], exerciseArray[1], false, exerciseArray[2]))
        }
        model.mutableListExercise.value = tempList
    }

    companion object {
        @JvmStatic
        fun newInstance() = DaysFragment()
    }

    override fun onClick(day: DayModel) {
        fillExerciseList(day)
        model.currentDay = day.dayNumber
        FragmentManager.setFragment(ExercisesListFragment.newInstance(),
            activity as AppCompatActivity)
    }
}