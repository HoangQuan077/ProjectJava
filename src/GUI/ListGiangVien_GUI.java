
package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import BLL.GiangVien_BLL;
import BLL.Khoa_BLL;
import BLL.SinhVien_BLL;
import DTO.GiangVienDTO;
import DTO.KhoaDTO;
import DTO.SinhVienDTO;


public class ListGiangVien_GUI extends JFrame {
    DefaultTableModel model;
    JLabel lable,labelLecture,labelId,labelName,labelTC,lableNote,labelDate,labelMaKhoa,labelChucVu,labelEmail;
    JPanel panel;
    JRadioButton rbLT,rbTH;
    JTextField tfId,tfName,tfTC,tfTH,tfLT,tfSearch,tfDate,tfEmail,tfChucVu ;
    JButton buttonAdd,buttonDelete,buttonEdit,buttonCancel,buttonExit,buttonSearch;
    JComboBox<String> tfKhoa;
    JTable jtable = new JTable();
    JScrollPane js = new JScrollPane(jtable);

    public ListGiangVien_GUI(){
        initListGiangVien_GUI();
        showListTable(); // hiển thị table
        initAction();
    }
    //tạo table
    private void showListTable(){
        model = new DefaultTableModel();
        jtable.setModel(model);
        model.addColumn("STT");
        model.addColumn("Mã GV");
        model.addColumn("Họ tên");
        model.addColumn("Ngày sinh");
        model.addColumn("Mã Khoa");
        model.addColumn("Email");
        model.addColumn("Chức vụ");
        js.setBounds(50,80,700,550);
        getdata_gv();
        for(int i = 0; i < jtable.getColumnCount();i++){
        Class<?> col = jtable.getColumnClass(i);
        jtable.setDefaultEditor(col, null);
        }
        

    }

public void getdata_gv()
        {
        Vector<GiangVienDTO> list_gv=new GiangVien_BLL().getinfo_GV();
        int i=0;
        model.setRowCount(0);
        while (i<= list_gv.size()-1){
        GiangVienDTO sub =list_gv.get(i);
        model.addRow(new Object []
        {i,sub.getMaGV(),sub.getHoTen(),sub.getNgaySinh(),sub.getMaKhoa(),sub.getEmail(),sub.getChucVu()});
        i++;

        }
       }
    public void initListGiangVien_GUI(){
        //set Label
        panel = new JPanel(null);
        panel.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel.setBounds(750,80,600,550);
        //set label
        lable = new JLabel("Quản lý Giảng viên ");
        lable.setFont(new Font("Calibri", Font.PLAIN, 48));
        lable.setHorizontalAlignment(JLabel.CENTER); // chỉnh theo chiều ngang x
        lable.setHorizontalTextPosition(SwingConstants.CENTER);
        lable.setBounds(280,-150,800,400);

        labelLecture = new JLabel("Thông tin Giảng viên ");
        labelLecture.setFont(new Font("Calibri", Font.PLAIN, 30));
        labelLecture.setHorizontalAlignment(JLabel.CENTER); // chỉnh theo chiều ngang x
        labelLecture.setVerticalAlignment(SwingConstants.TOP);
        labelLecture.setBounds(150,10,300,100);

        labelId = new JLabel("Mã Giảng Viên :");
        labelId.setBounds(35,50,200,50);
        labelId.setFont(new Font("Tahoma",0, 18));

        labelName = new JLabel("Họ tên :");
        labelName.setBounds(96,100,200,50);
        labelName.setFont(new Font("Tahoma",0, 18));

        labelDate = new JLabel("Ngày sinh :");
        labelDate.setBounds(73,150,200,50);
        labelDate.setFont(new Font("Tahoma",0, 18));

        labelMaKhoa = new JLabel("Mã Khoa :");
        labelMaKhoa.setBounds(78,200,200,50);
        labelMaKhoa.setFont(new Font("Tahoma",0, 18));

        labelEmail = new JLabel("Email :");
        labelEmail.setBounds(104,250,200,50);
        labelEmail.setFont(new Font("Tahoma",0, 18));

        labelChucVu = new JLabel("Chức vụ :");
        labelChucVu.setBounds(87,300,200,50);
        labelChucVu.setFont(new Font("Tahoma",0, 18));

        lableNote = new JLabel("(Tìm kiếm theo mã GV) ");
        lableNote.setFont(new Font("Calibri", Font.PLAIN, 18));
        lableNote.setHorizontalAlignment(JLabel.CENTER); // chỉnh theo chiều ngang x
        lableNote.setHorizontalTextPosition(SwingConstants.CENTER);
        lableNote.setBounds(70,400,250,100);


        //set TextField
        tfId = new JTextField();
        tfId.setBounds(180,60,240,30);
        tfId.setEditable(false);
        tfName = new JTextField();
        tfName.setBounds(180,110,240,30);

        tfDate = new JTextField();
        tfDate.setBounds(180,160,240,30);
        Vector<KhoaDTO> list=new Khoa_BLL().getinfo_khoa();
        Vector<String> data=new Vector<>();
        for(KhoaDTO k: list)
        {
        	data.add(k.getMaKhoa());
        }
        tfKhoa = new JComboBox<>(data);

        //JScrollPane scrollpane = new JScrollPane(tfTenGiangVien);
        tfKhoa.setBounds(180,210,240,30);
        tfKhoa.setEditable(false);


        tfEmail = new JTextField();
        tfEmail.setBounds(180,260,240,30);

        tfChucVu = new JTextField();
        tfChucVu.setBounds(180,310,240,30);

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
        panel.add(labelMaKhoa);     panel.add(tfKhoa);
        panel.add(labelEmail);      panel.add(tfEmail);
        panel.add(labelChucVu);    panel.add(tfChucVu);


        panel.add(buttonAdd);   panel.add(buttonDelete);   panel.add(buttonEdit);   panel.add(buttonCancel);   panel.add(buttonExit);
        panel.add(tfSearch);    panel.add(lableNote);      panel.add(buttonSearch);
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
    	tfId.setEnabled(false);
       tfName.setText(String.valueOf(model.getValueAt(row,2)));
       tfDate.setText(String.valueOf(model.getValueAt(row,3)));
       tfKhoa.setSelectedItem(model.getValueAt(row, 4));
       tfEmail.setText(String.valueOf(model.getValueAt(row,5)));
       tfChucVu.setText(String.valueOf(model.getValueAt(row, 6)));

   }
    public void refesh()
    {
        tfKhoa.setSelectedIndex(0);
        tfChucVu.setText("");
        tfDate.setText("");
        tfName.setText("");
        tfSearch.setText("");
        tfEmail.setText("");
        tfId.setText("");
        tfId.setEditable(true);
    }
    private void initAction(){
    	jtable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row=jtable.getSelectedRow();
                loadData(row);

            }

        });
    	buttonAdd.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tfChucVu.getText().equals("") || tfDate.getText().equals("") || tfEmail.getText().equals("") || tfName.getText().equals("") || tfId.getText().equals("") )
                {
                	JOptionPane.showMessageDialog(null, "Vui long nhap du thong tin");
                }
                else
                {
                	GiangVienDTO gv=new GiangVienDTO(tfId.getText(), tfName.getText(), tfDate.getText(), null,
                			String.valueOf( tfKhoa.getSelectedItem()), tfEmail.getText(), tfChucVu.getText());
                	int result=new GiangVien_BLL().add_GV(gv);
                	if(result>0)
                	{
                		JOptionPane.showMessageDialog(null, "Them thanh cong");
                		getdata_gv();
                	}
                	else
                		JOptionPane.showMessageDialog(null, "Them khong thanh cong");
                }
            }
        });     
    	buttonEdit.addActionListener(new ActionListener(){
            @Override
           public void actionPerformed(ActionEvent e) {
       try {
	    	   if(tfChucVu.getText().equals("") || tfDate.getText().equals("") || tfEmail.getText().equals("") || tfName.getText().equals("") || tfId.getText().equals("") )
	           {
	           	JOptionPane.showMessageDialog(null, "Vui long nhap du thong tin");
	           }
	             else
                       {
		            	 GiangVienDTO gv=new GiangVienDTO(tfId.getText(), tfName.getText(), tfDate.getText(), null,
		                			String.valueOf( tfKhoa.getSelectedItem()), tfEmail.getText(), tfChucVu.getText());
		            	 String ma=tfId.getText();
		                 int output=JOptionPane.showConfirmDialog(null, "Ban muon cap nhat giang vien co ma " +ma );
		                 if(output==JOptionPane.YES_OPTION) {
		                	 int result=new GiangVien_BLL().update_GV(ma, gv);
		                     if(result>0)
		                     {
		                       JOptionPane.showMessageDialog(null,"Update thanh cong");
		                       getdata_gv();
		                     }
	                     else
	                       JOptionPane.showMessageDialog(null,"Update khong  thanh cong, vui long khong thay doi mã sinh viên!!!");
		                 }
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
              
                Vector<GiangVienDTO> list_gv=new GiangVien_BLL().search_GV(tfSearch.getText());
                if(list_gv!=null)
                {
                	DefaultTableModel tmodel = new DefaultTableModel();
                	tmodel.addColumn("STT");
                    tmodel.addColumn("Mã GV");
                    tmodel.addColumn("Họ tên");
                    tmodel.addColumn("Ngày sinh");
                    tmodel.addColumn("Mã Khoa");
                    tmodel.addColumn("Email");
                    tmodel.addColumn("Chức vụ");
                int i=0;
                tmodel.setRowCount(0);
                while (i<= list_gv.size()-1){
                GiangVienDTO sub =list_gv.get(i);
                tmodel.addRow(new Object []
                {i,sub.getMaGV(),sub.getHoTen(),sub.getNgaySinh(),sub.getMaKhoa(),sub.getEmail(),sub.getChucVu()});
                i++;
                }
                jtable.setModel(tmodel);
                for(int j = 0; j < jtable.getColumnCount();j++){
                    Class<?> col = jtable.getColumnClass(j);
                    jtable.setDefaultEditor(col, null);
                }
                }
        }
    });
    	  buttonDelete.addActionListener(new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e) {
          
          int i=jtable.getSelectedRow();
          if(i>=0) {
          	 String ma=String.valueOf(model.getValueAt(i,1));
               int output=JOptionPane.showConfirmDialog(null, "Ban muon xoa giang vien co ma " +ma );
               if(output==JOptionPane.YES_OPTION) {
          	
          	try{
                  int result=new GiangVien_BLL().delete_GV(ma);
                  
                   
                  if(result==1){
                   
                   JOptionPane.showMessageDialog(null,"Giang viên da duoc xoa");
                   getdata_gv();
                  }
                   else
                      JOptionPane.showMessageDialog(null,"Xoa khong thanh cong");
              }catch(NumberFormatException ex){
                  JOptionPane.showMessageDialog(null,"Thông tin không hợp lệ.Vui long kiem tra lai thong tin");
                  
              }
               }
          }
          else  JOptionPane.showMessageDialog(null,"Vui long chon giang vien muon xoa!");
          
              }
          });
        //clickon
        buttonExit.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home_GUI();
                dispose();
            }
        });
        buttonCancel.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                refesh();
            }
        });
    }
    public static void main(String[] args){
        new ListGiangVien_GUI();
    }
}