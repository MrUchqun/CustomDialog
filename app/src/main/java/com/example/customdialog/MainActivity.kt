package com.example.customdialog

import android.app.Activity
import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
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

        Toast(this).showCustomToast("Ok",this)

        dialog.doneClick = {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        dialog.cancelClick = {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

    }
}

fun Toast.showCustomToast(message: String, activity: Activity) {

    val layout = activity.layoutInflater.inflate(
        R.layout.custom_dialog,
        activity.findViewById(R.id.custom),
    )

    val toastMessage = layout.findViewById<TextView>(R.id.cancel_txt)
    toastMessage.text = message

    this.apply {
        setGravity(Gravity.BOTTOM,0,200)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}