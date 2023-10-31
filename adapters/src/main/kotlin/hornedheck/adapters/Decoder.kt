package hornedheck.adapters

interface Decoder {

    fun decode(encodedData: Array<UByte>): Array<UShort>
}
