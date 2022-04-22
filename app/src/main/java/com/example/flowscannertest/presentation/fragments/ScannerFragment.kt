package com.example.flowscannertest.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import com.example.flowscannertest.R
import com.example.flowscannertest.ScannerApplication
import com.example.flowscannertest.databinding.FragmentScannerBinding
import com.example.flowscannertest.presentation.ext.openFragment
import java.util.*
import javax.inject.Inject

class ScannerFragment : Fragment(R.layout.fragment_scanner) {

    private val binding: FragmentScannerBinding by viewBinding()
    private lateinit var codeScanner: CodeScanner

    @Inject
    lateinit var viewModel: MainViewModel

    companion object {
        const val TAG = "FragmentScanner"
        fun newInstance() = ScannerFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ScannerApplication.appComponent?.inject(this)
        val scannerView = view.findViewById<CodeScannerView>(R.id.scanner_view)
        val activity = requireActivity()
        codeScanner = CodeScanner(activity, scannerView)
        codeScanner.decodeCallback = DecodeCallback {
            activity.runOnUiThread {
                Toast.makeText(activity, it.text, Toast.LENGTH_LONG).show()
                viewModel.addScanToData(
                    it.text,
                    Calendar.getInstance().time
                )
                requireActivity().openFragment(
                    HistoryFragment.newInstance(),
                    HistoryFragment.TAG,
                    R.id.container
                )
            }
        }
        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }
    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }
}