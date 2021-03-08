package com.ve.lawyer.ui.chat

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ve.lawyer.R
import com.ve.lawyer.ui.common.base.BaseActivity
import com.ve.lawyer.ui.listener.ListItemClickListener
import com.ve.lawyer.utils.SlideAnimationUtil
import kotlinx.android.synthetic.main.activity_chat_list.*

class ChatListActivity: BaseActivity(), View.OnClickListener, ListItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_list)
        setupToolbar()
        setupChatUserList()
        setupClickListener()
    }

    private fun setupToolbar()
    {
        tv_toolbarTitle.text = resources.getString(R.string.chat)
        iv_toolbarVoiceCall.visibility = View.GONE
        iv_toolbarVideoCall.visibility = View.GONE
    }

    private fun setupChatUserList()
    {
        val chatUserList = ArrayList<String>()
        val mChatUserListAdapter = ChatListAdapter(this@ChatListActivity, chatUserList, this)
        val mLayoutManager = LinearLayoutManager(this@ChatListActivity)
        rv_chatUser?.layoutManager = mLayoutManager
        rv_chatUser?.adapter = mChatUserListAdapter
        rv_chatUser?.hasFixedSize()
    }
    private fun setupClickListener() {
        iv_toolbarBack.setOnClickListener(this)
        iv_toolbarVoiceCall.setOnClickListener(this)
        iv_toolbarVideoCall.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_toolbarBack ->
            {
                finish()
                SlideAnimationUtil.slideBackAnimation(this@ChatListActivity)
            }
            R.id.iv_toolbarVoiceCall ->
            {

            }
            R.id.iv_toolbarVideoCall ->
            {

            }
        }
    }

    override fun onViewClicked(view: View, position: Int) {
        val intent = Intent(this@ChatListActivity, ChatActivity::class.java)
        startActivity(intent)
        SlideAnimationUtil.slideNextAnimation(this@ChatListActivity)
    }
}