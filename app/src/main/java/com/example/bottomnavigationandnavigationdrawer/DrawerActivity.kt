package com.example.bottomnavigationandnavigationdrawer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.bottomnavigationandnavigationdrawer.databinding.ActivityDrawerBinding
import com.example.bottomnavigationandnavigationdrawer.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class DrawerActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    lateinit var binding: ActivityDrawerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        Inside our MainActivity, we will first set the toolbar as a actionbar.
        setSupportActionBar(binding.drawerMainLayout.toolbar)

    //toggle handle the event when we click on hamburger sign (3 lines) it will display menu it bind all components
        val toggle=ActionBarDrawerToggle(this,binding.drawerLayout,binding.drawerMainLayout.toolbar,R.string.open,R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        binding.navigationView.setNavigationItemSelectedListener(this)

    }
// this method handle menu item click
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        when(item.itemId){
            R.id.homeFragment->{
                changeFragment(HomeFragment())
            }
            R.id.showsFragment->{
                changeFragment(ShowsFragment())
            }
            R.id.catchupFragment->{
                changeFragment(CatchupFragment())

            }  R.id.newsActivity->{
            var intent=Intent(this,NewsActivity::class.java)
            startActivity(intent)
        }
        }
        return true
    }

private fun changeFragment(frag:Fragment){
val fragment=supportFragmentManager.beginTransaction()
    fragment.replace(binding.fragmentContainerView.id,frag).commit()
}

}