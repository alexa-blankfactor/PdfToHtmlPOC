package com.itelInc.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Element;
import java.util.List;

public class FindElement {

    public static Boolean isPresent(WebElement element){
        try {
            element.getText();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }

    }
    public static Boolean isPresent(List<WebElement> element) {
        return element.size() != 0 ? true : false;
    }
}
