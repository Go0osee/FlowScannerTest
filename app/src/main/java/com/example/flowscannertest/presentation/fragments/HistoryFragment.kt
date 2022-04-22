package com.example.flowscannertest.presentation.fragments

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.flowscannertest.R
import com.example.flowscannertest.ScannerApplication
import com.example.flowscannertest.databinding.FragmentHistoryBinding
import com.example.flowscannertest.domain.models.ResultScan
import com.example.flowscannertest.presentation.ext.openFragment
import com.example.flowscannertest.presentation.fragments.recycler.ClickListener
import com.example.flowscannertest.presentation.fragments.recycler.ResultScanAdapter
import javax.inject.Inject

class HistoryFragment : Fragment(R.layout.fragment_history) {

    private val binding: FragmentHistoryBinding by viewBinding()
    private val adapter by lazy { ResultScanAdapter(onItemClickListener) }

    @Inject
    lateinit var viewModel: MainViewModel

    companion object {
        const val TAG = "FragmentHistory"
        fun newInstance() = HistoryFragment()
    }

    private val onItemClickListener by lazy {
        object : ClickListener {
            override fun onDeleteClickListener(resultScan: ResultScan) {
                viewModel.deleteResultScan(resultScan)
            }

            override fun onShareClickListener(resultScan: ResultScan) {
                openChatApp(resultScan.link)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ScannerApplication.appComponent?.inject(this)

        initViews()
    }

    private fun initViews() {

        binding.recycler.apply {
            adapter = this@HistoryFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.resultScan.observe(viewLifecycleOwner) { items ->
            adapter.submitList(items)
        }


        binding.scanBtn.setOnClickListener {

            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.CAMERA),
                1
            );

            requireActivity().openFragment(
                ScannerFragment.newInstance(),
                ScannerFragment.TAG,
                R.id.container
            )
        }
    }

    private fun openChatApp(link: String) {
        val intent = Intent().apply {
            type = "text/plain"

            action = Intent.ACTION_SEND

            putExtra(Intent.EXTRA_TEXT, link)
        }
        val intentChooser = Intent.createChooser(intent, "")
        startActivity(intentChooser)
    }
}