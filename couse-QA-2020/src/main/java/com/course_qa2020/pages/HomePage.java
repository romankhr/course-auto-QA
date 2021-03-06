package com.course_qa2020.pages;


import com.course_qa2020.framework.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HomePage extends Page {
    //TODO please be consistent with the naming and either add Locator at the end to all of them or to none
    protected RemoteWebDriver driver;
    private String searchFindByLocationLocator="//input[@class='search-input geo_autocomplete']";
    private String searchButtonLocator="//button[@id='search-submit']";
    private String searchByMinPriceLocator="//select[@id='forsale_price_min' ]//option[5]";
    private String searchByMaxPriceLocator="//select[@id='forsale_price_max' ]//option[37]";
    private String searchByPropertyType="//select[@id='property_type']//option[contains(text(),'Houses')]";
    private String searchAdvance="//div[@class='search-bottom-left']";
    private String searchByBedrooms="//select[@id='beds_min']//option[5]";
    private String searchRadius="//select[@id='radius']//option[contains(text(),'Within ¼ mile')]";
    private String sortLocator="//select[@id='sort_by']//option[contains(text(),'Lowest price')]";

    public HomePage(RemoteWebDriver driver) {
        super(driver);
        this.driver=driver;
    }
   //TODO please fix identation
        public HomePage setSearchLocationTerm(String searchTerm){
            driver.findElement(By.xpath(searchFindByLocationLocator)).sendKeys(searchTerm);
            return this;
        }

         public <T extends Page> T clickOnSearchButton(Class<T> clazz) throws Exception {
             driver.findElement(By.xpath(searchButtonLocator)).click();
             return PageFactory.newPage(driver, clazz);
    }

    public HomePage setMinPrice(){
        driver.findElement(By.xpath(searchByMinPriceLocator)).click();
        return this;
    }

    public HomePage setMaxPrice(){
        driver.findElement(By.xpath(searchByMaxPriceLocator)).click();
        return this;
    }
    public HomePage setPropertyType(){
        driver.findElement(By.xpath(searchByPropertyType)).click();
        return this;
    }

    public HomePage setSearchAdvance(){
        driver.findElement(By.xpath(searchAdvance)).click();
        return this;
    }

    public HomePage setSearchByBedrooms(){
        driver.findElement(By.xpath(searchByBedrooms)).click();
        return this;
    }
    public HomePage setSearchRadius(){
        driver.findElement(By.xpath(searchRadius)).click();
        return this;
    }
    public HomePage setSortOptions() {
        driver.findElement(By.xpath(sortLocator)).click();
        return this;
    }
}
