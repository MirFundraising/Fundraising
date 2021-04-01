package com.example.demo.serverClasses;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class FundraisingTest {

    long fundraisingId = 666L;

    Fundraising fundraising = new Fundraising(fundraisingId, 0, false, "", Calendar.getInstance(), new ArrayList<>(), 0);

    @Test
    void testGetFundraisingId() {
        assertEquals(fundraising.getFundraisingId(), fundraisingId);
    }

    @Test
    void getTransactionList() {
        assertEquals(fundraising.getTransactionList(), new ArrayList<>());
    }

}