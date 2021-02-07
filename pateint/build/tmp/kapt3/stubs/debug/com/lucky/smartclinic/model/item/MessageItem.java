package com.lucky.smartclinic.model.item;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/lucky/smartclinic/model/item/MessageItem;", "Lcom/xwray/groupie/kotlinandroidextensions/Item;", "message", "Lcom/lucky/smartclinic/model/Message;", "(Lcom/lucky/smartclinic/model/Message;)V", "getMessage", "()Lcom/lucky/smartclinic/model/Message;", "bind", "", "viewHolder", "Lcom/xwray/groupie/kotlinandroidextensions/GroupieViewHolder;", "position", "", "setMessageRootGravity", "setTimeText", "pateint_debug"})
public abstract class MessageItem extends com.xwray.groupie.kotlinandroidextensions.Item {
    @org.jetbrains.annotations.NotNull()
    private final com.lucky.smartclinic.model.Message message = null;
    
    @java.lang.Override()
    public void bind(@org.jetbrains.annotations.NotNull()
    com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder viewHolder, int position) {
    }
    
    private final void setTimeText(com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder viewHolder) {
    }
    
    private final void setMessageRootGravity(com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder viewHolder) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.lucky.smartclinic.model.Message getMessage() {
        return null;
    }
    
    public MessageItem(@org.jetbrains.annotations.NotNull()
    com.lucky.smartclinic.model.Message message) {
        super();
    }
}