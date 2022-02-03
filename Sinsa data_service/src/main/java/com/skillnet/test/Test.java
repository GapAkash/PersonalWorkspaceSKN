package com.skillnet.test;

import java.io.IOException;

import com.skillnet.dataservice.transaction.RevertTransactionProcessor;

public class Test {

	public static void main(String[] args) throws IOException {
		
		
		//DBConn.createConnection("1014","REG_1");
		
		RevertTransactionProcessor test = new RevertTransactionProcessor();
		
		System.out.println(test.getRevertTransactionInfo("revert_transaction").toString());
	}

}
