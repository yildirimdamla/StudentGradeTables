package Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Exceptions.Feedbacks;
import StudentInstructions.StudentsDAL;

public class StudentInsertionFrame extends OperationFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4311422959977220501L;

	public static final String VARS_ISIM_TEXT = "Ýsim giriniz";
	public static final String VARS_SOYISIM_TEXT = "Soyisim giriniz";
	protected static final int VARS_NOT = -9999;

	public static final String VARS_KELIME = "Girilmemiþ";
	public static final String BOS_TEXT = "";

	public static JLabel ustBilgiText;

	StudentsDAL islemler = new StudentsDAL();

	private JPanel contentPane;
	private static JTextField alinanSoyisim;
	private static JTextField alinanIsim;
	private JTextField alinanOgrenciID;
	private static JTextField alinanBitirmeNotu;
	JLabel ustBilgiText_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					StudentInsertionFrame frame = new StudentInsertionFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentInsertionFrame() {

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 814, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel ustBilgiPanel = new JPanel();
		ustBilgiPanel.setPreferredSize(new Dimension(10, 30));
		contentPane.add(ustBilgiPanel, BorderLayout.NORTH);
		GridBagLayout gbl_ustBilgiPanel = new GridBagLayout();
		gbl_ustBilgiPanel.columnWidths = new int[] { 240, 0 };
		gbl_ustBilgiPanel.rowHeights = new int[] { 16, 0 };
		gbl_ustBilgiPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_ustBilgiPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		ustBilgiPanel.setLayout(gbl_ustBilgiPanel);

		ustBilgiText_1 = new JLabel("Yeni \u00D6\u011Frencimizi Tan\u0131tman\u0131z Bekleniyor... ");
		ustBilgiText_1.setForeground(SystemColor.activeCaption);
		ustBilgiText_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		ustBilgiText_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_ustBilgiText_1 = new GridBagConstraints();
		gbc_ustBilgiText_1.anchor = GridBagConstraints.WEST;
		gbc_ustBilgiText_1.gridx = 0;
		gbc_ustBilgiText_1.gridy = 0;
		ustBilgiPanel.add(ustBilgiText_1, gbc_ustBilgiText_1);

		JPanel veriPanel = new JPanel();
		veriPanel.setBackground(SystemColor.inactiveCaption);
		veriPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Yeni \u00D6\u011Frencimizin...", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		contentPane.add(veriPanel, BorderLayout.CENTER);
		veriPanel.setLayout(new BoxLayout(veriPanel, BoxLayout.X_AXIS));

		JPanel veriAlPaneli = new JPanel();
		veriAlPaneli.setBorder(null);
		veriPanel.add(veriAlPaneli);
		GridBagLayout gbl_veriAlPaneli = new GridBagLayout();
		gbl_veriAlPaneli.columnWidths = new int[] { 120, 160, 160, 160 };
		gbl_veriAlPaneli.rowHeights = new int[] { 30, 30 };
		gbl_veriAlPaneli.columnWeights = new double[] { 0.0, 1.0, 1.0 };
		gbl_veriAlPaneli.rowWeights = new double[] { 0.0, 0.0 };
		veriAlPaneli.setLayout(gbl_veriAlPaneli);

		JLabel ogrenciIDText = new JLabel("\u00D6grenci ID :");
		ogrenciIDText.setVerticalAlignment(SwingConstants.BOTTOM);
		ogrenciIDText.setPreferredSize(new Dimension(90, 35));
		ogrenciIDText.setFont(new Font("Georgia", Font.ITALIC, 15));

		GridBagConstraints gbc_ogrenciIDText = new GridBagConstraints();
		gbc_ogrenciIDText.anchor = GridBagConstraints.SOUTH;
		gbc_ogrenciIDText.fill = GridBagConstraints.HORIZONTAL;
		gbc_ogrenciIDText.insets = new Insets(0, 22, 5, 5);
		gbc_ogrenciIDText.gridx = 0;
		gbc_ogrenciIDText.gridy = 0;
		veriAlPaneli.add(ogrenciIDText, gbc_ogrenciIDText);

		JLabel ogrenciIsimText = new JLabel("Ad\u0131 :");
		ogrenciIsimText.setFont(new Font("Georgia", Font.ITALIC, 15));
		ogrenciIsimText.setVerticalAlignment(SwingConstants.BOTTOM);
		ogrenciIsimText.setPreferredSize(new Dimension(90, 35));
		ogrenciIDText.setFont(new Font("Georgia", Font.ITALIC, 15));

		GridBagConstraints gbc_ogrenciIsimText = new GridBagConstraints();
		gbc_ogrenciIsimText.anchor = GridBagConstraints.SOUTH;
		gbc_ogrenciIsimText.fill = GridBagConstraints.HORIZONTAL;
		gbc_ogrenciIsimText.insets = new Insets(0, 12, 5, 5);
		gbc_ogrenciIsimText.gridx = 1;
		gbc_ogrenciIsimText.gridy = 0;
		veriAlPaneli.add(ogrenciIsimText, gbc_ogrenciIsimText);

		JLabel ogrenciSoyisimText = new JLabel("Soyisim :");
		ogrenciSoyisimText.setFont(new Font("Georgia", Font.ITALIC, 15));
		ogrenciSoyisimText.setVerticalAlignment(SwingConstants.BOTTOM);
		ogrenciSoyisimText.setPreferredSize(new Dimension(90, 35));
		ogrenciIDText.setFont(new Font("Georgia", Font.ITALIC, 15));

		GridBagConstraints gbc_ogrenciSoyisimText = new GridBagConstraints();
		gbc_ogrenciSoyisimText.anchor = GridBagConstraints.SOUTH;
		gbc_ogrenciSoyisimText.fill = GridBagConstraints.HORIZONTAL;
		gbc_ogrenciSoyisimText.insets = new Insets(0, 12, 5, 5);
		gbc_ogrenciSoyisimText.gridx = 2;
		gbc_ogrenciSoyisimText.gridy = 0;
		veriAlPaneli.add(ogrenciSoyisimText, gbc_ogrenciSoyisimText);

		JLabel ogrenciBitirmeNotuText = new JLabel("Bitirme Notu :");
		ogrenciBitirmeNotuText.setFont(new Font("Georgia", Font.ITALIC, 15));
		ogrenciBitirmeNotuText.setVerticalAlignment(SwingConstants.BOTTOM);
		ogrenciBitirmeNotuText.setPreferredSize(new Dimension(90, 35));
		ogrenciIDText.setFont(new Font("Georgia", Font.ITALIC, 15));

		GridBagConstraints gbc_ogrenciBitirmeNotuText = new GridBagConstraints();
		gbc_ogrenciBitirmeNotuText.anchor = GridBagConstraints.SOUTH;
		gbc_ogrenciBitirmeNotuText.fill = GridBagConstraints.HORIZONTAL;
		gbc_ogrenciBitirmeNotuText.insets = new Insets(0, 12, 5, 22);
		gbc_ogrenciBitirmeNotuText.gridx = 3;
		gbc_ogrenciBitirmeNotuText.gridy = 0;
		veriAlPaneli.add(ogrenciBitirmeNotuText, gbc_ogrenciBitirmeNotuText);

		alinanBitirmeNotu = new JTextField(VARS_KELIME);
		alinanBitirmeNotu.setHorizontalAlignment(SwingConstants.RIGHT);
		alinanBitirmeNotu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ustBilgiText_1.setForeground(getForeground());
				alinanBitirmeNotu.setForeground(getForeground());
			}
		});
		alinanBitirmeNotu.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		alinanBitirmeNotu.setPreferredSize(new Dimension(90, 35));
		alinanBitirmeNotu.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 15));
		GridBagConstraints gbc_alinanBitirmeNotu = new GridBagConstraints();
		gbc_alinanBitirmeNotu.fill = GridBagConstraints.BOTH;
		gbc_alinanBitirmeNotu.insets = new Insets(0, 5, 10, 10);
		gbc_alinanBitirmeNotu.gridx = 3;
		gbc_alinanBitirmeNotu.gridy = 1;
		veriAlPaneli.add(alinanBitirmeNotu, gbc_alinanBitirmeNotu);
		alinanBitirmeNotu.setColumns(10);

		alinanOgrenciID = new JTextField();
		alinanOgrenciID.setHorizontalAlignment(SwingConstants.RIGHT);
		alinanOgrenciID.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		alinanOgrenciID.setPreferredSize(new Dimension(90, 35));
		alinanOgrenciID.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 15));
		alinanOgrenciID.setForeground(Color.BLUE);
		alinanOgrenciID.setBackground(SystemColor.inactiveCaptionBorder);
		alinanOgrenciID.setBorder(new LineBorder(SystemColor.activeCaption));
		alinanOgrenciID.setEditable(false);

		GridBagConstraints gbc_alinanOgrenciID = new GridBagConstraints();
		gbc_alinanOgrenciID.fill = GridBagConstraints.BOTH;
		gbc_alinanOgrenciID.insets = new Insets(0, 10, 10, 5);
		gbc_alinanOgrenciID.gridx = 0;
		gbc_alinanOgrenciID.gridy = 1;
		veriAlPaneli.add(alinanOgrenciID, gbc_alinanOgrenciID);
		alinanOgrenciID.setColumns(10);

		alinanIsim = new JTextField();
		alinanIsim.setHorizontalAlignment(SwingConstants.RIGHT);
		alinanIsim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ustBilgiText_1.setForeground(getForeground());
				ustBilgiText_1.setText("Lütfen eklemek istediðiniz öðrenci ismini giriniz!!!");
				alinanIsim.setText(BOS_TEXT);
				alinanIsim.setForeground(getForeground());

			}
		});

		alinanIsim.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		alinanIsim.setPreferredSize(new Dimension(90, 35));
		alinanIsim.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 15));
		GridBagConstraints gbc_alinanIsim = new GridBagConstraints();
		gbc_alinanIsim.fill = GridBagConstraints.BOTH;
		gbc_alinanIsim.insets = new Insets(0, 5, 10, 5);
		gbc_alinanIsim.gridx = 1;
		gbc_alinanIsim.gridy = 1;
		veriAlPaneli.add(alinanIsim, gbc_alinanIsim);
		alinanIsim.setColumns(10);

		alinanSoyisim = new JTextField();
		alinanSoyisim.setHorizontalAlignment(SwingConstants.RIGHT);
		alinanSoyisim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ustBilgiText_1.setForeground(getForeground());
				ustBilgiText_1.setText("Lütfen eklemek istediðiniz öðrenci soyismini giriniz!!!");
				alinanSoyisim.setText(BOS_TEXT);
				alinanSoyisim.setForeground(getForeground());

			}
		});
		alinanSoyisim.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		alinanSoyisim.setPreferredSize(new Dimension(90, 35));
		alinanSoyisim.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 15));
		GridBagConstraints gbc_alinanSoyisim = new GridBagConstraints();
		gbc_alinanSoyisim.insets = new Insets(0, 5, 10, 5);
		gbc_alinanSoyisim.fill = GridBagConstraints.BOTH;
		gbc_alinanSoyisim.gridx = 2;
		gbc_alinanSoyisim.gridy = 1;
		veriAlPaneli.add(alinanSoyisim, gbc_alinanSoyisim);
		alinanSoyisim.setColumns(10);

		JPanel altBilgiPanel = new JPanel();
		contentPane.add(altBilgiPanel, BorderLayout.SOUTH);
		altBilgiPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 5));

		JButton ogrenciyiEkleButonu = new JButton("\u00D6\u011Frenciyi Ekle");
		ogrenciyiEkleButonu.setPreferredSize(new Dimension(150, 30));
		ogrenciyiEkleButonu.setFont(new Font("Georgia", Font.ITALIC, 14));
		ogrenciyiEkleButonu.setMinimumSize(new Dimension(113, 35));
		ogrenciyiEkleButonu.setMaximumSize(new Dimension(113, 35));
		ogrenciyiEkleButonu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				geciciIsim = alinanIsim.getText();
				geciciSoyisim = alinanSoyisim.getText();

				ogrenciUygunMU(isimUygunMU(geciciIsim), soyisimUygunMu(geciciSoyisim), bitirmeNotuUygunMu());

			}

		});
		altBilgiPanel.add(ogrenciyiEkleButonu);

		JButton geriDonButonu = new JButton("Listeye Geri D\u00F6n");
		geriDonButonu.setPreferredSize(new Dimension(160, 30));
		geriDonButonu.setFont(new Font("Georgia", Font.ITALIC, 14));
		geriDonButonu.setMaximumSize(new Dimension(125, 35));
		geriDonButonu.setMinimumSize(new Dimension(125, 35));
		geriDonButonu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				setVisible(false);

				OperationFrame islemEkrani = new OperationFrame();
				islemEkrani.setLocationRelativeTo(null);
				islemEkrani.setVisible(true);

			}

		});
		altBilgiPanel.add(geriDonButonu);

		alinanIsim.setForeground(SystemColor.activeCaption);
		alinanIsim.setText(VARS_ISIM_TEXT);

		alinanSoyisim.setForeground(SystemColor.activeCaption);
		alinanSoyisim.setText(VARS_SOYISIM_TEXT);

		geciciOgrenciID = islemler.yeniOgrenciIDOlustur();
		alinanOgrenciID.setText(Integer.toString(geciciOgrenciID));

	}

	public static String geciciIsim;
	public static String geciciSoyisim;
	public static String geciciBitirmeNotu;
	public static int geciciOgrenciID;

	public static boolean alinanTextRakamlardanOlusuyorMu(String text) {
		boolean alinanTextRakamlardanOlusuyorMu = true;

		for (int j = 0; j < text.length(); j++) {

			if (Character.isDigit(text.charAt(j)) != true) {

				alinanTextRakamlardanOlusuyorMu = false;
			}

		}

		return alinanTextRakamlardanOlusuyorMu;

	}

	public static boolean kelimeNumaraIceriyorMu(String kelime) {

		boolean stringNumaraIceriyorMu = false;
		for (int j = 0; j < kelime.length(); j++) {

			if (Character.isDigit(kelime.charAt(j))) {

				stringNumaraIceriyorMu = true;
			}

		}
		return stringNumaraIceriyorMu;
	}

	public static boolean bitirmeNotuUygunMu() {
		boolean bitirmeNotuUygunMu = false;

		if (alinanBitirmeNotu.getText().toString().equals(VARS_KELIME)) {

			bitirmeNotuUygunMu = true;
			geciciBitirmeNotu = VARS_KELIME;

		} else {

			if (alinanTextRakamlardanOlusuyorMu(alinanBitirmeNotu.getText())) {
				geciciBitirmeNotu = alinanBitirmeNotu.getText();

				if (Integer.parseInt(geciciBitirmeNotu) >= 0 && Integer.parseInt(geciciBitirmeNotu) <= 100) {

					bitirmeNotuUygunMu = true;
				} else {
					bitirmeNotuUygunMu = false;
					alinanBitirmeNotu.setForeground(Color.PINK);
					alinanBitirmeNotu.setBorder(new LineBorder(Color.PINK));

					Exceptions.Feedbacks.uyariMesajiYaz("Not deðerleri 0 ile 100 arasýnda bir sayý olmalý...");
				}

			} else {

				bitirmeNotuUygunMu = false;
				alinanBitirmeNotu.setForeground(Color.PINK);
				alinanBitirmeNotu.setBorder(new LineBorder(Color.PINK));
				Feedbacks.bilgiMesajiYaz("Rakamlardan oluþan 0-100 arasýnda bir sayý giriniz...");
			}

		}
		return bitirmeNotuUygunMu;

	}

	public static boolean soyisimUygunMu(String geciciSoyisim) {

		boolean soyisimUygunMu = false;
		if (geciciSoyisim.equals(VARS_SOYISIM_TEXT) == false) {

			if (kelimeHarfIcerýyorMu(geciciSoyisim)) {
				if (geciciSoyisim.length() >= 2) {
					if (kelimeNumaraIceriyorMu(geciciSoyisim) == false) {

						soyisimUygunMu = true;

					} else {

						soyisimUygunMu = false;
						alinanSoyisim.setForeground(Color.PINK);
						alinanSoyisim.setBorder(new LineBorder(Color.PINK));

						Exceptions.Feedbacks.uyariMesajiYaz("Lütfen sayý içermeyen isimler giriniz...");

					}

				} else {
					soyisimUygunMu = false;
					alinanSoyisim.setForeground(Color.PINK);
					alinanSoyisim.setBorder(new LineBorder(Color.PINK));

					Exceptions.Feedbacks.uyariMesajiYaz("Lütfen 1 den fazla karaktere sahip isim giriniz ...");
				}

			} else {
				soyisimUygunMu = false;
				alinanSoyisim.setForeground(Color.PINK);
				alinanSoyisim.setBorder(new LineBorder(Color.PINK));

				Exceptions.Feedbacks.uyariMesajiYaz("Girilen soyisim harf içermeli ...");
			}
		} else {
			soyisimUygunMu = false;
			alinanSoyisim.setForeground(Color.PINK);
			alinanSoyisim.setBorder(new LineBorder(Color.PINK));

			Exceptions.Feedbacks.uyariMesajiYaz("Soyisim deðeri boþ olamaz...");
		}
		return soyisimUygunMu;
	}

	public static boolean isimUygunMU(String geciciIsim) {

		boolean isimUygunMU = false;

		if (geciciIsim.equals(VARS_ISIM_TEXT) == false) {

			if (kelimeHarfIcerýyorMu(geciciIsim)) {
				if (geciciIsim.length() >= 3) {
					if (kelimeNumaraIceriyorMu(geciciIsim) == false) {

						isimUygunMU = true;
					} else {

						isimUygunMU = false;
						alinanIsim.setForeground(Color.PINK);
						alinanIsim.setBorder(new LineBorder(Color.PINK));

						Exceptions.Feedbacks.uyariMesajiYaz("Lütfen sayý içermeyen isimler giriniz...");

					}

				} else {

					isimUygunMU = false;
					alinanIsim.setForeground(Color.PINK);
					alinanIsim.setBorder(new LineBorder(Color.PINK));

					Exceptions.Feedbacks.uyariMesajiYaz("Lütfen 2 den fazla karaktere sahip isim giriniz ...");
				}

			} else {
				isimUygunMU = false;
				alinanIsim.setForeground(Color.PINK);
				alinanIsim.setBorder(new LineBorder(Color.PINK));

				Exceptions.Feedbacks.uyariMesajiYaz("Girilen isim harf içermeli ...");
			}

		} else {
			isimUygunMU = false;
			alinanIsim.setForeground(Color.PINK);
			alinanIsim.setBorder(new LineBorder(Color.PINK));

			Exceptions.Feedbacks.uyariMesajiYaz("Ýsim deðeri boþ olamaz...");
		}

		return isimUygunMU;

	}

	public static boolean kelimeHarfIcerýyorMu(String kelime) {

		boolean kelimeHarfIcerýyorMu = false;

		if (kelime != null) {

			for (int j = 0; j < kelime.length(); j++) {

				if (Character.isAlphabetic(kelime.charAt(j))) {

					kelimeHarfIcerýyorMu = true;
				}

			}
		}

		return kelimeHarfIcerýyorMu;

	}

	private void ogrenciUygunMU(boolean isimUygunMU, boolean soyisimUygunMu, boolean bitirmeNotuUygunMu) {
		if (isimUygunMU && soyisimUygunMu && bitirmeNotuUygunMu) {

			String onayDiyalog = "ID: " + geciciOgrenciID + "\nAdý: " + geciciIsim + "\nSoyadý: " + geciciSoyisim
					+ "\nolan öðrenci " + geciciBitirmeNotu + " notuyla eklensin mi?";
			// EVET=0, NO=1, CANCEL=2

			switch (JOptionPane.showConfirmDialog(null, onayDiyalog)) {
			case 0:

				islemler.ogrenciEkle(String.valueOf(geciciOgrenciID), geciciIsim, geciciSoyisim, geciciBitirmeNotu,
						geciciBitirmeNotu, geciciBitirmeNotu, geciciBitirmeNotu, geciciBitirmeNotu, geciciBitirmeNotu);

				alinanIsim.setForeground(SystemColor.activeCaption);
				alinanIsim.setText(VARS_ISIM_TEXT);

				alinanSoyisim.setForeground(SystemColor.activeCaption);
				alinanSoyisim.setText(VARS_SOYISIM_TEXT);

				geciciOgrenciID = islemler.yeniOgrenciIDOlustur();
				alinanOgrenciID.setText(Integer.toString(geciciOgrenciID));

				break;

			case 2:
				setVisible(false);

				OperationFrame islemEkrani = new OperationFrame();
				islemEkrani.setLocationRelativeTo(null);
				islemEkrani.setVisible(true);

			default:

				break;
			}

		}

	}

}
