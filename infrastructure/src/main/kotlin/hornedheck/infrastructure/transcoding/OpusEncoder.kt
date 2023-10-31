package hornedheck.infrastructure.transcoding

import hornedheck.adapters.Encoder
import org.koin.core.annotation.Single

@Single
class OpusEncoder : Encoder {

    override fun encode(pcmData: Array<UShort>): Array<UByte> {
        TODO("Not yet implemented")
    }
}
