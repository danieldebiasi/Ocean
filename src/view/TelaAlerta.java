/*
 * Projeto Ocean - Previsao de Tempo e Mares
 * Engenharia de Software III
 * Faculdade de Tecnologia - UNICAMP
 */
package view;

import control.Controle;
import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Daniel
 */
public class TelaAlerta extends javax.swing.JDialog {

    private Point posicao;
    
    /**
     * Creates new form Alerta
     */
    public TelaAlerta(java.awt.Frame parent, boolean modal, String nivel, String dia, String cidade, String estado) {
        super(parent, modal);
        initComponents();
        
        Controle controle = new Controle();
        String codCidade = Integer.toString(controle.getCodCidade(estado, cidade));
        String[] dados = controle.obterAlerta(dia, codCidade);
        
        if(Integer.parseInt(nivel) > 1){
            jLabelNivel.setText("RUIM");
            jLabelNivel.setForeground(new Color(255, 0, 0));
        }else{
            jLabelNivel.setText("MODERADO");
            jLabelNivel.setForeground(Color.YELLOW);
        }
        
        jLabelCidade.setText(cidade);
        jLabelEstado.setText(estado);
        jLabelDia.setText(dia);
        jLabelClima.setText(dados[0]);
        jLabelAgitacao.setText(dados[1]);
        jLabelVento.setText(dados[2]);
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
        jPanel2 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelFechar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jLabelEstado = new javax.swing.JLabel();
        jLabelDia = new javax.swing.JLabel();
        jLabelClima = new javax.swing.JLabel();
        jLabelAgitacao = new javax.swing.JLabel();
        jLabelVento = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelNivel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 260));
        setMinimumSize(new java.awt.Dimension(400, 260));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(400, 260));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setMaximumSize(new java.awt.Dimension(400, 260));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 260));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 260));
        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        jPanel2.setMaximumSize(new java.awt.Dimension(400, 260));
        jPanel2.setMinimumSize(new java.awt.Dimension(400, 260));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 260));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Detalhes");
        jLabelTitulo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabelTituloMouseDragged(evt);
            }
        });
        jLabelTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelTituloMousePressed(evt);
            }
        });

        jLabelFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fecharCinza.png"))); // NOI18N
        jLabelFechar.setToolTipText("Fechar");
        jLabelFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelFecharMouseReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cidade:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Estado:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dia:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Clima:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Vento:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Agitação:");

        jLabelCidade.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelCidade.setForeground(new java.awt.Color(255, 255, 255));

        jLabelEstado.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelEstado.setForeground(new java.awt.Color(255, 255, 255));

        jLabelDia.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelDia.setForeground(new java.awt.Color(255, 255, 255));

        jLabelClima.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelClima.setForeground(new java.awt.Color(255, 255, 255));

        jLabelAgitacao.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAgitacao.setForeground(new java.awt.Color(255, 255, 255));

        jLabelVento.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelVento.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Condição de Navegação:");

        jLabelNivel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNivel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabelFechar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(jLabelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(jLabelDia, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addComponent(jLabelClima, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7)
                        .addGap(6, 6, 6)
                        .addComponent(jLabelAgitacao, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addComponent(jLabelVento, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jLabel2)
                            .addGap(6, 6, 6)
                            .addComponent(jLabelCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(94, 94, 94))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabelNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabelCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabelDia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabelClima, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabelAgitacao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabelVento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 260);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo-azul-degrade.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-10, -100, 420, 380);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelFecharMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelFecharMouseReleased
        this.dispose();
    }//GEN-LAST:event_jLabelFecharMouseReleased

    private void jLabelTituloMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTituloMouseDragged
        int thisX = this.getLocation().x;
        int thisY = this.getLocation().y;

        int xMoved = (thisX + evt.getX()) - (thisX + posicao.x);
        int yMoved = (thisY + evt.getY()) - (thisY + posicao.y);

        int X = thisX + xMoved;
        int Y = thisY + yMoved;
        this.setLocation(X, Y);
    }//GEN-LAST:event_jLabelTituloMouseDragged

    private void jLabelTituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTituloMousePressed
        posicao = evt.getPoint();
        getComponentAt(posicao);
    }//GEN-LAST:event_jLabelTituloMousePressed

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
            java.util.logging.Logger.getLogger(TelaAlerta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAlerta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAlerta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAlerta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaAlerta dialog = new TelaAlerta(new javax.swing.JFrame(), true, null, null, null, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAgitacao;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelClima;
    private javax.swing.JLabel jLabelDia;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelFechar;
    private javax.swing.JLabel jLabelNivel;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelVento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
