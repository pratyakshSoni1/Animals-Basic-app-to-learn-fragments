package com.smartphone_codes.extinctanimals

import android.app.Activity
import android.content.ActivityNotFoundException
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smartphone_codes.extinctanimals.Adapter.animalsAdapter
import com.smartphone_codes.extinctanimals.Datasource.animalsDatasource
import com.smartphone_codes.extinctanimals.databinding.FragmentMainBinding

class FragmentMain : Fragment() {

    private var _binding:FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerview:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentMainBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val dataSet = animalsDatasource().loadData()
        binding.animalsMenu.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.animalsMenu.adapter = animalsAdapter(context,dataSet)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main,menu)
    }

    fun onSharemenu() {
        val shareIntent = ShareCompat.IntentBuilder.from(context as Activity)
            .setText("smartphone_codes is sharing awesome content visit his profile for more ! \n visit : www.instagram.com/smartphone_codes")
            .setType("text/plain")
            .intent
        try {
            startActivity(shareIntent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(
                context, " Error while sharing !",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_share -> onSharemenu()
        }
        return super.onOptionsItemSelected(item)
    }

}