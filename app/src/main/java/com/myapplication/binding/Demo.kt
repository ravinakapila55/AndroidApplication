package com.myapplication.binding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.myapplication.R
import com.myapplication.databinding.DemoBinding

class Demo :AppCompatActivity()
{
    private lateinit var demoBinding: DemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        demoBinding=DataBindingUtil.setContentView(this,R.layout.demo)

        demoBinding.tvSubmit.setOnClickListener {
            setData()
        }

    }

    private fun setData()
    {
        demoBinding.apply {
            tvResult.setText(etDemo.text.toString().trim())
            val it =Intent(this@Demo,StartProgress::class.java)
            it.putExtra("data",etDemo.text.toString())
            startActivity(it)
        }
    }
}