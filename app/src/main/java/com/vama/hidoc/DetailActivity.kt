package com.vama.hidoc

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    internal var resultarray: Resultarray? = null
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val text = findViewById<TextView>(R.id.text)
        val i = intent
        resultarray = i.getSerializableExtra("Model") as Resultarray
        if (resultarray != null) {
            text.text = (resultarray!!.id
                    + "\n" + resultarray!!.title
                    + "\n" + resultarray!!.date
                    + "\n" + resultarray!!.summary + "\n" + Html.fromHtml(resultarray!!.description))
            /*  code here for more data*/
        }
    }
}
