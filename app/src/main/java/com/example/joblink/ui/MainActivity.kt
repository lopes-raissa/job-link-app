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
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import com.example.joblink.R
import com.example.joblink.api.RetrofitApi
import com.example.joblink.api.SessionManager
import com.example.joblink.api.UserSessionCall
import com.example.joblink.model.UserLoginModel
import com.example.joblink.model.LoginResponseModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var emailField: EditText
    lateinit var passwordField: EditText
    lateinit var buttonSignIn: Button

    private lateinit var sessionManager: SessionManager
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
                    notifyUser("Sucesso na Autenticação!")
                    startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                }
            }

    private fun goToHome() {
        val homeActivity = Intent(this, HomeActivity::class.java)
        startActivity(homeActivity)
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailField = findViewById(R.id.email)
        passwordField = findViewById(R.id.et_password_login)
        buttonSignIn = findViewById(R.id.button_sign_in)

        //parte que abre o layout de criar conta
        val GoToRegister = findViewById<TextView>(R.id.tv_create)

        GoToRegister.setOnClickListener {
            val openRegistration = Intent(this, RegisterJobLinkActivity::class.java)
            startActivity(openRegistration)
        }

        checkBiometricSupport()

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
        }

        //Botão Login chamado
        buttonSignIn.setOnClickListener(this)
    }

    private fun notifyUser(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

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
    }

    override fun onClick(v: View?) {

        if (emailField.text.toString() == "" || passwordField.text.toString() == "") {
            Toast.makeText(this@MainActivity, "É preciso efetuar o Login", Toast.LENGTH_LONG).show()
        } else {
            loggedIn()
        }
    }

    fun loggedIn() {

        val user = UserLoginModel(
            email = emailField.text.toString(),
            password = passwordField.text.toString()
        )

        val retrofit = RetrofitApi.getRetrofit()
        val loginCall = retrofit.create(UserSessionCall::class.java)

        val call = loginCall.login(user)

        call.enqueue(object : Callback<LoginResponseModel> {
            override fun onFailure(call: Call<LoginResponseModel>, t: Throwable) {
                Toast.makeText(this@MainActivity, "A conexão falhou :(", Toast.LENGTH_LONG).show()
                Log.e("ERRO_CONEXÃO", t.message.toString())
            }

            override fun onResponse(
                call: Call<LoginResponseModel>,
                response: Response<LoginResponseModel>
            ) {
                val loginResponse = response.body()

                if (response.code().toString() == "200" || response.code()
                        .toString() == "201" && loginResponse?.client != null
                ) {
                    sessionManager.saveAuthToken(loginResponse!!.token)
                    Log.e("ERRO_CONEXÃO", loginResponse.token.toString());
                    goToHome()

                } else {
                    Toast.makeText(this@MainActivity, "email ou senha incorreto", Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }
}