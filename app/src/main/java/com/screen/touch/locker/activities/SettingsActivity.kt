package com.screen.touch.locker.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.screen.touch.locker.R

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val assignKeyButton: Button = findViewById(R.id.btn_assign_key)
        val startLockButton: Button = findViewById(R.id.btn_start_lock)

        assignKeyButton.setOnClickListener {
            saveButtonPreference("HOME")
            Toast.makeText(this, "Кнопка HOME выбрана для разблокировки", Toast.LENGTH_SHORT).show()
        }

        startLockButton.setOnClickListener {
            startActivity(Intent(this, LockActivity::class.java))
        }
    }

    private fun saveButtonPreference(button: String) {
        val sharedPref = getSharedPreferences("settings", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("lock_button", button)
            apply()
        }
    }
}
