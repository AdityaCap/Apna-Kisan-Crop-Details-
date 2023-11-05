package com.cropDetails.Invoice.ModelTestCases;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cropDetails.Invoice.Model.Invoice;

import lombok.AllArgsConstructor;

public class InvoiceTest {

    private Invoice invoice;

    @BeforeEach
    public void setUp() throws ParseException {
        // Create an instance of the Invoice class with sample data
        invoice = new Invoice();
        invoice.setInvoiceId("653d176102960856fa0df7e8");
        invoice.setFarmerId(0);
        invoice.setDealerId(22);
        invoice.setCropId(0);
        invoice.setTotalCost(1500);
        invoice.setQuantity(60);
        // Set the date with the sample date string
        // (You might want to change this to handle date objects properly in your code)
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date date = dateFormat.parse("2023-10-28T14:14:57.124+00:00");
        invoice.setDateOfPurchase(date);
    }

    @Test
    public void testInvoiceId() {
        assertEquals("653d176102960856fa0df7e8", invoice.getInvoiceId());
    }

    @Test
    public void testFarmerId() {
        assertEquals(0, invoice.getFarmerId());
    }

    @Test
    public void testDealerId() {
        assertEquals(22, invoice.getDealerId());
    }

    @Test
    public void testCropId() {
        assertEquals(0, invoice.getCropId());
    }

    @Test
    public void testTotalCost() {
        assertEquals(1500, invoice.getTotalCost());
    }

    @Test
    public void testQuantity() {
        assertEquals(60, invoice.getQuantity());
    }

    @Test
    public void testDateOfPurchase() {
        String expectedDate = "2023-10-28T14:14:57.124Z";
        assertEquals(expectedDate, invoice.getDateOfPurchase().toInstant().toString());
    }


    @Test
    public void testConstructorWithArguments() {
        Invoice invoice = new Invoice("653d176102960856fa0df7e8", 0, 22, 0, 1500, 60, new Date());

        assertEquals("653d176102960856fa0df7e8", invoice.getInvoiceId());
        assertEquals(0, invoice.getFarmerId());
        assertEquals(22, invoice.getDealerId());
        assertEquals(0, invoice.getCropId());
        assertEquals(1500, invoice.getTotalCost());
        assertEquals(60, invoice.getQuantity());
        assertNotNull(invoice.getDateOfPurchase());
    }

    @Test
    public void testDefaultConstructor() {
        Invoice invoice = new Invoice();

        assertNull(invoice.getInvoiceId());
        assertEquals(0, invoice.getFarmerId());
        assertEquals(0, invoice.getDealerId());
        assertEquals(0, invoice.getCropId());
        assertEquals(0, invoice.getTotalCost());
        assertEquals(0, invoice.getQuantity());
        assertNull(invoice.getDateOfPurchase());
    }

    @Test
    public void testSetterAndGetterMethods() {
        Invoice invoice = new Invoice();

        invoice.setInvoiceId("653d176102960856fa0df7e8");
        invoice.setFarmerId(0);
        invoice.setDealerId(22);
        invoice.setCropId(0);
        invoice.setTotalCost(1500);
        invoice.setQuantity(60);
        invoice.setDateOfPurchase(new Date());

        assertEquals("653d176102960856fa0df7e8", invoice.getInvoiceId());
        assertEquals(0, invoice.getFarmerId());
        assertEquals(22, invoice.getDealerId());
        assertEquals(0, invoice.getCropId());
        assertEquals(1500, invoice.getTotalCost());
        assertEquals(60, invoice.getQuantity());
        assertNotNull(invoice.getDateOfPurchase());
    }

    @Test
    public void testToStringMethod() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date expectedDate = null;
        try {
            expectedDate = dateFormat.parse("2023-10-28T19:44:57.124+05:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Invoice invoice = new Invoice("653d176102960856fa0df7e8", 0, 22, 0, 1500, 60, expectedDate);

        SimpleDateFormat invoiceDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        String formattedDate = invoiceDateFormat.format(invoice.getDateOfPurchase());

        String expectedToString = "Invoice(invoiceId=653d176102960856fa0df7e8, farmerId=0, dealerId=22, cropId=0, totalCost=1500, quantity=60, dateOfPurchase=" + formattedDate + ")";
        assertEquals(expectedToString, invoice.toString());
    }



}

