package com.makemytrip.baseclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DWT_Utility_Functions {

	static int indexOfCountry, indexOfTotal, indexOfRecovered, indexOfActive;
	static WebDriver driver;

	public static void browserLaunch() {

		System.getProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.worldometers.info/coronavirus/");
		driver.manage().window().maximize();
	}

	public static void getHeaderIndexes() {
		// Iterate all headers
		List<WebElement> allHeaders = driver
				.findElements(By.xpath("//table[@id='main_table_countries_today']/thead/tr/th"));

		for (int i = 0; i < allHeaders.size(); i++) {

			String header = allHeaders.get(i).getText().replaceAll("\n", " ");
			System.out.println(header);

			if (header.contains("Country")) {
				indexOfCountry = i;
			} else if (header.equalsIgnoreCase("Total Cases")) {
				indexOfTotal = i;
			} else if (header.equalsIgnoreCase("Total Recovered")) {
				indexOfRecovered = i;
			} else if (header.equalsIgnoreCase("Active Cases")) {
				indexOfActive = i;
			}
		}
		System.out.println("Index Of Country :" + indexOfCountry);
		System.out.println("Index Of Total :" + indexOfTotal);
		System.out.println("Index Of Recovered :" + indexOfRecovered);
		System.out.println("Index Of Active :" + indexOfActive);
	}

	public static void getColumnData(String countryName) {
		// traverse into body
		List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody/tr"));

		for (int i = 0; i < allRows.size(); i++) {
			List<WebElement> allColumn = allRows.get(i).findElements(By.tagName("td"));

			for (int j = 0; j < allColumn.size(); j++) {

				if (j == indexOfCountry) {
					if (allColumn.get(j).getText().equalsIgnoreCase(countryName)) {
						System.out.println("\nTotal Cases :" + allColumn.get(indexOfTotal).getText());
						System.out.println("Recovered Cases :" + allColumn.get(indexOfRecovered).getText());
						System.out.println("Active Cases :" + allColumn.get(indexOfActive).getText());
					}
					break;
				}
			}
		}
	}
}
