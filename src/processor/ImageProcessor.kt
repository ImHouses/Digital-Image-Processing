package processor

import java.io.File
import java.io.IOException
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.awt.Color

class ImageProcessor {

    private val algorithmMapper: AlgorithmMapper = AlgorithmMapper()

    fun processImage(
        inputFile: File,
        outputFile: File,
        outputFormat: String,
        algorithm: String,
        params: Bundle?
    ) {
        if (!inputFile.exists()) {
            throw IOException("File does not exists.")
        }
        if (outputFormat != "png" && outputFormat != "jpg") {
            throw IllegalArgumentException("Supported Formats: PNG, JPG.")
        }
        val imageProcessingAlgorithm = algorithmMapper.getAlgorithm(algorithm, params)
        if (imageProcessingAlgorithm == null) {
            throw IllegalArgumentException("Invalid algorithm identifier")
        }
        val bufferedImage = ImageIO.read(inputFile)
        val width = bufferedImage.width
        val height = bufferedImage.height
        val pixels: Array<Array<Color>> = fromBufferedImage(width, height, bufferedImage)
        imageProcessingAlgorithm.processImage(width, height, pixels, null)
        for (columnIndex in 0 until pixels.size) {
            for (rowIndex in 0 until pixels[columnIndex].size) {
                val argb = pixels[columnIndex][rowIndex].getRGB()
                bufferedImage.setRGB(columnIndex, rowIndex, argb)
            }
        }
        ImageIO.write(bufferedImage, outputFormat, outputFile)
    }
    
    private fun fromBufferedImage(
        width: Int,
        height: Int,
        image: BufferedImage
    ): Array<Array<Color>> = Array(width) { columnIndex ->
        Array(height) { rowIndex ->
            Color(image.getRGB(columnIndex, rowIndex))
        }
    }
}