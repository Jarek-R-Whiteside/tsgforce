package org.mypathus.tsgforce.model;

public class ReportIdentificationHelper {

	private int id;
	private String type;
	private String header;
	private String name;
	private int headerRow;
	private int dataRow;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getHeaderRow() {
		return headerRow;
	}
	public void setHeaderRow(int row) {
		this.headerRow = row;
	}
	public int getDataRow() {
		return dataRow;
	}
	public void setDataRow(int dataRow) {
		this.dataRow = dataRow;
	}
	
	
}
