package com.example.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.home.databinding.ItemReceiptBinding
import com.mathe.core.interactors.brazilPattern
import com.mathe.domain.Transaction

class ReceiptAdapter : RecyclerView.Adapter<ReceiptAdapter.ViewHolder>() {
    var data = mutableListOf<Transaction>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemReceiptBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class ViewHolder(private val binding: ItemReceiptBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(transaction: Transaction) {
            binding.transaction = transaction
            binding.buyValueCoin.text = transaction.buyValue.toString()
            binding.sellValueCoin.text = transaction.sellValue.toString()
            binding.date.text= transaction.date
        }
    }
}