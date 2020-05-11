package com.example.coviduz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_precautions.*


class PrecautionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_precautions)
        recyclerView.layoutManager=
            LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        val precautionsList=ArrayList<PrecautionsModel>()
        precautionsList.add(PrecautionsModel(R.drawable.soap,"Qo'lni Yuvish","Yo'tal quruq yoki nam bo'lishi mumkin.Uzoq muddatli yo'tal.Ayrim hollarda yo'talganda tomoqdan shilimshiq qon kelishi"))
        precautionsList.add(PrecautionsModel(R.drawable.hone,"Uyda Qolish","Yo'tal quruq yoki nam bo'lishi mumkin.Uzoq muddatli yo'tal.Ayrim hollarda yo'talganda tomoqdan shilimshiq qon kelishi"))
        precautionsList.add(PrecautionsModel(R.drawable.distance,"Masofani Saqlash","Yo'tal quruq yoki nam bo'lishi mumkin.Uzoq muddatli yo'tal.Ayrim hollarda yo'talganda tomoqdan shilimshiq qon kelishi"))
        precautionsList.add(PrecautionsModel(R.drawable.clean,"Toza Buyumlar","Yo'tal quruq yoki nam bo'lishi mumkin.Uzoq muddatli yo'tal.Ayrim hollarda yo'talganda tomoqdan shilimshiq qon kelishi"))
        precautionsList.add(PrecautionsModel(R.drawable.cover,"Qo'l bn Tegmang","Yo'tal quruq yoki nam bo'lishi mumkin.Uzoq muddatli yo'tal.Ayrim hollarda yo'talganda tomoqdan shilimshiq qon kelishi"))


        val precautionsAdapter=PrecautionsAdapter(precautionsList)
        recyclerView.adapter=precautionsAdapter
    }
}
