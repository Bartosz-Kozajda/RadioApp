package com.bkozajda.radioapp.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.bkozajda.radioapp.R
import com.bkozajda.radioapp.presentation.main.presentation.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController: NavController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setSupportActionBar(toolbar)
        setupNavigationDrawer(navController)
        setupNavigationView(navController)
    }

    private fun setupNavigationDrawer(navController: NavController) {
        NavigationUI.setupWithNavController(toolbar, navController, drawer_layout)
    }

    private fun setupNavigationView(navController: NavController) {
        NavigationUI.setupWithNavController(nav_view, navController)
    }
}
