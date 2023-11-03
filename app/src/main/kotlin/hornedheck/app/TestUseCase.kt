package hornedheck.app

import hornedheck.adapters.Decoder
import hornedheck.adapters.Encoder
import org.koin.core.annotation.Single
import java.io.InputStream
import java.io.OutputStream
import java.nio.ByteBuffer
import java.nio.ShortBuffer

@Single
class TestUseCase(
    private val decoder: Decoder,
    private val encoder: Encoder
) {

    fun execute(src: InputStream, out: OutputStream) {
        val srcData = ByteArray(960 * 2 * 2)
        val encodedData = ByteArray(4000)
        val decodedData = ByteArray(960 * 2 * 2)
        val decodedByteBuffer = ByteBuffer.wrap(decodedData).asShortBuffer()
        val decodedBuffer = ShortBuffer.allocate(960 * 2)
        var size = 0
        for (i in 0..1500) {
            src.read(srcData)

            size = encoder.encode(srcData, encodedData)
//            size = decoder.decode(encodedData, size, decodedBuffer)
            decodedByteBuffer.put(decodedBuffer).position(0)
            decodedBuffer.position(0)

            out.write(decodedData, 0, size * 2 * 2)
        }
    }
}