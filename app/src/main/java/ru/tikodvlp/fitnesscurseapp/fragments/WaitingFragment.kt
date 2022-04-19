package ru.tikodvlp.fitnesscurseapp.fragments

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import ru.tikodvlp.fitnesscurseapp.databinding.WaitingFragmentBinding
import ru.tikodvlp.fitnesscurseapp.utils.MainViewModel

const val COUNT_DOWN_TIME = 11000L
class WaitingFragment : Fragment() {

    private lateinit var binding: WaitingFragmentBinding
    private lateinit var timer: CountDownTimer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = WaitingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pBar.max = COUNT_DOWN_TIME.toInt()
    }

    private fun startTimer() = with (binding){
        timer = object : CountDownTimer(COUNT_DOWN_TIME, 100) {
            override fun onTick(restTime: Long) {
                pBar.progress = restTime.toInt()
            }

            override fun onFinish() {

            }

        }.start()
    }

    override fun onDetach() {
        super.onDetach()
        timer.cancel()
    }

    companion object {
        @JvmStatic
        fun newInstance() = WaitingFragment()
    }
}