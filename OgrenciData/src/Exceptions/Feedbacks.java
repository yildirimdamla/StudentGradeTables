package Exceptions;

import javax.swing.JOptionPane;

public class Feedbacks {

	public static void hataMesajiYaz(String message) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, message, "Hata Ekrani", JOptionPane.ERROR_MESSAGE);
	}

	public static void bilgiMesajiYaz(String message) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, message, "Bilgi Ekrani", JOptionPane.INFORMATION_MESSAGE);

	}

	public static void uyariMesajiYaz(String message) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, message, "Uyari Ekrani", JOptionPane.WARNING_MESSAGE);

	}

}
