package ncs_coffee_ygj.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ncs_coffee_ygj.dao.ProductDao;
import ncs_coffee_ygj.ds.MysqlDataSource;
import ncs_coffee_ygj.dto.Product;
import ncs_coffee_ygj.dto.Sale;
import ncs_coffee_ygj.util.LogUtil;

public class ProductDaoImpl implements ProductDao {
	private static final ProductDaoImpl instance = new ProductDaoImpl();
	
	public static ProductDaoImpl getInstance() {
		return instance;
	}
	
	public ProductDaoImpl() {}

	@Override
	public int insertProduct(Product pdt) {
		String sql = "insert into product(product_code , price , sale_cnt , margin_rate ) values (?, ?, ?, ?)";
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, pdt.getPdtCode());
			pstmt.setInt(2, pdt.getPdtPrice());
			pstmt.setInt(3, pdt.getPdtSaleCnt());
			pstmt.setInt(4, pdt.getPdtMarginRate());
			LogUtil.prnLog(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Product> procedureProductByPriceRank(Connection con) {
		String sql = "{call proc_order_price('priceRank')}";
		List<Product> list = null;
		try (CallableStatement cs = con.prepareCall(sql)) {
			LogUtil.prnLog(cs);
			try (ResultSet rs = cs.executeQuery()) {
				list = new ArrayList<>();
				if(rs.next()) {
					do {
						list.add(getList(rs));
					}while(rs.next());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Product> procedureProductByMarginRank(Connection con) {
		String sql = "{call proc_order_price('marginRank')}";
		List<Product> list = null;
		try (CallableStatement cs = con.prepareCall(sql)) {
			LogUtil.prnLog(cs);
			try (ResultSet rs = cs.executeQuery()) {
				list = new ArrayList<>();
				if(rs.next()) {
					do {
						list.add(getList(rs));
					} while(rs.next());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product procedureProductBySumAll(Connection con) {
		String sql = "{call proc_sum()}";
		try (CallableStatement cs = con.prepareCall(sql);
				ResultSet rs = cs.executeQuery()) {
			LogUtil.prnLog(cs);
			if(rs.next()) {
				return getTotalSum(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Product getTotalSum(ResultSet rs) throws SQLException {
		int pdtSupplySum = rs.getInt("supply_sum");
		int pdtAddtionSum = rs.getInt("addition_sum");
		int pdtSaleAmountSum = rs.getInt("sale_amount_sum");
		int pdtMarginAmountSum = rs.getInt("margin_amount_sum");
		return new Product(pdtSupplySum, pdtAddtionSum, pdtSaleAmountSum, pdtMarginAmountSum);
	}

	private Product getList(ResultSet rs) throws SQLException {
		int pdtRank = rs.getInt("ranking");
		String pdtCode = rs.getString("code");
		Sale pdtName = new Sale();
		pdtName.setProductName(rs.getString("name"));
		int pdtPrice = rs.getInt("price");
		int pdtSaleCnt = rs.getInt("sale_cnt");
		int pdtMarginRate = rs.getInt("margin_rate");
		int pdtSupply = rs.getInt("supply");
		int pdtAddition = rs.getInt("addition");
		int pdtSaleSum = rs.getInt("sale_sum");
		int pdtMarginSum = rs.getInt("margin_sum");
		return new Product(pdtRank, pdtCode, pdtName, pdtPrice, pdtSaleCnt, pdtSupply, pdtAddition, pdtSaleSum, pdtMarginRate, pdtMarginSum);
	}

	@Override
	public Boolean selectProductByProductCode(Product pdt) {
		String sql = "select product_code from product where product_code = ?";
		try(Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, pdt.getPdtCode());
			try(ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}
