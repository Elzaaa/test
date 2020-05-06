package com.example.andy.myapplication

import android.graphics.Matrix
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textChanger.setOnClickListener(View.OnClickListener { roateImage(imageView) })
    }

    private fun roateImage(imageView: ImageView?) {
        val matrix = Matrix()
        imageView!!.scaleType = ImageView.ScaleType.MATRIX //required
        matrix.postRotate(
            66 .toFloat(),
            imageView.drawable.bounds.width() / 2.toFloat(),
            imageView.drawable.bounds.height() / 2.toFloat()
        )
        imageView.imageMatrix = matrix
    }
}
