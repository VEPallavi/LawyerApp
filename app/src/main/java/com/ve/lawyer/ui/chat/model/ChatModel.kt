package com.ve.lawyer.ui.chat.model

import android.graphics.drawable.Drawable

class ChatModel(
        var senderName: String = "",
        var senderProfileImage: Drawable? = null,
        var message: String = "",
        var messageType: Int = 0,
        var messageDateTime: String = ""
)