
package com.example.tenantmanagementsystem

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val savedEmail = intent.getStringExtra("EMAIL") ?: ""

        setContent {
            LoginScreen(
                onLogin = { email, password ->
                    if (email.isNotBlank() && password.isNotBlank()) {
                        val nextIntent = Intent(this, MainActivity::class.java)
                        nextIntent.putExtra("EMAIL", email)
                        startActivity(nextIntent)
                    } else {
                        Toast.makeText(
                            this,
                            "Enter your email and password",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                onRegister = {
                    startActivity(
                        Intent(this, RegisterActivity::class.java)
                    )
                },
                onHelp = {
                    val websiteIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.strathmore.edu/")
                    )
                    startActivity(websiteIntent)
                }
            )
        }
    }
}
