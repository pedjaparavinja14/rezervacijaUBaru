/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import domain.RaspolozivostStola;
import domain.RejonStola;
import domain.Sto;
import domain.VrstaStola;
import javax.swing.JOptionPane;
import logic.Controller;

/**
 *
 * @author Djapac
 */
public class FrmIzmeniSto extends javax.swing.JFrame {
    
    Sto sto;

    /**
     * Creates new form IzmeniSto
     */
    public FrmIzmeniSto(Sto sto) {
        initComponents();
        this.sto = sto;
        setTitle("Izmeni sto");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        popuniVrstu();
        popuniRaspolozivost();
        popuniRejone();
        popuniPolja(sto);
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
        jLabel2 = new javax.swing.JLabel();
        txtBrojStola = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtKapacitetStola = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbVrstaStola = new javax.swing.JComboBox<>();
        btnIzadji = new javax.swing.JButton();
        btnIzmeniSto = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbRejonStola = new javax.swing.JComboBox<>();
        cbRaspolozivostStola = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Raspoloživost stola: ");

        jLabel2.setText("Broj stola: ");

        jLabel3.setText("Kapacitet stola: ");

        jLabel4.setText("Vrsta stola");

        cbVrstaStola.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnIzadji.setText("Izađi");
        btnIzadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzadjiActionPerformed(evt);
            }
        });

        btnIzmeniSto.setText("Izmeni sto");
        btnIzmeniSto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniStoActionPerformed(evt);
            }
        });

        jLabel5.setText("Rejon stola:");

        cbRejonStola.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbRaspolozivostStola.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addComponent(txtKapacitetStola, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbVrstaStola, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbRejonStola, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBrojStola, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(cbRaspolozivostStola, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addComponent(btnIzmeniSto, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnIzadji, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cbRaspolozivostStola))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBrojStola, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKapacitetStola, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbVrstaStola, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRejonStola, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIzadji, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIzmeniSto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzadjiActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnIzadjiActionPerformed

    private void btnIzmeniStoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniStoActionPerformed
        // TODO add your handling code here:
       
        
        String brojStola = txtBrojStola.getText().trim();
        String kapacitetStola = txtKapacitetStola.getText().trim();
        VrstaStola vrstaStola = (VrstaStola) cbVrstaStola.getSelectedItem();
        RaspolozivostStola raspoloziv = (RaspolozivostStola) cbRaspolozivostStola.getSelectedItem();
        RejonStola rejon = (RejonStola) cbRejonStola.getSelectedItem();
        
        if(validacijaStola(raspoloziv, brojStola, kapacitetStola, vrstaStola, rejon)){
            
            try {
                int kapacitet = Integer.parseInt(kapacitetStola);
                int brojSt = Integer.parseInt(brojStola);
                
                Sto izmenjen = new Sto(brojSt, vrstaStola, kapacitet, rejon, raspoloziv);
                izmenjen.setRbStola(sto.getRbStola());
                
                Controller.getInstance().updateTable(izmenjen);
                
                JOptionPane.showMessageDialog(this, "Sistem je izmenio sto!", "Izmena podataka stola", JOptionPane.INFORMATION_MESSAGE);
                
                FrmPretragaStola pretraga = new FrmPretragaStola();
                pretraga.setVisible(true);
                dispose();
                
                
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti sto!", "Greška", JOptionPane.ERROR_MESSAGE);

            }
            
            
            
            
        }else{
            JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti sto!", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIzmeniStoActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzadji;
    private javax.swing.JButton btnIzmeniSto;
    private javax.swing.JComboBox<Object> cbRaspolozivostStola;
    private javax.swing.JComboBox<Object> cbRejonStola;
    private javax.swing.JComboBox<Object> cbVrstaStola;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtBrojStola;
    private javax.swing.JTextField txtKapacitetStola;
    // End of variables declaration//GEN-END:variables

    private void popuniVrstu() {
        
        cbVrstaStola.removeAllItems();
        
        for(VrstaStola vs : VrstaStola.values()){
            cbVrstaStola.addItem(vs);
            
        }
        cbVrstaStola.setSelectedIndex(-1);
    }

    private void popuniPolja(Sto sto) {
        
        txtBrojStola.setText(sto.getBrojStola() + "");
        txtKapacitetStola.setText(sto.getKapacitetStola() + "");
        cbVrstaStola.setSelectedItem(sto.getVrstaStola());
        cbRaspolozivostStola.setSelectedItem(sto.getRaspolozivost());
        cbRejonStola.setSelectedItem(sto.getRejon());
        
        
    }

    private boolean validacijaStola(RaspolozivostStola raspoloziv, String brojStola, String kapacitetStola, VrstaStola vrstaStola, RejonStola rejon) {
        boolean uspesno = true;
        
        
        if(brojStola.isEmpty()){
            JOptionPane.showMessageDialog(this, "Popunite broj stola!");
            uspesno = false;
        }
        if(kapacitetStola.isEmpty()){
            JOptionPane.showMessageDialog(this, "Popunite kapacitet stola!");
            uspesno = false;
        }
        if(vrstaStola == null){
            JOptionPane.showMessageDialog(this, "Popunite vrstu stola!");
            uspesno = false;
        }
        if(!brojStola.matches("\\d+")){
            JOptionPane.showMessageDialog(this, "Broj stola ne sadrži samo cifre!");
            uspesno = false;
        }
        if(!kapacitetStola.matches("\\d+")){
            JOptionPane.showMessageDialog(this, "Kapacitet stola ne sadrži samo cifre!");
            uspesno = false;
        }
        
        int kapacitet = Integer.parseInt(kapacitetStola);
        
        if(vrstaStola == vrstaStola.STANDARDNI){
            if(kapacitet > 4){
                JOptionPane.showMessageDialog(this, "Kapacitet za obican sto je prevelik!");
                uspesno = false;
            }
        }
        
        if(vrstaStola == vrstaStola.SANK){
            if(kapacitet > 10){
                JOptionPane.showMessageDialog(this, "Kapacitet za sank je prevelik!");
                uspesno = false;
            }
        }
        if(vrstaStola == vrstaStola.VISOKOSEDENJE){
            if(kapacitet > 6){
                JOptionPane.showMessageDialog(this, "Kapacitet za visoko sedenje je prevelik!");
                uspesno = false;
            }
        }
        if(vrstaStola == vrstaStola.SEPARE){
            if(kapacitet > 8){
                JOptionPane.showMessageDialog(this, "Kapacitet za separe je prevelik!");
                uspesno = false;
            }
        }
       
         
    
        return uspesno;
    }

    private void popuniRaspolozivost() {
        cbRaspolozivostStola.removeAllItems();
        
        for(RaspolozivostStola rs : RaspolozivostStola.values()){
            cbRaspolozivostStola.addItem(rs);
            
        }
        cbRaspolozivostStola.setSelectedIndex(-1);
    }

    private void popuniRejone() {
        cbRejonStola.removeAllItems();
        
        for(RejonStola rs : RejonStola.values()){
            cbRejonStola.addItem(rs);
            
        }
        cbRejonStola.setSelectedIndex(-1);
    }
    
}
