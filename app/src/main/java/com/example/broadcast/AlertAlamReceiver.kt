package com.example.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Vibrator
import android.widget.Toast

/**
 * Created by PrernaSurbhi on 24/02/22.
 */
class AlertAlamReceive:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context,"wake up time",Toast.LENGTH_LONG).show()
        val vibrator = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator?.vibrate(2000)
    }
}