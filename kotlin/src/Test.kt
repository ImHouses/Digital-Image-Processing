import java.io.File
import java.io.IOException
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.awt.Color

fun main(args: Array<String>) {
    var image: BufferedImage?
    try {
        image = ImageIO.read(File("test.jpg"))
        println(image)
        val width = image.width
        val height = image.height
        val pixels = getPixelsFromBufferedImage(image, width, height)
        val rgbPixels: Array<Array<RGBPixel>> = getRGBPixels(pixels)
        for (rowIndex in 0 until rgbPixels.size) {
            for (columnIndex in 0 until rgbPixels[rowIndex].size) {
                val argbPixel = rgbPixels[rowIndex][columnIndex]
                val average = (argbPixel.red + argbPixel.green + argbPixel.blue) / 3
                val newColor = Color(average, average, average, argbPixel.alpha)
                image.setRGB(rowIndex, columnIndex, newColor.getRGB())
            }
        }
        val resultFile = File("result.jpg")
        ImageIO.write(image, "jpg", resultFile)
    } catch (ioException: IOException) {
        ioException.printStackTrace()
    }
}

private fun getPixelsFromBufferedImage(image: BufferedImage, width: Int, height: Int): Array<Array<Int>> = Array(width) { rowIndex ->
    Array(height) { columnIndex -> 
        image.getRGB(rowIndex, columnIndex)
    }
}

/**
 * Data class that represents an RGB pixel.
 */
data class RGBPixel(
    val alpha: Int,
    val red: Int,
    val green: Int,
    val blue: Int
)

private fun fromInt(pixel: Int): RGBPixel {
    val alpha: Int = (pixel shr 24) and 0xff
    val red: Int = (pixel shr 16) and 0xff
    val green: Int = (pixel shr 8) and 0xff
    val blue: Int = pixel and 0xff
    return RGBPixel(alpha, red, green, blue)
}

private fun getRGBPixels(pixels: Array<Array<Int>>): Array<Array<RGBPixel>> = Array(pixels.size) { rowIndex ->
    Array(pixels[rowIndex].size) { columnIndex ->
        fromInt(pixels[rowIndex][columnIndex])
    }
}