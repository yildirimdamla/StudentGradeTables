package StudentInstructions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Exceptions.Feedbacks;
import SQLConnection.AppConnection;
import Students.Students;

public class StudentsDAL {

	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;

	public ArrayList<Students> ogrencileriGetir() {

		ArrayList<Students> cikti = new ArrayList<Students>();

		try {
			statement = connection.createStatement();
			String sorgu = Statements.SELECT_ALL_OGRENCI;
			ResultSet resultSet = statement.executeQuery(sorgu);
			while (resultSet.next()) {
				cikti.add(createEntity(resultSet));
			}

			return cikti;

		} catch (SQLException ex) {
			Logger.getLogger(StudentsDAL.class.getName()).log(Level.SEVERE, null, ex);
			return null;

		}
	}

	private Students createEntity(ResultSet resultSet) {
		try {
			String ogrenciID = resultSet.getString(StudentInstructions.StudentColumns.OGRENCI_ID.toString());
			String isim = resultSet.getString(StudentInstructions.StudentColumns.ISIM.toString());
			String soyisim = resultSet.getString(StudentInstructions.StudentColumns.SOYISIM.toString());
			String bitirmeNot = resultSet.getString(StudentInstructions.StudentColumns.BITIRME_NOT.toString());
			String yazili01 = resultSet.getString(StudentInstructions.StudentColumns.YAZILI_01.toString());
			String yazili02 = resultSet.getString(StudentInstructions.StudentColumns.YAZILI_02.toString());
			String yazili03 = resultSet.getString(StudentInstructions.StudentColumns.YAZILI_03.toString());
			String sozlu01 = resultSet.getString(StudentInstructions.StudentColumns.SOZLU_01.toString());
			String sozlu02 = resultSet.getString(StudentInstructions.StudentColumns.SOZLU_02.toString());

			return new Students(ogrenciID, isim, soyisim, bitirmeNot, yazili01, yazili02, yazili03, sozlu01, sozlu02);
		} catch (SQLException exception) {
			Feedbacks.hataMesajiYaz(exception.getMessage());
			return null;
		}
	}

	public void ogrenciGuncelle(String guncellenenOgrenciID, String isim, String soyisim, String bitirmeNotu,
			String yazili01, String yazili02, String yazili03, String sozlu01, String sozlu02) {
		// TODO Auto-generated method stub

		try {
			String sorgu = Statements.UPDATE_OGRENCI;

			preparedStatement = connection.prepareStatement(sorgu);

			preparedStatement.setString(9, guncellenenOgrenciID);
			preparedStatement.setString(1, isim);

			preparedStatement.setString(2, soyisim);

			preparedStatement.setString(3, bitirmeNotu);

			preparedStatement.setString(4, yazili01);
			preparedStatement.setString(5, yazili02);

			preparedStatement.setString(6, yazili03);

			preparedStatement.setString(7, sozlu01);
			preparedStatement.setString(8, sozlu02);
			preparedStatement.executeUpdate();

			preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(StudentsDAL.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void ogrenciSil(String ogrenciID) {
		// TODO Auto-generated method stub
		try {
			String sorgu = Statements.DELETE_OGRENCI;
			preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setString(1, ogrenciID);
			preparedStatement.executeUpdate();

			ogrencileriGetir();

		} catch (SQLException ex) {
			Logger.getLogger(StudentsDAL.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void ogrenciEkle(String ogrenciID, String isim, String soyisim, String geciciBitirmeNotu,
			String geciciBitirmeNotu2, String geciciBitirmeNotu3, String geciciBitirmeNotu4, String geciciBitirmeNotu5,
			String geciciBitirmeNotu6) {
		// TODO Auto-generated method stub
		try {

			String sorgu = Statements.INSERT_OGRENCI;
			preparedStatement = connection.prepareStatement(sorgu);

			preparedStatement.setString(1, ogrenciID);
			preparedStatement.setString(2, isim);

			preparedStatement.setString(3, soyisim);

			preparedStatement.setString(4, geciciBitirmeNotu);

			preparedStatement.setString(5, geciciBitirmeNotu2);
			preparedStatement.setString(6, geciciBitirmeNotu3);

			preparedStatement.setString(7, geciciBitirmeNotu4);

			preparedStatement.setString(8, geciciBitirmeNotu5);
			preparedStatement.setString(9, geciciBitirmeNotu6);
			preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(StudentsDAL.class.getName()).log(Level.SEVERE, null, ex);
		}
		;

	}

	public int enBuyukOgrenciIDdCek(int enBuyukOgrenciIDd) {

		String sorgu = Statements.SELECT_MAX;

		try {

			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sorgu);
			int ogrenciID = 0;

			while (resultSet.next()) {
				ogrenciID = resultSet.getInt("MAX(OGRENCI_ID)".toString());

				enBuyukOgrenciIDd = ogrenciID;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			enBuyukOgrenciIDd = 0;
			Feedbacks.hataMesajiYaz("Yeni öðrenciye ID kalmamýþþþ, \nyönetimle iletiþime geçiniz...");

		}

		return enBuyukOgrenciIDd;

	}

	public int yeniOgrenciIDOlustur() {
		int enBuyukOgrenciIDd = 0;

		int ogrenciID = enBuyukOgrenciIDdCek(enBuyukOgrenciIDd) + 1;
		return ogrenciID;

	}

	public StudentsDAL() {

		connection = AppConnection.SemaBaglantisiniKur();
		try {
			statement = connection.createStatement();
		} catch (SQLException exception) {

			Feedbacks.bilgiMesajiYaz("Baðlantý saðlanamadý...");
		}
	}

}
