package CustomerInfoManagementSystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import OrderSystem.ClientControlForm;
import OrderSystem.NonOrderManager;

public class EditCustomerForm extends JPanel{
	
	private ClientControlForm F;

	private JPanel info_field, title_field, name_field,  address_field, phone_field, 
    information_field, entire_field;
	private JTextField  name, address, phone;

	private JButton edit_Button, orderHistory_Button, editInfo_Button;
	private JLabel _title, _name, _address, _phone, id_name;
	
	private String  confirmName="", confirmAddress="", confirmPhone="";
	private String customerInfo="";
	
	public EditCustomerForm(ClientControlForm f) {
		F = f;
		
		info_field = new JPanel();	title_field = new JPanel();
		name_field = new JPanel();address_field = new JPanel(); 
		phone_field = new JPanel();information_field = new JPanel();
		title_field = new JPanel();entire_field = new JPanel();
		
		edit_Button = new JButton("���� �Ϸ�");
		
		edit_Button.addActionListener(new ActionListener(){		//�����Ϸ� ACTION
            public void actionPerformed(ActionEvent e) {
            	customerInfo = "";
            	
        		confirmName = name.getText();		//�Է� �����͸� ������ �����ϴ� �κ�
        		confirmAddress = address.getText();
        		confirmPhone = phone.getText();
            	
            	if(e.getSource() == edit_Button){
            		if(!(confirmName.isEmpty()) && !(confirmAddress.isEmpty()) && !(confirmPhone.isEmpty())){
            			
            			customerInfo += confirmName + "/";
            			customerInfo += confirmAddress + "/";
            			customerInfo += confirmPhone;
            			
            			EditInformationManager.getClientInfo(customerInfo);
            			F.changePanel("ClientMenuForm");
            		}
            	}
            		
            }
        });
		
		orderHistory_Button = new JButton("�����ֹ�����");
		
		orderHistory_Button.addActionListener(new ActionListener(){		//�����ֹ����� ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("OrderHistoryForm");
            }
        });
		
		editInfo_Button = new JButton("ȸ����������");
		
		editInfo_Button.addActionListener(new ActionListener(){		//ȸ���������� ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("EditCustomerForm");
            }
        });
		
		_title= new JLabel("ȸ�� ���� ����");
		_name= new JLabel("�� ��");
		_address= new JLabel("�� ��");
		_phone= new JLabel("�� ȣ ");
		id_name = new JLabel("ID : �迵��");
		
		name = new JTextField(10);
		name.setText("");
		address = new JTextField(10);
		phone = new JTextField(10);
		//�Է� �����͸� ������ �����ϴ� �κ�

		confirmName = name.getText();
		confirmAddress = address.getText();
		confirmPhone = phone.getText();
				
	
		//-------------------�г� ���̴� �κ�-----------------------------------------------			
		
		info_field.add(id_name); info_field.add(orderHistory_Button);
		info_field.add(editInfo_Button);
		title_field.add(_title);
		name_field.add(_name); name_field.add(name);
		address_field.add(_address); address_field.add(address);
		phone_field.add(_phone);	phone_field.add(phone);
		information_field.setLayout(new BoxLayout(information_field, BoxLayout.Y_AXIS));
	    information_field.add(name_field);
		information_field.add(address_field); information_field.add(phone_field);
		information_field.add(edit_Button);
		
		entire_field.setLayout(new BoxLayout(entire_field, BoxLayout.Y_AXIS));
		entire_field.add(title_field); entire_field.add(information_field);
		
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(info_field);
		add(title_field);
		add(entire_field);
		
		setVisible(true);
		
		
	}
	
	
}

