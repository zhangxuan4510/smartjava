package demo;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhangxuan on 2016/7/9.
 */
public class CalculatorTest extends TestCase {
    Calculator cal=new Calculator();
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void add() throws Exception {
        assertEquals(6,cal.add(3,3));
    }

}