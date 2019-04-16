package ru.ifacesoft.mvptimer.handlers

import android.os.Handler
import android.os.Message
import android.widget.TextView

class TimerView(textView: TextView) : Handler() {
    var textView : TextView? = null

    init {
        this.textView = textView
    }

    override fun handleMessage(msg: Message?) {
        super.handleMessage(msg)

        textView!!.text = msg!!.obj.toString()
    }
}