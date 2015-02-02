package com.ryabokon.pie.api.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class HardwareService {

	private String path = "/dev/spidev0.0";
	private FileOutputStream miso = null;

	public HardwareService() {
		try {
			miso = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			System.err.println("Could not open MISO for write");
		}
	}

	public HardwareService(String customPath) {
		this();
		this.path = customPath;
		createEmptyFile(path);

	}

	public void sendData(byte[] data) {
		try {
			miso.write(data);
			miso.flush();
		} catch (IOException e) {
			System.err.println("Could not write to MISO");
			e.printStackTrace();
		}
	}

	private void createEmptyFile(String path) {
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
