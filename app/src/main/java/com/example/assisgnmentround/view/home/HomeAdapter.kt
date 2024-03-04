package com.example.assisgnmentround.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assisgnmentround.databinding.ItemLayoutEmployeeListBinding
import com.example.assisgnmentround.room_database.EmployeeEntity


class HomeAdapter(private var items: List<EmployeeEntity>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemLayoutEmployeeListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: EmployeeEntity) {
            binding.tvAgeValue.text = item.age
            binding.textView4.text = item.first_name
            binding.tvLastNameValue.text = item.last_name
            binding.tvAddressValue.text = item.address
            binding.tvCityvalue.text = item.city
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding =
            ItemLayoutEmployeeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }
    fun updateData(newData: List<EmployeeEntity>) {
        items = newData
        notifyDataSetChanged() // Notify RecyclerView that dataset has changed
    }
    override fun getItemCount(): Int {
        return items.size
    }}