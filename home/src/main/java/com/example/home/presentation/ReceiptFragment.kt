package com.example.home.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.home.R
import com.example.home.adapter.ReceiptAdapter
import com.example.home.databinding.FragmentReceiptBinding
import org.koin.android.viewmodel.ext.android.viewModel

class ReceiptFragment() : Fragment() {
    val viewModel: ReceiptViewModel by viewModel()
    lateinit var binding: FragmentReceiptBinding
    private val adapter = ReceiptAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getTransactions()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_receipt,
            container,
            false
        )
        binding.lifecycleOwner = this
         observableTransactions()
        return binding.root
    }

    private fun observableTransactions() {
        viewModel.transactions.observe(viewLifecycleOwner, Observer {
            adapter.data.addAll(it)
            setupRecyclerView()
        })
    }

    private fun setupRecyclerView() {
        binding.rcRcTransactios.adapter = this.adapter
        binding.rcRcTransactios.layoutManager = LinearLayoutManager(requireContext())
    }

}