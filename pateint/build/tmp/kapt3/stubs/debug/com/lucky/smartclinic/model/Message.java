package com.lucky.smartclinic.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0012\u0010\u000e\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/lucky/smartclinic/model/Message;", "", "date", "Ljava/util/Date;", "getDate", "()Ljava/util/Date;", "recipientId", "", "getRecipientId", "()Ljava/lang/String;", "senderId", "getSenderId", "senderName", "getSenderName", "type", "getType", "pateint_debug"})
public abstract interface Message {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.Date getDate();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getSenderId();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getRecipientId();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getSenderName();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getType();
}