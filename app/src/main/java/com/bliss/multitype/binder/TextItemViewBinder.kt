package com.bliss.multitype.binder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bliss.multitype.app.R
import com.bliss.multitype.data.TextItem
import com.drakeet.multitype.ItemViewBinder

/**
* Author: yangtianfu
* Date: 2021/1/28 20:13
* Describe:每一种itemViewBinder绑定指定类型的data - TextItem
*/
class TextItemViewBinder(val listener:OnItemClickedListener):ItemViewBinder<TextItem,TextItemViewBinder.TextHolder>() {
    private var lastShownAnimationPosition: Int = 0
    //holder初始化item控件
   class TextHolder(itemView: View):RecyclerView.ViewHolder(itemView){
       val text:TextView = itemView.findViewById(R.id.text)
   }

    override fun onBindViewHolder(holder: TextHolder, item: TextItem) {
        holder.text.text = "hello ${item.text}"
        //item点击事件，此处position可能会返回-1，故需要做一下判断
        holder.itemView.setOnClickListener {
            val position = getPosition(holder)
            if (position>=0){
                listener.onClick(holder.text,position,item)
            }
        }
        setAnimation(holder.itemView,holder.position)
    }

    private fun setAnimation(itemView: View, position: Int) {
        if (position>lastShownAnimationPosition){
            itemView.startAnimation(AnimationUtils.loadAnimation(itemView.context,android.R.anim.slide_in_left))
            lastShownAnimationPosition = position
        }
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): TextHolder {
        return TextHolder(inflater.inflate(R.layout.item_text,parent,false))
    }

    //view销毁时清除动画
    override fun onViewDetachedFromWindow(holder: TextHolder) {
        holder.itemView.clearAnimation()
    }
    interface OnItemClickedListener{
        fun onClick(textView: TextView,position: Int,textItem: TextItem)
    }
}