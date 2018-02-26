package com.fleenmobile.androidinterviewtask

import android.app.Activity
import android.widget.Toast

/**
 * @author FleenMobile at 2018-02-26
 */
fun Activity.showToast(message: String) =
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()