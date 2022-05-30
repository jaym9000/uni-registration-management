import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class LoginDemo extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    JLabel userLabel = new JLabel("ID");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    ArrayList <Student> Array = new ArrayList<>();
    
    // newWindowButton.setOnMouseClicked((event) -> {
//     try {
//         FXMLLoader fxmlLoader = new FXMLLoader();
//         fxmlLoader.setLocation(getClass().getResource("NewWindow.fxml"));
//         /* 
//          * if "fx:controller" is not set in fxml
//          * fxmlLoader.setController(NewWindowController);
//          */
//         Scene scene = new Scene(fxmlLoader.load(), 600, 400);
//         Stage stage = new Stage();
//         stage.setTitle("New Window");
//         stage.setScene(scene);
//         stage.show();
//     } catch (IOException e) {
//         Logger logger = Logger.getLogger(getClass().getName());
//         logger.log(Level.SEVERE, "Failed to create new Window.", e);
//     }
// });
 
 
    LoginDemo() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
 
 
    }
 
    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }
 
    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e){
      Boolean iv = false;
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton){
          String ID = userTextField.getText();
          for (int i =0; i<Array.size() ; i++){
                if (ID.equals(Array.get(i).getID())){
		              iv =true;
                }else{
                  iv=false;
                }
          }
         
          String psswd = passwordField.getText();
          for (int i =0; i<Array.size() ; i++){
             if(psswd.equals(Array.get(i).getPassword())){
               iv = true;
             }else{
               iv = false;
             }    
          }
	//ArrayList <Student> Array = new ArrayList<>(); 
	try
        {
            FileInputStream fis = new FileInputStream("Student");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            Array= (ArrayList) ois.readObject();
 
            ois.close();
            fis.close();
        } 
        catch (Exception a) 
        {
            a.printStackTrace();
            return;
        } 
           
	 iv = false;
          //Scanner scan = new Scanner(System.in);
            //System.out.print("Enter ID (4 digit unique code): ");
            //String ID = scan.next();
            for (int i =0; i<Array.size() ; i++)
             {
                if (ID.trim().equals(Array.get(i).getID()))
                 {
		    iv =true;
                    if(psswd.trim().equals(Array.get(i).getPassword()))
                     {
                        JOptionPane.showMessageDialog(this, "Login Successful");
			
			iv=true;
			break;
                     }
		    else
		     {
			JOptionPane.showMessageDialog(this, "Invalid Password");
		     }
                   }
             }
		if(iv==false)
		    {
			JOptionPane.showMessageDialog(this, "Invalid Username");
		    }
          
       }
 
        //Coding Part of RESET button
        if (e.getSource() == resetButton)
       {
            userTextField.setText("");
            passwordField.setText("");
        }
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword)
	   {
              if (showPassword.isSelected())
	       {
                 passwordField.setEchoChar((char) 0);
               } 
              else
	         {
                passwordField.setEchoChar('*');
                 }
           }
    }
 


    public static void main(String[] a)
 {
        LoginDemo frame = new LoginDemo();
        frame.setTitle("University Login");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
 
    }
 }

  