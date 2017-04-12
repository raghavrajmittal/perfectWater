package com.example.thushara.perfectwater;

import org.junit.Test;

import static org.junit.Assert.*;
import model.WaterSourceReport;
import model.WaterPurityReport;
/**
 * Created by Deepa on 4/10/17.
 */

public class ReportTest {
    //initialize a report object.
    //------*****---------THUSHARA MUDIREDDY JUNIT TESTS START----------********---------
    @Test (expected =  Exception.class)
    public void testName() throws Exception {
        WaterSourceReport one = new WaterSourceReport("", "1/2/3", "1:30", "30332", "Spring", "Muddy");
    }

    @Test (expected =  Exception.class)
    public void testDate() throws Exception {
        WaterSourceReport one = new WaterSourceReport("Deepa", "", "1:30", "30332", "Spring", "Muddy");

    }

    @Test (expected =  Exception.class)
    public void testLocation() throws Exception {
        WaterSourceReport one = new WaterSourceReport("Deepa", "1/2/3", "1:30", "", "Spring", "Muddy");
    }

    @Test (expected = Exception.class)
    public void testWaterType() throws Exception {
        WaterSourceReport one = new WaterSourceReport("Deepa", "1/2/3", "1:30", "30332", "", "Muddy");

    }

    @Test (expected = Exception.class)
    public void testWaterCondition() throws Exception {
        WaterSourceReport one = new WaterSourceReport("Deepa", "1/2/3", "1:30", "30332", "Spring", "");

    }

    @Test
    public void testSuccess() throws Exception {
        WaterSourceReport one = new WaterSourceReport("Deepa", "1/2/3", "1:30", "30332", "Spring", "Muddy");
        assertEquals("Deepa", one.getName());
        assertEquals("1/2/3", one.getDate());
        assertEquals("1:30", one.getTime());
        assertEquals("30332", one.getLocation());
        assertEquals("Spring", one.getWaterType());
        assertEquals("Muddy", one.getWaterCondition());
    }
    //-----*****---- THUSHARA MUDIREDDY JUNIT ENDS--------*********---------




    //------*****--------- DEEPA PILLALAMARRI JUNIT TESTS START----------********---------

    @Test (expected = Exception.class)
    public void testName1() throws Exception {
        WaterPurityReport test1 = new WaterPurityReport("", "2/7/16", "7:30", "GA", "Safe", "2.0", "0.01");
    }

    @Test (expected = Exception.class)
    public void testDate1() throws Exception {
        WaterPurityReport test1 = new WaterPurityReport("Sarah", "", "7:30", "GA", "Safe", "2.0", "0.01");
    }

    @Test (expected = Exception.class)
    public void testTime1() throws Exception {
        WaterPurityReport test1 = new WaterPurityReport("Sarah", "2/7/16", "", "GA", "Safe", "2.0", "0.01");
    }

    @Test (expected = Exception.class)
    public void testLocation1() throws Exception {
        WaterPurityReport test1 = new WaterPurityReport("Sarah", "2/7/16", "7:30", "", "Safe", "2.0", "0.01");
    }

    @Test (expected = Exception.class)
    public void testWaterCondition1() throws Exception {
        WaterPurityReport test1 = new WaterPurityReport("Sarah", "2/7/16", "7:30", "GA", "", "2.0", "0.01");
    }

    @Test (expected = Exception.class)
    public void testVirusppm1() throws Exception {
        WaterPurityReport test1 = new WaterPurityReport("Sarah", "2/7/16", "7:30", "GA", "Safe", "", "0.01");
    }
    @Test (expected = Exception.class)
    public void testContppm1() throws Exception {
        WaterPurityReport test1 = new WaterPurityReport("Sarah", "2/7/16", "7:30", "GA", "Safe", "2.0", "");
    }

    //Success Case
    @Test
    public void Success1() throws Exception {
        WaterPurityReport test1 = new WaterPurityReport("Sarah", "2/7/16", "7:30", "GA", "Safe", "2.0", "0.01");
        assertEquals("Sarah", test1.getName());
        assertEquals("2/7/16", test1.getDate());
        assertEquals("7:30", test1.getTime());
        assertEquals("GA", test1.getLocation());
        assertEquals("Safe", test1.getWaterCondition());
        assertEquals("2.0", test1.getVirusppm());
        assertEquals("0.01", test1.getContppm());
    }
    //------*****--------- DEEPA PILLALAMARRI JUNIT TESTS END----------********---------

}

