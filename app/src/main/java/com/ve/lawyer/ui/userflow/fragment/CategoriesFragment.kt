package com.ve.lawyer.ui.userflow.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.ve.lawyer.R
import com.ve.lawyer.prefrences.Prefs
import com.ve.lawyer.ui.adapter.CategoryListAdapter
import com.ve.lawyer.ui.listener.ListItemClickListener
import com.ve.lawyer.ui.userflow.UserHomeActivity
import com.ve.lawyer.utils.AppConstants
import kotlinx.android.synthetic.main.fragment_categories.view.*

class CategoriesFragment: Fragment(), View.OnClickListener, ListItemClickListener {

    private var mCategoryListAdapter: CategoryListAdapter? = null
    private var mView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.fragment_categories, container, false)
        setupToolbar()
        setupCategoryList()
        setupClickListener()
        return mView
    }

    private fun setupToolbar() {
        (activity as UserHomeActivity).setToolbarTitle(activity?.resources?.getString(R.string.categories)!!)
        (activity as UserHomeActivity).setToolbarVisibility(true)
        (activity as UserHomeActivity).setToolbarMenuIconVisibility(false)
        (activity as UserHomeActivity).setToolbarBackIconVisibility(true)
    }

    private fun setupCategoryList()
    {
        val mCategoryList = ArrayList<String>()
        mCategoryList.add("Housing")
        mCategoryList.add("Children & Custody")
        mCategoryList.add("Health")
        mCategoryList.add("Disability")

        mCategoryList.add("Housing1")
        mCategoryList.add("Children & Custody1")
        mCategoryList.add("Health1")
        mCategoryList.add("Disability1")

        mCategoryList.add("Housing2")
        mCategoryList.add("Children & Custody2")
        mCategoryList.add("Health2")
        mCategoryList.add("Disability2")

        mCategoryList.add("Housing3")
        mCategoryList.add("Children & Custody3")
        mCategoryList.add("Health3")
        mCategoryList.add("Disability3")

        mCategoryListAdapter = CategoryListAdapter(activity!!, mCategoryList, AppConstants.CATEGORY_LIST_VIEW_INITIAL, this)
        val mLayoutManager = GridLayoutManager(activity, 2)
        mView?.rv_category?.layoutManager = mLayoutManager
        mView?.rv_category?.adapter = mCategoryListAdapter
        mView?.rv_category?.hasFixedSize()
    }

    private fun setupClickListener() {
        mView?.btn_seeAll?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_seeAll ->
            {
                mCategoryListAdapter?.updateCategoryListViewCount(AppConstants.CATEGORY_LIST_VIEW_ALL)
                mView?.btn_seeAll?.visibility = View.GONE
            }
        }
    }

    override fun onViewClicked(view: View, position: Int) {
        Prefs.putString(AppConstants.USER_POST_PAGE_SHOWING_FROM, AppConstants.USER_POST_PAGE_SHOWING_FROM_CATEGORY)
        (activity as UserHomeActivity).setDisplayFragment(12)
    }
}