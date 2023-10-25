
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

class Employee  {
    String name;
    String id;
    String salary;
    String contact;
    String email;


    public Employee(  String name,String id, String salary, String contact, String email ){
        this.name=name;
        this.id=id;
        this.salary=salary;
        this.email=email;
        this.contact=contact;

    }

}

public class MainClass implements ActionListener {
    JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    JTextArea tf8;
    JButton b1,b2;

    private JFrame frame;
    private JTextField name,sid,salary,contact,email;
    private JTable table;

    int row;
    ArrayList<Employee> employeeList;
    DefaultTableModel dtm;
    String header[]= new String[]{"Employee Name","Employee ID","salary","contact","email"};


    MainClass(){
        JFrame f= new JFrame("Employee Management System");


        tf1=new JTextField("1.Add Employee's information");
        tf1.setBounds(50,50,220,30);
        tf1.setEditable(false);

        tf2=new JTextField("2.Update Employee's information");
        tf2.setBounds(50,80,220,30);
        tf2.setEditable(false);

        tf3=new JTextField("3.Delete Employee's information");
        tf3.setBounds(50,110,220,30);
        tf3.setEditable(false);

        tf4=new JTextField("4.Display Employee's information List");
        tf4.setBounds(50,140,220,30);
        tf4.setEditable(false);

        tf5=new JTextField("5.Exit");
        tf5.setBounds(50,170,220,30);
        tf5.setEditable(false);

        tf6=new JTextField();
        tf6.setBounds(50,200,220,30);

        b1=new JButton("Enter");
        b1.setBounds(110,230,100,50);

        tf8= new JTextArea();
        tf8.setBounds(50,310,300,100);
        tf8.setEditable(true);

        b1.addActionListener(this);

        f.add(tf1);
        f.add(tf2);
        f.add(tf3);
        f.add(tf4);
        f.add(tf5);
        f.add(tf6);

        f.add(b1);

        f.setSize(800,800);
        f.setLayout(null);
        f.setVisible(true);

    }
    public void actionPerformed( ActionEvent exm) {
        double s1= Double.parseDouble(tf6.getText());

        if(exm.getSource()==b1){

            if(s1==1) {

                frame = new JFrame();
                frame.setBounds(100, 100, 1079, 546);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(null);

                JLabel lblEmployeeName = new JLabel("Employee Name");
                lblEmployeeName.setForeground(new Color(0, 0, 128));

                lblEmployeeName.setBounds(29, 29, 102, 26);
                frame.getContentPane().add(lblEmployeeName);

                name = new JTextField();
                name.setBounds(127, 35, 111, 20);
                frame.getContentPane().add(name);
                name.setColumns(10);

                JLabel lblEmployeeId = new JLabel("Employee ID");
                lblEmployeeId.setForeground(new Color(0, 0, 128));

                lblEmployeeId.setBounds(29, 66, 102, 26);
                frame.getContentPane().add(lblEmployeeId);

                sid = new JTextField();
                sid.setColumns(10);
                sid.setBounds(127, 72, 111, 20);
                frame.getContentPane().add(sid);

                JLabel lblSalary = new JLabel("Salary");
                lblSalary.setForeground(new Color(0, 0, 128));

                lblSalary.setBounds(29, 103, 102, 26);
                frame.getContentPane().add(lblSalary);

                salary = new JTextField();
                salary.setColumns(10);
                salary.setBounds(127, 109, 111, 20);
                frame.getContentPane().add(salary);

                JLabel lblContact = new JLabel("Contact");
                lblContact.setForeground(new Color(0, 0, 128));

                lblContact.setBounds(29, 140, 102, 26);
                frame.getContentPane().add(lblContact);

                contact = new JTextField();
                contact.setColumns(10);
                contact.setBounds(127, 146, 111, 20);
                frame.getContentPane().add(contact);

                JLabel lblemail = new JLabel("email");
                lblemail.setForeground(new Color(0, 0, 128));

                lblemail.setBounds(29, 177, 102, 26);
                frame.getContentPane().add(lblemail);

                email = new JTextField();
                email.setColumns(10);
                email.setBounds(127, 183, 111, 20);
                frame.getContentPane().add(email);

                JButton btnAdd = new JButton("Add");
                btnAdd.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        Employee data=new Employee(name.getText(),sid.getText(),salary.getText(),contact.getText(),email.getText());
                        employeeList.add(data);
                        displayEmployeeDetails();
                    }
                });

                btnAdd.setBounds(29, 247, 89, 23);
                frame.getContentPane().add(btnAdd);

