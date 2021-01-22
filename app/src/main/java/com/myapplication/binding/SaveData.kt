package com.myapplication.binding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.myapplication.R
import com.myapplication.binding.model.Student
import com.myapplication.databinding.SaveDataBindBinding

class SaveData :AppCompatActivity(){

    private lateinit var saveDataBindBinding: SaveDataBindBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        saveDataBindBinding= DataBindingUtil.setContentView(this,R.layout.save_data_bind)
        saveDataBindBinding.student= getStudent()

      /*  val student:Student=getStudent()

        saveDataBindBinding.apply {
            etName.text="Name :"+student.name.toString()
            etEmail.text="Email :"+student.email.toString()
        }*/

    }

    private fun getStudent():Student{
        return Student(1,"Abc","abc@gmail.com")
    }
}