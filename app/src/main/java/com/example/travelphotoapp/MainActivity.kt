package com.example.travelphotoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var currentImage = 0
    lateinit var image : ImageView
    var places = arrayOf("Tashkent City", "Registan Square", "Emir Temur Square", "NBU", "National Museum")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next = findViewById<ImageButton>(R.id.btnNext)
        val prev = findViewById<ImageButton>(R.id.btnPrev)
        val placeName = findViewById<TextView>(R.id.tVName)

        next.setOnClickListener {
            // getting the next image
            var idCurrentImageString= "pic$currentImage"

            // getting the integer address associated with each view
            var idCurrentImageInt= this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (5+currentImage + 1)%5 // the way of making loop
            var idImageToShowString = "pic$currentImage"
            var idImageToShowInt= this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            placeName.text = places[currentImage]

        }

        prev.setOnClickListener {
            // getting the next image
            var idCurrentImageString= "pic$currentImage"

            // getting the integer address associated with each view
            var idCurrentImageInt= this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (5+currentImage - 1)%5 // the way of making loop
            var idImageToShowString = "pic$currentImage"
            var idImageToShowInt= this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            placeName.text = places[currentImage]

        }

    }
}