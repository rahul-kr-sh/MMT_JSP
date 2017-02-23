package com.mmt.model.testCases;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.mmt.model.bean.Promotion;
import com.mmt.model.dao.PromotionDaoImplMMT;

public class PromotionTestCase {
	PromotionDaoImplMMT pdi=null;
	Promotion pro=null;
	Promotion pro1=null;
	@Before
	public void setUp() throws Exception {
		pdi=new PromotionDaoImplMMT();
		pro=new Promotion("FLY2003","200Off",200.00,"20 Feb 2017",1999.50,"FlightType");
		pro1=new Promotion("FLY2001","200Off",200.00,"20 Feb 2017",1999.50,"FlightType");
	}

	@After
	public void tearDown() throws Exception {
		pdi=null;
		pro=null;
	}

	@Test(expected=SQLException.class)
	public void testInsertPromotion() throws SQLException, ClassNotFoundException, IOException {
		assertEquals(1,pdi.insertPromotion(pro));
		
	}
	
	@Test(expected=SQLException.class)
	public void testdeletePromotion() throws SQLException, ClassNotFoundException, IOException {
		assertEquals(1,pdi.deletePromotion("FLY200"));
		
	}
	@Test(expected=SQLException.class)
	public void testupdatePromotion() throws SQLException, ClassNotFoundException, IOException {
		assertEquals(1,pdi.updatePromotion("FLY200", pro1));
	}
	@Test(expected=SQLException.class)
	public void testdisplayPromotion() throws SQLException, ClassNotFoundException, IOException {
		pdi.insertPromotion(pro);
		ArrayList<Promotion> proList=pdi.displayPromotion();
		assertEquals(1,proList.size());
	}
	@Test(expected=SQLException.class)
	public void testsearchPromotion() throws SQLException, ClassNotFoundException, IOException {
		pdi.insertPromotion(pro1);
		assertEquals(pro1,pdi.searchPromotion("FLY2001"));
		
	}
	@Test(expected=SQLException.class)
	public void testdisplayPromotiontype() throws SQLException, ClassNotFoundException, IOException {
		pdi.insertPromotion(pro);
		ArrayList<Promotion> proList1=pdi.displayPromotion("flight");
		assertEquals(1,proList1.size());
}
}