                JButton btnBack = new JButton("BACK");
                btnBack.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.setVisible(false);
                    }
                });

                btnBack.setBounds(142, 248, 89, 23);
                frame.getContentPane().add(btnBack);

                JButton btnRefresh = new JButton("Refresh");
                btnRefresh.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        name.setText("");
                        sid.setText("");
                        salary.setText("");
                        contact.setText("");
                        email.setText("");
                    }
                });

                btnRefresh.setBounds(84, 286, 89, 23);
                frame.getContentPane().add(btnRefresh);

                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(279, 36, 737, 339);
                frame.getContentPane().add(scrollPane);

                table = new JTable();
                table.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent arg0) {
                        row=table.getSelectedRow();

                        name.setText(dtm.getValueAt(row, 0).toString());
                        sid.setText(dtm.getValueAt(row, 1).toString());
                        salary.setText(dtm.getValueAt(row, 2).toString());
                        contact.setText(dtm.getValueAt(row, 3).toString());
                        email.setText(dtm.getValueAt(row, 3).toString());

                    }
                });
                scrollPane.setViewportView(table);

               frame.setVisible(true);

                employeeList=new ArrayList<>();
                dtm=new DefaultTableModel(header,0);
                table.setModel(dtm);

            }

            else if (s1==2) {

                frame = new JFrame();

                frame.setBounds(100, 100, 1079, 546);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(null);

                JLabel lblEmployeeName = new JLabel("Employee Name");
                lblEmployeeName.setForeground(new Color(0, 0, 128));

                lblEmployeeName.setBounds(29, 29, 102, 26);
                frame.getContentPane().add(lblEmployeeName);

                name = new JTextField();
                name.setBounds(127, 35, 111, 20);
                frame.getContentPane().add(name);
                name.setColumns(10);

                JLabel lblEmployeeId = new JLabel("Employee ID");
                lblEmployeeId.setForeground(new Color(0, 0, 128));

                lblEmployeeId.setBounds(29, 66, 102, 26);
                frame.getContentPane().add(lblEmployeeId);

                sid = new JTextField();
                sid.setColumns(10);
                sid.setBounds(127, 72, 111, 20);
                frame.getContentPane().add(sid);

                JLabel lblSalary = new JLabel("Salary");
                lblSalary.setForeground(new Color(0, 0, 128));

                lblSalary.setBounds(29, 103, 102, 26);
                frame.getContentPane().add(lblSalary);

                salary = new JTextField();
                salary.setColumns(10);
                salary.setBounds(127, 109, 111, 20);
                frame.getContentPane().add(salary);

                JLabel Contact = new JLabel("Contact");
                Contact.setForeground(new Color(0, 0, 128));

                Contact.setBounds(29, 140, 102, 26);
                frame.getContentPane().add(Contact);

                contact = new JTextField();
                contact.setColumns(10);
                contact.setBounds(127, 146, 111, 20);
                frame.getContentPane().add(contact);

                JLabel lblemail = new JLabel("email");
                lblemail.setForeground(new Color(0, 0, 128));

                lblemail.setBounds(29, 177, 102, 26);
                frame.getContentPane().add(lblemail);

                email = new JTextField();
                email.setColumns(10);
                email.setBounds(127, 183, 111, 20);
                frame.getContentPane().add(email);

                JButton btnUpdate = new JButton("Update");
                btnUpdate.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        employeeList.get(row).name=name.getText();
                        employeeList.get(row).id=sid.getText();
                        employeeList.get(row).salary=salary.getText();
                        employeeList.get(row).contact=contact.getText();
                        employeeList.get(row).email=email.getText();
                        displayEmployeeDetails();
                    }
                });
                JButton btnBack = new JButton("BACK");
                btnBack.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.setVisible(false);
                    }
                });

                btnBack.setBounds(142, 248, 89, 23);
                frame.getContentPane().add(btnBack);
                btnUpdate.setBounds(29, 247, 89, 23);
                frame.getContentPane().add(btnUpdate);

                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(279, 36, 737, 339);
                frame.getContentPane().add(scrollPane);

                table = new JTable();
                table.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent arg0) {
                        row=table.getSelectedRow();

                        name.setText(dtm.getValueAt(row, 0).toString());
                        sid.setText(dtm.getValueAt(row, 1).toString());
                        salary.setText(dtm.getValueAt(row, 2).toString());
                        contact.setText(dtm.getValueAt(row, 3).toString());
                        email.setText(dtm.getValueAt(row, 3).toString());

                    }
                });
                scrollPane.setViewportView(table);
                frame.setVisible(true);
                table.setModel(dtm);
            }

            else if (s1==3){

                frame = new JFrame();

                frame.setBounds(100, 100, 1079, 546);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(null);

                JLabel lblEmployeeName = new JLabel("Employee Name");
                lblEmployeeName.setForeground(new Color(0, 0, 128));

                lblEmployeeName.setBounds(29, 29, 102, 26);
                frame.getContentPane().add(lblEmployeeName);

                name = new JTextField();
                name.setBounds(127, 35, 111, 20);
                frame.getContentPane().add(name);
                name.setColumns(10);

                JLabel lblEmployeeId = new JLabel("Employee ID");
                lblEmployeeId.setForeground(new Color(0, 0, 128));

                lblEmployeeId.setBounds(29, 66, 102, 26);
                frame.getContentPane().add(lblEmployeeId);

                sid = new JTextField();
                sid.setColumns(10);
                sid.setBounds(127, 72, 111, 20);
                frame.getContentPane().add(sid);

                JLabel lblSalary = new JLabel("Salary");
                lblSalary.setForeground(new Color(0, 0, 128));

                lblSalary.setBounds(29, 103, 102, 26);
                frame.getContentPane().add(lblSalary);

                salary = new JTextField();
                salary.setColumns(10);
                salary.setBounds(127, 109, 111, 20);
                frame.getContentPane().add(salary);

                JLabel lblEnrollment = new JLabel("Contact");
                lblEnrollment.setForeground(new Color(0, 0, 128));

                lblEnrollment.setBounds(29, 140, 102, 26);
                frame.getContentPane().add(lblEnrollment);

                contact = new JTextField();
                contact.setColumns(10);
                contact.setBounds(127, 146, 111, 20);
                frame.getContentPane().add(contact);

                JLabel lblemail = new JLabel("email");
                lblemail.setForeground(new Color(0, 0, 128));

                lblemail.setBounds(29, 177, 102, 26);
                frame.getContentPane().add(lblemail);

                email = new JTextField();
                email.setColumns(10);
                email.setBounds(127, 183, 111, 20);
                frame.getContentPane().add(email);

                JButton btnDelete = new JButton("Delete");
                btnDelete.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int choice=JOptionPane.showConfirmDialog(null, "Delete this data ?", "Delete",JOptionPane.YES_NO_OPTION);
                        if(choice==0){
                            dtm.removeRow(row);
                            employeeList.remove(row);
                            displayEmployeeDetails();
                        }

                    }
                });

                btnDelete.setBounds(29, 247, 89, 23);
                frame.getContentPane().add(btnDelete);
                JButton btnBack = new JButton("BACK");
                btnBack.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.setVisible(false);
                    }
                });

                btnBack.setBounds(142, 248, 89, 23);
                frame.getContentPane().add(btnBack);

                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(279, 36, 737, 339);
                frame.getContentPane().add(scrollPane);

                table = new JTable();
                table.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent arg0) {
                        row=table.getSelectedRow();

                        name.setText(dtm.getValueAt(row, 0).toString());
                        sid.setText(dtm.getValueAt(row, 1).toString());
                        salary.setText(dtm.getValueAt(row, 2).toString());
                        contact.setText(dtm.getValueAt(row, 3).toString());
                        email.setText(dtm.getValueAt(row, 3).toString());

                    }
                });
                scrollPane.setViewportView(table);
                frame.setVisible(true);
                table.setModel(dtm);

            }
            else if (s1==4){

                frame = new JFrame();

                frame.setBounds(100, 100, 1079, 546);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(null);

                JButton btnBack = new JButton("BACK");
                btnBack.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.setVisible(false);
                    }
                });

                btnBack.setBounds(100, 150, 89, 23);
                frame.getContentPane().add(btnBack);

                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(279, 36, 737, 339);
                frame.getContentPane().add(scrollPane);

                scrollPane.setViewportView(table);
                frame.setVisible(true);
                table.setModel(dtm);

            }
            else if (s1==5){

    int choice=JOptionPane.showConfirmDialog(null, "Exit from here ?", "Exit",JOptionPane.YES_NO_OPTION);
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {

            new MainClass();

    }

    public void displayEmployeeDetails(){
        dtm.setRowCount(0);
        for(int i=0; i<employeeList.size();i++){
            Object[] obj={employeeList.get(i).name,employeeList.get(i).id,employeeList.get(i).salary,
                    employeeList.get(i).contact,employeeList.get(i).email,employeeList.get(i)};
            dtm.addRow(obj);
        }
     }

  }
