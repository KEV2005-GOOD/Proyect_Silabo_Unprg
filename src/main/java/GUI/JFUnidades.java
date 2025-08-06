package GUI;

import GUI.modelos.HabilidadTableModel;
import GUI.modelos.HabilidadesComboModel;
import GUI.modelos.UnidadComboModel;
import GUI.modelos.semanaComboModel;
import entidades.EvidenciaAprendizaje;
import entidades.HabilidadRequerida;
import entidades.Semana;
import entidades.Unidad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class JFUnidades extends javax.swing.JFrame {

    private static JFUnidades instancia;
    private Unidad unidadSeleccionada;
    private HabilidadRequerida habilidadSeleccionada;
    private Semana semanaSeleccionada;
    private int filaSeleccionada = -1;
    private static List<Unidad> unidades;
    private int cantidadSemanas;

    private final Map<Unidad, List<HabilidadRequerida>> habilidadesPorUnidad = new HashMap<>();
    private List<HabilidadRequerida> habilidadRequerida = new ArrayList<>();

    private final UnidadComboModel modeloComboUnidad = new UnidadComboModel();
    private final UnidadComboModel modeloComboUnidadConfig = new UnidadComboModel();
    private final HabilidadesComboModel modeloComboHabilidad = new HabilidadesComboModel();
    private final semanaComboModel modeloSemanas = new semanaComboModel();
    private final HabilidadTableModel listadoHabilidadesRequeridas = new HabilidadTableModel();

    private JFUnidades() {
        initComponents();
        configurarVentana();
    }

    public static List<Unidad> retornaUnidades() {
        return unidades;
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
        lblActividadEvidenciaAprendizaje = new javax.swing.JLabel();
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
        btnCancelarConfiguraciónSemana = new javax.swing.JButton();
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
        btnCancelarHabilidad = new javax.swing.JButton();
        lblSemanas = new javax.swing.JLabel();
        spCantidadSemanas = new javax.swing.JSpinner();
        btnGuardarHabilidades = new javax.swing.JButton();
        lblIndicadorSemanas = new javax.swing.JLabel();
        btnConfigurarHabilidades = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bntCancelar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        bntCancelar.setText("Cancelar");

        btnAcepetarEditar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnAcepetarEditar.setText("Aceptar");
        btnAcepetarEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcepetarEditarActionPerformed(evt);
            }
        });

        panConfiguracionHabilidades.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Configurar Habilidades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 15))); // NOI18N
        panConfiguracionHabilidades.setEnabled(false);

        lblNombreHabilidad.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblNombreHabilidad.setText("Habilidad: ");
        lblNombreHabilidad.setEnabled(false);

        cmbHabilidadesConfig.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        cmbHabilidadesConfig.setModel(this.modeloComboHabilidad);
        cmbHabilidadesConfig.setEnabled(false);
        cmbHabilidadesConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHabilidadesConfigActionPerformed(evt);
            }
        });

        lblUnidadConfig.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblUnidadConfig.setText("Unidad: ");
        lblUnidadConfig.setEnabled(false);

        cmbUnidadConfig.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        cmbUnidadConfig.setModel(this.modeloComboUnidadConfig);
        cmbUnidadConfig.setEnabled(false);
        cmbUnidadConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUnidadConfigActionPerformed(evt);
            }
        });

        lblSemanasConfig.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblSemanasConfig.setText("Semana: ");
        lblSemanasConfig.setEnabled(false);

        panSemana.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Semana", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 15))); // NOI18N
        panSemana.setEnabled(false);

        lblConocimiento.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblConocimiento.setText("Conocimiento: ");
        lblConocimiento.setEnabled(false);

        txaConocimiento.setColumns(20);
        txaConocimiento.setRows(5);
        txaConocimiento.setEnabled(false);
        scpConocimiento.setViewportView(txaConocimiento);

        lblActividadEvidenciaAprendizaje.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblActividadEvidenciaAprendizaje.setText("Actividad de aprendizaje: ");
        lblActividadEvidenciaAprendizaje.setEnabled(false);

        txaActividadesDeAprendizaje.setColumns(20);
        txaActividadesDeAprendizaje.setRows(5);
        txaActividadesDeAprendizaje.setEnabled(false);
        scpActividadesAprendizaje.setViewportView(txaActividadesDeAprendizaje);

        lblActividadAprendizaje.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblActividadAprendizaje.setText("EVIDENCIA APRENDIZAJE: ");
        lblActividadAprendizaje.setEnabled(false);

        lblTipoEvidencia.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblTipoEvidencia.setText("Tipo de Evidencia: ");
        lblTipoEvidencia.setEnabled(false);

        cmbTipoEvidencia.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        cmbTipoEvidencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Exámenes", "Trabajos Escritos", "Presentaciones Orales ", "Proyectos", "Portafolios", "Pruebas Prácticas", "Observaciones Conductuales", "Entrevistas de Competencias", "Autoevaluaciones y Diarios de Aprendizaje", "Informes de Progreso", "Comentarios y Retroalimentación", "Creaciones Artísticas", "Maquetas y Prototipos", "Videojuegos y Aplicaciones Digitales", "Cuadernos de Notas y Bitácoras" }));
        cmbTipoEvidencia.setSelectedIndex(-1);
        cmbTipoEvidencia.setEnabled(false);

        lblEvidencia.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblEvidencia.setText("Evidencia: ");
        lblEvidencia.setEnabled(false);

        txaEvidencia.setColumns(20);
        txaEvidencia.setRows(5);
        txaEvidencia.setEnabled(false);
        scpEvidencia.setViewportView(txaEvidencia);

        lblInstrumentoEvaluación.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblInstrumentoEvaluación.setText("Instrumento Evaluación:");
        lblInstrumentoEvaluación.setEnabled(false);

        txaInstrumentoEvaluación.setColumns(20);
        txaInstrumentoEvaluación.setRows(5);
        txaInstrumentoEvaluación.setEnabled(false);
        scpInstrumentoEvaluación.setViewportView(txaInstrumentoEvaluación);

        btnGuardarSemana.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnGuardarSemana.setText("Guardar");
        btnGuardarSemana.setEnabled(false);
        btnGuardarSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarSemanaActionPerformed(evt);
            }
        });

        btnCancelarConfiguraciónSemana.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnCancelarConfiguraciónSemana.setText("Cancelar");
        btnCancelarConfiguraciónSemana.setEnabled(false);
        btnCancelarConfiguraciónSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarConfiguraciónSemanaActionPerformed(evt);
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
                                .addComponent(lblActividadEvidenciaAprendizaje)
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
                                .addComponent(cmbTipoEvidencia, 0, 320, Short.MAX_VALUE)
                                .addGap(207, 207, 207))
                            .addComponent(scpEvidencia, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                            .addComponent(scpInstrumentoEvaluación, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panSemanaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btnCancelarConfiguraciónSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panSemanaLayout.setVerticalGroup(
            panSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSemanaLayout.createSequentialGroup()
                .addGroup(panSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panSemanaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scpConocimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                    .addComponent(lblConocimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblActividadEvidenciaAprendizaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scpActividadesAprendizaje, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addComponent(lblActividadAprendizaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(panSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoEvidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoEvidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEvidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scpEvidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInstrumentoEvaluación, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scpInstrumentoEvaluación, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarConfiguraciónSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        btnConfigurarSemana.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnConfigurarSemana.setText("Configurar");
        btnConfigurarSemana.setEnabled(false);
        btnConfigurarSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigurarSemanaActionPerformed(evt);
            }
        });

        btnModificarLasHabilidades.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnModificarLasHabilidades.setText("Modificar Habilidades");
        btnModificarLasHabilidades.setEnabled(false);
        btnModificarLasHabilidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarLasHabilidadesActionPerformed(evt);
            }
        });

        cmbSemana.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        cmbSemana.setModel(this.modeloSemanas);
        cmbSemana.setEnabled(false);
        cmbSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSemanaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panConfiguracionHabilidadesLayout = new javax.swing.GroupLayout(panConfiguracionHabilidades);
        panConfiguracionHabilidades.setLayout(panConfiguracionHabilidadesLayout);
        panConfiguracionHabilidadesLayout.setHorizontalGroup(
            panConfiguracionHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panConfiguracionHabilidadesLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panConfiguracionHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panConfiguracionHabilidadesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConfigurarSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panSemana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panConfiguracionHabilidadesLayout.createSequentialGroup()
                        .addComponent(lblNombreHabilidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbHabilidadesConfig, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panConfiguracionHabilidadesLayout.createSequentialGroup()
                        .addComponent(lblUnidadConfig)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbUnidadConfig, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panConfiguracionHabilidadesLayout.createSequentialGroup()
                        .addGroup(panConfiguracionHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panConfiguracionHabilidadesLayout.createSequentialGroup()
                                .addComponent(lblSemanasConfig)
                                .addGap(18, 18, 18)
                                .addComponent(cmbSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnModificarLasHabilidades))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panConfiguracionHabilidadesLayout.setVerticalGroup(
            panConfiguracionHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panConfiguracionHabilidadesLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panConfiguracionHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbUnidadConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnidadConfig))
                .addGap(18, 18, 18)
                .addGroup(panConfiguracionHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreHabilidad)
                    .addComponent(cmbHabilidadesConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panConfiguracionHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSemanasConfig)
                    .addComponent(cmbSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(btnConfigurarSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panSemana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificarLasHabilidades, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        panRegistroDeHabilidades.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Registro Habilidades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 15))); // NOI18N

        cmbUnidad.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        cmbUnidad.setModel(this.modeloComboUnidad);
        cmbUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUnidadActionPerformed(evt);
            }
        });

        lblUnidad.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblUnidad.setText("Unidad: ");

        lblDesempeñoEsperado.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblDesempeñoEsperado.setText("Desempeño Esperado:");

        txaDesempeñoEsperado.setEditable(false);
        txaDesempeñoEsperado.setColumns(20);
        txaDesempeñoEsperado.setRows(5);
        scpDesempeñoEsperado.setViewportView(txaDesempeñoEsperado);

        panAgregarHabilidad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Agregamos habilidades"), "Agregamos la habilidad Requerida", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 15))); // NOI18N

        panListadoHabilidades.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Listado Habilidades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 15))); // NOI18N

        tblListado.setModel(this.listadoHabilidadesRequeridas);
        scpTablaListado.setViewportView(tblListado);

        btnNuevaHabilidad.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnNuevaHabilidad.setText("Nuevo");
        btnNuevaHabilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaHabilidadActionPerformed(evt);
            }
        });

        btnModificarHabilidad.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnModificarHabilidad.setText("Modificar");
        btnModificarHabilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarHabilidadActionPerformed(evt);
            }
        });

        btnEliminarHabilidad.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
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
                        .addComponent(btnNuevaHabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificarHabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarHabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scpTablaListado, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );
        panListadoHabilidadesLayout.setVerticalGroup(
            panListadoHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panListadoHabilidadesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scpTablaListado, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panListadoHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarHabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevaHabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarHabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        panHabilidad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Listado Habilidades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 15))); // NOI18N
        panHabilidad.setEnabled(false);

        lblHabilidad.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblHabilidad.setText("Habilidad: ");
        lblHabilidad.setEnabled(false);

        txaHabilidad.setColumns(20);
        txaHabilidad.setRows(5);
        txaHabilidad.setEnabled(false);
        scpHabilidad.setViewportView(txaHabilidad);

        btnAceptarHabilidadNueva.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnAceptarHabilidadNueva.setText("Aceptar");
        btnAceptarHabilidadNueva.setEnabled(false);
        btnAceptarHabilidadNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarHabilidadNuevaActionPerformed(evt);
            }
        });

        btnCancelarHabilidad.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnCancelarHabilidad.setText("Cancelar");
        btnCancelarHabilidad.setEnabled(false);
        btnCancelarHabilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarHabilidadActionPerformed(evt);
            }
        });

        lblSemanas.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblSemanas.setText("Semanas: ");

        spCantidadSemanas.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        spCantidadSemanas.setModel(new javax.swing.SpinnerNumberModel(1, 1, 4, 1));
        spCantidadSemanas.setEnabled(false);

        javax.swing.GroupLayout panHabilidadLayout = new javax.swing.GroupLayout(panHabilidad);
        panHabilidad.setLayout(panHabilidadLayout);
        panHabilidadLayout.setHorizontalGroup(
            panHabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panHabilidadLayout.createSequentialGroup()
                .addGroup(panHabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpHabilidad)
                    .addGroup(panHabilidadLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblHabilidad)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panHabilidadLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptarHabilidadNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelarHabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
            .addGroup(panHabilidadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSemanas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spCantidadSemanas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panHabilidadLayout.setVerticalGroup(
            panHabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panHabilidadLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblHabilidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scpHabilidad, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panHabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSemanas)
                    .addComponent(spCantidadSemanas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(panHabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarHabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptarHabilidadNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        btnGuardarHabilidades.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnGuardarHabilidades.setText("Guardar");
        btnGuardarHabilidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarHabilidadesActionPerformed(evt);
            }
        });

        lblIndicadorSemanas.setText("      ");

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
                .addGroup(panAgregarHabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarHabilidades, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAgregarHabilidadLayout.createSequentialGroup()
                        .addComponent(lblIndicadorSemanas)
                        .addGap(232, 232, 232))))
        );
        panAgregarHabilidadLayout.setVerticalGroup(
            panAgregarHabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAgregarHabilidadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panAgregarHabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panHabilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panListadoHabilidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(btnGuardarHabilidades, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(lblIndicadorSemanas)
                .addContainerGap())
        );

        btnConfigurarHabilidades.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
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
                    .addComponent(panAgregarHabilidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRegistroDeHabilidadesLayout.createSequentialGroup()
                        .addComponent(lblUnidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbUnidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRegistroDeHabilidadesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConfigurarHabilidades)))
                .addContainerGap())
        );
        panRegistroDeHabilidadesLayout.setVerticalGroup(
            panRegistroDeHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRegistroDeHabilidadesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panRegistroDeHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panRegistroDeHabilidadesLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblUnidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(panRegistroDeHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDesempeñoEsperado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scpDesempeñoEsperado, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panAgregarHabilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfigurarHabilidades, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(btnAcepetarEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(bntCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(bntCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAcepetarEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnCancelarHabilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarHabilidadActionPerformed
        cancelarEdicion();
    }//GEN-LAST:event_btnCancelarHabilidadActionPerformed

    private void btnModificarHabilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarHabilidadActionPerformed
        modificarHabilidad();
    }//GEN-LAST:event_btnModificarHabilidadActionPerformed

    private void btnGuardarHabilidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarHabilidadesActionPerformed
        guardarHabilidades();
    }//GEN-LAST:event_btnGuardarHabilidadesActionPerformed

    private void btnConfigurarHabilidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigurarHabilidadesActionPerformed
        activarPanelConfiguracion(true);
        cargarUniModHabilidades();
    }//GEN-LAST:event_btnConfigurarHabilidadesActionPerformed

    private void btnEliminarHabilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarHabilidadActionPerformed
        eliminarHabilidad();
    }//GEN-LAST:event_btnEliminarHabilidadActionPerformed

    private void btnModificarLasHabilidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarLasHabilidadesActionPerformed
        activarPanelConfiguracion(false);
    }//GEN-LAST:event_btnModificarLasHabilidadesActionPerformed

    private void cmbHabilidadesConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHabilidadesConfigActionPerformed
        if (habilidadSeleccionada != null) {
            asignarHabilidadAsuUnidad();
        }
        habilidadSeleccionada = null;
        int pos = this.cmbHabilidadesConfig.getSelectedIndex();
        if (pos > -1) {
            this.habilidadSeleccionada = this.unidadSeleccionada.getHabilidadesRequeridas().get(pos);
            cargarSemanas();
            this.cmbSemana.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_cmbHabilidadesConfigActionPerformed

    private void btnConfigurarSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigurarSemanaActionPerformed
        activarPanelSemana(true);
    }//GEN-LAST:event_btnConfigurarSemanaActionPerformed

    private void btnGuardarSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarSemanaActionPerformed
        guardarSemanasDeHabilidad();
        activarPanelSemana(false);
        limpiarSemana();
    }//GEN-LAST:event_btnGuardarSemanaActionPerformed

    private void cmbUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUnidadActionPerformed
        cmbUnidad.addActionListener(e -> {
            guardarHabilidadesPrevias();
            mostrarUnidadSeleccionada();
            cargarHabilidadesDeUnidad();
        });
    }//GEN-LAST:event_cmbUnidadActionPerformed

    private void cmbUnidadConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUnidadConfigActionPerformed
        if (unidadSeleccionada != null) {
            asignarUnidadAListaDeUnidad();
        }
        unidadSeleccionada = null;
        int pos = this.cmbUnidadConfig.getSelectedIndex();
        if (pos > -1) {
            this.unidadSeleccionada = this.unidades.get(pos);
            cargarHabilidades();
            this.cmbHabilidadesConfig.setSelectedIndex(-1);
            this.cmbSemana.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_cmbUnidadConfigActionPerformed

    private void cmbSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSemanaActionPerformed
        semanaSeleccionada = null;
        int pos = this.cmbSemana.getSelectedIndex();
        if (pos > -1) {
            this.semanaSeleccionada = this.habilidadSeleccionada.getSemanas().get(pos);
        }
    }//GEN-LAST:event_cmbSemanaActionPerformed

    private void btnCancelarConfiguraciónSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarConfiguraciónSemanaActionPerformed
        limpiarSemana();
        activarPanelSemana(false);
    }//GEN-LAST:event_btnCancelarConfiguraciónSemanaActionPerformed

    private void btnAcepetarEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcepetarEditarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnAcepetarEditarActionPerformed

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
    private javax.swing.JButton btnCancelarConfiguraciónSemana;
    private javax.swing.JButton btnCancelarHabilidad;
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
    private javax.swing.JLabel lblActividadAprendizaje;
    private javax.swing.JLabel lblActividadEvidenciaAprendizaje;
    private javax.swing.JLabel lblConocimiento;
    private javax.swing.JLabel lblDesempeñoEsperado;
    private javax.swing.JLabel lblEvidencia;
    private javax.swing.JLabel lblHabilidad;
    private javax.swing.JLabel lblIndicadorSemanas;
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
        btnCancelarHabilidad.setEnabled(estado);
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
        int contador = contarTotalSemanas();
        lblIndicadorSemanas.setText("Lleva " + String.valueOf(contador) + " semanas de  :" + cantidadSemanas);
        if (contador + contarSemanas(nuevas) > cantidadSemanas) {
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

        panRegistroDeHabilidades.setEnabled(!estado);
        lblUnidad.setEnabled(!estado);
        cmbUnidad.setEnabled(!estado);
        panAgregarHabilidad.setEnabled(!estado);
        panHabilidad.setEnabled(!estado);
        txaHabilidad.setEnabled(!estado);
        lblSemanas.setEnabled(!estado);
        spCantidadSemanas.setEnabled(!estado);
        btnAceptarHabilidadNueva.setEnabled(!estado);
        btnCancelarHabilidad.setEnabled(!estado);
        panListadoHabilidades.setEnabled(!estado);
        btnModificarHabilidad.setEnabled(!estado);
        btnNuevaHabilidad.setEnabled(!estado);
        btnEliminarHabilidad.setEnabled(!estado);
        btnGuardarHabilidades.setEnabled(!estado);
        btnConfigurarHabilidades.setEnabled(!estado);

    }

    private void activarPanelSemana(boolean estado) {
        if (cmbSemana.getSelectedIndex() > -1 || estado == false) {
            panSemana.setEnabled(estado);
            lblConocimiento.setEnabled(estado);
            txaConocimiento.setEnabled(estado);
            lblActividadAprendizaje.setEnabled(estado);
            lblActividadEvidenciaAprendizaje.setEnabled(estado);
            txaActividadesDeAprendizaje.setEnabled(estado);
            lblTipoEvidencia.setEnabled(estado);
            cmbTipoEvidencia.setEnabled(estado);
            lblEvidencia.setEnabled(estado);
            txaEvidencia.setEnabled(estado);
            lblInstrumentoEvaluación.setEnabled(estado);
            txaInstrumentoEvaluación.setEnabled(estado);
            btnGuardarSemana.setEnabled(estado);
            btnCancelarConfiguraciónSemana.setEnabled(estado);

            panConfiguracionHabilidades.setEnabled(!estado);
            lblUnidadConfig.setEnabled(!estado);
            cmbUnidadConfig.setEnabled(!estado);
            lblNombreHabilidad.setEnabled(!estado);
            cmbHabilidadesConfig.setEnabled(!estado);
            lblSemanasConfig.setEnabled(!estado);
            cmbSemana.setEnabled(!estado);
            btnConfigurarSemana.setEnabled(!estado);
        } else {
            mensajeGuiaParaConfigSemana();
        }
    }

    private void mensajeGuiaParaConfigSemana() {
        JOptionPane.showMessageDialog(null, "debe de seleccionar una semana para poder configurarla");
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

    private void guardarSemanasDeHabilidad() {
        if (validarDatosSemana() != false) {
            EvidenciaAprendizaje objEvi = new EvidenciaAprendizaje();
            this.semanaSeleccionada.setConocimiento(txaConocimiento.getText());
            this.semanaSeleccionada.setActividadAprendizaje(txaActividadesDeAprendizaje.getText());
            objEvi.setEvidencia(txaEvidencia.getText());
            objEvi.setInstrumentoEvaluacion(txaInstrumentoEvaluación.getText());
            objEvi.setTipoEvidencia(cmbTipoEvidencia.getSelectedItem().toString());
            this.semanaSeleccionada.setEvidenciasAprendizaje(objEvi);
            asignasemanallenaHabilidad();
            for (Semana object : habilidadSeleccionada.getSemanas()) {
                System.out.println(object.getConocimiento());
            }

        }
    }

    private boolean validarDatosSemana() {

        String mensaje = "";

        if (txaConocimiento.getText().isEmpty() && txaConocimiento.getText().isBlank()) {
            mensaje += " Complete el campo de Conocimientos \n";
            JOptionPane.showMessageDialog(null, mensaje);
            txaConocimiento.requestFocusInWindow();
            return false;
        }
        if (txaActividadesDeAprendizaje.getText().isEmpty() && txaActividadesDeAprendizaje.getText().isBlank()) {
            mensaje += " Complete el campo de Actividades de aprendizaje \n ";
            JOptionPane.showMessageDialog(null, mensaje);
            txaActividadesDeAprendizaje.requestFocusInWindow();
            return false;
        }
        if (txaEvidencia.getText().isEmpty() && txaEvidencia.getText().isBlank()) {
            mensaje += " Complete el campo de evidencia \n ";
            JOptionPane.showMessageDialog(null, mensaje);
            txaEvidencia.requestFocusInWindow();
            return false;
        }
        if (txaInstrumentoEvaluación.getText().isEmpty() && txaInstrumentoEvaluación.getText().isBlank()) {
            mensaje += " Complete el campo de Instrumento de evaluación\n ";
            JOptionPane.showMessageDialog(null, mensaje);
            txaInstrumentoEvaluación.requestFocusInWindow();
            return false;
        }
        if (cmbTipoEvidencia.getSelectedIndex() <= -1) {
            mensaje += " Seleccione un tipo de evidencia\n ";
            JOptionPane.showMessageDialog(null, mensaje);
            cmbTipoEvidencia.requestFocusInWindow();
            return false;
        }
        return true;
    }

    private void cargarUniModHabilidades() {
        if (unidades == null || unidades.isEmpty()) {
            return;
        } else {
            modeloComboUnidadConfig.setUnidad(unidades);
            cmbUnidadConfig.setSelectedIndex(-1);
        }

    }

    private void cargarHabilidades() {
        if (unidadSeleccionada != null) {
            modeloComboHabilidad.setHabi(unidadSeleccionada.getHabilidadesRequeridas());
            cmbHabilidadesConfig.setSelectedIndex(-1);
        }
    }

    private void cargarSemanas() {
        if (habilidadSeleccionada != null) {
            if (habilidadSeleccionada.getSemanas().size() == 0) {
                crearSemanasParaLasHabilidades(habilidadSeleccionada.getCantidadSemanas(), habilidadSeleccionada);
            }
            modeloSemanas.setSemana(habilidadSeleccionada.getSemanas());
            cmbSemana.setSelectedIndex(-1);
        }
    }

    private void crearSemanasParaLasHabilidades(int cantidadSemanas, HabilidadRequerida habilidadSeleccionada) {
        if (habilidadSeleccionada.getCantidadSemanas() > 0) {
            List<Semana> ls = new ArrayList<>();
            for (int i = 0; i < cantidadSemanas; i++) {
                Semana semanaaxi = new Semana();
                semanaaxi.setNumeroSemana(i + 1);
                ls.add(semanaaxi);
            }
            habilidadSeleccionada.setSemanas(ls);
        }

    }

    private void limpiarSemana() {
        txaConocimiento.setText("");
        txaActividadesDeAprendizaje.setText("");
        cmbTipoEvidencia.setSelectedIndex(-1);
        txaEvidencia.setText("");
        txaInstrumentoEvaluación.setText("");
    }

    private void asignasemanallenaHabilidad() {
        int contarInd = -1;
        for (Semana sen : habilidadSeleccionada.getSemanas()) {
            contarInd += 1;
            if (String.valueOf(this.semanaSeleccionada.getNumeroSemana()).equals(sen.getNumeroSemana())) {
                habilidadSeleccionada.getSemanas().set(contarInd, this.semanaSeleccionada);
            }
        }
    }

    private void asignarHabilidadAsuUnidad() {
        int contarInd = -1;
        for (HabilidadRequerida habi : unidadSeleccionada.getHabilidadesRequeridas()) {
            contarInd += 1;
            if (this.habilidadSeleccionada.getHabilidad().equals(habi.getHabilidad())) {
                unidadSeleccionada.getHabilidadesRequeridas().set(contarInd, this.habilidadSeleccionada);
            }
        }
    }

    private void asignarUnidadAListaDeUnidad() {
        int contarInd = -1;
        for (Unidad uni : unidades) {
            contarInd += 1;
            if (this.unidadSeleccionada.getNombre().equals(uni.getNombre())) {
                unidades.set(contarInd, this.unidadSeleccionada);
            }
        }
    }
}
