package com.screen.touch.locker.activities

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.screen.touch.locker.R

class SettingsActivity : AppCompatActivity() {

    private val preferences by lazy {
        getSharedPreferences("AppSettings", MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val btnAssignKey: Button = findViewById(R.id.btn_assign_key)
        val btnExitMode: Button = findViewById(R.id.btn_exit_mode)

        btnAssignKey.setOnClickListener {
            Toast.makeText(this, "Нажмите кнопку для выбора", Toast.LENGTH_SHORT).show()
            setKeyListener()
        }

        btnExitMode.setOnClickListener {
            preferences.edit().remove("keyCode").apply()
            Toast.makeText(this, "Режим сброшен", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setKeyListener() {
        window.decorView.setOnKeyListener { _, keyCode, _ ->
            preferences.edit().putInt("keyCode", keyCode).apply()
            Toast.makeText(this, "Кнопка назначена: $keyCode", Toast.LENGTH_SHORT).show()
            true
        }
    }
}
