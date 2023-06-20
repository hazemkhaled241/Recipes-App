package com.example.recipesapp.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.recipesapp.R
import com.example.recipesapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.NavHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration.Builder(
            setOf(
                R.id.recipesFragment,
                R.id.favoriteFragment
            )
        ).build()
        setupNavigationComponent()
    }



private fun setupNavigationComponent() {
    val navHostFragment =
        supportFragmentManager.findFragmentById(R.id.NavHostFragment) as NavHostFragment
    navController = navHostFragment.findNavController()
    binding.bottomNavigationView.background = null
    binding.bottomNavigationView.setupWithNavController(navController)
}
}