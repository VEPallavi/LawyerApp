package com.ve.lawyer.ui.chat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ve.lawyer.R
import com.ve.lawyer.ui.chat.model.ChatModel
import com.ve.lawyer.ui.listener.ListItemClickListener


class ChatAdapter (context: Context, chatUserList: ArrayList<ChatModel>, listener: ListItemClickListener): RecyclerView.Adapter<ChatAdapter.MyViewHolder>() {

    private var mContext: Context? = null
    private var mChatList: ArrayList<ChatModel>? = null
    private var itemClickListener: ListItemClickListener? = null
    private val MSG_TYPE_LEFT = 0
    private val MSG_TYPE_RIGHT = 1

    init {
        this.mContext = context
        this.mChatList = chatUserList
        this.itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return if (viewType === MSG_TYPE_RIGHT) {
            val view: View = LayoutInflater.from(mContext).inflate(R.layout.chat_item_right, parent, false)
            MyViewHolder(view)
        } else {
            val view: View = LayoutInflater.from(mContext).inflate(R.layout.chat_item_left, parent, false)
            MyViewHolder(view)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = mChatList?.get(position)
        return if (item?.messageType == 0) {
            MSG_TYPE_RIGHT
        } else {
            MSG_TYPE_LEFT
        }
    }

    override fun getItemCount(): Int {
        return mChatList?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val chatItem = mChatList?.get(position)
        holder.mReceiverMsg?.text = chatItem?.message
//        if (chatItem?.messageType == 0)
//        {
//            holder.mReceiverMsg?.text = chatItem.message
//        }
//        else
//        {
//            holder.mSenderMsg?.text = chatItem?.message
//        }

        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                itemClickListener?.onViewClicked(v!!, position)
            }
        })
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var mReceiverMsg: TextView? = null
        //var mSenderMsg: TextView? = null

        init {
            mReceiverMsg = itemView.findViewById(R.id.tv_receiverMsg)
            //mSenderMsg = itemView.findViewById(R.id.tv_senderMsg)
        }
    }
}