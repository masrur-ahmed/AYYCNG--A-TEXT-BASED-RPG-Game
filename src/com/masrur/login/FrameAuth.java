/**
 * 
 */
package com.masrur.login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
@SuppressWarnings("serial")
public class FrameAuth  extends JFrame implements ActionListener{
    static PreparedStatement st;
    static ResultSet ps;
    static Connection con;
    static String user1;
    String maild;
    JButton re,bt;
    JTextField tf,pass;
    JPasswordField changepass,changepass1;
    public FrameAuth() throws SQLException{
        JLabel lb=new JLabel("Enter Code");
        tf=new JTextField(5);
        JLabel lb2=new JLabel("Enter new Password");
        changepass=new JPasswordField(5);
        JLabel lb3=new JLabel("confirm new Password");
        changepass1=new JPasswordField(5);
        bt=new JButton("Change Password");
        re=new JButton("Resend");
        // maild=ps.getString("mail");
        
        setLayout(new GridLayout(5,2));
        add(lb);
        add(tf);
        add(lb2);
        add(changepass);
        add(lb3);
        add(changepass1);
        add(re);
        add(bt);
        
        bt.addActionListener(this);
        re.addActionListener(this);
    }
    public void setCon(PreparedStatement st,ResultSet ps,Connection con,String user1){
        FrameAuth.st=st;
        FrameAuth.ps=ps;
        FrameAuth.con=con;
        FrameAuth.user1=user1;
    }
    
    @SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae){
        //System.out.println("ActinCust");
        System.out.println("ActinCust52" + user1);
        try { String act=ae.getActionCommand();
        if(act.equals(re.getLabel())){
            forgotP.pset(st,ps,con,user1);
            setVisible(false);
        }
        else{
            //System.out.println("ActinCust52");
            st=con.prepareStatement("select * from userlogin where username=?");
            st.setString(1,user1);
            ps=st.executeQuery();
            ps.next();
            if(tf.getText().equals(ps.getInt("id")+"")){
                if(changepass.getText().equals(changepass1.getText())){
                    st=con.prepareStatement("update userlogin set password=? where username=?");
                    st.setString(1,changepass.getText());
                    st.setString(2,user1);
                    
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(new JFrame(),"password changed successfully");
                    setVisible(false);
                }
                else {
                JOptionPane.showMessageDialog(new JFrame(),"password did not match ");
                }
            }
            else{
            JOptionPane.showMessageDialog(new JFrame(),"wrong code entered");
            }
        }
        }catch(Exception e) {
        System.out.println(e);
        }
    }
}