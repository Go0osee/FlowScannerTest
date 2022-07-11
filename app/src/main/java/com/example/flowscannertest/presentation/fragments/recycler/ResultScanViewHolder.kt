package com.example.flowscannertest.presentation.fragments.recycler

import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.flowscannertest.databinding.ItemResultScanBinding
import com.example.flowscannertest.domain.mapper.toDateString
import com.example.flowscannertest.domain.mapper.toTimeString
import com.example.flowscannertest.domain.models.ResultScan

class ResultScanViewHolder(
    private val binding: ItemResultScanBinding,
    private val onItemClickListener: ClickListener
) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun newInstance(
            parent: ViewGroup,
            onItemClickListener: ClickListener
        ) = ResultScanViewHolder(
            ItemResultScanBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onItemClickListener
        )
    }

    fun bindItem(item: ResultScan) {
        with(itemView) {
            binding.link.text = item.link
            binding.time.text = item.dateAndTime.toTimeString()
            binding.date.text = item.dateAndTime.toDateString()
        }
        binding.delete.setOnClickListener {
            onItemClickListener.onDeleteClickListener(item)
        }
        binding.share.setOnClickListener {
            onItemClickListener.onShareClickListener(item)
        }
    }
}