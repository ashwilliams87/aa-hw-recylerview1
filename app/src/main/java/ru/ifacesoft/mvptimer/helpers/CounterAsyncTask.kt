package ru.ifacesoft.mvptimer.helpers

import android.os.AsyncTask
import android.os.SystemClock
import ru.ifacesoft.mvptimer.interactors.Timer

class CounterAsyncTask : AsyncTask<Timer, Long, Int>() {

    override fun doInBackground(vararg params: Timer): Int {
        val timer = params[0];

        var startTime: Long = System.currentTimeMillis()

        while (true) {
            SystemClock.sleep(1000)

            timer.notify(System.currentTimeMillis() - startTime)
        }

        return startTime.toInt()
    }

    override fun onProgressUpdate(vararg values: Long?) {
        super.onProgressUpdate(*values)
    }
}

