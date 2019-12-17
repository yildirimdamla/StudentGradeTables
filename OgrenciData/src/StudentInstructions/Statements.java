package StudentInstructions;

public class Statements {
	private static String tableName = "OGRENCILER_TABLOSU";

	public static String setTableName(String tableName) {
		return Statements.tableName = tableName;
	}

	public static final String TABLO_CREATING = "CREATE TABLE \"SYSTEM\".\"" + tableName + "\" \r\n" + "   (\""
			+ StudentColumns.OGRENCI_ID.toString() + "\" NVARCHAR2(20) NOT NULL ENABLE, \r\n" + "	\""
			+ StudentColumns.ISIM.toString() + "\" NVARCHAR2(100), \r\n" + "	\"" + StudentColumns.SOYISIM.toString()
			+ "\" NVARCHAR2(100), \r\n" + "	\"" + StudentColumns.BITIRME_NOT.toString() + "\" NVARCHAR2(20), \r\n"
			+ "	\"" + StudentColumns.YAZILI_01.toString() + "\" NVARCHAR2(20), \r\n" + "	\""
			+ StudentColumns.YAZILI_02.toString() + "\" NVARCHAR2(20), \r\n" + "	\""
			+ StudentColumns.YAZILI_03.toString() + "\" NVARCHAR2(20), \r\n" + "	\""
			+ StudentColumns.SOZLU_01.toString() + "\" NVARCHAR2(20), \r\n" + "	\"" + StudentColumns.SOZLU_02.toString()
			+ "\" NVARCHAR2(20), \r\n" + "	 CONSTRAINT \"" + tableName + "\" PRIMARY KEY (\"OGRENCI_ID\"))";

	public static final String SELECT_ALL_OGRENCI = "SELECT * FROM " + tableName;
	public static final String DELETE_OGRENCI = "DELETE FROM " + tableName + " WHERE "
			+ StudentColumns.OGRENCI_ID.toString() + " = ?";
	public static final String INSERT_OGRENCI = "INSERT INTO " + tableName + " (" + StudentColumns.OGRENCI_ID.toString()
			+ ", " + StudentColumns.ISIM.toString() + ", " + StudentColumns.SOYISIM.toString() + ", "
			+ StudentColumns.BITIRME_NOT.toString() + ", " + StudentColumns.YAZILI_01.toString() + ", "
			+ StudentColumns.YAZILI_02.toString() + ", " + StudentColumns.YAZILI_03.toString() + ", "
			+ StudentColumns.SOZLU_01.toString() + ", " + StudentColumns.SOZLU_02.toString()
			+ " ) VALUES(?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE_OGRENCI = "UPDATE " + tableName + " SET " + StudentColumns.ISIM.toString()
			+ " = ? , " + StudentColumns.SOYISIM.toString() + " = ? , " + StudentColumns.BITIRME_NOT.toString()
			+ " = ? , " + StudentColumns.YAZILI_01.toString() + " = ? ," + StudentColumns.YAZILI_02.toString()
			+ " = ? ," + StudentColumns.YAZILI_03.toString() + " = ? ," + StudentColumns.SOZLU_01.toString() + " = ? ,"
			+ StudentColumns.SOZLU_02.toString() + " = ? WHERE " + StudentColumns.OGRENCI_ID.toString() + " = ?";
	public static final String SELECT_MAX = "SELECT MAX(OGRENCI_ID) FROM " + tableName;

}
