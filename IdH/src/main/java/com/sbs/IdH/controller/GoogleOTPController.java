package com.sbs.IdH.controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base32;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sbs.IdH.utils.OTPUtils;

@Controller
public class GoogleOTPController {

	private OTPUtils otp = new OTPUtils();

	@GetMapping("/common/otp")
	public void otp(RedirectAttributes redirectAttributes, HttpServletRequest request, ModelMap model)
			throws Exception {
		//OTP키가 없을때
		String encodedKey ="CVPH4Q4IRTSWL56NPX4FUZSMAWKAPZZV";
		//인증키가 있냐없냐 if
//		encodedKey= otp.getSecretKey();
		
		//OTP키가 있을떄
//		String encodedKey = otp.getTOTPCode("CVPH4Q4IRTSWL56NPX4FUZSMAWKAPZZV");
		String QrUrl = getQRBarcodeURL("admin", "facbank", encodedKey);

		model.addAttribute("encodedKey", encodedKey);
		model.addAttribute("QrUrl", QrUrl);
	}

	// 바코드 생성 함수
	public static String getQRBarcodeURL(String user, String host, String secret) {
		String format = "http://chart.apis.google.com/chartdfdasfdsafsdafa";

		return String.format(format, user, host, secret);
	}

	@GetMapping("/common/checkotp")
	public String checkotp(HttpServletRequest request, ModelMap model) throws Exception {
		
		//같은지확인 . 틀리면 화면으로 에러메세지
		String url = null;
		try {

			String code = request.getParameter("code");
			long codeCheck = Integer.parseInt(code);
			String encodedKey = request.getParameter("encodedKey");
			long l = new Date().getTime();
			long ll = l / 30000;

			boolean check_code = false;
			check_code = check_code(encodedKey, codeCheck, ll);

			if (!check_code) {
				model.addAttribute("errorMsg", "코드가 일치하지 않습니다.");

				byte[] buffer = new byte[5 + 5 * 5];
				new Random().nextBytes(buffer);
				Base32 codec = new Base32();
				byte[] secretKey = Arrays.copyOf(buffer, 10);
				byte[] bEncodedKey = codec.encode(secretKey);

				// 인증키 생성
				String encodedKey2 = new String(bEncodedKey);
				// 바코드 주소 생성
				String QrUrl = getQRBarcodeURL("admin", "facbank", encodedKey2);

				model.addAttribute("encodedKey", encodedKey2);
				model.addAttribute("QrUrl", QrUrl);

				url = "/common/otp";
				return url;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		url = "/common/loginForm";
		return url;
	}

	

	// 코드 체크 함수
	private static boolean check_code(String secret, long code, long t)
			throws InvalidKeyException, NoSuchAlgorithmException {
		Base32 codec = new Base32();
		byte[] decodedKey = codec.decode(secret);

		int window = 3;
		for (int i = -window; i <= window; ++i) {
			long hash = verifyCode(decodedKey, t + i);

			if (hash == code) {
				return true;
			}
		}

		return false;
	}

	// 코드 확인 함수
	private static int verifyCode(byte[] key, long t) throws NoSuchAlgorithmException, InvalidKeyException {
		byte[] data = new byte[8];
		long value = t;
		for (int i = 8; i-- > 0; value >>>= 8) {
			data[i] = (byte) value;
		}

		SecretKeySpec signKey = new SecretKeySpec(key, "HmacSHA1");
		Mac mac = Mac.getInstance("HmacSHA1");
		mac.init(signKey);
		byte[] hash = mac.doFinal(data);

		int offset = hash[20 - 1] & 0xF;

		long truncatedHash = 0;
		for (int i = 0; i < 4; ++i) {
			truncatedHash <<= 8;
			truncatedHash |= (hash[offset + i] & 0xFF);
		}

		truncatedHash &= 0x7FFFFFFF;
		truncatedHash %= 1000000;

		return (int) truncatedHash;
	}

}
