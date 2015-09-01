package CustomerInfoManagementSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import OrderSystem.ClientControlForm;
import OrderSystem.OrderManager;

public class SignupForm extends JPanel{

	private ClientControlForm F;
	
	private JLabel _title, _id, _pw, _pwcheck, _name, _address, _phone;
	private JTextField id, name, address, phone;
	private JPasswordField pw, pwcheck;
	private JButton signUp_Button;

	private JPanel title_field, id_field, pw_field, pwcheck_field, name_field, 
	       address_field, phone_field, information_field,entire_field;
	
	private String confirmId="", confirmPw="", confirmPwcheck="", confirmName="", confirmAddress="", confirmPhone="";
	private String customerInfo="";
	
	public SignupForm(ClientControlForm f) {
		_id = new JLabel("ID ");
		_pw = new JLabel("PW");
		_pwcheck= new JLabel("PW Check");
		_title= new JLabel("ȸ�� ����");
		_name= new JLabel("�� ��");
		_address= new JLabel("�� ��");
		_phone= new JLabel("�� ȣ ");
		
		id = new JTextField(10);
		pw = new JPasswordField(10);
		pwcheck = new JPasswordField(10);
		name = new JTextField(10);
		address = new JTextField(10);
		phone = new JTextField(10);
		
		F = f;
		
		//���� �ϱ� ��ư 
		signUp_Button= new JButton("���� �ϱ�");
		
		signUp_Button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource() == signUp_Button){
            		
            		customerInfo = "";
            		
            		confirmId = id.getText();		//�Է� �����͸� ������ �����ϴ� �κ�
            		confirmPw = new String(pw.getPassword());
            		confirmPwcheck = new String(pwcheck.getPassword());
            		confirmName = name.getText();
            		confirmAddress = address.getText();
            		confirmPhone = phone.getText();
            		
					if (!(confirmId.isEmpty()) && !(confirmPw.isEmpty())
							&& !(confirmPwcheck.isEmpty())
							&& !(confirmName.isEmpty())
							&& !(confirmAddress.isEmpty())
							&& !(confirmPhone.isEmpty())
							&& confirmPw.equals(confirmPwcheck)) {

						customerInfo += confirmId + "/";
						customerInfo += confirmPw + "/";
						customerInfo += confirmName + "/";
						customerInfo += confirmAddress + "/";
						customerInfo += confirmPhone;

						OrderManager.getRegister(customerInfo);
						F.changePanel("CustomerStartForm");
					}

				}

            }
        });
		
		
// �г� ���̴� �κ� ----------------------------------------------------------------------
		id_field = new JPanel(); pw_field = new JPanel(); 
		pwcheck_field = new JPanel(); name_field = new JPanel();
		address_field = new JPanel(); phone_field = new JPanel();
		information_field = new JPanel(); title_field = new JPanel();
		entire_field = new JPanel();
		
		id_field.add(_id); id_field.add(id);
		pw_field.add(_pw); pw_field.add(pw);
		pwcheck_field.add(_pwcheck); pwcheck_field.add(pwcheck);
		name_field.add(_name); name_field.add(name);
		address_field.add(_address); address_field.add(address);
		phone_field.add(_phone); phone_field.add(phone);
		title_field.add(_title);
		information_field.setLayout(new BoxLayout(information_field, BoxLayout.Y_AXIS));
		information_field.add(id_field);information_field.add(pw_field);
		information_field.add(pwcheck_field);
		information_field.add(name_field);information_field.add(address_field);
		information_field.add(phone_field);information_field.add(signUp_Button);
		
		entire_field.setLayout(new BoxLayout(entire_field, BoxLayout.Y_AXIS));
		entire_field.add(title_field); entire_field.add(information_field);
		add(entire_field);
		setVisible(true);
//--------------------------------------------------------------------------------------
		
		
	}
	

}
