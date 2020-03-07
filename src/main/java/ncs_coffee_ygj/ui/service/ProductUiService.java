package ncs_coffee_ygj.ui.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ncs_coffee_ygj.dao.ProductDao;
import ncs_coffee_ygj.dao.SaleDao;
import ncs_coffee_ygj.dao.impl.ProductDaoImpl;
import ncs_coffee_ygj.dao.impl.SaleDaoImpl;
import ncs_coffee_ygj.ds.MysqlDataSource;
import ncs_coffee_ygj.dto.Product;
import ncs_coffee_ygj.dto.Sale;

public class ProductUiService {
	private Connection con;
	private ProductDao pdtDao;
	private SaleDao saleDao;
	
	public ProductUiService() {
		try {
			con = MysqlDataSource.getConnection();
			pdtDao = ProductDaoImpl.getInstance();
			saleDao = SaleDaoImpl.getInstance();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void addProduct(Product pdt) {
		pdtDao.insertProduct(pdt);
	}
	
	public List<Product> showProductPriceRankList() {
		return pdtDao.procedureProductByPriceRank(con);
	}
	
	public List<Product> showProductMarginRankList() {
		return pdtDao.procedureProductByMarginRank(con);
	}
	
	public Product showProductSumList() {
		return pdtDao.procedureProductBySumAll(con);
	}
	
	public Boolean checkProductCode(Product pdt) {
		return pdtDao.selectProductByProductCode(pdt);
	}
	
	public Sale getProductName(Sale sale) {
		return saleDao.selectSaleByCode(sale);
	}
}
