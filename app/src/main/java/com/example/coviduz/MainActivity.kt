package com.example.coviduz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_know_more.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayout.HORIZONTAL,false)
        val symptomsList=ArrayList<SymptomsModel>()
        symptomsList.add(SymptomsModel(R.drawable.cough,"Quruq Yo'tal","Ko'p hollarda quruq yo'tal.Uzoq muddatli yo'tal.Ayrim hollarda yo'talganda tomoqdan shilimshiq qon kelishi"))
        symptomsList.add(SymptomsModel(R.drawable.fever,"Isitma","Koronavirusga chalingan odamning yuqori isitma paydo bo'ladi ya'ni 37 gradusdan yuqori"))
        symptomsList.add(SymptomsModel(R.drawable.pain,"Bosh Og'rigi","Koronavirusga chalingan odam bosh o'g'rig'ini his qiladi va o'zini holsiz sezadi"))
        symptomsList.add(SymptomsModel(R.drawable.sore_throat,"Tomoq Og'rigi","Koronavirusga chalingan odamning tomog'i qirilib unga o'g'riq beradi ba'zida tomoqdan qol keladi"))

        val symptomsAdapter=SymptomsAdapter(symptomsList)

        recyclerView.adapter=symptomsAdapter

        recyclerViewPrecautions.layoutManager=LinearLayoutManager(this,LinearLayout.HORIZONTAL,false)
        val precautionsList=ArrayList<PrecautionsModel>()
        precautionsList.add(PrecautionsModel(R.drawable.soap,"Qo'lni Yuvish","Yo'tal quruq yoki nam bo'lishi mumkin.Uzoq muddatli yo'tal.Ayrim hollarda yo'talganda tomoqdan shilimshiq qon kelishi"))
        precautionsList.add(PrecautionsModel(R.drawable.hone,"Uyda Qolish","Yo'tal quruq yoki nam bo'lishi mumkin.Uzoq muddatli yo'tal.Ayrim hollarda yo'talganda tomoqdan shilimshiq qon kelishi"))
        precautionsList.add(PrecautionsModel(R.drawable.distance,"Masofani Saqlash","Yo'tal quruq yoki nam bo'lishi mumkin.Uzoq muddatli yo'tal.Ayrim hollarda yo'talganda tomoqdan shilimshiq qon kelishi"))
        precautionsList.add(PrecautionsModel(R.drawable.clean,"Toza Buyumlar","Yo'tal quruq yoki nam bo'lishi mumkin.Uzoq muddatli yo'tal.Ayrim hollarda yo'talganda tomoqdan shilimshiq qon kelishi"))
        precautionsList.add(PrecautionsModel(R.drawable.cover,"Qo'l bn Tegmang","Yo'tal quruq yoki nam bo'lishi mumkin.Uzoq muddatli yo'tal.Ayrim hollarda yo'talganda tomoqdan shilimshiq qon kelishi"))


        val precautionsAdapter=PrecautionsAdapter(precautionsList)
        recyclerViewPrecautions.adapter=precautionsAdapter

        btnLearnMore.setOnClickListener{
            var intent= Intent(this@MainActivity,KnowMoreActivity::class.java)
            startActivity(intent)
        }

        txtViewSymptoms.setOnClickListener{
            var intent= Intent(this@MainActivity,SymptomsActivity::class.java)
            startActivity(intent)
        }


        getGlobalData()
    }

    fun getGlobalData(){
        val url:String ="https://disease.sh/v2/countries/Uzbekistan?yesterday=false&strict=false"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener<String> {

                var jsonObject = JSONObject(it.toString())

                //now set values in textview
                txtInfected.text = jsonObject.getString("cases")
                txtRecovered.text = jsonObject.getString("recovered")
                txtDeceased.text = jsonObject.getString("deaths")

            },
            Response.ErrorListener {
                Toast.makeText(this@MainActivity,"Internetga ulanmagan!",Toast.LENGTH_LONG).show()
                txtInfected.text = "-"
                txtRecovered.text = "-"
                txtDeceased.text = "-"

            }
        )

        val requestQueue = Volley.newRequestQueue(this@MainActivity)
        requestQueue.add(stringRequest)
    }

}
