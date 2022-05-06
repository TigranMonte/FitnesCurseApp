package ru.tikodvlp.fitnesscurseapp.utils

import android.app.AlertDialog
import android.content.Context
import ru.tikodvlp.fitnesscurseapp.R

object DialogManager {

    fun showDialog(context: Context, mId: Int, listener: Listener) {

        val builder = AlertDialog.Builder(context)
        var dialog: AlertDialog? = null

        builder.setMessage(mId)
        builder.setTitle(R.string.alert)

        builder.setPositiveButton(R.string.reset){ _,_ ->
            listener.onClick()
            dialog?.dismiss()
        }

        builder.setNegativeButton(R.string.back){ _,_ ->
            dialog?.dismiss()
        }
        dialog = builder.create()
        dialog.show()
    }

    interface Listener {
        fun onClick()
    }
}