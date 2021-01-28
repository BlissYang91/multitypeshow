package com.bliss.multitype.binder

import android.content.Context
import android.view.ViewGroup
import com.bliss.multitype.data.RichItem
import com.bliss.multitype.data.RichView
import com.drakeet.multitype.ViewDelegate
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
/**
* Author: yangtianfu
* Date: 2021/1/28 20:39
* Describe:ViewDelegate是ItemViewDelegate子类
 * 用以自定义view做item的数据绑定方式
*/
class RichViewDelegate :ViewDelegate<RichItem,RichView>() {
    override fun onBindView(view: RichView, item: RichItem) {
        view.imageView.setImageResource(item.imageResId)
        view.textView.text = item.text
    }

    override fun onCreateView(context: Context): RichView {
        return RichView(context).apply {
            layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, WRAP_CONTENT) }
    }
}