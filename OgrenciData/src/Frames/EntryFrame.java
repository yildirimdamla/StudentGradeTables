package Frames;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

public class EntryFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2938956110138049458L;
	public OperationFrame islemEkrani = new OperationFrame();

	public static String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public static void setKullaniciAdi(String kullaniciAdi) {
		EntryFrame.kullaniciAdi = kullaniciAdi;
	}

	public static String getParola() {
		return parola;
	}

	public static void setParola(String parola) {
		EntryFrame.parola = parola;
	}

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					EntryFrame frame = new EntryFrame();
					frame.setLocationRelativeTo(null);
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
	public EntryFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		final TextField alinanKullaniciAdi = new TextField();
		alinanKullaniciAdi.setText("system");
		alinanKullaniciAdi.setBounds(140, 40, 200, 24);
		alinanKullaniciAdi.setForeground(Color.BLACK);

		Label parolaSor = new Label("Parola :");
		parolaSor.setBounds(76, 85, 59, 24);
		parolaSor.setAlignment(Label.RIGHT);

		final JPasswordField alinanParola = new JPasswordField();
		alinanParola.setText("12345");
		alinanParola.setBounds(140, 85, 200, 24);
		alinanParola.setBackground(Color.WHITE);
		alinanParola.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));

		Button girisButonu = new Button();
		girisButonu.addActionListener(new ActionListener() {
			@Override
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				setKullaniciAdi(alinanKullaniciAdi.getText());
				setParola(alinanParola.getText());
				SQLConnection.TableCreating tabloKontrolu = new SQLConnection.TableCreating();

				tabloKontrolu.tabloOlusturulmusMu();
				setVisible(false);

				islemEkrani.setLocationRelativeTo(null);
				islemEkrani.setVisible(true);

			}
		});
		girisButonu.setBounds(140, 130, 105, 24);
		girisButonu.setLabel("Giri\u015F");
		girisButonu.setName("giris");
		girisButonu.setBackground(new Color(173, 216, 230));

		Label kullaniciAdiSor = new Label("Kullanýcý Adý :");
		kullaniciAdiSor.setBounds(41, 40, 94, 24);
		kullaniciAdiSor.setAlignment(Label.RIGHT);

		Label mesaj = new Label("Mesaj..");
		mesaj.setBounds(51, 160, 350, 35);

		contentPane.setLayout(null);
		contentPane.add(kullaniciAdiSor);
		contentPane.add(alinanKullaniciAdi);
		contentPane.add(parolaSor);
		contentPane.add(alinanParola);
		contentPane.add(girisButonu, BorderLayout.CENTER);
		contentPane.add(mesaj);

	}

	private static String kullaniciAdi = "system";

	private static String parola = "12345";

}
