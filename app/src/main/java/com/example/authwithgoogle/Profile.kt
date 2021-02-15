package com.example.authwithgoogle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_profile.*

class Profile : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        auth = FirebaseAuth.getInstance()

        var user = auth.currentUser

        txtID.text = user?.uid
        txtEmail.text = user?.email
        txtName.text = user?.displayName

        btnSignOut.setOnClickListener {
            signout()
        }
    }
    private fun signout(){
        auth.signOut()
        Toast.makeText(this@Profile, "Sign Out!", Toast.LENGTH_SHORT).show()
        val intent = Intent(this@Profile, MainActivity::class.java)
        startActivity(intent)
    }
}