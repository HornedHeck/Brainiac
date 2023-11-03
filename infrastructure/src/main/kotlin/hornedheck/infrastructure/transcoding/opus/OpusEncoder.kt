package hornedheck.infrastructure.transcoding.opus

import hornedheck.adapters.Encoder
import org.koin.core.annotation.Single
import tomp2p.opuswrapper.Opus
import java.nio.ByteBuffer
import java.nio.IntBuffer
import java.nio.ShortBuffer

@Single
class OpusEncoder(private val opusConfig: OpusConfig) : Encoder {

    private val encoder = Opus.INSTANCE.opus_encoder_create(
        opusConfig.frequency.hzValue,
        opusConfig.channels,
        Opus.OPUS_APPLICATION_AUDIO,
        IntBuffer.allocate(1)
    )

    init {
        Opus.INSTANCE.opus_encoder_ctl(encoder, Opus.OPUS_SET_BITRATE_REQUEST, opusConfig.bitrate)
    }

    private val pcmBuffer = ShortBuffer.allocate(opusConfig.frameSize * opusConfig.channels)
    private val encodedBuf = ByteBuffer.allocate(opusConfig.encodeBufferMaxSize)

    override fun encode(pcmData: ByteArray, encodedData: ByteArray): Int {

        for (j in pcmData.indices step 2) {
            pcmBuffer.put(
                (pcmData[j].toInt() + pcmData[j + 1].toInt().shl(8)).toShort()
            )
        }
        pcmBuffer.position(0)

        val encoded = Opus.INSTANCE.opus_encode(
            encoder,
            pcmBuffer,
            opusConfig.frameSize,
            encodedBuf,
            opusConfig.encodeBufferMaxSize
        )

        if (encoded > 0) {
            encodedBuf.array().copyInto(encodedData)
        }

        return encoded
    }
}
