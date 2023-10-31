package hornedheck.infrastructure.transcoding

import hornedheck.adapters.Decoder
import org.koin.core.annotation.Single

@Single
class OpusDecoder : Decoder {

    override fun decode(encodedData: Array<UByte>): Array<UShort> {
        TODO("Not yet implemented")
    }
}
