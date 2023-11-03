package hornedheck.infrastructure.transcoding.opus

import tomp2p.opuswrapper.Opus

data class OpusConfig(
    val frequency: Frequency,
    val channels: Int,
    val frameSize: Int,
    val bitrate: Int,
    val encodeBufferMaxSize : Int = 4096
) {

    init {
        assert(bitrate in 500..512000){
            "Bitrate should be in range from 500 to 512000 bits per second"
        }
    }
}

enum class Frequency(val hzValue: Int, val bandwidth: Int) {
    F_48_KHZ(48000, Opus.OPUS_BANDWIDTH_FULLBAND),
    F_24_KHZ(24000, Opus.OPUS_BANDWIDTH_SUPERWIDEBAND),
    F_16_KHZ(16000, Opus.OPUS_BANDWIDTH_WIDEBAND),
    F_12_KHZ(12000, Opus.OPUS_BANDWIDTH_MEDIUMBAND),
    F_8_KHZ(8000, Opus.OPUS_BANDWIDTH_NARROWBAND),
}