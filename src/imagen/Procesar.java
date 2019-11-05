/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagen;

import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public class Procesar extends javax.swing.JFrame {

    private imagen obj = new imagen();

    /**
     * Creates new form Procesar
     */
    public Procesar() {
        initComponents();
        setTitle("Procesar Imagen");
        filtro_manual.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        girar = new javax.swing.JButton();
        ac_filtro_manual = new javax.swing.JCheckBox();
        filtro_manual = new javax.swing.JSlider();
        btnSave = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jsliderContrast = new javax.swing.JSlider();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblPaciente = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblDoctor = new javax.swing.JLabel();
        lblLugar = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnNoneFiltro = new javax.swing.JMenuItem();
        btnBordes = new javax.swing.JMenuItem();
        btnNegativo = new javax.swing.JMenuItem();
        btnEspejoHorizontal = new javax.swing.JMenuItem();
        btnEspejoVertical = new javax.swing.JMenuItem();
        btnGrises = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 153, 204));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rotación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 51))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        girar.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        girar.setText("90 Grados");
        girar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                girarActionPerformed(evt);
            }
        });

        ac_filtro_manual.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ac_filtro_manual.setText("Girar Manualmente");
        ac_filtro_manual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ac_filtro_manualActionPerformed(evt);
            }
        });

        filtro_manual.setMajorTickSpacing(50);
        filtro_manual.setMaximum(360);
        filtro_manual.setPaintLabels(true);
        filtro_manual.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        filtro_manual.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                filtro_manualStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(filtro_manual, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(girar))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(ac_filtro_manual)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(girar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ac_filtro_manual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filtro_manual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnSave.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recortar Imagen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 51))); // NOI18N

        TAncho.setMaximum(0);
        TAncho.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TAnchoStateChanged(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jButton2.setText("Guardar Recorte");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TAncho, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TAncho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contraste", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        jsliderContrast.setMajorTickSpacing(50);
        jsliderContrast.setPaintLabels(true);
        jsliderContrast.setValue(100);
        jsliderContrast.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsliderContrastStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jsliderContrast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jsliderContrast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setForeground(new java.awt.Color(204, 255, 204));

        lblPaciente.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblPaciente.setForeground(new java.awt.Color(255, 255, 255));
        lblPaciente.setText("Paciente: ");

        lblEdad.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblEdad.setForeground(new java.awt.Color(255, 255, 255));
        lblEdad.setText("Edad:");

        lblDoctor.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblDoctor.setForeground(new java.awt.Color(255, 255, 255));
        lblDoctor.setText("Doctor:");

        lblLugar.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lblLugar.setForeground(new java.awt.Color(255, 255, 255));
        lblLugar.setText("Lugar:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLugar)
                    .addComponent(lblDoctor)
                    .addComponent(lblEdad)
                    .addComponent(lblPaciente))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEdad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDoctor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLugar)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(106, 106, 106)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Filtro");

        btnNoneFiltro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNoneFiltro.setText("Ninguno");
        btnNoneFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoneFiltroActionPerformed(evt);
            }
        });
        jMenu2.add(btnNoneFiltro);

        btnBordes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBordes.setText("Borders");
        btnBordes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBordesActionPerformed(evt);
            }
        });
        jMenu2.add(btnBordes);

        btnNegativo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNegativo.setText("Negativo");
        btnNegativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNegativoActionPerformed(evt);
            }
        });
        jMenu2.add(btnNegativo);

        btnEspejoHorizontal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEspejoHorizontal.setText("Espejo Horizontal");
        btnEspejoHorizontal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEspejoHorizontalActionPerformed(evt);
            }
        });
        jMenu2.add(btnEspejoHorizontal);

        btnEspejoVertical.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEspejoVertical.setText("Espejo Vertical");
        btnEspejoVertical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEspejoVerticalActionPerformed(evt);
            }
        });
        jMenu2.add(btnEspejoVertical);

        btnGrises.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGrises.setText("Escala Grises");
        btnGrises.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrisesActionPerformed(evt);
            }
        });
        jMenu2.add(btnGrises);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        ///     ABRIENDO ARCHIVO
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        try {
            //llamada del metodo cargar imagen
            obj.cargaImag();
            obj.setVisible(true);
            //obtener ruta            
            ShowOriginal();
        } catch (Exception e) {
            System.out.println("");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed
//          FILTROS
    private void btnNoneFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoneFiltroActionPerformed
        // NINGUNO
        if (obj.isVisible()) {
            //seleccion NINGUN FILTRO
            obj.r_efecto(0);
            obj.repaint();
        }
    }//GEN-LAST:event_btnNoneFiltroActionPerformed

    private void btnBordesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBordesActionPerformed
        // TODO add your handling code here:
        if (obj.isVisible()) {
            //seleccion BORDERS
            obj.r_efecto(10);
            obj.repaint();
        }
    }//GEN-LAST:event_btnBordesActionPerformed

    private void btnNegativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNegativoActionPerformed
        // TODO add your handling code here:
        if (obj.isVisible()) {
            //seleccion NEGATIVO
            obj.r_efecto(9);
            obj.repaint();
        }
    }//GEN-LAST:event_btnNegativoActionPerformed
