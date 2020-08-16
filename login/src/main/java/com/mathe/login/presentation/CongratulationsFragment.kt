package com.mathe.login.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mathe.login.R
import com.mathe.login.databinding.FragmentCongratulationsBinding

class CongratulationsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val biding: FragmentCongratulationsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_congratulations, container, false)
        return biding.root
    }
}