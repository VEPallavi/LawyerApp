package com.ve.lawyer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ve.lawyer.R
import com.ve.lawyer.model.ChatModel


class ChatAdapter(
        val context: Context,
        val list: ArrayList<ChatModel>
) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val IS_OTHERS = 1
    private val IS_MINE = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        return if (viewType === IS_OTHERS) {
            view = LayoutInflater.from(context).inflate(R.layout.item_chat_others, parent, false)
            OtherChatViewHolder(view)
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.item_chat_mine, parent, false)
            MineChatViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) === IS_OTHERS) {
            (holder as OtherChatViewHolder).bind(list.get(position), context)
        } else {
            (holder as MineChatViewHolder).bind(list.get(position), context)
        }


    }

    override fun getItemViewType(position: Int): Int {
        if (list.get(position).fromId!!.equals("1")) {
            return IS_MINE
        } else {
            return IS_OTHERS
        }


    }


    inner class OtherChatViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
        private val txt: TextView
        private val txt_chat_time: TextView

        init {
            txt = itemView.findViewById(R.id.txt)
            txt_chat_time = itemView.findViewById(R.id.txt_chat_time)
        }

        fun bind(chat: ChatModel, context: Context) {
            txt?.text = chat.message
            txt_chat_time.setText(chat.name + ", " + chat.time!!)
        }
    }


    inner class MineChatViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
        private val txt: TextView
        private val chat_time: TextView


        init {
            txt = itemView.findViewById(R.id.txt)
            chat_time = itemView.findViewById(R.id.chat_time)
        }

        fun bind(chat: ChatModel, context: Context) {
            txt.setText(chat.message!!)
            chat_time.setText(chat.time)
        }
    }


}







