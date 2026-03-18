import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
class MyFrame extends Frame implements ActionListener
{
    Label L1,L2,L3;
    TextField T1,T2,T3;
    Button B1,B2,B3;
    TextArea TA;
    String Enter="";
    int finlatotal=0;
    public MyFrame()
    {
        L1=new Label("Enter Product Name");
        L2=new Label("Enter Product Price");
        L3=new Label("Enter Product Quntity");
        T1=new TextField(30);
        T2=new TextField(30);
        T3=new TextField(30);
        B1=new Button("Add Product");
        B2=new Button("Show Bill");
        B3=new Button("Clear Bill");
        TA=new TextArea(10,40);
        setLayout(new FlowLayout());
        add(L1);add(T1);
        add(L2);add(T2);
        add(L3);add(T3);
        add(B1);add(B2);add(B3);
        add(TA);
        B1.addActionListener(this);
        B2.addActionListener(this);
        B3.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        if (B1==e.getSource()) 
        {
            String name=T1.getText();   
            String price=T2.getText();   
            String qty=T3.getText();
            if (name.isEmpty() || price.isEmpty() || qty.isEmpty()) 
                JOptionPane.showMessageDialog(this, "Please enter values in fields");
            else
            {
                int pprice=Integer.parseInt(price);
                int pqty=Integer.parseInt(qty);
                int total=pprice*pqty;
                String item="Name: "+name+" price: "+price+" Qty: "+qty+" total: "+total+"\n";
                Enter=Enter+item;
                finlatotal=finlatotal+total;
                JOptionPane.showMessageDialog(this, "Product added....");
            }
        }
        if (B2==e.getSource())
        {
            TA.setText(" ");
            TA.append(Enter);
            TA.append("--------------------------------------------------------\n");
            TA.append("Final Total:                  "+finlatotal);
        }
        if (B3==e.getSource()) 
        {
            TA.setText("");
            finlatotal=0;
            Enter="";    
        }
    }
}
class MainFrame
{
    public static void main(String [] args)
    {
        MyFrame frm=new MyFrame();
        frm.setSize(450,400);
        frm.setVisible(true);
    }
}