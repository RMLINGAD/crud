import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.io.FileFilter;

import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
public class stud extends javax.swing.JFrame {

    private ResultSet rs;

    public stud() {
        initComponents();
        Connect();
        Fetch();
    }
     Connection con;
  PreparedStatement pst;
  //Connec sql
  public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/jcrud", "root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(stud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(stud.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
  
  public void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM stud");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            DefaultTableModel model = (DefaultTableModel)jTable.getModel();
            model.setRowCount(0);
            while(rs.next()){
                Vector vec = new Vector();
                for(int a=1;  a<=q; a++){
                    vec.add(rs.getString("ID"));
                    vec.add(rs.getString("name"));
                    vec.add(rs.getString("age"));
                    vec.add(rs.getString("gender"));
                    vec.add(rs.getString("course"));
                    vec.add(rs.getString("year"));
                    vec.add(rs.getString("section"));
                    vec.add(rs.getString("pf"));
                    vec.add(rs.getString("net"));
                    vec.add(rs.getString("im"));
                    vec.add(rs.getString("ms"));
                    vec.add(rs.getString("avg"));
                    vec.add(rs.getString("status"));}
                model.addRow(vec);}
        } catch (SQLException ex) {
            Logger.getLogger(stud.class.getName()).log(Level.SEVERE, null, ex);
        }    
  }
  public void Search(String search){
         try {
            int q;
            pst = con.prepareStatement("SELECT * FROM stud WHERE ID = ? OR name = ? OR age = ? OR gender = ? OR course = ? OR section = ? OR status = ? OR year = ?");
             pst.setString(1, search);
             pst.setString(2, search);
             pst.setString(3, search);
             pst.setString(4, search);
             pst.setString(5, search);
             pst.setString(6, search);
             pst.setString(7, search);
             pst.setString(8, search);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            DefaultTableModel model = (DefaultTableModel)jTable.getModel();
            model.setRowCount(0);
            boolean founddata = false;
            while(rs.next()){
                founddata = true;
                Vector vec = new Vector();
                for(int a=1;  a<=q; a++){
                    vec.add(rs.getString("ID"));
                    vec.add(rs.getString("name"));
                    vec.add(rs.getString("age"));
                    vec.add(rs.getString("gender"));
                    vec.add(rs.getString("course"));
                     vec.add(rs.getString("year"));
                    vec.add(rs.getString("section"));
                    vec.add(rs.getString("pf"));
                    vec.add(rs.getString("net"));
                    vec.add(rs.getString("im"));
                    vec.add(rs.getString("ms"));
                    vec.add(rs.getString("avg"));
                    vec.add(rs.getString("status"));}
                model.addRow(vec);}
         
          if (!founddata) {
            JOptionPane.showMessageDialog(null, "No data found.");
        }}
         catch (SQLException ex) {
            Logger.getLogger(stud.class.getName()).log(Level.SEVERE, null, ex);
        }    
  }
      public void delete(Object id) throws SQLException{
  String deleteQuery = "DELETE FROM stud WHERE id = ?";
          pst = con.prepareStatement(deleteQuery);
          pst.setObject(1, id);
          int k = pst.executeUpdate();
 if(k ==1){
   JOptionPane.showMessageDialog(this, "Record Delete");
 }
 else{
  JOptionPane.showMessageDialog(this, "Record Failed");
 }
  }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jname = new javax.swing.JTextField();
        jgender = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jpf = new javax.swing.JTextField();
        jnet = new javax.swing.JTextField();
        jim = new javax.swing.JTextField();
        jms = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jcreate = new javax.swing.JButton();
        jdelete = new javax.swing.JButton();
        jupdate = new javax.swing.JButton();
        jcsv = new javax.swing.JButton();
        jshow = new javax.swing.JButton();
        jpdf = new javax.swing.JButton();
        jage1 = new javax.swing.JSpinner();
        jcourse = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jyear = new javax.swing.JComboBox<>();
        jsection = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        jsearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(10, 59, 98));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("STUDENT MANAGEMENT SYSTEM");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NAME:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("AGE:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("GENDER:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("COURSE:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("SECTION:");

        jgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE" }));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PF:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("IM:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("NET:");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("MS:");

        jim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jimActionPerformed(evt);
            }
        });

        jms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmsActionPerformed(evt);
            }
        });

        jcreate.setBackground(new java.awt.Color(55, 106, 146));
        jcreate.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jcreate.setForeground(new java.awt.Color(255, 255, 255));
        jcreate.setText("CREATE");
        jcreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcreateActionPerformed(evt);
            }
        });

        jdelete.setBackground(new java.awt.Color(55, 106, 146));
        jdelete.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jdelete.setForeground(new java.awt.Color(255, 255, 255));
        jdelete.setText("DELETE");
        jdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdeleteActionPerformed(evt);
            }
        });

        jupdate.setBackground(new java.awt.Color(55, 106, 146));
        jupdate.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jupdate.setForeground(new java.awt.Color(255, 255, 255));
        jupdate.setText("UPDATE");
        jupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jupdateActionPerformed(evt);
            }
        });

        jcsv.setBackground(new java.awt.Color(55, 106, 146));
        jcsv.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jcsv.setForeground(new java.awt.Color(255, 255, 255));
        jcsv.setText("CSV");
        jcsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcsvActionPerformed(evt);
            }
        });

        jshow.setBackground(new java.awt.Color(55, 106, 146));
        jshow.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jshow.setForeground(new java.awt.Color(255, 255, 255));
        jshow.setText("SHOW DATA");
        jshow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jshowActionPerformed(evt);
            }
        });

        jpdf.setBackground(new java.awt.Color(55, 106, 146));
        jpdf.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jpdf.setForeground(new java.awt.Color(255, 255, 255));
        jpdf.setText("PDF");
        jpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpdfActionPerformed(evt);
            }
        });

        jage1.setModel(new javax.swing.SpinnerNumberModel(18, 18, 50, 1));
        jage1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jage1InputMethodTextChanged(evt);
            }
        });

        jcourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSIT", "BSIS", "BSCE" }));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("GRADES");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("YEAR:");

        jyear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        jsection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jname)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcourse, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jyear, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jsection, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel7)
                                        .addComponent(jpf, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addComponent(jim, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addComponent(jage1))
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel5))
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel12)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jgender, 0, 100, Short.MAX_VALUE)
                                                .addComponent(jms)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel6)
                                                    .addGap(7, 7, 7))))
                                        .addComponent(jLabel9))
                                    .addComponent(jnet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(57, 57, 57))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcsv, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpdf, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jshow, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcreate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator3)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jgender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcreate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jshow, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcsv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpdf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel2.setBackground(new java.awt.Color(55, 106, 146));

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jsearch.setBackground(new java.awt.Color(10, 59, 98));
        jsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-search-24(@1x).png"))); // NOI18N
        jsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsearchActionPerformed(evt);
            }
        });

        jScrollPane2.setPreferredSize(new java.awt.Dimension(452, 480));

        jTable.setBackground(new java.awt.Color(55, 106, 146));
        jTable.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTable.setForeground(new java.awt.Color(255, 255, 255));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "AGE", "GENDER", "COURSE", "YEAR", "SECTION", "PF", "NET", "IM", "MS", "AVG", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jTable.setMinimumSize(new java.awt.Dimension(90, 0));
        jTable.setRowHeight(25);
        jTable.setShowGrid(true);
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setResizable(false);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable.getColumnModel().getColumn(1).setResizable(false);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(300);
            jTable.getColumnModel().getColumn(2).setResizable(false);
            jTable.getColumnModel().getColumn(3).setResizable(false);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(75);
            jTable.getColumnModel().getColumn(4).setResizable(false);
            jTable.getColumnModel().getColumn(4).setPreferredWidth(75);
            jTable.getColumnModel().getColumn(5).setResizable(false);
            jTable.getColumnModel().getColumn(6).setResizable(false);
            jTable.getColumnModel().getColumn(6).setPreferredWidth(75);
            jTable.getColumnModel().getColumn(7).setResizable(false);
            jTable.getColumnModel().getColumn(7).setPreferredWidth(50);
            jTable.getColumnModel().getColumn(8).setResizable(false);
            jTable.getColumnModel().getColumn(8).setPreferredWidth(50);
            jTable.getColumnModel().getColumn(9).setResizable(false);
            jTable.getColumnModel().getColumn(9).setPreferredWidth(50);
            jTable.getColumnModel().getColumn(10).setResizable(false);
            jTable.getColumnModel().getColumn(10).setPreferredWidth(50);
            jTable.getColumnModel().getColumn(11).setResizable(false);
            jTable.getColumnModel().getColumn(11).setPreferredWidth(50);
            jTable.getColumnModel().getColumn(12).setResizable(false);
            jTable.getColumnModel().getColumn(12).setPreferredWidth(75);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jshowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jshowActionPerformed
  Fetch();
    }//GEN-LAST:event_jshowActionPerformed

    private void jupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jupdateActionPerformed
