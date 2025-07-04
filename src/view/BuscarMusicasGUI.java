/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControllerMusicas;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author unifybarros
 */
public class BuscarMusicasGUI extends javax.swing.JFrame {
    //private int idUsuario;

    /**
     * Creates new form Buscarmu
     */
    public BuscarMusicasGUI() {
        initComponents();
        getContentPane().setBackground(new Color(12, 12, 12));
        setLocationRelativeTo(null); 
    }

    public JButton getBotaoBuscarMusica() {
        return botaoBuscarMusica;
    }

    public void setBotaoBuscarMusica(JButton botaoBuscarMusica) {
        this.botaoBuscarMusica = botaoBuscarMusica;
    }

    public JTextField getCaixaBusca() {
        return caixaBusca;
    }

    public void setCaixaBusca(JTextField caixaBusca) {
        this.caixaBusca = caixaBusca;
    }

    public JTable getTabelaResultadoMusicas() {
        return tabelaResultadoMusicas;
    }

    public void setTabelaResultadoMusicas(JTable tabelaResultadoMusicas) {
        this.tabelaResultadoMusicas = tabelaResultadoMusicas;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaResultadoMusicas = new javax.swing.JTable();
        caixaBusca = new javax.swing.JTextField();
        botaoBuscarMusica = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botaoCurtir = new javax.swing.JButton();
        botaoDescurtir = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaResultadoMusicas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Título", "Gênero", "Artista", "id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaResultadoMusicas);
        if (tabelaResultadoMusicas.getColumnModel().getColumnCount() > 0) {
            tabelaResultadoMusicas.getColumnModel().getColumn(3).setMinWidth(0);
            tabelaResultadoMusicas.getColumnModel().getColumn(3).setPreferredWidth(0);
            tabelaResultadoMusicas.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        caixaBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caixaBuscaActionPerformed(evt);
            }
        });

        botaoBuscarMusica.setBackground(new java.awt.Color(29, 185, 84));
        botaoBuscarMusica.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        botaoBuscarMusica.setForeground(new java.awt.Color(0, 0, 0));
        botaoBuscarMusica.setText("Procurar");
        botaoBuscarMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarMusicaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Música:");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/By Yasmin Barros (3) (2).png"))); // NOI18N
        jLabel2.setText("jLabel1");

        botaoCurtir.setBackground(new java.awt.Color(255, 102, 102));
        botaoCurtir.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        botaoCurtir.setForeground(new java.awt.Color(0, 0, 0));
        botaoCurtir.setText("Curtir");
        botaoCurtir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCurtirActionPerformed(evt);
            }
        });

        botaoDescurtir.setBackground(new java.awt.Color(255, 102, 102));
        botaoDescurtir.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        botaoDescurtir.setForeground(new java.awt.Color(0, 0, 0));
        botaoDescurtir.setText("Descurtir");
        botaoDescurtir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDescurtirActionPerformed(evt);
            }
        });

        botaoVoltar.setBackground(new java.awt.Color(29, 185, 84));
        botaoVoltar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        botaoVoltar.setForeground(new java.awt.Color(0, 0, 0));
        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(124, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(caixaBusca)
                        .addGap(18, 18, 18)
                        .addComponent(botaoBuscarMusica)
                        .addGap(23, 23, 23))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoCurtir)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoDescurtir)
                                .addGap(64, 64, 64)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botaoVoltar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(botaoVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caixaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(botaoBuscarMusica))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoCurtir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoDescurtir)
                        .addGap(59, 59, 59))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void caixaBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixaBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caixaBuscaActionPerformed

    private void botaoBuscarMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarMusicaActionPerformed
        try {
            ControllerMusicas controller = new ControllerMusicas(this);
            controller.buscarMusica();
        } catch (SQLException ex) {
            Logger.getLogger(BuscarMusicasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoBuscarMusicaActionPerformed

    private void botaoCurtirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCurtirActionPerformed
        try {
            ControllerMusicas controller = new ControllerMusicas(this);
            controller.curtirMusica();
        } catch (SQLException ex) {
            Logger.getLogger(BuscarMusicasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoCurtirActionPerformed

    private void botaoDescurtirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDescurtirActionPerformed
        try {
            ControllerMusicas controller = new ControllerMusicas(this);
            controller.descurtirMusica();
        } catch (SQLException ex) {
            Logger.getLogger(BuscarMusicasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoDescurtirActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        new PaginaInicialGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarMusicasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarMusicasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarMusicasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarMusicasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarMusicasGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoBuscarMusica;
    private javax.swing.JButton botaoCurtir;
    private javax.swing.JButton botaoDescurtir;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JTextField caixaBusca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaResultadoMusicas;
    // End of variables declaration//GEN-END:variables
}
