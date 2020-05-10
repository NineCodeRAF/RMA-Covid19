package rs.raf.projekat1.Nikola_Adamovic_RN4217.app

import android.app.Application
import timber.log.Timber

class App : Application(){
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}