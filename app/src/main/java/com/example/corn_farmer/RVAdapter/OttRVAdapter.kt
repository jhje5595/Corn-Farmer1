package com.example.corn_farmer.RVAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.corn_farmer.Item.Ott
import com.example.corn_farmer.databinding.ItemOttsBinding

class OttRVAdapter(private val ottList : ArrayList<Ott>) : RecyclerView.Adapter<OttRVAdapter.Viewholder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val binding : ItemOttsBinding = ItemOttsBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bind(ottList[position])
    }

    override fun getItemCount(): Int {
        return ottList.size
    }


    inner class Viewholder(val binding : ItemOttsBinding ) : RecyclerView.ViewHolder(binding.root){

        fun bind(ott : Ott){
            binding.itemOttImgIv.setImageResource(ott.Img!!)
            binding.itemOttTitle.text = ott.title
            binding.itemOttGenre.text = ott.genre
            if(!ott.like){
                binding.itemOttLikeImgIv.visibility = View.VISIBLE
                binding.itemOttLikeFillImgIv.visibility = View.INVISIBLE
            }
            else{
                binding.itemOttLikeImgIv.visibility = View.INVISIBLE
                binding.itemOttLikeFillImgIv.visibility = View.VISIBLE
            }
            binding.itemOttLikeCountTv.text = ott.likecount.toString()
        }
    }
}