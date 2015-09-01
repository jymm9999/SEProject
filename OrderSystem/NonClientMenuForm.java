package OrderSystem;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NonClientMenuForm extends JPanel{

	private ClientControlForm F;
	
	JPanel NonClientMenuPanel;
	JPanel NonClientMenuTopPanel;		//이게 영준이가 원하는 위에꺼
	JPanel NonClientMenuMenuPanel;		
	JPanel NonClientMenuPricePanel;
	JPanel NonClientMenuPriceEachPanel;
	JPanel NonClientMenuPriceSumPanel;
	JPanel NonClientMenuLeftPanel;
	JPanel NonClientMenuRightPanel;
	JPanel NonClientMenuMenuScrollPanel;
	
	JButton NonClientMenuMenuButton;
	JButton NonClientMenuOrderButton;
	
	JLabel NonClientMenuMenuPriceLabel;
	JLabel NonClientMenuIDLabel;	
	
	JScrollPane NonClientMenuMenuScrollPane;
	
	public NonClientMenuForm(ClientControlForm f){
		
		setSize(800, 600);
		
		F = f;
		
		NonClientMenuPanel = new JPanel();
		NonClientMenuTopPanel = new JPanel();
		NonClientMenuMenuPanel = new JPanel();
		NonClientMenuPricePanel = new JPanel();
		NonClientMenuPriceSumPanel = new JPanel();
		NonClientMenuLeftPanel = new JPanel();
		NonClientMenuRightPanel = new JPanel();
		NonClientMenuMenuScrollPanel = new JPanel();
		
		NonClientMenuIDLabel = new JLabel();
		NonClientMenuIDLabel.setText("비회원주문 ");//여기에 아이디 가져오기
		
		NonClientMenuTopPanel.add(NonClientMenuIDLabel);
		
		NonClientMenuTopPanel.setPreferredSize(new Dimension(450, 50));
		
		NonClientMenuMenuScrollPane = new JScrollPane(NonClientMenuMenuScrollPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		NonClientMenuMenuScrollPane.setPreferredSize(new Dimension(450, 400));
		NonClientMenuMenuScrollPanel.setPreferredSize(new Dimension(450, 5000));
		
		int size = 50;
		for(int i = 0 ; i<size;i++){
			NonClientMenuMenuButton = new JButton();
			NonClientMenuMenuButton.setText(""+i);	//여기에 메뉴 정보
			NonClientMenuMenuButton.setPreferredSize(new Dimension(180, 180));
			NonClientMenuMenuScrollPanel.add(NonClientMenuMenuButton);
		}
		
		NonClientMenuMenuPanel.add(NonClientMenuMenuScrollPane);
		
		NonClientMenuLeftPanel.add(NonClientMenuTopPanel);
		NonClientMenuLeftPanel.add(NonClientMenuMenuPanel);
		NonClientMenuLeftPanel.setPreferredSize(new Dimension(450, 800));
		

		NonClientMenuPricePanel.setLayout(new BoxLayout(NonClientMenuPricePanel, BoxLayout.Y_AXIS));
		
		
		for(int i = 0 ; i<size;i++){
			NonClientMenuMenuPriceLabel = new JLabel();
			NonClientMenuMenuPriceLabel.setText(""+i);
			
			NonClientMenuPricePanel.add(NonClientMenuMenuPriceLabel);
		}
		NonClientMenuPricePanel.setPreferredSize(new Dimension(300, 500));
		
		NonClientMenuMenuPriceLabel = new JLabel();
		NonClientMenuMenuPriceLabel.setText("총 합 : "+" 원");
		NonClientMenuOrderButton = new JButton("주문");
		NonClientMenuOrderButton.addActionListener(new ActionListener(){		//회원정보수정 ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("NonTotalOrderInfoForm");
            }
        });
		
		NonClientMenuPriceSumPanel.add(NonClientMenuMenuPriceLabel);
		NonClientMenuPriceSumPanel.add(NonClientMenuOrderButton);
		NonClientMenuPriceSumPanel.setPreferredSize(new Dimension(300, 200));
		
		NonClientMenuRightPanel.add(NonClientMenuPricePanel);
		NonClientMenuRightPanel.add(NonClientMenuPriceSumPanel);
		NonClientMenuRightPanel.setPreferredSize(new Dimension(300, 800));
		
		
		NonClientMenuPanel.add(NonClientMenuLeftPanel);
		NonClientMenuPanel.add(NonClientMenuRightPanel);
		
		
		setVisible(true);
		add(NonClientMenuPanel);
	}
}
