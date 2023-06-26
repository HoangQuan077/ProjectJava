package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import DTO.*;
import BLL.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class ListSinhVien_GUI extends JFrame {
    DefaultTableModel model;
    JLabel lable,labelLecture,labelId,labelName,labelTC,labelDate,labelMaKhoa,labelGioiTinh,labelLop,labelNote;
    JPanel panel;
    JRadioButton rbNu,rbNam;
    JTextField tfId,tfName,tfTC,tfTH,tfLT,tfSearch,tfDate,tfKhoa,tfGioitinh ;
    JButton buttonAdd,buttonDelete,buttonEdit,buttonCancel,buttonExit,buttonSearch; 
     JComboBox<String> tfLop;
    JTable jtable = new JTable();
    JScrollPane js = new JScrollPane(jtable);
    
    Vector<SinhVienDTO> list_student = new Vector<>();
    
    public ListSinhVien_GUI(){
        initListSinhVien_GUI();
        showListTable(); // hiển thị table
        initAction();
    }
    //tạo table
    private void showListTable(){
        model = new DefaultTableModel();
        jtable.setModel(model);
        model.addColumn("STT");
        model.addColumn("MSSV");
        model.addColumn("Họ tên");
        model.addColumn("Ngày sinh");
        model.addColumn("Giới tính");
        model.addColumn("Mã lớp");
        js.setBounds(50,80,700,550);
        getdata_SV();
        // dùng để set enable cho table
        for(int i = 0; i < jtable.getColumnCount();i++){
            Class<?> col = jtable.getColumnClass(i);
            jtable.setDefaultEditor(col, null);
        }
    }
    public void getdata_SV()
    {
        list_student=new SinhVien_BLL().getinfo_SV();
        int i=0;
        model.setRowCount(0);
        while (i<= list_student.size()-1){
            SinhVienDTO sub =list_student.get(i);
            model.addRow(new Object []
                    {i,sub.getMaSV(),sub.getHoTen(),sub.getNgaySinh(),sub.getGioiTinh(),sub.getMaLop()});
            i++;

        }
    }
    public void initListSinhVien_GUI(){
     panel = new JPanel(null);
        panel.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel.setBounds(750,80,600,550);
        //set label
        lable = new JLabel("Quản lý Sinh Viên ");
        lable.setFont(new Font("Calibri", Font.PLAIN, 48));
        lable.setHorizontalAlignment(JLabel.CENTER); // chỉnh theo chiều ngang x
        lable.setHorizontalTextPosition(SwingConstants.CENTER);
        lable.setBounds(280,-150,800,400);

        labelLecture = new JLabel("Thông tin Sinh viên ");
        labelLecture.setFont(new Font("Calibri", Font.PLAIN, 30));
        labelLecture.setHorizontalAlignment(JLabel.CENTER); // chỉnh theo chiều ngang x
        labelLecture.setVerticalAlignment(SwingConstants.TOP);
        labelLecture.setBounds(150,10,300,100);

        labelId = new JLabel("MSSV :");
        labelId.setBounds(100,50,200,50);
        labelId.setFont(new Font("Tahoma",0, 18));

        labelName = new JLabel("Họ tên :");
        labelName.setBounds(96,100,200,50);
        labelName.setFont(new Font("Tahoma",0, 18));

        labelDate = new JLabel("Ngày sinh :");
        labelDate.setBounds(73,150,200,50);
        labelDate.setFont(new Font("Tahoma",0, 18));
              
        
        labelLop = new JLabel("Lớp :");
        labelLop.setBounds(104,250,200,50);
        labelLop.setFont(new Font("Tahoma",0, 18));
        
        labelNote = new JLabel("(Tìm kiếm theo mã nhóm) ");
        labelNote.setFont(new Font("Calibri", Font.PLAIN, 18));
        labelNote.setBounds(530,640,200,100);
        //set JRadioButton
        ButtonGroup bg = new ButtonGroup(); 
        rbNam = new JRadioButton("Nam");
        rbNam.setFont(new Font("Tahoma",0, 16));
        rbNam.setBounds(200,200,100,40);
        
        rbNu = new JRadioButton("Nữ");
        rbNu.setFont(new Font("Tahoma",0, 16));
        rbNu.setBounds(320,200,100,40);
        bg.add(rbNam);bg.add(rbNu);


        //set TextField
        tfId = new JTextField();
        tfId.setBounds(180,60,240,30);

        tfName = new JTextField();
        tfName.setBounds(180,110,240,30);

        tfDate = new JTextField();
        tfDate.setBounds(180,160,240,30);
        
        tfKhoa = new JTextField();
        tfKhoa.setBounds(180,210,240,30);
        Vector<LopHocDTO> dataLH=new Lop_BLL().getinfo_lop();
        Vector<String> data_MA=new Vector<>();
        for(LopHocDTO LH : dataLH)
        {
        	data_MA.add(LH.getMaLop());
        }
       
        tfLop = new JComboBox<>(data_MA);
       
        //JScrollPane scrollpane = new JScrollPane(tfTenGiangVien);
        tfLop.setBounds(180,260,240,30);
        tfLop.setEditable(false);

        tfSearch = new JTextField(20);
        tfSearch.setBounds(70,460,350,30);
       
        //set Button
        buttonAdd = new JButton(new ImageIcon("src\\Icon\\plus.png"));
        buttonAdd.setBounds(50,350,70,50);
        buttonAdd.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonDelete  = new JButton(new ImageIcon("src\\Icon\\delete.png"));
        buttonDelete.setBounds(150,350,70,50);
        buttonDelete.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonEdit = new JButton(new ImageIcon("src\\Icon\\edit.png"));
        buttonEdit.setBounds(250,350,70,50);
        buttonEdit.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonCancel = new JButton(new ImageIcon("src\\Icon\\cancel.png"));
        buttonCancel.setBounds(350,350,70,50);
        buttonCancel.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonExit = new JButton(new ImageIcon("src\\Icon\\logout.png"));
        buttonExit.setBounds(450,350,70,50);
        buttonExit.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonSearch = new JButton(new ImageIcon("src\\Icon\\search.png"));
        buttonSearch.setBounds(450,440,70,50);
        buttonSearch.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        //add các frame
        panel.add(labelLecture);
        panel.add(labelId);         panel.add(tfId);
        panel.add(labelName);       panel.add(tfName);
        panel.add(labelDate);         panel.add(tfDate);
        panel.add(labelLop);        panel.add(tfLop);
     

        
        panel.add(buttonAdd);   panel.add(buttonDelete);   panel.add(buttonEdit);   panel.add(buttonCancel);   panel.add(buttonExit);
        panel.add(tfSearch);    panel.add(labelNote);      panel.add(buttonSearch);
        panel.add(rbNam);                panel.add(rbNu);
        add(panel);
        add(lable);
        add(js);
    //set JFrame
        setBounds(170,70,1350,700);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
     public void loadData(int row)
    {
        //tfMaMonHoc.setText(String.valueOf(model.getValueAt(row,0)));
    	tfId.setText(String.valueOf(model.getValueAt(row,1)));
        tfName.setText(String.valueOf(model.getValueAt(row,2)));
        tfDate.setText(String.valueOf(model.getValueAt(row,3)));
       
        
        if(String.valueOf(model.getValueAt(row,4)).equals("Nam"))
        {
            rbNu.setSelected(false);
            rbNam.setSelected(true);
        }
        else
        {
            rbNu.setSelected(true);
            rbNam.setSelected(false);
        }
        tfLop.setSelectedItem(model.getValueAt(row,5));
        

    }
     
    private void initAction(){
        jtable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row=jtable.getSelectedRow();
                loadData(row);

            }

        });
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (    tfId.getText().equals("") )
                        JOptionPane.showMessageDialog(null,"Vui lòng nhập MSSV");
                    else
                        if (tfName.getText().equals(""))
                            JOptionPane.showMessageDialog(null,"Vui lòng nhập Họ Tên");
                         else
                            if (tfDate.getText().equals(""))
                                        JOptionPane.showMessageDialog(null,"Vui lòng nhập ngay thang nam sinh");
                            else
                                if (    !rbNam.isSelected() && !rbNu.isSelected())
                                    JOptionPane.showMessageDialog(null,"Vui lòng chon giới tính");
                                else
                                                {
                                                   SinhVienDTO sv =new SinhVienDTO();
                                                    sv.setMaSV(String.valueOf(tfId.getText()));
                                                    sv.setHoTen(tfName.getText());
                                                   
                                                    sv.setNgaySinh(tfDate.getText());
                                                    
                                                    if(rbNam.isSelected())   //// radio chuyen qua String
                                                    {
                                                         sv.setGioiTinh("Nam");
                                                    }
                                                    else
                                                    {
                                                        sv.setGioiTinh("Nu");
                                                    }
                                                    
                                                   sv.setMaLop(String.valueOf(tfLop.getSelectedItem()));
            
                             SinhVien_BLL svbll = new SinhVien_BLL();
                      if(svbll.add_SV(sv)>0)
                      {
                        JOptionPane.showMessageDialog(null,"them sinh vien thành công");
                        getdata_SV();
                      }
                      else
                        JOptionPane.showMessageDialog(null,"Thêm sinh viên không thành công, MSSV đã tồn tại!!!");
        }
        }

        catch (NumberFormatException ex) {
             JOptionPane.showMessageDialog(null, "Thông tin không hợp lệ.Vui long kiem tra lai thong tin"); 
             }
        }
        });
     buttonSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              
                Vector<SinhVienDTO>  list_search =  new SinhVien_BLL().search_SV(tfSearch.getText());
        if(list_search != null){
           

            DefaultTableModel tbmodel = new DefaultTableModel();
            
            tbmodel.addColumn("STT");
            tbmodel.addColumn("MSSV");
            tbmodel.addColumn("Họ tên");
            tbmodel.addColumn("Ngày sinh");
            tbmodel.addColumn("Giới tính");
            tbmodel.addColumn("Mã lớp");
          int i=0;
            for (SinhVienDTO sv : list_search) {               
                tbmodel.addRow(new Object[]{i++,
                                            sv.getMaSV(),
                                            sv.getHoTen(),
                                            sv.getNgaySinh(),
                                            sv.getGioiTinh(),
                                            sv.getMaLop(),
                                            });
                
                
               
            }
            
            jtable.setModel(tbmodel);
            for(int j = 0; j < jtable.getColumnCount();j++){
                Class<?> col = jtable.getColumnClass(j);
                jtable.setDefaultEditor(col, null);
            }
        }
            
    }    
        });
     buttonExit.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home_GUI();
                dispose();
            }
        });
     //clickon update
     buttonEdit.addActionListener(new ActionListener(){
             @Override
            public void actionPerformed(ActionEvent e) {
        try {
                    if (    tfId.getText().equals("") )
                        JOptionPane.showMessageDialog(null,"Vui lòng nhập MSSV");
                    else
                        if (tfName.getText().equals(""))
                            JOptionPane.showMessageDialog(null,"Vui lòng nhập Họ Tên");
                         else
                            if (tfDate.getText().equals(""))
                                        JOptionPane.showMessageDialog(null,"Vui lòng nhập ngay thang nam sinh");
                            else
                                if (    !rbNam.isSelected() && !rbNu.isSelected())
                                    JOptionPane.showMessageDialog(null,"Vui lòng chon giới tính");
                                else
                                                {
                                                   SinhVienDTO sv =new SinhVienDTO();
                                                    sv.setMaSV(String.valueOf(tfId.getText()));
                                                    sv.setHoTen(tfName.getText());
                                                   
                                                    sv.setNgaySinh(tfDate.getText());
                                                    
                                                    if(rbNam.isSelected())   //// radio chuyen qua String
                                                    {
                                                         sv.setGioiTinh("Nam");
                                                    }
                                                    else
                                                    {
                                                        sv.setGioiTinh("Nu");
                                                    }
                                                    
                                                   sv.setMaLop(String.valueOf(tfLop.getSelectedItem()));
            
                             SinhVien_BLL svbll = new SinhVien_BLL();
                      if(svbll.update_sv(sv.getMaSV(),sv)>0)
                      {
                        JOptionPane.showMessageDialog(null,"Update thanh cong");
                        getdata_SV();
                      }
                      else
                        JOptionPane.showMessageDialog(null,"Update khong  thanh cong, vui long khong thay doi mã sinh viên!!!");
        }
        }

        catch (NumberFormatException ex) {
             JOptionPane.showMessageDialog(null, "Thông tin không hợp lệ.Vui long kiem tra lai thong tin"); 
             }
        }
        });
     //clickon delete
     buttonDelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
        
        int i=jtable.getSelectedRow();
        if(i>=0) {
        	 String ma=String.valueOf(model.getValueAt(i,1));
             int output=JOptionPane.showConfirmDialog(null, "Ban muon xoa sinh vien co ma " +ma );
             if(output==JOptionPane.YES_OPTION) {
        	
        	try{
                SinhVien_BLL svbll=new SinhVien_BLL();
                
                 
                if(svbll.delete_SV(tfId.getText())==1){
                 
                 JOptionPane.showMessageDialog(null,"Sinh viên da duoc xoa");
                 getdata_SV();
                }
                 else
                    JOptionPane.showMessageDialog(null,"Xoa khong thanh cong");
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null,"Thông tin không hợp lệ.Vui long kiem tra lai thong tin");
                
            }
             }
        }
        else  JOptionPane.showMessageDialog(null,"Vui long chon sinh vien muon xoa!");
        
            }
        });
     //cancel
      buttonCancel.addActionListener(new ActionListener() {
            	@Override
                public void actionPerformed(ActionEvent e) {
                    tfId.setText("");
                    tfSearch.setText("");
                    tfName.setText("");
                    tfDate.setText("");
                    rbNam.setSelected(true);
                    rbNu.setSelected(false);
        tfLop.setSelectedIndex(0);
        
            	}
            	
            });
    }
     //clickon
     
          
    public static void main(String[] args){
        new ListSinhVien_GUI();
}
}