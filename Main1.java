package shiwuzhou;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Timer;
import javax.swing.*;

public class Main1 extends JFrame
{
    private static ArrayList<Person> Personlist;
    
    
    Scanner scanner = new Scanner(System.in);
    File file = new File("D:\\.txt");
    
    private JPanel Panel;
    private JLabel JLabel1;
    private JButton Button,Button2,Button3;
    private JTextArea text,text1,text2,text3;
    boolean tru=true;
    
    
    
    public  Main1() {

        
        Panel = new JPanel();Panel.setLayout(null);
        Button = new JButton("人员信息");
        Button2 = new JButton("重点关注人员信息");
        Button3 = new JButton("查询所在地");
        JLabel1 = new JLabel("输入学号或所在地查询");
        JLabel1.setBounds(900, 50, 400, 30);
        
        text=new JTextArea(30,80);text.setBounds(50, 180, 700, 700);
        text1=new JTextArea(1,30);text1.setBounds(900, 80, 400, 30);
        text2=new JTextArea(30,80);text2.setBounds(900,180,700, 700);
        text3=new JTextArea(30,80);text3.setBounds(420,100,200,40);
       
        Button.addActionListener(new Action());Button.setBounds(50,50,300,40);
        Button2.addActionListener(new Action1());Button2.setBounds(50,100,300,40);
        Button3.addActionListener(new Action2());Button3.setBounds(650,100,120,40);
        Panel.add(JLabel1);
        Panel.add(Button);
        Panel.add(Button2);
        Panel.add(Button3);
        Panel.add(text);
        Panel.add(text2);
        Panel.add(text1);
        Panel.add(text3);
        add(Panel);
        
        
        Timer timer = new Timer();      
        TimerTask timeTask=new TimerTask() {
            
             @Override
            public void run()
             {             
                     // TODO Auto-generated method stub
                     text2.setText(null);
                     String place=text1.getText().toString().trim();
                     for (int i = 0; i <Personlist.size(); i++) 
                     {
                         
                         String Str=(String)Personlist.get(i).getbirthplace();
                         if(Str.contains(place)&&!place.equals("")) 
                             {
                             text2.append(Personlist.get(i).toString());
                             }  
                    }      
                     for (int i = 0; i <Personlist.size(); i++) 
                     {
                         
                         String Str=(String)Personlist.get(i).getID();
                         if(Str.contains(place)&&!place.equals("")) 
                             {
                             text2.append(Personlist.get(i).toString());
                             }  
                    }    
                     
            }
            
        };timer.schedule(timeTask, 0,100);
     
        Personlist = new ArrayList<>();       
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            String temp = null;
            while ((temp = in.readLine()) != null) {            
                Scanner linescanner = new Scanner(temp);               
                linescanner.useDelimiter(" ");    
                String name = linescanner.next();
                String ID = linescanner.next();
                String sex = linescanner.next();
                String age = linescanner.next();
                String place =linescanner.nextLine();
                Person Person = new Person();
                Person.setname(name);
                Person.setID(ID);
                Person.setsex(sex);
                int a = Integer.parseInt(age);
                Person.setage(a);
                Person.setbirthplace(place);
                Personlist.add(Person);

            }
        } catch (FileNotFoundException e) {
            System.out.println("查找不到信息");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("信息读取有误");
            e.printStackTrace();
        }
 
        
    }
    
    


    private class Action implements ActionListener
    {
    public void actionPerformed(ActionEvent event)
        {        
         text.setText(null);
         Collections.sort(Personlist);
         text.append(Personlist.toString());
        }

    }         

    private class Action1 implements ActionListener
        {
        public void actionPerformed(ActionEvent event)
            {        
            text.setText(null);
            int max=0,min=100;int j,k1 = 0,k2=0;
            for(int i=1;i<Personlist.size();i++)
            {
                j=Personlist.get(i).getage();
               if(j>max)
               {
                   max=j; 
                   k1=i;
               }
               if(j<min)
               {
                   min=j; 
                   k2=i;
               }
            }  
            text.append("年龄最大：   "+Personlist.get(k1)+"\n"+"年龄最小：  "+Personlist.get(k2));     
            }
   
        }          

    private class Action2 implements ActionListener
    {
    public void actionPerformed(ActionEvent event)
        {        
         text.setText(null);
         int a = Integer.parseInt(text3.getText().toString().trim());         
         int d_value=a-Personlist.get(agenear(a)).getage();
         
         for (int i = 0; i < Personlist.size(); i++)
         {
             int p=Personlist.get(i).getage()-a;
            
             if(p==d_value||-p==d_value) text.append(Personlist.get(i).toString());
         } 
        }

    } 
    
    
    public static int agenear(int age) {
        
        int j=0,min=53,d_value=0,k=0;
         for (int i = 0; i < Personlist.size(); i++)
         {
             d_value=Personlist.get(i).getage()-age;
             if(d_value<0) d_value=-d_value; 
             if (d_value<min) 
             {
                min=d_value;
                k=i;
             }

          }    return k;
         
      }

}