package ncs_coffee_ygj.dao;

import java.sql.Connection;
import java.util.List;

import ncs_coffee_ygj.dto.Product;

public interface ProductDao {
	List<Product> procedureProductByPriceRank(Connection con);
	List<Product> procedureProductByMarginRank(Connection con);
	Product procedureProductBySumAll(Connection con);
	Boolean selectProductByProductCode(Product pdt);
	
	int insertProduct(Product pdt);
}
