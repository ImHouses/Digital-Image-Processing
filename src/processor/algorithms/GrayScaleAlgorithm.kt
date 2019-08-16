package processor.algorithms

import processor.ImageProcessingAlgorithm
import processor.Bundle
import java.awt.Color

class GrayScaleAlgorithm : ImageProcessingAlgorithm  {

    override fun processImage(
        width: Int,
        height: Int,
        pixels: Array<Array<Color>>,
        algorithmParams: Bundle?
    ) {
        for (rowIndex in 0 until pixels.size) {
            for (columnIndex in 0 until pixels[rowIndex].size) {
                val pixel = pixels[rowIndex][columnIndex]
                val average = (pixel.red + pixel.green + pixel.blue) / 3
                val newColor = Color(average, average, average, pixel.alpha)
                pixels[rowIndex][columnIndex] = newColor
            }
        }
    }
}