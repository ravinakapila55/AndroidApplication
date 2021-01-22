package com.myapplication.binding

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.myapplication.R
import com.myapplication.databinding.StartProgressBinding

class StartProgress :AppCompatActivity()
{
    private lateinit var startProgressBinding: StartProgressBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startProgressBinding=DataBindingUtil.setContentView(this,R.layout.start_progress)

        if (intent.hasExtra("data"))
        {
            startProgressBinding.tvName.setText("Hello "+intent.extras!!.getString("data")+"!!")
        }

        startProgressBinding.tvStart.setOnClickListener{

            Log.e("Click ","ss")
            Log.e("visibility ",startProgressBinding.progressBar.visibility.toString())

            startOrStop()
        }

        startProgressBinding.apply {

            tvStart.setOnClickListener {
                startOrStop()
            }

            tvSubmit.setOnClickListener {
                if (tvStart.text.equals("START"))
                {
                    navigate()
                }
                else
                {
                    Toast.makeText(this@StartProgress,"Please start some progress..",Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private fun startOrStop()
    {
        startProgressBinding.apply {
            if (progressBar.visibility==View.VISIBLE)
            {
               progressBar.visibility=View.GONE
               tvStart.setText("STOP")
            }
            else{
                progressBar.visibility=View.VISIBLE
              tvStart.setText("START")
            }
        }

    }

    private fun navigate()
    {
        val it= Intent(this@StartProgress,SaveData::class.java)
        startActivity(it)
    }


}