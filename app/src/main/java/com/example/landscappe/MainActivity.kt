package com.example.landscappe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.landscappe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val landscapeList = ArrayList<Landscape>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        fillTheList()
        val myAdapter = LandscapeAdapter(landscapeList)
        binding.recyclerView.adapter = myAdapter
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)
        binding.recyclerView.layoutManager = linearLayoutManager
    }

    private fun fillTheList(): ArrayList<Landscape>{

        val allLandscapeImage = arrayOf(
            R.drawable.ls1,
            R.drawable.ls2,
            R.drawable.ls3,
            R.drawable.ls4,
            R.drawable.ls5,
            R.drawable.ls6,
            R.drawable.ls7,
            R.drawable.ls8,
            R.drawable.ls9,
            R.drawable.ls10,
            R.drawable.ls11,
            R.drawable.ls12,
            R.drawable.ls13,
            R.drawable.ls14,
            R.drawable.ls15,
            R.drawable.ls16,
            R.drawable.ls17,
            R.drawable.ls18,
            R.drawable.ls19,
            R.drawable.ls20,
            R.drawable.ls21,
            R.drawable.ls22,
            R.drawable.ls23,
            R.drawable.ls24,
        )
        for (i in allLandscapeImage.indices){
            val landscapeListElement = Landscape("Landscape $i","Explanation $i",allLandscapeImage[i])
            landscapeList.add(landscapeListElement)
        }
        return landscapeList
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuHorizontal -> {
                val menuHorizontal = LinearLayoutManager(
                    this,
                    LinearLayoutManager.HORIZONTAL,
                    false)
                binding.recyclerView.layoutManager = menuHorizontal
            }
            R.id.menuVertical -> {
                val menuVertical = LinearLayoutManager(
                    this,
                    LinearLayoutManager.VERTICAL,
                    false)
                binding.recyclerView.layoutManager = menuVertical
            }
            R.id.menuGrid -> {
                val menuGrid = GridLayoutManager(this, 2)
                binding.recyclerView.layoutManager = menuGrid
            }
            R.id.menuStaggeredHorizontal -> {
                val menuStaggeredHorizontal = StaggeredGridLayoutManager(
                    2,
                    StaggeredGridLayoutManager.HORIZONTAL)
                binding.recyclerView.layoutManager = menuStaggeredHorizontal
            }
            R.id.menuStaggeredVertical -> {
                val menuStaggeredVertical = StaggeredGridLayoutManager(
                    2,
                    StaggeredGridLayoutManager.VERTICAL)
                binding.recyclerView.layoutManager = menuStaggeredVertical
            }
        }
        return true
    }
}