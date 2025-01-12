package com.example.gonggangam.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gonggangam.Class.ChatList
import com.example.gonggangam.databinding.ItemChatListBinding

class TChatListRVAdapter(private val chatLists: ArrayList<ChatList>) :
    RecyclerView.Adapter<TChatListRVAdapter.ViewHolder>(){

    interface OnItemClickListener{
        fun onItemClick(chatList: ChatList)
    }

    private lateinit var onItemClickListener: OnItemClickListener

    fun setOnItemClickListener(itemClickListener: OnItemClickListener){
        onItemClickListener = itemClickListener
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemChatListBinding = ItemChatListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(chatLists[position])

        holder.binding.chatListCl.setOnClickListener {
            onItemClickListener.onItemClick(chatLists[position])
        }
    }

    override fun getItemCount(): Int = chatLists.size

    inner class ViewHolder(val binding: ItemChatListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(chatList: ChatList) {
            binding.chatListOppNameTv.text = chatList.oppName
            binding.chatListDate.text = chatList.date
            binding.chatListContentTv.text = chatList.content
        }

        init {

        }
    }
}