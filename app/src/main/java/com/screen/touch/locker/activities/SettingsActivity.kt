package com.screen.touch.locker.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SettingsScreen(
                onSaveSettings = {
                    // Сохраните настройки
                    Toast.makeText(this, "Settings Saved", Toast.LENGTH_SHORT).show()
                    finish() // Закрыть активность после сохранения
                }
            )
        }
    }
}

@Composable
fun SettingsScreen(onSaveSettings: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text("Settings Screen")
        Button(
            onClick = { onSaveSettings() },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Save Settings")
        }
    }
}
