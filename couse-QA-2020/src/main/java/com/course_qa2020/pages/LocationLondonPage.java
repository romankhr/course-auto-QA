package com.course_qa2020.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LocationLondonPage extends Page{
    //TODO same as previously - capitals should be used for constants only
    private String searchTermLocatorLocation="//h1[@class='css-mh5azd-Heading1 e1s8jdjv5']";
    private String LOCATION_PAGE_TITLE_LOCATION="Property for sale in London";

    public LocationLondonPage(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean isTitleCorrect(String searchTerm){
        return driver.findElement(By.xpath(searchTermLocatorLocation)).getText().toLowerCase().contains(searchTerm.toLowerCase());
    }
}
