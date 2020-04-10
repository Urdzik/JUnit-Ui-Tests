package com.example.testing.mock


import android.content.Context
import com.example.testing.R
import java.net.URI


class UriValidator(context: Context) {

    private val context: Context = context

    fun validate(uri: String): String {
        var resId: Int = R.string.nothing
        if (isUrl(uri)) {
            resId = R.string.url
        } else if (isFile(uri)) {
            resId = R.string.file
        }
        return context.getString(resId)
    }

    private fun isUrl(uri: String): Boolean {
        return "http" == URI.create(uri).scheme
    }

    private fun isFile(uri: String): Boolean {
        return "file" == URI.create(uri).scheme
    }

}