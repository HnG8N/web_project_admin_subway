package com.javalec.dto;

public class ProductInsert_Dto {
	
	// Field
	int mncode;
	String mnctg;
	String mnname;
	String mnengname;
	String mninfo;
	int mnprice;
	String mnimg;

	// Constructor
	
	public ProductInsert_Dto() {
		
	}
	
	public ProductInsert_Dto(int mncode, String mnctg, String mnname, String mnengname, String mninfo, int mnprice,
			String mnimg) {
		super();
		this.mncode = mncode;
		this.mnctg = mnctg;
		this.mnname = mnname;
		this.mnengname = mnengname;
		this.mninfo = mninfo;
		this.mnprice = mnprice;
		this.mnimg = mnimg;
	}

	// Method
	public int getMncode() {
		return mncode;
	}

	public void setMncode(int mncode) {
		this.mncode = mncode;
	}

	public String getMnctg() {
		return mnctg;
	}

	public void setMnctg(String mnctg) {
		this.mnctg = mnctg;
	}

	public String getMnname() {
		return mnname;
	}

	public void setMnname(String mnname) {
		this.mnname = mnname;
	}

	public String getMnengname() {
		return mnengname;
	}

	public void setMnengname(String mnengname) {
		this.mnengname = mnengname;
	}

	public String getMninfo() {
		return mninfo;
	}

	public void setMninfo(String mninfo) {
		this.mninfo = mninfo;
	}

	public int getMnprice() {
		return mnprice;
	}

	public void setMnprice(int mnprice) {
		this.mnprice = mnprice;
	}

	public String getMnimg() {
		return mnimg;
	}

	public void setMnimg(String mnimg) {
		this.mnimg = mnimg;
	}
	
}
