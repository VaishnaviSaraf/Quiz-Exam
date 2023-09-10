package Quiz.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener
{
    JButton rules,back;
    JTextField tfname;
    JLabel name,heading;
    Login()
    {
        //Background colour
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        //Image Import - QuizTime
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("Icons/QuizTime.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(370,80,500,300);
        add(image);
        //Heading-Sample minds
        heading =new JLabel("Sample Minds");
        heading.setBounds(550,0,200,70);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,20));
        heading.setForeground(Color.MAGENTA);
        add(heading);
        //Name
        name =new JLabel("Enter your name :");
        name.setBounds(400,400,200,70);
        name.setFont(new Font("Arial",Font.BOLD,20));
        heading.setForeground(Color.BLACK);
        add(name);
        //Name Input
        tfname = new JTextField();
        tfname.setBounds(570,420,300,40);
        tfname.setFont(new Font("Arial",Font.BOLD,20));
        add(tfname);
        //Button Rules
        rules = new JButton("Rules");
        rules.setBounds(570,465,120,25);
        rules.setBackground(Color.LIGHT_GRAY);
        rules.setForeground(Color.BLACK);
        rules.addActionListener(this);
        add(rules);
        //Button back
        back = new JButton("Back");
        back.setBounds(750,465,120,25);
        back.setBackground(Color.LIGHT_GRAY);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        //Size and location of window
        setSize(1285,700);
        setLocation(0,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == rules)
        {
            String name = tfname.getText();
           setVisible(false);
           new Rules(name);
        }else if (ae.getSource() == back)
        {
            setVisible(false);
        }
    }
 public static void main(String str[])
 {
        new Login();
 }
}
