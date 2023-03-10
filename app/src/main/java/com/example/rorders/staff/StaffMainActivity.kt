package com.example.rorders.staff

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.rorders.R
import com.example.rorders.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class StaffMainActivity : AppCompatActivity() {
    lateinit var nContext: Context
    private lateinit var auth: FirebaseAuth
    lateinit var signOutBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_main)
        nContext=this
        auth = Firebase.auth
        init()
        Toast.makeText(this, "Staff", Toast.LENGTH_SHORT).show()
    }
    private fun init(){
        signOutBtn=findViewById(R.id.signout_btn)
        signOutBtn.setOnClickListener {
            auth.signOut()
            var intent= Intent(nContext, LoginActivity::class.java)
            startActivity(intent)

        }
    }
}