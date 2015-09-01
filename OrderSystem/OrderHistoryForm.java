package OrderSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OrderHistoryForm extends JPanel{
	
	private ClientControlForm F;
	
	JPanel OrderHistoryPanel;
	JPanel OrderHistoryTopPanel;		//이게 영준이가 원하는 위에꺼
	JPanel OrderHistoryMenuPanel;		
	JPanel OrderHistoryPricePanel;
	JPanel OrderHistoryPriceEachPanel;
	JPanel OrderHistoryPriceSumPanel;
	JPanel OrderHistoryLeftPanel;
	JPanel OrderHistoryRightPanel;
	JPanel OrderHistoryMenuScrollPanel;
	JPanel OrderHistoryLeftMediumPanel;
	
	JButton OrderHistoryMenuButton;
	JButton OrderHistoryPreviuosOrderButton;
	JButton OrderHistoryEditCustomerInfoButton;
	JButton OrderHistoryOrderButton;
	JButton OrderHistoryPreviuosButton;
	JButton OrderHistoryLogOutButton;
	
	JLabel OrderHistoryMenuPriceLabel;
	JLabel OrderHistoryIDLabel;	
	
	JScrollPane OrderHistoryMenuScrollPane;

	public OrderHistoryForm(ClientControlForm f){
		
		setSize(800, 600);
		
		F = f;
		
		OrderHistoryPanel = new JPanel();
		OrderHistoryTopPanel = new JPanel();
		OrderHistoryMenuPanel = new JPanel();
		OrderHistoryPricePanel = new JPanel();
		OrderHistoryPriceSumPanel = new JPanel();
		OrderHistoryLeftPanel = new JPanel();
		OrderHistoryRightPanel = new JPanel();
		OrderHistoryMenuScrollPanel = new JPanel();
		OrderHistoryLeftMediumPanel = new JPanel();
		
		OrderHistoryIDLabel = new JLabel();
		OrderHistoryIDLabel.setText("ID : " + "");//여기에 아이디 가져오기
		OrderHistoryPreviuosOrderButton = new JButton("이전 주문 내역");
		OrderHistoryPreviuosOrderButton.addActionListener(new ActionListener(){		//회원정보수정 ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("OrderHistoryForm");
            }
        });
		
		OrderHistoryEditCustomerInfoButton = new JButton("회원정보수정");
		OrderHistoryEditCustomerInfoButton.addActionListener(new ActionListener(){		//회원정보수정 ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("EditCustomerForm");
            }
        });

		OrderHistoryLogOutButton = new JButton("로그 아웃");
		OrderHistoryLogOutButton.addActionListener(new ActionListener(){		//회원정보수정 ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("CustomerStartForm");
            }
        });
		
		OrderHistoryTopPanel.add(OrderHistoryIDLabel);
		OrderHistoryTopPanel.add(OrderHistoryPreviuosOrderButton);
		OrderHistoryTopPanel.add(OrderHistoryEditCustomerInfoButton);
		OrderHistoryTopPanel.add(OrderHistoryLogOutButton);
		
		
		OrderHistoryTopPanel.setPreferredSize(new Dimension(450, 50));
		
		OrderHistoryPreviuosButton = new JButton("이전으로");
		OrderHistoryLeftMediumPanel.add(OrderHistoryPreviuosButton);
		OrderHistoryLeftMediumPanel.setPreferredSize(new Dimension(450, 50));
		
		OrderHistoryPreviuosButton.addActionListener(new ActionListener(){		//이전으로 ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("ClientMenuForm");
            }
        });
				
		OrderHistoryMenuScrollPane = new JScrollPane(OrderHistoryMenuScrollPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		OrderHistoryMenuScrollPane.setPreferredSize(new Dimension(450, 400));
		OrderHistoryMenuScrollPanel.setPreferredSize(new Dimension(450, 5000));
		
		int size = 50;
		for(int i = 0 ; i<size;i++){
			OrderHistoryMenuButton = new JButton();
			OrderHistoryMenuButton.setText(""+i);	//여기에 메뉴 정보
			OrderHistoryMenuButton.setPreferredSize(new Dimension(180, 180));
			OrderHistoryMenuScrollPanel.add(OrderHistoryMenuButton);
		}
		
		OrderHistoryMenuPanel.add(OrderHistoryMenuScrollPane);
		
		OrderHistoryLeftPanel.add(OrderHistoryTopPanel);
		OrderHistoryLeftPanel.add(OrderHistoryLeftMediumPanel);
		OrderHistoryLeftPanel.add(OrderHistoryMenuPanel);
		OrderHistoryLeftPanel.setPreferredSize(new Dimension(450, 800));
		

		OrderHistoryPricePanel.setLayout(new BoxLayout(OrderHistoryPricePanel, BoxLayout.Y_AXIS));
		
		
		for(int i = 0 ; i<size;i++){
			OrderHistoryMenuPriceLabel = new JLabel();
			OrderHistoryMenuPriceLabel.setText(""+i);
			
			OrderHistoryPricePanel.add(OrderHistoryMenuPriceLabel);
		}
		OrderHistoryPricePanel.setPreferredSize(new Dimension(300, 500));
		
		OrderHistoryMenuPriceLabel = new JLabel();
		OrderHistoryMenuPriceLabel.setText("총 합 : "+" 원");
		OrderHistoryOrderButton = new JButton("주문");
		OrderHistoryOrderButton.addActionListener(new ActionListener(){		//주문 ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("TotalOrderInfoForm");
            }
        });
		
		OrderHistoryPriceSumPanel.add(OrderHistoryMenuPriceLabel);
		OrderHistoryPriceSumPanel.add(OrderHistoryOrderButton);
		OrderHistoryPriceSumPanel.setPreferredSize(new Dimension(300, 200));
		
		OrderHistoryRightPanel.add(OrderHistoryPricePanel);
		OrderHistoryRightPanel.add(OrderHistoryPriceSumPanel);
		OrderHistoryRightPanel.setPreferredSize(new Dimension(300, 800));
		
		
		OrderHistoryPanel.add(OrderHistoryLeftPanel);
		OrderHistoryPanel.add(OrderHistoryRightPanel);
		
		
		setVisible(true);
		add(OrderHistoryPanel);
	}
	
}
