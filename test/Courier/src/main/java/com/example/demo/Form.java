package com.example.demo;

import java.time.LocalDate;


public class Form {
	    private Integer SenderPostcode;
	    private String SenderAddress;
	    private String SenderNameKanji;
	    private String SenderNameKana;
	    private LocalDate SenderDate;
	    private Integer RecipientPostcode;
	    private String RecipientAddress;
	    private String RecipientNameKanji;
	    private String RecipientNameKana;
	    private LocalDate RecipientDate;
	    private Integer Num;

	    public void setSenderPostcode(Integer senderPostcode) {
	        this.SenderPostcode = senderPostcode;
	    }

	    public Integer getSenderPostcode() {
	        return SenderPostcode;
	    }
	    
	    public void setSenderAddress(String senderAddress) {
	        this.SenderAddress = senderAddress;
	    }

	    public String getSenderAddress() {
	        return SenderAddress;
	    }

	    public void setSenderNameKanji(String senderNameKanji) {
	        this.SenderNameKanji = senderNameKanji;
	    }

	    public String getSenderNameKanji() {
	        return SenderNameKanji;
	    }
	    
	    public void setSenderNameKana(String senderNameKana) {
	        this.SenderNameKana = senderNameKana;
	    }

	    public String getSenderNameKana() {
	        return SenderNameKana;
	    }

	    public void setSenderDate(LocalDate senderDate) {
	        this.SenderDate = senderDate;
	    }

	    public LocalDate getSenderDate() {
	        return SenderDate;
	    }

	    public void setRecipientPostcode(Integer recipientPostcode) {
	        this.RecipientPostcode = recipientPostcode;
	    }

	    public Integer getRecipientPostcode() {
	        return RecipientPostcode;
	    }

	    public void setRecipientAddress(String recipientAddress) {
	        this.RecipientAddress = recipientAddress;
	    }

	    public String getRecipientAddress() {
	        return RecipientAddress;
	    }

	    public void setRecipientNameKanji(String recipientNameKanji) {
	        this.RecipientNameKanji = recipientNameKanji;
	    }

	    public String getRecipientNameKanji() {
	        return RecipientNameKanji;
	    }
	    
	    public void setRecipientNameKana(String recipientNameKana) {
	        this.RecipientNameKana = recipientNameKana;
	    }

	    public String getRecipientNameKana() {
	        return RecipientNameKana;
	    }

	    public void setRecipientDate(LocalDate recipientDate) {
	        this.RecipientDate = recipientDate;
	    }

	    public LocalDate getRecipientDate() {
	        return RecipientDate;
	    }

	    public void setNum(Integer num) {
	        this.Num = num;
	    }

	    public Integer getNum() {
	        return Num;
	    }
}
