package com.example.customdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        val dialog = ExitDialog()
        dialog.show(supportFragmentManager, "ExitDialog")

        dialog.doneClick = {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        dialog.cancelClick = {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

    }
}