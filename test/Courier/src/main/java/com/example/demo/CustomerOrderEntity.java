package com.example.demo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CustomerOrderEntity {
    private Integer senderPost;
    private String senderAddress;
    private String senderNameKanji; // Add this field for sender's name in Kanji
    private String senderNameKana; // Add this field for sender's name in Kana
    private LocalDate senderDate; // Add this field for sender's date
    private Integer recipientPost; // Corrected variable name to lowercase initial letter
    private String recipientAddress; // Corrected variable name to lowercase initial letter
    private String recipientNameKanji; // Corrected variable name to lowercase initial letter
    private String recipientNameKana; // Corrected variable name to lowercase initial letter
    private LocalDate recipientDate; // Corrected variable name to lowercase initial letter
    private Integer num;

    // コンストラクタ、ゲッター、セッターを定義する
//    public CustomerOrderEntity() {
//    }    

//    public CustomerOrderEntity(Integer senderPost, String senderAddress, String senderNameKanji, String senderNameKana, LocalDate senderDate,
//    		Integer recipientPost, String recipientAddress, String recipientNameKanji, String recipientNameKana, LocalDate recipientDate,Integer num) {
//        this.senderPost = senderPost;
//        this.senderAddress = senderAddress;
//        this.senderNameKanji = senderNameKanji;
//        this.senderNameKana = senderNameKana;
//        this.senderDate = senderDate;
//        this.recipientPost = recipientPost;
//        this.recipientAddress = recipientAddress;
//        this.recipientNameKanji = recipientNameKanji;
//        this.recipientNameKana = recipientNameKana;
//        this.recipientDate = recipientDate;
//        this.num = num;
//    }
//
//    public Integer getSenderPost() {
//        return senderPost;
//    }
//
//    public void setSenderPost(Integer senderPost) {
//        this.senderPost = senderPost;
//    }
//
//    public String getSenderAddress() {
//        return senderAddress;
//    }
//
//    public void setSenderAddress(String senderAddress) {
//        this.senderAddress = senderAddress;
//    }
//
//    public String getSenderNameKanji() {
//        return senderNameKanji;
//    }
//
//    public void setSenderNameKanji(String senderNameKanji) {
//        this.senderNameKanji = senderNameKanji;
//    }
//
//    public String getSenderNameKana() {
//        return senderNameKana;
//    }
//
//    public void setSenderNameKana(String senderNameKana) {
//        this.senderNameKana = senderNameKana;
//    }
//
//    public LocalDate getSenderDate() {
//        return senderDate;
//    }
//
//    public void setSenderDate(LocalDate senderDate) {
//        this.senderDate = senderDate;
//    }
//
//    public Integer getRecipientPost() {
//        return recipientPost;
//    }
//
//    public void setRecipientPost(Integer recipientPost) {
//        this.recipientPost = recipientPost;
//    }
//
//    public String getRecipientAddress() {
//        return recipientAddress;
//    }
//
//    public void setRecipientAddress(String recipientAddress) {
//        this.recipientAddress = recipientAddress;
//    }
//
//    public String getRecipientNameKanji() {
//        return recipientNameKanji;
//    }
//
//    public void setRecipientNameKanji(String recipientNameKanji) {
//        this.recipientNameKanji = recipientNameKanji;
//    }
//
//    public String getRecipientNameKana() {
//        return recipientNameKana;
//    }
//
//    public void setRecipientNameKana(String recipientNameKana) {
//        this.recipientNameKana = recipientNameKana;
//    }
//
//    public LocalDate getRecipientDate() {
//        return recipientDate;
//    }
//
//    public void setRecipientDate(LocalDate recipientDate) {
//        this.recipientDate = recipientDate;
//    }
//    
//    public Integer getnum() {
//        return num;
//    }
//
//    public void setnum(Integer num) {
//        this.num = num;
//    }
}
