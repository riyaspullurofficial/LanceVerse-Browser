package app.riyaspullur.lanceversebrowser

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.KeyEvent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import app.riyaspullur.lanceversebrowser.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    var url: String? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Handler().postDelayed({
            val intent = Intent(this@MainActivity, BrowsingActivity::class.java)
            startActivity(intent)
        }, 3000)


    }


}