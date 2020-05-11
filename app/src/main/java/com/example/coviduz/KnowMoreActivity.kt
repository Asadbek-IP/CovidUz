package com.example.coviduz

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_know_more.*
import kotlinx.android.synthetic.main.activity_main.*

class KnowMoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_know_more)
        btnLearnMoree.setOnClickListener{
            var intent =Intent(Intent.ACTION_VIEW,Uri.parse("https://kun.uz/faq/koronavirus"))
            startActivity(intent)
        }
    }
}
