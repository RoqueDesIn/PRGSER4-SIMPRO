package GUI;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GUI {

	public JFrame frame;
	private JTextField tfQuantum;
	private JCheckBox chkFIFO;
	private JCheckBox chkSJF;
	private JCheckBox chkRST;
	private JCheckBox chkRR;
	private JTextField textFieldB1;
	private JTextField textFieldC1;
	private JTextField textFieldB2;
	private JTextField textFieldC2;
	private JTextField textFieldB3;
	private JTextField textFieldC3;
	private JTextField textFieldB4;
	private JTextField textFieldC4;
	private JTextArea taResultado;
	private JPanel panel_procesos;
	
	/**
	 * Launch the application.
	 */
	
	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	*/
	

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame padre
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 480, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		// panel título
		JPanel panel_titulo = new JPanel();
		frame.getContentPane().add(panel_titulo);
		panel_titulo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_titulo.setMaximumSize(new Dimension(500, 20));
		
		JLabel lblNewLabel = new JLabel("Simulador de procesos");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.BLUE);
		panel_titulo.add(lblNewLabel);
		
	
			// panel algoritmos
			JPanel panel_algoritmos = new JPanel();
			panel_algoritmos.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			panel_algoritmos.setMinimumSize(new Dimension(400,100));
			frame.getContentPane().add(panel_algoritmos);
					
				// panel chkbox
				JPanel panel_chkbox = new JPanel();
				panel_chkbox.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				panel_algoritmos.add(panel_chkbox);
				
				JLabel lblNewLabel_3 = new JLabel("Elija los procesos a implementar:");
				panel_chkbox.add(lblNewLabel_3);
				chkFIFO = new JCheckBox("FIFO");
				chkFIFO.setSelected(true);
				panel_chkbox.add(chkFIFO);
				chkSJF = new JCheckBox("SJF");
				chkSJF.setSelected(true);
				panel_chkbox.add(chkSJF);
				chkRST = new JCheckBox("SRT");
				chkRST.setSelected(true);
				panel_chkbox.add(chkRST);
				chkRR = new JCheckBox("RR");
				chkRR.setSelected(true);
				panel_chkbox.add(chkRR);
				
				// panel quantum
				JPanel panel_quantum = new JPanel();
				panel_algoritmos.add(panel_quantum);
			
				JLabel lblNewLabel_1 = new JLabel("Quantum:");
				panel_quantum.add(lblNewLabel_1);
		
				tfQuantum = new JTextField();
				tfQuantum.setText("2");
				tfQuantum.setToolTipText("Introduzca un n\u00FAmero entero");
				panel_quantum.add(tfQuantum);
				tfQuantum.setColumns(10);
				
				// panel procesos+txtarea
				JPanel panelproctxtarea = new JPanel();
				frame.getContentPane().add(panelproctxtarea);
				panelproctxtarea.setMinimumSize(new Dimension(500,300));
				panelproctxtarea.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				
				// panel procesos
				panel_procesos = new JPanel();
				panelproctxtarea.add(panel_procesos);
					GridBagLayout gbl_panel_procesos = new GridBagLayout();
					gbl_panel_procesos.columnWidths = new int[]{105, 0};
					gbl_panel_procesos.rowHeights = new int[]{10, 26, 26, 26, 26, 0};
					gbl_panel_procesos.columnWeights = new double[]{0.0, Double.MIN_VALUE};
					gbl_panel_procesos.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
					panel_procesos.setLayout(gbl_panel_procesos);
					
					//panel titulo tabla
					JPanel panelTTabla = new JPanel();
					FlowLayout flowLayout = (FlowLayout) panelTTabla.getLayout();
					flowLayout.setAlignment(FlowLayout.LEFT);
					panelTTabla.setMinimumSize(new Dimension(130,1));
					GridBagConstraints gbc_panelTTabla = new GridBagConstraints();
					gbc_panelTTabla.insets = new Insets(0, 0, 5, 0);
					gbc_panelTTabla.gridx = 0;
					gbc_panelTTabla.gridy = 0;
					panel_procesos.add(panelTTabla, gbc_panelTTabla);
					
					JLabel lblNewLabel_4 = new JLabel("ID");
					panelTTabla.add(lblNewLabel_4);
					lblNewLabel_4.setEnabled(false);
					JLabel lblNewLabel_2 = new JLabel("Llegada");
					panelTTabla.add(lblNewLabel_2);
					JLabel lblNewLabel_5 = new JLabel("Ráfaga");
					panelTTabla.add(lblNewLabel_5);
					panelTTabla.setMaximumSize(new Dimension(120,10));
					
					//panel fila1 tabla
					JPanel panelF1Tabla = new JPanel();
					FlowLayout flowLayout_1 = (FlowLayout) panelF1Tabla.getLayout();
					flowLayout_1.setAlignment(FlowLayout.LEFT);
					panelF1Tabla.setMaximumSize(new Dimension(130,26));
					GridBagConstraints gbc_panelF1Tabla = new GridBagConstraints();
					gbc_panelF1Tabla.insets = new Insets(0, 0, 5, 0);
					gbc_panelF1Tabla.gridx = 0;
					gbc_panelF1Tabla.gridy = 1;
					panel_procesos.add(panelF1Tabla, gbc_panelF1Tabla);
					
					JLabel lblNewLabelFA1 = new JLabel(" 0");
					panelF1Tabla.add(lblNewLabelFA1);
					
					textFieldB1 = new JTextField();
					textFieldB1.setColumns(4);
					textFieldB1.setText("2");
					panelF1Tabla.add(textFieldB1);
					textFieldB1.setColumns(4);
					panelF1Tabla.add(textFieldB1);
					
					textFieldC1 = new JTextField();
					textFieldC1.setText("12");
					textFieldC1.setColumns(4);
					panelF1Tabla.add(textFieldC1);
					
					//panel fila2
					JPanel panelF2Tabla = new JPanel();
					FlowLayout flowLayout_2 = (FlowLayout) panelF2Tabla.getLayout();
					flowLayout_2.setAlignment(FlowLayout.LEFT);
					panelF2Tabla.setMaximumSize(new Dimension(130,26));
					GridBagConstraints gbc_panelF2Tabla = new GridBagConstraints();
					gbc_panelF2Tabla.insets = new Insets(0, 0, 5, 0);
					gbc_panelF2Tabla.gridx = 0;
					gbc_panelF2Tabla.gridy = 2;
					panel_procesos.add(panelF2Tabla, gbc_panelF2Tabla);
					
					JLabel lblNewLabelFA2 = new JLabel(" 1");
					panelF2Tabla.add(lblNewLabelFA2);
					
					textFieldB2 = new JTextField();
					panelF2Tabla.add(textFieldB2);
					textFieldB2.setText("4");
					textFieldB2.setColumns(4);
					
					textFieldC2 = new JTextField();
					panelF2Tabla.add(textFieldC2);
					textFieldC2.setText("2");
					textFieldC2.setColumns(4);
					
					//panel fila3
					JPanel panelF3Tabla = new JPanel();
					FlowLayout flowLayoutF3 = (FlowLayout) panelF3Tabla.getLayout();
					flowLayoutF3.setAlignment(FlowLayout.LEFT);
					panelF3Tabla.setMaximumSize(new Dimension(130,26));
					GridBagConstraints gbc_panelF3Tabla = new GridBagConstraints();
					gbc_panelF3Tabla.insets = new Insets(0, 0, 5, 0);
					gbc_panelF3Tabla.gridx = 0;
					gbc_panelF3Tabla.gridy = 3;
					panel_procesos.add(panelF3Tabla, gbc_panelF3Tabla);
					
					JLabel lblNewLabelFA3 = new JLabel(" 2");
					panelF3Tabla.add(lblNewLabelFA3);
					
					textFieldB3 = new JTextField();
					panelF3Tabla.add(textFieldB3);
					textFieldB3.setText("0");
					textFieldB3.setColumns(4);
					
					textFieldC3 = new JTextField();
					panelF3Tabla.add(textFieldC3);
					textFieldC3.setText("9");
					textFieldC3.setColumns(4);
					
					//Panel fila 4
					JPanel panelF4Tabla = new JPanel();
					FlowLayout flowLayoutF4 = (FlowLayout) panelF4Tabla.getLayout();
					flowLayoutF4.setAlignment(FlowLayout.LEFT);
					panelF4Tabla.setMaximumSize(new Dimension(130,26));
					GridBagConstraints gbc_panelF4Tabla = new GridBagConstraints();
					gbc_panelF4Tabla.gridx = 0;
					gbc_panelF4Tabla.gridy = 4;
					panel_procesos.add(panelF4Tabla, gbc_panelF4Tabla);
					
					JLabel lblNewLabelFA4 = new JLabel(" 3");
					panelF4Tabla.add(lblNewLabelFA4);
					
					textFieldB4 = new JTextField();
					panelF4Tabla.add(textFieldB4);
					textFieldB4.setText("6");
					textFieldB4.setColumns(4);
					
					textFieldC4 = new JTextField();
					panelF4Tabla.add(textFieldC4);
					textFieldC4.setText("15");
					textFieldC4.setColumns(4);
			
		
					// panel scrolable
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
					panelproctxtarea.add(scrollPane);
					
					taResultado = new JTextArea();
					taResultado.setEditable(false);
					taResultado.setText("                                                               \r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
					scrollPane.setViewportView(taResultado);

			
			// panel botonera
			JPanel botonera = new JPanel();
			frame.getContentPane().add(botonera);
			
			JButton btnNewButton = new JButton("Iniciar");
			btnNewButton.addActionListener(new MiMouseListener());
			botonera.add(btnNewButton);

	}
	/**
	 * GETTERS
	 */

	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTfQuantum() {
		return tfQuantum;
	}

	public JCheckBox getChkFIFO() {
		return chkFIFO;
	}

	public JCheckBox getChkSJF() {
		return chkSJF;
	}

	public JCheckBox getChkRST() {
		return chkRST;
	}

	public JCheckBox getChkRR() {
		return chkRR;
	}

	public JTextField getTextFieldB1() {
		return textFieldB1;
	}

	public JTextField getTextFieldC1() {
		return textFieldC1;
	}

	public JTextField getTextFieldB2() {
		return textFieldB2;
	}

	public JTextField getTextFieldC2() {
		return textFieldC2;
	}

	public JTextField getTextFieldB3() {
		return textFieldB3;
	}

	public JTextField getTextFieldC3() {
		return textFieldC3;
	}
	public JTextField getTextFieldB4() {
		return textFieldB4;
	}

	public JTextField getTextFieldC4() {
		return textFieldC4;
	}

	public JTextArea getTaResultado() {
		return taResultado;
	}

	public JPanel getPanel_procesos() {
		return panel_procesos;
	}

}

