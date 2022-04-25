package ru.tikodvlp.fitnesscurseapp.fragments

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import pl.droidsonroids.gif.GifDrawable
import ru.tikodvlp.fitnesscurseapp.R
import ru.tikodvlp.fitnesscurseapp.adapters.DayModel
import ru.tikodvlp.fitnesscurseapp.adapters.DaysAdapter
import ru.tikodvlp.fitnesscurseapp.adapters.ExerciseAdapter
import ru.tikodvlp.fitnesscurseapp.adapters.ExerciseModel
import ru.tikodvlp.fitnesscurseapp.databinding.DayFinishFragmentBinding
import ru.tikodvlp.fitnesscurseapp.databinding.ExercisesListFragmentBinding
import ru.tikodvlp.fitnesscurseapp.databinding.FragmentDaysBinding
import ru.tikodvlp.fitnesscurseapp.databinding.WaitingFragmentBinding
import ru.tikodvlp.fitnesscurseapp.utils.FragmentManager
import ru.tikodvlp.fitnesscurseapp.utils.MainViewModel
import ru.tikodvlp.fitnesscurseapp.utils.TimeUtils

class DayFinishFragment : Fragment() {

    private lateinit var binding: DayFinishFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DayFinishFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imMain.setImageDrawable(GifDrawable((activity as AppCompatActivity).assets, "congrats.gif"))
        binding.btnDone.setOnClickListener {
            FragmentManager.setFragment(DaysFragment.newInstance(), activity as AppCompatActivity)
        }
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        @JvmStatic
        fun newInstance() = DayFinishFragment()
    }
}