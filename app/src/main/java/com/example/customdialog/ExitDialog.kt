package com.example.customdialog

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class ExitDialog : DialogFragment() {

    var doneClick: ((String) -> Unit)? = null
    var cancelClick: ((String) -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.customDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.custom_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvText: TextView = view.findViewById(R.id.text)
        val tvCancel: TextView = view.findViewById(R.id.cancel_txt)
        val tvDone: TextView = view.findViewById(R.id.done_txt)

        tvDone.setOnClickListener {
//            requireActivity().finish()
            doneClick?.invoke("Yes button clicked")
        }

        tvCancel.setOnClickListener {
//            dismiss()
            cancelClick?.invoke("No button clicked")
        }
    }
}
