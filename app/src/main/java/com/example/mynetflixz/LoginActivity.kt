package com.example.mynetflixz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mynetflixz.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
       binding.apply {
           loginBtn.setOnClickListener{
               if(edittextUser.text.toString().isEmpty() || edittextPassword.text.toString().isEmpty()){
                   Toast.makeText(this@LoginActivity, "Please fill your userName and password", Toast.LENGTH_LONG).show()
               } else if(edittextUser.text.toString() == "test" && edittextPassword.text.toString() == "test"){
                    supportFragmentManager.beginTransaction().setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right).replace(R.id.placeHolder,MainFragment()).commit()
               }else{
                   Toast.makeText(this@LoginActivity, "Your user and password is not correct", Toast.LENGTH_SHORT).show()
               }
           }
       }
    }
}