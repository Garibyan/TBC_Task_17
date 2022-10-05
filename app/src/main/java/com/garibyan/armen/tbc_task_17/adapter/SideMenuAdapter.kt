package com.garibyan.armen.tbc_task_17.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.garibyan.armen.tbc_task_17.R
import com.garibyan.armen.tbc_task_17.databinding.SideMenuItemBinding
import com.garibyan.armen.tbc_task_17.databinding.SideMenuItemWithNotificationsBinding
import com.garibyan.armen.tbc_task_17.model.SideMenuItem
import com.garibyan.armen.tbc_task_17.utils.ItemViewType

class SideMenuAdapter: ListAdapter<SideMenuItem, RecyclerView.ViewHolder>(ItemCallBack()) {

    inner class ItemViewHolder(private val binding: SideMenuItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(sideMenuItem: SideMenuItem) = with(binding){
            imgIcon.setBackgroundResource(sideMenuItem.icon)
            tvTitle.text = sideMenuItem.title
        }
    }

    inner class ItemWithNotificationsViewHolder(private val binding: SideMenuItemWithNotificationsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(sideMenuItem: SideMenuItem) = with(binding){
            imgIcon.setBackgroundResource(sideMenuItem.icon)
            tvTitle.text = sideMenuItem.title
            tvNotificationsCounter.text = sideMenuItem.counter.toString()
            tvNotificationsCounter.background.setTint(sideMenuItem.notificationColor!!)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position).counter){
            null -> ItemViewType.DEFAULT.type
            else -> ItemViewType.WITHNOTIFICATIONS.type
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            ItemViewType.DEFAULT.type -> ItemViewHolder(SideMenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> ItemWithNotificationsViewHolder(SideMenuItemWithNotificationsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ItemViewHolder -> holder.bind(getItem(position))
            is ItemWithNotificationsViewHolder -> holder.bind(getItem(position))
        }
    }

    class ItemCallBack: DiffUtil.ItemCallback<SideMenuItem>(){
        override fun areItemsTheSame(oldItem: SideMenuItem, newItem: SideMenuItem) =
            oldItem.title == newItem.title

        override fun areContentsTheSame(oldItem: SideMenuItem, newItem: SideMenuItem) =
            oldItem == newItem

    }

}