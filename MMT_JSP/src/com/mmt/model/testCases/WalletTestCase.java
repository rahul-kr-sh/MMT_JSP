package com.mmt.model.testCases;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.mmt.model.bean.Wallet;
import com.mmt.model.dao.WalletDaoImplMMT;
public class WalletTestCase {
Wallet wl;
Wallet wl1,wl2;
WalletDaoImplMMT wdi;


	@Before
	public void setUp() throws Exception {
		wl=new Wallet("1",100);
		wdi=new WalletDaoImplMMT();
		wdi.insertWallet(wl);
		
		
	}

	@After
	public void tearDown() throws Exception {
		wdi.deleteWallet(wl);
		wl=null;
		wdi=null;
		wl1=null;
	}

	@Test
	public void testdisplayWallet() throws SQLException, ClassNotFoundException, IOException {
		wl1=wdi.displayWallet("1");
		assertEquals("1",wl.getUserId());
	}
	
	@Test
	public void testupdateWallet() throws SQLException, ClassNotFoundException, IOException {
		assertEquals(1, wdi.updateWallet("1",wl));
	}
	@Test
	public void testdisplayWalletAll() throws SQLException, ClassNotFoundException, IOException {
		ArrayList<Wallet> proList=wdi.displayWalletAll();
		assertEquals(1, proList.size());
	}
	@Test
	public void testinsertWallet() throws SQLException, ClassNotFoundException, IOException {
		wl1=new Wallet("2",200);
		assertEquals(1, wdi.insertWallet(wl1));
		wdi.deleteWallet(wl1);
	}
	@Test
	public void testdeleteWallet() throws SQLException, ClassNotFoundException, IOException {
		wl2=new Wallet("3",300);
		wdi.insertWallet(wl2);
		assertEquals(1, wdi.deleteWallet(wl2));
	}
}
