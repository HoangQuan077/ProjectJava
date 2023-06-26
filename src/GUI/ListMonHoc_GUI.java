package GUI;

import BLL.MonHoc_BLL;
import BLL.*;
import DAL.*;
import DTO.*;

import java.awt.Font;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ListMonHoc_GUI extends JFrame {
    public static  ListMonHoc_GUI MH;
    DefaultTableModel model;
    JLabel lable,labelSubjects,labelId,labelName,labelTC,lableNote;
    JPanel panel;
    JRadioButton rbLT,rbTH;
    JTextField tfId,tfName,tfTC,tfTH,tfLT,tfSearch ;
    JButton buttonAdd,buttonDelete,buttonEdit,buttonCancel,buttonExit,buttonSearch;
    JTable jtable = new JTable();
    JScrollPane js = new JScrollPane(jtable);

    Vector<MonHocDTO> list_MH = new Vector<>();

    public ListMonHoc_GUI(){
        MH=this;
        initListMonHoc_GUI();
        showListTable(); // hiển thị table
        initAction();
    }
    //tạo table
    private void showListTable(){
        model = new DefaultTableModel();
        jtable.setModel(model);
        model.addColumn("STT");
        model.addColumn("Mã MH");
        model.addColumn("Tên môn học");
        model.addColumn("Số tín chỉ");
        model.addColumn("Thực hành");
        model.addColumn("Lý thuyết");
        js.setBounds(50,80,650,550);
        getdata_MH();
        for(int i = 0; i < jtable.getColumnCount();i++){
            Class<?> col = jtable.getColumnClass(i);
            jtable.setDefaultEditor(col, null);
        }
    }
    // load data môn học theo vector ( load có thể load hết data, hoặc load data có điều kiện )
    public void getdata_MH()
    {
        list_MH=new MonHoc_BLL().getinfo_MH();
        int i=0;
        model.setRowCount(0);
        while (i<= list_MH.size()-1){
            MonHocDTO sub =list_MH.get(i);
            model.addRow(new Object []
                    {i,sub.getMaMH(),sub.getTenMH(),String.valueOf(sub.getSoTc()),sub.getThucHanh(),sub.getLiThuyet()});
            i++;

        }
    }
    public void initListMonHoc_GUI(){
        //set Panel
        panel = new JPanel(null);
        panel.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel.setBounds(750,80,600,550);
        //set label
        lable = new JLabel("Quản lý môn học ");
        lable.setFont(new Font("Calibri", Font.PLAIN, 48));
        lable.setHorizontalAlignment(JLabel.CENTER); // chỉnh theo chiều ngang x
        lable.setHorizontalTextPosition(SwingConstants.CENTER);
        lable.setBounds(280,-150,800,400);

        labelSubjects = new JLabel("Thông tin môn học ");
        labelSubjects.setFont(new Font("Calibri", Font.PLAIN, 30));
        labelSubjects.setHorizontalAlignment(JLabel.CENTER); // chỉnh theo chiều ngang x
        labelSubjects.setVerticalAlignment(SwingConstants.TOP);
        labelSubjects.setBounds(150,10,300,100);

        labelId = new JLabel("Mã môn học :");
        labelId.setBounds(35,50,200,50);
        labelId.setFont(new Font("Tahoma",0, 18));

        labelName = new JLabel("Tên môn học :");
        labelName.setBounds(27,100,200,50);
        labelName.setFont(new Font("Tahoma",0, 18));

        labelTC = new JLabel("Số tín chỉ :");
        labelTC.setBounds(60,150,200,50);
        labelTC.setFont(new Font("Tahoma",0, 18));


        lableNote = new JLabel("(Tìm kiếm theo tên môn học) ");
        lableNote.setFont(new Font("Calibri", Font.PLAIN, 18));
        lableNote.setHorizontalAlignment(JLabel.CENTER); // chỉnh theo chiều ngang x
        lableNote.setHorizontalTextPosition(SwingConstants.CENTER);
        lableNote.setBounds(70,400,250,100);


        //set TextField
        tfId = new JTextField();
        tfId.setBounds(180,60,240,30);

        tfName = new JTextField();
        tfName.setBounds(180,110,240,30);

        tfTC = new JTextField();
        tfTC.setBounds(180,160,240,30);

        tfSearch = new JTextField(20);
        tfSearch.setBounds(70,460,350,30);
        //set JRadioButton
        ButtonGroup bg = new ButtonGroup();
        rbLT = new JRadioButton("Lý thuyết");
        rbLT.setFont(new Font("Tahoma",0, 18));
        rbLT.setBounds(100,200,150,40);
        rbTH = new JRadioButton("Thực hành");
        rbTH.setFont(new Font("Tahoma",0, 18));
        rbTH.setBounds(250,200,150,40);
        bg.add(rbLT);bg.add(rbTH);
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
        panel.add(labelSubjects);
        panel.add(labelId);         panel.add(tfId);
        panel.add(labelName);       panel.add(tfName);
        panel.add(labelTC);         panel.add(tfTC);

        panel.add(rbLT);    panel.add(rbTH);
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
    // load data qua các textfield
    public void loadData(int row)
    {
        tfId.setText(String.valueOf(model.getValueAt(row,1)));
        tfId.setEnabled(false);
        tfName.setText(String.valueOf(model.getValueAt(row,2)));
        tfTC.setText(String.valueOf(model.getValueAt(row,3)));
        if(String.valueOf(model.getValueAt(row,4)).equals("1"))
        {
            rbTH.setSelected(true);
            rbLT.setSelected(false);
        }
        else
        {
            rbTH.setSelected(false);
            rbLT.setSelected(true);
        }

    }
    private void initAction(){
        //method load data qua textfield
        jtable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row=jtable.getSelectedRow();
                loadData(row);

            }

        });
        //clickon
        buttonCancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    tfId.setEnabled(true);
                    tfId.setText("");
                    tfTC.setText("");
                    tfName.setText("");
                    rbTH.setSelected(true);
                    rbLT.setSelected(false);

                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Thông tin không hợp lệ");
                }
            }
        });
        //nút add thông tin và check rỗng
        buttonAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (    tfId.getText().equals("") )
                        JOptionPane.showMessageDialog(null,"Vui lòng nhập ma mon hoc");

                    else
                    if (    tfName.getText().equals("") )
                        JOptionPane.showMessageDialog(null,"Vui lòng nhập ten mon hoc");
                    else
                    if (    tfTC.getText().equals("") )
                        JOptionPane.showMessageDialog(null,"Vui lòng nhập so tin chi");
                    else
                    if (    !rbTH.isSelected() && !rbLT.isSelected())
                        JOptionPane.showMessageDialog(null,"Vui lòng chon ly thuyet hay thuc hanh");
                    else{
                        MonHocDTO mh =new MonHocDTO();
                        mh.setMaMH(tfId.getText());
                        mh.setTenMH(tfName.getText());
                        mh.setSoTc(Integer.parseInt(tfTC.getText()));
                        if(rbTH.isSelected())
                        {
                            mh.setThucHanh(1);
                            mh.setLiThuyet(0);
                        }
                        else
                        {
                            mh.setThucHanh(0);
                            mh.setLiThuyet(1);
                        }

                        if(new MonHoc_BLL().add_MH(mh)>0)
                        {
                            JOptionPane.showMessageDialog(null,"Thêm thành công");
                            getdata_MH();
                        }
                        else
                            JOptionPane.showMessageDialog(null,"Thêm không thành công");
                        // khúc này khoogn biết refesh lại data
                        // làm ntn đỡ
//
//                        MH.dispose();
//                        new ListMonHoc_GUI();


                    }


                }

                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Thông tin không hợp lệ.Vui long kiem tra lai thong tin");
                }
            }
        });
        //clickon update /// bị bug, mai fix tiếp
        buttonEdit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(tfId.getText()==null)
                    {
                        JOptionPane.showMessageDialog(null," Vui long nhap ma mon hoc muon update!!");
                        return;
                    }
                    // lấy data từ text field
                    MonHocDTO mh =new MonHocDTO();
                    mh.setTenMH(tfName.getText());
                    mh.setSoTc(Integer.parseInt(tfTC.getText()));
                    if(rbTH.isSelected())
                    {
                        mh.setThucHanh(1);
                        mh.setLiThuyet(0);
                    }
                    else
                    {
                        mh.setThucHanh(0);
                        mh.setLiThuyet(1);
                    }

                    // update
                    int output=JOptionPane.showConfirmDialog(null, "Ban muon cap nhat mon hoc co ma " +tfId.getText() );
                    if(output==JOptionPane.YES_OPTION)
                    {
                        if(new MonHoc_BLL().update_MH(tfId.getText(),mh)>0)
                        {
                            JOptionPane.showMessageDialog(null,"Update thanh cong");
                            getdata_MH();
                        }
                        else
                        JOptionPane.showMessageDialog(null,"Update khong  thanh cong");
                    }
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Thông tin không hợp lệ.Vui long kiem tra lai thong tin");
                }
            }


        });
