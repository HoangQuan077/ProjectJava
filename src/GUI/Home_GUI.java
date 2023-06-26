package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Home_GUI extends JFrame{
    JPanel panel1;
    JButton SubjectsBtn,SubjectsGroupBtn,StudentBtn,LecturerBtn,ClassBtn,DepartmentBtn,GroupClassBtn;
    JLabel l1;



    public Home_GUI(){
        initMenuMain();
        initAction();

    }

    private void initMenuMain(){
        //set Panel
        panel1 = new JPanel(null);
        panel1.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel1.setBounds(50,0,700,600);
        //set Label
        l1 = new JLabel("Hệ thống quản lý môn học ");
        l1.setFont(new Font("Calibri", Font.PLAIN, 48));
        l1.setHorizontalAlignment(JLabel.CENTER); // chỉnh theo chiều ngang x
        l1.setHorizontalTextPosition(SwingConstants.CENTER);
        l1.setBounds(280,50,800,400);
        //set Button
        //Button sinh viên
        StudentBtn = new JButton("Sinh viên",new ImageIcon("src\\Icon\\students.png"));
        StudentBtn.setBounds(240,350,180,70);
        //Button giảng viên
        LecturerBtn = new JButton("Giảng viên",new ImageIcon("src\\Icon\\teacher.png"));
        LecturerBtn.setBounds(470,350,180,70);
        //Button môn học
        SubjectsBtn = new JButton("Môn học",new ImageIcon("src\\Icon\\Subjects1.png"));
        SubjectsBtn.setBounds(700,350,180,70);
        //Button nhóm môn học
        SubjectsGroupBtn = new JButton("Nhóm môn học",new ImageIcon("src\\Icon\\topic.png"));
        SubjectsGroupBtn.setBounds(930,350,180,70);
        //Button nhóm lớp
        ClassBtn = new JButton("Lớp học",new ImageIcon("src\\Icon\\webinar.png"));
        ClassBtn.setBounds(350,450,180,70);
        //Button nhóm khoa
        DepartmentBtn = new JButton("Khoa",new ImageIcon("src\\Icon\\college.png"));
        DepartmentBtn.setBounds(580,450,180,70);

        GroupClassBtn = new JButton("Đăng ký MH",new ImageIcon("src\\Icon\\group-chat.png"));
        GroupClassBtn.setBounds(810,450,180,70);




        panel1.add(l1);
        panel1.add(StudentBtn); panel1.add(LecturerBtn); panel1.add(SubjectsBtn); panel1.add(SubjectsGroupBtn);
        panel1.add(ClassBtn);    panel1.add(DepartmentBtn);         panel1.add(GroupClassBtn);
        add(panel1);

        //set JFrame
        setBounds(170,70,1350,700);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }



    private void initAction(){
        //clickon
        SubjectsBtn.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListMonHoc_GUI();
                dispose();
            }
        });

        SubjectsGroupBtn.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListNhomMH_GUI();
                dispose();
            }
        });
        StudentBtn.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListSinhVien_GUI();
                dispose();
            }
        });
        LecturerBtn.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListGiangVien_GUI();
                dispose();
            }
        });
        ClassBtn.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListLopHoc_GUI();
                dispose();
            }
        });
        DepartmentBtn.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListKhoa_GUI();
                dispose();
            }
        });
        DepartmentBtn.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListKhoa_GUI();
                dispose();
            }
        });
        GroupClassBtn.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListDangKiMonHoc_GUI();
                dispose();
            }
        });
    }
    public static void main(String[] args){
        new Home_GUI();
    }
}