import platform.UIKit.UIImage
import platform.UIKit.UIImagePNGRepresentation
import platform.Foundation.NSData
import kotlinx.cinterop.memcpy
import kotlinx.cinterop.refTo

class ImageConverter {
     fun fromImageBitmap(imageBitmap: ImageBitmap?): ByteArray? {
        if (imageBitmap == null) return null

        // Преобразуем ImageBitmap в UIImage
        val uiImage = imageBitmap.toUIImage()

        // Преобразуем UIImage в NSData и затем в ByteArray
        val nsData = UIImagePNGRepresentation(uiImage) ?: return null
        val byteArray = ByteArray(nsData.length.toInt())
        memcpy(byteArray.refTo(0), nsData.bytes, nsData.length)
        return byteArray
    }

     fun toImageBitmap(byteArray: ByteArray?): ImageBitmap? {
        if (byteArray == null) return null

        // Преобразуем ByteArray в NSData
        val nsData = byteArray.toNSData()

        // Преобразуем NSData в UIImage
        val uiImage = UIImage(data = nsData) ?: return null

        // Преобразуем UIImage в ImageBitmap
        return uiImage.toImageBitmap()
    }
}