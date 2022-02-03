package com.skillnet.util.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class KeyEncrypter {

	private static final String SECRET_KEY_1 = "ssdkF$HUy2A#D%kd";
	private static final String SECRET_KEY_2 = "weJiSEvR5yAC5ftB";

	private IvParameterSpec ivParameterSpec;
	private SecretKeySpec secretKeySpec;
	private Cipher cipher;

	private static KeyEncrypter object = null;
	
	//prevent instantiation 
	private KeyEncrypter() throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException {
		ivParameterSpec = new IvParameterSpec(SECRET_KEY_1.getBytes("UTF-8"));
		secretKeySpec = new SecretKeySpec(SECRET_KEY_2.getBytes("UTF-8"), "AES");
		cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	}

	public static KeyEncrypter getInstance() {
		if (object == null) {
			try {
				object = new KeyEncrypter();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}

		return object;

	}

	/**
	 * Encrypt the string with this internal algorithm.
	 *
	 * @param toBeEncrypt
	 *            string object to be encrypt.
	 * @return returns encrypted string.
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidAlgorithmParameterException
	 * @throws InvalidKeyException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	public String encrypt(String toBeEncrypt) {
		try {
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
			byte[] encrypted = cipher.doFinal(toBeEncrypt.getBytes());
			return Base64.encodeBase64String(encrypted);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return toBeEncrypt;
	}

	/**
	 * Decrypt this string with the internal algorithm. The passed argument
	 * should be encrypted using {@link #encrypt(String) encrypt} method of this
	 * class.
	 *
	 * @param encrypted
	 *            encrypted string that was encrypted using
	 *            {@link #encrypt(String) encrypt} method.
	 * @return decrypted string.
	 * @throws InvalidAlgorithmParameterException
	 * @throws InvalidKeyException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	public String decrypt(String encrypted) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
			byte[] decryptedBytes = cipher.doFinal(Base64.decodeBase64(encrypted));
			return new String(decryptedBytes);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return encrypted;
	}
}