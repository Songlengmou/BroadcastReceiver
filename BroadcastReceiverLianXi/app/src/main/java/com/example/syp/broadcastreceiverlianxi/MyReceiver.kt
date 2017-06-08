package com.example.syp.broadcastreceiverlianxi

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 * Created by syp on 17-5-21.
 */
open class MyReceiver(n: String) : BroadcastReceiver() {

    companion object {
        val INTENT_ACTION = "com.example.syp.broadcastreceiverlianxi.intent.action.MyReceiver"
    }

    private var name = n

    override fun onReceive(context: Context?, intent: Intent?) {
        println(String.format("[%s]MyReceiver.onReceve========", name))

        abortBroadcast()
    }
}