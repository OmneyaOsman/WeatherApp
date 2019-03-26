package com.waether.app.feature.home

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.omni.entities.City
import com.waether.app.R

class CitySearchResultViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    init {

    }

    fun bind(city: City){

    }

}

class CitySearchResultAdapter(private val lifecycleOwner :LifecycleOwner ,private val citiesResult: MutableLiveData<List<City>>) :
    RecyclerView.Adapter<CitySearchResultViewHolder>() {



    init {
        citiesResult.observe(lifecycleOwner , Observer {
            notifyDataSetChanged()
        })
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CitySearchResultViewHolder {
        return LayoutInflater
            .from(p0.context)
            .inflate(R.layout.city_list_item , p0 , false)
            .let { CitySearchResultViewHolder(it) }
    }

    override fun getItemCount() =
        citiesResult.value?.size ?: 0

    override fun onBindViewHolder(holder: CitySearchResultViewHolder, pos: Int) {
        holder.bind(citiesResult.value!![pos])
    }
}