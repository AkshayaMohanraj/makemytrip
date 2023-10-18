package com.makemytrip.baseclass;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_WebTable extends DWT_Utility_Functions{

	public static void main(String[] args) {
		Logger log = Logger.getLogger(Dynamic_WebTable.class);
	//	PropertyConfigurator.configure("C:\\Users\\Vijayakumar\\eclipse-workspace\\MakeMyTrip\\log4j.properties");
		DOMConfigurator.configure("C:\\Users\\Vijayakumar\\eclipse-workspace\\MakeMyTrip\\log4j.properties");
		String country = "Russia";
		
		browserLaunch();
		log.info("Browser Launch");
		getHeaderIndexes();
		log.info("get header indexes");
		getColumnData(country);
		log.info("get data ");
	}

}
