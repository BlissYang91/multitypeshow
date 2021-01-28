package com.bliss.multitype.data

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.bliss.multitype.dp

/**
* Author: yangtianfu
* Date: 2021/1/28 20:35
* Describe:自定义view做item
*/
class RichView(context: Context):LinearLayout(context) {
    val imageView = AppCompatImageView(context).apply {
        addView(this, LayoutParams(72.dp, 72.dp))
    }

    val textView = AppCompatTextView(context).apply {
        setTextColor(Color.BLACK)
        addView(this, LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ))
    }

    init {
        orientation = VERTICAL
        gravity = Gravity.CENTER
        setPadding(16.dp, 16.dp, 16.dp, 16.dp)
    }
}