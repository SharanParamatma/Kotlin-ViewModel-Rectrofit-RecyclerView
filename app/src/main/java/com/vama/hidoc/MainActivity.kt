package com.vama.hidoc

import android.content.Intent
import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    internal lateinit var recyclerView: RecyclerView
    private var adapter: AdapterData? = null
    private var list: List<Resultarray>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.setHasFixedSize(true)
        val model = ViewModelProviders.of(this).get(DataViewModel::class.java!!)
        model.text.observe(this, Observer<Example> { example ->
            adapter = AdapterData(this@MainActivity, example.resultarray!!)
            recyclerView.adapter = adapter
            list = example.resultarray
        })
        recyclerView.addOnItemTouchListener(RecyclerViewClick.RecyclerItemClickListener(this,
                recyclerView, object : RecyclerViewClick.RecyclerItemClickListener.OnItemClickListener {
            override fun onItemLongClick(view: View?, position: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemClick(view: View, position: Int) {
                if (list != null) {
                    val listData = list!![position]
                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    intent.putExtra("Model", listData)
                    startActivity(intent)
                }
            }


        }))


    }


}
