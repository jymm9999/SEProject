package OrderSystem;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NonClientInfoForm extends JPanel{
	
	private ClientControlForm F;

	private JLabel _title, _name, _address, _phone;
	private JTextField  name, address, phone;

	private JButton check_Button;

	private JPanel title_field, name_field,  address_field, phone_field, 
	               information_field, entire_field;
	
	private String  confirmName="", confirmAddress="", confirmPhone="";
	private String nonCustomerInfo="";
	
	public NonClientInfoForm(ClientControlForm f) {
		
		F = f;
		
		_title= new JLabel("비회원 주문 정보 입력");
		_name= new JLabel("이 름");
		_address= new JLabel("주 소");
		_phone= new JLabel("번 호 ");
		
		name = new JTextField(10);
		address = new JTextField(10);
		phone = new JTextField(10);
		
		//확인 버튼 
		check_Button= new JButton("확 인");
		check_Button.addActionListener(new ActionListener(){		//확인 ACTION
            public void actionPerformed(ActionEvent e) {
            	
            	nonCustomerInfo = "";
            	
        		confirmName = name.getText();		//입력 데이터를 변수에 저장하는 부분
        		confirmAddress = address.getText();
        		confirmPhone = phone.getText();
            	
            	if(e.getSource() == check_Button){
            		if(!(confirmName.isEmpty()) && !(confirmAddress.isEmpty()) && !(confirmPhone.isEmpty())){
            			
            			nonCustomerInfo += confirmName + "/";
            			nonCustomerInfo += confirmAddress + "/";
            			nonCustomerInfo += confirmPhone;
            			
            			NonOrderManager.getNonClientInfo(nonCustomerInfo);
            			F.changePanel("NonClientMenuForm");
            		}
            	}
            }
        });


		
		
// 패널 붙이는 부분 ----------------------------------------------------------------------
	    name_field = new JPanel();
		address_field = new JPanel(); phone_field = new JPanel();
		information_field = new JPanel(); title_field = new JPanel();
		entire_field = new JPanel();
		
		title_field.add(_title);
		name_field.add(_name);       name_field.add(name);
		address_field.add(_address); address_field.add(address);
		phone_field.add(_phone);     phone_field.add(phone);
		information_field.setLayout(new BoxLayout(information_field, BoxLayout.Y_AXIS));
	    information_field.add(name_field);
		information_field.add(address_field); information_field.add(phone_field);
		information_field.add(check_Button);
		entire_field.setLayout(new BoxLayout(entire_field, BoxLayout.Y_AXIS));
		entire_field.add(title_field); entire_field.add(information_field);
		
	
		add(entire_field);
		setVisible(true);
//--------------------------------------------------------------------------------------
		
		
	}
	

}

