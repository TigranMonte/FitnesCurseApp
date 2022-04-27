package ru.tikodvlp.fitnesscurseapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import ru.tikodvlp.fitnesscurseapp.R
import ru.tikodvlp.fitnesscurseapp.adapters.DayModel
import ru.tikodvlp.fitnesscurseapp.adapters.DaysAdapter
import ru.tikodvlp.fitnesscurseapp.adapters.ExerciseAdapter
import ru.tikodvlp.fitnesscurseapp.adapters.ExerciseModel
import ru.tikodvlp.fitnesscurseapp.databinding.ExercisesListFragmentBinding
import ru.tikodvlp.fitnesscurseapp.databinding.FragmentDaysBinding
import ru.tikodvlp.fitnesscurseapp.utils.FragmentManager
import ru.tikodvlp.fitnesscurseapp.utils.MainViewModel

class ExercisesListFragment : Fragment() {

    private lateinit var binding: ExercisesListFragmentBinding
    private lateinit var adapter: ExerciseAdapter
    private var ab: ActionBar? = null
    private val model: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ExercisesListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        model.mutableListExercise.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun init() = with (binding){
        ab = (activity as AppCompatActivity).supportActionBar
        ab?.title = getString(R.string.all_exercises)
        adapter = ExerciseAdapter()
        rcView.layoutManager = LinearLayoutManager(activity)
        rcView.adapter = adapter
        btnStart.setOnClickListener {
            FragmentManager.setFragment(WaitingFragment.newInstance(),
                activity as AppCompatActivity)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ExercisesListFragment()
    }
}