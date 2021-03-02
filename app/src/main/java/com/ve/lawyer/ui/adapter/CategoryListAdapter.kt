package com.ve.lawyer.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ve.lawyer.R
import com.ve.lawyer.ui.listener.ListItemClickListener
import com.ve.lawyer.utils.AppConstants

class CategoryListAdapter (context: Context, categoryList: ArrayList<String>, viewCount: String, listener: ListItemClickListener): RecyclerView.Adapter<CategoryListAdapter.MyViewHolder>() {

    private var mContext: Context? = null
    private var mCategoryList: ArrayList<String>? = null
    private var LIST_VIEW_COUNT: String = ""
    private var itemClickListener: ListItemClickListener? = null
    init {
        this.mContext = context
        this.mCategoryList = categoryList
        this.LIST_VIEW_COUNT = viewCount
        this.itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_category_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        when(LIST_VIEW_COUNT)
        {
            AppConstants.CATEGORY_LIST_VIEW_INITIAL ->
            {
                return 4
            }
            AppConstants.CATEGORY_LIST_VIEW_ALL ->
            {
                return mCategoryList?.size!!
            }
        }
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val categoryData = mCategoryList?.get(position)

        holder.mCategoryTitle?.text = categoryData

        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                itemClickListener?.onViewClicked(v!!, position)
            }
        })
    }

    fun updateCategoryListViewCount(viewType: String) {
        when(viewType)
        {
            AppConstants.CATEGORY_LIST_VIEW_INITIAL ->
            {
                LIST_VIEW_COUNT = viewType
            }
            AppConstants.CATEGORY_LIST_VIEW_ALL ->
            {
                LIST_VIEW_COUNT = viewType
            }
        }
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var mCategoryTitle: TextView? = null

        init {
            mCategoryTitle = itemView.findViewById(R.id.tv_titleCategory)
        }
    }
}