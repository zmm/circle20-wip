package com.megaprojectsuperpuper.thecode


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_level1.*
import kotlinx.android.synthetic.main.activity_mainf.*
import java.util.*
import kotlin.concurrent.schedule
import kotlin.math.round


class Level18 : BackMusicActivity() {
    var i = 0
    var editcheck = true
    var text = ""
    var check = ""
    var name = "18. 方便麵"
    var lvlcheck = 1
    var soundcheck = 0
    private lateinit var prefs: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefs = getSharedPreferences("settings", Context.MODE_PRIVATE)
        lvlcheck = prefs.getInt("lvlcheck", 18)
        val editor = prefs.edit()
        editor.putInt("languagecheck0", 1)
        editor.apply()

        setContentView(R.layout.activity_level1)
        lvl_name.setText(name)

        for (i in 1..4){
            var a = Math.random()
            while (round(a*10).toInt() ==10)
            {
                a = Math.random()
            }
            if (round(a*10).toInt() != 10) {
                check += (round(a*10).toInt())
                check += " "
            }
        }
        Level11()



        pausebutton.setOnClickListener(){
            pauseupdate(clickable = true, alpha = 1f, visibility = View.INVISIBLE)

            soundcheck = prefs.getInt("soundcheck", 0)
            if (soundcheck == 1){
                soundbutton.visibility = View.INVISIBLE
                soundoffbutton.visibility = View.VISIBLE
                stopService(Intent(this, BackgroundMusic::class.java))
            }
            menubutton.setOnClickListener(){
                val intent = Intent(this, First_screen::class.java)
                startActivity(intent)
                this.finish()
            }
            soundbutton.setOnClickListener(){
                val editor = prefs.edit()
                editor.putInt("soundcheck", 1)
                editor.apply()
                soundbutton.visibility = View.INVISIBLE
                soundoffbutton.visibility = View.VISIBLE
            }
            soundoffbutton.setOnClickListener(){
                val editor = prefs.edit()
                editor.putInt("soundcheck", 0)
                editor.apply()
                soundbutton.visibility = View.VISIBLE
                soundoffbutton.visibility = View.INVISIBLE
                startService(Intent(this, BackgroundMusic::class.java))
            }
            resumebutton.setOnClickListener(){
                pauseupdate(clickable = false, alpha = 0.8f, visibility = View.VISIBLE)
            }

        }




    }
    fun pauseupdate(clickable:Boolean, alpha:Float, visibility:Int){
        var visres: Int = if (visibility== View.INVISIBLE){
            View.VISIBLE }

        else
            View.INVISIBLE
        var alphares: Float = if (alpha == 1f){
            0.8f
        }
        else
            1f
        var clres: Boolean = clickable != true

        pausebutton.visibility = visibility
        resumebutton.visibility = visres
        menubutton.visibility = visres
        soundoffbutton.visibility = visres
        soundbutton.visibility = visres
        textView.alpha = alphares
        textView4.alpha = alphares
        imageView.alpha = alphares
        stol.alpha = alphares
        redbutton.isClickable = clres
        num1.isClickable = clres
        num2.isClickable = clres
        num3.isClickable = clres
        num4.isClickable = clres
        num5.isClickable = clres
        num6.isClickable = clres
        num7.isClickable = clres
        num8.isClickable = clres
        num9.isClickable = clres
        num0.isClickable = clres
        mainbutton.isClickable = clres
        stol.isClickable = clres



    }


    fun kubok(){
        if (prefs.getInt("lvlcheck", 18) <= 19) {
            lvlcheck = 19
            val editor = prefs.edit()
            editor.putInt("lvlcheck", lvlcheck)
            editor.apply()
        }
        setContentView(R.layout.activity_mainf)
        buttonlvl.setOnClickListener(){
            val intent = Intent(this, Level19::class.java)
            startActivity(intent)
            this.finish()
        }
    }
    fun Level11(){
        mainbutton.setOnClickListener{
            //запуска второй активити в вводом кода
            mainbutton.visibility = View.INVISIBLE
            stol.visibility = View.INVISIBLE
            textView.visibility = View.VISIBLE
            textView4.visibility = View.VISIBLE
            imageView.visibility = View.VISIBLE
            num1.visibility = View.VISIBLE
            redbutton.visibility = View.VISIBLE
            num2.visibility = View.VISIBLE
            num3.visibility = View.VISIBLE
            num4.visibility = View.VISIBLE
            num5.visibility = View.VISIBLE
            num6.visibility = View.VISIBLE
            num7.visibility = View.VISIBLE
            num8.visibility = View.VISIBLE
            num9.visibility = View.VISIBLE
            num0.visibility = View.VISIBLE
            Level12()
        }
    }
    fun Level12() {
        if (prefs.getInt("languagecheck1", 1) == 2){
            textView.visibility = View.VISIBLE
            textView.setText(check)
            val editor = prefs.edit()
            editor.putInt("languagecheck1", 0)
            editor.apply()
            editor.putInt("languagecheck0", 0)
            editor.apply()

        }
        delete.setOnClickListener{
            textView4.setText("")
            text = ""
            i=0
        }
        num1.setOnClickListener{
            vvod(1)
        }
        num2.setOnClickListener{
            vvod(2)
        }
        num3.setOnClickListener{
            vvod(3)
        }
        num4.setOnClickListener{
            vvod(4)
        }
        num5.setOnClickListener{
            vvod(5)
        }
        num6.setOnClickListener{
            vvod(6)
        }
        num7.setOnClickListener{
            vvod(7)
        }
        num8.setOnClickListener{
            vvod(8)
        }
        num9.setOnClickListener{
            vvod(9)
        }
        num0.setOnClickListener{
            vvod(0)
        }
    }
    fun vvod(num: Int){
        if (editcheck){
            text+= "$num "
            textView4.setText(text)
            bool()
        }

    }
    fun bool(): Unit{
        i++
        if (i == 4){
            if(text.equals(check)){
                kubok()
            }
            else{
                textView.visibility = View.INVISIBLE
                text = ""
                i = 0
                editcheck = false
                error.visibility = View.VISIBLE
                Timer("settingUp", false).schedule(1500) {
                    textView4.setText(text)
                    editcheck = true
                    error.visibility = View.INVISIBLE
                    //Log.d("pupok", "gjrj")
                    //textView.visibility = View.VISIBLE
                }
                //Log.d("pupok","kok")
                //if (i == 0) textView.visibility = View.VISIBLE

            }
        }
    }
}