package com.example.sendersms

import android.Manifest
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if(checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED){
                    println("this permission not working")
                    var  permissions = Manifest.permission.SEND_SMS

                    var permissionss = arrayOf(Manifest.permission.SEND_SMS)

                    requestPermissions(permissionss,1)

                }
            } else {
                TODO("VERSION.SDK_INT < M")
            }



        send.setOnClickListener({
            // in java  Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            val intent = Intent(applicationContext,MainActivity::class.java);
            val pending = PendingIntent.getActivity(applicationContext,0,intent,0)
            val smsSender = SmsManager.getDefault()
            smsSender.sendTextMessage(phone.text.toString(),null,
                message.text.toString(),pending,null)
            Toast.makeText(applicationContext,"Sms muvofaqiyatli jo`natildi",Toast.LENGTH_LONG).show()
        })





    }
}





