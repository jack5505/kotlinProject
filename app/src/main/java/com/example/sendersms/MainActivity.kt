package com.example.sendersms

import android.Manifest
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.telephony.SmsManager
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var phone:EditText;
    private lateinit var message:EditText;
    private lateinit var send:Button;
    private lateinit var img:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.phone = findViewById(R.id.editText1);
        this.message = findViewById(R.id.editText2);
        this.send  = findViewById(R.id.button1)
        this.img = findViewById(R.id.imageButton)
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



        send.setOnClickListener {
            // in java  Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            val intent = Intent(applicationContext,MainActivity::class.java);
            val pending = PendingIntent.getActivity(applicationContext,0,intent,0)
            val smsSender = SmsManager.getDefault()
            smsSender.sendTextMessage(phone.text.toString(),null,
                message.text.toString(),pending,null)
            Toast.makeText(applicationContext,"Sms muvofaqiyatli jo`natildi",Toast.LENGTH_LONG).show()
        }

        this.img.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            startActivityForResult(intent,1)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        data?.dataString?.let { Log.d("new", it) }

        var cursor = data?.data?.let { contentResolver.query(it,null,null,null,null) }
        cursor?.moveToFirst()
        var phoneIndex: Int? = cursor?.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)

        //phone.setText(phoneIndex?.let { cursor?.getString(it) })
        Log.d("new", data?.data.toString())
        super.onActivityResult(requestCode, resultCode, data)

    }
}





