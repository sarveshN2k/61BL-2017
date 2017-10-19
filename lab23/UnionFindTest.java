import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cjjang on 8/7/17.
 */
public class UnionFindTest {
    @Test
    public void sizeOf() throws Exception {
        UnionFind test = new UnionFind(5);
        assertEquals(test.sizeOf(0), 1);

    }

    @Test
    public void parent() throws Exception {
        UnionFind test = new UnionFind(5);
        assertEquals(test.parent(0), -1);

    }

    @Test
    public void isConnected() throws Exception {

    }

    @Test
    public void find() throws Exception {
        UnionFind test = new UnionFind(5);

    }

    @Test
    public void union() throws Exception {
    }

}