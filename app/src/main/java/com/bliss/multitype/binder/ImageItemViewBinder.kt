package com.bliss.multitype.binder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bliss.multitype.app.R
import com.bliss.multitype.data.ImageItem
import com.drakeet.multitype.ItemViewBinder

class ImageItemViewBinder : ItemViewBinder<ImageItem, ImageItemViewBinder.ImageHolder>() {

    //①创建holder，然后在ItemViewBinder泛型中填入改holder
    //标记为 inner 的嵌套类能够访问其外部类的成员。内部类会带有一个对外部类的对象的引用，不是单例，可以被定义多个
    inner class ImageHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val image:ImageView = itemView.findViewById(R.id.image)
    }

    override fun onBindViewHolder(holder: ImageHolder, item: ImageItem) {
        //③给item控件赋值
        holder.image.setImageResource(item.resId)
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ImageHolder {
        //②创建的时候给ImageHolder赋值布局
       return ImageHolder(inflater.inflate(R.layout.item_image,parent,false))
    }
}