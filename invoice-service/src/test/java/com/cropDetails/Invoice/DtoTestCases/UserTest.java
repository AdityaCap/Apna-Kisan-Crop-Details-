package com.cropDetails.Invoice.DtoTestCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.cropDetails.Invoice.Dto.User;

public class UserTest {

    @Test
    public void testConstructorWithArguments() {
        User user = new User(12, "ROLE_FARMER", "Aditya");

        assertEquals(12, user.getUId());
        assertEquals("ROLE_FARMER", user.getRole());
        assertEquals("Aditya", user.getName());
    }

    @Test
    public void testDefaultConstructor() {
        User user = new User();

        assertEquals(0, user.getUId());
        assertNull(user.getRole());
        assertNull(user.getName());
    }

    @Test
    public void testSetterAndGetterMethods() {
        User user = new User();

        user.setUId(12);
        user.setRole("ROLE_FARMER");
        user.setName("Aditya");

        assertEquals(12, user.getUId());
        assertEquals("ROLE_FARMER", user.getRole());
        assertEquals("Aditya", user.getName());
    }

    @Test
    public void testToStringMethod() {
        User user = new User(12, "ROLE_FARMER", "Aditya");
        String expectedToString = "User(uId=12, role=ROLE_FARMER, name=Aditya)";
        assertEquals(expectedToString, user.toString());
    }
}
