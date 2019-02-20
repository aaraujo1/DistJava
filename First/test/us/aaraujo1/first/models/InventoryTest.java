package us.aaraujo1.first.models;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest extends TestCase {

    Inventory i;
    @Before
    public void setUp() throws Exception {
        i = new Inventory();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetProducts() {
        assertEquals(i.getProducts().size(), 1);
    }
}