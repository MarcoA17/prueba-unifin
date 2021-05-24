package com.mast.unifin.sprinboot.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.mast.unifin.sprinboot.model.PedidosFruta;

public class CSVHelper {
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "Id", "Nombre", "Total", "Estatus" };

	public static boolean hasCSVFormat(MultipartFile file) {
		System.out.println(file.getContentType());
		if (TYPE.equals(file.getContentType()) || file.getContentType().equals("application/vnd.ms-excel")) {
			return true;
		}

		return false;
	}

	public static List<PedidosFruta> csvToFrutas(InputStream is) throws ParseException {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<PedidosFruta> pedidoFrutaList = new ArrayList<>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			

			for (CSVRecord csvRecord : csvRecords) {
				PedidosFruta pedidosFruta = new PedidosFruta(Long.parseLong(csvRecord.get("Id")),
						csvRecord.get("Nombre"), Double.parseDouble(csvRecord.get("Total")),
						Boolean.parseBoolean(csvRecord.get("Estatus")));

				pedidoFrutaList.add(pedidosFruta);
			}

			return pedidoFrutaList;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

//	public static ByteArrayInputStream tutorialsToCSV(List<DeveloperTutorial> developerTutorialList) {
//		final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
//
//		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
//				CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
//			for (DeveloperTutorial developerTutorial : developerTutorialList) {
//				List<String> data = Arrays.asList(String.valueOf(developerTutorial.getId()),
//						developerTutorial.getTitle(), developerTutorial.getDescription(),
//						String.valueOf(developerTutorial.isPublished()));
//
//				csvPrinter.printRecord(data);
//			}
//
//			csvPrinter.flush();
//			return new ByteArrayInputStream(out.toByteArray());
//		} catch (IOException e) {
//			throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
//		}
//	}
}
