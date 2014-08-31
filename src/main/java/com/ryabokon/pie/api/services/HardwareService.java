package com.ryabokon.pie.api.services;

import java.io.*;

public class HardwareService {

	private String path = "/dev/spidev0.0";
	private FileOutputStream miso = null;

	public HardwareService() {

	}

	public HardwareService(String customPath) {
		this.path = customPath;
		createEmptyFile();
	}

	public void sendData(byte[] data) {
		try {
			miso = new FileOutputStream(path);
			miso.write(data);
			miso.flush();
			miso.close();
		} catch (IOException e) {
			System.err.println("Could not write to MISO");
			e.printStackTrace();
		} finally {

			try {
				miso.close();
			} catch (IOException e) {
				System.err.println("Could not close MISO");
				e.printStackTrace();
			}
		}
	}

	private void createEmptyFile() {
		File misoFile = new File(path);
		if (!misoFile.exists()) {
			try {
				misoFile.createNewFile();
			} catch (IOException e) {
				System.err.println("Could not create empty MISO");
				e.printStackTrace();
			}
		}
	}

}
