package com.example.tmd1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var array = arrayOf("Le monde s’effondre", "Contes ", "L’Étranger ", "Les poèmes")
        val context = context as MainActivity


        val lv = context.findViewById(R.id.liste) as ListView
        val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, array)
        lv.adapter = adapter
        liste.onItemClickListener = object : AdapterView.OnItemClickListener {

            override fun onItemClick(parent: AdapterView<*>, view: View,
                                     position: Int, id: Long) {

                // value of item that is clicked
                val itemValue = liste.getItemAtPosition(position) as String
                var bundle = bundleOf("item" to itemValue,"amount" to position)

                view.findNavController().navigate(R.id.action_mainFragment2_to_secondFragment, bundle)



            }
        }

    }

    }
