package ru.ifacesoft.mvptimer.interactors

import java.util.*

class Timer : Observable() {
    fun notify(time: Long) {
        setChanged();
        notifyObservers(time)
    }
}