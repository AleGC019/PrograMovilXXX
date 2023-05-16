package com.example.example01.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.example01.R
import com.example.example01.SuperHeroe

class SuperHereoViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val superHeroeName = view.findViewById<TextView>(R.id.tvName)
    val superHeroeRealName = view.findViewById<TextView>(R.id.tvRealName)
    val superHeroePublisher = view.findViewById<TextView>(R.id.tvPublisher)
    val superHeroeImage = view.findViewById<ImageView>(R.id.ivcontainer)


    fun render(superHeroeModel: SuperHeroe){
        superHeroeName.text = superHeroeModel.name
        superHeroeRealName.text = superHeroeModel.realName
        superHeroePublisher.text = superHeroeModel.publisher
    }


}