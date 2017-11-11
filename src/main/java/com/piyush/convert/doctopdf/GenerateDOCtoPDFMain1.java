package com.piyush.convert.doctopdf;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hwpf.extractor.WordExtractor;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class GenerateDOCtoPDFMain1 {

	public static void main(String[] args) {

		try {
			String doc = "C:\\Users\\PiyushMittal\\Desktop\\garbage\\tes.doc";
			String pdf = doc.substring(0, doc.lastIndexOf('.') + 1) + "pdf";
			System.out.println(pdf);
			InputStream is = new BufferedInputStream(new FileInputStream(doc));
			WordExtractor wd = new WordExtractor(is);

			String text = wd.getText();

			Document document = new Document();

			System.out.println(" Lok");
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdf));

			document.open();
			document.add(new Paragraph(text));

			document.close();

		} catch (FileNotFoundException e1) {
			System.out.println("File does not exist.");
		} catch (IOException ioe) {
			System.out.println("IO Exception");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}