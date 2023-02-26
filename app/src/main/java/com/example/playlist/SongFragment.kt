package com.example.playlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.playlist.databinding.FragmentSongBinding

class SongFragment : Fragment() {
    private lateinit var binding:FragmentSongBinding
    private lateinit var playlist:ArrayList<Song>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        val adapter = PlaylistAdapter(playlist, this::onClick)
        binding.recyclerView.adapter = adapter
    }

    private fun loadData (){
        playlist = ArrayList<Song>()

        playlist.apply {
            playlist.add(Song("1", "I Ain't Worried", "OneRepublic", "2:28"))
            playlist.add(Song("2", "Calm Down", "Rema", "3:40"))
            playlist.add(Song("3", "Save Me", "Kadebostany", "3:48"))
            playlist.add(Song("4", "Enemy", "Imagine Dragons", "2:53"))
            playlist.add(Song("5", "Bones", "Imagine Dragons", "2:45"))
            playlist.add(Song("6", "Rampampam", "Minelly", "3:19"))
            playlist.add(Song("7", "When We Were Young", "Adele", "4:50"))
            playlist.add(Song("8", "Her Mevsim Yazim", "Zeynep Bastik", "3:14"))
            playlist.add(Song("9", "Snowman", "Sia", "2:45"))
            playlist.add(Song("10", "Often", "The Weekend", "1:59"))

        }
    }
    private fun onClick(tittle:String){
        val bundle = Bundle()
        bundle.putString("Kal", tittle)
        val songInfoFragment = SongInfoFragment()
        songInfoFragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction().
        replace(R.id.container, songInfoFragment).addToBackStack(null).commit()
    }
}