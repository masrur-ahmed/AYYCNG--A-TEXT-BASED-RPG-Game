/**
 * 
 */
package com.masrur.login;

import javax.swing.*;
import java.sql.*;
import java.util.*;   
public class forgotP{
    PreparedStatement st;
    Connection con;
    ResultSet ps;
    String user1;
    public static String pset(PreparedStatement st,ResultSet ps,Connection con,String user1) throws Exception{
        
        if(ps.next()){
            String maild=ps.getString("mail");
            JOptionPane.showMessageDialog(new JFrame(),"An email was sent to : "+maild);
            Random rn = new Random();
            int answer = rn.nextInt(100000) + 1;
            System.out.println(maild);
            st=con.prepareStatement("update userlogin set id=? where username=?");
            st.setInt(1,answer);
            st.setString(2,user1);
            st.executeUpdate();
            String msg="Hello, "+user1+"\n"+"Here is your password resetting code : "+answer+" ."+"\n"+"please paste it it to the password resetting box.\nThank You for using our game AYCNG "+"\n \n"+"On Regards\n S. M. Masrur Ahmed \nSoftware Engineer, AYCNG\nSNET";
            Mailer.send("test.mashrur@gmail.com","amiabirlol",maild,"Password Reset Code",msg);
        }   
        new FrameAuth().setCon(st,ps,con,user1);
        JFrame jf=new FrameAuth();
        jf.setVisible(true);
        jf.setSize(600,600);
        return "";
    }
    
}
