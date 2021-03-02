package com.ve.lawyer.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.ve.lawyer.R

class CategorySpinnerListAdapter (internal var context: Context, internal var genderTypeList: ArrayList<String>?) :
        ArrayAdapter<String>(context, 0, genderTypeList!!) {



    override fun getCount(): Int {
        return  genderTypeList?.size!!
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItem(position: Int): String? {
        return genderTypeList?.get(position)
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var itemView = convertView
        if (itemView == null)
        {
            itemView = LayoutInflater.from(context).inflate(R.layout.text_layout,parent, false)
        }

        val label = itemView?.findViewById(R.id.text) as TextView
        if (position == 0)
        {
            label.setTextColor(context.resources.getColor(R.color.colorLabel))
        }
        else
        {
            label.setTextColor(context.resources.getColor(R.color.colorBlack))
        }
        label.text = genderTypeList?.get(position)

        return itemView
    }

    override fun getDropDownView(position: Int, convertView: View?,
                                 parent: ViewGroup): View {
        var dropDownItemView = convertView
        if (dropDownItemView == null)
        {
            dropDownItemView = LayoutInflater.from(context).inflate(R.layout.item_dropdown_view, parent, false)
        }
        val label = dropDownItemView?.findViewById(R.id.tv_text) as TextView
        label.text = genderTypeList?.get(position)

        return label
    }
}