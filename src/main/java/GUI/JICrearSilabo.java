package GUI;

import GUI.modelos.CiclosComboModel;
import GUI.modelos.CursoComboModel;
import GUI.modelos.DesempeñosTableModelo;
import GUI.modelos.EvaluacionesTableModel;
import GUI.modelos.UnidadComboModel;
import GUI.modelos.UnidadTableModel;
import entidades.Ciclo;
import entidades.Curso;
import entidades.DepartamentoAcademico;
import entidades.Desempeño;
import entidades.Docente;
import entidades.Escuela;
import entidades.EvaluacionesCalificadas;
import entidades.Facultad;
import entidades.Silabo;
import entidades.Unidad;
import entidades.Usuario;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class JICrearSilabo extends javax.swing.JInternalFrame {

    private EvaluacionesTableModel modelo = new EvaluacionesTableModel();
    private static JICrearSilabo frm;
    private static Escuela escuela;
    private static Facultad facultad;
    private static DepartamentoAcademico departamento;

    private Date FechaInicio;
    private Date FechaFin;
    private Ciclo cicloSeleccionado;
    private Curso cursoSeleccionado;
    private boolean detallado = true;
    private boolean plan = true;

    private static Docente usuarioCreador;
    private static List<EvaluacionesCalificadas> evaluaciones = new ArrayList<EvaluacionesCalificadas>();

    private List<Ciclo> ciclosVigentes;
    private List<Curso> cursosVigentes;
    private List<Unidad> unidadesLis;
    private UnidadTableModel modeloUnidad = new UnidadTableModel();

    private CiclosComboModel modeloCiclos = new CiclosComboModel();
    private CursoComboModel modeloCursos = new CursoComboModel();
    private DesempeñosTableModelo modeloDesempeño = new DesempeñosTableModelo();
    private UnidadComboModel modeloComboUnidad = new UnidadComboModel();

    public JICrearSilabo(Silabo silabo, Usuario user) throws IOException {
        initComponents();
        pn8.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
            @Override
            protected int calculateTabAreaHeight(int tabPlacement, int runCount, int maxTabHeight) {
                return 0;
            }
        });
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        setBorder(null);
        this.facultad = silabo.getFacultad();
        this.departamento = silabo.getDepatamento();
        this.escuela = silabo.getEscuela();
        this.usuarioCreador = user.getDocente();
        cargarDatosASilabo();
        cargarDatosDocenteLoggeado();
        cargarCiclosDeSilabo();
        configurarTablaDesempeñosMultilinea();

        // Configurar listener para limpiar referencia cuando se cierre
        this.setDefaultCloseOperation(javax.swing.JInternalFrame.DISPOSE_ON_CLOSE);
        this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
                frm = null;
            }
        });
    }

    public static JICrearSilabo crear(javax.swing.JDesktopPane contenedor, Silabo silabo, Usuario usuarioDocente) throws IOException {
        if (JICrearSilabo.frm == null) {
            JICrearSilabo.frm = new JICrearSilabo(silabo, usuarioDocente);
            JICrearSilabo.frm.setResizable(true);
            contenedor.add(JICrearSilabo.frm);
        }
        return JICrearSilabo.frm;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn8 = new javax.swing.JTabbedPane();
        pn1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblPrerrequistos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        axtPrerrequisitos = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        txtHorasSemanales = new javax.swing.JTextField();
        lblHorasTeoricas = new javax.swing.JLabel();
        lblHorasPracticas = new javax.swing.JLabel();
        txtHorasTeoricas = new javax.swing.JTextField();
        txtHorasPracticas = new javax.swing.JTextField();
        lblDuracion = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        lblFechaFinal = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtDocente = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jdcFechaInicio = new com.toedter.calendar.JDateChooser();
        jTextField1 = new javax.swing.JTextField();
        txtGrado = new javax.swing.JTextField();
        lblTipoCurso = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        lblUniversidad = new javax.swing.JLabel();
        txtUniversidad = new javax.swing.JTextField();
        lblDepartamento = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JTextField();
        lblEscuela = new javax.swing.JLabel();
        txtEscuela = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbCiclos = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cmbCursos = new javax.swing.JComboBox<>();
        lblFacultad = new javax.swing.JLabel();
        txtFacultad = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        lblCodigoCurso = new javax.swing.JLabel();
        txtCodigoCurso = new javax.swing.JTextField();
        lblCreditos = new javax.swing.JLabel();
        txtCreditos = new javax.swing.JTextField();
        lblSemestreAcademico = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        bntSiguiente1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        spDuración = new javax.swing.JSpinner();
        pn2 = new javax.swing.JPanel();
        btnSiguiente2 = new javax.swing.JButton();
        btnAtras2 = new javax.swing.JButton();
        jScrollPane19 = new javax.swing.JScrollPane();
        axtSumilla = new javax.swing.JTextArea();
        pn3 = new javax.swing.JPanel();
        btnSiguiente3 = new javax.swing.JButton();
        bntAtras3 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        atxCompetenciaProfesional = new javax.swing.JTextArea();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        atxCapacidadCurso = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        axtDesempeños = new javax.swing.JTextArea();
        pn4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblDesempeñosUnidades = new javax.swing.JTable();
        btnEditarUnidades = new javax.swing.JButton();
        panUnidades = new javax.swing.JPanel();
        jscUnidad = new javax.swing.JScrollPane();
        tblUnidades = new javax.swing.JTable();
        lblUnidades = new javax.swing.JLabel();
        cmbUMostrarUnidades = new javax.swing.JComboBox<>();
        btnAnterior4 = new javax.swing.JButton();
        btnSiguiente4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnMostrarUnidad = new javax.swing.JButton();
        pn5 = new javax.swing.JPanel();
        ADS = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblEvaluaciones = new javax.swing.JTable();
        txtPromedioFinal = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btnSiguiente5 = new javax.swing.JButton();
        btnAnterior5 = new javax.swing.JButton();
        btnAgregarEvaluacion = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGenerarFormula = new javax.swing.JButton();
        pn6 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        txaMetodologiaEnseñanza = new javax.swing.JTextArea();
        panDetallado = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        axtMetopro = new javax.swing.JTextArea();
        jScrollPane13 = new javax.swing.JScrollPane();
        axtMetodoInv = new javax.swing.JTextArea();
        lbl12 = new javax.swing.JLabel();
        lbl11 = new javax.swing.JLabel();
        btnDetallado = new javax.swing.JButton();
        btnAtras6 = new javax.swing.JButton();
        btnSiguiente6 = new javax.swing.JButton();
        pn7 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextArea10 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        scplan = new javax.swing.JScrollPane();
        tblPlan = new javax.swing.JTable();
        btnSiguiente7 = new javax.swing.JButton();
        btnAnterior7 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        txaReferencias = new javax.swing.JTextArea();
        lblBienvenida = new javax.swing.JLabel();
        lblBienvenida1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        lblFirma = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

        pn8.setBackground(new java.awt.Color(25, 118, 210));

        pn1.setBackground(new java.awt.Color(255, 255, 255));
        pn1.setBorder(javax.swing.BorderFactory.createTitledBorder("I. INFORMACIÓN GENERAL"));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        lblPrerrequistos.setText("Prerrequisitos:");

        axtPrerrequisitos.setEditable(false);
        axtPrerrequisitos.setBackground(new java.awt.Color(255, 255, 255));
        axtPrerrequisitos.setColumns(20);
        axtPrerrequisitos.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        axtPrerrequisitos.setRows(5);
        axtPrerrequisitos.setEnabled(false);
        jScrollPane2.setViewportView(axtPrerrequisitos);

        jLabel10.setText("Horas semanales:");

        txtHorasSemanales.setEditable(false);
        txtHorasSemanales.setBackground(new java.awt.Color(255, 255, 255));
        txtHorasSemanales.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtHorasSemanales.setEnabled(false);

        lblHorasTeoricas.setText("Teoricas:");

        lblHorasPracticas.setText("Practicas:");

        txtHorasTeoricas.setEditable(false);
        txtHorasTeoricas.setBackground(new java.awt.Color(255, 255, 255));
        txtHorasTeoricas.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtHorasTeoricas.setEnabled(false);

        txtHorasPracticas.setEditable(false);
        txtHorasPracticas.setBackground(new java.awt.Color(255, 255, 255));
        txtHorasPracticas.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtHorasPracticas.setEnabled(false);

        lblDuracion.setText("Duración: ");

        lblFechaInicio.setText("Fecha Inicio: ");

        lblFechaFinal.setText("Fecha Final:");

        jLabel16.setText("Docente: ");

        txtDocente.setEditable(false);
        txtDocente.setBackground(new java.awt.Color(255, 255, 255));
        txtDocente.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtDocente.setEnabled(false);

        jLabel17.setText("Grado: ");

        lblCorreo.setText("Correo:");

        txtCorreo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jdcFechaInicio.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jdcFechaInicio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcFechaInicioPropertyChange(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTextField1.setEnabled(false);

        txtGrado.setEditable(false);
        txtGrado.setBackground(new java.awt.Color(255, 255, 255));
        txtGrado.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtGrado.setEnabled(false);

        lblTipoCurso.setText("Tipo:");

        txtTipo.setEditable(false);
        txtTipo.setBackground(new java.awt.Color(255, 255, 255));
        txtTipo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtTipo.setEnabled(false);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        lblUniversidad.setText("Universidad: ");

        txtUniversidad.setEditable(false);
        txtUniversidad.setBackground(new java.awt.Color(255, 255, 255));
        txtUniversidad.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtUniversidad.setEnabled(false);
        txtUniversidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUniversidadActionPerformed(evt);
            }
        });

        lblDepartamento.setText("Departamento academico:");

        txtDepartamento.setEditable(false);
        txtDepartamento.setBackground(new java.awt.Color(255, 255, 255));
        txtDepartamento.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtDepartamento.setEnabled(false);

        lblEscuela.setText("Escuela:");

        txtEscuela.setEditable(false);
        txtEscuela.setBackground(new java.awt.Color(255, 255, 255));
        txtEscuela.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtEscuela.setEnabled(false);

        jLabel5.setText("Ciclo:");

        cmbCiclos.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        cmbCiclos.setModel(this.modeloCiclos);
        cmbCiclos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCiclosActionPerformed(evt);
            }
        });

        jLabel6.setText("Curso:");

        cmbCursos.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        cmbCursos.setModel(this.modeloCursos);
        cmbCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCursosActionPerformed(evt);
            }
        });

        lblFacultad.setText("Facultad: ");

        txtFacultad.setEditable(false);
        txtFacultad.setBackground(new java.awt.Color(255, 255, 255));
        txtFacultad.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtFacultad.setEnabled(false);
        txtFacultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFacultadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblUniversidad)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbCiclos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblDepartamento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDepartamento))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(lblFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(101, 101, 101)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUniversidad, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtFacultad)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(lblEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtEscuela))))
                        .addGap(16, 16, 16))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUniversidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUniversidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCiclos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        lblCodigoCurso.setText("Codigo del curso:");

        txtCodigoCurso.setEditable(false);
        txtCodigoCurso.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigoCurso.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtCodigoCurso.setEnabled(false);

        lblCreditos.setText("Creditos: ");

        txtCreditos.setEditable(false);
        txtCreditos.setBackground(new java.awt.Color(255, 255, 255));
        txtCreditos.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtCreditos.setEnabled(false);

        lblSemestreAcademico.setText("Semestre academico:");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(2025, 2025, null, 1));
        jSpinner1.setEditor(new javax.swing.JSpinner.NumberEditor(jSpinner1, "0"));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("-");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I", "II", "III" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblCodigoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtCodigoCurso)
                .addGap(18, 18, 18)
                .addComponent(lblSemestreAcademico)
                .addGap(18, 18, 18)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(lblCreditos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSemestreAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        bntSiguiente1.setText("Siguiente");
        bntSiguiente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSiguiente1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 98, Short.MAX_VALUE)
                .addComponent(bntSiguiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 31, Short.MAX_VALUE)
                .addComponent(bntSiguiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("semanas");

        spDuración.setModel(new javax.swing.SpinnerNumberModel(16, 16, 18, 1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel16))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(lblCorreo)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDocente)
                            .addComponent(txtCorreo))
                        .addGap(21, 21, 21)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblHorasTeoricas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(11, 11, 11)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtHorasTeoricas, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtHorasSemanales, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(63, 63, 63))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblHorasPracticas, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtHorasPracticas, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDuracion, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblFechaInicio, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblFechaFinal))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jdcFechaInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(lblTipoCurso)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(spDuración, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblPrerrequistos, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(jLabel1)
                    .addContainerGap(670, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPrerrequistos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTipoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHorasSemanales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHorasTeoricas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHorasTeoricas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHorasPracticas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHorasPracticas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(spDuración, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(lblFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jdcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jLabel1)
                    .addContainerGap(849, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pn1Layout = new javax.swing.GroupLayout(pn1);
        pn1.setLayout(pn1Layout);
        pn1Layout.setHorizontalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        pn1Layout.setVerticalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn8.addTab("Pagina 1", pn1);

        pn2.setBorder(javax.swing.BorderFactory.createTitledBorder("II. SUMILLA"));

        btnSiguiente2.setText("Siguiente");
        btnSiguiente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente2ActionPerformed(evt);
            }
        });

        btnAtras2.setText("Atras");
        btnAtras2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtras2ActionPerformed(evt);
            }
        });

        axtSumilla.setEditable(false);
        axtSumilla.setColumns(20);
        axtSumilla.setRows(5);
        jScrollPane19.setViewportView(axtSumilla);

        javax.swing.GroupLayout pn2Layout = new javax.swing.GroupLayout(pn2);
        pn2.setLayout(pn2Layout);
        pn2Layout.setHorizontalGroup(
            pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn2Layout.createSequentialGroup()
                        .addGap(0, 419, Short.MAX_VALUE)
                        .addComponent(btnAtras2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSiguiente2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane19))
                .addContainerGap())
        );
        pn2Layout.setVerticalGroup(
            pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguiente2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pn8.addTab("Pagina 2", pn2);

        btnSiguiente3.setText("Siguiente");
        btnSiguiente3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente3ActionPerformed(evt);
            }
        });

        bntAtras3.setText("Atras");
        bntAtras3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAtras3ActionPerformed(evt);
            }
        });

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("III. COMPETENCIA PROFESIONAL"));

        atxCompetenciaProfesional.setEditable(false);
        atxCompetenciaProfesional.setColumns(20);
        atxCompetenciaProfesional.setRows(5);
        jScrollPane4.setViewportView(atxCompetenciaProfesional);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("IV. CAPACIDAD DEL CURSO"));

        atxCapacidadCurso.setEditable(false);
        atxCapacidadCurso.setColumns(20);
        atxCapacidadCurso.setRows(5);
        jScrollPane6.setViewportView(atxCapacidadCurso);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("V. DESEMPEÑOS DE LAS UNIDADES DIDÁCTICAS"));

        axtDesempeños.setEditable(false);
        axtDesempeños.setColumns(20);
        axtDesempeños.setRows(5);
        jScrollPane7.setViewportView(axtDesempeños);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn3Layout = new javax.swing.GroupLayout(pn3);
        pn3.setLayout(pn3Layout);
        pn3Layout.setHorizontalGroup(
            pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn3Layout.createSequentialGroup()
                        .addComponent(bntAtras3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSiguiente3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn3Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pn3Layout.setVerticalGroup(
            pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(pn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguiente3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntAtras3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pn8.addTab("Pagina 3", pn3);

        pn4.setBorder(javax.swing.BorderFactory.createTitledBorder("VI. PROGRAMA DE CONTENIDOS."));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Unidades"));

        tblDesempeñosUnidades.setModel(this.modeloDesempeño);
        jScrollPane8.setViewportView(tblDesempeñosUnidades);

        btnEditarUnidades.setText("Editar");
        btnEditarUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUnidadesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditarUnidades)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btnEditarUnidades)
                .addContainerGap())
        );

        panUnidades.setEnabled(false);

        jscUnidad.setEnabled(false);

        tblUnidades.setModel(this.modeloUnidad);
        tblUnidades.setEnabled(false);
        jscUnidad.setViewportView(tblUnidades);

        lblUnidades.setText("Unidad:");
        lblUnidades.setEnabled(false);

        cmbUMostrarUnidades.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        cmbUMostrarUnidades.setModel(this.modeloComboUnidad);
        cmbUMostrarUnidades.setEnabled(false);
        cmbUMostrarUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUMostrarUnidadesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panUnidadesLayout = new javax.swing.GroupLayout(panUnidades);
        panUnidades.setLayout(panUnidadesLayout);
        panUnidadesLayout.setHorizontalGroup(
            panUnidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jscUnidad, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
            .addGroup(panUnidadesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(cmbUMostrarUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panUnidadesLayout.setVerticalGroup(
            panUnidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panUnidadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panUnidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbUMostrarUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnidades))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jscUnidad, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnAnterior4.setText("Anterior");
        btnAnterior4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnterior4ActionPerformed(evt);
            }
        });

        btnSiguiente4.setText("Siguiente");
        btnSiguiente4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente4ActionPerformed(evt);
            }
        });

        jLabel2.setText("ver los contenidos");

        btnMostrarUnidad.setText("Mostrar");
        btnMostrarUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarUnidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn4Layout = new javax.swing.GroupLayout(pn4);
        pn4.setLayout(pn4Layout);
        pn4Layout.setHorizontalGroup(
            pn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn4Layout.createSequentialGroup()
                        .addGroup(pn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panUnidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pn4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAnterior4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSiguiente4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9))
                    .addGroup(pn4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(btnMostrarUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pn4Layout.setVerticalGroup(
            pn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(pn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnMostrarUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(pn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguiente4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnterior4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pn8.addTab("Pagina 4", pn4);

        pn5.setBorder(javax.swing.BorderFactory.createTitledBorder("VIII. SISTEMA DE CALIFICACIÓN"));

        ADS.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblEvaluaciones.setModel(this.modelo);
        jScrollPane10.setViewportView(tblEvaluaciones);

        javax.swing.GroupLayout ADSLayout = new javax.swing.GroupLayout(ADS);
        ADS.setLayout(ADSLayout);
        ADSLayout.setHorizontalGroup(
            ADSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ADSLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10)
                .addContainerGap())
        );
        ADSLayout.setVerticalGroup(
            ADSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );

        txtPromedioFinal.setEditable(false);
        txtPromedioFinal.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jLabel20.setText("Promedio final =");

        btnSiguiente5.setText("Siguiente");
        btnSiguiente5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente5ActionPerformed(evt);
            }
        });

        btnAnterior5.setText("Anterior");
        btnAnterior5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnterior5ActionPerformed(evt);
            }
        });

        btnAgregarEvaluacion.setText("Agregar");
        btnAgregarEvaluacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEvaluacionActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnGenerarFormula.setText("Generar Formula");
        btnGenerarFormula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarFormulaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn5Layout = new javax.swing.GroupLayout(pn5);
        pn5.setLayout(pn5Layout);
        pn5Layout.setHorizontalGroup(
            pn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel20)
                .addGap(29, 29, 29)
                .addComponent(txtPromedioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGenerarFormula)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pn5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ADS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgregarEvaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAnterior5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSiguiente5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        pn5Layout.setVerticalGroup(
            pn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(ADS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarEvaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(pn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPromedioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(btnGenerarFormula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(203, 203, 203)
                .addGroup(pn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguiente5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnterior5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pn8.addTab("Pagina 5", pn5);

        pn6.setBorder(javax.swing.BorderFactory.createTitledBorder("IX. METODOLOGÍA DE ENSEÑANZA – APRENDIZAJE Y ACTIVIDADES DE INVESTIGACIÓN FORMATIVA"));

        txaMetodologiaEnseñanza.setColumns(20);
        txaMetodologiaEnseñanza.setRows(5);
        jScrollPane11.setViewportView(txaMetodologiaEnseñanza);

        panDetallado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panDetallado.setEnabled(false);

        axtMetopro.setColumns(20);
        axtMetopro.setRows(5);
        axtMetopro.setText("Metodología para el proceso formativo:\n\n");
        axtMetopro.setEnabled(false);
        jScrollPane12.setViewportView(axtMetopro);

        axtMetodoInv.setColumns(20);
        axtMetodoInv.setRows(5);
        axtMetodoInv.setText("Metodología para la investigación formativa:");
        axtMetodoInv.setEnabled(false);
        jScrollPane13.setViewportView(axtMetodoInv);

        lbl12.setText("Metodología para la investigación formativa");
        lbl12.setEnabled(false);

        lbl11.setText("Metodología para el proceso formativo");
        lbl11.setEnabled(false);

        javax.swing.GroupLayout panDetalladoLayout = new javax.swing.GroupLayout(panDetallado);
        panDetallado.setLayout(panDetalladoLayout);
        panDetalladoLayout.setHorizontalGroup(
            panDetalladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDetalladoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetalladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                    .addComponent(jScrollPane12)
                    .addGroup(panDetalladoLayout.createSequentialGroup()
                        .addGroup(panDetalladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl12)
                            .addComponent(lbl11))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panDetalladoLayout.setVerticalGroup(
            panDetalladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDetalladoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lbl11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lbl12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnDetallado.setText("Detallado");
        btnDetallado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalladoActionPerformed(evt);
            }
        });

        btnAtras6.setText("Atras");
        btnAtras6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtras6ActionPerformed(evt);
            }
        });

        btnSiguiente6.setText("Siguiente");
        btnSiguiente6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn6Layout = new javax.swing.GroupLayout(pn6);
        pn6.setLayout(pn6Layout);
        pn6Layout.setHorizontalGroup(
            pn6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pn6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDetallado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane11)
                    .addComponent(panDetallado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtras6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSiguiente6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn6Layout.setVerticalGroup(
            pn6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addGroup(pn6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn6Layout.createSequentialGroup()
                        .addComponent(btnDetallado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panDetallado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn6Layout.createSequentialGroup()
                        .addGroup(pn6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSiguiente6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtras6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        pn8.addTab("Pagina 6", pn6);

        pn7.setBorder(javax.swing.BorderFactory.createTitledBorder("X. ACTIVIDADES DE TUTORÍA: ÁREA ACADÉMICA"));

        jTextArea10.setColumns(20);
        jTextArea10.setRows(5);
        jScrollPane14.setViewportView(jTextArea10);

        jButton2.setText("PLAN DE DINAMIZACIÓN Y SEGUIMIENTO");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tblPlan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblPlan.setEnabled(false);
        scplan.setViewportView(tblPlan);

        btnSiguiente7.setText("Siguiente");
        btnSiguiente7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente7ActionPerformed(evt);
            }
        });

        btnAnterior7.setText("Anterior");
        btnAnterior7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnterior7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn7Layout = new javax.swing.GroupLayout(pn7);
        pn7.setLayout(pn7Layout);
        pn7Layout.setHorizontalGroup(
            pn7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pn7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAnterior7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSiguiente7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn7Layout.createSequentialGroup()
                        .addGroup(pn7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scplan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn7Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(5, 5, 5)))
                .addContainerGap())
        );
        pn7Layout.setVerticalGroup(
            pn7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addGroup(pn7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn7Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(scplan, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                        .addGap(88, 88, 88))
                    .addGroup(pn7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pn7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSiguiente7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAnterior7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        pn8.addTab("Pagina 7", pn7);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("XI. REFERENCIAS"));

        txaReferencias.setColumns(20);
        txaReferencias.setRows(5);
        jScrollPane17.setViewportView(txaReferencias);

        lblBienvenida.setBackground(new java.awt.Color(255, 255, 255));
        lblBienvenida.setText("{Lugar}, {mes} de {Año}");

        lblBienvenida1.setBackground(new java.awt.Color(255, 255, 255));
        lblBienvenida1.setText("{Grado}. {FullName}");

        jButton3.setText("Anterior");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Exportar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        lblFirma.setText(" ");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(lblBienvenida1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE))
                        .addGap(5, 5, 5)))
                .addContainerGap())
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(lblFirma)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBienvenida)
                .addGap(51, 51, 51)
                .addComponent(lblFirma)
                .addGap(50, 50, 50)
                .addComponent(lblBienvenida1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pn8.addTab("Pagina 8", jPanel13);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pn8, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(pn8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtras2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtras2ActionPerformed
        this.pn8.setSelectedIndex(0);
    }//GEN-LAST:event_btnAtras2ActionPerformed

    private void btnSiguiente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente2ActionPerformed
        this.pn8.setSelectedIndex(2);
    }//GEN-LAST:event_btnSiguiente2ActionPerformed

    private void bntSiguiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSiguiente1ActionPerformed
        this.pn8.setSelectedIndex(1);
    }//GEN-LAST:event_bntSiguiente1ActionPerformed

    private void btnSiguiente4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente4ActionPerformed
        this.pn8.setSelectedIndex(4);
    }//GEN-LAST:event_btnSiguiente4ActionPerformed

    private void btnAnterior4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnterior4ActionPerformed
        this.pn8.setSelectedIndex(2);
    }//GEN-LAST:event_btnAnterior4ActionPerformed

    private void btnSiguiente5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente5ActionPerformed
        this.pn8.setSelectedIndex(5);
    }//GEN-LAST:event_btnSiguiente5ActionPerformed

    private void btnSiguiente6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente6ActionPerformed
        this.pn8.setSelectedIndex(6);
    }//GEN-LAST:event_btnSiguiente6ActionPerformed

    private void btnSiguiente7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente7ActionPerformed
        this.pn8.setSelectedIndex(7);
    }//GEN-LAST:event_btnSiguiente7ActionPerformed

    private void btnAnterior5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnterior5ActionPerformed
        this.pn8.setSelectedIndex(3);
    }//GEN-LAST:event_btnAnterior5ActionPerformed

    private void btnAtras6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtras6ActionPerformed
        this.pn8.setSelectedIndex(4);
    }//GEN-LAST:event_btnAtras6ActionPerformed

    private void btnAnterior7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnterior7ActionPerformed
        this.pn8.setSelectedIndex(5);
    }//GEN-LAST:event_btnAnterior7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.pn8.setSelectedIndex(6);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cmbCiclosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCiclosActionPerformed
        int pos = this.cmbCiclos.getSelectedIndex();
        if (pos > -1) {
            this.cicloSeleccionado = this.ciclosVigentes.get(pos);
            cargarCusos();
        }
    }//GEN-LAST:event_cmbCiclosActionPerformed

    private void cmbCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCursosActionPerformed
        int pos = this.cmbCursos.getSelectedIndex();
        if (pos > -1) {
            this.cursoSeleccionado = this.cursosVigentes.get(pos);
            cargarDatosDeCurso();
        }
    }//GEN-LAST:event_cmbCursosActionPerformed

    private void jdcFechaInicioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcFechaInicioPropertyChange
        if ("date".equals(evt.getPropertyName()) && evt.getNewValue() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaInicio = (Date) evt.getNewValue();
            Calendar cal = Calendar.getInstance();
            cal.setTime(fechaInicio);
            this.FechaInicio = fechaInicio;
            cal.add(Calendar.WEEK_OF_YEAR, ((Integer) spDuración.getValue()) - 1);
            cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            Date fechaFinal = cal.getTime();
            this.FechaFin = fechaFinal;
            jTextField1.setText(sdf.format(fechaFinal));
        }

    }//GEN-LAST:event_jdcFechaInicioPropertyChange

    private void btnAgregarEvaluacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEvaluacionActionPerformed
        JDAgregarEvaluacion frmEval = new JDAgregarEvaluacion(null, true);
        frmEval.setVisible(true);
        EvaluacionesCalificadas eval = null;
        eval = frmEval.agregar();
        if (eval != null) {
            this.evaluaciones.add(eval);
        }
        this.listarEvaluaciones();
        frmEval.dispose();
        frmEval = null;
    }//GEN-LAST:event_btnAgregarEvaluacionActionPerformed

    private void btnMostrarUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarUnidadActionPerformed

        this.panUnidades.setEnabled(true);
        this.jscUnidad.setEnabled(true);
        this.lblUnidades.setEnabled(true);
        this.cmbUMostrarUnidades.setEnabled(true);
        this.tblUnidades.setEnabled(true);

        this.modeloComboUnidad.setUnidad(unidadesLis);
        this.cmbUMostrarUnidades.setModel(modeloComboUnidad);
        this.cmbUMostrarUnidades.setSelectedIndex(-1);
        configurarTablaUnidadMultilinea();

    }//GEN-LAST:event_btnMostrarUnidadActionPerformed

    private void cmbUMostrarUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUMostrarUnidadesActionPerformed
        cmbUMostrarUnidades.addActionListener(e -> {
            mostrarDatosDeUnidadSeleccionada();
            this.tblUnidades.setModel(modeloUnidad);
        });
    }//GEN-LAST:event_cmbUMostrarUnidadesActionPerformed

    private void txtFacultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFacultadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFacultadActionPerformed

    private void btnDetalladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalladoActionPerformed
        if (detallado == true) {
            this.panDetallado.setEnabled(true);
            this.lbl11.setEnabled(true);
            this.axtMetodoInv.setEnabled(true);
            this.lbl12.setEnabled(true);
            this.axtMetopro.setEnabled(true);
            this.detallado = false;
        } else {
            this.panDetallado.setEnabled(false);
            this.lbl11.setEnabled(false);
            this.axtMetodoInv.setEnabled(false);
            this.lbl12.setEnabled(false);
            this.axtMetopro.setEnabled(false);
            this.detallado = true;
        }
    }//GEN-LAST:event_btnDetalladoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (plan == true) {
            this.scplan.setEnabled(true);
            this.tblPlan.setEnabled(true);
            this.plan = false;
        } else {
            this.scplan.setEnabled(false);
            this.tblPlan.setEnabled(false);
            this.plan = true;
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        EvaluacionesCalificadas eval;
        int fila = this.tblEvaluaciones.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona una fila para modificar");
            return;
        }
        EvaluacionesCalificadas seleccionada = modelo.getCalificaciones().get(fila);

        JDAgregarEvaluacion dialogo = new JDAgregarEvaluacion(null, true);
        dialogo.cargarDatos(seleccionada);
        eval = dialogo.agregar();
        this.evaluaciones.set(fila, eval);
        this.listarEvaluaciones();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGenerarFormulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarFormulaActionPerformed
        if (this.validarSumaGlobalPesos(this.tblEvaluaciones) == true) {
            actualizarFormulaPromedio(this.tblEvaluaciones, this.txtPromedioFinal);
        } else {
            this.btnModificar.requestFocusInWindow();
        }
    }//GEN-LAST:event_btnGenerarFormulaActionPerformed

    private void txtUniversidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUniversidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUniversidadActionPerformed

    private void bntAtras3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAtras3ActionPerformed
        this.pn8.setSelectedIndex(1);
    }//GEN-LAST:event_bntAtras3ActionPerformed

    private void btnSiguiente3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente3ActionPerformed
        this.pn8.setSelectedIndex(3);
    }//GEN-LAST:event_btnSiguiente3ActionPerformed

    private void btnEditarUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUnidadesActionPerformed
        if (unidadesLis == null) {
            unidadesLis = new ArrayList<>();
        } else {
            unidadesLis.clear();
        }
        if (cursoSeleccionado != null && cursoSeleccionado.getDesempeños() != null) {
            for (Desempeño d : cursoSeleccionado.getDesempeños()) {
                Unidad u = d.getUnidad();
                u.setDesempeño(d.getDesempeño());
                if (u != null && u.getNombre() != null && !u.getNombre().trim().isEmpty()) {
                    unidadesLis.add(u);
                }
            }
        }

        JFUnidades frm = JFUnidades.mostrar(unidadesLis, (int) spDuración.getValue());
        this.unidadesLis = JFUnidades.devolverDatos();
    }//GEN-LAST:event_btnEditarUnidadesActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            escrbirSilabo();
        } catch (JAXBException ex) {
            Logger.getLogger(JICrearSilabo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JICrearSilabo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ADS;
    private javax.swing.JTextArea atxCapacidadCurso;
    private javax.swing.JTextArea atxCompetenciaProfesional;
    private javax.swing.JTextArea axtDesempeños;
    private javax.swing.JTextArea axtMetodoInv;
    private javax.swing.JTextArea axtMetopro;
    private javax.swing.JTextArea axtPrerrequisitos;
    private javax.swing.JTextArea axtSumilla;
    private javax.swing.JButton bntAtras3;
    private javax.swing.JButton bntSiguiente1;
    private javax.swing.JButton btnAgregarEvaluacion;
    private javax.swing.JButton btnAnterior4;
    private javax.swing.JButton btnAnterior5;
    private javax.swing.JButton btnAnterior7;
    private javax.swing.JButton btnAtras2;
    private javax.swing.JButton btnAtras6;
    private javax.swing.JButton btnDetallado;
    private javax.swing.JButton btnEditarUnidades;
    private javax.swing.JButton btnGenerarFormula;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostrarUnidad;
    private javax.swing.JButton btnSiguiente2;
    private javax.swing.JButton btnSiguiente3;
    private javax.swing.JButton btnSiguiente4;
    private javax.swing.JButton btnSiguiente5;
    private javax.swing.JButton btnSiguiente6;
    private javax.swing.JButton btnSiguiente7;
    private javax.swing.JComboBox<String> cmbCiclos;
    private javax.swing.JComboBox<String> cmbCursos;
    private javax.swing.JComboBox<String> cmbUMostrarUnidades;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextArea jTextArea10;
    private javax.swing.JTextField jTextField1;
    private com.toedter.calendar.JDateChooser jdcFechaInicio;
    private javax.swing.JScrollPane jscUnidad;
    private javax.swing.JLabel lbl11;
    private javax.swing.JLabel lbl12;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblBienvenida1;
    private javax.swing.JLabel lblCodigoCurso;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblCreditos;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JLabel lblEscuela;
    private javax.swing.JLabel lblFacultad;
    private javax.swing.JLabel lblFechaFinal;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblFirma;
    private javax.swing.JLabel lblHorasPracticas;
    private javax.swing.JLabel lblHorasTeoricas;
    private javax.swing.JLabel lblPrerrequistos;
    private javax.swing.JLabel lblSemestreAcademico;
    private javax.swing.JLabel lblTipoCurso;
    private javax.swing.JLabel lblUnidades;
    private javax.swing.JLabel lblUniversidad;
    private javax.swing.JPanel panDetallado;
    private javax.swing.JPanel panUnidades;
    private javax.swing.JPanel pn1;
    private javax.swing.JPanel pn2;
    private javax.swing.JPanel pn3;
    private javax.swing.JPanel pn4;
    private javax.swing.JPanel pn5;
    private javax.swing.JPanel pn6;
    private javax.swing.JPanel pn7;
    private javax.swing.JTabbedPane pn8;
    private javax.swing.JScrollPane scplan;
    private javax.swing.JSpinner spDuración;
    private javax.swing.JTable tblDesempeñosUnidades;
    private javax.swing.JTable tblEvaluaciones;
    private javax.swing.JTable tblPlan;
    private javax.swing.JTable tblUnidades;
    private javax.swing.JTextArea txaMetodologiaEnseñanza;
    private javax.swing.JTextArea txaReferencias;
    private javax.swing.JTextField txtCodigoCurso;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCreditos;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtDocente;
    private javax.swing.JTextField txtEscuela;
    private javax.swing.JTextField txtFacultad;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtHorasPracticas;
    private javax.swing.JTextField txtHorasSemanales;
    private javax.swing.JTextField txtHorasTeoricas;
    private javax.swing.JTextField txtPromedioFinal;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtUniversidad;
    // End of variables declaration//GEN-END:variables

    private void cargarCusos() {
        if (this.cicloSeleccionado != null) {
            this.cursosVigentes = new ArrayList<>();
            for (Curso curo : this.cicloSeleccionado.getCuros()) {
                if (curo.isVigente() == true) {
                    this.cursosVigentes.add(curo);
                }
            }
            this.modeloCursos.setCurso(this.cursosVigentes);
            this.cmbCursos.setSelectedIndex(-1);
        }
    }

    private void cargarDatosDeCurso() {
        if (this.cursoSeleccionado != null) {
            int horasTeoricas = this.cursoSeleccionado.getHorasTeoricaSemanales();
            int horasPracticas = this.cursoSeleccionado.getHorasTeoricaSemanales();
            this.txtCodigoCurso.setText(cursoSeleccionado.getCodigoCurso());
            this.txtCreditos.setText(String.valueOf(cursoSeleccionado.getCreditos()));
            this.txtHorasSemanales.setText(String.valueOf(horasTeoricas + horasPracticas));
            this.txtHorasTeoricas.setText(String.valueOf(horasTeoricas));
            this.txtHorasPracticas.setText(String.valueOf(horasTeoricas));
            this.txtCodigoCurso.setText(cursoSeleccionado.getCodigoCurso());
            this.axtPrerrequisitos.setText(this.cursoSeleccionado.getPrerrequisitos());
            this.txtTipo.setText(this.cursoSeleccionado.getTipo());
            this.axtSumilla.setLineWrap(true);
            this.axtSumilla.setWrapStyleWord(true);
            this.axtSumilla.setText(this.cursoSeleccionado.getSumilla());
            this.atxCompetenciaProfesional.setLineWrap(true);
            this.atxCompetenciaProfesional.setWrapStyleWord(true);
            this.atxCompetenciaProfesional.setText(this.cursoSeleccionado.getCompetenciaProfesional());
            this.atxCapacidadCurso.setLineWrap(true);
            this.atxCapacidadCurso.setWrapStyleWord(true);
            this.atxCapacidadCurso.setText(this.cursoSeleccionado.getCapacidadDelCurso());
            String desemp = "";
            int contador = 1;
            List<Desempeño> listaDesempeñosConUnidad = new ArrayList<>();
            for (Desempeño cur : cursoSeleccionado.getDesempeños()) {
                desemp += cur.getNombre() + ": " + cur.getDesempeño() + "\n";
                if (cur.getUnidad() == null) {
                    Unidad unidadDummy = new Unidad();
                    unidadDummy.setNombre("Unidad " + contador++);
                    cur.setUnidad(unidadDummy);
                }
                listaDesempeñosConUnidad.add(cur);
            }
            axtDesempeños.setLineWrap(true);
            axtDesempeños.setWrapStyleWord(true);
            axtDesempeños.setText(desemp);
            modeloDesempeño.setDesempeño(listaDesempeñosConUnidad);
        }

    }

    public void mostrarDatosDeUnidadSeleccionada() {

        int index = cmbUMostrarUnidades.getSelectedIndex();
        List<Unidad> unidadesDisponibles = modeloComboUnidad.getUnidad(); // ✅ asegúrate que este método existe

        if (index >= 0 && unidadesDisponibles != null && index < unidadesDisponibles.size()) {
            Unidad seleccionada = unidadesDisponibles.get(index);

            if (seleccionada != null && seleccionada.getHabilidadesRequeridas() != null && !seleccionada.getHabilidadesRequeridas().isEmpty()) {
                modeloUnidad.setUnidades(List.of(seleccionada));
                tblUnidades.setModel(modeloUnidad); // 🔑 vuelve a vincular el modelo
                return;
            }
        }

        modeloUnidad.setUnidades(new ArrayList<>());
        tblUnidades.setModel(modeloUnidad); // 🔁 importante aunque esté vacío
    }

    public boolean validarSumaGlobalPesos(JTable tabla) {
        String mensaje = "";
        TableModel modelo = this.tblEvaluaciones.getModel();
        double sumaPesos = 0;

        for (int i = 0; i < modelo.getRowCount(); i++) {
            Object pesoObj = modelo.getValueAt(i, 2); // Columna 2: Peso
            if (pesoObj != null) {
                sumaPesos += Double.parseDouble(pesoObj.toString());
            }
        }

        if (sumaPesos > 100) {
            mensaje += "La suma de los pesos es " + sumaPesos + "%. Debes modificarlos para que sumen exactamente 100%";
            JOptionPane.showMessageDialog(null, mensaje);
            return false;
        }
        return true;
    }

    public void actualizarFormulaPromedio(JTable tabla, JTextField campoFormula) {
        StringBuilder formula = new StringBuilder();
        TableModel modelo = this.tblEvaluaciones.getModel();

        for (int i = 0; i < modelo.getRowCount(); i++) {
            String sigla = modelo.getValueAt(i, 1).toString(); // Asumiendo columna 1 = Siglas
            String peso = modelo.getValueAt(i, 2).toString();  // Asumiendo columna 2 = Peso

            formula.append(peso)
                    .append("%*")
                    .append(sigla);

            if (i < modelo.getRowCount() - 1) {
                formula.append(" + ");
            }
        }

        campoFormula.setText(formula.toString());
    }

    private void configurarTablaDesempeñosMultilinea() {
        tblDesempeñosUnidades.setModel(modeloDesempeño);
        tblDesempeñosUnidades.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JTextArea area = new JTextArea(value != null ? value.toString() : "");
                area.setLineWrap(true);
                area.setWrapStyleWord(true);
                area.setEditable(false);
                area.setFont(table.getFont());
                area.setOpaque(true);
                if (isSelected) {
                    area.setBackground(table.getSelectionBackground());
                    area.setForeground(table.getSelectionForeground());
                } else {
                    area.setBackground(table.getBackground());
                    area.setForeground(table.getForeground());
                }
                return area;
            }
        });
        tblDesempeñosUnidades.setRowHeight(60);

    }

    private void configurarTablaUnidadMultilinea() {
        tblUnidades.setModel(modeloUnidad);
        tblUnidades.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JTextArea area = new JTextArea(value != null ? value.toString() : "");
                area.setLineWrap(true);
                area.setWrapStyleWord(true);
                area.setEditable(false);
                area.setFont(table.getFont());
                area.setOpaque(true);
                if (isSelected) {
                    area.setBackground(table.getSelectionBackground());
                    area.setForeground(table.getSelectionForeground());
                } else {
                    area.setBackground(table.getBackground());
                    area.setForeground(table.getForeground());
                }
                return area;
            }
        });
        tblUnidades.setRowHeight(60);

    }

    private void cargarDatosDocenteLoggeado() throws IOException {
        if (usuarioCreador == null) {
            System.out.println("❌ usuarioCreador no inicializado");
            lblFirma.setText("Usuario no disponible");
            return;
        }

        BufferedImage firma = usuarioCreador.getFirma();
        if (firma != null) {
            lblFirma.setIcon(new ImageIcon(firma));
            lblFirma.setText("");
        } else {
            lblFirma.setText("Sin firma disponible");
        }

        txtDocente.setText(usuarioCreador.getFullName());
        txtCorreo.setText(usuarioCreador.getCorreo());
        txtGrado.setText(usuarioCreador.getGrado());
    }

    private void listarEvaluaciones() {
        this.modelo.setCalificaciones(this.evaluaciones);
    }

    public void cargarDatosASilabo() {
        this.txtUniversidad.setText("Universidad Nacional Pedro Ruiz Gallo");
        this.txtFacultad.setText(this.facultad.getNombre());
        this.txtDepartamento.setText(this.departamento.getNombre());
        this.txtEscuela.setText(this.escuela.getNombre());

    }

    private void cargarCiclosDeSilabo() {
        this.ciclosVigentes = new ArrayList<>();
        for (Ciclo ciclo1 : this.escuela.getCiclo()) {
            if (ciclo1.isVigente() == true) {
                this.ciclosVigentes.add(ciclo1);
            }
        }
        this.modeloCiclos.setCiclo(ciclosVigentes);
        this.cmbCiclos.setSelectedIndex(-1);
    }

    public void escrbirSilabo() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Silabo.class);
        Marshaller marshaller = context.createMarshaller();
        Silabo silabo = new Silabo();
        silabo.setFacultad(facultad);
        silabo.setDepartamento(departamento);
        silabo.setEscuela(escuela);
        silabo.setDocente(usuarioCreador);
        silabo.setSemanas((String) spDuración.getValue());
        silabo.setFechaInicio(FechaInicio);
        silabo.setFechaFin(FechaFin);
        String mensaje = "";
        mensaje += txaMetodologiaEnseñanza.getText() + "\n";
        if (detallado == true) {
            mensaje += axtMetopro.getText() + "\n";
            mensaje += axtMetodoInv.getText();

        }
        silabo.setMetodologiaEnseñanza(mensaje);
        silabo.setFuentesReferenciales(txaReferencias.getText());

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(silabo, new FileWriter("SilaboGenadao.xml"));
        // justto esto se crea en file los archivos del programa

    }
}
