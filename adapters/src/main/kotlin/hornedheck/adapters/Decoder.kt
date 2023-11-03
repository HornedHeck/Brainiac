package hornedheck.adapters

import java.nio.ByteBuffer
import java.nio.ShortBuffer

interface Decoder {

    fun decode(encodedData: ByteArray, size : Int, decodedData: ByteArray): Int
}
