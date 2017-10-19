import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ray on 6/30/2017.
 */
public class AccountTest {
    @Test
    public void testInit() throws Exception {
        int initBalance = 100;
        Account acct = new Account(initBalance);
        assertEquals(acct.getBalance(),initBalance);

    }

    @Test
    public void testInvalidArgs() throws Exception {
        int negAmount = -100;
        int balAmount = 100;
        Account acct = new Account(balAmount);
        acct.withdraw(negAmount);
        assertEquals(acct.getBalance(),balAmount);
        acct.deposit(negAmount);
        assertEquals(acct.getBalance(),balAmount);

    }

    @Test
    public void testOverdraft() throws Exception {
        Account acct = new Account(100);
        acct.withdraw(200);
        assertEquals(acct.getBalance(),100);
    }

    @Test
    public void testDeposit() throws Exception {
        Account acct = new Account(10);
        acct.deposit(100);
        assertEquals(acct.getBalance(),110);
    }

    @Test
    public void testWithdraw() throws Exception {
        Account acct = new Account(200);
        acct.withdraw(100);
    }
}