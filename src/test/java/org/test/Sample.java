package org.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Sample {

	public static void main(String[] args) {

		Select s;
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);

		driver.get("https://clicktobuy.hyundai.co.in/#/bookACar?modelCode=0Y");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement ddnModel = driver.findElement(By.id("inputmodel-01"));
		s = new Select(ddnModel);
		s.selectByValue("0Y");

		s = new Select(driver.findElement(By.id("inputfuel-01")));
		s.selectByValue("U");

		s = new Select(driver.findElement(By.id("inputvrnt-01")));
		s.selectByValue("4884");

		s = new Select(driver.findElement(By.id("inputext-01")));
		s.selectByValue("A2B");

		s = new Select(driver.findElement(By.id("inputinter-01")));
		s.selectByValue("MCG");

		s = new Select(driver.findElement(By.id("state-01")));
		s.selectByValue("AN");

		s = new Select(driver.findElement(By.id("dealer-city-01")));
		s.selectByValue("S30");

		s = new Select(driver.findElement(By.id("bookacardelar")));
		s.selectByValue("S4228");

		for (int i = 1; i <= 35; i++) {
			s = new Select(driver.findElement(By.cssSelector("#state-01")));
			s.selectByIndex(i);

			for (int j = 1; j <= 40; j++) {

				s = new Select(driver.findElement(By.cssSelector("#dealer-city-01")));
				s.selectByIndex(j);

				for (int k = 1; k <= 2; k++) {

					s = new Select(driver.findElement(By.cssSelector("#bookacardelar")));
					s.selectByIndex(k);

					WebElement txtDealer = driver.findElement(By.xpath("//div[@class='tit ico-bullet']"));
					System.out.println(txtDealer.getText());
					break;

				}
				break;
			}

		}

	}
}