package com.example.android_kotlin_five

import android.Manifest
import android.app.Instrumentation.ActivityResult
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Audio.Media
import android.view.View
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.android_kotlin_five.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    val getAction = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        val bitmap = it.data?.extras?.get("data")as Bitmap
        binding.imageView.setImageBitmap(bitmap)
    }
    fun takePhoto(view: View){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null)
            getAction.launch(intent)
    }
//        setupListener()
//
//    }
//
//    private fun setupListener() {
//        binding.btn.setOnClickListener {
//            if (ContextCompat.checkSelfPermission(
//                    this,
//                    android.Manifest.permission.READ_EXTERNAL_STORAGE
//                )
//                != PackageManager.PERMISSION_DENIED
//            ) {
//                if (ActivityCompat.shouldShowRequestPermissionRationale(
//                        this,
//                        Manifest.permission.READ_EXTERNAL_STORAGE
//                    )
//                ) {
//                } else {
//                    ActivityCompat.requestPermissions(
//                        this,
//                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
//                        100
//                    )
//                }
//            } else {
//                startActivityForResult(
//                    Intent(
//                        Intent.ACTION_PICK,
//                        MediaStore.Images.Media.INTERNAL_CONTENT_URI
//                    ), 100
//                )
//            }
//        }
//    }
}