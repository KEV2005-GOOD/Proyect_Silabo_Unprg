package GUI;

import GUI.modelos.HabilidadTableModel;
import GUI.modelos.HabilidadesComboModel;
import GUI.modelos.UnidadComboModel;
import entidades.HabilidadRequerida;
import entidades.Semana;
import entidades.Unidad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

public class JFUnidades extends javax.swing.JFrame {

    private static JFUnidades fmr;
    private static List<Unidad> unidades;
    private static int cantidadSemanas;
    private Unidad unidadSeleccionada;
    private int filaSeleccionada = -1;

    private List<HabilidadRequerida> habilidadRequerida = new ArrayList<>();
    private Map<Unidad, List<HabilidadRequerida>> habilidadesPorUnidad = new HashMap<>();

    private UnidadComboModel modeloComboUnidad = new UnidadComboModel();
    private HabilidadTableModel listadoHabilidadesRequeridas = new HabilidadTableModel();
    private HabilidadesComboModel modeloComboHabilidad = new HabilidadesComboModel();

    private JFUnidades() {
        initComponents();
        cmbUnidad.addActionListener(e -> {
            guardarHabilidadesPrevias();
            mostrarDatosDeUnidadSeleccionada();
            cargarHabilidadesDeUnidad();
        });
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                fmr = null;
            }
        });
    }

    public static JFUnidades mostrar(List<Unidad> unidades, int cantidadSemanas) {
        if (fmr == null) {
            fmr = new JFUnidades();
            fmr.actualizarUnidades(unidades, cantidadSemanas);
        } else {
            fmr.actualizarUnidades(unidades, cantidadSemanas);
            fmr.toFront();
        }
        fmr.setVisible(true);

        return fmr;

    }

    public void actualizarUnidades(List<Unidad> unidad, int cantidadSemanas) {
        this.unidades = unidad;
        this.cantidadSemanas = cantidadSemanas;
        cargarDatosUnidades();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bntCancelar = new javax.swing.JButton();
        btnAcepetarEditar = new javax.swing.JButton();
        panConfiguracionHabilidades = new javax.swing.JPanel();
        lblNombreHabilidad = new javax.swing.JLabel();
        cmbHabilidadesConfig = new javax.swing.JComboBox<>();
        lblUnidadConfig = new javax.swing.JLabel();
        cmbUnidadConfig = new javax.swing.JComboBox<>();
        lblSemanasConfig = new javax.swing.JLabel();
        panSemana = new javax.swing.JPanel();
        lblConocimiento = new javax.swing.JLabel();
        scpConocimiento = new javax.swing.JScrollPane();
        txaConocimiento = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        scpActividadesAprendizaje = new javax.swing.JScrollPane();
        txaActividadesDeAprendizaje = new javax.swing.JTextArea();
        lblActividadAprendizaje = new javax.swing.JLabel();
        lblTipoEvidencia = new javax.swing.JLabel();
        cmbTipoEvidencia = new javax.swing.JComboBox<>();
        lblEvidencia = new javax.swing.JLabel();
        scpEvidencia = new javax.swing.JScrollPane();
        txaEvidencia = new javax.swing.JTextArea();
        lblInstrumentoEvaluación = new javax.swing.JLabel();
        scpInstrumentoEvaluación = new javax.swing.JScrollPane();
        txaInstrumentoEvaluación = new javax.swing.JTextArea();
        btnGuardarSemana = new javax.swing.JButton();
        btnConfigurarSemana = new javax.swing.JButton();
        btnModificarLasHabilidades = new javax.swing.JButton();
        cmbSemana = new javax.swing.JComboBox<>();
        panRegistroDeHabilidades = new javax.swing.JPanel();
        cmbUnidad = new javax.swing.JComboBox<>();
        lblUnidad = new javax.swing.JLabel();
        lblDesempeñoEsperado = new javax.swing.JLabel();
        scpDesempeñoEsperado = new javax.swing.JScrollPane();
        txaDesempeñoEsperado = new javax.swing.JTextArea();
        panAgregarHabilidad = new javax.swing.JPanel();
        panListadoHabilidades = new javax.swing.JPanel();
        scpTablaListado = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        btnNuevaHabilidad = new javax.swing.JButton();
        btnModificarHabilidad = new javax.swing.JButton();
        btnEliminarHabilidad = new javax.swing.JButton();
        panHabilidad = new javax.swing.JPanel();
        lblHabilidad = new javax.swing.JLabel();
        scpHabilidad = new javax.swing.JScrollPane();
        txaHabilidad = new javax.swing.JTextArea();
        btnAceptarHabilidadNueva = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblSemanas = new javax.swing.JLabel();
        spCantidadSemanas = new javax.swing.JSpinner();
        btnGuardarHabilidades = new javax.swing.JButton();
        btnConfigurarHabilidades = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bntCancelar.setText("Cancelar");

        btnAcepetarEditar.setText("Aceptar");

        panConfiguracionHabilidades.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Configurar Habilidades"));
        panConfiguracionHabilidades.setEnabled(false);

        lblNombreHabilidad.setText("Habilidad: ");
        lblNombreHabilidad.setEnabled(false);

        cmbHabilidadesConfig.setModel(this.modeloComboHabilidad);
        cmbHabilidadesConfig.setEnabled(false);
        cmbHabilidadesConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHabilidadesConfigActionPerformed(evt);
            }
        });

        lblUnidadConfig.setText("Unidad: ");
        lblUnidadConfig.setEnabled(false);

        cmbUnidadConfig.setModel(this.modeloComboUnidad);
        cmbUnidadConfig.setEnabled(false);

        lblSemanasConfig.setText("Semana: ");
        lblSemanasConfig.setEnabled(false);

        panSemana.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Semana"));
        panSemana.setEnabled(false);

        lblConocimiento.setText("Conocimiento: ");
        lblConocimiento.setEnabled(false);

        txaConocimiento.setColumns(20);
        txaConocimiento.setRows(5);
        txaConocimiento.setEnabled(false);
        scpConocimiento.setViewportView(txaConocimiento);

        jLabel3.setText("Actividad de aprendizaje: ");
        jLabel3.setEnabled(false);

        txaActividadesDeAprendizaje.setColumns(20);
        txaActividadesDeAprendizaje.setRows(5);
        txaActividadesDeAprendizaje.setEnabled(false);
        scpActividadesAprendizaje.setViewportView(txaActividadesDeAprendizaje);

        lblActividadAprendizaje.setText("EVIDENCIA APRENDIZAJE: ");
        lblActividadAprendizaje.setEnabled(false);

        lblTipoEvidencia.setText("Tipo de Evidencia: ");
        lblTipoEvidencia.setEnabled(false);

        cmbTipoEvidencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Exámenes", "Trabajos Escritos", "Presentaciones Orales ", "Proyectos", "Portafolios", "Pruebas Prácticas", "Observaciones Conductuales", "Entrevistas de Competencias", "Autoevaluaciones y Diarios de Aprendizaje", "Informes de Progreso", "Comentarios y Retroalimentación", "Creaciones Artísticas", "Maquetas y Prototipos", "Videojuegos y Aplicaciones Digitales", "Cuadernos de Notas y Bitácoras" }));
        cmbTipoEvidencia.setSelectedIndex(-1);
        cmbTipoEvidencia.setEnabled(false);

        lblEvidencia.setText("Evidencia: ");
        lblEvidencia.setEnabled(false);

        txaEvidencia.setColumns(20);
        txaEvidencia.setRows(5);
        txaEvidencia.setEnabled(false);
        scpEvidencia.setViewportView(txaEvidencia);

        lblInstrumentoEvaluación.setText("Instrumento Evaluación:");
        lblInstrumentoEvaluación.setEnabled(false);

        txaInstrumentoEvaluación.setColumns(20);
        txaInstrumentoEvaluación.setRows(5);
        txaInstrumentoEvaluación.setEnabled(false);
        scpInstrumentoEvaluación.setViewportView(txaInstrumentoEvaluación);

        btnGuardarSemana.setText("Guardar");
        btnGuardarSemana.setEnabled(false);
        btnGuardarSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarSemanaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panSemanaLayout = new javax.swing.GroupLayout(panSemana);
        panSemana.setLayout(panSemanaLayout);
        panSemanaLayout.setHorizontalGroup(
            panSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSemanaLayout.createSequentialGroup()
                .addGroup(panSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panSemanaLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panSemanaLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scpActividadesAprendizaje))
                            .addGroup(panSemanaLayout.createSequentialGroup()
                                .addComponent(lblConocimiento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scpConocimiento))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panSemanaLayout.createSequentialGroup()
                                .addComponent(lblActividadAprendizaje)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panSemanaLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(panSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panSemanaLayout.createSequentialGroup()
                                .addComponent(lblInstrumentoEvaluación)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panSemanaLayout.createSequentialGroup()
                                .addGroup(panSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblEvidencia)
                                    .addComponent(lblTipoEvidencia))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(panSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panSemanaLayout.createSequentialGroup()
                                .addComponent(cmbTipoEvidencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(207, 207, 207))
                            .addComponent(scpEvidencia, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                            .addComponent(scpInstrumentoEvaluación, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panSemanaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardarSemana)))
                .addContainerGap())
        );
        panSemanaLayout.setVerticalGroup(
            panSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSemanaLayout.createSequentialGroup()
                .addGroup(panSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panSemanaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scpConocimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                    .addComponent(lblConocimiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(scpActividadesAprendizaje, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addComponent(lblActividadAprendizaje)
                .addGap(19, 19, 19)
                .addGroup(panSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoEvidencia)
                    .addComponent(cmbTipoEvidencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEvidencia)
                    .addComponent(scpEvidencia, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(panSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpInstrumentoEvaluación, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(lblInstrumentoEvaluación))
                .addGap(49, 49, 49)
                .addComponent(btnGuardarSemana)
                .addGap(20, 20, 20))
        );

        btnConfigurarSemana.setText("Configurar");
        btnConfigurarSemana.setEnabled(false);
        btnConfigurarSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigurarSemanaActionPerformed(evt);
            }
        });

        btnModificarLasHabilidades.setText("Modificar Habilidades");
        btnModificarLasHabilidades.setEnabled(false);
        btnModificarLasHabilidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarLasHabilidadesActionPerformed(evt);
            }
        });

        cmbSemana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSemana.setEnabled(false);

        javax.swing.GroupLayout panConfiguracionHabilidadesLayout = new javax.swing.GroupLayout(panConfiguracionHabilidades);
        panConfiguracionHabilidades.setLayout(panConfiguracionHabilidadesLayout);
        panConfiguracionHabilidadesLayout.setHorizontalGroup(
            panConfiguracionHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panConfiguracionHabilidadesLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panConfiguracionHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panConfiguracionHabilidadesLayout.createSequentialGroup()
                        .addComponent(lblUnidadConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbUnidadConfig, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panConfiguracionHabilidadesLayout.createSequentialGroup()
                        .addComponent(lblNombreHabilidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbHabilidadesConfig, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panConfiguracionHabilidadesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConfigurarSemana))
                    .addComponent(panSemana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panConfiguracionHabilidadesLayout.createSequentialGroup()
                        .addGroup(panConfiguracionHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificarLasHabilidades)
                            .addGroup(panConfiguracionHabilidadesLayout.createSequentialGroup()
                                .addComponent(lblSemanasConfig)
                                .addGap(18, 18, 18)
                                .addComponent(cmbSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panConfiguracionHabilidadesLayout.setVerticalGroup(
            panConfiguracionHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panConfiguracionHabilidadesLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panConfiguracionHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbUnidadConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnidadConfig))
                .addGap(18, 18, 18)
                .addGroup(panConfiguracionHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreHabilidad)
                    .addComponent(cmbHabilidadesConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(panConfiguracionHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSemanasConfig)
                    .addComponent(cmbSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(btnConfigurarSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panSemana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificarLasHabilidades)
                .addGap(7, 7, 7))
        );

        panRegistroDeHabilidades.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Registro Habilidades"));

        cmbUnidad.setModel(this.modeloComboUnidad);

        lblUnidad.setText("Unidad: ");

        lblDesempeñoEsperado.setText("Desempeño Esperado:");

        txaDesempeñoEsperado.setEditable(false);
        txaDesempeñoEsperado.setColumns(20);
        txaDesempeñoEsperado.setRows(5);
        scpDesempeñoEsperado.setViewportView(txaDesempeñoEsperado);

        panAgregarHabilidad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Agregamos habilidades"), "Agregamos la habilidad Requerida"));

        panListadoHabilidades.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Listado Habilidades"));

        tblListado.setModel(this.listadoHabilidadesRequeridas);
        scpTablaListado.setViewportView(tblListado);

        btnNuevaHabilidad.setText("Nuevo");
        btnNuevaHabilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaHabilidadActionPerformed(evt);
            }
        });

        btnModificarHabilidad.setText("Modificar");
        btnModificarHabilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarHabilidadActionPerformed(evt);
            }
        });

        btnEliminarHabilidad.setText("Eliminar");
        btnEliminarHabilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarHabilidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panListadoHabilidadesLayout = new javax.swing.GroupLayout(panListadoHabilidades);
        panListadoHabilidades.setLayout(panListadoHabilidadesLayout);
        panListadoHabilidadesLayout.setHorizontalGroup(
            panListadoHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panListadoHabilidadesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panListadoHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panListadoHabilidadesLayout.createSequentialGroup()
                        .addComponent(btnNuevaHabilidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificarHabilidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarHabilidad))
                    .addComponent(scpTablaListado, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );
        panListadoHabilidadesLayout.setVerticalGroup(
            panListadoHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panListadoHabilidadesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scpTablaListado, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panListadoHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarHabilidad)
                    .addComponent(btnNuevaHabilidad)
                    .addComponent(btnEliminarHabilidad))
                .addGap(44, 44, 44))
        );

        panHabilidad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Habilidad"));
        panHabilidad.setEnabled(false);

        lblHabilidad.setText("Habilidad: ");
        lblHabilidad.setEnabled(false);

        txaHabilidad.setColumns(20);
        txaHabilidad.setRows(5);
        txaHabilidad.setEnabled(false);
        scpHabilidad.setViewportView(txaHabilidad);

        btnAceptarHabilidadNueva.setText("Aceptar");
        btnAceptarHabilidadNueva.setEnabled(false);
        btnAceptarHabilidadNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarHabilidadNuevaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblSemanas.setText("Semanas: ");

        spCantidadSemanas.setModel(new javax.swing.SpinnerNumberModel(1, 1, 4, 1));
        spCantidadSemanas.setEnabled(false);

        javax.swing.GroupLayout panHabilidadLayout = new javax.swing.GroupLayout(panHabilidad);
        panHabilidad.setLayout(panHabilidadLayout);
        panHabilidadLayout.setHorizontalGroup(
            panHabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panHabilidadLayout.createSequentialGroup()
                .addGroup(panHabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpHabilidad, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                    .addGroup(panHabilidadLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblHabilidad)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panHabilidadLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptarHabilidadNueva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addGap(13, 13, 13))
            .addGroup(panHabilidadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSemanas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spCantidadSemanas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panHabilidadLayout.setVerticalGroup(
            panHabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panHabilidadLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblHabilidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scpHabilidad, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panHabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSemanas)
                    .addComponent(spCantidadSemanas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(panHabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptarHabilidadNueva))
                .addGap(40, 40, 40))
        );

        btnGuardarHabilidades.setText("Guardar");
        btnGuardarHabilidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarHabilidadesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panAgregarHabilidadLayout = new javax.swing.GroupLayout(panAgregarHabilidad);
        panAgregarHabilidad.setLayout(panAgregarHabilidadLayout);
        panAgregarHabilidadLayout.setHorizontalGroup(
            panAgregarHabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAgregarHabilidadLayout.createSequentialGroup()
                .addComponent(panHabilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panListadoHabilidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAgregarHabilidadLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGuardarHabilidades, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panAgregarHabilidadLayout.setVerticalGroup(
            panAgregarHabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAgregarHabilidadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panAgregarHabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panHabilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panListadoHabilidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(btnGuardarHabilidades)
                .addGap(39, 39, 39))
        );

        btnConfigurarHabilidades.setText("Configurar habilidades");
        btnConfigurarHabilidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigurarHabilidadesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panRegistroDeHabilidadesLayout = new javax.swing.GroupLayout(panRegistroDeHabilidades);
        panRegistroDeHabilidades.setLayout(panRegistroDeHabilidadesLayout);
        panRegistroDeHabilidadesLayout.setHorizontalGroup(
            panRegistroDeHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRegistroDeHabilidadesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panRegistroDeHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panRegistroDeHabilidadesLayout.createSequentialGroup()
                        .addComponent(lblDesempeñoEsperado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scpDesempeñoEsperado))
                    .addGroup(panRegistroDeHabilidadesLayout.createSequentialGroup()
                        .addComponent(lblUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbUnidad, 0, 652, Short.MAX_VALUE))
                    .addComponent(btnConfigurarHabilidades, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panAgregarHabilidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panRegistroDeHabilidadesLayout.setVerticalGroup(
            panRegistroDeHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRegistroDeHabilidadesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panRegistroDeHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnidad))
                .addGap(18, 18, 18)
                .addGroup(panRegistroDeHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDesempeñoEsperado)
                    .addComponent(scpDesempeñoEsperado, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panAgregarHabilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfigurarHabilidades)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAcepetarEditar)
                        .addGap(41, 41, 41)
                        .addComponent(bntCancelar)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panRegistroDeHabilidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panConfiguracionHabilidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(9, 9, 9))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panRegistroDeHabilidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panConfiguracionHabilidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntCancelar)
                    .addComponent(btnAcepetarEditar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaHabilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaHabilidadActionPerformed
        activarControles(true);
    }//GEN-LAST:event_btnNuevaHabilidadActionPerformed

    private void btnAceptarHabilidadNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarHabilidadNuevaActionPerformed
        if (!validarDatos() || unidadSeleccionada == null) {
            return;
        }
        String texto = txaHabilidad.getText().trim();
        int semanas = (int) spCantidadSemanas.getValue();
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre de la habilidad no puede estar vacío.", "Dato inválido", JOptionPane.WARNING_MESSAGE);
            txaHabilidad.requestFocus();
            return;
        }
        List<HabilidadRequerida> habilidadesUnidad = habilidadesPorUnidad.getOrDefault(unidadSeleccionada, new ArrayList<>());
        boolean duplicado = habilidadesUnidad.stream().anyMatch(h
                -> h.getHabilidad().equalsIgnoreCase(texto)
                && h.getCantidadSemanas() == semanas
                && habilidadesUnidad.indexOf(h) != filaSeleccionada
        );
        if (duplicado) {
            JOptionPane.showMessageDialog(this, "Ya existe una habilidad con ese nombre y número de semanas.", "Duplicado detectado", JOptionPane.WARNING_MESSAGE);
            txaHabilidad.requestFocus();
            return;
        }
        if (filaSeleccionada > -1) {
            HabilidadRequerida habilidad = habilidadesUnidad.get(filaSeleccionada);
            habilidad.setHabilidad(texto);
            habilidad.setCantidadSemanas(semanas);
            filaSeleccionada = -1;
            System.out.println("[EDITADO] " + texto + " - " + semanas);
        } else {
            HabilidadRequerida nueva = new HabilidadRequerida();
            nueva.setHabilidad(texto);
            nueva.setCantidadSemanas(semanas);
            habilidadesUnidad.add(nueva);
            habilidadesPorUnidad.put(unidadSeleccionada, habilidadesUnidad);
            System.out.println("[AGREGADO] " + texto + " - " + semanas);
        }
        habilidadRequerida = habilidadesUnidad;
        listadoHabilidadesRequeridas.setHabilidadesReque(habilidadRequerida);
        listadoHabilidadesRequeridas.fireTableDataChanged();
        txaHabilidad.setText("");
        spCantidadSemanas.setValue(((SpinnerNumberModel) spCantidadSemanas.getModel()).getMinimum());
        activarControles(false);

    }//GEN-LAST:event_btnAceptarHabilidadNuevaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.txaHabilidad.setText("");
        this.spCantidadSemanas.setValue(((SpinnerNumberModel) spCantidadSemanas.getModel()).getMinimum());
        this.activarControles(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarHabilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarHabilidadActionPerformed
        filaSeleccionada = tblListado.getSelectedRow();

        if (filaSeleccionada > -1) {
            HabilidadRequerida habilidad = habilidadRequerida.get(filaSeleccionada);
            txaHabilidad.setText(habilidad.getHabilidad());
            activarControles(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una habilidad para modificar");
        }

    }//GEN-LAST:event_btnModificarHabilidadActionPerformed

    private void btnGuardarHabilidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarHabilidadesActionPerformed
        if (unidadSeleccionada == null) {
            return;
        }

        int totalSemanasAsignadas = 0;
        for (Map.Entry<Unidad, List<HabilidadRequerida>> entry : habilidadesPorUnidad.entrySet()) {
            for (HabilidadRequerida h : entry.getValue()) {
                totalSemanasAsignadas += h.getCantidadSemanas();
            }
        }
        List<HabilidadRequerida> habilidadesActuales = listadoHabilidadesRequeridas.getHabilidadesReque();
        List<HabilidadRequerida> habilidadesGuardadas = habilidadesPorUnidad.getOrDefault(unidadSeleccionada, new ArrayList<>());

        int nuevasAgregadas = 0;
        int nuevasSemanas = 0;

        for (HabilidadRequerida nueva : habilidadesActuales) {
            boolean yaExiste = habilidadesGuardadas.stream().anyMatch(h
                    -> h.getHabilidad().equalsIgnoreCase(nueva.getHabilidad())
                    && h.getCantidadSemanas() == nueva.getCantidadSemanas()
            );
            if (!yaExiste) {
                nuevasSemanas += nueva.getCantidadSemanas();
            }
        }
        if (totalSemanasAsignadas + nuevasSemanas > cantidadSemanas) {
            JOptionPane.showMessageDialog(this,
                    "⛔ Usted se excedió en la cantidad de semanas.\n"
                    + "Solo se permiten " + cantidadSemanas + " semanas según anteriormente establecido.\n"
                    + "Distribuya mejor sus semanas antes de continuar.",
                    "Límite de semanas superado", JOptionPane.WARNING_MESSAGE);
            return;
        }
        for (HabilidadRequerida nueva : habilidadesActuales) {
            boolean yaExiste = habilidadesGuardadas.stream().anyMatch(h
                    -> h.getHabilidad().equalsIgnoreCase(nueva.getHabilidad())
                    && h.getCantidadSemanas() == nueva.getCantidadSemanas()
            );
            if (!yaExiste) {
                habilidadesGuardadas.add(nueva);
                nuevasAgregadas++;
                System.out.println("[GUARDADO] " + nueva.getHabilidad() + " - " + nueva.getCantidadSemanas());
            } else {
                System.out.println("[OMITIDO] Ya registrada: " + nueva.getHabilidad() + " - " + nueva.getCantidadSemanas());
            }
        }

        habilidadesPorUnidad.put(unidadSeleccionada, habilidadesGuardadas);
        int semanasUsadasFinal = totalSemanasAsignadas + nuevasSemanas;
        int libresFinal = cantidadSemanas - semanasUsadasFinal;
        if (nuevasAgregadas > 0) {
            JOptionPane.showMessageDialog(this,
                    "✅ Se actualizaron las habilidades para la unidad seleccionada.\n"
                    + "Nuevas habilidades guardadas: " + nuevasAgregadas + "\n"
                    + "Semanas disponibles restantes: " + libresFinal,
                    "Confirmación de guardado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Se actualizaron las habilidades de cada unidad\n" + "Semanas disponibles: " + libresFinal,
                    "Unidades Actualizadas", JOptionPane.INFORMATION_MESSAGE);
        }
        // ⬇️ Sincronizar el mapa con el atributo 'unidades' de la clase
        actualizarUnidadesConHabilidades();
        System.out.println("📦 Habilidades sincronizadas con las unidades activas.");
    }//GEN-LAST:event_btnGuardarHabilidadesActionPerformed

    private void btnConfigurarHabilidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigurarHabilidadesActionPerformed
        activarControlesPanel(true);
    }//GEN-LAST:event_btnConfigurarHabilidadesActionPerformed

    private void btnEliminarHabilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarHabilidadActionPerformed
        int fila = tblListado.getSelectedRow();
        if (fila == -1 || unidadSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una habilidad para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar esta habilidad?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            List<HabilidadRequerida> habilidadesUnidad = habilidadesPorUnidad.getOrDefault(unidadSeleccionada, new ArrayList<>());
            if (fila < habilidadesUnidad.size()) {
                habilidadesUnidad.remove(fila);
                habilidadesPorUnidad.put(unidadSeleccionada, habilidadesUnidad);
                habilidadRequerida = habilidadesUnidad;
                listadoHabilidadesRequeridas.setHabilidadesReque(habilidadRequerida);
                listadoHabilidadesRequeridas.fireTableDataChanged();
                filaSeleccionada = -1;
                JOptionPane.showMessageDialog(this, "Habilidad eliminada correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnEliminarHabilidadActionPerformed

    private void btnModificarLasHabilidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarLasHabilidadesActionPerformed
        activarControlesPanel(false);
    }//GEN-LAST:event_btnModificarLasHabilidadesActionPerformed

    private void cmbHabilidadesConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHabilidadesConfigActionPerformed
        this.cmbUnidadConfig.addActionListener(e -> {
            mostrarDatosDeHabilidadesSeleccionadaParaSemana();
        });
    }//GEN-LAST:event_cmbHabilidadesConfigActionPerformed

    private void btnConfigurarSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigurarSemanaActionPerformed
        ActivarControlesPanelSsemana(true);
    }//GEN-LAST:event_btnConfigurarSemanaActionPerformed

    private void btnGuardarSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarSemanaActionPerformed
        if (validarDatosSemanas() != false) {
            ActivarControlesPanelSsemana(false);
        }
    }//GEN-LAST:event_btnGuardarSemanaActionPerformed

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
            java.util.logging.Logger.getLogger(JFUnidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFUnidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFUnidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFUnidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFUnidades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCancelar;
    private javax.swing.JButton btnAcepetarEditar;
    private javax.swing.JButton btnAceptarHabilidadNueva;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfigurarHabilidades;
    private javax.swing.JButton btnConfigurarSemana;
    private javax.swing.JButton btnEliminarHabilidad;
    private javax.swing.JButton btnGuardarHabilidades;
    private javax.swing.JButton btnGuardarSemana;
    private javax.swing.JButton btnModificarHabilidad;
    private javax.swing.JButton btnModificarLasHabilidades;
    private javax.swing.JButton btnNuevaHabilidad;
    private javax.swing.JComboBox<String> cmbHabilidadesConfig;
    private javax.swing.JComboBox<String> cmbSemana;
    private javax.swing.JComboBox<String> cmbTipoEvidencia;
    private javax.swing.JComboBox<String> cmbUnidad;
    private javax.swing.JComboBox<String> cmbUnidadConfig;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblActividadAprendizaje;
    private javax.swing.JLabel lblConocimiento;
    private javax.swing.JLabel lblDesempeñoEsperado;
    private javax.swing.JLabel lblEvidencia;
    private javax.swing.JLabel lblHabilidad;
    private javax.swing.JLabel lblInstrumentoEvaluación;
    private javax.swing.JLabel lblNombreHabilidad;
    private javax.swing.JLabel lblSemanas;
    private javax.swing.JLabel lblSemanasConfig;
    private javax.swing.JLabel lblTipoEvidencia;
    private javax.swing.JLabel lblUnidad;
    private javax.swing.JLabel lblUnidadConfig;
    private javax.swing.JPanel panAgregarHabilidad;
    private javax.swing.JPanel panConfiguracionHabilidades;
    private javax.swing.JPanel panHabilidad;
    private javax.swing.JPanel panListadoHabilidades;
    private javax.swing.JPanel panRegistroDeHabilidades;
    private javax.swing.JPanel panSemana;
    private javax.swing.JScrollPane scpActividadesAprendizaje;
    private javax.swing.JScrollPane scpConocimiento;
    private javax.swing.JScrollPane scpDesempeñoEsperado;
    private javax.swing.JScrollPane scpEvidencia;
    private javax.swing.JScrollPane scpHabilidad;
    private javax.swing.JScrollPane scpInstrumentoEvaluación;
    private javax.swing.JScrollPane scpTablaListado;
    private javax.swing.JSpinner spCantidadSemanas;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextArea txaActividadesDeAprendizaje;
    private javax.swing.JTextArea txaConocimiento;
    private javax.swing.JTextArea txaDesempeñoEsperado;
    private javax.swing.JTextArea txaEvidencia;
    private javax.swing.JTextArea txaHabilidad;
    private javax.swing.JTextArea txaInstrumentoEvaluación;
    // End of variables declaration//GEN-END:variables

    public static List<Unidad> devolverDatos() {
        return unidades;
    }

    private void guardarHabilidadesPrevias() {
        if (unidadSeleccionada != null) {
            habilidadesPorUnidad.put(unidadSeleccionada, new ArrayList<>(habilidadRequerida));
        }
    }

    private void cargarHabilidadesDeUnidad() {
        habilidadRequerida = habilidadesPorUnidad.getOrDefault(unidadSeleccionada, new ArrayList<>());
        listadoHabilidadesRequeridas.setHabilidadesReque(habilidadRequerida);
        txaHabilidad.setText("");
        activarControles(false);
    }

    public void mostrarDatosDeUnidadSeleccionada() {
        int index = cmbUnidad.getSelectedIndex();
        List<Unidad> disponibles = modeloComboUnidad.getUnidad();
        if (index >= 0 && disponibles != null && index < disponibles.size()) {
            unidadSeleccionada = disponibles.get(index);
            txaDesempeñoEsperado.setText(unidadSeleccionada.getDesempeño());
        }
    }

    private void cargarDatosUnidades() {
        this.modeloComboUnidad.setUnidad(unidades);
        this.cmbUnidad.setModel(modeloComboUnidad);
        this.cmbUnidad.setSelectedIndex(-1);
    }

    private boolean validarDatos() {
        return true;
    }

    private void activarControles(boolean estado) {
        this.panHabilidad.setEnabled(estado);
        this.lblHabilidad.setEnabled(estado);
        this.txaHabilidad.setEnabled(estado);
        this.btnAceptarHabilidadNueva.setEnabled(estado);
        this.spCantidadSemanas.setEnabled(estado);
        this.btnCancelar.setEnabled(estado);
        this.panListadoHabilidades.setEnabled(!estado);
        this.tblListado.setEnabled(!estado);
        this.btnNuevaHabilidad.setEnabled(!estado);
        this.btnModificarHabilidad.setEnabled(!estado);
    }

    private void activarControlesPanel(boolean estado) {
        this.panConfiguracionHabilidades.setEnabled(estado);
        this.lblUnidadConfig.setEnabled(estado);
        this.cmbUnidadConfig.setEnabled(estado);
        this.lblNombreHabilidad.setEnabled(estado);
        this.cmbHabilidadesConfig.setEnabled(estado);
        this.lblSemanasConfig.setEnabled(estado);
        this.cmbSemana.setEnabled(estado);
        this.btnConfigurarSemana.setEnabled(estado);
        this.btnModificarLasHabilidades.setEnabled(estado);

        this.panRegistroDeHabilidades.setEnabled(!estado);
        this.lblUnidad.setEnabled(!estado);
        this.cmbUnidad.setEnabled(!estado);
        this.lblDesempeñoEsperado.setEnabled(!estado);
        this.txaDesempeñoEsperado.setEnabled(!estado);
        this.panAgregarHabilidad.setEnabled(!estado);
        this.panHabilidad.setEnabled(!estado);
        this.panListadoHabilidades.setEnabled(!estado);
        this.tblListado.setEnabled(!estado);
        this.btnNuevaHabilidad.setEnabled(!estado);
        this.btnModificarHabilidad.setEnabled(!estado);
        this.btnEliminarHabilidad.setEnabled(!estado);
        this.btnGuardarHabilidades.setEnabled(!estado);
        this.btnConfigurarHabilidades.setEnabled(!estado);
    }

    private void mostrarSemanasDeHabilidadSeleccionada() {
        String nombreHab = (String) cmbHabilidadesConfig.getSelectedItem();
        Unidad unidad = (Unidad) cmbUnidadConfig.getSelectedItem();
        if (unidad == null || nombreHab == null) {
            return;
        }

        List<HabilidadRequerida> habilidades = habilidadesPorUnidad.get(unidad);

        for (HabilidadRequerida h : habilidades) {
            if (h.getHabilidad().equalsIgnoreCase(nombreHab)) {
                cmbSemana.removeAllItems();
                for (Semana s : h.getSemanas()) {
                    cmbSemana.addItem("Semana " + s.getNumeroSemana());
                }
                break;
            }
        }
    }

    public void mostrarDatosDeUnidadSeleccionadaParaHabilidades() {
        int index = cmbUnidad.getSelectedIndex();
        List<Unidad> disponibles = this.unidades;
        if (index >= 0 && disponibles != null && index < disponibles.size()) {
            unidadSeleccionada = disponibles.get(index);
            this.modeloComboHabilidad.setHabi(unidadSeleccionada.getHabilidadesRequeridas());
        }
    }

    private void mostrarDatosDeHabilidadesSeleccionadaParaSemana() {

        Unidad unidad = (Unidad) cmbUnidadConfig.getSelectedItem();
        if (unidad == null) {
            cmbSemana.removeAllItems();
            return;
        }
        String nombreHab = (String) cmbHabilidadesConfig.getSelectedItem();
        if (nombreHab == null) {
            cmbSemana.removeAllItems();
            return;
        }
        List<HabilidadRequerida> habs
                = habilidadesPorUnidad.getOrDefault(unidad, Collections.emptyList());

        cmbSemana.removeAllItems();

        for (HabilidadRequerida h : habs) {
            if (h.getHabilidad().equalsIgnoreCase(nombreHab)) {
                for (Semana s : h.getSemanas()) {
                    cmbSemana.addItem("Semana " + s.getNumeroSemana());
                }
                break;
            }
        }
    }

    private void ActivarControlesPanelSsemana(boolean estado) {
        panSemana.setEnabled(estado);
        lblConocimiento.setEnabled(estado);
        txaConocimiento.setEditable(estado);
        lblActividadAprendizaje.setEnabled(estado);
        lblEvidencia.setEnabled(estado);
        lblTipoEvidencia.setEnabled(estado);
        cmbTipoEvidencia.setEditable(estado);
        lblEvidencia.setEnabled(estado);
        txaEvidencia.setEnabled(estado);
        lblInstrumentoEvaluación.setEnabled(estado);
        txaInstrumentoEvaluación.setEnabled(estado);
        btnGuardarSemana.setEnabled(estado);
    }

    private void actualizarUnidadesConHabilidades() {
        if (unidades == null || unidades.isEmpty()) {
            System.out.println("⚠ No hay unidades cargadas para actualizar.");
            return;
        }

        for (Unidad u : unidades) {
            List<HabilidadRequerida> habs = habilidadesPorUnidad.getOrDefault(u, new ArrayList<>());
            u.setHabilidadesRequeridas(habs);
            System.out.println("✅ Unidad actualizada: " + u.getNombre() + " con " + habs.size() + " habilidades.");
        }
    }

    private boolean validarDatosSemanas() {
        return true;
    }

}
