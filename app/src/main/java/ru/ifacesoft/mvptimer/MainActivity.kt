package ru.ifacesoft.mvptimer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import ru.ifacesoft.mvptimer.handlers.TimerView
import ru.ifacesoft.mvptimer.interactors.Timer


class MainActivity : AppCompatActivity() {
    private var timerViewHandler: TimerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timerViewHandler = TimerView(findViewById(R.id.timer_textView))

        val startButton: Button = findViewById(R.id.start_button)

        val stopButton: Button = findViewById(R.id.stop_button)

        val mainPresenter = MainPresenter(this)

        val timerInteractor = Timer()

        startButton.setOnClickListener {
            mainPresenter.startTimer(timerInteractor)
        }

        stopButton.setOnClickListener {
            mainPresenter.stopTimer(timerInteractor)
        }
    }

    fun updateTimerTextView(time : Long) {
        val msg = Message()
        msg.obj = time

        timerViewHandler!!.sendMessage(msg)
    }
}
