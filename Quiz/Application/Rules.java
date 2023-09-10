package Quiz.Application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {

    String name;
    JButton start,back;
    Rules(String name)
    {
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        //
        JLabel heading = new JLabel("Welcome "+name+" to Simple Mind");
        heading.setBounds(30,20,700,30);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,20));
        heading.setForeground(Color.black);
        add(heading);
        //
        JLabel rules = new JLabel();
        rules.setBounds(20,90,700,350);
        rules.setFont(new Font("Tahoma",Font.PLAIN,16));
        rules.setText(
                "<html>"+
                        "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
                        "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
                        "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                        "4. Crying is allowed but please do so quietly." + "<br><br>" +
                        "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                        "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
                        "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                        "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
                        "<html>"
        );
        add(rules);
        start = new JButton("Start");
        start.setBounds(100,465,125,25);
        start.setBackground(Color.LIGHT_GRAY);
        start.setForeground(Color.BLACK);
        start.addActionListener(this);
        add(start);
        //Button back
        back = new JButton("Back");
        back.setBounds(240,465,120,25);
        back.setBackground(Color.LIGHT_GRAY);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        setSize(1285,700);
        setLocation(0,0);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == start)
        {
            setVisible(false);
            new Quiz(name);

        }else if (ae.getSource() == back)
        {
            setVisible(false);
            new Login();
        }
    }





    public static void main(String arg[])
    {
        new Rules("User");
    }
}
