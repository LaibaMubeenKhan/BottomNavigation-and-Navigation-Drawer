package com.example.bottomnavigationandnavigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.bottomnavigationandnavigationdrawer.databinding.ActivityMainBinding
import com.example.bottomnavigationandnavigationdrawer.databinding.ActivityNavigationDrawerBinding

class NavigationDrawerActivity : AppCompatActivity() {
    lateinit var binding: ActivityNavigationDrawerBinding
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNavigationDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //this is the id of fragment which we add in xml where our views will exchange
        //navController is used for navigation between fragments present inside nav Graph
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)

        //navigation Up button for back trace to default fragment
        //Navigation UI shows up button on tool bar
        NavigationUI.setupActionBarWithNavController(this,navController,binding.drawerLayout)

        appBarConfiguration= AppBarConfiguration(navController.graph,binding.drawerLayout)

            //drawer Navigation
        NavigationUI.setupWithNavController(binding.navigationView,navController)
    }

    //    this method handle click on up button
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,appBarConfiguration)
    }
}