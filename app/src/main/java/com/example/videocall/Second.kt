package com.example.videocall

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_second.*

class Second : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btnTwo.setOnClickListener {

            var intent=Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA)
            startActivityForResult(intent,3)
        }


        btnTwo.filters
        ImageView.SOUND_EFFECTS_ENABLED
        imageView.setColorFilter(25000)
        imageView.display

           }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==3 && resultCode== Activity.RESULT_OK && data != null){
            imageView.setImageURI(data.data)
            btnTwo.visibility=View.GONE
            imageView.visibility=View.VISIBLE
            imageView.animate()

        }
    }
}
