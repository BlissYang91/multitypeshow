package com.bliss.multitype

import android.content.res.Resources

/**
* Author: yangtianfu
* Date: 2021/1/28 20:37
* Describe:数字转dp
*/
val Number.dp: Int get() = (toInt() * Resources.getSystem().displayMetrics.density).toInt()
