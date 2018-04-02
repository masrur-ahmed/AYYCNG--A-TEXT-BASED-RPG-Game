/**
 * 
 */
package com.masrur.login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.*;
import com.shahriyer.logGraphics;
@SuppressWarnings("serial")
public class Reg extends JFrame implements ActionListener{
    JLabel user,pwd,date,mail,gender,nw;
    JPanel main,dat,genderp,login;
    JButton log,forgot,register;
    JPasswordField pw;
    JTextField us,mai;
    @SuppressWarnings("rawtypes")
 JComboBox mm,dd,yy;
    JRadioButton male,female;
    ButtonGroup bg;
    public static Connection con;
    ResultSet ps;
    @SuppressWarnings("static-access")
 public Reg() throws Exception{
        connectDB();
        setContentPane(new JLabel(new ImageIcon("src\\cng2.gif")));
        user=new JLabel("Username");
        //user.setForeground(Color.red);
        user.setBackground(Color.GRAY);
        user.setForeground(Color.WHITE);
        pwd=new JLabel("Password");
        pwd.setBackground(Color.GRAY);
        pwd.setForeground(Color.WHITE);
        date=new JLabel("Date of Birth");
        date.setBackground(Color.GRAY);
        date.setForeground(Color.WHITE);
        mail=new JLabel("Mail");
        mail.setBackground(Color.GRAY);
        mail.setForeground(Color.WHITE);
        gender=new JLabel("Gender");
        gender.setBackground(Color.GRAY);
        gender.setForeground(Color.WHITE);
        nw=new JLabel("Are you new Here?");
        us=new JTextField();
        us.setBackground(Color.GRAY);
        us.setForeground(Color.WHITE);
        us.setBorder(new LineBorder(Color.GRAY));
        pw=new JPasswordField();
        pw.setBackground(Color.GRAY);
        pw.setForeground(Color.WHITE);
        pw.setBorder(new LineBorder(Color.GRAY));
        nw.setBackground(Color.GRAY);
        nw.setForeground(Color.WHITE);
        nw.setBorder(new LineBorder(Color.GRAY));
        mai=new JTextField();
        mai.setBackground(Color.GRAY);
        mai.setForeground(Color.WHITE);
        mai.setBorder(new LineBorder(Color.GRAY));
        main=new JPanel();
        setLayout(new GridLayout(5,2));
        main.setLayout(new GridLayout(7,2));
        //addUs();
        addDat();
        addGen();
        //addPass();
        //addMail();
        addButton();
        addmain();
        setLayout( new GridBagLayout() );
        add(main, new GridBagConstraints());
        //setLayout(new FlowLayout());
        //add(main);
        addAct();
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }
    
