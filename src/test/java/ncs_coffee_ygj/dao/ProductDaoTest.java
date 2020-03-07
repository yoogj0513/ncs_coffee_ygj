package ncs_coffee_ygj.dao;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import ncs_coffee_ygj.dao.impl.ProductDaoImpl;
import ncs_coffee_ygj.ds.MysqlDataSource;
import ncs_coffee_ygj.dto.Product;
import ncs_coffee_ygj.util.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest {
	private Connection con;
	private static ProductDao dao;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		dao = ProductDaoImpl.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		con = MysqlDataSource.getConnection();
	}

	@After
	public void tearDown() throws Exception {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		con.close();
	}

	@Test
	public void test01ProcedureProductByPriceRank() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Product> list = dao.procedureProductByPriceRank(con);
		Assert.assertNotEquals(0, list.size());
		
		for(Product prd : list) LogUtil.prnLog(prd);
	}

	@Test
	public void test02ProcedureProductByMarginRank() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Product> list = dao.procedureProductByMarginRank(con);
		Assert.assertNotEquals(0, list.size());
		
		for(Product prd : list) LogUtil.prnLog(prd);
	}
	
	@Test
	public void test03ProcedureProductBySumAll() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Product pdt = dao.procedureProductBySumAll(con);
		Assert.assertNotNull(pdt);
		LogUtil.prnLog(pdt);
	}
	
	@Test
	public void test04SelectProductByProductCode() {
		LogUtil.prnLog(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Product pdt = new Product("A002");
		Boolean res = dao.selectProductByProductCode(pdt);
		LogUtil.prnLog(res);
	}
}
