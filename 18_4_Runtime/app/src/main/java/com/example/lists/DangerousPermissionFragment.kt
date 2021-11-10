package com.example.lists

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_permission_dangerous.*

class DangerousPermissionFragment : Fragment(R.layout.fragment_permission_dangerous) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        positionTextView.text = "Для отображения списка локаций необходимо разрешение"
        getCurrentLocationB.setOnClickListener {
            showLocationWithPermissionCheck()
        }

    }


    private fun showLocationWithPermissionCheck() {
        val isLocationPermissionGranted = ActivityCompat.checkSelfPermission(requireContext(),
            android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED

        if (!isLocationPermissionGranted) {
            requestLocationPermission()
        } else {
            showLocationInfo()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
            showLocationInfo()
        } else {
            toast("Нет разрешения на отображение локаций")
        }
    }


    private fun showLocationInfo() {
        positionTextView.text = "Нет локаций для отображения"
        getCurrentLocationB.isGone = true
        getCurrentLocationB2.isVisible = true
        toast("showLocationInfo")
    }

    private fun requestLocationPermission() {
        requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
            PERMISSION_REQUEST_CODE)
    }


    companion object {
        private const val PERMISSION_REQUEST_CODE = 7788
    }
}
