package vn.phatndt.movieapplication

import android.app.Application
import org.koin.core.context.startKoin
import vn.phatndt.data.di.dataModule
import vn.phatndt.domain.di.domainModule
import vn.phatndt.movie.di.movieModule

class MoveApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(dataModule, domainModule, movieModule)
        }
    }
}