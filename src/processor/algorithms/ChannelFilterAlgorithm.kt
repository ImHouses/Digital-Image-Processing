package processor.algorithms

import java.awt.Color
import processor.ImageProcessingAlgorithm
import processor.Bundle

class ChannelFilterAlgorithm(var channel: String) : ImageProcessingAlgorithm {

    override fun processImage(
        width: Int,
        height: Int,
        pixels: Array<Array<Color>>,
        algorithmParams: Bundle?
    ) {
        for (rowIndex in 0 until pixels.size) {
            for (columnIndex in 0 until pixels[rowIndex].size) {
                val pixel = pixels[rowIndex][columnIndex]
                val newColor = getColorAccordingChannel(channel, pixel)
                pixels[rowIndex][columnIndex] = newColor
            }
        }       
    }

    private fun getColorAccordingChannel(
        channel: String,
        pixel: Color
    ): Color = when(channel) {
        "red" -> Color(pixel.red, 0, 0, pixel.alpha)
        "blue" -> Color(0, 0, pixel.blue, pixel.alpha)
        "green" -> Color(0, pixel.green, 0, pixel.alpha)
        else -> pixel
    }
}