package Quiz.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {

    String name;
    String questions[][]= new String[10][5];
    String answers[][]= new String[10][2];
    String userans[][]= new String[10][1];
    JButton next,submit,Bookmark,Lifeline;
    JLabel qno,question;
    JRadioButton opt1,opt2,opt3,opt4;
    public static int timer=15,flag=0,cnt=0,score=0;
    ButtonGroup grp;
    Quiz(String name)
    {
        this.name=name;
        setBounds(0,0,1285,700);
        getContentPane().setBackground(Color.PINK);
        setLayout(null);

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("Icons/Quizx.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1250,300);
        add(image);

        qno = new JLabel();
        qno.setBounds(290,330,50,30);
        qno.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(qno);

        question = new JLabel();
        question.setBounds(340,330,900,30);
        question.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(question);

        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        opt1= new JRadioButton();
        opt1.setBounds(340,380,700,30);
        opt1.setBackground(Color.PINK);
        opt1.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt1);

        opt2= new JRadioButton("option 2");
        opt2.setBounds(340,410,700,30);
        opt2.setBackground(Color.PINK);
        opt2.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt2);

        opt3= new JRadioButton("option 3");
        opt3.setBounds(340,440,700,30);
        opt3.setBackground(Color.PINK);
        opt3.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt3);

        opt4= new JRadioButton("option 4");
        opt4.setBounds(340,470,700,30);
        opt4.setBackground(Color.PINK);
        opt4.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt4);
        //Group Buttons so that only one can be get selected
        grp = new ButtonGroup();
        grp.add(opt1);
        grp.add(opt3);
        grp.add(opt2);
        grp.add(opt4);

        Lifeline = new JButton("Lifeline");
        Lifeline.setBounds(400,550,120,25);
        Lifeline.setBackground(Color.LIGHT_GRAY);
        Lifeline.setForeground(Color.BLACK);
        Lifeline.addActionListener(this);
        add(Lifeline);

        next = new JButton("Next");
        next.setBounds(550,550,120,25);
        next.setBackground(Color.LIGHT_GRAY);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        add(next);

//        Bookmark = new JButton("Bookmark");
//        Bookmark.setBounds(700,550,120,25);
//        Bookmark.setBackground(Color.LIGHT_GRAY);
//        Bookmark.setForeground(Color.BLACK);
//        Bookmark.addActionListener(this);
//        add(Bookmark);

        submit = new JButton("Submit");
        submit.setBounds(700,550,120,25);
        submit.setBackground(Color.LIGHT_GRAY);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(cnt);
        setVisible(true);


    }
    public void paint(Graphics g)
    {
        super.paint(g);

        String time="Time Left : " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma",Font.BOLD,20));
        if(timer>0)
        {
            g.drawString(time,1000,330);
        }
        else
        {
            g.drawString("Times up!",1000,330);
        }
        timer--;
        try
        {
            Thread.sleep(1000);
            repaint();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        if(flag==1)
        {
            flag=0;
            timer=15;
        }else if(timer<0)
        {

//            opt1.setEnabled(true);
//            opt2.setEnabled(true);
//            opt3.setEnabled(true);
//            opt4.setEnabled(true);
//            Lifeline.setEnabled(true);
//            next.setEnabled(true);
            if(cnt==8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(cnt==9)
            {
                if(grp.getSelection() == null)
                {
                    userans[cnt][0]="";
                }else
                {
                    userans[cnt][0]=grp.getSelection().getActionCommand();
                    //flag=1;
                }
                for(int i=0;i<userans.length;i++ )
                {
                    if(userans[i][0].equals(answers[i][1]))
                    {
                        score+=10;
                    }else
                    {
                        score+=0;
                    }
                }
                setVisible(false);
                new Score(name,score);
                //score

            }else
            {
                timer =15;
                if(grp.getSelection() == null)
                {
                    userans[cnt][0]="";
                }else
                {
                    userans[cnt][0]=grp.getSelection().getActionCommand();
                    //flag=1;
                }
                cnt++;
                start(cnt);
            }

        }
    }
    public void start(int count)
    {
        opt1.setEnabled(true);
        opt2.setEnabled(true);
        opt3.setEnabled(true);
        opt4.setEnabled(true);
        Lifeline.setEnabled(true);
        if(cnt<=8)
        {
            next.setEnabled(true);
        }
        qno.setText(""+(count + 1)+ ".");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        grp.clearSelection();
    }
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()==next)
    {
        next.setEnabled(false);
        repaint();

        timer=15;
        flag=1;
        if(grp.getSelection() == null)
        {
            userans[cnt][0]="";
        }else
        {
            userans[cnt][0]=grp.getSelection().getActionCommand();
            //flag=1;
        }
        if(cnt==8)
        {
            next.setEnabled(false);
            submit.setEnabled(true);
        }
        cnt++;
        start(cnt);
    }
    else if(ae.getSource()==Lifeline)
    {
        if(cnt==2 || cnt== 4|| cnt== 6|| cnt== 8|| cnt== 9)
        {
            opt2.setEnabled(false);
            opt3.setEnabled(false);
        }
        else
        {
            opt1.setEnabled(false);
            opt4.setEnabled(false);
        }
        Lifeline.setEnabled(false);

    }
    else if(ae.getSource()==submit)
    {
        flag=1;
        if(grp.getSelection() == null)
        {
            userans[cnt][0]="";
        }else
        {
            userans[cnt][0]=grp.getSelection().getActionCommand();
            //flag=1;
        }
        for(int i=0;i<userans.length;i++ )
        {
            if(userans[i][0].equals(answers[i][1]))
            {
                score+=10;
            }else
            {
                score+=0;
            }
        }
        setVisible(false);
        new Score(name,score);
        //score;
    } else if (ae.getSource()==Bookmark)
    {

    }
    }
    public static void main(String arg[])
    {
        new Quiz("username");
    }



}
