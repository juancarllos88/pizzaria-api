package br.com.pizzaria.core.api.infrastructure.util;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CriptografiaUtil {

	public static String criptografar(String original) {

		StringBuilder hexString = new StringBuilder();
		if (original != null) {
			try {
				MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
				byte messageDigest[] = algorithm.digest(original.getBytes("UTF-8"));

				for (byte b : messageDigest) {
					hexString.append(String.format("%02X", 0xFF & b));
				}

			} catch (Exception e) {

			}
		}

		return hexString.toString();

	}

	public static Map<String, String> gerarSenhaAleatoria(int length) {

		Map<String, String> senhas = new HashMap<>();

		char[] chart = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
				'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
				'Z' };
		char[] senha = new char[length];
		int chartLenght = chart.length;

		Random rdm = new Random();

		for (int x = 0; x < length; x++) {
			senha[x] = chart[rdm.nextInt(chartLenght)];
		}

		String senhaCript = criptografar(new String(senha));

		senhas.put("senhaOriginal", new String(senha));
		senhas.put("senhaCript", new String(senhaCript));

		return senhas;
	}

}
