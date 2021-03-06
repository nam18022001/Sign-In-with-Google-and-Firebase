package com.example.authwithgoogle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile.*

class Profile : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        auth = FirebaseAuth.getInstance()

        var user = auth.currentUser
        Picasso.with(this)
                .load(user?.photoUrl)
                .resize(500, 500)
                .into(imageView)
        txtID.text = user?.uid
        txtEmail.text = user?.email
        txtName.text = user?.displayName
        Log.d("ok", "url: "+ user?.photoUrl.toString())
        btnSignOut.setOnClickListener {
            signout()
        }
    }
    private fun signout(){
        auth.signOut()
        Toast.makeText(this@Profile, "Sign Out!", Toast.LENGTH_SHORT).show()
        val intent = Intent(this@Profile, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}