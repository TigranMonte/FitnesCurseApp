package ru.tikodvlp.fitnesscurseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.tikodvlp.fitnesscurseapp.fragments.DaysFragment
import ru.tikodvlp.fitnesscurseapp.utils.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FragmentManager.setFragment(DaysFragment.newInstance(), this)
    }
}