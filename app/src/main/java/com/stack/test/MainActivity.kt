package com.stack.test

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var stack: Stack<String>? = null
    private var firstString: String? = null
    private var secondString: String? = null
    private var strList: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stack = Stack<String>()
        strList = ArrayList()
        btn_add.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_add -> {
                val str = ed_value.text.toString()
                addStringToStack(str)
            }
        }
    }

    private fun addStringToStack(str: String) {
        val lparams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        val tv = TextView(this)
        tv.layoutParams = lparams
        tv.text = str
        ll_txt_layout.addView(tv)

        strList?.add(str)
        ed_value.text?.clear()
        addToStack(strList)

    }

    private fun addToStack(strList: ArrayList<String>?) {

        if (strList?.size!! > 1) {
            val s = strList[strList.size - 1]
            Log.e("DDD",s)
            stack?.push(s)
            // strList.add(1,"")
            Log.e("STACK", stack.toString())
        }
    }
}