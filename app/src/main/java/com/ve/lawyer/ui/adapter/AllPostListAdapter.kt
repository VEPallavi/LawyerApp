package com.ve.lawyer.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ve.lawyer.R
import com.ve.lawyer.prefrences.Prefs
import com.ve.lawyer.ui.listener.ListItemClickListener
import com.ve.lawyer.utils.AppConstants

class AllPostListAdapter(context: Context, allPostList: ArrayList<String>, listener: ListItemClickListener) : RecyclerView.Adapter<AllPostListAdapter.MyViewHolder>() {

    private var mContext: Context? = null
    private var mAllPostList: ArrayList<String>? = null
    private var mItemClickListener: ListItemClickListener? = null

    init {
        this.mContext = context
        this.mAllPostList = allPostList
        this.mItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_all_post_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5//mAllCourseList?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        when (Prefs.getString(AppConstants.USER_POST_PAGE_SHOWING_FROM)) {
            AppConstants.USER_POST_PAGE_SHOWING_FROM_CATEGORY ->
            {
                holder.mCorrectIcon?.visibility = View.GONE
                holder.mFavoriteIcon?.visibility = View.VISIBLE
            }
            AppConstants.USER_POST_PAGE_SHOWING_FROM_POST ->
            {
                holder.mCorrectIcon?.visibility = View.VISIBLE
                holder.mFavoriteIcon?.visibility = View.GONE
            }
        }
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

        var mCorrectIcon: ImageView? = null
        var mFavoriteIcon: ImageView? = null

        init {
            mCorrectIcon = itemView.findViewById(R.id.iv_correct)
            mFavoriteIcon = itemView.findViewById(R.id.iv_favorite)
        }
    }
}