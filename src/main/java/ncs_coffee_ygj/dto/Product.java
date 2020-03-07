package ncs_coffee_ygj.dto;

public class Product {
	private int pdtRank;
	private String pdtCode;
	private Sale pdtName;
	private int pdtPrice;
	private int pdtSaleCnt;
	private int pdtSupply;
	private int pdtAddition;
	private int pdtSaleSum;
	private int pdtMarginRate;
	private int pdtMarginSum;
	private int pdtSupplySum;
	private int pdtAddtionSum;
	private int pdtSaleAmountSum;
	private int pdtMarginAmountSum;

	public Product() {}

	public Product(String pdtCode) {
		this.pdtCode = pdtCode;
	}
	
	public Product(String pdtCode, int pdtPrice, int pdtSaleCnt, int pdtMarginRate) {
		this.pdtCode = pdtCode;
		this.pdtPrice = pdtPrice;
		this.pdtSaleCnt = pdtSaleCnt;
		this.pdtMarginRate = pdtMarginRate;
	}

	public Product(int pdtRank, String pdtCode, Sale pdtName, int pdtPrice, int pdtSaleCnt, int pdtSupply,
			int pdtAddition, int pdtSaleSum, int pdtMarginRate, int pdtMarginSum) {
		this.pdtRank = pdtRank;
		this.pdtCode = pdtCode;
		this.pdtName = pdtName;
		this.pdtPrice = pdtPrice;
		this.pdtSaleCnt = pdtSaleCnt;
		this.pdtSupply = pdtSupply;
		this.pdtAddition = pdtAddition;
		this.pdtSaleSum = pdtSaleSum;
		this.pdtMarginRate = pdtMarginRate;
		this.pdtMarginSum = pdtMarginSum;
	}

	public Product(int pdtSupplySum, int pdtAddtionSum, int pdtSaleAmountSum, int pdtMarginAmountSum) {
		this.pdtSupplySum = pdtSupplySum;
		this.pdtAddtionSum = pdtAddtionSum;
		this.pdtSaleAmountSum = pdtSaleAmountSum;
		this.pdtMarginAmountSum = pdtMarginAmountSum;
	}

	public String getPdtCode() {
		return pdtCode;
	}

	public void setPdtCode(String pdtCode) {
		this.pdtCode = pdtCode;
	}
	
	public Sale getPdtName() {
		return pdtName;
	}

	public void setPdtName(Sale pdtName) {
		this.pdtName = pdtName;
	}

	public int getPdtPrice() {
		return pdtPrice;
	}

	public void setPdtPrice(int pdtPrice) {
		this.pdtPrice = pdtPrice;
	}

	public int getPdtSaleCnt() {
		return pdtSaleCnt;
	}

	public void setPdtSaleCnt(int pdtSaleCnt) {
		this.pdtSaleCnt = pdtSaleCnt;
	}

	public int getPdtMarginRate() {
		return pdtMarginRate;
	}

	public void setPdtMarginRate(int pdtMarginRate) {
		this.pdtMarginRate = pdtMarginRate;
	}

	public int getPdtRank() {
		return pdtRank;
	}

	public void setPdtRank(int pdtRank) {
		this.pdtRank = pdtRank;
	}

	public int getPdtSupply() {
		return pdtSupply;
	}

	public void setPdtSupply(int pdtSupply) {
		this.pdtSupply = pdtSupply;
	}

	public int getPdtAddition() {
		return pdtAddition;
	}

	public void setPdtAddition(int pdtAddition) {
		this.pdtAddition = pdtAddition;
	}

	public int getPdtSaleSum() {
		return pdtSaleSum;
	}

	public void setPdtSaleSum(int pdtSaleSum) {
		this.pdtSaleSum = pdtSaleSum;
	}

	public int getPdtMarginSum() {
		return pdtMarginSum;
	}

	public void setPdtMarginSum(int pdtMarginSum) {
		this.pdtMarginSum = pdtMarginSum;
	}

	public int getPdtSupplySum() {
		return pdtSupplySum;
	}

	public void setPdtSupplySum(int pdtSupplySum) {
		this.pdtSupplySum = pdtSupplySum;
	}

	public int getPdtAddtionSum() {
		return pdtAddtionSum;
	}

	public void setPdtAddtionSum(int pdtAddtionSum) {
		this.pdtAddtionSum = pdtAddtionSum;
	}

	public int getPdtSaleAmountSum() {
		return pdtSaleAmountSum;
	}

	public void setPdtSaleAmountSum(int pdtSaleAmountSum) {
		this.pdtSaleAmountSum = pdtSaleAmountSum;
	}

	public int getPdtMarginAmountSum() {
		return pdtMarginAmountSum;
	}

	public void setPdtMarginAmountSum(int pdtMarginAmountSum) {
		this.pdtMarginAmountSum = pdtMarginAmountSum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pdtAddition;
		result = prime * result + pdtAddtionSum;
		result = prime * result + ((pdtCode == null) ? 0 : pdtCode.hashCode());
		result = prime * result + pdtMarginAmountSum;
		result = prime * result + pdtMarginRate;
		result = prime * result + pdtMarginSum;
		result = prime * result + ((pdtName == null) ? 0 : pdtName.hashCode());
		result = prime * result + pdtPrice;
		result = prime * result + pdtRank;
		result = prime * result + pdtSaleAmountSum;
		result = prime * result + pdtSaleCnt;
		result = prime * result + pdtSaleSum;
		result = prime * result + pdtSupply;
		result = prime * result + pdtSupplySum;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (pdtAddition != other.pdtAddition)
			return false;
		if (pdtAddtionSum != other.pdtAddtionSum)
			return false;
		if (pdtCode == null) {
			if (other.pdtCode != null)
				return false;
		} else if (!pdtCode.equals(other.pdtCode))
			return false;
		if (pdtMarginAmountSum != other.pdtMarginAmountSum)
			return false;
		if (pdtMarginRate != other.pdtMarginRate)
			return false;
		if (pdtMarginSum != other.pdtMarginSum)
			return false;
		if (pdtName == null) {
			if (other.pdtName != null)
				return false;
		} else if (!pdtName.equals(other.pdtName))
			return false;
		if (pdtPrice != other.pdtPrice)
			return false;
		if (pdtRank != other.pdtRank)
			return false;
		if (pdtSaleAmountSum != other.pdtSaleAmountSum)
			return false;
		if (pdtSaleCnt != other.pdtSaleCnt)
			return false;
		if (pdtSaleSum != other.pdtSaleSum)
			return false;
		if (pdtSupply != other.pdtSupply)
			return false;
		if (pdtSupplySum != other.pdtSupplySum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"순위 : %s, 코드 : %s, 제품이름 : %s, %n"
				+ "가격 : %s, pdtSaleCnt=%s, pdtSupply=%s, pdtAddition=%s, pdtSaleSum=%s, pdtMarginRate=%s, pdtMarginSum=%s, pdtSupplySum=%s, pdtAddtionSum=%s, pdtSaleAmountSum=%s, pdtMarginAmountSum=%s",
				pdtRank, pdtCode, pdtName, pdtPrice, pdtSaleCnt, pdtSupply, pdtAddition, pdtSaleSum, pdtMarginRate,
				pdtMarginSum, pdtSupplySum, pdtAddtionSum, pdtSaleAmountSum, pdtMarginAmountSum);
	}

}
