/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import domain.Korisnik;
import domain.Sto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import logic.Controller;
import model.ModelTabeleKorisnik;
import model.ModelTabeleStolovi;

/**
 *
 * @author Djapac
 */
public class FrmPretragaKorisnika extends javax.swing.JFrame {
    
   

    /**
     * Creates new form FrmPretragaKorisnika
     */
    public FrmPretragaKorisnika() {
        initComponents();
        setTitle("Pretraga korisnika");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        popuniTabelu();
    }
    
    public FrmPretragaKorisnika(FrmPrikazKorisnika frmPretraga){
        initComponents();
        setTitle("Pretraga korisnika");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        popuniTabelu();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKorisnici = new javax.swing.JTable();
        btnIzadji = new javax.swing.JButton();
        btnPretrazi = new javax.swing.JButton();
        btnPonisti = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Unesite ime korisnika: ");

        tblKorisnici.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblKorisnici);

        btnIzadji.setText("Izađi:");
        btnIzadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzadjiActionPerformed(evt);
            }
        });

        btnPretrazi.setText("Pretraži korisnike");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        btnPonisti.setText("Poništi pretragu");
        btnPonisti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonistiActionPerformed(evt);
            }
        });

        btnObrisi.setText("Izbriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIzadji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPretrazi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPonisti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnObrisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPretrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPonisti, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIzadji, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(21, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzadjiActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnIzadjiActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        // TODO add your handling code here:
        try {
            String naziv = txtIme.getText().trim();
            Korisnik korisnik = new Korisnik();
            
            if(naziv.isEmpty()){
                JOptionPane.showMessageDialog(this, "Unesite parametar za pretragu!");
                return;
            }
            btnPonisti.setEnabled(true);
            
            btnObrisi.setEnabled(true);
            korisnik.setIme(naziv);
            List <Korisnik> lista = Controller.getInstance().searchUsers(korisnik);

            popuniTabelu(lista);
            JOptionPane.showMessageDialog(this, "Sistem je našao korisnike prema zadatoj vrednosti!","Pretraga korisnika", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da nađe korisnike prema zadatoj vrednosti!","Pretraga korisnika", JOptionPane.INFORMATION_MESSAGE);
            podesiDugmice();
            ex.printStackTrace();
        }
        
        
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnPonistiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonistiActionPerformed
        // TODO add your handling code here:
     popuniTabelu();
    }//GEN-LAST:event_btnPonistiActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        // TODO add your handling code here:
        ModelTabeleKorisnik mtk = (ModelTabeleKorisnik) tblKorisnici.getModel();
        int red = tblKorisnici.getSelectedRow();
       
        if(red!=-1){
            try {
                Korisnik korisnik = mtk.getKorisnik(red);
                int odgovor = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da želite da obrišete korisnika?","Brisanje korisnika",JOptionPane.YES_NO_OPTION);
                if (odgovor == JOptionPane.YES_OPTION) {
                    Korisnik obrisan = Controller.getInstance().deleteUser(korisnik);
                    JOptionPane.showMessageDialog(this, "Sistem je izbrisao korisnika", "Brisanje korisnika", JOptionPane.INFORMATION_MESSAGE);
                    popuniTabelu();
                }
                else{
                   
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Sistem ne može da obriše korisnika.", "Greška", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }else{
           JOptionPane.showMessageDialog(this, "Morate izabrati korisnika", "Brisanje korisnika", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzadji;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPonisti;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKorisnici;
    private javax.swing.JTextField txtIme;
    // End of variables declaration//GEN-END:variables

    private void popuniTabelu() {
        btnPonisti.setEnabled(false);
        
        btnObrisi.setEnabled(false);
        txtIme.setText(" ");
        
        try {
            List<Korisnik> lista = Controller.getInstance().getAllUsers();   
            ModelTabeleKorisnik mtk = new ModelTabeleKorisnik(lista);
            tblKorisnici.setModel(mtk);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Niste popunili tabelu");
            ex.printStackTrace();
        }
        
    }
    
     private void popuniTabelu(List<Korisnik> lista) {
         try {
             ModelTabeleKorisnik mtk = new ModelTabeleKorisnik();
             mtk.refresh(lista);
            tblKorisnici.setModel(mtk);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Niste popunili tabelu");
            ex.printStackTrace();
        }
    }

    private void podesiDugmice() {
        btnPonisti.setEnabled(false);
       
        btnObrisi.setEnabled(false);
    }
}
