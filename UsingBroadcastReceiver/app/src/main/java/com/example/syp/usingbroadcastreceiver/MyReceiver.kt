package com.example.syp.usingbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 * Created by syp on 17-5-19.
 */
//-------------------------静态-------------------------------
//class MyReceiver : BroadcastReceiver() {
//    override fun onReceive(context: Context?, intent: Intent?) {
//        println("===============MyReceiver.onReceive")
//        println(intent)
//    }
//
//}

//-------------------------动态-------------------------------
open class MyReceiver(n: String) : BroadcastReceiver() {

    companion object {
        val INTENT_ACTION = "com.example.syp.usingbroadcastreceiver.intent.action.MyReceiver"
    }

    private var name = n;

    override fun onReceive(context: Context?, intent: Intent?) {
        println(String.format("[%s]MyReceiver.onReceive", name))

        abortBroadcast()

    }

}