package com.example.bottomnavigationandnavigationdrawer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bottomnavigationandnavigationdrawer.databinding.ActivityButtonBinding

class ButtonActivity : AppCompatActivity() {
    lateinit var binding:ActivityButtonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBottom.setOnClickListener {
            var intent= Intent(this,BottomNavigation::class.java)
            startActivity(intent)
        }
        binding.btnDrawer.setOnClickListener {
            var intent= Intent(this,DrawerActivity::class.java)
            startActivity(intent)
        }
        binding.btnBoth.setOnClickListener {
            var intent= Intent(this,NavigationDrawerActivity::class.java)
            startActivity(intent)
        }

    }
}