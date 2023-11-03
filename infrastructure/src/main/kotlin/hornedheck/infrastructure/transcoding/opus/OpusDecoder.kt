package hornedheck.infrastructure.transcoding.opus

import hornedheck.adapters.Decoder
import org.koin.core.annotation.Single
import tomp2p.opuswrapper.Opus
import java.nio.IntBuffer
import java.nio.ShortBuffer

@Single
class OpusDecoder(
    private val opusConfig: OpusConfig
) : Decoder {

    private val decoder by lazy {
        val intBuffer = IntBuffer.allocate(1)

        Opus.INSTANCE.opus_decoder_create(
            opusConfig.frequency.hzValue,
            opusConfig.channels,
            intBuffer
        )
    }

    private val decodeBuffer = ShortBuffer.allocate(opusConfig.channels * opusConfig.frameSize)

    override fun decode(encodedData: ByteArray, size: Int, decodedData: ByteArray): Int {

        val decodeRes = Opus.INSTANCE.opus_decode(
            decoder,
            encodedData,
            size,
            decodeBuffer,
            opusConfig.frameSize,
            0
        )

        if (decodeRes > 0) {
            with(decodeBuffer) {
                for (j in array().indices) {
                    decodedData[j * 2] = array()[j].toByte()
                    decodedData[j * 2 + 1] = array()[j].toInt().ushr(8).toByte()
                }
            }
        }
        return decodeRes
    }
}
