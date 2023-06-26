
package GUI;

import BLL.*;
import DTO.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ListKhoa_GUI extends JFrame {
    DefaultTableModel model;
    JButton buttonExit;
    JLabel lable; 
    JTable jtable = new JTable();
    JScrollPane js = new JScrollPane(jtable);
    
    Vector<KhoaDTO> list_khoa = new Vector<>();
    
    public ListKhoa_GUI(){
        initListKhoa_GUI();
        showListTable(); // hiển thị table
        initAction();
    }
    //tạo table
    private void showListTable(){
        model = new DefaultTableModel();
        jtable.setModel(model);
        model.addColumn("STT");
        model.addColumn("Mã Khoa");
        
        model.addColumn("Tên Khoa");

        
        js.setBounds(300,80,700,550);
        getdata_khoa();
        for(int i = 0; i < jtable.getColumnCount();i++){
            Class<?> col = jtable.getColumnClass(i);
            jtable.setDefaultEditor(col, null);
        }
    }
    public void getdata_khoa()
    {
        list_khoa=new Khoa_BLL().getinfo_khoa();
        int i=0;
        while (i<= list_khoa.size()-1){
            KhoaDTO sub =list_khoa.get(i);
            model.addRow(new Object []
                    {i,sub.getMaKhoa(),sub.getTenKhoa()});
            i++;

        }
    }
    public void initListKhoa_GUI(){
    //set Label    
        lable = new JLabel("Quản lý Khoa ");
        lable.setFont(new Font("Calibri", Font.PLAIN, 48));
        lable.setHorizontalAlignment(JLabel.CENTER); // chỉnh theo chiều ngang x
        lable.setHorizontalTextPosition(SwingConstants.CENTER);
        lable.setBounds(280,-150,800,400);
    //set Button
        buttonExit = new JButton(new ImageIcon("src\\Icon\\logout.png"));    
        buttonExit.setBounds(1150,580,70,50);        
        buttonExit.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        
        add(buttonExit);
        add(lable);
        add(js);
    //set JFrame
        setBounds(170,70,1350,700);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void initAction(){
     //clickon
      buttonExit.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) { 
               new Home_GUI(); 
               dispose();
            }
        });
        }  
    public static void main(String[] args){
        new ListLopHoc_GUI();
}
}
