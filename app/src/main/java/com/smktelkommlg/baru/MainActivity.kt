package com.smktelkommlg.baru


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvBarang: RecyclerView
    private var list: ArrayList<Barang> = arrayListOf()
    private var title: String = "SHOP.ID"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvBarang = findViewById(R.id.rv_barang)
        rvBarang.setHasFixedSize(true)

        list.addAll(thingData.listData)
        showRecyclerList()

    }
    private fun showSelectedBarang(barang: Barang) {
        Toast.makeText(this, "Kamu memilih " + barang.name, Toast.LENGTH_SHORT).show()
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }


    private fun showRecyclerList() {
        rvBarang.layoutManager = LinearLayoutManager(this)
        val listBarangAdapter = ListBarangAdapter(list)
        rvBarang.adapter = listBarangAdapter
        listBarangAdapter.setOnItemClickCallback(object : ListBarangAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Barang) {
                showSelectedBarang(data)
            }
        })}}