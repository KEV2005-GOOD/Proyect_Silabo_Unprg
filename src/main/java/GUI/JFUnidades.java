package GUI;

import GUI.modelos.HabilidadTableModel;
import GUI.modelos.HabilidadesComboModel;
import GUI.modelos.UnidadComboModel;
import GUI.modelos.semanaComoModel;
import entidades.EvidenciaAprendizaje;
import entidades.HabilidadRequerida;
import entidades.Semana;
import entidades.Unidad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class JFUnidades extends javax.swing.JFrame {

    private static JFUnidades instancia;
    private Unidad unidadSeleccionada;
    private int filaSeleccionada = -1;
    private List<Unidad> unidades;
    private int cantidadSemanas;
    private List<Semana> semanasTemp = new ArrayList<>();

    private final Map<Unidad, List<HabilidadRequerida>> habilidadesPorUnidad = new HashMap<>();
    private List<HabilidadRequerida> habilidadRequerida = new ArrayList<>();

    private final UnidadComboModel modeloComboUnidad = new UnidadComboModel();
    private final UnidadComboModel modeloComboUnidadConfig = new UnidadComboModel();
    private final HabilidadesComboModel modeloComboHabilidad = new HabilidadesComboModel();
    private final semanaComoModel modeloSemanas = new semanaComoModel();
    private final HabilidadTableModel listadoHabilidadesRequeridas = new HabilidadTableModel();

    private JFUnidades() {
        initComponents();
        configurarVentana();

    }

    public static JFUnidades mostrar(List<Unidad> unidades, int cantidadSemanas) {
        if (instancia == null) {
            instancia = new JFUnidades();
        }
        instancia.setDatos(unidades, cantidadSemanas);
        instancia.setVisible(true);
        return instancia;
    }

    private void configurarVentana() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                instancia = null;
            }
        });
    }

    private void setDatos(List<Unidad> unidades, int cantidadSemanas) {
        this.unidades = unidades;
        this.cantidadSemanas = cantidadSemanas;
        configurarCombosUnidad();
    }

    private void configurarCombosUnidad() {
        modeloComboUnidad.setUnidad(unidades);
        modeloComboUnidadConfig.setUnidad(unidades);
        cmbUnidad.setModel(modeloComboUnidad);
        cmbUnidadConfig.setModel(modeloComboUnidadConfig);
        cmbUnidad.setSelectedIndex(-1);
        cmbUnidadConfig.setSelectedIndex(-1);
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

        cmbUnidadConfig.setModel(this.modeloComboUnidadConfig);
        cmbUnidadConfig.setEnabled(false);
        cmbUnidadConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUnidadConfigActionPerformed(evt);
            }
        });

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

        cmbSemana.setModel(this.modeloSemanas);
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
        cmbUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUnidadActionPerformed(evt);
            }
        });

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
        aceptarHabilidad();
    }//GEN-LAST:event_btnAceptarHabilidadNuevaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelarEdicion();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarHabilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarHabilidadActionPerformed
        modificarHabilidad();
    }//GEN-LAST:event_btnModificarHabilidadActionPerformed

    private void btnGuardarHabilidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarHabilidadesActionPerformed
        guardarHabilidades();
    }//GEN-LAST:event_btnGuardarHabilidadesActionPerformed

    private void btnConfigurarHabilidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigurarHabilidadesActionPerformed
        activarPanelConfiguracion(true);
    }//GEN-LAST:event_btnConfigurarHabilidadesActionPerformed

    private void btnEliminarHabilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarHabilidadActionPerformed
        eliminarHabilidad();
    }//GEN-LAST:event_btnEliminarHabilidadActionPerformed

    private void btnModificarLasHabilidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarLasHabilidadesActionPerformed
        activarPanelConfiguracion(false);
    }//GEN-LAST:event_btnModificarLasHabilidadesActionPerformed

    private void cmbHabilidadesConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHabilidadesConfigActionPerformed
        mostrarSemanasDeHabilidad();
    }//GEN-LAST:event_cmbHabilidadesConfigActionPerformed

    private void btnConfigurarSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigurarSemanaActionPerformed
        activarPanelSemana(true);
    }//GEN-LAST:event_btnConfigurarSemanaActionPerformed

    private void btnGuardarSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarSemanaActionPerformed
        guardarSemanasDeHabilidad();
    }//GEN-LAST:event_btnGuardarSemanaActionPerformed

    private void cmbUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUnidadActionPerformed
        cmbUnidad.addActionListener(e -> {
            guardarHabilidadesPrevias();
            mostrarUnidadSeleccionada();
            cargarHabilidadesDeUnidad();
        });
    }//GEN-LAST:event_cmbUnidadActionPerformed

    private void cmbUnidadConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUnidadConfigActionPerformed
        cmbUnidadConfig.addActionListener(e -> {
            mostrarUnidadSeleccionadaParaHabilidades();
//            mostrarSemanasDeHabilidad();
        });
    }//GEN-LAST:event_cmbUnidadConfigActionPerformed

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
    private void manejarSeleccionUnidad() {
        guardarHabilidadesPrevias();
        mostrarUnidadSeleccionada();
        cargarHabilidadesDeUnidad();
    }

    private void manejarSeleccionUnidadConfig() {
        mostrarUnidadSeleccionadaParaHabilidades();
        mostrarDatosDeHabilidadParaSemana();
        mostrarSemanasDeHabilidad();
    }

    private void mostrarUnidadSeleccionada() {
        int index = cmbUnidad.getSelectedIndex();
        List<Unidad> disponibles = modeloComboUnidad.getUnidad();
        if (index >= 0 && disponibles != null && index < disponibles.size()) {
            unidadSeleccionada = disponibles.get(index);
            txaDesempeñoEsperado.setText(unidadSeleccionada.getDesempeño());
        }
    }

    private void cargarHabilidadesDeUnidad() {
        habilidadRequerida = habilidadesPorUnidad.getOrDefault(unidadSeleccionada, new ArrayList<>());
        listadoHabilidadesRequeridas.setHabilidadesReque(habilidadRequerida);
        tblListado.setModel(listadoHabilidadesRequeridas);
        listadoHabilidadesRequeridas.fireTableDataChanged();
        limpiarCamposHabilidad();
    }

    private void limpiarCamposHabilidad() {
        txaHabilidad.setText("");
        activarControles(false);
    }

    private void mostrarUnidadSeleccionadaParaHabilidades() {
        int index = cmbUnidadConfig.getSelectedIndex();
        List<Unidad> disponibles = this.unidades;
        if (index >= 0 && disponibles != null && index < disponibles.size()) {
            unidadSeleccionada = disponibles.get(index);
            this.modeloComboHabilidad.setHabi(unidadSeleccionada.getHabilidadesRequeridas());
        }
    }
    
    private List<Semana> crearSemanasDeUnidad(int indiceUnidad, int indiceHabilidad){
        int cantidad = unidades.get(indiceUnidad).getHabilidadesRequeridas().get(indiceHabilidad).getCantidadSemanas();
        List<Semana> semanas = new ArrayList<>();
        for(int i = 0; i < cantidad; i++){
            Semana s = new Semana();
            s.setNumeroSemana(i + 1);
            semanas.add(s);
        }
        return semanas;
        
    }

    private void mostrarDatosDeHabilidadParaSemana() {
        int index = cmbHabilidadesConfig.getSelectedIndex();

        String nombreHab = (String) cmbHabilidadesConfig.getSelectedItem();
        if (nombreHab == null) {
            return;
        }

        for(int i = 0; i < unidades.size(); i++){
            if(unidades.get(i).getNombre().equalsIgnoreCase(modeloComboUnidadConfig.getSeleccionado().getNombre())){
                modeloSemanas.setSemana(semanasTemp = crearSemanasDeUnidad(i, index));
                cmbSemana.setModel(modeloSemanas);
                break;
            }
        }
    }

    private void mostrarSemanasDeHabilidad() {
        mostrarDatosDeHabilidadParaSemana();
    }

    private void guardarHabilidadesPrevias() {
        if (unidadSeleccionada != null) {
            habilidadesPorUnidad.put(unidadSeleccionada, new ArrayList<>(habilidadRequerida));
        }

    }

    private void aceptarHabilidad() {
        if (unidadSeleccionada == null) {
            return;
        }

        String texto = txaHabilidad.getText().trim();
        int semanas = (int) spCantidadSemanas.getValue();

        if (!validarHabilidad(texto, semanas)) {
            return;
        }

        List<Semana> semanasAsignadas = new ArrayList<>();
        List<HabilidadRequerida> habilidadesUnidad = habilidadesPorUnidad.getOrDefault(unidadSeleccionada, new ArrayList<>());

        if (filaSeleccionada > -1) {
            HabilidadRequerida hr = habilidadesUnidad.get(filaSeleccionada);
            hr.setHabilidad(texto);
            hr.setCantidadSemanas(semanas);
            filaSeleccionada = -1;
        } else {
            habilidadesUnidad.add(new HabilidadRequerida(texto, semanas, semanasAsignadas));
        }

        habilidadesPorUnidad.put(unidadSeleccionada, habilidadesUnidad);
        actualizarTablaHabilidades(habilidadesUnidad);
        cancelarEdicion();
    }

    private void activarControles(boolean estado) {
        panHabilidad.setEnabled(estado);
        lblHabilidad.setEnabled(estado);
        txaHabilidad.setEnabled(estado);
        btnAceptarHabilidadNueva.setEnabled(estado);
        spCantidadSemanas.setEnabled(estado);
        btnCancelar.setEnabled(estado);
    }

    private void cancelarEdicion() {
        txaHabilidad.setText("");
        spCantidadSemanas.setValue(1);
        activarControles(false);
    }

    private boolean validarHabilidad(String texto, int semanas) {
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre de la habilidad no puede estar vacío.", "Dato inválido", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        List<HabilidadRequerida> habilidadesUnidad = habilidadesPorUnidad.getOrDefault(unidadSeleccionada, new ArrayList<>());
        for (HabilidadRequerida h : habilidadesUnidad) {
            if (h.getHabilidad().equalsIgnoreCase(texto) && h.getCantidadSemanas() == semanas && habilidadesUnidad.indexOf(h) != filaSeleccionada) {
                JOptionPane.showMessageDialog(this, "Ya existe una habilidad igual.", "Duplicado", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        return true;
    }

    private void actualizarTablaHabilidades(List<HabilidadRequerida> habilidadesUnidad) {
        habilidadRequerida = habilidadesUnidad;
        listadoHabilidadesRequeridas.setHabilidadesReque(habilidadRequerida);
        listadoHabilidadesRequeridas.fireTableDataChanged();
    }

    private void eliminarHabilidad() {
        int fila = tblListado.getSelectedRow();
        if (fila == -1 || unidadSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una habilidad para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "¿Eliminar esta habilidad?", "Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            List<HabilidadRequerida> habilidadesUnidad = habilidadesPorUnidad.getOrDefault(unidadSeleccionada, new ArrayList<>());
            habilidadesUnidad.remove(fila);
            habilidadesPorUnidad.put(unidadSeleccionada, habilidadesUnidad);
            actualizarTablaHabilidades(habilidadesUnidad);
            filaSeleccionada = -1;
        }
    }

    private void modificarHabilidad() {
        filaSeleccionada = tblListado.getSelectedRow();
        if (filaSeleccionada > -1) {
            HabilidadRequerida habilidad = habilidadRequerida.get(filaSeleccionada);
            txaHabilidad.setText(habilidad.getHabilidad());
            spCantidadSemanas.setValue(habilidad.getCantidadSemanas());
            activarControles(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una habilidad para modificar.");
        }
    }

    private void guardarHabilidades() {
        if (unidadSeleccionada == null) {
            return;
        }

        List<HabilidadRequerida> nuevas = obtenerHabilidadesNuevas();
        if (contarTotalSemanas() + contarSemanas(nuevas) > cantidadSemanas) {
            JOptionPane.showMessageDialog(this, "⛔ Se excedió en la cantidad de semanas permitidas.");
            return;
        }

        List<HabilidadRequerida> lista = habilidadesPorUnidad.getOrDefault(unidadSeleccionada, new ArrayList<>());
        lista.addAll(nuevas);
        habilidadesPorUnidad.put(unidadSeleccionada, lista);
        actualizarUnidadesConHabilidades();
        JOptionPane.showMessageDialog(this, "✅ Habilidades guardadas correctamente.");
    }

    private List<HabilidadRequerida> obtenerHabilidadesNuevas() {
        List<HabilidadRequerida> actuales = listadoHabilidadesRequeridas.getHabilidadesReque();
        List<HabilidadRequerida> existentes = habilidadesPorUnidad.getOrDefault(unidadSeleccionada, new ArrayList<>());
        List<HabilidadRequerida> nuevas = new ArrayList<>();
        for (HabilidadRequerida h : actuales) {
            boolean existe = existentes.stream().anyMatch(e -> e.getHabilidad().equalsIgnoreCase(h.getHabilidad()) && e.getCantidadSemanas() == h.getCantidadSemanas());
            if (!existe) {
                nuevas.add(h);
            }
        }
        return nuevas;
    }

    private int contarTotalSemanas() {
        return habilidadesPorUnidad.values().stream()
                .flatMap(List::stream)
                .mapToInt(HabilidadRequerida::getCantidadSemanas)
                .sum();
    }

    private int contarSemanas(List<HabilidadRequerida> lista) {
        return lista.stream().mapToInt(HabilidadRequerida::getCantidadSemanas).sum();
    }

    private void activarPanelConfiguracion(boolean estado) {
        panConfiguracionHabilidades.setEnabled(estado);
        lblUnidadConfig.setEnabled(estado);
        cmbUnidadConfig.setEnabled(estado);
        lblNombreHabilidad.setEnabled(estado);
        cmbHabilidadesConfig.setEnabled(estado);
        lblSemanasConfig.setEnabled(estado);
        cmbSemana.setEnabled(estado);
        btnConfigurarSemana.setEnabled(estado);
        btnModificarLasHabilidades.setEnabled(estado);
    }

    private void activarPanelSemana(boolean estado) {
        if(cmbSemana.getSelectedIndex() > -1 || estado == false){
            panSemana.setEnabled(estado);
            lblConocimiento.setEnabled(estado);
            txaConocimiento.setEnabled(estado);
            lblActividadAprendizaje.setEnabled(estado);
            txaActividadesDeAprendizaje.setEnabled(estado);
            lblTipoEvidencia.setEnabled(estado);
            cmbTipoEvidencia.setEnabled(estado);
            lblEvidencia.setEnabled(estado);
            txaEvidencia.setEnabled(estado);
            lblInstrumentoEvaluación.setEnabled(estado);
            txaInstrumentoEvaluación.setEnabled(estado);
            btnGuardarSemana.setEnabled(estado);
        }
        else{
            
        }
    }

    private void actualizarUnidadesConHabilidades() {
        if (unidades == null || unidades.isEmpty()) {
            return;
        }

        for (Unidad u : unidades) {
            List<HabilidadRequerida> habs = habilidadesPorUnidad.getOrDefault(u, new ArrayList<>());
            u.setHabilidadesRequeridas(habs);
        }
    }
    
    private void guardarSemanasDeHabilidad(){
        if(txaConocimiento.getText().isEmpty() || txaActividadesDeAprendizaje.getText().isEmpty() || txaEvidencia.getText().isEmpty() || 
                txaInstrumentoEvaluación.getText().isEmpty() || cmbTipoEvidencia.getSelectedIndex() <= -1){
            
        }
        else{
            System.out.println("Prueba");
            Semana obj = new Semana();
            EvidenciaAprendizaje objEvi = new EvidenciaAprendizaje();
            obj.setConocimiento(txaConocimiento.getText());
            obj.setActividadAprendizaje(txaActividadesDeAprendizaje.getText());
            objEvi.setEvidencia(txaEvidencia.getText());
            objEvi.setInstrumentoEvaluacion(txaInstrumentoEvaluación.getText());
            objEvi.setTipoEvidencia(cmbTipoEvidencia.getSelectedItem().toString());
            obj.setEvidenciasAprendizaje(objEvi);
            
            // 
            semanasTemp.set(cmbSemana.getSelectedIndex(), obj);
            
            // Probar lo guardado para comprobar que se haya guardado
            System.out.println(cmbSemana.getSelectedIndex() + "");
            
            activarPanelSemana(false);
        }
    }

}
