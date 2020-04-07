package com.e.tdm1.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.e.tdm1.R
import com.e.tdm1.data.Book

class BookAdapter (
    private val videoList : List<Book>,
    val context : Context
): RecyclerView.Adapter<BookAdapter.BookoViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookAdapter.BookoViewHolder
            = BookoViewHolder(DataBindingUtil
        .inflate(LayoutInflater
            .from(parent.context),
            R.layout.video_recyclerview,
            parent,
            false
        ))


    override fun getItemCount() = videoList.size

    override fun onBindViewHolder(holder: BookoViewHolder, position: Int) {


        /** until here it works **/
        holder.videoRecyclerviewBinding.video = videoList[position]

        // Parse the video Url to a Uri
        // val url = URL(videoList[position].url)   // Url(videoList[position].url)//Url(videoList[position].url)
        //val videoUri =  Uri.parse(url.toURI().toString())

        val url = videoList[position].url
        val uri = Uri.parse(url)
        val mediaController = MediaController(context)
        holder.videoRecyclerviewBinding.videoView.setMediaController(mediaController)
        mediaController.setAnchorView(holder.videoRecyclerviewBinding.videoView)
        holder.videoRecyclerviewBinding.videoView.setVideoURI(uri)
        //holder.videoRecyclerviewBinding.videoView.start()


        /** but here isn't*/

    }
    inner class BookoViewHolder (
       // val videoRecyclerviewBinding : BRecyclerviewBinding
    )  :
        RecyclerView.ViewHolder(videoRecyclerviewBinding.root) ,
    {}


}