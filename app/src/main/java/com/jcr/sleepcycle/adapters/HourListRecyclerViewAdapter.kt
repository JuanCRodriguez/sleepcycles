package com.jcr.sleepcycle.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jcr.sleepcycle.R
import com.jcr.sleepcycle.databinding.ListItemBinding
import com.jcr.sleepcycle.db.Hour
import com.jcr.sleepcycle.generated.callback.OnClickListener

class HourListRecyclerViewAdapter(
    private val hours: List<Hour>, private val onClickListener: (Hour) -> Unit
) :
    RecyclerView.Adapter<HourListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return HourListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hours.size
    }

    override fun onBindViewHolder(holder: HourListViewHolder, position: Int) {
        holder.bind(hours[position], onClickListener)
    }
}

class HourListViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(hour: Hour, onClickListener: (Hour) -> Unit) {
        binding.hourTextView.text = hour.hour
        binding.listItemLayout.setOnClickListener{
            onClickListener(hour)
        }
    }

}