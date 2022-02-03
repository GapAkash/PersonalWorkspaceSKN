package com.skillnet.util.excel.bean;

import org.apache.poi.ss.usermodel.Row;

public class RevertTransaction {

	private String store;
	private String businessDate;
	private String transNum;
	private String register;
	private String value;

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getBusinessDate() {
		return businessDate;
	}

	public void setBusinessDate(String businessDate) {
		this.businessDate = businessDate;
	}

	public String getTransNum() {
		return transNum;
	}

	public void setTransNum(String transNum) {
		this.transNum = transNum;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public RevertTransaction() {
	}

	public RevertTransaction(Row row) {

		this.store = row.getCell(0).toString();
		this.businessDate = row.getCell(1).toString();
		this.transNum = row.getCell(2).toString();
		this.register = row.getCell(3).toString();
		this.value = row.getCell(4).toString();

	}
	
	@Override
	public String toString() {
		return "RevertTransaction [store=" + store + ", businessDate=" + businessDate + ", transNum=" + transNum
				+ ", register=" + register + ", value=" + value + "]";
	}

}
