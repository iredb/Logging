package com.example.logging

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val TAG: String = "From EditText"

        val editText = findViewById<EditText>(R.id.edit_text)
        val buttonLog = findViewById<Button>(R.id.button_log)
        val buttonTimber = findViewById<Button>(R.id.button_timber)

        buttonLog.setOnClickListener {
            val text = editText.text.toString()
            Log.v(TAG, text)
        }

        Timber.plant(Timber.DebugTree())
        buttonTimber.setOnClickListener {
            val text = editText.text.toString()
            Timber.v(text)
        }
    }
}