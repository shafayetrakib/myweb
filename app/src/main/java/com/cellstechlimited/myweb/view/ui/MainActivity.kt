package com.cellstechlimited.myweb.view.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.cellstechlimited.myweb.R
import com.cellstechlimited.myweb.databinding.ActivityMainBinding
import com.cellstechlimited.myweb.view.fragments.Gallery
import com.cellstechlimited.myweb.view.fragments.Login
import com.cellstechlimited.myweb.view.fragments.MarketCap
import com.cellstechlimited.myweb.view.fragments.Mybook

class MainActivity : AppCompatActivity() {
        private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(1000)
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.bottomNav.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.martktcap ->{
                    loadfragment(MarketCap())
                    true
                }
                R.id.gellary ->{
                    loadfragment(Gallery())
                    true
                }
                R.id.mybook ->{
                    loadfragment(Mybook())
                    true
                }
                R.id.login ->{
                    loadfragment(Login())
                    true
                }
                else -> false

            }

        }
        loadfragment(MarketCap())
        
    }

    private fun loadfragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
    }
}