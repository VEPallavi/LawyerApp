package com.ve.lawyer.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ve.lawyer.R
import com.ve.lawyer.ui.listener.ListItemClickListener

class ContactListAdapter (context: Context, contactList: ArrayList<String>, listener: ListItemClickListener): RecyclerView.Adapter<ContactListAdapter.MyViewHolder>() {

    private var mContext: Context? = null
    private var mContactList: ArrayList<String>? = null
    private var mItemClickListener: ListItemClickListener?= null
    init {
        this.mContext = context
        this.mContactList = contactList
        this.mItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_contact_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10//mAllCourseList?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val courseData = mAllCourseList?.get(position)
//
//        holder.mView?.setBackgroundColor(courseData?.itemColor!!)
//        holder.mCourseTitle?.text = courseData?.courseTitle
//
        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                mItemClickListener?.onViewClicked(v!!, position)
            }
        })
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        var mView: ConstraintLayout? = null
//        var mCourseTitle: TextView? = null
//
//        init {
//            mView = itemView.findViewById(R.id.lyt_view)
//            mCourseTitle = itemView.findViewById(R.id.tv_courseTitle)
//        }
    }
}