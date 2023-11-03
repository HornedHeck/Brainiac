package hornedheck.app

import hornedheck.adapters.Decoder
import hornedheck.adapters.Encoder
import org.koin.core.annotation.Single
import java.io.File

@Single
class TestFileUseCase(
    private val decoder: Decoder,
    private val encoder: Encoder,
) {

    private val targetByteSize = 480 * 2 * 2

    fun execute(srcFilename: String, dstFilename: String) {

        val srcStream = File(srcFilename).inputStream()
        val dstStream = File(dstFilename).outputStream()

        val pcmData = ByteArray(targetByteSize)
        val decodedData = ByteArray(targetByteSize)
        val encodedData = ByteArray(4096)

        var bytesRead = srcStream.read(pcmData)

        while (bytesRead > 0) {

            if (bytesRead < pcmData.size) {
                pcmData.fill(0, bytesRead)
            }

            val bytesEncoded = encoder.encode(pcmData, encodedData)

            decoder.decode(encodedData, bytesEncoded, decodedData)

            dstStream.write(decodedData)

            bytesRead = srcStream.read(pcmData)
        }

        srcStream.close()
        dstStream.close()
    }
}