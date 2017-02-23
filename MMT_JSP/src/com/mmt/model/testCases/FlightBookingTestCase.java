package com.mmt.model.testCases;


import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.mmt.model.bean.FlightBooking;

import com.mmt.model.dao.FlightBookingImpMMT;


public class FlightBookingTestCase {

	FlightBookingImpMMT fbi=null;
		FlightBooking fbk=null;
		FlightBooking fbk1=null;
		
		@Before
		public void setUp() throws Exception {
			fbi=new FlightBookingImpMMT();
//			fbk=new FlightBooking("FBK1001", "UI100", "FLY2001", "20 Feb 2017", true);
//			fbk1=new FlightBooking("FBK2001","UI101","FLY2001","20 Feb 2017",true);
		}
	
		@After
		public void tearDown() throws Exception {
			fbi=null;
			fbk=null;
		}
		//@Ignore
		//@Test(expected=SQLException.class)
		@Ignore
		public void testInsertFlightbooking() throws SQLException, Exception {
			//System.out.println("insert");
			assertEquals(1,fbi.insertFlightBooking(fbk));
		}
		//@Ignore
		//@Test(expected=SQLException.class)
		@Ignore
		public void testdeleteFlightBooking() throws SQLException, ClassNotFoundException, IOException {
			//System.out.println("delete");
			assertEquals(1,fbi.deleteFlightBooking("FBK1001"));
			
		}
		//priyanka
		
		//@Test(expected=SQLException.class)
		@Ignore
		@Test
		public void testdisplayFlightBooking() throws SQLException, ClassNotFoundException, IOException {
			fbi.insertFlightBooking(fbk);
			ArrayList<FlightBooking> bookingList =fbi.displayFlightBooking();
			assertEquals(1,bookingList.size());
		}
		
		//ArrayList<FlightBooking> displayFlightBooking() throws ClassNotFoundException, SQLException;
		
		@Ignore
		@Test(expected=SQLException.class)
		public void testsearchFlightBooking() throws SQLException, ClassNotFoundException, IOException {
			fbi.insertFlightBooking(fbk);
			ArrayList<FlightBooking> bookingList =fbi.searchFlightBooking("FBK2001");
			assertEquals(1,bookingList.size());
		}

}
