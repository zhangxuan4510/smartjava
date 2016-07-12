package test.edu.bjtu.daoimpl;

import edu.bjtu.daoimpl.PayeeDaoImpl;
import edu.bjtu.model.Payee;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * PayeeDaoImpl Tester.
 *
 * @author <Authors name>
 * @since <pre>07/11/2016</pre>
 * @version 1.0
 */
public class PayeeDaoImplTest extends TestCase {
    public PayeeDaoImplTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public static Test suite() {
        return new TestSuite(PayeeDaoImplTest.class);
    }

    @org.junit.Test
    public void testaddPayee() throws Exception {
        PayeeDaoImpl payeeDao=new PayeeDaoImpl();
        Payee p=new Payee();
        p.setName("xiaowang");
        p.setAccount("hhhhh");
        p.setAddress("beijing");
        p.setSwiftCode("1234567");
        p.setBankName("huaqi");
        p.setBankAddress("huashendun");
        payeeDao.addPayee(p,"123");
        System.out.println("测试完毕");
    }



}
