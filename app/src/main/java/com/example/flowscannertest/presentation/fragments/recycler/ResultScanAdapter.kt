package com.example.flowscannertest.presentation.fragments.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flowscannertest.domain.models.ResultScan

class ResultScanAdapter(
    private val onItemClickListener: ClickListener
) : RecyclerView.Adapter<ResultScanViewHolder>() {

    private var items: List<ResultScan> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultScanViewHolder {
        return ResultScanViewHolder.newInstance(parent, onItemClickListener)
    }

    override fun onBindViewHolder(holder: ResultScanViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount() = items.size

    fun submitList(data: List<ResultScan>) {
        notifyDataSetChanged()
        items = data
    }
}