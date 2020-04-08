package com.example.tmd1


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    lateinit var textView: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val index=arguments!!.getInt("amount")
        val item=arguments!!.getString("item")

        // binding the data from the string resources
        title.text =resources.getStringArray(R.array.planets_array2)[index]
        auteur.text=resources.getStringArray(R.array.planets_array3)[index]
        description.text=resources.getStringArray(R.array.planets_array1)[index]
        var images = resources.obtainTypedArray(R.array.images)
        var i= resources.getIntArray(R.array.images)[index]
        image.setImageResource(images.getResourceId(index,-1))

    }
}
