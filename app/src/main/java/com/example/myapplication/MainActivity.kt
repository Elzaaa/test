package com.example.myapplication
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import com.example.oncreate.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val degrees = 0.0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bu.setOnClickListener{
            val degrees = 90.0;
        }
        imageView.invalidate()
        val bitmap = imageView.getDrawable().toBitmap()
        Rotation.rotateCw(bitmap, degrees)
    }
    object Rotation {
        fun rotateCw(img: Bitmap, degrees: Double) {
            val width: Int = img.getWidth()
            val height: Int = img.getHeight()
            val newImage = Bitmap.createBitmap(width, height, img.getConfig())
            val angle = Math.toRadians(degrees)
            val sin = Math.sin(angle)
            val cos = Math.cos(angle)
            val x0 = 0.5 * (width - 1) // point to rotate about
            val y0 = 0.5 * (height - 1) // center of image
            // rotation
            for (x in 0 until width) {
                for (y in 0 until height) {
                    val a = x - x0
                    val b = y - y0
                    val xx = (+a * cos - b * sin + x0).toInt()
                    val yy = (+a * sin + b * cos + y0).toInt()
                    if (xx >= 0 && xx < width && yy >= 0 && yy < height) {
                        newImage.setPixel(x, y, img.getPixel(xx, yy))
                    }
                }
            }
        }
    }
}
