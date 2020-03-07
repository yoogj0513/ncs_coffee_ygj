package ncs_coffee_ygj.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import ncs_coffee_ygj.dto.Product;
import ncs_coffee_ygj.ui.service.ProductUiService;

@SuppressWarnings("serial")
public class MarginRankintUiPanel extends JPanel {
	private ProductUiService service;
	private JPanel pContent;
	private JPanel pConTit;
	private JPanel pConList;
	private JPanel pConSum;
	private JLabel lblList;
	
	private int center = SwingConstants.CENTER;
	private int right = SwingConstants.RIGHT;
	private JLabel lblSum;

	public MarginRankintUiPanel() {
		service = new ProductUiService();
		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pTitle = new JPanel();
		pTitle.setBorder(new EmptyBorder(10, 0, 10, 0));
		add(pTitle, BorderLayout.NORTH);
		pTitle.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblTitle = new JLabel("마진액순위");
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pTitle.add(lblTitle);
		
		pContent = new JPanel();
		pContent.setBorder(new EmptyBorder(0, 15, 5, 15));
		add(pContent);
		pContent.setLayout(new BoxLayout(pContent, BoxLayout.Y_AXIS));
		
		pConTit = new JPanel();
		pConTit.setBorder(new MatteBorder(1, 0, 1, 0, (Color) Color.GRAY));
		pContent.add(pConTit);
		pConTit.setLayout(new GridLayout(0, 10, 5, 5));
		
		pConList = new JPanel();
		pConList.setBorder(new EmptyBorder(10, 0, 10, 0));
		pContent.add(pConList);
		pConList.setLayout(new GridLayout(0, 10, 5, 5));
		
		pConSum = new JPanel();
		pConSum.setBorder(new MatteBorder(1, 0, 1, 0, (Color) Color.GRAY));
		pContent.add(pConSum);
		pConSum.setLayout(new GridLayout(0, 10, 5, 5));
		
		getTitle();
		getRanking();
		getSum();
	}
	
	public void getSum() {
		Product resSum = service.showProductSumList();
		String[] sum = {"합계", "", "", "", "", 
						String.format("%,d", resSum.getPdtSupplySum()), 
						String.format("%,d", resSum.getPdtAddtionSum()), 
						String.format("%,d", resSum.getPdtSaleAmountSum()), 
						"", 
						String.format("%,d", resSum.getPdtMarginAmountSum())};
		lblSum = new JLabel(sum[0]);
		PaneAdd(pConSum, lblSum, center);
		for(int i=0; i<sum.length-1; i++) {
			lblSum = new JLabel(sum[i+1]);
			PaneAdd(pConSum, lblSum, right);
		}
		
		
	}
	
	public void getTitle() {
		String[] title = {"순위", "제품코드", "제품명", "제품단가", "판매수량", "공급가액", "부가세액", "판매금액", "마진율", "마진액"};
		for(int i=0; i<title.length; i++) {
			JLabel lblTitle = new JLabel(title[i]);
			PaneAdd(pConTit, lblTitle, center);
		}
	}

	public void getRanking() {
		List<Product> list = service.showProductMarginRankList();
		for(int i=0; i<list.size(); i++) {
			lblList =  new JLabel(list.get(i).getPdtRank()+"");
			PaneAdd(pConList, lblList, center);
			
			lblList = new JLabel(list.get(i).getPdtCode());
			PaneAdd(pConList, lblList, center);
			
			lblList = new JLabel(list.get(i).getPdtName().getProductName());
			PaneAdd(pConList, lblList, center);
			
			lblList = new JLabel(String.format("%,d", list.get(i).getPdtPrice()));
			PaneAdd(pConList, lblList, right);
			
			lblList = new JLabel(String.format("%,d", list.get(i).getPdtSaleCnt()));
			PaneAdd(pConList, lblList, right);
			
			lblList = new JLabel(String.format("%,d", list.get(i).getPdtSupply()));
			PaneAdd(pConList, lblList, right);
			
			lblList = new JLabel(String.format("%,d", list.get(i).getPdtAddition()));
			PaneAdd(pConList, lblList, right);
			
			lblList = new JLabel(String.format("%,d", list.get(i).getPdtSaleSum()));
			PaneAdd(pConList, lblList, right);
			
			lblList = new JLabel(String.format("%,d", list.get(i).getPdtMarginRate()));
			PaneAdd(pConList, lblList, right);
			
			lblList = new JLabel(String.format("%,d", list.get(i).getPdtMarginSum()));
			PaneAdd(pConList, lblList, right);
		}
	}
	
	public void PaneAdd(JPanel panel, JLabel lbl, int Alig) {
		lbl.setHorizontalAlignment(Alig);
		panel.add(lbl);
	}
}
