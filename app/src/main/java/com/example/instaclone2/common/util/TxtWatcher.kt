package com.example.instaclone2.common.util

import android.text.Editable
import android.text.TextWatcher

class TxtWatcher(val onTextChanged: (String) -> Unit) : TextWatcher {
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        TODO("Not yet implemented")
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        onTextChanged(p0.toString())
    }

    override fun afterTextChanged(p0: Editable?) {
        TODO("Not yet implemented")
    }
}