package com.bliss.multitype.data

import java.nio.charset.Charset

class TextItem {
    var text:String
    constructor(text: String){
        this.text = text
    }

    //伴生对象是个实际对象的单例实例,在特定类中可以省略类名,只能定义一个，是静态内部类
    //标记为 inner 的嵌套类能够访问其外部类的成员。内部类会带有一个对外部类的对象的引用，不是单例，也不是静态内部类可以被定义多个
    //object，天生单例
//    companion object{
//        private val UTF_8 = Charset.forName("UTF-8")
//    }
}