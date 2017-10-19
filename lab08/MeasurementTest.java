import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ray on 6/30/2017.
 */
public class MeasurementTest {
    @org.junit.Test
    public void testgetFeet() throws Exception {
        Measurement m = new Measurement(1,11);
        assertEquals(m.getFeet(),1);
        Measurement n = new Measurement(4);
        assertEquals(n.getFeet(),4);
        Measurement o = new Measurement(0,1);
        assertEquals(o.getFeet(),0);
    }

    @Test
    public void testgetInches() throws Exception {
        Measurement m = new Measurement(0,12);
        assertEquals(m.getInches(),0);
        Measurement n = new Measurement(1,4);
        assertEquals(n.getInches(),4);
        Measurement o = new Measurement(12);
        assertEquals(o.getInches(),0);
    }

    @Test
    public void testplus() throws Exception {
        Measurement m = new Measurement(1,10);
        Measurement n = new Measurement(2,4);
        Measurement o = n.plus(m);
        assertEquals(o.numInches,50);
        assertEquals(o.getFeet(),4);
        assertEquals(o.getInches(),2);
    }

    @Test
    public void testminus() throws Exception {
        Measurement m = new Measurement(4,1);
        Measurement n = new Measurement(3,10);
        Measurement o = m.minus(n);
        assertEquals(o.numInches,3);
        assertEquals(o.getFeet(),0);
        assertEquals(o.getInches(),3);
    }

    @Test
    public void testmultiple() throws Exception {
        Measurement m = new Measurement(6,2);
        Measurement n = m.multiple(2);
        assertEquals(n.getFeet(),12);
        assertEquals(n.getInches(),4);
        Measurement o = n.multiple(0);
        assertEquals(o.getInches(),0);
        Measurement p = m.multiple(1);
        assertEquals(p.getInches(),2);
        assertEquals(p.getFeet(),6);
    }

    @Test
    public void testtoString() throws Exception {
        Measurement m = new Measurement(6,2);
        Measurement n = new Measurement(0,4);
        Measurement o = new Measurement(7);
        assertEquals(m.toString(),"6'2\"");
        assertEquals(n.toString(),"0'4\"");
        assertEquals(o.toString(),"7'0\"");
    }

}