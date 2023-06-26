
package GUI;

import BLL.*;
import DTO.*;
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


public class ListDangKiMonHoc_GUI extends JFrame {

    DefaultTableModel model;
    JLabel label,labelInfo,
            labelSoTiet,labelSoTC,labelLop,labelTenGiangVien,labelMaNhom,labelMaMon,labelTenMon,labelTietHoc,labelNote,labelSLDangKi;
    JPanel panel;

    JRadioButton rbLT,rbTH;
    JTextField tfSearch,tfLop,tfTenGiangVien,tfMaMon,tfTenMon,tfSLDangKi,tfsoTC,tfSoTiet;

    JButton buttonAdd,buttonDelete,buttonEdit,buttonCancel,buttonExit,buttonSearch;
    JComboBox<String> comboBoxMaNhom,comboBoxMaLop;
    JTable jtable = new JTable();
    JScrollPane js = new JScrollPane(jtable);

    //Vector<NhomMHDTO> list_NMH = new Vector<>();


    public ListDangKiMonHoc_GUI(){
        initListDangKiMonHoc_GUI();
        showListTable(); // hiển thị table
        initAction();
    }
    //tạo table
    private void showListTable(){
        model = new DefaultTableModel();
        jtable.setModel(model);
        model.addColumn("Mã nhóm ");
        model.addColumn("Mã lớp");
        model.addColumn("Tên môn học");
        model.addColumn("Tên giảng viên");
        model.addColumn("Số lượng đăng kí");
        model.addColumn("Số tín chỉ");
        model.addColumn("Số tiết");
        model.addColumn("Tiết học");
        js.setBounds(10,80,850,550);
        getinfo_HP();
        for(int i = 0; i < jtable.getColumnCount();i++){
            Class<?> col = jtable.getColumnClass(i);
            jtable.setDefaultEditor(col, null);
        }
    }
    public void getinfo_HP()
    {
        Vector<HocPhanDTO> list=new HocPhan_BLL().getinfo_hocphan();
        int i=0;
        model.setRowCount(0);
        while (i<= list.size()-1){
            HocPhanDTO sub =list.get(i);
            model.addRow(new Object []
                    {sub.getMaNhom(),sub.getMaLop(),
                            sub.getTenMH(),sub.getTenGV(),
                            String.valueOf(sub.getSoLuongDK()),String.valueOf(sub.getSoTc()),
                            String.valueOf(sub.getSoTiet()),sub.getTiethoc()});
            i++;

        }
    }
    public void loadData(int row)
    {
        comboBoxMaNhom.setSelectedItem(model.getValueAt(row,0));
        comboBoxMaLop.setSelectedItem(model.getValueAt(row,1));
        tfTenMon.setText(String.valueOf(model.getValueAt(row,2)));
        tfTenGiangVien.setText(String.valueOf(model.getValueAt(row,3)));
        tfSLDangKi.setText(String.valueOf(model.getValueAt(row,4)));
        tfsoTC.setText(String.valueOf(model.getValueAt(row,5)));
        tfSoTiet.setText(String.valueOf(model.getValueAt(row,6)));
        if(String.valueOf(model.getValueAt(row,7)).equals("LT"))
        {
            rbLT.setSelected(true);
            rbTH.setSelected(false);
        }
        else
        {
            rbTH.setSelected(true);
            rbLT.setSelected(false);
        }

    }
    public void initListDangKiMonHoc_GUI(){
        //set Panel
        panel = new JPanel(null);
        panel.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel.setBounds(870,80,600,550);
        //set label
        label = new JLabel("Đăng kí môn học ");
        label.setFont(new Font("Calibri", Font.PLAIN, 48));
        label.setBounds(350,-150,800,400);

        labelInfo = new JLabel("Thông tin đăng kí ");
        labelInfo.setFont(new Font("Calibri", Font.PLAIN, 30));
        labelInfo.setBounds(150,-10,350,100);

        labelMaNhom = new JLabel("Mã nhóm : ");
        labelMaNhom.setFont(new Font("Calibri", Font.PLAIN, 18));
        labelMaNhom.setBounds(15,25,200,100);

        labelLop = new JLabel("Mã Lớp : ");
        labelLop.setFont(new Font("Calibri", Font.PLAIN, 18));
        labelLop.setBounds(310,25,200,100);

        labelTenMon = new JLabel("Tên Môn : ");
        labelTenMon.setFont(new Font("Calibri", Font.PLAIN, 18));
        labelTenMon.setBounds(19,75,200,100);

        labelTenGiangVien = new JLabel("Giảng viên : ");
        labelTenGiangVien.setFont(new Font("Calibri", Font.PLAIN, 18));
        labelTenGiangVien.setBounds(290,75,200,100);

        labelSLDangKi = new JLabel("SL Đăng Kí : ");
        labelSLDangKi.setFont(new Font("Calibri", Font.PLAIN, 18));
        labelSLDangKi.setBounds(10,125,200,100);

        labelSoTC = new JLabel("Số TC : ");
        labelSoTC.setFont(new Font("Calibri", Font.PLAIN, 18));
        labelSoTC.setBounds(42,175,200,100);

        labelSoTiet = new JLabel("Số Tiết : ");
        labelSoTiet.setFont(new Font("Calibri", Font.PLAIN, 18));
        labelSoTiet.setBounds(318,125,200,100);

        labelNote = new JLabel("(Tìm kiếm theo Tên MH) ");
        labelNote.setFont(new Font("Calibri", Font.PLAIN, 18));
        labelNote.setBounds(530,640,200,100);
        // combobox MSSV
        Vector<NhomMHDTO> list_NMH=new NhomMH_BLL().getinfo_NhomMH();
        Vector<String> data_manhom=new Vector<>();
        for(NhomMHDTO nmh : list_NMH)
        {
        	data_manhom.add(nmh.getMaNhom());
        }
        comboBoxMaNhom = new JComboBox(data_manhom);
        comboBoxMaNhom.setBounds(100, 60, 170, 25);
        comboBoxMaNhom.setEditable(false);

        // mã lớp
        Vector<LopHocDTO> list=new Lop_BLL().getinfo_lop();
        Vector<String> data_lop=new Vector<>();
        for(LopHocDTO l : list)
        {
            data_lop.add(l.getMaLop());
        }
        comboBoxMaLop= new JComboBox<>(data_lop);
        comboBoxMaLop.setEditable(false);
        comboBoxMaLop.setBounds(400,60,170,25);

        tfTenMon = new JTextField(20);
        tfTenMon.setBounds(100,110,170,25);
        tfTenMon.setEnabled(false);

        tfTenGiangVien = new JTextField(20);
        tfTenGiangVien.setBounds(400,110,170,25);
        tfTenGiangVien.setEnabled(false);

        tfLop = new JTextField(20);
        tfLop.setBounds(100,110,170,25);
        tfLop.setEnabled(false);

        tfSLDangKi = new JTextField(20);
        tfSLDangKi.setEnabled(false);
        tfSLDangKi.setBounds(100,160,170,25);

        tfsoTC = new JTextField(20);
        tfsoTC.setBounds(100,210,170,25);
        tfsoTC.setEnabled(false);


        tfSoTiet = new JTextField(20);
        tfSoTiet.setBounds(400,160,170,25);
        tfSoTiet.setEnabled(false);





        //set JRadioButton
        ButtonGroup bg = new ButtonGroup();
        rbLT = new JRadioButton("Lý thuyết");
        rbLT.setFont(new Font("Tahoma",0, 16));
        rbLT.setBounds(340,210,100,40);

        rbTH = new JRadioButton("Thực hành");
        rbTH.setFont(new Font("Tahoma",0, 16));
        rbTH.setBounds(470,210,100,40);
        bg.add(rbLT);bg.add(rbTH);

        tfSearch = new JTextField(20);
        tfSearch.setBounds(180,670,350,30);



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



        panel.add(labelInfo);
        panel.add(labelMaNhom);          panel.add(comboBoxMaNhom);       panel.add(labelLop);                       panel.add(comboBoxMaLop);
        panel.add(labelTenMon);          panel.add(tfTenMon);            panel.add(labelTenGiangVien);              panel.add(tfTenGiangVien);
        panel.add(labelSLDangKi);        panel.add(tfSLDangKi);
        panel.add(rbLT); panel.add(rbTH);
        panel.add(labelSoTC); panel.add(tfsoTC);
        panel.add(labelSoTiet); panel.add(tfSoTiet);
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
    public void refesh()
    {
        comboBoxMaNhom.setSelectedIndex(0);
        comboBoxMaLop.setSelectedIndex(0);
        tfsoTC.setText("");
        tfSoTiet.setText("");
        tfTenMon.setText("");
        tfLop.setText("");
        tfTenMon.setText("");
        tfTenGiangVien.setText("");
        tfSLDangKi.setText("");
        rbLT.setSelected(true);
    }
    private void initAction(){
        jtable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row=jtable.getSelectedRow();
                loadData(row);

            }

        });
        comboBoxMaNhom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String manhom=String.valueOf(comboBoxMaNhom.getSelectedItem());
                NhomMHDTO item=new NhomMH_BLL().get_data1NMH(manhom);
                if(item!=null)
                {
                    tfTenMon.setText(item.getTenMH());
                    MonHocDTO sub=new MonHoc_BLL().search_indexMH(item.getMaMH());
                    tfsoTC.setText(String.valueOf(sub.getSoTc()));
                    tfTenGiangVien.setText(item.getTenGV());
                    tfSoTiet.setText(String.valueOf(item.getTongtiet()));
                    if(item.getTiethoc().equalsIgnoreCase("TH"))
                    {
                        rbTH.setSelected(true);
                        rbLT.setSelected(false);
                        rbLT.setSelected(false);
                        rbTH.setEnabled(true);
                    }
                    else
                    {
                        rbLT.setSelected(true);
                        rbTH.setSelected(false);
                        rbLT.setEnabled(true);
                    }
                }
            }
        });
        comboBoxMaLop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String malop=String.valueOf(comboBoxMaLop.getSelectedItem());
                int count=new SinhVien_BLL().count_SV(malop);
                tfSLDangKi.setText(String.valueOf(count));
            }
        });
        //clickon
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBoxMaNhom.getSelectedItem()==null || comboBoxMaLop.getSelectedItem()==null)
                    JOptionPane.showMessageDialog(null,"Vui long chon ma nhom va ma lop hoc!!");
                else if(tfSLDangKi.getText()==null)
                    JOptionPane.showMessageDialog(null,"Vui long nhap so luong dang ki!!");
                else
                {
                    //getdata
                    HocPhanDTO hp=new HocPhanDTO();
                    hp.setMaNhom(String.valueOf(comboBoxMaNhom.getSelectedItem()));
                    hp.setMaLop(String.valueOf(comboBoxMaLop.getSelectedItem()));
                    hp.setTenMH(tfTenMon.getText());
                    hp.setTenGV(tfTenGiangVien.getText());
                    hp.setSoLuongDK(Integer.parseInt(tfSLDangKi.getText()));
                    hp.setSoTc(Integer.parseInt(tfsoTC.getText()));
                    hp.setSoTiet(Integer.parseInt(tfSoTiet.getText()));
                    if(rbTH.isSelected())
                    {
                        hp.setTiethoc("TH");
                    }
                    else {
                        hp.setTiethoc("LT");
                    }
                    int result=new HocPhan_BLL().add_hocphan(hp);
                    if(result>0)
                    {
                        JOptionPane.showMessageDialog(null,"Dang ki hoc phan thanh cong");
                        getinfo_HP();
                    }
                    else JOptionPane.showMessageDialog(null,"Dang ki that bai");


                }
            }
        });
        buttonDelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=jtable.getSelectedRow();
                if(i>=0) {
                    String ma=String.valueOf(model.getValueAt(i,0));
                    int output=JOptionPane.showConfirmDialog(null, "Ban muon xoa hoc phan co ma " +ma );
                    if(output==JOptionPane.YES_OPTION) {
                        int result=new HocPhan_BLL().delete_hocphan(ma);
                        if(result>0)
                        {
                            model.removeRow(i);
                            JOptionPane.showMessageDialog(null, "Xoa thanh cong");
                            getinfo_HP();
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Xoa khong thanh cong");
                    }
                }
                else JOptionPane.showMessageDialog(null, "Vui long chon mon hoc muon xoa");
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refesh();
            }
        });
        buttonExit.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home_GUI();
                dispose();
            }
        });
       buttonSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              
                Vector<HocPhanDTO>  list_search =  new HocPhan_BLL().search_HP(tfSearch.getText());
        if(list_search != null){
            DefaultTableModel tbmodel = new DefaultTableModel();
            
            tbmodel.addColumn("Mã nhóm");
            tbmodel.addColumn("Mã lớp");
            tbmodel.addColumn("Tên Môn học");
            tbmodel.addColumn("Tên giảng viên");
            tbmodel.addColumn("Số lượng đăng kí");
            tbmodel.addColumn("Số tín chỉ ");
            tbmodel.addColumn("Số tiết ");
            tbmodel.addColumn("Tiết học ");
         

            
          
            for (HocPhanDTO hp: list_search) {               
                tbmodel.addRow(new Object[]{
                                            hp.getMaNhom(),
                                            hp.getMaLop(),
                                            hp.getTenMH(),
                                            hp.getTenGV(),
                                            hp.getSoLuongDK(),
                                            hp.getSoTc(),
                                            hp.getSoTiet(),
                                            hp.getTiethoc()
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
    }
    public static void main(String[] args){
        new ListDangKiMonHoc_GUI();
    }
}