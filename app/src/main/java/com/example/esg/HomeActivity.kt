package com.example.esg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        getSupportActionBar()?.setDisplayShowTitleEnabled(false);

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.overflowIcon = getDrawable(R.drawable.baseline_menu_24)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.home -> {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            true
        }
        R.id.ranking -> {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}