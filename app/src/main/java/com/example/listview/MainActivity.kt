package com.example.listview

import android.R
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val nombres = arrayOf<String>(
        "Samuel",
        "Valentina",
        "Sandra",
        "Fidel",
        "Silvia",
        "Paola",
        "Gaby",
        "Katya",
        "Claudia"
    )
    val imagen = arrayListOf<Int>(R.drawable.mono)
    private val edades = arrayOf<String>("33", "43", "19", "21", "21", "21", "23", "21", "22")
    private lateinit var paises: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        llenarListView();

        paises = resources.getStringArray(R.array.paises)
        val adapter:ArrayAdapter<String> = ArrayAdapter(
            applicationContext, android.R.layout.simple_spinner_item,
            android.R.id.text1, paises
        )
        spnSpinner.adapter = adapter
    }

    private fun llenarListView() {
        val adapter: ArrayAdapter<Int> =
            ArrayAdapter(this, R.layout.layout, imagen);
        list_view.adapter = adapter;

        list_view.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                txt_texto.text =
                    "La edad de ${parent.getItemAtPosition(position).toString()} es ${edades.get(
                        position
                    )} años ";
            }
    }
}

