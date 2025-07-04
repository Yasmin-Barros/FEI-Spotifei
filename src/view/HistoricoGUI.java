/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControllerHistorico;
import controller.ControllerMusicas;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.sql.SQLException;


/**
 *
 * @author unifybarros
 */
public class HistoricoGUI extends javax.swing.JFrame {

    /**
     * Creates new form Historico
     */
    public HistoricoGUI() {
        initComponents();
        getContentPane().setBackground(new Color(12,12,12)); 
        setLocationRelativeTo(null); 
        jTabbedPane1.setForeground(Color.WHITE); // Cor de fundo dos botões de aba

        
        jTabbedPane1.addChangeListener(e -> {
        int index = jTabbedPane1.getSelectedIndex();
        if (index == 1) { // Aba 1 = Histórico
            try {
                ControllerHistorico controller = new ControllerHistorico(this);
                controller.carregarHistorico();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    });
        
        jTabbedPane1.addChangeListener(e -> {
        int index = jTabbedPane1.getSelectedIndex();
        if (index == 2) { // Aba2 = Curtidas
            try {
                ControllerHistorico controller = new ControllerHistorico(this);
                controller.carregarCurtidas();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    });
        
        jTabbedPane1.addChangeListener(e -> {
        int index = jTabbedPane1.getSelectedIndex();
        if (index == 3) { // Aba 3 = Descirrtodas
            try {
                ControllerHistorico controller = new ControllerHistorico(this);
                controller.carregarDescurtidas();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTextArea1 = new javax.swing.JTextArea();
        tabHistorico = new javax.swing.JScrollPane();
        tabelaResultadoHistorico = new javax.swing.JTable();
        tabCurtidas = new javax.swing.JScrollPane();
        tabelaResultadoCurtidas = new javax.swing.JTable();
        tabDescurtidas = new javax.swing.JScrollPane();
        tabelaResultadoDescurtidas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        botaoVoltar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(29, 185, 84));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Seja bem-vindo(a) so seu histórico! Aqui você encontrará:\n\n- Histórico de buscas;\n- Lista das músicas que você curtiu;\n- Lista das músicas que você descurtiu.\n");
        jTabbedPane1.addTab("Início", jTextArea1);

        tabelaResultadoHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Buscas recentes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabHistorico.setViewportView(tabelaResultadoHistorico);

        jTabbedPane1.addTab("Histórico", tabHistorico);

        tabelaResultadoCurtidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Título", "Gênero", "Artista", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabCurtidas.setViewportView(tabelaResultadoCurtidas);
        if (tabelaResultadoCurtidas.getColumnModel().getColumnCount() > 0) {
            tabelaResultadoCurtidas.getColumnModel().getColumn(3).setMinWidth(0);
            tabelaResultadoCurtidas.getColumnModel().getColumn(3).setPreferredWidth(0);
            tabelaResultadoCurtidas.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        jTabbedPane1.addTab("Curtidas", tabCurtidas);

        tabelaResultadoDescurtidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Título", "Gênero", "Artista", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabDescurtidas.setViewportView(tabelaResultadoDescurtidas);
        if (tabelaResultadoDescurtidas.getColumnModel().getColumnCount() > 0) {
            tabelaResultadoDescurtidas.getColumnModel().getColumn(3).setMinWidth(0);
            tabelaResultadoDescurtidas.getColumnModel().getColumn(3).setPreferredWidth(0);
            tabelaResultadoDescurtidas.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        jTabbedPane1.addTab("Descurtidas", tabDescurtidas);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/By Yasmin Barros (3) (2).png"))); // NOI18N

        botaoVoltar1.setBackground(new java.awt.Color(29, 185, 84));
        botaoVoltar1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        botaoVoltar1.setForeground(new java.awt.Color(0, 0, 0));
        botaoVoltar1.setText("Voltar");
        botaoVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botaoVoltar1)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(botaoVoltar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltar1ActionPerformed
        new PaginaInicialGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoVoltar1ActionPerformed

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
    }

    public JTable getjTable3() {
        return tabelaResultadoDescurtidas;
    }

    public void setjTable3(JTable jTable3) {
        this.tabelaResultadoDescurtidas = jTable3;
    }

    public JScrollPane getTabCurtidas() {
        return tabCurtidas;
    }

    public void setTabCurtidas(JScrollPane tabCurtidas) {
        this.tabCurtidas = tabCurtidas;
    }

    public JScrollPane getTabDescurtidas() {
        return tabDescurtidas;
    }

    public void setTabDescurtidas(JScrollPane tabDescurtidas) {
        this.tabDescurtidas = tabDescurtidas;
    }

    public JScrollPane getTabHistorico() {
        return tabHistorico;
    }

    public void setTabHistorico(JScrollPane tabHistorico) {
        this.tabHistorico = tabHistorico;
    }

    public JTable getTabelaCurtidas() {
        return tabelaResultadoCurtidas;
    }

    public void setTabelaCurtidas(JTable tabelaCurtidas) {
        this.tabelaResultadoCurtidas = tabelaCurtidas;
    }

    public JTable getTabelaResultadoHistorico() {
        return tabelaResultadoHistorico;
    }

    public void setTabelaResultadoHistorico(JTable tabelaResultadoHistorico) {
        this.tabelaResultadoHistorico = tabelaResultadoHistorico;
    }

    public JTable getTabelaResultadoCurtidas() {
        return tabelaResultadoCurtidas;
    }

    public JTable getTabelaResultadoDescurtidas() {
        return tabelaResultadoDescurtidas;
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
            java.util.logging.Logger.getLogger(HistoricoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoricoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoricoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoricoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoricoGUI().setVisible(true);
                }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoVoltar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JScrollPane tabCurtidas;
    private javax.swing.JScrollPane tabDescurtidas;
    private javax.swing.JScrollPane tabHistorico;
    private javax.swing.JTable tabelaResultadoCurtidas;
    private javax.swing.JTable tabelaResultadoDescurtidas;
    private javax.swing.JTable tabelaResultadoHistorico;
    // End of variables declaration//GEN-END:variables
}
