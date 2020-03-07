package ncs_coffee_ygj.dao;

import ncs_coffee_ygj.dto.Sale;

public interface SaleDao {
	Sale selectSaleByCode(Sale sale);
}
