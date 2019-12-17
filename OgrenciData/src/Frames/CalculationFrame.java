package Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Exceptions.Feedbacks;
import Students.Students;

public class CalculationFrame extends OperationFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2420707897250164962L;
	protected static final int VARS_NOT = -9999;
	protected static final String VARS_ORAN = "1";
	protected static final String VARS_NOT_TEXT = "-9999";
	public static final String VARS_KELIME = "Girilmemiþ";

	public static double bitirmeNotu = VARS_NOT;

	private JPanel contentPane;
	private JTextField hesaplananBitirmeNotu;

	/**
	 * Create the frame.
	 */
	public CalculationFrame(final Students seciliOgrenci) {

		String ogrenciBilgileri = "Adý " + seciliOgrenci.getIsim().toUpperCase() + " soyadý "
				+ seciliOgrenci.getSoyisim().toUpperCase() + " ID'si " + seciliOgrenci.getOgrenciID()
				+ " olan öðrencinin deðerlerini giriniz";

		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setBounds(100, 100, 800, 245);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setSize(new Dimension(750, 200));
		contentPane.setPreferredSize(new Dimension(750, 200));
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), ogrenciBilgileri,
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 120, 215)));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 2));

		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.setBackground(SystemColor.menu);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel, BorderLayout.SOUTH);

		JLabel hesaplananBitirmeNotuText = new JLabel("Hesaplalanan bitirme notu :");
		hesaplananBitirmeNotuText.setForeground(SystemColor.textHighlight);
		hesaplananBitirmeNotuText.setFont(new Font("Georgia", Font.ITALIC, 14));
		panel.add(hesaplananBitirmeNotuText);

		hesaplananBitirmeNotu = new JTextField();
		hesaplananBitirmeNotu.setEditable(false);
		hesaplananBitirmeNotu.setHorizontalAlignment(SwingConstants.RIGHT);
		hesaplananBitirmeNotu.setPreferredSize(new Dimension(40, 35));
		hesaplananBitirmeNotu.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 15));
		hesaplananBitirmeNotu.setForeground(Color.BLUE);
		hesaplananBitirmeNotu.setBackground(SystemColor.inactiveCaptionBorder);
		hesaplananBitirmeNotu.setBorder(new LineBorder(SystemColor.activeCaption));

		panel.add(hesaplananBitirmeNotu);
		hesaplananBitirmeNotu.setColumns(10);

		JButton bitirmeNotunuHesaplaButonu = new JButton("Hesapla");
		bitirmeNotunuHesaplaButonu.setBackground(SystemColor.inactiveCaption);

		bitirmeNotunuHesaplaButonu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				bitirmeNotu = bitirmeNotuHesapla(notHesaplansinMi());
				if (bitirmeNotu != VARS_NOT) {

					hesaplananBitirmeNotu.setText(String.valueOf(bitirmeNotu));

				}
			}
		});
		bitirmeNotunuHesaplaButonu.setFont(new Font("Georgia", Font.ITALIC, 14));
		panel.add(bitirmeNotunuHesaplaButonu);
		bitirmeNotunuHesaplaButonu.setPreferredSize(new Dimension(100, 35));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 140, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 35, 35, 35, 35 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0 };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		yazili01Text = new JLabel("1. Yazili");
		yazili01Text.setFont(new Font("Georgia", Font.ITALIC, 15));
		GridBagConstraints gbc_yazili01Text = new GridBagConstraints();
		gbc_yazili01Text.anchor = GridBagConstraints.SOUTH;
		gbc_yazili01Text.insets = new Insets(0, 0, 5, 5);
		gbc_yazili01Text.gridx = 1;
		gbc_yazili01Text.gridy = 0;
		panel_1.add(yazili01Text, gbc_yazili01Text);

		yazili02Text = new JLabel("2. Yazili");
		yazili02Text.setFont(new Font("Georgia", Font.ITALIC, 15));
		GridBagConstraints gbc_yazili02Text = new GridBagConstraints();
		gbc_yazili02Text.anchor = GridBagConstraints.SOUTH;
		gbc_yazili02Text.insets = new Insets(0, 0, 5, 5);
		gbc_yazili02Text.gridx = 2;
		gbc_yazili02Text.gridy = 0;
		panel_1.add(yazili02Text, gbc_yazili02Text);

		yazili03Text = new JLabel("3. Yazili");
		yazili03Text.setFont(new Font("Georgia", Font.ITALIC, 15));
		GridBagConstraints gbc_yazili03Text = new GridBagConstraints();
		gbc_yazili03Text.anchor = GridBagConstraints.SOUTH;
		gbc_yazili03Text.insets = new Insets(0, 0, 5, 5);
		gbc_yazili03Text.gridx = 3;
		gbc_yazili03Text.gridy = 0;
		panel_1.add(yazili03Text, gbc_yazili03Text);

		sozlu01Text = new JLabel("1. S\u00F6zl\u00FC");
		sozlu01Text.setFont(new Font("Georgia", Font.ITALIC, 15));
		GridBagConstraints gbc_sozlu01Text = new GridBagConstraints();
		gbc_sozlu01Text.anchor = GridBagConstraints.SOUTH;
		gbc_sozlu01Text.insets = new Insets(0, 0, 5, 5);
		gbc_sozlu01Text.gridx = 4;
		gbc_sozlu01Text.gridy = 0;
		panel_1.add(sozlu01Text, gbc_sozlu01Text);

		sozlu02Text = new JLabel("2. S\u00F6zl\u00FC");
		sozlu02Text.setFont(new Font("Georgia", Font.ITALIC, 15));
		GridBagConstraints gbc_sozlu02Text = new GridBagConstraints();
		gbc_sozlu02Text.anchor = GridBagConstraints.SOUTH;
		gbc_sozlu02Text.insets = new Insets(0, 0, 5, 5);
		gbc_sozlu02Text.gridx = 5;
		gbc_sozlu02Text.gridy = 0;
		panel_1.add(sozlu02Text, gbc_sozlu02Text);

		JLabel notAgirlikOraniText = new JLabel("Not A\u011F\u0131rl\u0131k Oran\u0131");
		notAgirlikOraniText.setFont(new Font("Georgia", Font.ITALIC, 15));
		notAgirlikOraniText.setPreferredSize(new Dimension(165, 35));
		GridBagConstraints gbc_notAgirlikOraniText = new GridBagConstraints();
		gbc_notAgirlikOraniText.insets = new Insets(0, 0, 5, 5);
		gbc_notAgirlikOraniText.gridx = 0;
		gbc_notAgirlikOraniText.gridy = 1;
		panel_1.add(notAgirlikOraniText, gbc_notAgirlikOraniText);

		alinanYazili01Orani = new JTextField(VARS_ORAN);
		alinanYazili01Orani.setHorizontalAlignment(SwingConstants.RIGHT);
		alinanYazili01Orani.setPreferredSize(new Dimension(6, 30));
		GridBagConstraints gbc_alinanYazili01Orani = new GridBagConstraints();
		gbc_alinanYazili01Orani.insets = new Insets(0, 0, 5, 5);
		gbc_alinanYazili01Orani.fill = GridBagConstraints.BOTH;
		gbc_alinanYazili01Orani.gridx = 1;
		gbc_alinanYazili01Orani.gridy = 1;
		panel_1.add(alinanYazili01Orani, gbc_alinanYazili01Orani);
		alinanYazili01Orani.setColumns(10);

		alinanYazili02Orani = new JTextField(VARS_ORAN);
		alinanYazili02Orani.setHorizontalAlignment(SwingConstants.RIGHT);
		alinanYazili02Orani.setPreferredSize(new Dimension(6, 30));
		GridBagConstraints gbc_alinanYazili02Orani = new GridBagConstraints();
		gbc_alinanYazili02Orani.insets = new Insets(0, 0, 5, 5);
		gbc_alinanYazili02Orani.fill = GridBagConstraints.BOTH;
		gbc_alinanYazili02Orani.gridx = 2;
		gbc_alinanYazili02Orani.gridy = 1;
		panel_1.add(alinanYazili02Orani, gbc_alinanYazili02Orani);
		alinanYazili02Orani.setColumns(10);

		alinanYazili03Orani = new JTextField(VARS_ORAN);
		alinanYazili03Orani.setHorizontalAlignment(SwingConstants.RIGHT);
		alinanYazili03Orani.setPreferredSize(new Dimension(6, 30));
		GridBagConstraints gbc_alinanYazili03Orani = new GridBagConstraints();
		gbc_alinanYazili03Orani.insets = new Insets(0, 0, 5, 5);
		gbc_alinanYazili03Orani.fill = GridBagConstraints.BOTH;
		gbc_alinanYazili03Orani.gridx = 3;
		gbc_alinanYazili03Orani.gridy = 1;
		panel_1.add(alinanYazili03Orani, gbc_alinanYazili03Orani);
		alinanYazili03Orani.setColumns(10);

		alinanSozlu01Orani = new JTextField(VARS_ORAN);
		alinanSozlu01Orani.setHorizontalAlignment(SwingConstants.RIGHT);
		alinanSozlu01Orani.setPreferredSize(new Dimension(6, 30));
		GridBagConstraints gbc_alinanSozlu01Orani = new GridBagConstraints();
		gbc_alinanSozlu01Orani.insets = new Insets(0, 0, 5, 5);
		gbc_alinanSozlu01Orani.fill = GridBagConstraints.BOTH;
		gbc_alinanSozlu01Orani.gridx = 4;
		gbc_alinanSozlu01Orani.gridy = 1;
		panel_1.add(alinanSozlu01Orani, gbc_alinanSozlu01Orani);
		alinanSozlu01Orani.setColumns(10);

		alinanSozlu02Orani = new JTextField(VARS_ORAN);
		alinanSozlu02Orani.setHorizontalAlignment(SwingConstants.RIGHT);
		alinanSozlu02Orani.setPreferredSize(new Dimension(6, 30));
		GridBagConstraints gbc_alinanSozlu02Orani = new GridBagConstraints();
		gbc_alinanSozlu02Orani.insets = new Insets(0, 0, 5, 5);
		gbc_alinanSozlu02Orani.fill = GridBagConstraints.BOTH;
		gbc_alinanSozlu02Orani.gridx = 5;
		gbc_alinanSozlu02Orani.gridy = 1;
		panel_1.add(alinanSozlu02Orani, gbc_alinanSozlu02Orani);
		alinanSozlu02Orani.setColumns(10);

		bitirmeNotunuEkleButonu = new JButton("Bitirme Notunu Ekle");
		bitirmeNotunuEkleButonu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String bitirmeNotu = String.valueOf(bitirmeNotuHesapla(notHesaplansinMi()));

				double bitirmeNotuDegeri = Double.parseDouble(bitirmeNotu);
				if (bitirmeNotuDegeri >= 0 && bitirmeNotuDegeri <= 100) {

					String yazili01 = alinanYazili01Notu.getText().toString();
					String yazili02 = alinanYazili02Notu.getText().toString();
					String yazili03 = alinanYazili03Notu.getText().toString();
					String sozlu01 = alinanSozlu01Notu.getText().toString();
					String sozlu02 = alinanSozlu02Notu.getText().toString();
					islemler.ogrenciGuncelle(seciliOgrenci.getOgrenciID(), seciliOgrenci.getIsim(),
							seciliOgrenci.getSoyisim(), bitirmeNotu, yazili01, yazili02, yazili03, sozlu01, sozlu02);

					setVisible(false);

					OperationFrame islemEkrani = new OperationFrame();
					islemEkrani.setLocationRelativeTo(null);
					islemEkrani.setVisible(true);

				}
				;

			}
		});
		bitirmeNotunuEkleButonu.setMinimumSize(new Dimension(175, 35));
		bitirmeNotunuEkleButonu.setMaximumSize(new Dimension(175, 35));
		bitirmeNotunuEkleButonu.setPreferredSize(new Dimension(175, 35));
		bitirmeNotunuEkleButonu.setFont(new Font("Georgia", Font.ITALIC, 15));
		bitirmeNotunuEkleButonu.setBackground(SystemColor.inactiveCaption);

		GridBagConstraints gbc_bitirmeNotunuEkleButonu = new GridBagConstraints();
		gbc_bitirmeNotunuEkleButonu.gridheight = 2;
		gbc_bitirmeNotunuEkleButonu.insets = new Insets(0, 0, 0, 5);
		gbc_bitirmeNotunuEkleButonu.gridx = 6;
		gbc_bitirmeNotunuEkleButonu.gridy = 1;
		panel_1.add(bitirmeNotunuEkleButonu, gbc_bitirmeNotunuEkleButonu);

		geriDonButonu = new JButton("Listeye Geri D\u00F6n");

		geriDonButonu.setMinimumSize(new Dimension(175, 35));
		geriDonButonu.setMaximumSize(new Dimension(175, 35));
		geriDonButonu.setPreferredSize(new Dimension(175, 35));
		geriDonButonu.setFont(new Font("Georgia", Font.ITALIC, 15));
		geriDonButonu.setBackground(SystemColor.inactiveCaption);

		GridBagConstraints gbc_geriDonButonu = new GridBagConstraints();
		gbc_geriDonButonu.gridheight = 2;
		gbc_geriDonButonu.insets = new Insets(0, 0, 0, 5);
		gbc_geriDonButonu.gridx = 7;
		gbc_geriDonButonu.gridy = 1;
		panel_1.add(geriDonButonu, gbc_geriDonButonu);

		JLabel ogrencininAldigiNotText = new JLabel("\u00D6\u011Frencinin Ald\u0131\u011F\u0131 Not");
		ogrencininAldigiNotText.setFont(new Font("Georgia", Font.ITALIC, 15));
		ogrencininAldigiNotText.setPreferredSize(new Dimension(180, 35));
		GridBagConstraints gbc_ogrencininAldigiNotText = new GridBagConstraints();
		gbc_ogrencininAldigiNotText.insets = new Insets(0, 0, 0, 5);
		gbc_ogrencininAldigiNotText.gridx = 0;
		gbc_ogrencininAldigiNotText.gridy = 2;
		panel_1.add(ogrencininAldigiNotText, gbc_ogrencininAldigiNotText);

		alinanYazili01Notu = new JTextField();
		if (seciliOgrenci.getYazili01().equals(VARS_KELIME) == false) {

			alinanYazili01Notu.setText(seciliOgrenci.getYazili01());

		}
		;
		alinanYazili01Notu.setHorizontalAlignment(SwingConstants.RIGHT);
		alinanYazili01Notu.setPreferredSize(new Dimension(6, 30));
		GridBagConstraints gbc_alinanYazili01Notu = new GridBagConstraints();
		gbc_alinanYazili01Notu.insets = new Insets(0, 0, 0, 5);
		gbc_alinanYazili01Notu.fill = GridBagConstraints.BOTH;
		gbc_alinanYazili01Notu.gridx = 1;
		gbc_alinanYazili01Notu.gridy = 2;
		panel_1.add(alinanYazili01Notu, gbc_alinanYazili01Notu);
		alinanYazili01Notu.setColumns(10);

		alinanYazili02Notu = new JTextField();

		if (seciliOgrenci.getYazili02().equals(VARS_KELIME) == false) {

			alinanYazili02Notu.setText(seciliOgrenci.getYazili02());

		}
		;
		alinanYazili02Notu.setHorizontalAlignment(SwingConstants.RIGHT);
		alinanYazili02Notu.setPreferredSize(new Dimension(6, 30));
		GridBagConstraints gbc_alinanYazili02Notu = new GridBagConstraints();
		gbc_alinanYazili02Notu.insets = new Insets(0, 0, 0, 5);
		gbc_alinanYazili02Notu.fill = GridBagConstraints.BOTH;
		gbc_alinanYazili02Notu.gridx = 2;
		gbc_alinanYazili02Notu.gridy = 2;
		panel_1.add(alinanYazili02Notu, gbc_alinanYazili02Notu);
		alinanYazili02Notu.setColumns(10);

		alinanYazili03Notu = new JTextField();
		if (seciliOgrenci.getYazili03().equals(VARS_KELIME) == false) {

			alinanYazili03Notu.setText(seciliOgrenci.getYazili03());

		}
		;
		alinanYazili03Notu.setHorizontalAlignment(SwingConstants.RIGHT);
		alinanYazili03Notu.setPreferredSize(new Dimension(6, 30));
		GridBagConstraints gbc_alinanYazili03Notu = new GridBagConstraints();
		gbc_alinanYazili03Notu.insets = new Insets(0, 0, 0, 5);
		gbc_alinanYazili03Notu.fill = GridBagConstraints.BOTH;
		gbc_alinanYazili03Notu.gridx = 3;
		gbc_alinanYazili03Notu.gridy = 2;
		panel_1.add(alinanYazili03Notu, gbc_alinanYazili03Notu);
		alinanYazili03Notu.setColumns(10);

		alinanSozlu01Notu = new JTextField();
		if (seciliOgrenci.getSozlu01().equals(VARS_KELIME) == false) {

			alinanSozlu01Notu.setText(seciliOgrenci.getSozlu01());

		}
		;
		alinanSozlu01Notu.setHorizontalAlignment(SwingConstants.RIGHT);
		alinanSozlu01Notu.setPreferredSize(new Dimension(6, 30));
		GridBagConstraints gbc_alinanSozlu01Notu = new GridBagConstraints();
		gbc_alinanSozlu01Notu.insets = new Insets(0, 0, 0, 5);
		gbc_alinanSozlu01Notu.fill = GridBagConstraints.BOTH;
		gbc_alinanSozlu01Notu.gridx = 4;
		gbc_alinanSozlu01Notu.gridy = 2;
		panel_1.add(alinanSozlu01Notu, gbc_alinanSozlu01Notu);
		alinanSozlu01Notu.setColumns(10);

		alinanSozlu02Notu = new JTextField();
		if (seciliOgrenci.getSozlu02().equals(VARS_KELIME) == false) {

			alinanSozlu02Notu.setText(seciliOgrenci.getSozlu02());

		}
		;
		alinanSozlu02Notu.setHorizontalAlignment(SwingConstants.RIGHT);
		alinanSozlu02Notu.setPreferredSize(new Dimension(6, 30));
		GridBagConstraints gbc_alinanSozlu02Notu = new GridBagConstraints();
		gbc_alinanSozlu02Notu.insets = new Insets(0, 0, 0, 5);
		gbc_alinanSozlu02Notu.fill = GridBagConstraints.BOTH;
		gbc_alinanSozlu02Notu.gridx = 5;
		gbc_alinanSozlu02Notu.gridy = 2;
		panel_1.add(alinanSozlu02Notu, gbc_alinanSozlu02Notu);
		alinanSozlu02Notu.setColumns(10);

	}

	private JTextField alinanYazili01Orani;
	private JTextField alinanYazili02Orani;
	private JTextField alinanYazili03Orani;
	private JTextField alinanSozlu01Orani;
	private JTextField alinanSozlu02Orani;
	private static JTextField alinanYazili01Notu;
	private JTextField alinanYazili02Notu;
	private JTextField alinanYazili03Notu;
	private JTextField alinanSozlu01Notu;
	private JTextField alinanSozlu02Notu;
	private JLabel yazili01Text;
	private JLabel yazili02Text;
	private JLabel yazili03Text;
	private JLabel sozlu01Text;
	private JLabel sozlu02Text;

	private double bitirmeNotuHesapla(boolean notHesaplansinMi) {
		double bitirmeNotu;
		if (notHesaplansinMi) {
			bitirmeNotu = ((yazili01Notu * yazili01Orani) + (yazili02Notu * yazili02Orani)
					+ (yazili03Notu * yazili03Orani) + (sozlu01Notu * sozlu01Orani) + (sozlu02Notu * sozlu02Orani))
					/ (double) (yazili01Orani + yazili02Orani + yazili03Orani + sozlu01Orani + sozlu02Orani);

		} else {
			bitirmeNotu = VARS_NOT;
		}

		return bitirmeNotu;

	}

	private Boolean notHesaplansinMi() {
		boolean notHesaplansinMi = true;

		if (alinanTextIstenenAralýktaMi(alinanYazili01Orani.getText().toString())) {
			alinanYazili01Orani.setForeground(getForeground());
			alinanYazili01Orani.setBorder(null);
			yazili01Orani = Integer.parseInt(alinanYazili01Orani.getText().toString());

		} else {
			alinanYazili01Orani.setForeground(Color.PINK);
			alinanYazili01Orani.setBorder(new LineBorder(Color.PINK));
			notHesaplansinMi = false;
		}
		;

		if (alinanTextIstenenAralýktaMi(alinanYazili02Orani.getText().toString())) {
			alinanYazili02Orani.setForeground(getForeground());
			alinanYazili02Orani.setBorder(null);
			yazili02Orani = Integer.parseInt(alinanYazili02Orani.getText().toString());
		} else {
			alinanYazili02Orani.setForeground(Color.PINK);
			alinanYazili02Orani.setBorder(new LineBorder(Color.PINK));
			notHesaplansinMi = false;
		}
		;

		if (alinanTextIstenenAralýktaMi(alinanYazili03Orani.getText().toString())) {
			alinanYazili03Orani.setForeground(getForeground());
			alinanYazili03Orani.setBorder(null);
			yazili03Orani = Integer.parseInt(alinanYazili03Orani.getText().toString());
		} else {
			alinanYazili03Orani.setForeground(Color.PINK);
			alinanYazili03Orani.setBorder(new LineBorder(Color.PINK));
			notHesaplansinMi = false;
		}
		;

		if (alinanTextIstenenAralýktaMi(alinanSozlu01Orani.getText().toString())) {
			sozlu01Orani = Integer.parseInt(alinanSozlu01Orani.getText().toString());
			alinanSozlu01Orani.setForeground(getForeground());
			alinanSozlu01Orani.setBorder(null);
		} else {
			alinanSozlu01Orani.setForeground(Color.PINK);
			alinanSozlu01Orani.setBorder(new LineBorder(Color.PINK));
			notHesaplansinMi = false;
		}
		;

		if (alinanTextIstenenAralýktaMi(alinanSozlu02Orani.getText().toString())) {
			sozlu02Orani = Integer.parseInt(alinanSozlu02Orani.getText().toString());
			alinanSozlu02Orani.setForeground(getForeground());
			alinanSozlu02Orani.setBorder(null);
		} else {
			alinanSozlu02Orani.setForeground(Color.PINK);
			alinanSozlu02Orani.setBorder(new LineBorder(Color.PINK));
			notHesaplansinMi = false;
		}

		if (alinanTextIstenenAralýktaMi(alinanYazili01Notu.getText().toString())) {
			alinanYazili01Notu.setForeground(getForeground());
			alinanYazili01Notu.setBorder(null);
			yazili01Notu = Integer.parseInt(alinanYazili01Notu.getText().toString());

		} else {
			alinanYazili01Notu.setForeground(Color.PINK);
			alinanYazili01Notu.setBorder(new LineBorder(Color.PINK));
			notHesaplansinMi = false;
		}
		;

		if (alinanTextIstenenAralýktaMi(alinanYazili02Notu.getText().toString())) {
			alinanYazili02Notu.setForeground(getForeground());
			alinanYazili02Notu.setBorder(null);
			yazili02Notu = Integer.parseInt(alinanYazili02Notu.getText().toString());
		} else {
			alinanYazili02Notu.setForeground(Color.PINK);
			alinanYazili02Notu.setBorder(new LineBorder(Color.PINK));
			notHesaplansinMi = false;
		}
		;

		if (alinanTextIstenenAralýktaMi(alinanYazili03Notu.getText().toString())) {
			alinanYazili03Notu.setForeground(getForeground());
			alinanYazili03Notu.setBorder(null);
			yazili03Notu = Integer.parseInt(alinanYazili03Notu.getText().toString());
		} else {
			alinanYazili03Notu.setForeground(Color.PINK);
			alinanYazili03Notu.setBorder(new LineBorder(Color.PINK));
			notHesaplansinMi = false;
		}
		;

		if (alinanTextIstenenAralýktaMi(alinanSozlu01Notu.getText().toString())) {
			sozlu01Notu = Integer.parseInt(alinanSozlu01Notu.getText().toString());
			alinanSozlu01Notu.setForeground(getForeground());
			alinanSozlu01Notu.setBorder(null);
		} else {
			alinanSozlu01Notu.setForeground(Color.PINK);
			alinanSozlu01Notu.setBorder(new LineBorder(Color.PINK));
			notHesaplansinMi = false;
		}
		;

		if (alinanTextIstenenAralýktaMi(alinanSozlu02Notu.getText().toString())) {
			sozlu02Notu = Integer.parseInt(alinanSozlu02Notu.getText().toString());
			alinanSozlu02Notu.setForeground(getForeground());
			alinanSozlu02Notu.setBorder(null);
		} else {
			alinanSozlu02Notu.setForeground(Color.PINK);
			alinanSozlu02Notu.setBorder(new LineBorder(Color.PINK));
			notHesaplansinMi = false;
		}
		;

		return notHesaplansinMi;

	}// GEN-LAST:event_ogrenciTablosuMouseClicked

	public static int yazili01Notu;
	public static int yazili02Notu;
	public static int yazili03Notu;
	public static int sozlu01Notu;
	public static int sozlu02Notu;

	public static int yazili01Orani;
	public static int yazili02Orani;
	public static int yazili03Orani;
	public static int sozlu01Orani;
	public static int sozlu02Orani;

	public static boolean alinanTextIstenenAralýktaMi = false;
	public static boolean alinanTextRakamlardanOlusuyorMu = true;
	private JButton bitirmeNotunuEkleButonu;
	private JButton geriDonButonu;

	public static boolean alinanTextIstenenAralýktaMi(String text) {

		int notDegeri;

		if (text.equals(null) || text.equals("") || text.equals(" ")) {

			text = VARS_NOT_TEXT;

		}
		;

		for (int j = 0; j < text.length(); j++) {

			if (Character.isDigit(text.charAt(j)) != true) {

				text = VARS_NOT_TEXT;
				alinanTextRakamlardanOlusuyorMu = false;

			}

		}
		;
		if (text != VARS_NOT_TEXT) {
			if (alinanTextRakamlardanOlusuyorMu = true) {

				notDegeri = Integer.parseInt(text);
				if (notDegeri >= 0 && notDegeri <= 100) {
					alinanTextIstenenAralýktaMi = true;

				} else {

					notDegeri = VARS_NOT;
					alinanTextIstenenAralýktaMi = false;
					Feedbacks.bilgiMesajiYaz("Not puanlarý 0 ile 100 arasýnda olmalý...");

				}

			}
		} else {

			notDegeri = VARS_NOT;
			alinanTextRakamlardanOlusuyorMu = false;
			alinanTextIstenenAralýktaMi = false;
			Feedbacks.bilgiMesajiYaz("Not deðerleri rakamlardan oluþmalý...");
		}
		;

		return alinanTextIstenenAralýktaMi;

	}

}
