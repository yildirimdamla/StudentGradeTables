package SQLConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Exceptions.Feedbacks;
import Frames.EntryFrame;

public class AppConnection {

	public AppConnection() {

		SemaBaglantisiniKur();
	}

	private final static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";

	@SuppressWarnings("unused")
	private static final String CONNECTION_NAME = "OgrenciCRUDApp";

	public static boolean baglantiBasarriliMi;

	public static Connection SemaBaglantisiniKur() {
		try {
			baglantiBasarriliMi = true;
			String kullaniciAdi = EntryFrame.getKullaniciAdi();
			String parola = EntryFrame.getParola();
			return DriverManager.getConnection(DB_URL, kullaniciAdi, parola);
		} catch (SQLException exception) {

			Feedbacks.hataMesajiYaz("Kullanýcý bilgileriniz geçerli deðil yada kullanýcý adý parola ile uyuþmuyor...");
			baglantiBasarriliMi = false;
			return null;
		}

	}

}
