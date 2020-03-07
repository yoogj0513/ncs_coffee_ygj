package ncs_coffee_ygj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ncs_coffee_ygj.dao.SaleDao;
import ncs_coffee_ygj.ds.MysqlDataSource;
import ncs_coffee_ygj.dto.Sale;
import ncs_coffee_ygj.util.LogUtil;

public class SaleDaoImpl implements SaleDao {
	private static final SaleDaoImpl instance = new SaleDaoImpl();
	
	public static SaleDaoImpl getInstance() {
		return instance;
	}
	
	public SaleDaoImpl() {}

	@Override
	public Sale selectSaleByCode(Sale sale) {
		String sql = "select product_code , product_name from sale where product_code = ?";
		try (Connection con = MysqlDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, sale.getProductCode());
			LogUtil.prnLog(pstmt);
			try (ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					return getSale(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Sale getSale(ResultSet rs) throws SQLException {
		String productCode = rs.getString("product_code");
		String productName = rs.getString("product_name");
		return new Sale(productCode, productName);
	}

}
