package com.dev.landonhotelapi.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class DateUtilsTest {

    @Test
    @DisplayName("check if the date conversion is done successfully")
    void createDateFromDateString() {
        DateUtils dateUtils =  new DateUtils();
        Assertions.assertEquals(dateUtils.createDateFromDateString("3030-12-04"),new Date("3030/12/04"));
        System.out.println("createDateFromDateString(\"3030-12-04\") = " + dateUtils.createDateFromDateString("3030-12-04"));
    }
}