package com.example.a2024604.ui.theme

import android.content.Context
import android.util.Log

import androidx.compose.runtime.MutableState
import com.android.volley.Request


import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject


fun volleyRequest(context: Context,cardNum: MutableState<String>,cardExp: MutableState<String>){
    val queue = Volley.newRequestQueue(context)
    val url = "http://172.20.10.5:7886/credit_cards"
    var response: JSONObject
    val stringRequest = StringRequest(
        Request.Method.GET, url,
        {
            Log.d("Success","simpleRequest:${it}")
            response= JSONObject(it)

            cardNum.value= response.getString("credit_card_number")
            cardExp.value= response.getString("credit_card_expiry_date")
        },{
            cardNum.apply { "1211-1221-1234-2201" }
            cardExp.apply { "2028-06-01" }
            Log.d("Error","simpleRequest:${it}")
        })
    queue.add(stringRequest)
}