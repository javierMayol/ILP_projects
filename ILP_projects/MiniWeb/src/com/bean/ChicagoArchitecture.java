package com.bean;

import java.io.Serializable;

public class ChicagoArchitecture  implements Serializable  {
	
	private static final long serialVersionUID = 1420914735271944204L;
	
	private int buildingId;
	private String buildingName;
	private String architects;
	private String address;
	private int yearBuilt;
	public int getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getArchitects() {
		return architects;
	}
	public void setArchitects(String architects) {
		this.architects = architects;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getYearBuilt() {
		return yearBuilt;
	}
	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}
	@Override
	public String toString() {
		return buildingId+" "+buildingName + ", architects="
				+ architects + ", address=" + address + ", year=" + yearBuilt + ".";
	}
	
	

}
