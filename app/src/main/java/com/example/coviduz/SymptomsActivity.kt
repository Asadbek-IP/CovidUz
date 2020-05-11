package com.example.coviduz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class SymptomsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptoms)
        recyclerView.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        val symptomsList=ArrayList<SymptomsModel>()
        symptomsList.add(SymptomsModel(R.drawable.cough,"Quruq Yo'tal","Ko'p hollarda quruq yo'tal.Uzoq muddatli yo'tal.Ayrim hollarda yo'talganda tomoqdan shilimshiq qon kelishi"))
        symptomsList.add(SymptomsModel(R.drawable.fever,"Isitma","Koronavirusga chalingan odamning yuqori isitma paydo bo'ladi ya'ni 37 gradusdan yuqori"))
        symptomsList.add(SymptomsModel(R.drawable.pain,"Bosh Og'rigi","Koronavirusga chalingan odam bosh o'g'rig'ini his qiladi va o'zini holsiz sezadi"))
        symptomsList.add(SymptomsModel(R.drawable.sore_throat,"Tomoq Og'rigi","Koronavirusga chalingan odamning tomog'i qirilib unga o'g'riq beradi ba'zida tomoqdan qol keladi"))

        val symptomsAdapter=SymptomsAdapter(symptomsList)

        recyclerView.adapter=symptomsAdapter
    }
}
