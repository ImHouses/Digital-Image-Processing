package processor

import processor.algorithms.GrayScaleAlgorithm
import processor.algorithms.ChannelFilterAlgorithm
import processor.algorithms.InverseAlgorithm

class AlgorithmMapper {

    private val grayScaleAlgorithm: GrayScaleAlgorithm = GrayScaleAlgorithm()
    private val channelFilter: ChannelFilterAlgorithm = ChannelFilterAlgorithm("red")
    private val inverseAlgorithm: InverseAlgorithm by lazy { InverseAlgorithm() }

    fun getAlgorithm(algorithmId: String, params: Bundle?): ImageProcessingAlgorithm? = when (algorithmId) {
        "grayscale" -> grayScaleAlgorithm
        "red" -> {
            channelFilter.channel = "red"
            channelFilter
        }
        "blue" -> {
            channelFilter.channel = "blue"
            channelFilter
        }
        "green" -> {
            channelFilter.channel = "green"
            channelFilter
        }
        "inverse" -> inverseAlgorithm
        else -> null
    }
}