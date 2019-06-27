package com.andersonfonseka.caffeine.servlet;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

public class UploadDownload {

	public String uploadFiles(BufferedImage uploadImage, String componentId, String uploadId, HttpServletRequest request) {
		
		String resultado = "";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {

			ImageIO.write(uploadImage, "jpg", baos );
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();
			
			resultado = Base64.getEncoder().encodeToString(imageInByte);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute(uploadId, resultado);
		
		return resultado;
	}

}