// click Seacrch , còn bug/ // mai fix
        buttonSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector <MonHocDTO>  list_MHsearch = new MonHoc_BLL().search_MH(tfSearch.getText());
                if(list_MHsearch != null){
                    DefaultTableModel tbmodel = new DefaultTableModel();
                    tbmodel.addColumn("STT");
                    tbmodel.addColumn("Mã MH");
                    tbmodel.addColumn("Tên môn học");
                    tbmodel.addColumn("Số tín chỉ");
                    tbmodel.addColumn("Thực hành");
                    tbmodel.addColumn("Lý thuyết");


                    int i = 0;
                    for (MonHocDTO nv : list_MHsearch) {
                        tbmodel.addRow(new Object[]{i,nv.getMaMH(), nv.getTenMH(), nv.getSoTc(), nv.getThucHanh(), nv.getLiThuyet()});
                        i++;


                    }
                    jtable.setModel(tbmodel);
                    for(int j = 0; j < jtable.getColumnCount();j++){
                        Class<?> col = jtable.getColumnClass(j);
                        jtable.setDefaultEditor(col, null);
                    }
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
                    int output=JOptionPane.showConfirmDialog(null, "Ban muon xoa mon hoc co ma " +ma );
                    if(output==JOptionPane.YES_OPTION) {
                        int result=new MonHoc_BLL().delete_MH(ma);
                        if(result>0)
                        {
                            model.removeRow(i);
                            JOptionPane.showMessageDialog(null, "Xoa thanh cong");
                            getdata_MH();
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Xoa khong thanh cong");
                    }
                }
                else JOptionPane.showMessageDialog(null, "Vui long chon mon hoc muon xoa");
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
    }

    public static void main(String[] args){
        new ListMonHoc_GUI();
    }
}