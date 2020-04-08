package com.example.tmd1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager
    private val firstFragment = MainFragment()
    private val secondFragment = SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //  setFragment(MainFragment())


    }
  //  fun setFragment(f: Fragment) {

       // val ft = supportFragmentManager.beginTransaction()

      //  ft.replace(R.id.framelayout, f)
      //  ft.commit()
    //}



}

