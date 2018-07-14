package com.bkozajda.radioapp.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
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
        val host: NavHostFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return
        setSupportActionBar(toolbar)
        setupNavigationDrawer(host)
        setupNavigationView(host)
    }

    private fun setupNavigationDrawer(host: NavHostFragment) {
        NavigationUI.setupWithNavController(toolbar, host.navController, drawer_layout)
    }

    private fun setupNavigationView(host: NavHostFragment) {
        NavigationUI.setupWithNavController(nav_view, host.navController)
    }
}
