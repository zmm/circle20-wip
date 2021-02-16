package com.megaprojectsuperpuper.thecode

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first_screen.*



class First_screen : AppCompatActivity() {
    var lvlcheck = 1
    private lateinit var prefs: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_screen)
        prefs = getSharedPreferences("settings", Context.MODE_PRIVATE)
        lvlcheck = prefs.getInt("lvlcheck", 1)
        play.setOnClickListener{
            if (lvlcheck == 1){
                val intent = Intent(this, Level1::class.java)
                startActivity(intent)

            }
            if (lvlcheck == 2){
                val intent = Intent(this, Level2::class.java)
                startActivity(intent)

            }
            if (lvlcheck == 3){
                val intent = Intent(this, Level3::class.java)
                startActivity(intent)

            }
            if (lvlcheck == 4){
                val intent = Intent(this, Level4::class.java)
                startActivity(intent)

            }
            if (lvlcheck == 5){
                val intent = Intent(this, Level5::class.java)
                startActivity(intent)

            }
            if (lvlcheck == 6){
                val intent = Intent(this, Level6::class.java)
                startActivity(intent)

            }
            if (lvlcheck == 7){
            val intent = Intent(this, Level7::class.java)
            startActivity(intent)
            }
            if (lvlcheck == 8){
                val intent = Intent(this, Level8::class.java)
                startActivity(intent)

            }
            if (lvlcheck == 9){
                val intent = Intent(this, Level9::class.java)
                startActivity(intent)

            }
            if (lvlcheck == 10){
                val intent = Intent(this, Level10::class.java)
                startActivity(intent)

            }
            if (lvlcheck == 11){
                val intent = Intent(this, Level10::class.java)
                startActivity(intent)

            }
            }
        list_of_levels.setOnClickListener(){
            val intent = Intent(this, menu::class.java)
            startActivity(intent)

        }
        }


    }
