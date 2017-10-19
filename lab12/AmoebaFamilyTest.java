import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Part of lab12
 * Created by Ray on 7/11/2017.
 */
public class AmoebaFamilyTest {

    @Test
    public void longestName() throws Exception {
        AmoebaFamily a = new AmoebaFamily("1");
        a.addChild("1","22");
        a.addChild("22","333");
        a.addChild("1","4444");

        AmoebaFamily b = new AmoebaFamily("333");
        b.addChild("1","3");
        b.addChild("1","34");

        a.print();
        b.print();

        assertEquals(a.longestName(),"4444");
        assertEquals(b.longestName(),"333");
    }

    @Test
    public void height() throws Exception {
        AmoebaFamily b = new AmoebaFamily("0");
        b.addChild("0","1");
        b.addChild("1","2");
        b.addChild("0","1");
        b.addChild("1","2");

        AmoebaFamily a = new AmoebaFamily("0");
        a.addChild("0", "1");
        a.addChild("1", "2");
        a.addChild("1","2");
        a.addChild("2","3");


        AmoebaFamily c = new AmoebaFamily("0");

        AmoebaFamily d = new AmoebaFamily("0");
        d.addChild("0","1");
        d.addChild("1","2");
        d.addChild("2","3");
        d.addChild("3","4");

        a.print();
        b.print();
        c.print();
        d.print();

        assertEquals(a.height(),3);
        assertEquals(b.height(),2);
        assertEquals(c.height(),0);
        assertEquals(d.height(),4);
    }

}