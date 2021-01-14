package com.course_qa2020.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PriceMinPage extends Page{
    //TODO same as previously about variable names
    private String priceMinLocator="//div[@class='css-ijwzpf-ButtonWrapper e1tnwg465']//p[contains(text(),'£40k min')]";
    private String LOCATION_PAGE_TITLE_MIN="£40k min";

    public PriceMinPage(RemoteWebDriver driver) {
        super(driver);
    }
    //TODO as such method widely used I'd recommend to extract logic of it to the Page and reuse across other pages
    public boolean isTitleCorrect(){
        return driver.findElement(By.xpath(priceMinLocator)).getText().equals(LOCATION_PAGE_TITLE_MIN);
    }
}
