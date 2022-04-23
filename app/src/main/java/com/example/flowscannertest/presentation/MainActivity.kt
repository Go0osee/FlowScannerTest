package com.example.flowscannertest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.flowscannertest.R
import com.example.flowscannertest.ScannerApplication
import com.example.flowscannertest.databinding.ActivityMainBinding
import com.example.flowscannertest.presentation.ext.openFragment
import com.example.flowscannertest.presentation.fragments.HistoryFragment
import com.example.flowscannertest.presentation.fragments.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ScannerApplication.appComponent?.inject(this)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        openFragment(HistoryFragment.newInstance(), HistoryFragment.TAG, R.id.container)
    }
}