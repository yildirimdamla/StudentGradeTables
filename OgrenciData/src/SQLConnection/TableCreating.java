package SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import StudentInstructions.Statements;
import StudentInstructions.StudentColumns;
import Students.Students;

public class TableCreating {

	private Connection connection = null;
	public Statement statement = null;
	public PreparedStatement preparedStatement = null;

	public void tabloOlusturulmusMu() {

		ArrayList<Students> cikti = new ArrayList<Students>();

		connection = AppConnection.SemaBaglantisiniKur();

		if (AppConnection.baglantiBasarriliMi) {

			try {
				statement = connection.createStatement();

				String sorgu = Statements.SELECT_ALL_OGRENCI;
				ResultSet resultSet = statement.executeQuery(sorgu);
				while (resultSet.next()) {
					cikti.add(createEntity(resultSet));
				}
				Exceptions.Feedbacks.bilgiMesajiYaz(
						"Daha önce zaten bir öðrenci tablonuz varmýþ. \nTablonuzu sizin için çaðýrdýk :) ");

			} catch (SQLException e) {

				try {

					statement.executeUpdate(Statements.TABLO_CREATING);
					Exceptions.Feedbacks.bilgiMesajiYaz(
							"Sizin için yeni bir öðrenci tablosu oluþturduk...\nGüle güle kullanýn :) ");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				System.out.println(Statements.TABLO_CREATING);

			}

		}

	}

	private Students createEntity(ResultSet resultSet) {
		try {
			String ogrenciID = resultSet.getString(StudentColumns.OGRENCI_ID.toString());
			String isim = resultSet.getString(StudentColumns.ISIM.toString());
			String soyisim = resultSet.getString(StudentColumns.SOYISIM.toString());
			String bitirmeNot = resultSet.getString(StudentColumns.BITIRME_NOT.toString());
			String yazili01 = resultSet.getString(StudentColumns.YAZILI_01.toString());
			String yazili02 = resultSet.getString(StudentColumns.YAZILI_02.toString());
			String yazili03 = resultSet.getString(StudentColumns.YAZILI_03.toString());
			String sozlu01 = resultSet.getString(StudentColumns.SOZLU_01.toString());
			String sozlu02 = resultSet.getString(StudentColumns.SOZLU_02.toString());

			Students yeniSatirOgrenci = new Students(ogrenciID, isim, soyisim, bitirmeNot, yazili01, yazili02, yazili03,
					sozlu01, sozlu02);

			return yeniSatirOgrenci;
		} catch (SQLException exception) {
			Exceptions.Feedbacks.hataMesajiYaz(exception.getMessage());
			return null;
		}
	}
}