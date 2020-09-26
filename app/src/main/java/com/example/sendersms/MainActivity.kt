package com.example.sendersms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var phone:EditText;
    private lateinit var message:EditText;
    private lateinit var send:Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.phone = findViewById(R.id.editText1);
        this.message = findViewById(R.id.editText2);
        this.send  = findViewById(R.id.button1)
        print("start project")
        send.hasOnClickListeners{
            // in java  Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            val intent = Intent(applicationContext,MainActivity::class.java);
            print("hello world")
        }






    }
}

private fun Button.hasOnClickListeners(function: () -> Unit) {
        TODO("Not yet implemented")
    print("hello world")
}



