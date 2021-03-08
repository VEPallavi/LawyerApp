package com.ve.lawyer.ui.chat

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ve.lawyer.R
import com.ve.lawyer.ui.chat.model.ChatModel
import com.ve.lawyer.ui.common.base.BaseActivity
import com.ve.lawyer.ui.listener.ListItemClickListener
import com.ve.lawyer.utils.SlideAnimationUtil
import com.ve.lawyer.utils.ToastMsgUtils
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity: BaseActivity(), View.OnClickListener, ListItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        setupToolbar()
        setupChatUserList()
        setupClickListener()
    }

    private fun setupToolbar()
    {
        tv_toolbarTitle.text = "User Name"
        iv_toolbarVoiceCall.visibility = View.VISIBLE
        iv_toolbarVideoCall.visibility = View.VISIBLE
    }

    private fun setupChatUserList()
    {
        val chatUserList = ArrayList<ChatModel>()
        val chatModel = ChatModel()
        chatModel.senderName = "Sender name"
        chatModel.senderProfileImage = resources.getDrawable(R.mipmap.image_one)
        chatModel.message = "Test message send to someone"
        chatModel.messageType = 0
        chatModel.messageDateTime = "04:00 PM"
        chatUserList.add(chatModel)

        val chatModel1 = ChatModel()
        chatModel1.senderName = "User name"
        chatModel1.senderProfileImage = resources.getDrawable(R.mipmap.image_one)
        chatModel1.message = "Test message send to someone for testing purpose"
        chatModel1.messageType = 1
        chatModel1.messageDateTime = "05:00 PM"
        chatUserList.add(chatModel1)

        val chatModel2 = ChatModel()
        chatModel2.senderName = "User name"
        chatModel2.senderProfileImage = resources.getDrawable(R.mipmap.image_one)
        chatModel2.message = "Hello how are you?"
        chatModel2.messageType = 1
        chatModel2.messageDateTime = "05:10 PM"
        chatUserList.add(chatModel2)

        val chatModel3 = ChatModel()
        chatModel3.senderName = "User name"
        chatModel3.senderProfileImage = resources.getDrawable(R.mipmap.image_one)
        chatModel3.message = "I am fine what about you"
        chatModel3.messageType = 0
        chatModel3.messageDateTime = "05:10 PM"
        chatUserList.add(chatModel3)

        val mChatUserListAdapter = ChatAdapter(this@ChatActivity, chatUserList, this)
        val mLayoutManager = LinearLayoutManager(this@ChatActivity)
        rv_chatUser?.layoutManager = mLayoutManager
        rv_chatUser?.adapter = mChatUserListAdapter
        rv_chatUser?.hasFixedSize()
        rv_chatUser?.isNestedScrollingEnabled = false
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
                SlideAnimationUtil.slideBackAnimation(this@ChatActivity)
            }
            R.id.iv_toolbarVoiceCall ->
            {
                ToastMsgUtils.showSuccessMsg(lyt_parent, "Voice call not setup")
            }
            R.id.iv_toolbarVideoCall ->
            {
                ToastMsgUtils.showSuccessMsg(lyt_parent, "Video call not setup")
            }
        }
    }

    override fun onViewClicked(view: View, position: Int) {

    }
}