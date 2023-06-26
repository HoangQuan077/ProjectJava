
package GUI;

import BLL.GiangVien_BLL;
import BLL.MonHoc_BLL;
import BLL.NhomMH_BLL;
import DAL.NhomMH_DAL;
import DTO.GiangVienDTO;
import DTO.MonHocDTO;
import DTO.NhomMHDTO;
import java.awt.Color;
import static java.awt.Color.WHITE;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ListNhomMH_GUI extends JFrame {
    public static  ListNhomMH_GUI NMH;
    DefaultTableModel model;
    JLabel label,labelNote,labelMaNhom,labelInfo,labelTenMonHoc,labelMaMonHoc,labelSucChua,labelTenGiangVien,labelSoTuanHoc,labelTongPhanTiet,labelTongTiet,labelHocKi,labelNamHoc;
    JPanel panel;  
    JRadioButton rbLT,rbTH;
    JTextField tfSearch,tfMaNhom,tfTenMonHoc,tfSucChua,tfSoTuanHoc,tfTongPhanTiet,tfTongTiet,tfHocKi,tfNamHoc;
    JButton buttonAdd,buttonDelete,buttonEdit,buttonCancel,buttonExit,buttonSearch;
    JComboBox<String> tfTenGiangVien,tfMaMonHoc;
    JTable jtable = new JTable();
    JScrollPane js = new JScrollPane(jtable);
    
    Vector<NhomMHDTO> list_NMH = new Vector<>();
    
    
     public ListNhomMH_GUI(){
        initListNhomMH_GUI();
        showListTable(); // hiển thị table
        initAction();
    }
    //tạo table
    private void showListTable(){
        model = new DefaultTableModel();
        jtable.setModel(model);
        model.addColumn("Mã MH ");
        model.addColumn("Tên môn học");
        model.addColumn("Mã nhóm");
        model.addColumn("Sức chứa");
        model.addColumn("Tên giảng viên");
        model.addColumn("Tiết học");
        model.addColumn("Số tuần học");
        model.addColumn("Tổng phân tiết");
        model.addColumn("Tổng Tiết");
        model.addColumn("Học kì");
        model.addColumn("Năm học");
        js.setBounds(10,80,850,550);
        getdata_NMH();
        for(int i = 0; i < jtable.getColumnCount();i++){
            Class<?> col = jtable.getColumnClass(i);
            jtable.setDefaultEditor(col, null);
        }
    }
    public void getdata_NMH()
    {
        list_NMH=new NhomMH_BLL().getinfo_NhomMH();
        int i=0;
        model.setRowCount(0);
        while (i<= list_NMH.size()-1){
            NhomMHDTO sub =list_NMH.get(i);
            model.addRow(new Object []
                    {sub.getMaMH()
                    ,sub.getTenMH()
                    ,sub.getMaNhom()
                    ,String.valueOf(sub.getSucchua())
                    ,sub.getTenGV()
                    ,sub.getTiethoc()
                    ,String.valueOf(sub.getSotuanhoc())
                    ,String.valueOf(sub.getTongphantiet())
                    ,String.valueOf(sub.getTongtiet())
                    ,sub.getHocki()
                    ,sub.getNamhoc()});
            i++;

        }
    }
    public void initListNhomMH_GUI(){
    //set Panel
        panel = new JPanel(null);       
        panel.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel.setBounds(870,80,600,550);
    //set label
        label = new JLabel("Quản lý nhóm môn học ");
        label.setFont(new Font("Calibri", Font.PLAIN, 48));
        label.setBounds(350,-150,800,400);
        
        labelInfo = new JLabel("Thông tin nhóm môn học ");
        labelInfo.setFont(new Font("Calibri", Font.PLAIN, 30));
        labelInfo.setBounds(150,-10,350,100);
        
        labelMaMonHoc = new JLabel("Mã Môn học : ");
        labelMaMonHoc.setFont(new Font("Calibri", Font.PLAIN, 18));
        labelMaMonHoc.setBounds(20,25,200,100);
        
        labelTenMonHoc = new JLabel("Tên môn học : ");
        labelTenMonHoc.setFont(new Font("Calibri", Font.PLAIN, 18));
        labelTenMonHoc.setBounds(250,25,200,100);
        
        labelMaNhom = new JLabel("Mã nhóm : ");
        labelMaNhom.setFont(new Font("Calibri", Font.PLAIN, 18));
        labelMaNhom.setBounds(43,75,200,100);
        
        labelSucChua = new JLabel("Sức chứa : ");
        labelSucChua.setFont(new Font("Calibri", Font.PLAIN, 18));
        labelSucChua.setBounds(270,75,200,100);
        
        labelTenGiangVien = new JLabel("Tên giảng viên : ");
        labelTenGiangVien.setFont(new Font("Calibri", Font.PLAIN, 18));
        labelTenGiangVien.setBounds(9,125,200,100);
        
        labelSoTuanHoc = new JLabel("Số tuần học : ");
        labelSoTuanHoc.setFont(new Font("Calibri", Font.PLAIN, 18));
        labelSoTuanHoc.setBounds(25,175,200,100);
        
        labelTongPhanTiet = new JLabel("Tổng phân tiết : ");
        labelTongPhanTiet.setFont(new Font("Calibri", Font.PLAIN, 18));
        labelTongPhanTiet.setBounds(5,225,200,100);
        
        labelTongTiet = new JLabel("Tổng Tiết : ");
        labelTongTiet.setFont(new Font("Calibri", Font.PLAIN, 18));
        labelTongTiet.setBounds(45,275,300,100);
        
        labelHocKi = new JLabel("Học Kì : ");
        labelHocKi.setFont(new Font("Calibri", Font.PLAIN, 18));
        labelHocKi.setBounds(65,325,300,100);
        
        labelNamHoc = new JLabel("Năm Học : ");
        labelNamHoc.setFont(new Font("Calibri", Font.PLAIN, 18));
        labelNamHoc.setBounds(45,375,300,100);
        
        labelNote = new JLabel("(Tìm kiếm theo mã nhóm) ");
        labelNote.setFont(new Font("Calibri", Font.PLAIN, 18));
        labelNote.setBounds(530,640,200,100);
        // giảng viên
        Vector<GiangVienDTO> dataGV=new GiangVien_BLL().getinfo_GV();
        Vector<String> data_nameGV=new Vector<>();
        for(GiangVienDTO gv : dataGV)
        {
        	data_nameGV.add(gv.getHoTen());
        }
        tfTenGiangVien = new JComboBox<>(data_nameGV);
       
        //JScrollPane scrollpane = new JScrollPane(tfTenGiangVien);
        tfTenGiangVien.setBounds(130, 160, 170, 25);
        tfTenGiangVien.setEditable(false);
        
        // mã môn học
        Vector<MonHocDTO> dataMH=new MonHoc_BLL().getinfo_MH();
        Vector<String> data_mh=new Vector<>();
        for(MonHocDTO mh : dataMH)
        {
        	data_mh.add(mh.getMaMH());
        }
        tfMaMonHoc = new JComboBox<>(data_mh);
       
        //JScrollPane scrollpane1 = new JScrollPane(tfMaMonHoc);
        tfMaMonHoc.setEditable(false);   
        tfMaMonHoc.setBounds(130,60,100,25);

        
      tfTenMonHoc = new JTextField(20);
       tfTenMonHoc.setBounds(360,60,190,25);
        
        tfMaNhom = new JTextField(20);
        tfMaNhom.setBounds(130,110,100,25);
        
        tfSucChua = new JTextField(20);
        tfSucChua.setBounds(360,110,190,25);
//       
//        tfTenGiangVien = new JTextField(20);
//        tfTenGiangVien.setBounds(130,160,170,25);
        
        tfSoTuanHoc = new JTextField(20);
        tfSoTuanHoc.setBounds(130,210,170,25);
        
        tfTongPhanTiet = new JTextField(20);
        tfTongPhanTiet.setBounds(130,260,170,25);
       
        tfTongTiet = new JTextField(20);
        tfTongTiet.setBounds(130,310,170,25);
        tfTongTiet.setEnabled(false);
        
        
        tfHocKi = new JTextField(20);
        tfHocKi.setBounds(130,360,170,25);
        
        tfNamHoc = new JTextField(20);
        tfNamHoc.setBounds(130,410,170,25);
                 
        tfSearch = new JTextField(20);
        tfSearch.setBounds(180,670,350,30);
    //set JRadioButton
        ButtonGroup bg = new ButtonGroup(); 
        rbLT = new JRadioButton("Lý thuyết");
        rbLT.setFont(new Font("Tahoma",0, 16));
        rbLT.setBounds(320,150,100,40);
        
        rbTH = new JRadioButton("Thực hành");
        rbTH.setFont(new Font("Tahoma",0, 16));
        rbTH.setBounds(450,150,100,40);
        bg.add(rbLT);bg.add(rbTH);
    //set Button
        buttonAdd = new JButton(new ImageIcon("src\\Icon\\plus.png"));        	
        buttonAdd.setBounds(870,660,70,50);
        buttonAdd.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonEdit  = new JButton(new ImageIcon("src\\Icon\\edit.png"));     
        buttonEdit.setBounds(970,660,70,50);
        buttonEdit.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonDelete  = new JButton(new ImageIcon("src\\Icon\\delete.png"));     
        buttonDelete.setBounds(1070,660,70,50);
        buttonDelete.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonCancel = new JButton(new ImageIcon("src\\Icon\\cancel.png"));
        buttonCancel.setBounds(1170,660,70,50);      
        buttonCancel.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonExit = new JButton(new ImageIcon("src\\Icon\\logout.png"));    
        buttonExit.setBounds(1270,660,70,50);        
        buttonExit.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonSearch = new JButton(new ImageIcon("src\\Icon\\search.png"));      
        buttonSearch.setBounds(770,660,70,50);       
        buttonSearch.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        
        tfTenMonHoc.setEnabled(false);
        
        panel.add(labelInfo);
        panel.add(labelMaMonHoc);    
        //panel.add(cb);
        //panel.add(cb1);
        panel.add(tfMaMonHoc);
        panel.add(labelTenMonHoc);    panel.add(tfTenMonHoc); 
        panel.add(labelMaNhom);         panel.add(tfMaNhom);       panel.add(labelSucChua);        panel.add(tfSucChua);   
        panel.add(labelTenGiangVien);   panel.add(tfTenGiangVien);  panel.add(rbLT);                panel.add(rbTH);
        panel.add(labelSoTuanHoc);      panel.add(tfSoTuanHoc);     panel.add(labelTongPhanTiet);   panel.add(tfTongPhanTiet);
        panel.add(labelTongTiet);       panel.add(tfTongTiet);
        panel.add(labelHocKi);       panel.add(tfHocKi);      panel.add(labelNamHoc);       panel.add(tfNamHoc);
        add(tfSearch); add(labelNote); add(buttonSearch); 
        add(buttonAdd); add(buttonDelete); add(buttonEdit); add(buttonExit); add(buttonCancel);
        add(panel);
        add(label);
        add(js);
    //set JFrame
        setBounds(50,30,1500,800);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void loadData(int row)
    {
        //tfMaMonHoc.setText(String.valueOf(model.getValueAt(row,0)));
    	tfMaMonHoc.setSelectedItem(model.getValueAt(row,0));
        tfTenMonHoc.setText(String.valueOf(model.getValueAt(row,1)));
        tfMaNhom.setText(String.valueOf(model.getValueAt(row,2)));
        tfSucChua.setText(String.valueOf(model.getValueAt(row,3)));
        //tfTenGiangVien.setText(String.valueOf(model.getValueAt(row,4)));
        tfTenGiangVien.setSelectedItem(model.getValueAt(row,4));
        
        if(String.valueOf(model.getValueAt(row,5)).equals("LT"))
        {
            rbTH.setSelected(false);
            rbLT.setSelected(true);
        }
        else
        {
            rbTH.setSelected(true);
            rbLT.setSelected(false);
        }
        tfSoTuanHoc.setText(String.valueOf(model.getValueAt(row,6)));
        tfTongPhanTiet.setText(String.valueOf(model.getValueAt(row,7)));
        tfTongTiet.setText(String.valueOf(model.getValueAt(row,8)));
        tfHocKi.setText(String.valueOf(model.getValueAt(row,9)));
        tfNamHoc.setText(String.valueOf(model.getValueAt(row,10)));
        

    }
    public void refesh()
    {
        tfTenMonHoc.setText("");
        tfSearch.setText("");
        tfMaNhom.setText("");
        tfMaMonHoc.setSelectedIndex(0);
        tfTenGiangVien.setSelectedIndex(0);
        tfTongPhanTiet.setText("");
        tfTongTiet.setText("");
        tfHocKi.setText("");
        tfNamHoc.setText("");
        tfSucChua.setText("");
        tfSoTuanHoc.setText("");
    }
    private void initAction(){
     //clickon
     jtable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row=jtable.getSelectedRow();
                loadData(row);

            }

        });
     tfMaMonHoc.addActionListener(new ActionListener() {
    	 @Override
         public void actionPerformed(ActionEvent e) {
    		 // code ở đây
    		 MonHocDTO item=new MonHoc_BLL().search_indexMH(String.valueOf(tfMaMonHoc.getSelectedItem()));
    		 if(item!=null) 
    			 {
	    			 tfTenMonHoc.setText(item.getTenMH());
	    			 if(item.getLiThuyet()==1) 
	        		 {
	        			 rbLT.setSelected(true);
	        			 rbTH.setEnabled(false);
	        			 rbLT.setEnabled(true);
	        		 }
	        		 else
	        		 {
	        			 rbTH.setSelected(true);
	        			 rbLT.setEnabled(false);
	        			 rbTH.setEnabled(true);
	        		 }
    			 }
    		
            
         }


	
     });
     buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    if (    tfMaNhom.getText().equals("") )
                        JOptionPane.showMessageDialog(null,"Vui lòng nhập mã nhóm");
                    else
                    if (    tfSucChua.getText().equals("") )
                        JOptionPane.showMessageDialog(null,"Vui lòng nhập sức chứa");
                    else
                    if (    !rbTH.isSelected() && !rbLT.isSelected())
                        JOptionPane.showMessageDialog(null,"Vui lòng chọn tiết học");
                    else
                    if (    tfSoTuanHoc.getText().equals("") )
                        JOptionPane.showMessageDialog(null,"Vui lòng nhập số tuần học");
                    else
                    if (    tfTongPhanTiet.getText().equals("") )
                        JOptionPane.showMessageDialog(null,"Vui lòng nhập tổng phân tiết");
                    else
                    if (    tfHocKi.getText().equals("") )
                        JOptionPane.showMessageDialog(null,"Vui lòng nhập học kì");
                    else
                    if (    tfNamHoc.getText().equals("") )
                        JOptionPane.showMessageDialog(null,"Vui lòng nhập năm học");
                    else{
                        NhomMHDTO nmh =new NhomMHDTO();
                        nmh.setMaMH(String.valueOf(tfMaMonHoc.getSelectedItem()));
                        nmh.setTenMH(tfTenMonHoc.getText());
                        nmh.setMaNhom(tfMaNhom.getText());
                        nmh.setSucchua(Integer.parseInt(tfSucChua.getText()));
                        //nmh.setTenGV(tfTenGiangVien.getText());
                        nmh.setTenGV(String.valueOf(tfTenGiangVien.getSelectedItem()));
                        if(rbTH.isSelected())
                        {
                            nmh.setTiethoc("TH");
                            
                        }
                        else
                        {
                            nmh.setTiethoc("LT");
                        }
                        nmh.setSotuanhoc(Integer.parseInt(tfSoTuanHoc.getText()));
                        nmh.setTongphantiet(Integer.parseInt(tfTongPhanTiet.getText()));                      
                        nmh.setTongtiet(Integer.parseInt(tfSoTuanHoc.getText()) * Integer.parseInt(tfTongPhanTiet.getText()));                
                        nmh.setHocki(tfHocKi.getText());
                        nmh.setNamhoc(tfNamHoc.getText());
                        
                        if( new NhomMH_BLL().add_NhomMH1(nmh) > 0 )
                        {
                        JOptionPane.showMessageDialog(null,"Thêm thành công");
                        getdata_NMH();
                        refesh();
                        }
                        else
                        JOptionPane.showMessageDialog(null,"Thêm không thành công.Mã nhóm đã tồn tại");
                        
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
              
                Vector<NhomMHDTO>  list_NMHsearch =  new NhomMH_BLL().search_NhomMH(tfSearch.getText());
        if(list_NMHsearch != null){
            DefaultTableModel tbmodel = new DefaultTableModel();
            
            tbmodel.addColumn("Mã MH");
            tbmodel.addColumn("Tên môn học");
            tbmodel.addColumn("Mã nhóm ");
            tbmodel.addColumn("Sức chứa");
            tbmodel.addColumn("Tên giảng viên");
            tbmodel.addColumn("Tiết học ");
            tbmodel.addColumn("Số tuần học ");
            tbmodel.addColumn("Tổng phân tiết ");
            tbmodel.addColumn("Tổng tiết ");
            tbmodel.addColumn("Học kì ");
            tbmodel.addColumn("Năm học ");
            

            
          
            for (NhomMHDTO nmh : list_NMHsearch) {               
                tbmodel.addRow(new Object[]{nmh.getMaMH(),
                                            nmh.getTenMH(),
                                            nmh.getMaNhom(),
                                            nmh.getSucchua(),
                                            nmh.getTenGV(),
                                            nmh.getTiethoc(),
                                            nmh.getSotuanhoc(),
                                            nmh.getTongphantiet(),
                                            nmh.getTongtiet(),
                                            nmh.getHocki(),
                                            nmh.getNamhoc()});
                
                
               
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
                    if (    tfMaNhom.getText().equals("") )
                        JOptionPane.showMessageDialog(null,"Vui lòng nhập ma nhom");
                    else
                        if (tfSucChua.getText().equals(""))
                            JOptionPane.showMessageDialog(null,"Vui lòng nhập suc chua");
                            else
                                if (    !rbTH.isSelected() && !rbLT.isSelected())
                                    JOptionPane.showMessageDialog(null,"Vui lòng chon ly thuyet hay thuc hanh");
                                else
                                    if (tfSoTuanHoc.getText().equals(""))
                                        JOptionPane.showMessageDialog(null,"Vui lòng nhập so tuan hpc");
                                     else
                                        if (tfTongPhanTiet.getText().equals(""))
                                         JOptionPane.showMessageDialog(null,"Vui lòng nhập tong phan tiet");
                                        else
                                            if (tfHocKi.getText().equals(""))
                                            JOptionPane.showMessageDialog(null,"Vui lòng nhập hoc ky");
                                            else
                                                if (tfNamHoc.getText().equals(""))
                                                JOptionPane.showMessageDialog(null,"Vui lòng nhập nam hoc");
                                                else
                                                {
                                                    NhomMHDTO nhommh =new NhomMHDTO();
                                                    nhommh.setMaMH(String.valueOf(tfMaMonHoc.getSelectedItem()));
                                                    nhommh.setMaNhom(tfMaNhom.getText());
                                                   
                                                    nhommh.setTenMH(tfTenMonHoc.getText());
                                                    nhommh.setSucchua(Integer.parseInt(tfSucChua.getText()));
                                                    nhommh.setTenGV(String.valueOf(tfTenGiangVien.getSelectedItem()));
                                                    if(rbTH.isSelected())   //// radio chuyen qua String
                                                    {
                                                         nhommh.setTiethoc("TH");
                                                    }
                                                    else
                                                    {
                                                    nhommh.setTiethoc("LT");
                                                    }
                                                    
                                                    nhommh.setSotuanhoc(Integer.parseInt(tfSoTuanHoc.getText()));
                                                    nhommh.setTongphantiet(Integer.parseInt(tfTongPhanTiet.getText()));
                                                    nhommh.setTongtiet(Integer.parseInt(tfTongTiet.getText()));
                                                    nhommh.setHocki(tfHocKi.getText());
                                                    nhommh.setNamhoc(tfNamHoc.getText());
            
                             NhomMH_BLL mhbll = new NhomMH_BLL();
                      if(mhbll.update_nhomMH(nhommh.getMaNhom(),nhommh)>0)
                      {
                        JOptionPane.showMessageDialog(null,"Update thanh cong");
                        getdata_NMH();
                      }
                      else
                        JOptionPane.showMessageDialog(null,"Update khong  thanh cong, vui long khong thay doi ma nhom!!!");
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
        
        if(tfMaNhom.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Vui long nhap Ma nhom muon xoa");
            
        }
        
        else
            // xac nhan xem muon xoa k
        if(JOptionPane.showConfirmDialog(null,"Ban co muon xoa nhom mon hoc? ")== JOptionPane.NO_OPTION) {
            return ;
        }
        try{
            NhomMH_BLL bus=new NhomMH_BLL();
            
             
            if(bus.delete_NhomMH(tfMaNhom.getText())==1){
             
             JOptionPane.showMessageDialog(null,"Nhom mon hoc da duoc xoa");
             getdata_NMH();
            }
             else
                JOptionPane.showMessageDialog(null,"Xoa khong thanh cong");
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Thông tin không hợp lệ.Vui long kiem tra lai thong tin");
            
        }
            }
        });
            buttonCancel.addActionListener(new ActionListener() {
            	@Override
                public void actionPerformed(ActionEvent e) {
                    refesh();
            	}
            	
            });
    }
     
    public static void main(String[] args){
        new ListNhomMH_GUI();
}
}
