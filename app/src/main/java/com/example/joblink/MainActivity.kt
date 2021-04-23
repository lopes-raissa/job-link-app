package com.example.joblink

import android.app.KeyguardManager
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CancellationSignal
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var cancellationSignal: CancellationSignal? = null

    private val authecationCallback: BiometricPrompt.AuthenticationCallback
    get() =
        @RequiresApi(Build.VERSION_CODES.P)
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
                super.onAuthenticationError(errorCode, errString)
                notifyUser("Erro de autenticação: $errString")
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult?) {
                super.onAuthenticationSucceeded(result)
                notifyUser("Authentication success!")
                startActivity(Intent(this@MainActivity, SecretActivity::class.java))
            }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkBiometricSupport()

        button_biometria.setOnClickListener {

            val biometricPrompt = BiometricPrompt.Builder(this)
                .setTitle("Titolu fo promtodfe")
                .setSubtitle("Autenticação é requerida")
                .setDescription("Este aplicativo usa proteção de impressão digital para manter seus dados seguros")
                .setNegativeButton("Cancelar", this.mainExecutor, DialogInterface.OnClickListener { dialog, which ->
                    notifyUser("Autenticação Cancelada")
                }).build()

            biometricPrompt.authenticate(getCancellationsSignal(),mainExecutor,authecationCallback)
        }
    }

    private fun notifyUser(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun getCancellationsSignal() : CancellationSignal {
        cancellationSignal = CancellationSignal()
        cancellationSignal?.setOnCancelListener {
            notifyUser("A autenticação foi cancelada pelo usuário")
        }
        return cancellationSignal as CancellationSignal
    }

    private fun checkBiometricSupport(): Boolean {

        val keyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager

        if (!keyguardManager.isKeyguardSecure) {
            notifyUser("A autenticação de impressão digital não foi habilitada nas configurações")
            return false
        }

        if (ActivityCompat
                .checkSelfPermission(this, android.Manifest.permission.USE_BIOMETRIC)
            != PackageManager.PERMISSION_GRANTED) {
            notifyUser("Fingerprint authetication permission is not enabled")
            return false
            }
        return if (packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)) {
           true
        } else true

    }
}