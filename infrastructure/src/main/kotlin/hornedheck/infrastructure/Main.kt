package hornedheck.infrastructure

import hornedheck.adapters.Encoder
import hornedheck.infrastructure.transcoding.OpusEncoder
import org.koin.core.context.startKoin

fun main() {
    val koin = startKoin {
        modules(InfrastructureModules().modules)
    }.koin

    val encoder = koin.get<Encoder>()
    assert(encoder is OpusEncoder)
}

