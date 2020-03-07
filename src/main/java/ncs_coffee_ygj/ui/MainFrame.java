package ncs_coffee_ygj.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ncs_coffee_ygj.dto.Product;
import ncs_coffee_ygj.dto.Sale;
import ncs_coffee_ygj.ui.exception.InvalidCheckException;
import ncs_coffee_ygj.ui.service.ProductUiService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements FocusListener, ActionListener {

	private JPanel contentPane;
	private JTextField tfCode;
	private JTextField tfPrice;
	private JTextField tfSaleCnt;
	private JTextField tfMargin;
	private JLabel lblNewLabel;
	private ProductUiService service;
	private JButton btnAdd;
	private JButton btnOutput1;
	private JFrame frame1;
	private JFrame frame2;
	private JButton btnOutput2;
	private PriceRankintUiPanel prp;
	private MarginRankintUiPanel mrp;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MainFrame() {
		service = new ProductUiService();
		initialize();
	}
	private void initialize() {
		setTitle("프랜차이즈 커피전문점 상품별 판매실적 계산 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pMain = new JPanel();
		pMain.setBorder(new EmptyBorder(10, 30, 10, 30));
		contentPane.add(pMain, BorderLayout.CENTER);
		pMain.setLayout(new GridLayout(0, 4, 10, 10));
		
		JLabel lblCode = new JLabel("제품코드 :");
		lblCode.setHorizontalAlignment(SwingConstants.RIGHT);
		pMain.add(lblCode);
		
		tfCode = new JTextField();
		tfCode.addFocusListener(this);
		pMain.add(tfCode);
		tfCode.setColumns(10);
		
		JLabel lblMargin = new JLabel("제품명 : ");
		lblMargin.setHorizontalAlignment(SwingConstants.RIGHT);
		pMain.add(lblMargin);
		
		lblNewLabel = new JLabel();
		pMain.add(lblNewLabel);
		
		JLabel lblName = new JLabel("제품단가 : ");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		pMain.add(lblName);
		
		tfPrice = new JTextField();
		tfPrice.addKeyListener(myKeyListener(tfPrice));
		pMain.add(tfPrice);
		tfPrice.setColumns(10);
		
		JLabel lblnone1 = new JLabel();
		pMain.add(lblnone1);
		
		JLabel lblnone4 = new JLabel();
		pMain.add(lblnone4);
		
		JLabel lblPrice = new JLabel("판매수량 : ");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		pMain.add(lblPrice);
		
		tfSaleCnt = new JTextField();
		tfSaleCnt.addKeyListener(myKeyListener(tfSaleCnt));
		tfSaleCnt.setColumns(10);
		pMain.add(tfSaleCnt);
		
		JLabel lblnone5 = new JLabel();
		pMain.add(lblnone5);
		
		JLabel lblnone3 = new JLabel();
		pMain.add(lblnone3);
		
		JLabel lblSaleCnt = new JLabel("마진율 : ");
		lblSaleCnt.setHorizontalAlignment(SwingConstants.RIGHT);
		pMain.add(lblSaleCnt);
		
		tfMargin = new JTextField();
		tfMargin.addKeyListener(myKeyListener(tfMargin));
		tfMargin.setColumns(10);
		pMain.add(tfMargin);
		
		JLabel lblnone6 = new JLabel();
		pMain.add(lblnone6);
		
		JLabel lblnone2 = new JLabel();
		pMain.add(lblnone2);
		
		JPanel pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);
		
		btnAdd = new JButton("입력");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);
		
		btnOutput1 = new JButton(" 출력1");
		btnOutput1.addActionListener(this);
		pBtns.add(btnOutput1);
		
		btnOutput2 = new JButton("출력2");
		btnOutput2.addActionListener(this);
		pBtns.add(btnOutput2);
	}


	private KeyListener myKeyListener(JTextField thisTf) {
		return new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				String str = thisTf.getText();
				int cnt = str.length();
				if(cnt > 7) {
					thisTf.setText("");
					JOptionPane.showMessageDialog(null, "숫자 8자리까지 입력 가능합니다");
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
			}
		};
	}

	public void focusGained(FocusEvent e) {
	}
	
	public void focusLost(FocusEvent e) {
		if (e.getSource() == tfCode) {
			tfCodeFocusLost(e);
		}
	}
	protected void tfCodeFocusLost(FocusEvent e) {
		String inCode = new String(tfCode.getText());
		if(inCode.length() == 0) {
			lblNewLabel.setText("");
		} else {
			try {
				String getName = service.getProductName(new Sale(inCode)).getProductName();
				lblNewLabel.setText(getName);
			} catch (Exception e1) {
				lblNewLabel.setText("");
				JOptionPane.showMessageDialog(null, "입력된 제품 코드가 없습니다.\n다시 입력해주세요.");
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOutput2) {
			btnOutput2ActionPerformed(e);
		}
		if (e.getSource() == btnOutput1) {
			btnOutput1ActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}
	protected void btnAddActionPerformed(ActionEvent e) {
		try {
			Product newPdt = getItem();
			if(service.checkProductCode(newPdt)) {				
				service.addProduct(newPdt);
			} else {
				JOptionPane.showMessageDialog(null, "판매실적이 저장된 제품입니다.");
			}
			clearTf();
		} catch (InvalidCheckException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(null, "제품단가, 판매수량, 마진율은 숫자로 입력해주세요.");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public Product getItem() {
		validCheck();
		String pdtCode = tfCode.getText().trim();
		int pdtPrice = Integer.parseInt(tfPrice.getText().trim());
		int pdtSaleCnt = Integer.parseInt(tfSaleCnt.getText().trim());
		int pdtMarginRate = Integer.parseInt(tfMargin.getText().trim());
		return new Product(pdtCode, pdtPrice, pdtSaleCnt, pdtMarginRate);
	}

	public void clearTf() {
		tfCode.setText("");
		tfPrice.setText("");
		tfSaleCnt.setText("");
		tfMargin.setText("");
		lblNewLabel.setText("");
	}

	private void validCheck() {
		if(tfCode.getText().contentEquals("") || tfPrice.getText().contentEquals("") || tfSaleCnt.getText().contentEquals("") || 
				tfMargin.getText().contentEquals("")) {
			throw new InvalidCheckException();
		}
	}
	
	protected void btnOutput1ActionPerformed(ActionEvent e) {
		if(frame1 == null) {
			frame1 = new JFrame();
			frame1.setBounds(100, 100, 800, 300);
			frame1.setTitle("판매금액순위");
			prp = new PriceRankintUiPanel();
			frame1.getContentPane().add(prp);
			frame1.setVisible(true);
		} else {
			if(frame1.isVisible()) {
				return;
			}
			frame1 = new JFrame();
			frame1.setBounds(100, 100, 800, 300);
			frame1.setTitle("판매금액순위");
			prp = new PriceRankintUiPanel();
			frame1.getContentPane().add(prp);
			frame1.setVisible(true);
		}
	}
	protected void btnOutput2ActionPerformed(ActionEvent e) {
		if(frame2 == null) {
			frame2 = new JFrame();
			frame2.setBounds(100, 100, 800, 300);
			frame2.setTitle("마진액순위");
			mrp = new MarginRankintUiPanel();
			frame2.getContentPane().add(mrp);
			frame2.setVisible(true);
		} else {
			if(frame1.isVisible()) {
				return;
			}
			frame2 = new JFrame();
			frame2.setBounds(100, 100, 800, 300);
			frame2.setTitle("마진액순위");
			mrp = new MarginRankintUiPanel();
			frame2.getContentPane().add(prp);
			frame2.setVisible(true);
		}
	}
}
