package com.ve.lawyer.ui.chat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ve.lawyer.R
import com.ve.lawyer.ui.listener.ListItemClickListener

class ChatListAdapter (context: Context, chatUserList: ArrayList<String>, listener: ListItemClickListener): RecyclerView.Adapter<ChatListAdapter.MyViewHolder>() {

    private var mContext: Context? = null
    private var mChatUserList: ArrayList<String>? = null
    private var itemClickListener: ListItemClickListener? = null
    init {
        this.mContext = context
        this.mChatUserList = chatUserList
        this.itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_chat_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                itemClickListener?.onViewClicked(v!!, position)
            }
        })
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        var mCategoryTitle: TextView? = null
//
//        init {
//            mCategoryTitle = itemView.findViewById(R.id.tv_titleCategory)
//        }
    }
}