package com.example.broadcast

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.broadcast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun startAlarmAlertMessage(View: View){
        val editText:String = binding.time.text.toString()
        val longText:Long? = editText.toLongOrNull()
        val intent = Intent(this,AlertAlamReceive::class.java)

        val pendingIntent = PendingIntent.getBroadcast(this.applicationContext,
                                123123,
                                          intent,
                                          0)

        val alertManager = getSystemService(ALARM_SERVICE) as AlarmManager
        if (longText != null) {
            alertManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis(),
                longText,
                pendingIntent)
        }

        Toast.makeText(this,"alart set up",Toast.LENGTH_LONG).show()
    }
}