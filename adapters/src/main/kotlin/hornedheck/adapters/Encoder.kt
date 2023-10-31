package hornedheck.adapters

interface Encoder {

    fun encode(pcmData: Array<UShort>): Array<UByte>
}
