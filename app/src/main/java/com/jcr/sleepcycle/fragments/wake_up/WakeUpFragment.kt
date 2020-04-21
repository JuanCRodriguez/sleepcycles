package com.jcr.sleepcycle.fragments.wake_up

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jcr.sleepcycle.R
import com.jcr.sleepcycle.adapters.HourListRecyclerViewAdapter
import com.jcr.sleepcycle.databinding.FragmentWakeUpBinding
import com.jcr.sleepcycle.db.Hour
import com.jcr.sleepcycle.db.HourDatabase
import com.jcr.sleepcycle.db.HourRepository

class WakeUpFragment : Fragment() {

    private lateinit var binding: FragmentWakeUpBinding
    private lateinit var viewModel: WakeUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_wake_up, container, false
        )
        val dao = HourDatabase.getInstance(context!!).hourDao
        val repository = HourRepository(dao)
        val factory = WakeUpViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(WakeUpViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        initRecyclerView()
        binding.commitEditButton.setOnClickListener {
            commitUpdate()
        }
        return binding.root
    }

    private fun initRecyclerView() {
        binding.hoursRecyclerView.layoutManager = LinearLayoutManager(context!!)
        displayHoursList()
    }

    private fun displayHoursList() {
        viewModel.hours.observe(viewLifecycleOwner, Observer {
            Log.i("MYTAG", it.toString())
            binding.hoursRecyclerView.adapter =
                HourListRecyclerViewAdapter(it, { selectedItem: Hour -> editHour(selectedItem) })
        })
    }

    private fun editHour(hour: Hour) {
        viewModel.initUpdate(hour)
    }

    private fun commitUpdate() {
        viewModel.commitUpdate()
        Toast.makeText(activity, "Hour edited succesfully", Toast.LENGTH_LONG).show()
    }
}


//        binding.wakeUpButton.setOnClickListener {
//            val text = binding.hourTextEdit.text
//            if (!TextUtils.isEmpty(text.toString())) {
//                val bundle = bundleOf(
//                    "Hour" to binding.hourTextEdit.text.toString(),
//                    "Message" to "You have to go to bed at any of these times to wake up at ${binding.hourTextEdit.text}"
//                )
//                it.findNavController()
//                    .navigate(R.id.action_wakeUpFragment_to_sleepCyclesFragment, bundle)
//            } else {
//                Toast.makeText(activity, "Hour cannot be empty", Toast.LENGTH_LONG).show()
//            }