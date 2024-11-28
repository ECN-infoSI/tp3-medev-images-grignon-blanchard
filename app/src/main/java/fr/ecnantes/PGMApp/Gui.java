package fr.ecnantes.PGMApp;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Cette classe a pour objectif de visualiser les fonctionnalités d'affichage, lecture histogramme ...
 * @author kaoutar
 */
public class Gui extends javax.swing.JFrame {
    // Attributs
    /**
     * image: l'image PGM
     */
    PGMImage image;

    // Constructeurs
    public Gui(PGMImage image) {
        this.image = image;
        initComponents();
    }

    public Gui() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Composants
        jPanel1 = new javax.swing.JPanel();
        lire = new javax.swing.JButton();
        ecrire = new javax.swing.JButton();
        hist = new javax.swing.JButton();
        afficher = new javax.swing.JButton();
        seuil = new javax.swing.JButton();
        agrandir = new javax.swing.JButton();  // Bouton Agrandir
        reduire = new javax.swing.JButton();  // Bouton Réduire
        jFileChooser1 = new javax.swing.JFileChooser();
        imageLabel = new javax.swing.JLabel();

        // Configuration de la fenêtre
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PGM Image Viewer");

        // Panel principal
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        // Bouton Lire image
        lire.setText("Lire image");
        lire.addActionListener(evt -> lireImage(evt));

        // Bouton Ecrire image
        ecrire.setText("Ecrire image");
        ecrire.addActionListener(evt -> ecrireImage(evt));

        // Bouton Histogramme
        hist.setText("Histogramme");
        hist.addActionListener(evt -> afficherHistogramme(evt));

        // Bouton Afficher Image
        afficher.setText("Afficher Image");
        afficher.addActionListener(evt -> afficherImage(evt));

        // Bouton Seuillage
        seuil.setText("Seuillage");
        seuil.addActionListener(evt -> appliquerSeuillage(evt));

        // Bouton Agrandir
        agrandir.setText("Agrandir");
        agrandir.addActionListener(evt -> agrandirImage(evt));

        // Bouton Réduire
        reduire.setText("Réduire");
        reduire.addActionListener(evt -> reduireImage(evt));

        // Layout des composants
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ecrire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(afficher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(seuil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(agrandir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reduire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lire)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ecrire)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(hist)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(afficher)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(seuil)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(agrandir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(reduire))
                        .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(20, Short.MAX_VALUE))
        );

        // Layout de la fenêtre
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addContainerGap())
        );

        pack();
    }

    /**
     * Lecture d'une image
     * @param evt 
     */
    private void lireImage(java.awt.event.ActionEvent evt) {
        File fichier = jFileChooser1.getSelectedFile();
        try {
            String dir = fichier.getAbsolutePath();
            this.image = PGMFileIO.read(dir); // Assurez-vous que cette classe existe.
            JOptionPane.showMessageDialog(this, "Image chargée avec succès !");
        } catch (IOException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Ecriture d'une image
     * @param evt 
     */
    private void ecrireImage(java.awt.event.ActionEvent evt) {
        if (this.image != null) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Enregistrer l'image");
            fileChooser.setSelectedFile(new File("image.pgm"));

            int userSelection = fileChooser.showSaveDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                
                try {
                    PGMFileIO.write(fileToSave.getAbsolutePath(), this.image); // Assurez-vous que cette classe existe.
                    JOptionPane.showMessageDialog(this, "Image écrite avec succès !");
                } catch (IOException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement de l'image !");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Aucun fichier sélectionné pour enregistrer.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Aucune image à sauvegarder !");
        }
    }
    /**
     * affichage de l'histogramme de l'image
     * @param evt 
     */
    private void afficherHistogramme(java.awt.event.ActionEvent evt) {
        if (this.image != null) {
            PGMImage histImage = this.image.histogram();
            afficherImage(histImage);
        } else {
            JOptionPane.showMessageDialog(this, "Aucune image chargée !");
        }
    }
    /**
     * Application du seuillage 
     * @param evt 
     */
    private void appliquerSeuillage(java.awt.event.ActionEvent evt) {
        if (this.image != null) {
            String seuilStr = JOptionPane.showInputDialog(this, "Entrez le seuil (0-255):");
            int seuil = Integer.parseInt(seuilStr);
            PGMImage thresImage = this.image.thresholding(seuil);
            afficherImage(thresImage);
        } else {
            JOptionPane.showMessageDialog(this, "Aucune image chargée !");
        }
    }
    /**
     * Affichage de l'image
     * @param evt 
     */
    private void afficherImage(java.awt.event.ActionEvent evt) {
        if (this.image != null) {
            afficherImage(this.image);
        } else {
            JOptionPane.showMessageDialog(this, "Aucune image chargée !");
        }
    }
    
    private void afficherImage(PGMImage img) {
        Integer[][] content = img.getContent();
        int height = img.getHeight();
        int width = img.getWidth();

        BufferedImage buffer = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int gray = content[i][j];
                int rgb = (gray << 16) | (gray << 8) | gray;
                buffer.setRGB(j, i, rgb);
            }
        }
        ImageIcon icon = new ImageIcon(buffer.getScaledInstance(400, 400, Image.SCALE_SMOOTH));
        imageLabel.setIcon(icon);
    }

    /**
     * Méthode pour agrandir l'image
     * @param evt
     */
    private void agrandirImage(java.awt.event.ActionEvent evt) {
        if (this.image != null) {
            
            String ratioStr = JOptionPane.showInputDialog(this, "Entrez le ratio d'agrandissement:");

            try {
                int ratio = Integer.parseInt(ratioStr);
                if (ratio > 0) {
                    
                    PGMImage enlargedImage = this.image.enlargement(ratio);
                    afficherImage(enlargedImage); 
                } else {
                    JOptionPane.showMessageDialog(this, "Le ratio doit être supérieur à zéro.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Entrée invalide pour le ratio.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Aucune image chargée !");
        }
    }
    /**
    * Méthode pour réduire l'image
    * @param evt
    */
    private void reduireImage(java.awt.event.ActionEvent evt) {
       if (this.image != null) {
           
           String ratioStr = JOptionPane.showInputDialog(this, "Entrez le ratio de réduction:");

           try {
               int ratio = Integer.parseInt(ratioStr);
               if (ratio > 0) {
                   
                   PGMImage reducedImage = this.image.reduction(ratio);
                   afficherImage(reducedImage); 
               } else {
                   JOptionPane.showMessageDialog(this, "Le ratio doit être supérieur à zéro.");
               }
           } catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(this, "Entrée invalide pour le ratio.");
           }
       } else {
           JOptionPane.showMessageDialog(this, "Aucune image chargée !");
       }
    }


    // Variables de classe
    private javax.swing.JButton afficher;
    private javax.swing.JButton ecrire;
    private javax.swing.JButton hist;
    private javax.swing.JButton lire;
    private javax.swing.JButton seuil;
    private javax.swing.JButton agrandir;
    private javax.swing.JButton reduire;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JPanel jPanel1;
}
