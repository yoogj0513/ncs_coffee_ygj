package ncs_coffee_ygj.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ncs_coffee_ygj.dao.impl.SaleDaoImpl;
import ncs_coffee_ygj.dto.Sale;
import ncs_coffee_ygj.util.LogUtil;

public class SaleDaoTest {
	private static SaleDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		dao = SaleDaoImpl.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	}

	@After
	public void tearDown() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	}

	@Test
	public void testSelectSaleByCode() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Sale getName = dao.selectSaleByCode(new Sale("A001"));
		Assert.assertNotNull(getName);
		LogUtil.prnLog(getName);
	}

}
