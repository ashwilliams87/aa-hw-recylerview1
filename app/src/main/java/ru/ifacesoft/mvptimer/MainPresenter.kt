package ru.ifacesoft.mvptimer

import ru.ifacesoft.mvptimer.helpers.CounterAsyncTask
import ru.ifacesoft.mvptimer.interactors.Timer
import java.util.*

class MainPresenter(mainActivity: MainActivity) : Observer {
    var counterAsyncTask: CounterAsyncTask? = null

    private var mainActivity: MainActivity

    init {
        counterAsyncTask = CounterAsyncTask()
        this.mainActivity = mainActivity
    }

    override fun update(o: Observable?, arg: Any?) {
        mainActivity.updateTimerTextView(arg as Long)
    }

    fun startTimer(timerInteractor: Timer) {
        timerInteractor.addObserver(this)

        counterAsyncTask!!.execute(timerInteractor)
    }

    fun stopTimer(timerInteractor: Timer) {
        timerInteractor.addObserver(this)
    }
}