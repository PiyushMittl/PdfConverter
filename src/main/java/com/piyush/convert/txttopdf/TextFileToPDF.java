package com.piyush.convert.txttopdf;

import java.io.*;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class TextFileToPDF {

	/*
	 * ex. java TextFileToPDF c:\temp\text.txt c:\temp\text.pdf
	 */
	public static void main(String[] args) {
		BufferedReader input = null;
		Document output = null;

		/*
		 * String src="C:\\Users\\PiyushMittal\\Desktop\\garbage\\efax.txt";
		 * String des=ClassLoader.getSystemResource("textTOpdf.pdf").getPath();
		 */
		String src = "C:\\home\\test.txt";
		String des = "C:\\home\\testpdf.pdf";

		// ClassLoader.getSystemResource("textTOpdf.pdf");

		System.out.println("Convert text file to pdf");
		System.out.println("input  : " + src);
		System.out.println("output : " + des);
		try {
			// text file to convert to pdf as args[0]
			input = new BufferedReader(new FileReader(src));
			// letter 8.5x11
			// see com.lowagie.text.PageSize for a complete list of page-size
			// constants.
			// new Document(PageSize.A4, 36, 72, 108, 180);
			output = new Document(PageSize.LETTER, 40, 40, 40, 40);
			// pdf file as args[1]
			PdfWriter.getInstance(output, new FileOutputStream(des));

			output.open();
			output.addAuthor("RealHowTo");
			output.addSubject(src);
			output.addTitle(src);

			String line = "";
			while (null != (line = input.readLine())) {
				System.out.println(line);
				Paragraph p = new Paragraph(line);
				p.setAlignment(Element.ALIGN_JUSTIFIED);
				output.add(p);
			}
			System.out.println("Done.");
			output.close();
			input.close();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}