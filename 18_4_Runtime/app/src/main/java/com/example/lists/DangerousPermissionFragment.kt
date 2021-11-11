package com.example.lists

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.fragment_permission_dangerous.*
import org.threeten.bp.Instant
import kotlin.random.Random

class DangerousPermissionFragment : Fragment(R.layout.fragment_permission_dangerous) {

    private var datasets: List<Dataset> = listOf()
    private var datasetAdapter: DatasetAdapter? = null
    private var selectedDatasetInstant: Instant? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        initLocationInfo()
        messageTextView.text = "Для отображения списка локаций необходимо разрешение"
        getAllowButton.setOnClickListener {
            showLocationWithPermissionCheck()
        }

    }



    private fun initList() = with(dataSetList) {
        datasetAdapter = DatasetAdapter()
        adapter = datasetAdapter
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(requireContext())
        datasetAdapter?.submitList(datasets)
    }

    private fun initLocationInfo() {
        getCurrentLocationButton.setOnClickListener {
            val newLocation = Dataset(
                id = Random.nextLong(),
                text = showLocation().toString(),
                createdAt = selectedDatasetInstant ?: Instant.now()
            )
            datasets = datasets + listOf(newLocation)
            datasetAdapter?.submitList(datasets)
            selectedDatasetInstant = null
        }
    }
    private fun showLocationWithPermissionCheck() {
        val isLocationPermissionGranted = ActivityCompat.checkSelfPermission(
            requireContext(),
            android.Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

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
        messageTextView.text = "Нет локаций для отображения"
        getAllowButton.isGone = true
        getCurrentLocationButton.isVisible = true
    }

    @SuppressLint("MissingPermission")
    private fun showLocation() {
        LocationServices.getFusedLocationProviderClient(requireContext())
            .lastLocation
            .addOnSuccessListener {
                it?.let {
                    """ Lat = ${it.latitude}
                        Lng = ${it.longitude}
                        Alt = ${it.altitude}
                        Speed = ${it.speed}
                        Accuracy = ${it.accuracy}
                    """.trimIndent()
                } ?: toast("Локация отсутсвует")
            }
            .addOnCanceledListener {
                toast("запрос локации был отменен")
            }
            .addOnFailureListener {
                toast("запрос локации завершился неудачно")
            }
    }


    private fun requestLocationPermission() {
        requestPermissions(
            arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
            PERMISSION_REQUEST_CODE
        )
    }


    companion object {
        private const val PERMISSION_REQUEST_CODE = 7788
    }
}
