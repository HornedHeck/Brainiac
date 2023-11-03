package hornedheck.adapters

import java.nio.ByteBuffer
import java.nio.ShortBuffer

interface Encoder {

    fun encode(pcmData: ByteArray, encodedData : ByteArray): Int
}