//Convert textfield, combobox, spinner into string   
    String Name = jname.getText();
    String Age = jage1.getValue().toString();
    String Gender = (String) jgender.getSelectedItem();
    String Course = (String) jcourse.getSelectedItem();
    String Year = (String) jyear.getSelectedItem();
    String Section = (String) jsection.getSelectedItem();
    String Pf = jpf.getText();
    String Net = jnet.getText();
    String Im = jim.getText();
    String Ms = jms.getText();
        if(jTable.getSelectedRow() == -1){
        JOptionPane.showMessageDialog(jPanel1, "Please select the table");
        }
        else{
             if(Name.isEmpty()|| Pf.isEmpty() || Net.isEmpty() || Im.isEmpty() || Ms.isEmpty()){
     JOptionPane.showMessageDialog(jPanel1, "Please input student information");
    }
    else{
    // convert subjects into double
    try{
    int selectedRow = jTable.getSelectedRow();
    Object id = jTable.getValueAt(selectedRow, NORMAL);
    double dpf = Double.parseDouble(Pf);
    double dnet = Double.parseDouble(Net);
    double dim = Double.parseDouble(Im);
    double dms = Double.parseDouble(Im);
    double avg = (dms + dim + dnet + dpf)/4;
    String stat = (avg >= 75) ? "Passed" : "Failed";
    if(dpf <= 100 && dnet <= 100 && dim <= 100 && dms <= 100){
        try{
        pst = con.prepareStatement("UPDATE stud SET name = ?, age = ?, gender = ?, course = ?, year = ?, section = ?, pf = ?, net = ?, im = ?, ms = ?, avg = ?, status = ? WHERE id = ?");
            pst.setString(1, Name);
            pst.setString(2, Age);
            pst.setString(3, Gender);
            pst.setString(4, Course);
            pst.setString(5, Year);
            pst.setString(6, Section);
            pst.setDouble(7, dpf);
            pst.setDouble(8, dnet);
            pst.setDouble(9, dim);
            pst.setDouble(10, dms);
            pst.setDouble(11, avg);
            pst.setString(12, stat);
            pst.setObject(13, id);
               int k = pst.executeUpdate();
            if(k ==1){
                JOptionPane.showMessageDialog(this, "Record Update Successfully");
            }
            else{
                JOptionPane.showMessageDialog(this, "Record Failed");
            }    
        }
        catch (SQLException ex) {
            Logger.getLogger(stud.class.getName()).log(Level.SEVERE, null, ex);
        }
        Fetch();
        
         //set textfield empty
            jname.setText("");
            jage1.setValue(18);
            jgender.setSelectedIndex(0);
            jcourse.setSelectedIndex(0);
            jyear.setSelectedIndex(0);
            jsection.setSelectedIndex(0);
            jpf.setText("");
            jnet.setText("");
            jim.setText("");
            jms.setText("");
    }
    else{
    JOptionPane.showMessageDialog(jPanel1, "The Maximum grade you can input is 100");
    }
    }
    catch(NumberFormatException e){
     JOptionPane.showMessageDialog(jPanel1, "Please enter a valid number");
    }
    }
    }//GEN-LAST:event_jupdateActionPerformed
    }
    private void jcsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcsvActionPerformed
      String filename = "D:\\ExportedFileJava.csv";
      
        try {
            FileWriter fw = new FileWriter(filename);
            pst = con.prepareStatement("SELECT * FROM stud");
            rs = pst.executeQuery();
            
            while(rs.next()){
            fw.append(rs.getString(1));
             fw.append(',');
             fw.append(rs.getString(2));
             fw.append(',');
             fw.append(rs.getString(3));
             fw.append(',');
             fw.append(rs.getString(4));
             fw.append(',');
             fw.append(rs.getString(5));
             fw.append(',');
             fw.append(rs.getString(6));
             fw.append(',');
             fw.append(rs.getString(7));
             fw.append(',');
             fw.append(rs.getString(8));
             fw.append(',');
             fw.append(rs.getString(9));
             fw.append(',');
             fw.append(rs.getString(10));
             fw.append(',');
             fw.append(rs.getString(11));
             fw.append(',');
             fw.append(rs.getString(12));
             fw.append(',');
             fw.append(rs.getString(13));
             fw.append('\n');
            }
             JOptionPane.showMessageDialog(jPanel1, "csv file exported successfully");
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(stud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(stud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcsvActionPerformed

    private void jpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpdfActionPerformed
        try {
            pst = con.prepareStatement("SELECT * FROM stud");
            rs = pst.executeQuery();
            
            Document PDFreport = new Document();
            PdfWriter.getInstance(PDFreport, new FileOutputStream("D:\\OutputReportJava.pdf"));
            
            PDFreport.open();
            
            PdfPTable PDFTable = new PdfPTable(13);
            PdfPCell table_cell;
            
            while(rs.next()){
            String id = rs.getString("id");
            table_cell = new PdfPCell (new Phrase(id));
            PDFTable.addCell(table_cell);
            
             String name = rs.getString("name");
            table_cell = new PdfPCell (new Phrase(name));
            PDFTable.addCell(table_cell);
            
             String age = rs.getString("age");
            table_cell = new PdfPCell (new Phrase(age));
            PDFTable.addCell(table_cell);
            
             String gender = rs.getString("gender");
            table_cell = new PdfPCell (new Phrase(gender));
            PDFTable.addCell(table_cell);
            
             String course = rs.getString("course");
            table_cell = new PdfPCell (new Phrase(course));
            PDFTable.addCell(table_cell);
            
             String year = rs.getString("year");
            table_cell = new PdfPCell (new Phrase(year));
            PDFTable.addCell(table_cell);
            
             String section = rs.getString("section");
            table_cell = new PdfPCell (new Phrase(section));
            PDFTable.addCell(table_cell);
            
             String pf = rs.getString("pf");
            table_cell = new PdfPCell (new Phrase(pf));
            PDFTable.addCell(table_cell);
            
             String net = rs.getString("net");
            table_cell = new PdfPCell (new Phrase(net));
            PDFTable.addCell(table_cell);
            
             String im = rs.getString("im");
            table_cell = new PdfPCell (new Phrase(im));
            PDFTable.addCell(table_cell);
            
             String ms = rs.getString("ms");
            table_cell = new PdfPCell (new Phrase(ms));
            PDFTable.addCell(table_cell);
            
             String avg = rs.getString("avg");
            table_cell = new PdfPCell (new Phrase(avg));
            PDFTable.addCell(table_cell);
            
             String status = rs.getString("status");
            table_cell = new PdfPCell (new Phrase(status));
            PDFTable.addCell(table_cell);
            }
            JOptionPane.showMessageDialog(jPanel1, "pdf file exported successfully");
            
            PDFreport.add(PDFTable);
            PDFreport.close();
        } catch (SQLException ex) {
            Logger.getLogger(stud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(stud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(stud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jpdfActionPerformed

    private void jsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsearchActionPerformed
        String dsearch = search.getText();
        if(dsearch.isEmpty()){
         JOptionPane.showMessageDialog(jPanel1, "Search Field is Blank");
        }
        else{
        Search(dsearch);}
    }//GEN-LAST:event_jsearchActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void jimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jimActionPerformed

    private void jcreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcreateActionPerformed
    //Convert textfield, combobox, spinner into string   
    String Name = jname.getText();
    String Age = jage1.getValue().toString();
    String Gender = (String) jgender.getSelectedItem();
    String Course = (String) jcourse.getSelectedItem();
    String Year = (String) jyear.getSelectedItem();
    String Section = (String) jsection.getSelectedItem();
    String Pf = jpf.getText();
    String Net = jnet.getText();
    String Im = jim.getText();
    String Ms = jms.getText();
    // Use condition if the variables are empty or not
    if(Name.isEmpty()|| Pf.isEmpty() || Net.isEmpty() || Im.isEmpty() || Ms.isEmpty()){
     JOptionPane.showMessageDialog(jPanel1, "Please input student information");
    }
    else{
    // convert subjects into double
    try{
    double dpf = Double.parseDouble(Pf);
    double dnet = Double.parseDouble(Net);
    double dim = Double.parseDouble(Im);
    double dms = Double.parseDouble(Im);
    double avg = (dms + dim + dnet + dpf)/4;
    String stat = (avg >= 75) ? "Passed" : "Failed";
    if(dpf <= 100 && dnet <= 100 && dim <= 100 && dms <= 100){
        try{
        pst = con.prepareStatement("INSERT INTO stud (name, age, gender, course, year,  section, pf, net, im, ms, avg, status ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, Name);
            pst.setString(2, Age);
            pst.setString(3, Gender);
            pst.setString(4, Course);
             pst.setString(5, Year);
            pst.setString(6, Section);
            pst.setDouble(7, dpf);
            pst.setDouble(8, dnet);
            pst.setDouble(9, dim);
            pst.setDouble(10, dms);
            pst.setDouble(11, avg);
            pst.setString(12, stat);
            
               int k = pst.executeUpdate();
            if(k ==1){
                JOptionPane.showMessageDialog(this, "Record Added Successfully");
            }
            else{
                JOptionPane.showMessageDialog(this, "Record Failed");
            }    
        }
        catch (SQLException ex) {
            Logger.getLogger(stud.class.getName()).log(Level.SEVERE, null, ex);
        }
        Fetch();
        
        //set textfield empty
            jname.setText("");
            jage1.setValue(18);
            jgender.setSelectedIndex(0);
            jcourse.setSelectedIndex(0);
            jyear.setSelectedIndex(0);
            jsection.setSelectedIndex(0);
            jpf.setText("");
            jnet.setText("");
            jim.setText("");
            jms.setText("");
            
     
    }
    else{
    JOptionPane.showMessageDialog(jPanel1, "The Maximum grade you can input is 100");
    }
    }
    catch(NumberFormatException e){
     JOptionPane.showMessageDialog(jPanel1, "Please enter a valid number");
    }
    }
    }//GEN-LAST:event_jcreateActionPerformed

    private void jdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdeleteActionPerformed
       if(jTable.getSelectedRow() == -1){
     JOptionPane.showMessageDialog(jPanel1, "Please select table");}
         else{
             try{
         int selectedRow = jTable.getSelectedRow();
         Object id = jTable.getValueAt(selectedRow, NORMAL);
         delete(id);
         Fetch();
         //set textfield empty
            jname.setText("");
            jage1.setValue(18);
            jgender.setSelectedIndex(0);
            jcourse.setSelectedIndex(0);
            jyear.setSelectedIndex(0);
            jsection.setSelectedIndex(0);
            jpf.setText("");
            jnet.setText("");
            jim.setText("");
            jms.setText("");     
             }
             catch(SQLException ex){
                             Logger.getLogger(stud.class.getName()).log(Level.SEVERE, null, ex);
             }
    }                                      
    }//GEN-LAST:event_jdeleteActionPerformed

    private void jmsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmsActionPerformed

    private void jage1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jage1InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jage1InputMethodTextChanged

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
          if(jTable.getSelectedRow() == -1){
        JOptionPane.showMessageDialog(jPanel1, "Please select the table");
        }
          else{
        int selectedRow = jTable.getSelectedRow();
        String cname = jTable.getValueAt(selectedRow, 1).toString();
        int cage = Integer.parseInt(jTable.getValueAt(selectedRow, 2).toString());
        String cgender = jTable.getValueAt(selectedRow, 3).toString();
        String ccourse = jTable.getValueAt(selectedRow, 4).toString();
        String cyear = jTable.getValueAt(selectedRow, 5).toString();
        String csection = jTable.getValueAt(selectedRow, 6).toString();
        String cpf = jTable.getValueAt(selectedRow, 7).toString();
        String cnet = jTable.getValueAt(selectedRow, 8).toString();
        String cim = jTable.getValueAt(selectedRow, 9).toString();
        String cms = jTable.getValueAt(selectedRow, 10).toString();
        
        // set the values sa textfields, combobox, and spinner
         jname.setText(cname);
    jage1.setValue(cage);
    jgender.setSelectedItem(cgender);
    jcourse.setSelectedItem(ccourse);
    jyear.setSelectedItem(cyear);
    jsection.setSelectedItem(csection);
    jpf.setText(cpf);
    jnet.setText(cnet);
    jim.setText(cim);
    jms.setText(cms);
    }//GEN-LAST:event_jTableMouseClicked
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(stud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable;
    private javax.swing.JSpinner jage1;
    private javax.swing.JComboBox<String> jcourse;
    private javax.swing.JButton jcreate;
    private javax.swing.JButton jcsv;
    private javax.swing.JButton jdelete;
    private javax.swing.JComboBox<String> jgender;
    private javax.swing.JTextField jim;
    private javax.swing.JTextField jms;
    private javax.swing.JTextField jname;
    private javax.swing.JTextField jnet;
    private javax.swing.JButton jpdf;
    private javax.swing.JTextField jpf;
    private javax.swing.JButton jsearch;
    private javax.swing.JComboBox<String> jsection;
    private javax.swing.JButton jshow;
    private javax.swing.JButton jupdate;
    private javax.swing.JComboBox<String> jyear;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
