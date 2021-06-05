package com.example.joblink.ui

import android.Manifest
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.core.app.ActivityCompat
import com.example.joblink.R
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener

class LocationOfServicesActivity : AppCompatActivity() {

    lateinit var client: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_of_services)

        client = LocationServices.getFusedLocationProviderClient(this)
    }

    override fun onResume() {
        super.onResume()
        var errorCode = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this)

        when (errorCode) {
            1 -> {
                ConnectionResult.SERVICE_MISSING
                Toast.makeText(this, "show Dialog 1", Toast.LENGTH_SHORT).show()
            }
            2 -> {
                ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED
                Toast.makeText(this, "show Dialog 2", Toast.LENGTH_SHORT).show()
            }
            3 -> {
                ConnectionResult.SERVICE_DISABLED
                Toast.makeText(this, "show Dialog 3", Toast.LENGTH_SHORT).show()

                GoogleApiAvailability.getInstance().getErrorDialog(this, errorCode,
                    0, DialogInterface.OnCancelListener() {
                        finish()
                    })
            }

            else -> {
                ConnectionResult.SUCCESS
                Log.d("TESTE SUCESSSSOOOO", "Atualizadooo")
            }
        }


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }

        client.lastLocation
            .addOnSuccessListener(OnSuccessListener<Location> {
            fun onSuccess(location: Location) {
                if (location != null) {
                    Log.i("TESTE DE LOCALIZAÇAO", location.latitude.toString() + "" + location.longitude)
                }

            }
        }).addOnFailureListener(OnFailureListener() {
            fun onFailure(@NonNull e: Exception) {

            }
        })


    }
}