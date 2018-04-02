package com.shahriyer;
import java.awt.*;
import javax.swing.*;

import com.masrur.login.Reg;
import com.masrur.login.forgotP;

import java.io.*;
import java.awt.event.*;
import java.sql.*;

@SuppressWarnings("serial")
public class logGraphics extends JFrame implements ActionListener
{
    
    JFrame flash, working;
    Container con;
    JLabel uname, passw;
    JTextField uname_f;
    JPasswordField passw_f;
    JButton login, forgot;
    JPanel titleNamePanel,common;
    Connection con1;
    PreparedStatement st;
    ResultSet ps;
    public logGraphics()throws Exception{
        //FONT
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Pixel Font/pixelmix.ttf")));
        } catch (IOException|FontFormatException e) {
            //Handle exception
        }
        Font normalFont = new Font("pixelmix", Font.PLAIN, 28);
        
        //FRAME
        flash = new JFrame();
        setContentPane(new JLabel(new ImageIcon("logopix.jpg")));
        flash.setSize(800, 600);
        flash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //FRAME SET VISIBLE
        flash.setVisible(true);
        con = flash.getContentPane();
        
//    titleNamePanel = new JPanel();
//    titleNamePanel.setBounds(100, 100, 700, 300);
//    BufferedImage myPicture = ImageIO.read(new File("logopix.jpg"));
//    JLabel picLabel = new JLabel(new ImageIcon(myPicture));
//    titleNamePanel.add(picLabel);
        
        
        //IMAGE ICON
        flash.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.jpg")));
        flash.setTitle("AAY CNG!");
        
        //LOGIN
        common = new JPanel(new GridLayout(4,2,10,5));
        uname = new JLabel("Username");
        //uname.setForeground(Color.white);
        uname.setFont(normalFont);
        passw = new JLabel("Password");
        passw.setFont(normalFont);
        //passw.setForeground(Color.white);
        uname_f = new JTextField(10);
        passw_f = new JPasswordField(10);
        login = new JButton("Login");
        forgot = new JButton("Forgot");
        
        common.add(uname);
        common.add(uname_f);
        common.add(passw);
        
        common.add(passw_f);
        common.add(login);
        common.add(forgot);
        flash.add(common);
        
        flash.pack();
        login.addActionListener(this);
        forgot.addActionListener(this);
        
    }
    public void  actionPerformed(ActionEvent ae){
        try{
            actionPerformedCustom(ae);
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    @SuppressWarnings("deprecation")
 public void actionPerformedCustom(ActionEvent ae) throws Exception{
        //System.out.println(uname_f.getText());
        // System.out.println(uname_f.getText());
        con1=Reg.con;
        String act=ae.getActionCommand();
        String user1=uname_f.getText();
        
        st=con1.prepareStatement("select * from userlogin where username=?");
        st.setString(1,user1);
        ps=st.executeQuery();
        
        if(act.equals(login.getLabel())){
            //Scanner sc=new Scanner(System.in);
            
            
            String pass1=passw_f.getText();
            System.out.println(pass1);
            if(ps.next() && pass1.equals(ps.getString("password"))){
                JFrame frame = new JFrame("Congratulation");
                
                
                JOptionPane.showMessageDialog(frame,"Welcome "+user1);
                setVisible(false);
                new MainGame();
                
                
            }
            else{
                JFrame frame = new JFrame("Sorry");
                
                
                JOptionPane.showMessageDialog(frame,"Wrong Password or Username" );
            }
            
        }
        else if(act.equals(forgot.getLabel())){
            setVisible(false);
            forgotP.pset(st,ps,con1,user1);
            
        }
    }
    
}