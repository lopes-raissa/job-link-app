package com.example.joblink.util

import android.net.ConnectivityManager
import android.net.NetworkCapabilities

class NetworkChecker(private val connectivityManager: ConnectivityManager?) {

    fun perforeActionIfConnectec(action: () -> Unit) {
        if (hasInternet())
            action()
    }

    private fun hasInternet(): Boolean {
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            val network = connectivityManager?.activeNetwork ?: return false
            val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false

            return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                    || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                    || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN)

        } else {
            val activeNeworkInfo = connectivityManager?.activeNetworkInfo
            if (activeNeworkInfo != null) {
                return activeNeworkInfo.type == ConnectivityManager.TYPE_WIFI
                        || activeNeworkInfo.type == ConnectivityManager.TYPE_MOBILE
            }
            false
        }
    }
}