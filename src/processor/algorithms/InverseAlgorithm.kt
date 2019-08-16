package processor.algorithms

import java.awt.Color
import processor.ImageProcessingAlgorithm
import processor.Bundle

class InverseAlgorithm : ImageProcessingAlgorithm {

    override fun processImage(
        width: Int,
        height: Int,
        pixels: Array<Array<Color>>,
        algorithmParams: Bundle?
    ) {
        for (rowIndex in 0 until pixels.size) {
            for (columnIndex in 0 until pixels[rowIndex].size) {
                val pixel = pixels[rowIndex][columnIndex]
                val redChannel = 255 - pixel.red
                val greenChannel = 255 - pixel.green
                val blueChannel = 255 - pixel.blue 
                val newColor = Color(redChannel, greenChannel, blueChannel, pixel.alpha)
                pixels[rowIndex][columnIndex] = newColor
            }
        }       
    }
}