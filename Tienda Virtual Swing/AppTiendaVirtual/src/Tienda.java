
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author jozem
 */
public class Tienda extends javax.swing.JFrame {
    // Variables muy importantes para el funcionamiento del programa
    DefaultListModel modelo = new DefaultListModel();
    ImageIcon warning=new ImageIcon(getClass().getResource("/iconos/advertencia.png"));
    ImageIcon happy=new ImageIcon(getClass().getResource("/iconos/cara-de-guino.png"));
    ImageIcon sad=new ImageIcon(getClass().getResource("/iconos/enfadado.png"));

    /**
     * Creates new form Tienda
     */
    public Tienda() {
        initComponents();
        // Establecimiento del inventario al momento de generar la Tienda
        inventario();
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
        jVentanaProductos = new javax.swing.JTabbedPane();
        jProductos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jInventario = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListaSeleccionados = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jAnadirProducto = new javax.swing.JButton();
        jEliminarProductoSeleccionado = new javax.swing.JButton();
        jComprarProductos = new javax.swing.JButton();
        jCarrito = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListaComprar = new javax.swing.JList<>();
        jFinalizarCompra = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLimpiarCesta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TIENDA");
        setBackground(new java.awt.Color(0, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(0, 224, 161));

        jVentanaProductos.setBackground(new java.awt.Color(51, 255, 51));
        jVentanaProductos.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N

        jProductos.setBackground(new java.awt.Color(142, 255, 156));

        jScrollPane1.setViewportView(jInventario);

        jScrollPane2.setViewportView(jListaSeleccionados);

        jLabel1.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        jLabel1.setText("PRODUCTOS");

        jLabel2.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        jLabel2.setText("CARRITO");

        jAnadirProducto.setBackground(new java.awt.Color(142, 255, 156));
        jAnadirProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/anadir.png"))); // NOI18N
        jAnadirProducto.setText("AÑADIR");
        jAnadirProducto.setBorder(null);
        jAnadirProducto.setBorderPainted(false);
        jAnadirProducto.setContentAreaFilled(false);
        jAnadirProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jAnadirProducto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jAnadirProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAnadirProductoActionPerformed(evt);
            }
        });

        jEliminarProductoSeleccionado.setBackground(new java.awt.Color(142, 255, 156));
        jEliminarProductoSeleccionado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar (1).png"))); // NOI18N
        jEliminarProductoSeleccionado.setText("QUITAR");
        jEliminarProductoSeleccionado.setBorder(null);
        jEliminarProductoSeleccionado.setBorderPainted(false);
        jEliminarProductoSeleccionado.setContentAreaFilled(false);
        jEliminarProductoSeleccionado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jEliminarProductoSeleccionado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jEliminarProductoSeleccionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEliminarProductoSeleccionadoActionPerformed(evt);
            }
        });

        jComprarProductos.setBackground(new java.awt.Color(142, 255, 156));
        jComprarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/carrito-de-compras.png"))); // NOI18N
        jComprarProductos.setText("COMPRAR");
        jComprarProductos.setBorder(null);
        jComprarProductos.setBorderPainted(false);
        jComprarProductos.setContentAreaFilled(false);
        jComprarProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jComprarProductos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jComprarProductos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jComprarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComprarProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jProductosLayout = new javax.swing.GroupLayout(jProductos);
        jProductos.setLayout(jProductosLayout);
        jProductosLayout.setHorizontalGroup(
            jProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jProductosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jAnadirProducto)
                    .addComponent(jEliminarProductoSeleccionado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jProductosLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComprarProductos))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jProductosLayout.setVerticalGroup(
            jProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jProductosLayout.createSequentialGroup()
                .addGroup(jProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jProductosLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jProductosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGroup(jProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jProductosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComprarProductos)
                        .addGap(61, 61, 61))
                    .addGroup(jProductosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jProductosLayout.createSequentialGroup()
                                .addComponent(jAnadirProducto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jEliminarProductoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
                            .addGroup(jProductosLayout.createSequentialGroup()
                                .addGroup(jProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );

        jVentanaProductos.addTab("PRODUCTOS", jProductos);

        jCarrito.setBackground(new java.awt.Color(142, 255, 156));

        jListaComprar.setBorder(null);
        jListaComprar.setMinimumSize(new java.awt.Dimension(0, 1));
        jScrollPane3.setViewportView(jListaComprar);

        jFinalizarCompra.setBackground(new java.awt.Color(142, 255, 156));
        jFinalizarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/carrito-de-compras (1).png"))); // NOI18N
        jFinalizarCompra.setBorder(null);
        jFinalizarCompra.setBorderPainted(false);
        jFinalizarCompra.setContentAreaFilled(false);
        jFinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFinalizarCompraActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        jLabel3.setText("RESUMEN DEL PEDIDO");

        jLimpiarCesta.setBackground(new java.awt.Color(153, 255, 153));
        jLimpiarCesta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar.png"))); // NOI18N
        jLimpiarCesta.setBorder(null);
        jLimpiarCesta.setBorderPainted(false);
        jLimpiarCesta.setContentAreaFilled(false);
        jLimpiarCesta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLimpiarCesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLimpiarCestaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jCarritoLayout = new javax.swing.GroupLayout(jCarrito);
        jCarrito.setLayout(jCarritoLayout);
        jCarritoLayout.setHorizontalGroup(
            jCarritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jCarritoLayout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(jCarritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jCarritoLayout.createSequentialGroup()
                        .addComponent(jLimpiarCesta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jFinalizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jCarritoLayout.createSequentialGroup()
                        .addGroup(jCarritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74))))
        );
        jCarritoLayout.setVerticalGroup(
            jCarritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCarritoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jCarritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLimpiarCesta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFinalizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jVentanaProductos.addTab("PEDIDO", jCarrito);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jVentanaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jVentanaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFinalizarCompraActionPerformed
        /* Para la creacion de opciones en un JOptionPane le he asignado una variable int ya que las opciones 
        yes,no y closed tienen un valor, asi que, igualándolos puedo establecer una condicion*/
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de finalizar compra?", "Confirmar",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,warning);
        if (respuesta == JOptionPane.NO_OPTION) { 
            // Te cancela, impia todo y vuelve al principio PRODUCTOS
            limpiarListaSeleccionados();
            limpiarLista();
            jVentanaProductos.setSelectedComponent(jProductos);
        } else if (respuesta == JOptionPane.YES_OPTION) {
            // Te felicita, limpia todo y vuelve al principio PRODUCTOS
            JOptionPane.showMessageDialog(null, "FELICIDADES", "COMPRA EXITOSA",1, happy);
            limpiarListaSeleccionados();
            limpiarLista();
            jVentanaProductos.setSelectedComponent(jProductos);
        } else if (respuesta == JOptionPane.CLOSED_OPTION) {
            // Cierra, y te devuelve a pedido con la lista de carrito que tenías.
            System.out.println("JOptionPane closed");
        }
    }//GEN-LAST:event_jFinalizarCompraActionPerformed

    private void jAnadirProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAnadirProductoActionPerformed
        /* El valor/producto seleccionado lo almacena en forma de String para
        después agregarlo a la lista de productos agregados en Productos*/ 
        String productoSeleccionado = jInventario.getSelectedValue();
        jListaSeleccionados.setModel(modelo);
        if (productoSeleccionado != null) {
            modelo.addElement(productoSeleccionado);
        }
    }//GEN-LAST:event_jAnadirProductoActionPerformed

    private void jComprarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComprarProductosActionPerformed
        // Hasta que no agregas algo a la lista de la compra, no puedes comprar/carrito 
        if(modelo.isEmpty()){
            JOptionPane.showMessageDialog(null, "NO hay productos en el CARRITO.", "CARRITO VACÍO", JOptionPane.WARNING_MESSAGE,sad);
            return;
        }
        jVentanaProductos.setSelectedComponent(jCarrito);
        carritoProductos();
    }//GEN-LAST:event_jComprarProductosActionPerformed

    private void jLimpiarCestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLimpiarCestaActionPerformed
        limpiarLista();
        limpiarListaSeleccionados();
        jVentanaProductos.setSelectedComponent(jProductos);
    }//GEN-LAST:event_jLimpiarCestaActionPerformed

    private void jEliminarProductoSeleccionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEliminarProductoSeleccionadoActionPerformed
        // El valor de un producto es pasa a un String y si valor no es null lo retira/elimina
        String productoEliminar = jListaSeleccionados.getSelectedValue();
        if (productoEliminar != null) {
            modelo.removeElement(productoEliminar);
        }
    }//GEN-LAST:event_jEliminarProductoSeleccionadoActionPerformed
    public JList inventario() {
        // Creo una lista que tendrá un modelo al cual le voy agregando elementos al inventario y hago me lo devuelva
        DefaultListModel modelo = new DefaultListModel();
        modelo.addElement("USB");
        modelo.addElement("Teclado");
        modelo.addElement("Monitor");
        modelo.addElement("Portatil");
        modelo.addElement("Mouse");
        jInventario.setModel(modelo);
        jInventario.getModel();
        return jInventario;
    }

    public JList carritoProductos() {
        // El carrito obtendrá la lista de los productos seleccionados en Productos
        jListaComprar.setModel(jListaSeleccionados.getModel());
        return jListaComprar;
    }

    public DefaultListModel limpiarLista() {
        // Se utiliza un nuevo modelo de lista vacio que se establecerá el la lista de CARRITO
        DefaultListModel modelo = new DefaultListModel();
        jListaComprar.setModel(modelo);
        return modelo;
    }

    public DefaultListModel limpiarListaSeleccionados() {
        // Se utiliza un nuevo modelo de lista vacio que se establecerá el la lista de PRODUCTOS
        DefaultListModel modelo = new DefaultListModel();
        jListaSeleccionados.setModel(modelo);
        return modelo;
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
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tienda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAnadirProducto;
    private javax.swing.JPanel jCarrito;
    private javax.swing.JButton jComprarProductos;
    private javax.swing.JButton jEliminarProductoSeleccionado;
    private javax.swing.JButton jFinalizarCompra;
    private javax.swing.JList<String> jInventario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jLimpiarCesta;
    private javax.swing.JList<String> jListaComprar;
    private javax.swing.JList<String> jListaSeleccionados;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jProductos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jVentanaProductos;
    // End of variables declaration//GEN-END:variables
}