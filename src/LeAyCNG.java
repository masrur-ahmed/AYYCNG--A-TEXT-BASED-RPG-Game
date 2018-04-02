/**
 * 
 */
import javax.swing.*;
import com.masrur.login.Reg;
/**
 * @author JAVA
 *
 */
public class LeAyCNG {

 /**
  * @param args
  */
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  JFrame reg;
  try {
   reg = new Reg();
   reg.setVisible(true);
  reg.setSize(500,500);
  } catch (Exception e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
     
 }

}
