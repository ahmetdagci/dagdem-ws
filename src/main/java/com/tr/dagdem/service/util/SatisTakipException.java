package com.tr.dagdem.service.util;

@SuppressWarnings("serial")
public class SatisTakipException extends RuntimeException{
	
	private String hataMesaji;
	public SatisTakipException(String hataMesaji)
	{
		this.hataMesaji = hataMesaji;
		
	}
	
	public String getHataMesaji() {
		return hataMesaji;
	}

}
