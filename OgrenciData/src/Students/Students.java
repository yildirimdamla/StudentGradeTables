package Students;

public class Students {

	private String ogrenciID;
	private String isim;
	private String soyisim;
	private String bitirmeNot;
	private String yazili01;
	private String yazili02;
	private String yazili03;
	private String sozlu01;
	private String sozlu02;

	public static final String VARS_OGRECI_ID = "-1";
	public static final String VARS_KELIME = "Girilmemiþ";
	public static final String VARS_NOT = "-1";

	public Students() {

		this.ogrenciID = VARS_OGRECI_ID;
		this.isim = VARS_KELIME;
		this.soyisim = VARS_KELIME;
		this.bitirmeNot = VARS_NOT;
		this.yazili01 = VARS_NOT;
		this.yazili02 = VARS_NOT;
		this.yazili03 = VARS_NOT;
		this.sozlu01 = VARS_NOT;
		this.sozlu02 = VARS_NOT;

	}

	public Students(String ogrenciID, String isim, String soyisim, String bitirmeNot) {
		super();

		this.ogrenciID = ogrenciID;
		this.isim = isim;
		this.soyisim = soyisim;

		this.bitirmeNot = bitirmeNot;

	}

	public Students(String ogrenciID2, String isim, String soyisim, String bitirmeNot, String yazili01, String yazili02,
			String yazili03, String sozlu01, String sozlu02) {
		super();
		this.ogrenciID = ogrenciID2;
		this.isim = isim;
		this.soyisim = soyisim;
		this.bitirmeNot = bitirmeNot;
		this.yazili01 = yazili01;
		this.yazili02 = yazili02;
		this.yazili03 = yazili03;
		this.sozlu01 = sozlu01;
		this.sozlu02 = sozlu02;
	}

	public String getOgrenciID() {
		return ogrenciID;
	}

	public void setOgrenciID(String ogrenciID) {
		this.ogrenciID = ogrenciID;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyisim() {
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public String getBitirmeNot() {
		return bitirmeNot;
	}

	public void setBitirmeNot(String bitirmeNot) {
		this.bitirmeNot = bitirmeNot;
	}

	public String getYazili01() {
		return yazili01;
	}

	public void setYazili01(String yazili01) {
		this.yazili01 = yazili01;
	}

	public String getYazili02() {
		return yazili02;
	}

	public void setYazili02(String yazili02) {
		this.yazili02 = yazili02;
	}

	public String getYazili03() {
		return yazili03;
	}

	public void setYazili03(String yazili03) {
		this.yazili03 = yazili03;
	}

	public String getSozlu01() {
		return sozlu01;
	}

	public void setSozlu01(String sozlu01) {
		this.sozlu01 = sozlu01;
	}

	public String getSozlu02() {
		return sozlu02;
	}

	public void setSozlu02(String sozlu02) {
		this.sozlu02 = sozlu02;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ogrenciID == null) ? 0 : ogrenciID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Students other = (Students) obj;
		if (ogrenciID == null) {
			if (other.ogrenciID != null) {
				return false;
			}
		} else if (!ogrenciID.equals(other.ogrenciID)) {
			return false;
		}
		return true;
	}

}
