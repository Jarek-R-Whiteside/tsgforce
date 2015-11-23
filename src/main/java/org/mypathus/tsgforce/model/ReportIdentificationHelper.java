package org.mypathus.tsgforce.model;

public class ReportIdentificationHelper {

	private String type;
	private String header;
	private String name;
	private int row;
	
	public ReportIdentificationHelper(String type, String header, String name, int row) {
		this.type = type;
		this.header = header;
		this.name = name;
		this.row = row;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	
}
