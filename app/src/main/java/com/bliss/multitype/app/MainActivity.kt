package com.bliss.multitype.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bliss.multitype.app.databinding.ActivityMainBinding
import com.bliss.multitype.binder.ImageItemViewBinder
import com.bliss.multitype.binder.RichViewDelegate
import com.bliss.multitype.binder.TextItemViewBinder
import com.bliss.multitype.data.ImageItem
import com.bliss.multitype.data.RichItem
import com.bliss.multitype.data.TextItem
import com.drakeet.multitype.MultiTypeAdapter
import com.google.gson.Gson
import java.nio.charset.Charset
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val adapter = MultiTypeAdapter()
    private val items = ArrayList<Any>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
//        imageItemShow()
        imageAndTextItemsShow()
    }

    private fun imageAndTextItemsShow() {
        //注册ItemViewBinder，每一种数据源对应一种viewBinder，都需要进行注册
        adapter.register(ImageItemViewBinder())
        adapter.register(TextItemViewBinder())
        adapter.register(RichViewDelegate())
        binding.recycleView.adapter = adapter
        //多类型数据源
        val imageItem = ImageItem(R.mipmap.ic_launcher)
        val textItem = TextItem("world")
        val richItem = RichItem("自定义view做item", R.drawable.img_11)
        for (i in 0..19) {
            items.add(textItem)
            items.add(imageItem)
            items.add(richItem)
        }
        adapter.items = items //adapter会给items中每一种类型的itemData找到对应的itemViewBinder进行数据绑定
        adapter.notifyDataSetChanged()
    }

    /**
     * 单一item类型
     * android:descendantFocusability="blocksDescendants"处理item不显示的问题
     * beforeDescendants：viewgroup会优先其子类控件而获取到焦点
     * afterDescendants：viewgroup只有当其子类控件不需要获取焦点时才获取焦点
     * blocksDescendants：viewgroup会覆盖子类控件而直接获得焦点，常用
     */
    private fun imageItemShow() {
        //注册ItemViewBinder
        adapter.register(ImageItemViewBinder())
        binding.recycleView.adapter = adapter
        //数据源
        val imageItem = ImageItem(R.mipmap.ic_launcher)
        for (i in 0..19) {
            items.add(imageItem)
        }
        adapter.items = items
        adapter.notifyDataSetChanged()
    }
}