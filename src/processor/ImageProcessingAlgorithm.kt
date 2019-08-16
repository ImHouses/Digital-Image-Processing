package processor

import java.awt.Color
import processor.Bundle

interface ImageProcessingAlgorithm {

    fun processImage(
        width: Int,
        height: Int,
        pixels: Array<Array<Color>>,
        algorithmParams: Bundle?
    )
}