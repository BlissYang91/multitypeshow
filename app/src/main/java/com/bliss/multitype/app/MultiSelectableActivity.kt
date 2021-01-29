package com.bliss.multitype.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.bliss.multitype.app.databinding.ActivityMultiSelectableBinding
import com.bliss.multitype.binder.CategoryItemViewBinder
import com.bliss.multitype.binder.SquareViewBinder
import com.bliss.multitype.data.Category
import com.bliss.multitype.data.Square
import com.drakeet.multitype.MultiTypeAdapter
import java.util.*

class MultiSelectableActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMultiSelectableBinding
    private val adapter = MultiTypeAdapter()
    private val items = ArrayList<Any>()
    private lateinit var selectedSet: TreeSet<Int>//内部元素排序

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_multi_selectable)
        initRecycle()
    }

    private fun initRecycle() {
        val layoutManager = GridLayoutManager(this, SPAN_COUNT)
        layoutManager.spanSizeLookup = object :GridLayoutManager.SpanSizeLookup(){
            override fun getSpanSize(position: Int): Int {
                //当前位置的 item 跨度大小,（SPAN_COUNT ÷ 此处返回值）== 该item所在行一共有几列
                //此处Category所在行要求只显示一列作为标题，所以返回计算公式如下
                return if (items[position] is Category) SPAN_COUNT else 1
            }

        }
        selectedSet = TreeSet()
        binding.recycleView.layoutManager = layoutManager
        adapter.register(CategoryItemViewBinder())
        adapter.register(SquareViewBinder(selectedSet))
        loadData()
        binding.recycleView.adapter = adapter

        binding.fab.setOnClickListener { v ->
            val content = StringBuilder()
            for (number in selectedSet) {
                content.append(number).append(" ")
            }
            Toast.makeText(v.context, "Selected items: $content", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadData() {
        val spacialCategory = Category("特别篇")
        items.add(spacialCategory)
        for (i in 0..6) {
            items.add(Square(i + 1))
        }
        val currentCategory = Category("本篇")
        items.add(currentCategory)
        for (i in 0..999) {
            items.add(Square(i + 1))
        }
        adapter.items = items
        adapter.notifyDataSetChanged()
    }

    companion object{
       private const val SPAN_COUNT = 5//每行排列 item 个数，在GridLayoutManager对象创建时需要传入
    }

}