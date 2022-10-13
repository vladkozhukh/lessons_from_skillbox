package com.example.m18_permissions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.camera.core.ImageCapture
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.example.m18_permissions.data.Photo
import com.example.m18_permissions.databinding.ActivityMainBinding
import com.example.m18_permissions.presentation.PhotoAdapter
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.Executor

private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss"

class MainActivity : AppCompatActivity() {

    private var imageCapture: ImageCapture? = null
    private lateinit var executor: Executor
    private lateinit var binding: ActivityMainBinding
    private var adapter = PhotoAdapter()

    private val imageUri = listOf<Photo>()
    private var index = 1

    private val name = SimpleDateFormat(FILENAME_FORMAT, Locale.US)
        .format(System.currentTimeMillis())

//    private val launcher =
//        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { map ->
//            if (map.values.all { it }) {
//                startCamera()
//            } else {
//                Toast.makeText(this, "permission is not Granted", Toast.LENGTH_SHORT).show()
//            }
//        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
//        executor = ContextCompat.getMainExecutor(this)
//        binding.takePhotoButton.setOnClickListener {
//            takePhoto()
//        }
//
//        checkPermissions()
    }

    private fun init() {
        binding.apply {
            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            recyclerView.adapter = adapter
            takePhotoButton.setOnClickListener {
                val photo =
                    Photo(UUID.randomUUID(), "https://source.unsplash.com/random/800x600", "$index")
                adapter.addPhoto(photo)
                index++
            }
        }
    }

//    private fun takePhoto() {
//        val imageCapture = imageCapture ?: return
//        val contentValues = ContentValues().apply {
//            put(MediaStore.MediaColumns.DISPLAY_NAME, name)
//            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
//        }
//        val outPutOptions = ImageCapture.OutputFileOptions.Builder(
//            contentResolver,
//            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//            contentValues
//        )
//            .build()
//
//        imageCapture.takePicture(
//            outPutOptions,
//            executor,
//            object : ImageCapture.OnImageSavedCallback {
//                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
//                    Toast.makeText(this@MainActivity,
//                        "Photo saved on: {${outputFileResults.savedUri}}",
//                        Toast.LENGTH_SHORT).show()
//                    Glide.with(this@MainActivity)
//                        .load(outputFileResults.savedUri)
//                        .circleCrop()
//                        .into(binding.viewPreview)
//                }
//
//                override fun onError(exception: ImageCaptureException) {
//                    Toast.makeText(this@MainActivity,
//                        "Photo failed {${exception.message}}",
//                        Toast.LENGTH_SHORT).show()
//                    exception.printStackTrace()
//                }
//
//            }
//        )
//    }
//
//    private fun startCamera() {
//        val cameraProviderFeature = ProcessCameraProvider.getInstance(this)
//        cameraProviderFeature.addListener({
//            val cameraProvider = cameraProviderFeature.get()
//            val preview = Preview.Builder().build()
//            preview.setSurfaceProvider(binding.viewFinder.surfaceProvider)
//            imageCapture = ImageCapture.Builder().build()
//            cameraProvider.unbindAll()
//            cameraProvider.bindToLifecycle(
//                this,
//                CameraSelector.DEFAULT_BACK_CAMERA,
//                preview,
//                imageCapture
//            )
//        }, executor)
//    }
//
//    private fun checkPermissions() {
//        val isAllGranted = REQUEST_PERMISSIONS.all { permissions ->
//            ContextCompat.checkSelfPermission(this,
//                permissions) == PackageManager.PERMISSION_GRANTED
//        }
//        if (isAllGranted) {
//            startCamera()
//            Toast.makeText(this, "permission is Granted", Toast.LENGTH_SHORT).show()
//        } else {
//            launcher.launch(REQUEST_PERMISSIONS)
//        }
//    }
//
//    companion object {
//        private val REQUEST_PERMISSIONS: Array<String> = buildList {
//            add(Manifest.permission.CAMERA)
//            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
//                add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
//            }
//        }.toTypedArray()
//    }
}