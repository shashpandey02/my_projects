package com.example.birthday_wish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn=findViewById<Button>(R.id.createCard)
        val input=findViewById<EditText>(R.id.nameInput)
        btn.setOnClickListener {
            val name=input.editableText.toString()
            val intent=Intent(this,BirthdayCard::class.java)
            intent.putExtra(BirthdayCard.NAME_EXTRA,name)
            startActivity(intent)
        }

    }




}