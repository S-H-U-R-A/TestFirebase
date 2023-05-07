package com.example.pruebasfirebasekotlin.core.ext

import android.content.DialogInterface
import androidx.annotation.StringRes
import androidx.annotation.StyleRes
import androidx.fragment.app.Fragment
import com.example.pruebasfirebasekotlin.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder


fun Fragment.showDialogInfo(
    @StyleRes style: Int,
    title: String,
    @StringRes messagePositiveButton: Int,
    actionPositiveButton: ( DialogInterface, Int ) -> Unit,
    contentMessage: String
) {

    val alertDialogInfo = MaterialAlertDialogBuilder(
        requireContext(),
        R.style.Theme_PruebasFirebaseKotlin
    )

    with(alertDialogInfo) {
        setTitle(title)
        setPositiveButton(
            messagePositiveButton,
            actionPositiveButton
        )
        setMessage(
            contentMessage
        )
        setCancelable(false)
        show()
    }

}