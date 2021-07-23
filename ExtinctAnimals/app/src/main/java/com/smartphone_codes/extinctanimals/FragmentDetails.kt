package com.smartphone_codes.extinctanimals

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import com.smartphone_codes.extinctanimals.Adapter.animalsAdapter
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.smartphone_codes.extinctanimals.databinding.FragmentDetailsBinding
import com.smartphone_codes.extinctanimals.databinding.FragmentMainBinding

class FragmentDetails : Fragment() {

    private var _binding : FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private var imageId: Int? = null
    private var tittleId:Int? = null
    private var detailsId:Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {
            imageId=it.getInt(animalsAdapter.image)
            tittleId=it.getInt(animalsAdapter.tittle)
            detailsId=it.getInt(animalsAdapter.detailstring)

            Log.e("MainFragment","${getString(tittleId!!)}")
    }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentDetailsBinding.inflate(inflater,container,false)
        val view=binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

            binding.animalImage.setImageResource(imageId!!)
            binding.animalTittle.text = getString(tittleId!!)
            binding.animalDetail.text = getString(detailsId!!)


        binding.readBTN.setOnClickListener {
            val BTNintent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(animalsAdapter.url+"${tittleId?.let { it -> getString(it) }}"))
            context?.startActivity(BTNintent)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}