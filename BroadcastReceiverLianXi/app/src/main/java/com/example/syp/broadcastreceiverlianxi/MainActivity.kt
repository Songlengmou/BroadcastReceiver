package com.example.syp.broadcastreceiverlianxi;

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;

/**
 * 动态广播
 *
 * var声明的属性值为可变的，而val声明的属性值是只读属性，也就是说其值是不可变的。
 */
open class MainActivity : AppCompatActivity() {
    private val receiver1 = MyReceiver("Receiver 1")
    private val receiver2 = MyReceiver("Receiver 2")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById(R.id.btnSendBroadcast).setOnClickListener {
            sendOrderedBroadcast(Intent(MyReceiver.INTENT_ACTION), null)
        }

        findViewById(R.id.btnReceiverZhuCe1).setOnClickListener {
            val intentFilter = IntentFilter(MyReceiver.INTENT_ACTION)
            intentFilter.priority = 8
            registerReceiver(receiver1, intentFilter)

        }

        findViewById(R.id.btnUnReceiverZhuXiao1).setOnClickListener {
            unregisterReceiver(receiver1)
        }

        findViewById(R.id.btnReceiverZhuCe2).setOnClickListener {
            val intentFilter2 = IntentFilter(MyReceiver.INTENT_ACTION)
            intentFilter2.priority = 10
            registerReceiver(receiver2, intentFilter2)
        }

        findViewById(R.id.btnUnReceiverZhuXiao2).setOnClickListener {
            unregisterReceiver(receiver2)
        }
    }

}
