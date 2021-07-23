package com.smartphone_codes.extinctanimals.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.smartphone_codes.extinctanimals.Datasource.animals
import com.smartphone_codes.extinctanimals.FragmentDetails
import com.smartphone_codes.extinctanimals.FragmentMainDirections
import com.smartphone_codes.extinctanimals.R

class animalsAdapter(val context:Context?, private val dataset:List<animals>) :RecyclerView.Adapter<animalsAdapter.animalViewHolder>(){

    companion object{
        const val tittle:String="tittle"
        const val detailstring:String="detailstring"
        const val image: String="image"

        const val url:String="https://www.google.com/search?q="
    }


    class animalViewHolder(val view: View):RecyclerView.ViewHolder(view){
        val cardImage:ImageView=view.findViewById(R.id.cardImg)
        val cardTxt: TextView =view.findViewById(R.id.cardTitle)
        val readBTN: Button =view.findViewById(R.id.main_readbtn)
        val highlightTXT: TextView=view.findViewById(R.id.highlighttxt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): animalViewHolder {
        val adapterlayout=LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout,parent,false)
        return animalViewHolder(adapterlayout)
    }

    override fun onBindViewHolder(holder: animalViewHolder, position: Int) {
        val item=dataset[position]

        holder.cardImage.setImageResource(item.imageId)
        holder.cardTxt.text = context?.resources?.getString(item.animal_name)
        holder.highlightTXT.text= context?.resources?.getString(item.animal_details)
        holder.readBTN.setOnClickListener {

            val action = FragmentMainDirections.actionFragmentMainToFragmentDetails2(item.imageId, item.animal_name, item.animal_details)
            holder.view.findNavController().navigate(action)

//            val intent=Intent(context,FragmentDetails::class.java)
//            intent.putExtra(KEY_tittle,item.animal_name)
//            intent.putExtra(KEY_image,item.imageId)
//            intent.putExtra(KEY_detail,item.animal_details)
//            context?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}