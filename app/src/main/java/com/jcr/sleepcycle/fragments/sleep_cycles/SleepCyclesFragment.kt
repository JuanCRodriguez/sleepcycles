package com.jcr.sleepcycle.fragments.sleep_cycles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jcr.sleepcycle.R
import com.jcr.sleepcycle.databinding.FragmentSleepCyclesBinding

/**
 * A simple [Fragment] subclass.
 */
class SleepCyclesFragment : Fragment() {
    private lateinit var binding: FragmentSleepCyclesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater,
                R.layout.fragment_sleep_cycles, container, false)
        val hours = arguments!!.getString("Hour")
        val message = arguments!!.getString("Message")
        binding.hoursTextView.text = "10:30"
        binding.messageTextView.text = message.toString()
        return binding.root
    }

}
