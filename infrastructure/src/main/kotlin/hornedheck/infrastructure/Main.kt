package hornedheck.infrastructure

import club.minnced.opus.util.OpusLibrary
import hornedheck.app.AppModules
import hornedheck.app.TestFileUseCase
import org.koin.core.Koin
import org.koin.core.context.startKoin

const val TIMESPAN = 20
const val FS = 48000
const val CHANNELS = 2
const val FRAME_SIZE = (FS * TIMESPAN / 1000)
const val BUFFER_SIZE = (FRAME_SIZE * CHANNELS)
const val BUFFER_READ_SIZE = BUFFER_SIZE * 2
const val MAX_FRAME_SIZE = 960
const val BUFFER_OUT_SIZE = (MAX_FRAME_SIZE * CHANNELS)
const val BUFFER_OUT_WRITE_SIZE = BUFFER_OUT_SIZE * 2
const val OUTPUT_MAX_SIZE = 4096

const val FRAMES_COUNT = (60 * 1000 / TIMESPAN)

fun main() {
    val koin = startKoin {
        modules(InfrastructureModules().modules + AppModules().modules)
    }.koin

}

private fun testFile(koin: Koin) {
    OpusLibrary.loadFromJar()

    val testUseCase = koin.get<TestFileUseCase>()
    testUseCase.execute("files/pcm.bin", "files/test_v9.bin")
}