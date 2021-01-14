package com.course_qa2020.pages;

import javafx.collections.transformation.SortedList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortedPage extends Page {
    //TODO please make it private & remove empty line
    public String resultsListLocator = "//p[@class='css-18tfumg-Text eczcs4p0']";


    public SortedPage(RemoteWebDriver driver) {
        super(driver);
    }
    //TODO method should be renamed & overall can we make it less complex? or split into few methods to decrease complexity?
    public boolean isSortedPageSorted() {
        List<Integer> results = new ArrayList<>();
        List<Integer> expectedResults = new ArrayList<>();

        for (WebElement element : getElements(By.xpath(resultsListLocator))) {
            String price = element.getText().replaceAll("[^\\d]", "");
            System.out.println(price);

            if (price.isEmpty())
                continue;

            results.add(Integer.parseInt(price));
            expectedResults.add(Integer.parseInt(price));
            Collections.sort(expectedResults, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o1,o2);
                }
            });

            if (!results.get(results.size() - 1).equals(expectedResults.get(expectedResults.size() - 1)))
                return false;
        }

        return true;
    }

}
