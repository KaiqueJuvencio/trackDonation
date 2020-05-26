package com.br.trackDonation.helper;

import java.io.File;
import java.io.IOException;

public class FileHelper {
	private String directory = "C:\\Users\\kaiqu\\Desktop\\trackDonation";

	public void visualizarArquivos() throws IOException {
		String[] tempArray;
		File file = new File(directory);
		File afile[] = file.listFiles();
		int i = 0;
		for (int j = afile.length; i < j; i++) {
			File arquivos = afile[i];
			String text = arquivos.getName().toString();
			tempArray = text.split("\\.");
			System.out.println(arquivos.getName() + tempArray[0]);
		}

	}
	
	public String verifiedDonationPhoto(String donationNumber) throws IOException {
		String[] fileNameWithoutExtension;
		File file = new File(directory);
		File afile[] = file.listFiles();
		int i = 0;
		for (int j = afile.length; i < j; i++) {
			File files = afile[i];
			String fileNameStr = files.getName().toString();
			fileNameWithoutExtension = fileNameStr.split("\\.");
			if (donationNumber.equals(fileNameWithoutExtension[0])) {
				System.out.println(files.getName());
				return files.getName();
			}
		}
		return "Não encontrado";
	}
}
