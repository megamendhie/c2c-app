package com.mendhie.c2capp.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.mendhie.c2capp.data.models.Exhibit
import com.mendhie.c2capp.databinding.ActivityMainBinding
import com.mendhie.c2capp.domain.viewmodels.ExhibitViewModel
import com.mendhie.c2capp.presentation.adapters.ExhibitAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: ExhibitViewModel by viewModels()
    private val adapter = ExhibitAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lstAllExhibits.layoutManager = LinearLayoutManager(this)
        binding.lstAllExhibits.adapter = adapter

        //listen to data change in viewModel and update recyclerView
        viewModel.getExhibits().observe(this, {exhibits -> updateExhibits(exhibits!!) })

        //listen for http request error and display message accordingly
        viewModel.errorListener().observe(this, {error ->
            Snackbar.make(binding.lstAllExhibits, error, Snackbar.LENGTH_SHORT).show()
        })
    }

    private fun updateExhibits(exhibits: List<Exhibit>) {
        adapter.updateExhibits(exhibits)
    }
}