package com.example.syp.usingbroadcastreceiver;

import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 广播接收器静态要在AndroidManifest中写东西
 */

//------------------------静态---------------------------------
//open class MainActivity : AppCompatActivity() {
//
//    private val receiver = MyReceiver()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        findViewById(R.id.btnSendBroadcast).setOnClickListener {
//            //静态
//            sendBroadcast(Intent(this, MyReceiver::class.java))
//
//        }
//
//        findViewById(R.id.btnRegisterBroadcastReceiver1).setOnClickListener {
//            registerReceiver(receiver, IntentFilter("com.example.syp.usingbroadcastreceiver.intent.action.MyReceiver"))
//        }
//
//        findViewById(R.id.btnUnRegisterBroadcastReceiver1).setOnClickListener {
//            unregisterReceiver(receiver)
//        }
//
//
//    }
//}

//------------------------动态---------------------------------
open class MainActivity : AppCompatActivity() {

    private val receiver1 = MyReceiver("Receiver 1")
    private val receiver2 = MyReceiver("Receiver 2")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById(R.id.btnSendBroadcast).setOnClickListener {

            //动态
            sendOrderedBroadcast(Intent(MyReceiver.INTENT_ACTION), null)

        }

        findViewById(R.id.btnRegisterBroadcastReceiver1).setOnClickListener {
            val filter = IntentFilter(MyReceiver.INTENT_ACTION)
            filter.priority = 10
            registerReceiver(receiver1, filter)
        }

        findViewById(R.id.btnUnRegisterBroadcastReceiver1).setOnClickListener {
            unregisterReceiver(receiver1)
        }

        findViewById(R.id.btnRegisterBroadcastReceiver2).setOnClickListener {
            val filter = IntentFilter(MyReceiver.INTENT_ACTION)
            filter.priority = 11
            registerReceiver(receiver2, filter)
        }

        findViewById(R.id.btnUnRegisterBroadcastReceiver2).setOnClickListener {
            unregisterReceiver(receiver2)
        }

    }
}
