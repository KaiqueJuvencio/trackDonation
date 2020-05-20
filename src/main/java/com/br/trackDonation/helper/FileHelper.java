package com.br.trackDonation.helper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileHelper {
	private String diretorio = "C:\\projetos\\trackDonation\\pictures";

	public void visualizarArquivos() throws IOException {
		String[] tempArray;
		File file = new File(diretorio);
		File afile[] = file.listFiles();
		int i = 0;
		for (int j = afile.length; i < j; i++) {
			File arquivos = afile[i];
			String text = arquivos.getName().toString();
			tempArray = text.split("\\.");
			System.out.println(arquivos.getName() + tempArray[0]);
		}

	}
}
