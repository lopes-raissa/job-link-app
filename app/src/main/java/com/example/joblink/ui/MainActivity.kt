package com.example.joblink.ui

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
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import com.example.joblink.R
import com.example.joblink.api.RetrofitApi
import com.example.joblink.api.SessionManager
import com.example.joblink.model.LoginRequestModel
import com.example.joblink.model.LoginResponseModel
import com.example.joblink.model.PublicationResponseModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var apiClient: RetrofitApi
    private lateinit var sessionManager: SessionManager

    /* private var cancellationSignal: CancellationSignal? = null

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
                    notifyUser("Sucesso na Autenticação!")
                    startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                }
            }

    @RequiresApi(Build.VERSION_CODES.P)*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiClient = RetrofitApi()
        sessionManager = SessionManager(this)

        val call = apiClient.getApiService().login(LoginRequestModel(
                email = "fernandojackson@gmail.bin",
                password = "fernandojackson"
            )
        )

        call.enqueue(object : Callback<LoginResponseModel> {
            override fun onFailure(call: Call<LoginResponseModel>, t: Throwable) {
                // Error logging in
            }

            override fun onResponse(
                call: Call<LoginResponseModel>,
                response: Response<LoginResponseModel>
            ) {
                val loginResponse = response.body()

                if (loginResponse?.statusCode == 200 && loginResponse.client != null) {
                    sessionManager.saveAuthToken(loginResponse.token)
                } else {
                    // Error logging in
                }
            }
        })

        fun fetchPosts() {
            // Passe o token como parâmetro
            apiClient.getApiService().getPublication()
                .enqueue(object : Callback<PublicationResponseModel> {
                    override fun onFailure(call: Call<PublicationResponseModel>, t: Throwable) {
                        // Erro ao buscar postagens
                    }

                    override fun onResponse(
                        call: Call<PublicationResponseModel>,
                        response: Response<PublicationResponseModel>
                    ) {
                        // Manipular função para exibir postagens
                    }
                })

            //parte que abre o layout de criar conta
            val buttonAbrirCadastro = findViewById<TextView>(R.id.abrir_criar_conta)

            buttonAbrirCadastro.setOnClickListener {
                val abrirCadastro = Intent(this, HomeActivity::class.java)
                startActivity(abrirCadastro)
            }

            /*checkBiometricSupport()

        button_biometria.setOnClickListener {

            val biometricPrompt = BiometricPrompt.Builder(this)
                .setTitle("Logar com Biometria")
                .setDescription("Este aplicativo usa proteção de impressão digital para manter seus dados seguros")
                .setNegativeButton(
                    "Cancelar",
                    this.mainExecutor,
                    DialogInterface.OnClickListener { dialog, which ->
                        notifyUser("Autenticação Cancelada")
                    }).build()

            biometricPrompt.authenticate(
                getCancellationsSignal(),
                mainExecutor,
                authecationCallback
            )
        }*/
        }

        /*private fun notifyUser(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()    }

    private fun getCancellationsSignal(): CancellationSignal {
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
            != PackageManager.PERMISSION_GRANTED
        ) {
            notifyUser("A permissão de autenticação de impressão digital não está ativada")
            return false
        }
        return if (packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)) {
            true
        } else true
    }*/
  }
}