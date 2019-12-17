package Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import StudentInstructions.StudentsDAL;
import Students.Students;

public class OperationFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7775442870170565538L;
	public static JTextField alinanOgrenciID;
	public static JTextField alinanIsim;
	public static JTextField alinanBitirmeNotu;
	public static JTextField alinanSoyisim;
	public static JTextField alinanAramaText;
	public static JTable ogrenciTablosu;
	public static DefaultTableModel model;
	public static Students seciliOgrenci;

	StudentsDAL islemler = new StudentsDAL();
	public static JLabel altYaziText = new JLabel();

	final static String GIRDISIZ_TEXT_ALANI = "";
	public static final String VARS_KELIME = "Girilmemiþ";

	/**
	 * Creates new form StudentsEkrani1
	 */
	public OperationFrame() {

		initComponents();
		model = (DefaultTableModel) ogrenciTablosu.getModel();
		ogrenciGoruntule();
	}

	/**
	 * Create the dialog.
	 * 
	 * @return
	 */
	public void initComponents() {

		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			};
		});

		setBounds(100, 100, 1100, 726);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel aramaCubuguPaneli = new JPanel();
		aramaCubuguPaneli.setMinimumSize(new Dimension(0, 0));
		getContentPane().add(aramaCubuguPaneli, BorderLayout.NORTH);
		GridBagLayout gbl_aramaCubuguPaneli = new GridBagLayout();
		gbl_aramaCubuguPaneli.columnWidths = new int[] { 573 };
		gbl_aramaCubuguPaneli.rowHeights = new int[] { 65 };
		gbl_aramaCubuguPaneli.columnWeights = new double[] { 1.0 };
		gbl_aramaCubuguPaneli.rowWeights = new double[] { 0.0 };
		aramaCubuguPaneli.setLayout(gbl_aramaCubuguPaneli);

		alinanAramaText = new JTextField();
		alinanAramaText.setPreferredSize(new Dimension(6, 55));
		alinanAramaText.setBackground(SystemColor.text);
		alinanAramaText.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Arama Yapmak \u0130stedi\u011Finiz Veriyi Giriniz...", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(153, 180, 209)));
		GridBagConstraints gbc_alinanAramaText = new GridBagConstraints();
		gbc_alinanAramaText.insets = new Insets(15, 25, 10, 25);
		gbc_alinanAramaText.fill = GridBagConstraints.BOTH;
		gbc_alinanAramaText.gridx = 0;
		gbc_alinanAramaText.gridy = 0;
		aramaCubuguPaneli.add(alinanAramaText, gbc_alinanAramaText);

		JPanel mesajYazanPaneli = new JPanel();
		getContentPane().add(mesajYazanPaneli, BorderLayout.SOUTH);
		GridBagLayout gbl_mesajYazanPaneli = new GridBagLayout();
		gbl_mesajYazanPaneli.columnWidths = new int[] { 692 };
		gbl_mesajYazanPaneli.rowHeights = new int[] { 28 };
		gbl_mesajYazanPaneli.columnWeights = new double[] { 0.0 };
		gbl_mesajYazanPaneli.rowWeights = new double[] { 0.0 };
		mesajYazanPaneli.setLayout(gbl_mesajYazanPaneli);

		altYaziText = new JLabel(
				"Merhaba... Kullan\u0131c\u0131 giri\u015Finiz ba\u015Far\u0131l\u0131 olmu\u015Ftur sizin i\u00E7in \u00F6\u011Frencilerinizi s\u0131raya dizdik... :)");
		altYaziText.setForeground(SystemColor.textHighlight);
		altYaziText.setFont(new Font("Georgia", Font.ITALIC, 14));
		GridBagConstraints gbc_altYaziText = new GridBagConstraints();
		gbc_altYaziText.insets = new Insets(10, 28, 10, 28);
		gbc_altYaziText.anchor = GridBagConstraints.NORTH;
		gbc_altYaziText.fill = GridBagConstraints.BOTH;
		gbc_altYaziText.gridx = 0;
		gbc_altYaziText.gridy = 0;
		mesajYazanPaneli.add(altYaziText, gbc_altYaziText);

		JPanel islemlerPaneli = new JPanel();
		islemlerPaneli.setMinimumSize(new Dimension(0, 0));
		islemlerPaneli.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		islemlerPaneli.setAutoscrolls(true);
		getContentPane().add(islemlerPaneli, BorderLayout.WEST);
		GridBagLayout gbl_islemlerPaneli = new GridBagLayout();
		gbl_islemlerPaneli.columnWidths = new int[] { 240 };
		gbl_islemlerPaneli.rowHeights = new int[] { 25, 35, 35, 35, 35, 33, 35, 35, 30, 30, 35, 35, 35, 50 };
		gbl_islemlerPaneli.columnWeights = new double[] { 0.0 };
		gbl_islemlerPaneli.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0 };
		islemlerPaneli.setLayout(gbl_islemlerPaneli);

		JLabel ogrenciIDText = new JLabel("New label");
		ogrenciIDText.setAlignmentX(Component.CENTER_ALIGNMENT);
		ogrenciIDText.setFont(new Font("Georgia", Font.ITALIC, 15));
		GridBagConstraints gbc_ogrenciIDText = new GridBagConstraints();
		gbc_ogrenciIDText.anchor = GridBagConstraints.SOUTHWEST;
		gbc_ogrenciIDText.insets = new Insets(0, 25, 5, 5);
		gbc_ogrenciIDText.gridx = 0;
		gbc_ogrenciIDText.gridy = 0;
		islemlerPaneli.add(ogrenciIDText, gbc_ogrenciIDText);

		alinanOgrenciID = new JTextField();
		alinanOgrenciID.setPreferredSize(new Dimension(6, 25));
		alinanOgrenciID.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 15));
		alinanOgrenciID.setForeground(Color.BLUE);
		alinanOgrenciID.setBackground(SystemColor.inactiveCaptionBorder);
		alinanOgrenciID.setBorder(new LineBorder(SystemColor.activeCaption));
		alinanOgrenciID.setEditable(false);
		GridBagConstraints gbc_alinanOgrenciID = new GridBagConstraints();
		gbc_alinanOgrenciID.insets = new Insets(0, 25, 5, 5);
		gbc_alinanOgrenciID.fill = GridBagConstraints.BOTH;
		gbc_alinanOgrenciID.gridx = 0;
		gbc_alinanOgrenciID.gridy = 1;
		islemlerPaneli.add(alinanOgrenciID, gbc_alinanOgrenciID);
		alinanOgrenciID.setColumns(10);

		JLabel isimText = new JLabel("New label");
		isimText.setAlignmentX(Component.CENTER_ALIGNMENT);
		isimText.setFont(new Font("Georgia", Font.ITALIC, 15));
		GridBagConstraints gbc_isimText = new GridBagConstraints();
		gbc_isimText.anchor = GridBagConstraints.SOUTHWEST;
		gbc_isimText.insets = new Insets(0, 25, 5, 5);
		gbc_isimText.gridx = 0;
		gbc_isimText.gridy = 2;
		islemlerPaneli.add(isimText, gbc_isimText);

		alinanIsim = new JTextField();
		alinanIsim.setPreferredSize(new Dimension(6, 25));
		alinanIsim.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 15));
		GridBagConstraints gbc_alinanIsim = new GridBagConstraints();
		gbc_alinanIsim.insets = new Insets(0, 25, 5, 5);
		gbc_alinanIsim.fill = GridBagConstraints.BOTH;
		gbc_alinanIsim.gridx = 0;
		gbc_alinanIsim.gridy = 3;
		islemlerPaneli.add(alinanIsim, gbc_alinanIsim);
		alinanIsim.setColumns(10);

		JLabel soyisimText = new JLabel("New label");
		soyisimText.setAlignmentX(Component.CENTER_ALIGNMENT);
		soyisimText.setFont(new Font("Georgia", Font.ITALIC, 15));
		GridBagConstraints gbc_soyisimText = new GridBagConstraints();
		gbc_soyisimText.anchor = GridBagConstraints.SOUTHWEST;
		gbc_soyisimText.insets = new Insets(0, 25, 5, 5);
		gbc_soyisimText.gridx = 0;
		gbc_soyisimText.gridy = 4;
		islemlerPaneli.add(soyisimText, gbc_soyisimText);

		alinanSoyisim = new JTextField();
		alinanSoyisim.setPreferredSize(new Dimension(6, 25));
		alinanSoyisim.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 15));
		GridBagConstraints gbc_alinanSoyisim = new GridBagConstraints();
		gbc_alinanSoyisim.insets = new Insets(0, 25, 5, 5);
		gbc_alinanSoyisim.fill = GridBagConstraints.BOTH;
		gbc_alinanSoyisim.gridx = 0;
		gbc_alinanSoyisim.gridy = 5;
		islemlerPaneli.add(alinanSoyisim, gbc_alinanSoyisim);
		alinanSoyisim.setColumns(10);

		JLabel bitirmeNotuText = new JLabel("New label");
		bitirmeNotuText.setAlignmentX(Component.CENTER_ALIGNMENT);
		bitirmeNotuText.setFont(new Font("Georgia", Font.ITALIC, 15));
		GridBagConstraints gbc_bitirmeNotuText = new GridBagConstraints();
		gbc_bitirmeNotuText.anchor = GridBagConstraints.SOUTHWEST;
		gbc_bitirmeNotuText.insets = new Insets(0, 25, 5, 5);
		gbc_bitirmeNotuText.gridx = 0;
		gbc_bitirmeNotuText.gridy = 6;
		islemlerPaneli.add(bitirmeNotuText, gbc_bitirmeNotuText);

		alinanBitirmeNotu = new JTextField();
		alinanBitirmeNotu.setPreferredSize(new Dimension(6, 25));
		alinanBitirmeNotu.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 15));
		GridBagConstraints gbc_alinanBitirmeNotu = new GridBagConstraints();
		gbc_alinanBitirmeNotu.insets = new Insets(0, 25, 5, 5);
		gbc_alinanBitirmeNotu.fill = GridBagConstraints.BOTH;
		gbc_alinanBitirmeNotu.gridx = 0;
		gbc_alinanBitirmeNotu.gridy = 7;
		islemlerPaneli.add(alinanBitirmeNotu, gbc_alinanBitirmeNotu);
		alinanBitirmeNotu.setColumns(10);

		JButton bitirmeNotuHesaplaButonu = new JButton("Not Hesapla");

		bitirmeNotuHesaplaButonu.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				int selectedrow = ogrenciTablosu.getSelectedRow();
				if (selectedrow == -1) {

					if (model.getRowCount() == 0) {
						altYaziText.setText("Öðrenciler Tablosu þu anda boþ. ");
					} else {
						altYaziText.setText("Lütfen güncellenecek bir öðrenci seçin.");
					}
				} else {
					String isim = (model.getValueAt(selectedrow, 1).toString());
					String soyIsim = (model.getValueAt(selectedrow, 2).toString());
					String ogrenciID = (model.getValueAt(selectedrow, 0).toString());
					String bitirmeNotu = (model.getValueAt(selectedrow, 3).toString());
					String yazili01Notu = (model.getValueAt(selectedrow, 4).toString());
					String yazili02Notu = (model.getValueAt(selectedrow, 5).toString());
					String yazili03Notu = (model.getValueAt(selectedrow, 6).toString());
					String sozlu01Notu = (model.getValueAt(selectedrow, 7).toString());
					String sozlu02Notu = (model.getValueAt(selectedrow, 8).toString());

					seciliOgrenci = new Students(ogrenciID, isim, soyIsim, bitirmeNotu, yazili01Notu, yazili02Notu,
							yazili03Notu, sozlu01Notu, sozlu02Notu);

					setVisible(false);
					CalculationFrame notHesaplamaEkrani = new CalculationFrame(seciliOgrenci);
					notHesaplamaEkrani.setVisible(true);
				}

			}
		});

		bitirmeNotuHesaplaButonu.setAlignmentX(Component.CENTER_ALIGNMENT);
		bitirmeNotuHesaplaButonu.setFont(new Font("Georgia", Font.ITALIC, 20));
		bitirmeNotuHesaplaButonu.setPreferredSize(new Dimension(97, 40));
		bitirmeNotuHesaplaButonu.setBackground(SystemColor.activeCaption);
		bitirmeNotuHesaplaButonu.setBorder(
				new EtchedBorder(EtchedBorder.RAISED, SystemColor.activeCaption, SystemColor.inactiveCaption));
		GridBagConstraints gbc_bitirmeNotuHesaplaButonu = new GridBagConstraints();
		gbc_bitirmeNotuHesaplaButonu.fill = GridBagConstraints.HORIZONTAL;
		gbc_bitirmeNotuHesaplaButonu.insets = new Insets(0, 25, 5, 5);
		gbc_bitirmeNotuHesaplaButonu.gridx = 0;
		gbc_bitirmeNotuHesaplaButonu.gridy = 12;
		islemlerPaneli.add(bitirmeNotuHesaplaButonu, gbc_bitirmeNotuHesaplaButonu);

		JButton ogrenciEkleButonu = new JButton("Yeni \u00D6\u011Frenci Ekle");

		ogrenciEkleButonu.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				ogrenciekleActionPerformed(evt);
			}
		});

		ogrenciEkleButonu.setAlignmentX(Component.CENTER_ALIGNMENT);
		ogrenciEkleButonu.setFont(new Font("Georgia", Font.ITALIC, 20));
		ogrenciEkleButonu.setPreferredSize(new Dimension(97, 40));
		ogrenciEkleButonu.setBackground(SystemColor.activeCaption);
		ogrenciEkleButonu.setBorder(
				new EtchedBorder(EtchedBorder.RAISED, SystemColor.activeCaption, SystemColor.inactiveCaption));
		GridBagConstraints gbc_ogrenciEkleButonu = new GridBagConstraints();
		gbc_ogrenciEkleButonu.fill = GridBagConstraints.HORIZONTAL;
		gbc_ogrenciEkleButonu.insets = new Insets(0, 25, 5, 5);
		gbc_ogrenciEkleButonu.gridx = 0;
		gbc_ogrenciEkleButonu.gridy = 9;
		islemlerPaneli.add(ogrenciEkleButonu, gbc_ogrenciEkleButonu);

		JButton ogrenciGuncelleButonu = new JButton("\u00D6\u011Frenciyi G\u00FCncelle");
		ogrenciGuncelleButonu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ogrenciGuncelleButonu.setAlignmentX(Component.CENTER_ALIGNMENT);

		ogrenciGuncelleButonu.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				guncelleActionPerformed(evt);
			}
		});

		ogrenciGuncelleButonu.setFont(new Font("Georgia", Font.ITALIC, 20));
		ogrenciGuncelleButonu.setPreferredSize(new Dimension(97, 40));
		ogrenciGuncelleButonu.setBackground(SystemColor.activeCaption);
		ogrenciGuncelleButonu.setBorder(
				new EtchedBorder(EtchedBorder.RAISED, SystemColor.activeCaption, SystemColor.inactiveCaption));
		GridBagConstraints gbc_ogrenciGuncelleButonu = new GridBagConstraints();
		gbc_ogrenciGuncelleButonu.fill = GridBagConstraints.HORIZONTAL;
		gbc_ogrenciGuncelleButonu.insets = new Insets(0, 25, 5, 5);
		gbc_ogrenciGuncelleButonu.gridx = 0;
		gbc_ogrenciGuncelleButonu.gridy = 10;
		islemlerPaneli.add(ogrenciGuncelleButonu, gbc_ogrenciGuncelleButonu);

		JButton ogrenciSilButonu = new JButton("\u00D6\u011Frenciyi Sil");

		ogrenciSilButonu.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				silActionPerformed(evt);
			}
		});

		ogrenciSilButonu.setAlignmentX(Component.CENTER_ALIGNMENT);
		ogrenciSilButonu.setFont(new Font("Georgia", Font.ITALIC, 20));
		ogrenciSilButonu.setPreferredSize(new Dimension(97, 40));
		ogrenciSilButonu.setBackground(SystemColor.activeCaption);
		ogrenciSilButonu.setBorder(
				new EtchedBorder(EtchedBorder.RAISED, SystemColor.activeCaption, SystemColor.inactiveCaption));
		GridBagConstraints gbc_ogrenciSilButonu = new GridBagConstraints();
		gbc_ogrenciSilButonu.fill = GridBagConstraints.HORIZONTAL;
		gbc_ogrenciSilButonu.insets = new Insets(0, 25, 5, 5);
		gbc_ogrenciSilButonu.gridx = 0;
		gbc_ogrenciSilButonu.gridy = 11;
		islemlerPaneli.add(ogrenciSilButonu, gbc_ogrenciSilButonu);

		JPanel tabloPaneli = new JPanel();
		tabloPaneli.setAutoscrolls(true);
		getContentPane().add(tabloPaneli, BorderLayout.CENTER);
		GridBagLayout gbl_tabloPaneli = new GridBagLayout();
		gbl_tabloPaneli.columnWidths = new int[] { 442 };
		gbl_tabloPaneli.rowHeights = new int[] { 542 };
		gbl_tabloPaneli.columnWeights = new double[] { 1.0 };
		gbl_tabloPaneli.rowWeights = new double[] { 0.0 };
		tabloPaneli.setLayout(gbl_tabloPaneli);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setAutoscrolls(true);
		scrollPane.setPreferredSize(new Dimension(0, 0));
		scrollPane.setMinimumSize(new Dimension(0, 0));
		scrollPane.setBackground(SystemColor.activeCaption);
		scrollPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"G\u00FCncel \u00D6\u011Frenci Listesi... ", TitledBorder.LEADING, TitledBorder.TOP, null,
				Color.WHITE));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 18, 0, 25);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		tabloPaneli.add(scrollPane, gbc_scrollPane);

		ogrenciTablosu = new JTable();
		ogrenciTablosu.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		ogrenciTablosu.setIgnoreRepaint(true);
		ogrenciTablosu.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		ogrenciTablosu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ogrenciTablosu.setPreferredScrollableViewportSize(new Dimension(0, 0));
		ogrenciTablosu.setFocusTraversalPolicyProvider(true);
		ogrenciTablosu.setFocusCycleRoot(true);
		ogrenciTablosu.setAutoCreateRowSorter(true);
		ogrenciTablosu.setColumnSelectionAllowed(true);
		ogrenciTablosu.setCellSelectionEnabled(true);
		ogrenciTablosu.setRowHeight(26);
		ogrenciTablosu.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { StudentInstructions.StudentColumns.OGRENCI_ID.toString(),
						StudentInstructions.StudentColumns.ISIM.toString(),
						StudentInstructions.StudentColumns.SOYISIM.toString(),
						StudentInstructions.StudentColumns.BITIRME_NOT.toString(),
						StudentInstructions.StudentColumns.YAZILI_01.toString(),
						StudentInstructions.StudentColumns.YAZILI_02.toString(),
						StudentInstructions.StudentColumns.YAZILI_03.toString(),
						StudentInstructions.StudentColumns.SOZLU_01.toString(),
						StudentInstructions.StudentColumns.SOZLU_02.toString() }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 775369578204568095L;
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		ogrenciTablosu.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				ogrenciTablosuMouseClicked(evt);
			}
		});

		scrollPane.setViewportView(ogrenciTablosu);
		if (ogrenciTablosu.getColumnModel().getColumnCount() > 0) {
			ogrenciTablosu.getColumnModel().getColumn(0).setResizable(true);
			ogrenciTablosu.getColumnModel().getColumn(1).setResizable(true);
			ogrenciTablosu.getColumnModel().getColumn(2).setResizable(true);
			ogrenciTablosu.getColumnModel().getColumn(3).setResizable(true);
			ogrenciTablosu.getColumnModel().getColumn(4).setResizable(true);
			ogrenciTablosu.getColumnModel().getColumn(5).setResizable(true);
			ogrenciTablosu.getColumnModel().getColumn(6).setResizable(true);
			ogrenciTablosu.getColumnModel().getColumn(7).setResizable(true);
			ogrenciTablosu.getColumnModel().getColumn(8).setResizable(true);
		}

		alinanAramaText.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyReleased(java.awt.event.KeyEvent evt) {
				aramaYapAlaniKeyReleased(evt);
			}
		});

		alinanOgrenciID.setText(GIRDISIZ_TEXT_ALANI);
		alinanIsim.setText(GIRDISIZ_TEXT_ALANI);
		alinanSoyisim.setText(GIRDISIZ_TEXT_ALANI);
		alinanBitirmeNotu.setText(GIRDISIZ_TEXT_ALANI);

		isimText.setText("Ad:");

		soyisimText.setText("Soyad:");

		ogrenciIDText.setText("Ögrenci ID:");

		bitirmeNotuText.setText("Bitirme Notu:");

		ogrenciTablosu.setFillsViewportHeight(true);
		scrollPane.setViewportView(ogrenciTablosu);

	}

	public void dinamikAra(String ara) {

		/*
		 * The previous example assumes you have not enabled filtering.If you have
		 * enabled filtering convertRowIndexToView will return-1 for locations that are
		 * not visible in the view.
		 */

		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);

		ogrenciTablosu.setRowSorter(tr);

		tr.setRowFilter(RowFilter.regexFilter(ara));

	}

	private void aramaYapAlaniKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_aramaYapAlaniKeyReleased
		String ara = alinanAramaText.getText();

		dinamikAra(ara);

	}// GEN-LAST:event_aramaYapAlaniKeyReleased

	private void ogrenciekleActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ogrenciekleActionPerformed

		setVisible(false);
		StudentInsertionFrame yeniOgrenciEkrani = new StudentInsertionFrame();
		yeniOgrenciEkrani.setLocationRelativeTo(null);
		yeniOgrenciEkrani.setVisible(true);

		ogrenciGoruntule();

	}// GEN-LAST:event_ogrenciekleActionPerformed

	private void ogrenciTablosuMouseClicked(java.awt.event.MouseEvent evt) {

		int selectedrow = ogrenciTablosu.getSelectedRow();
		if (selectedrow == -1) {

			if (model.getRowCount() == 0) {
				altYaziText.setText("Öðrenciler Tablosu þu anda boþ. ");
			} else {
				altYaziText.setText("Lütfen güncellenecek bir öðrenci seçin.");
			}
		} else {
			alinanIsim.setText(model.getValueAt(selectedrow, 1).toString());
			alinanSoyisim.setText(model.getValueAt(selectedrow, 2).toString());
			alinanOgrenciID.setText(model.getValueAt(selectedrow, 0).toString());
			alinanBitirmeNotu.setText(model.getValueAt(selectedrow, 3).toString());

		}
	}// GEN-LAST:event_ogrenciTablosuMouseClicked

	private void guncelleActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_guncelleActionPerformed

		int selectedrow = ogrenciTablosu.getSelectedRow();

		if (selectedrow == -1) {

			if (model.getRowCount() == 0) {
				altYaziText.setText("Öðrenciler Tablosu þu anda boþ. ");
			} else {
				altYaziText.setText("Lütfen güncellenecek bir öðrenci seçin.");
			}
		} else {

			String isim = alinanIsim.getText().toString();
			String soyisim = alinanSoyisim.getText().toString();

			String ogrenciID = alinanOgrenciID.getText().toString();
			String bitirmeNotu = alinanBitirmeNotu.getText().toString();
			String yazili01 = model.getValueAt(selectedrow, 4).toString();
			String yazili02 = model.getValueAt(selectedrow, 5).toString();
			String yazili03 = model.getValueAt(selectedrow, 6).toString();
			String sozlu01 = model.getValueAt(selectedrow, 7).toString();
			String sozlu02 = model.getValueAt(selectedrow, 8).toString();
			ogrenciID = model.getValueAt(selectedrow, 0).toString();

			islemler.ogrenciGuncelle(ogrenciID, isim, soyisim, bitirmeNotu, yazili01, yazili02, yazili03, sozlu01,
					sozlu02);

			ogrenciGoruntule();

			altYaziText.setText("Öðrenci baþarýyla güncellendi...");
		}

	}// GEN-LAST:event_guncelleActionPerformed

	private void silActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_silActionPerformed
		altYaziText.setText("");

		int selectedrow = ogrenciTablosu.getSelectedRow();

		if (selectedrow == -1) {
			if (model.getRowCount() == 0) {
				altYaziText.setText("Öðrenci tablosu þu anda boþ...");
			} else {
				altYaziText.setText("Lütfen silinecek bir öðrenci seçin...");
			}

		} else {
			String id = model.getValueAt(selectedrow, 0).toString();

			islemler.ogrenciSil(id);

			ogrenciGoruntule();

			altYaziText.setText("Öðrenci baþarýyla silindi...");

		}

	}// GEN-LAST:event_silActionPerformed

	public void ogrenciGoruntule() {

		model.setRowCount(0);

		ArrayList<Students> ogrenciler = new ArrayList<Students>();

		ogrenciler = islemler.ogrencileriGetir();

		if (ogrenciler != null) {

			for (Students ogrenci : ogrenciler) {
				Object[] eklenecek = { ogrenci.getOgrenciID(), ogrenci.getIsim(), ogrenci.getSoyisim(),
						ogrenci.getBitirmeNot(), ogrenci.getYazili01(), ogrenci.getYazili02(), ogrenci.getYazili03(),
						ogrenci.getSozlu01(), ogrenci.getSozlu02() };

				model.addRow(eklenecek);

			}

		}

	}

	/**
	 * @return the seciliOgrenci
	 */
	public static Students getSeciliOgrenci() {
		return seciliOgrenci;
	}

	/**
	 * @param seciliOgrenci the seciliOgrenci to set
	 */
	public static void setSeciliOgrenci(Students seciliOgrenci) {
		OperationFrame.seciliOgrenci = seciliOgrenci;
	}

}
