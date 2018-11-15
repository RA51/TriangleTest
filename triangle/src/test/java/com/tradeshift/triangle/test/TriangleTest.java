package com.tradeshift.triangle.test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.tradeshift.triangle.controller.TriangleController;

/**
 * @author Roshan Akhtar
 * purpose of this tool to test the cases
 *
 */
public class TriangleTest {
	/**
	 * purpose of this test to validate the sides of triangle
	 * 
	 */
	 
	 private TriangleController triangle= new TriangleController();
	//@Test
	public void isValidSideTest()
	{
		assertEquals(true,triangle.isValidSide("3232"));
		assertEquals(true,triangle.isValidSide("3223.000"));
		assertEquals(true,triangle.isValidSide("-232323"));
	}
	 
	/**
	 * purpose of this test to know all the 
	 * types of triangles
	 *
	 */
	@Test
	public void getTriangleTypesTest()
	{
		/**
		 * testing as not a triangle
		 */
		List<Double> sidesList= Arrays.asList(1.0,5.0,10.0);    
		assertEquals("not a triangle",triangle.getTriangleTypes(sidesList));
		List<Double> sidesList1= Arrays.asList(5.0,5.0,10.0);
		assertEquals("not a triangle",triangle.getTriangleTypes(sidesList1));
		List<Double> sidesList2= Arrays.asList(10.0,5.0,4.0);
		assertEquals("not a triangle",triangle.getTriangleTypes(sidesList2));
		List<Double> sidesList3= Arrays.asList(10.0,5.0,5.0);
		assertEquals("not a triangle",triangle.getTriangleTypes(sidesList3));
		List<Double> sidesList4= Arrays.asList(0.0,5.0,5.0);
		assertEquals("not a triangle",triangle.getTriangleTypes(sidesList4));
		List<Double> sidesList5= Arrays.asList(5.0,0.0,5.0);
		assertEquals("not a triangle",triangle.getTriangleTypes(sidesList5));
		List<Double> sidesList6= Arrays.asList(5.0,5.0,0.0);
		assertEquals("not a triangle",triangle.getTriangleTypes(sidesList6));
		/**
		 * testing as equilateral
		 */
		List<Double> sidesList7= Arrays.asList(5.0,5.0,5.0);
		assertEquals("equilateral",triangle.getTriangleTypes(sidesList7));
		
		/**
		 * testing as isosceles
		 */
		List<Double> sidesList8= Arrays.asList(5.0,5.0,6.0);
		assertEquals("isosceles",triangle.getTriangleTypes(sidesList8));
		List<Double> sidesList9= Arrays.asList(6.0,5.0,6.0);
		assertEquals("isosceles",triangle.getTriangleTypes(sidesList9));
		List<Double> sidesList10= Arrays.asList(5.0,6.0,6.0);
		assertEquals("isosceles",triangle.getTriangleTypes(sidesList10));
		
		/**
		 * testing as scalene
		 */
		List<Double> sidesList11= Arrays.asList(5.0,6.0,7.0);
		assertEquals("scalene",triangle.getTriangleTypes(sidesList11));
	}
	
	@Test 
	public void sidesOfTriangleTest()
	{
		List<Double> sidesList=null;
		
		sidesList = Arrays.asList(1.0,5.0,10.0);    

        //1. If List has this value
        assertThat(sidesList, hasItems(1.0));

        //2. Check List Size
        assertThat(sidesList, hasSize(3));
	}
	// This test case passsing validated that sum of sides can not be null
	
	@Test(expected=NullPointerException.class)
	public void getSumOfSides()
	{
		List<Double> sidesList=null;
		fail(triangle.getTriangleTypes(sidesList));
	}
	
}
