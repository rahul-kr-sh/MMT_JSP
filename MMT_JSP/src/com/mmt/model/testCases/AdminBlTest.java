package com.mmt.model.testCases;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.mmt.model.bean.Flight;
import com.mmt.model.bean.Hotel;
import com.mmt.model.bean.HotelRoom;
import com.mmt.model.bl.AdminBlMMT;

public class AdminBlTest {
	AdminBlMMT abl=new AdminBlMMT();
	Flight f,newF;
	HotelRoom rm01;
	 HotelRoom rm02;
	 HotelRoom rm03;
	 HotelRoom rm11;
	 HotelRoom rm12;
	 HotelRoom rm13;
	 ArrayList<HotelRoom> al1;
	 ArrayList<HotelRoom> al2;
	 Hotel h,newHotel;
	@Before
	public void setUp() throws Exception {
		//f=new Flight("IndiGo","1","NewDelhi","Bangalore","18:40","21:20",8901,100);
		f=new Flight("AirIndia", "FLY2001","Delhi","Indore","3:00pm","5:00pm",6700.00,20);
		newF=new Flight("GoAir", "FLY2002","Mumbai","Indore","3:00pm","5:00pm",6900.00,20);
		 rm01=new HotelRoom("1",1,"Deluxe",3000,"Avail");
			rm02=new HotelRoom("1",2,"Cabana",4000,"Avail");
			 rm03=new HotelRoom("1",3,"Studio",5000,"Avail");
			 rm11=new HotelRoom("2",1,"Deluxe",3000,"Avail");
			 rm12=new HotelRoom("2",2,"Cabana",4000,"Avail");
			 rm13=new HotelRoom("2",3,"Studio",5000,"Avail");
			 al1=new ArrayList<HotelRoom>();
			 al2=new ArrayList<HotelRoom>();
			al1.add(rm01);
			al1.add(rm02);
			al1.add(rm03);
			al2.add(rm11);
			al2.add(rm12);
			al2.add(rm13);
			h=new Hotel("1","Taj Hotel","Mumbai","5 Star",al1); 
			newHotel=new Hotel("2","Ramada","Jaipur","5 Star",al2); 
	}

	@After
	public void tearDown() throws Exception {
		al1=null;
		al2=null;
		rm01=null;
		rm02=null;
		rm03=null;
		rm11=null;
		rm12=null;
		rm13=null;
		h=null;
		f=null;
	}

	@Test
	public void testInsertHotel() throws  SQLException, ClassNotFoundException, IOException {
		assertEquals(1,abl.insertHotel(h));
		abl.deleteHotel("1");
	}
	@Test
	public void testdeleteHotel() throws  SQLException, ClassNotFoundException, IOException {
		abl.insertHotel(h);
		assertEquals(1,abl.deleteHotel("1"));
		
	}
	@Ignore
	@Test
	public void testmodifyHotel() throws  SQLException, ClassNotFoundException, IOException {
		abl.insertHotel(h);
		assertEquals(1,abl.modifyHotel("1", newHotel));
		abl.deleteHotel("1");
		}
	
	@Ignore
	@Test
	public void testInsertFlight() throws  SQLException, ClassNotFoundException, IOException {
		assertEquals(1,abl.insertFlight(f));
		abl.deleteFlight( "FLY2001");
	}
	@Ignore
	@Test
	public void testdeleteFlight() throws  SQLException, ClassNotFoundException, IOException {
		abl.insertFlight(f);
		assertEquals(1,abl.deleteFlight("FLY2001"));
		
	}
	@Ignore
	@Test
	public void testmodifyFlight() throws  SQLException, ClassNotFoundException, IOException {
		abl.insertFlight(f);
		assertEquals(1,abl.modifyFlight("FLY2001",newF));
}}

