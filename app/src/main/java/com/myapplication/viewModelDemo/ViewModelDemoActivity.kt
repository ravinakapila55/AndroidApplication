package com.myapplication.viewModelDemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.myapplication.R
import com.myapplication.databinding.ViewModelDemoBinding

class ViewModelDemoActivity : AppCompatActivity()
{
    var count =0
    private lateinit var viewModelDemoBinding: ViewModelDemoBinding
    private lateinit var viewModelDemoViewModel: ViewModelDemoViewModel

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        viewModelDemoBinding= DataBindingUtil.setContentView(this,R.layout.view_model_demo)

        viewModelDemoViewModel = ViewModelProvider(this).get(ViewModelDemoViewModel::class.java)
//        viewModelDemoBinding.tvCount.text=count.toString()

        viewModelDemoBinding.apply {
            tvCount.text=viewModelDemoViewModel.getCurrent().toString()

            tvSubmit.setOnClickListener {
                tvCount.text=viewModelDemoViewModel.getUpdated().toString()
            }
        }

      /*  viewModelDemoBinding.tvSubmit.setOnClickListener {
            count++
            viewModelDemoBinding.tvCount.text=count.toString()
        }*/
    }
}