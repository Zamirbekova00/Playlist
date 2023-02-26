package com.example.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.playlist.databinding.ItemPlaylistBinding

class PlaylistAdapter(private val playlist:ArrayList<Song>
, val onClick:(tittle:String) -> Unit): Adapter<PlaylistAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()

    }

    override fun getItemCount(): Int = playlist.size

    inner class ViewHolder(private val binding: ItemPlaylistBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(){
            val item = playlist[adapterPosition]

            itemView.setOnClickListener{
                onClick(playlist[adapterPosition].name)
            }

            binding.apply {
                tvNumber.text = item.number
                tvSinger.text = item.singer
                tvSongName.text = item.name
                tvTime.text = item.time
            }

        }

    }

}
