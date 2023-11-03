package hornedheck.infrastructure.transcoding.opus

import org.koin.core.annotation.Single
import org.koin.dsl.module

@Single
class OpusConfigProvider {

    private val config by lazy {
        OpusConfig(
            frequency = Frequency.F_48_KHZ,
            channels = 2,
            frameSize = 480,
            bitrate = 80000
        )
    }

    fun provide() = config

    companion object {

        val koinModule = module {
            single { get<OpusConfigProvider>().config }
        }
    }
}