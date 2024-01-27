package com.example.birthday_wish

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class BirthdayCard : AppCompatActivity() {
    companion object{
        const val NAME_EXTRA="name_extra"
    }
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday_card)
        val name=intent.getStringExtra(NAME_EXTRA)
        val msg=findViewById<TextView>(R.id.brithdayMsg)
        msg.text="Happy Birthday $name"


    }
}