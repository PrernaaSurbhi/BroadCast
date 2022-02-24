package com.example.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Toast
import java.lang.Exception

/**
 * Created by PrernaSurbhi on 24/02/22.
 */
class PhoneCallReceiver:BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        try{
           val extra = intent?.extras
            extra?.let{
              val state =   it.getString(TelephonyManager.EXTRA_STATE)

                if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                    Toast.makeText(context, "Phone Is Ringing", Toast.LENGTH_LONG).show()
                }

                if(state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)){
                    Toast.makeText(context, "Call Recieved", Toast.LENGTH_LONG).show();
                }

                if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)){
                    Toast.makeText(context, "Phone Is Idle", Toast.LENGTH_LONG).show();
                }

            }

        }catch(e:Exception){
            Log.d("PhoneCallReceiver got error"," "+e)
        }
    }

}