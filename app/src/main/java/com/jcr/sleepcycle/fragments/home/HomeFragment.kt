package com.jcr.sleepcycle.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.jcr.sleepcycle.R
import com.jcr.sleepcycle.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_home, container, false)
        binding.goToBedButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_wakeUpFragment)
        }
        return binding.root
    }

}
