/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembler;

import datapath.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ramak
 */
public class NewJFrame extends javax.swing.JFrame {

    String filename;
    String filedirectory;
    boolean firstsave = false;
    String outputfile;
    String dir;
    String file;
    public primary_memory memory = new primary_memory();
    boolean pip=false;
Object[][] reg=new Object [][] {
        {"x0", 0},
        {"x1", 0},
        {"x2", memory.register[2]},
        {"x3", memory.register[3]},
        {"x4", 0},
        {"x5", 0},
        {"x6", 0},
        {"x7", 0},
        {"x8", 0},
        {"x9", 0},
        {"x10", 0},
        {"x11", 0},
        {"x12", 0},
        {"x13", 0},
        {"x14", 0},
        {"x15", 0},
        {"x16", 0},
        {"x17", 0},
        {"x18", 0},
        {"x19", 0},
        {"x20", 0},
        {"x21", 0},
        {"x22", 0},
        {"x23", 0},
        {"x24", 0},
        {"x25", 0},
        {"x26", 0},
        {"x27", 0},
        {"x28", 0},
        {"x29", 0},
        {"x30", 0},
        {"x31", 0},};
    String[] column=new String [] {
        "Register", "Value"
    };
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        Run = new javax.swing.JButton();
        Build = new javax.swing.JButton();
        pipeline = new javax.swing.JToggleButton();
        MenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        New = new javax.swing.JMenuItem();
        Open = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        SaveAs = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        Cut = new javax.swing.JMenuItem();
        Paste = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextArea1.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextArea3.setRows(5);
        jTextArea3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane3.setViewportView(jTextArea3);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            reg,column
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        //jTable1.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        jTable1.setRowHeight(25);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

        Run.setText("Run");
        Run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RunActionPerformed(evt);
            }
        });

        Build.setText("Build");
        Build.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuildActionPerformed(evt);
            }
        });

        pipeline.setText("pipeline");
        pipeline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pipelineActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        New.setText("New");
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });
        jMenu1.add(New);

        Open.setText("Open");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        jMenu1.add(Open);

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jMenu1.add(Save);

        SaveAs.setText("Save As");
        SaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveAsActionPerformed(evt);
            }
        });
        jMenu1.add(SaveAs);

        MenuBar.add(jMenu1);

        Edit.setText("Edit");

        Cut.setText("Cut");
        Edit.add(Cut);

        Paste.setText("Paste");
        Edit.add(Paste);

        MenuBar.add(Edit);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Build, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Run)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pipeline, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Run)
                        .addComponent(Build, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pipeline, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    // MenuBar.add(jButton1);
    private void NewActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        jTextArea1.setText("");
        setTitle(filename);

    }

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        FileDialog fileDialog = new FileDialog(NewJFrame.this, "Open File", FileDialog.LOAD);
        fileDialog.setVisible(true);
        if (fileDialog.getFile() != null) {
            filename = fileDialog.getDirectory() + fileDialog.getFile();
            setTitle(filename);
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
                jTextArea1.setText(sb.toString());

            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    private void SaveAsActionPerformed(java.awt.event.ActionEvent evt) {
        FileDialog fileDialog = new FileDialog(NewJFrame.this, "Save File", FileDialog.SAVE);
        fileDialog.setVisible(true);
        if (fileDialog.getFile() != null) {
            filename = fileDialog.getDirectory() + fileDialog.getFile();
            file = fileDialog.getFile();
            dir = fileDialog.getDirectory();
            setTitle(filename);
        }
        try {
            FileWriter filewriter = new FileWriter(filename);
            String content = jTextArea1.getText();
            content = content.replaceAll("(?!\\r)\\n", "\r\n");
            filewriter.write(content);
            setTitle(filename);
            filewriter.flush();
            filewriter.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        firstsave = true;
    }

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (firstsave == false) {
            SaveAsActionPerformed(evt);
            // firstsave = true;
        }
        try {
            FileWriter filewriter = new FileWriter(filename);
            String content = jTextArea1.getText();
            content = content.replaceAll("(?!\\r)\\n", "\r\n");
            filewriter.write(content);
//filewriter.write(jTextArea1.getText());
            setTitle(filename);
            filewriter.close();
            filewriter.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }


    }

    private void BuildActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        SaveActionPerformed(evt);
        assembler obj = new assembler();
        try {
            obj.assemble(filename,memory);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // PrintWriter p=null;
        //creating output filename
        int temp = file.indexOf('.');
        outputfile = dir + file.substring(0, temp) + ".mc";
        PrintWriter p;

        try {
            p = new PrintWriter(new FileOutputStream(outputfile, false));
            for (int i = 0; i < obj.instructions_temp.length; i++) {
                Long decimal = Long.parseLong(obj.instructions_temp[i].binary, 2);
                // String hexStr = Integer.toString(decimal, 16);
                // System.out.println(decimal.toHexString());
                // System.out.println(String.format("0x%08X", decimal));
                // PrintWriter writer = nul
                p.println(String.format("0x%08X", decimal));

                // p.flush();
            }
            // p.println(assembler.instructions_temp.length);
            p.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextArea3.setEditable(true);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(outputfile));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
                jTextArea3.setText(sb.toString());

            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        jTextArea3.setEditable(false);
    }

    private void RunActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        BuildActionPerformed(evt);
        File file = new File(outputfile);
        memory.set_primary_memory();
        int mem_index=0;
                try
                {

                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String line;
                    //System.out.println("No input");
                    while ((line = br.readLine()) != null)
                        {
                            //System.out.println(line);
                            long itemp = Long.parseLong(line.substring(2), 16);
                            String bin_line = Long.toBinaryString(itemp);
                            String temp="";
                            for (int i = 0; i < 32 - bin_line.length(); i++)
                            {
                                    temp = temp + "0";
                            }
                            memory.storewordstr(mem_index,temp+bin_line);
                            //System.out.println(mem.loadword(mem_index)+"p");
                            mem_index=mem_index+4;

                        }
                }
                catch(Exception e){System.out.println("No input");}
        datapath dat=new datapath();
        dat.run(memory,pip);
        for(int i=0;i<32;i++)
        {
            if(i==0)
                reg[i][1]=0;
            reg[i][1]=memory.register[i];
        }
        jTable1.setModel(new DefaultTableModel(reg, column));
    }

    private void pipelineActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        pip=!pip;
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton Build;
    private javax.swing.JMenuItem Cut;
    private javax.swing.JMenu Edit;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem New;
    private javax.swing.JMenuItem Open;
    private javax.swing.JMenuItem Paste;
    private javax.swing.JButton Run;
    private javax.swing.JMenuItem Save;
    private javax.swing.JMenuItem SaveAs;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JToggleButton pipeline;
    // End of variables declaration
}
