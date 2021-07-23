package com.smartphone_codes.extinctanimals

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.smartphone_codes.extinctanimals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var controller:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        

        val fragContainer = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        controller = fragContainer.navController
        setupActionBarWithNavController(controller)

        supportActionBar?.title = "Extinct Animals"
    }

    override fun onSupportNavigateUp(): Boolean {
        return controller.navigateUp() || super.onSupportNavigateUp()
    }

}