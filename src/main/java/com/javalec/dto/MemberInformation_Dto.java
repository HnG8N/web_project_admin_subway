package com.javalec.dto;

public class MemberInformation_Dto {
	
	// Field
	String mid; 
	String mpw; 
	String mname; 
	String maddress; 
	String mtel; 
	String mbirth; 
	String memail; 
	String mregdate; 
	String menddate;
	
	// Constructor
	public MemberInformation_Dto() {
	}
	
	public MemberInformation_Dto(String mid, String mpw, String mname, String maddress, String mtel, String mbirth,
			String memail, String mregdate, String menddate) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.maddress = maddress;
		this.mtel = mtel;
		this.mbirth = mbirth;
		this.memail = memail;
		this.mregdate = mregdate;
		this.menddate = menddate;
	}
	
	// Method
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMaddress() {
		return maddress;
	}
	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}
	public String getMtel() {
		return mtel;
	}
	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	public String getMbirth() {
		return mbirth;
	}
	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMregdate() {
		return mregdate;
	}
	public void setMregdate(String mregdate) {
		this.mregdate = mregdate;
	}
	public String getMenddate() {
		return menddate;
	}
	public void setMenddate(String menddate) {
		this.menddate = menddate;
	}
	
	

}
