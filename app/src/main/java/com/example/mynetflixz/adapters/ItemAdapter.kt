package com.example.mynetflixz.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mynetflixz.data.Movie
import com.example.mynetflixz.databinding.OneItemBinding

class ItemAdapter(private val itemOnClicked : (Movie) -> Unit): ListAdapter<Movie,ItemAdapter.ItemViewHolder>(DIFF_CALLBACK) {

    inner class ItemViewHolder(private val binding : OneItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Movie) = with(binding){
                  imageItemElement.setImageResource(movie.image)
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(OneItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
       val movie = currentList[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener{
            itemOnClicked(movie)
        }
    }



    class DiffUtils : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

    }
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }

}