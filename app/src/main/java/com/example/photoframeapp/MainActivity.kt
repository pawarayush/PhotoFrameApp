package com.example.photoframeapp

import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.photoframeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var currentImage = 0
    var names = arrayOf("Ayush Pawar","Elbert","Tesla","Virat Kohli")
    lateinit var image: ImageView
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val prev = binding.imgprev
        val next = binding.imgnext
        val text = binding.textView5








        prev.setOnClickListener{
            //for prev button

            val idCurrentImageString = "pic$currentImage"

            // convert String id into int

            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha=0f


            currentImage=(4+currentImage-1)%4



            val idImageToShowString = "pic$currentImage"
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha=1f
            text.text=names[currentImage]





        }
        next.setOnClickListener{
            val idCurrentImageString = "pic$currentImage"

            // convert String id into int

            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha=0f



            currentImage=(4+currentImage+1)%4



            val idImageToShowString = "pic$currentImage"
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha=1f
            text.text=names[currentImage]


        }


    }
}