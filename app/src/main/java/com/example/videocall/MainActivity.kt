package com.example.videocall

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOne.setOnClickListener {

            videoCall()

        }
        btnThree.setOnClickListener {

            var t=Intent("com.soha.second")
            startActivity(t)
        }

        videoView.setOnCompletionListener {

            videoView.visibility = View.GONE
            btnOne.visibility = View.VISIBLE
        }




    }


    fun videoCall() {


            var i = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
            startActivityForResult(i, 2)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 2 && resultCode== Activity.RESULT_OK && data!=null){
            videoView.setVideoURI(data.data)
            btnOne.visibility = View.GONE
            btnThree.visibility=View.GONE
            videoView.visibility=View.VISIBLE
            videoView.start()
        }
        else
        {
            Toast.makeText(this,"Problems",Toast.LENGTH_LONG).show()
        }
    }




}
