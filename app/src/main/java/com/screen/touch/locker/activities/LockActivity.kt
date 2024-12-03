package com.screen.touch.locker.activities

import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.screen.touch.locker.R

class LockActivity : AppCompatActivity() {

    private val preferences by lazy {
        getSharedPreferences("AppSettings", MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return true
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val savedKeyCode = preferences.getInt("keyCode", KeyEvent.KEYCODE_HOME)
        return if (keyCode == savedKeyCode) {
            finish()
            true
        } else {
            super.onKeyDown(keyCode, event)
        }
    }
}