////// Fin FILTROS
    private void girarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_girarActionPerformed
        try {
            //llamamada del metodo rotar imagen
            obj.rotacionImagen(90);
            obj.actualiza_frame();
            obj.repaint();
            //Se giró la imagen
        } catch (Exception e) {
            System.out.println("");
        }
    }//GEN-LAST:event_girarActionPerformed

    private void ac_filtro_manualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ac_filtro_manualActionPerformed

        if (ac_filtro_manual.isSelected()) {
            filtro_manual.setEnabled(true);
            //Giro manual ACTIVADO
        } else {
            filtro_manual.setEnabled(false);
            //"Giro manual DESACTIVADO
        }
    }//GEN-LAST:event_ac_filtro_manualActionPerformed

    private void filtro_manualStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_filtro_manualStateChanged
        //llamada del metodo grados para girar la imagen
        obj.Grados(filtro_manual.getValue());
        obj.r_efecto(4);
    }//GEN-LAST:event_filtro_manualStateChanged

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void TAnchoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TAnchoStateChanged
        //llamada del metodo recortar imagen
        try {
            obj.RecortarImagen();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_TAnchoStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //llamada del metodo guardar recorte
        obj.GuardarRecorte();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnEspejoHorizontalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEspejoHorizontalActionPerformed
        // TODO add your handling code here:
        if (obj.isVisible()) {
            //seleccion Espejo Horizontal
            obj.r_efecto(7);
            obj.repaint();
        }
    }//GEN-LAST:event_btnEspejoHorizontalActionPerformed

    private void btnEspejoVerticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEspejoVerticalActionPerformed
        // TODO add your handling code here:
        if (obj.isVisible()) {
            //seleccion Espejo Vertical
            obj.r_efecto(8);
            obj.repaint();
        }
    }//GEN-LAST:event_btnEspejoVerticalActionPerformed

    private void btnGrisesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrisesActionPerformed
        // TODO add your handling code here:
        if (obj.isVisible()) {
            //seleccion Escala Grises
            obj.r_efecto(3);
            obj.repaint();
        }
    }//GEN-LAST:event_btnGrisesActionPerformed

    private void jsliderContrastStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsliderContrastStateChanged
        // TODO add your handling code here:
        if (obj.isVisible()) {
            //Contraste            
            obj.Contraste(jsliderContrast.getValue());
            obj.r_efecto(12);
        }
    }//GEN-LAST:event_jsliderContrastStateChanged

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
            java.util.logging.Logger.getLogger(Procesar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Procesar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Procesar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Procesar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Procesar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JSlider TAncho = new javax.swing.JSlider();
    private javax.swing.JCheckBox ac_filtro_manual;
    private javax.swing.JMenuItem btnBordes;
    private javax.swing.JMenuItem btnEspejoHorizontal;
    private javax.swing.JMenuItem btnEspejoVertical;
    private javax.swing.JMenuItem btnGrises;
    private javax.swing.JMenuItem btnNegativo;
    private javax.swing.JMenuItem btnNoneFiltro;
    private javax.swing.JButton btnSave;
    private javax.swing.JSlider filtro_manual;
    private javax.swing.JButton girar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSlider jsliderContrast;
    private javax.swing.JLabel lblDoctor;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblLugar;
    private javax.swing.JLabel lblPaciente;
    // End of variables declaration//GEN-END:variables
    public void ShowOriginal() {
        try {
            //cargar imagen en la 1º ventana
            ImageIcon icon = new ImageIcon(obj.RutaFull);
            icon = new ImageIcon(icon.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT));
            jLabel1.setIcon(icon);
            //mostrando informacion "" dicom
            String[] parte = obj.RutaFull.split("\\.");
            String Rutatxt = parte[0];
            Rutatxt += ".txt";
            //System.out.println("" + Rutatxt);

            File txt = new File(Rutatxt);
            BufferedReader br = new BufferedReader(new FileReader(txt));

            String line;
            String[] lines;
            String[] lines2 = new String[4];
            int i = 0;
            while ((line = br.readLine()) != null) {
                lines = line.split(":");
                lines2[i] = lines[1];
                //System.out.println("" + line);
                i++;
            }
            lblPaciente.setText("Paciente: ");
            lblEdad.setText("Edad: ");
            lblDoctor.setText("Doctor: ");
            lblLugar.setText("Lugar: ");

            lblPaciente.setText(lblPaciente.getText() + lines2[0]);
            lblEdad.setText(lblEdad.getText() + lines2[1]);
            lblDoctor.setText(lblDoctor.getText() + lines2[2]);
            lblLugar.setText(lblLugar.getText() + lines2[3]);

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    private void save() {
        try {

            String formato = "png";
            File saveFile = new File("NewImagen." + formato);
            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(saveFile);
            int rFormato = chooser.showSaveDialog(this);
            if (rFormato == JFileChooser.APPROVE_OPTION) {
                saveFile = chooser.getSelectedFile();
                ImageIO.write(obj.getBi(), formato, saveFile);
                //Se guardó exitosamente
            }
        } catch (Exception e) {
        }
    }
}
