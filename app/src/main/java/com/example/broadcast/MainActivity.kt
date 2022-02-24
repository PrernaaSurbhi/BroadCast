package com.example.broadcast

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.broadcast.databinding.ActivityMainBinding
import com.example.broadcast.receiver.DynamicBroadCastReceiver

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    val dynamicBroadCastReceiver = DynamicBroadCastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()
        //connectivity manager - Class that answers queries about the state of network connectivity.
        // It also notifies applications when network connectivity changes.
        //The primary responsibilities of this class are to: Monitor network connections (Wi-Fi, GPRS, UMTS, etc.)

        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(dynamicBroadCastReceiver,intentFilter)
    }

    //fun for set Alarm service
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

    override fun onStop() {
        super.onStop()
        unregisterReceiver(dynamicBroadCastReceiver)
    }
}