package com.mutakin.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.mutakin.myintentapp.models.Person

class MoveWithDataActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        val tvDataReceived: TextView = findViewById(R.id.tv_data_received)
        val tvObjectReceived: TextView = findViewById(R.id.tv_object_received)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)
        var text = ""
        if(name != null && age != null) {
            text = "Your name is ${name ?: "Unknown"} you are $age years old"
            tvDataReceived.text = text
        }


        val person = intent.getParcelableExtra<Person>(EXTRA_DATA)
        if(person != null){
            text = "Name : ${person?.name.toString()},\nEmail : ${person?.email},\nAge : ${person?.age},\nLocation : ${person?.city}"
            tvObjectReceived.text = text
        }

    }
}