    public void connectDB() throws Exception{
        String url="jdbc:mysql://localhost:3306/user";
        String user="root";
        String pass="root";
        Driver d=new com.mysql.jdbc.Driver();
        DriverManager.registerDriver(d);
        con=DriverManager.getConnection(url,user,pass);
        //System.out.println("connected");
        
    }
    public void addAct(){
        log.addActionListener(this);
        forgot.addActionListener(this);
        register.addActionListener(this);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
 public void addDat(){
        dat=new JPanel();
        dat.setLayout(new GridLayout(1,3,10,10));
        dat.setBackground(new Color(0,0,0,65));
        mm=new JComboBox();
        dd=new JComboBox();
        yy=new JComboBox();
        dd.setBorder(new LineBorder(Color.GRAY));
        yy.setBorder(new LineBorder(Color.GRAY));
        mm.setBorder(new LineBorder(Color.GRAY));
        yy.setBackground(Color.GRAY);
        yy.setForeground(Color.WHITE);
        mm.setBackground(Color.GRAY);
        mm.setForeground(Color.WHITE);
        dd.setBackground(Color.GRAY);
        dd.setForeground(Color.WHITE);
        
        dd.addItem("DD");
        for(int i=1;i<=31;i++){
            dd.addItem(""+i);
        }
        dat.add(dd);
        mm.addItem("MM");
        for(int i=1;i<=12;i++){
            mm.addItem(""+i);
        }
        dat.add(mm);
        yy.addItem("YYYY");
        for(int i=1994;i<=2002;i++){
            yy.addItem(""+i);
        }
        dat.add(yy);
    }
    public void addGen(){
        male=new JRadioButton("Male");
        female=new JRadioButton("Female");
        male.setBackground(Color.GRAY);
        female.setBackground(Color.GRAY);
        female.setForeground(Color.WHITE);
        male.setForeground(Color.WHITE);
        male.setOpaque(true);
        female.setOpaque(true);
        bg=new ButtonGroup();
        bg.add(male);
        bg.add(female);
        genderp=new JPanel();
        
        genderp.setLayout(new GridLayout(1,2));
        // male.setBackground(new Color(0,0,0,65));
        //female.setBackground(new Color(0,0,0,65));
        genderp.add(male);
        genderp.add(female);
        
    }
    
    
    public void addButton(){
        log =new JButton("Log in");
        forgot=new JButton("Already an User?");
        register=new JButton("Register");
        forgot.setBackground(Color.GRAY);
        register.setBackground(Color.GRAY);
        log.setBackground(Color.GRAY);
        log.setForeground(Color.WHITE);
        forgot.setForeground(Color.WHITE);
        register.setForeground(Color.WHITE);
        //log.setBackground(UIManager.getColor("control"));
        log.setOpaque(true);
        //log.setBorder(new LineBorder(Color.WHITE));
        //forgot.setBorder(new LineBorder(Color.WHITE));
        //register.setBorder(new LineBorder(Color.WHITE));
        //log.setBorderPainted(false);
        forgot.setOpaque(true);
        register.setOpaque(true);
        //button=new JPanel();
        // button.setLayout(new GridLayout(1,2));
        
    }
    public void addmain(){
        main.setBackground(new Color(0,0,0,65));
        main.add(user);
        main.add(us);
        main.add(pwd);
        main.add(pw);
        main.add(mail);
        main.add(mai);
        main.add(date);
        main.add(dat);
        main.add(gender);
        main.add(genderp);
        // main.add(log);
        main.add(forgot);
        //main.add(nw);
        //main.add(Box.createHorizontalStrut(10));
        main.add(register);
        
    }
    public void  actionPerformed(ActionEvent ae){
        try{
            actionPerformedCustom(ae);
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    static PreparedStatement  st;
    @SuppressWarnings("deprecation")
 public void actionPerformedCustom(ActionEvent ae) throws Exception{
        String act=ae.getActionCommand();
        String user1=us.getText();
        
        //st=con.prepareStatement("select * from userlogin where username=?");
        //st.setString(1,user1);
        //st.setString(2,pass1);
        //ps=st.executeQuery();
        
        if(act.equals(forgot.getLabel())){
            setVisible(false);
            JFrame jf=new logGraphics();
            //jf.setVisible(true);
            jf.setSize(100,100);
            
        }
        else {
            PreparedStatement ps=con.prepareStatement("insert into userlogin values(?,?,?,?,?)");
            ps.setString(1,us.getText());
            ps.setString(2,mai.getText());
            ps.setString(4,pw.getText());
            ps.setString(3,""+yy.getSelectedItem().toString()+"-"+mm.getSelectedItem().toString()+"-"+dd.getSelectedItem().toString());
            ps.setInt(5,1234);
            //ps.setString(7,bg.getSelection().getActionCommand());
            ps.execute();
            
            JOptionPane.showMessageDialog(new JFrame("Congratulation"),user1+" Welcome to AYCNG ");
            setVisible(false);
            JFrame jf=new logGraphics();
            //jf.setVisible(true);
            jf.setSize(100,100);
            
        }
    }
    
}


