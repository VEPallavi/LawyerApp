package com.ve.lawyer.ui.userflow.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import com.ve.lawyer.R
import com.ve.lawyer.prefrences.Prefs
import com.ve.lawyer.ui.adapter.CategorySpinnerListAdapter
import com.ve.lawyer.ui.userflow.UserHomeActivity
import com.ve.lawyer.utils.AppConstants
import kotlinx.android.synthetic.main.fragment_post_question.view.*

class PostQuestionFragment: Fragment(), View.OnClickListener {

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
        mView = inflater.inflate(R.layout.fragment_post_question, container, false)
        setupToolbar()
        setupCategoryList()
        setupQuestionTypeList()
        setupClickListener()
        return mView
    }

    private fun setupToolbar() {
        (activity as UserHomeActivity).setToolbarTitle(activity?.resources?.getString(R.string.post_question)!!)
        (activity as UserHomeActivity).setToolbarVisibility(true)
        (activity as UserHomeActivity).setToolbarMenuIconVisibility(true)
        (activity as UserHomeActivity).setToolbarBackIconVisibility(false)
        (activity as UserHomeActivity).setBottomNavigationBarVisibility(false)
    }

    private fun setupCategoryList()
    {
        val categoryList = ArrayList<String>()
        categoryList.add("Categories")
        categoryList.add("Housing")
        categoryList.add("Finance")
        categoryList.add("Insurance")
        categoryList.add("Crime")
        categoryList.add("Test")
        val mGenderSelectionAdapter = CategorySpinnerListAdapter(activity!!, categoryList)
        mView?.spinnerCategory?.adapter = mGenderSelectionAdapter

        mView?.spinnerCategory?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
            ) {
                val selectedCategory = parent!!.adapter.getItem(position) as String
            }
        }
    }

    private fun setupQuestionTypeList()
    {
        val questionTypeList = ArrayList<String>()
        questionTypeList.add("Type")
        questionTypeList.add("Public")
        questionTypeList.add("Private")
        val mGenderSelectionAdapter = CategorySpinnerListAdapter(activity!!, questionTypeList)
        mView?.spinnerQusType?.adapter = mGenderSelectionAdapter

        mView?.spinnerQusType?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
            ) {
                val selectedType = parent!!.adapter.getItem(position) as String
            }
        }
    }

    private fun setupClickListener() {
        mView?.cardViewCategory?.setOnClickListener(this)
        mView?.iv_categoryImage?.setOnClickListener(this)
        mView?.cardViewQusType?.setOnClickListener(this)
        mView?.iv_qusTypeImage?.setOnClickListener(this)
        mView?.btn_post?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.cardViewCategory ->
            {
                mView?.spinnerCategory?.performClick()
            }
            R.id.iv_categoryImage ->
            {
                mView?.spinnerCategory?.performClick()
            }
            R.id.cardViewQusType ->
            {
                mView?.spinnerQusType?.performClick()
            }
            R.id.iv_qusTypeImage ->
            {
                mView?.spinnerQusType?.performClick()
            }
            R.id.btn_post ->
            {
                Prefs.putString(AppConstants.USER_POST_PAGE_SHOWING_FROM, AppConstants.USER_POST_PAGE_SHOWING_FROM_POST)
                (activity as UserHomeActivity).setDisplayFragment(12)
            }
        }
    }
}