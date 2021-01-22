package com.myapplication.viewModelDemo

import androidx.lifecycle.ViewModel

class ViewModelDemoViewModel :ViewModel()
{
   private var count = 0

    fun getCurrent():Int
    {
        return count
    }

    fun getUpdated() :Int
    {
        count=++count
        return count
    }

}