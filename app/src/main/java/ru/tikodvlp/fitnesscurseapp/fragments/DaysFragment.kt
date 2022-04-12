package ru.tikodvlp.fitnesscurseapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.tikodvlp.fitnesscurseapp.R
import ru.tikodvlp.fitnesscurseapp.adapters.DayModel
import ru.tikodvlp.fitnesscurseapp.databinding.FragmentDaysBinding

class DaysFragment : Fragment() {

    private lateinit var binding: FragmentDaysBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDaysBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun fillDaysArray(): ArrayList<DayModel> {
        val tempArray = ArrayList<DayModel>() // временный экземпляр класса для послед. заполнения
        resources.getStringArray(R.array.day_exercise).forEach {
            tempArray.add(DayModel(it, false))
        }
        return tempArray
    }

    companion object {
        @JvmStatic
        fun newInstance() = DaysFragment()
    }
}