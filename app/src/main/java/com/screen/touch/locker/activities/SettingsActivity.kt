package com.screen.touch.locker.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.screen.touch.locker.R

class SettingsActivity : ComponentActivity() {
    private var isHomeButtonSelected = true

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val assignKeyButton: Button = findViewById(R.id.btn_assign_key)
        val startLockButton: Button = findViewById(R.id.btn_start_lock)

        assignKeyButton.text = "Select the Home button"

        assignKeyButton.setOnClickListener {
            if (isHomeButtonSelected) {
                saveButtonPreference("HOME")
                Toast.makeText(this, "HOME button is selected for unlocking", Toast.LENGTH_SHORT).show()
                assignKeyButton.text = "Select the Back button"
            } else {
                saveButtonPreference("BACK")
                Toast.makeText(this, "Back button is selected for unlocking", Toast.LENGTH_SHORT).show()
                assignKeyButton.text = "Select the Home button"
            }
            isHomeButtonSelected = !isHomeButtonSelected
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
