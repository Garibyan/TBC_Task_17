package com.garibyan.armen.tbc_task_17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.garibyan.armen.tbc_task_17.adapter.SideMenuAdapter
import com.garibyan.armen.tbc_task_17.databinding.ActivityMainBinding
import com.garibyan.armen.tbc_task_17.model.itemList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val itemAdapter: SideMenuAdapter by lazy { SideMenuAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            rvItems.adapter = itemAdapter
            rvItems.layoutManager = LinearLayoutManager(this@MainActivity)
            itemAdapter.submitList(itemList)
        }

    }
}