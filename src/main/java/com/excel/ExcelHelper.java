package com.excel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.entity.ExcelEntity;

public class ExcelHelper 
{

	 public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  static String[] HEADERs = { "Id", "Name", "Email", "Password" };
	  static String SHEET = "ExcelEntity";

	  public static boolean hasExcelFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }

	  public static ByteArrayInputStream tutorialsToExcel(List<ExcelEntity> excel) {

	    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
	      Sheet sheet = workbook.createSheet(SHEET);

	      // Header
	      Row headerRow = sheet.createRow(0);

	      for (int col = 0; col < HEADERs.length; col++) {
	        Cell cell = headerRow.createCell(col);
	        cell.setCellValue(HEADERs[col]);
	      }

	      int rowIdx = 1;
	      for (ExcelEntity excelentity : excel) 
	      {
	        Row row = sheet.createRow(rowIdx++);

	        row.createCell(0).setCellValue(excelentity.getId());
	        row.createCell(1).setCellValue(excelentity.getEmail());
	        row.createCell(2).setCellValue(excelentity.getName());
	        row.createCell(3).setCellValue(excelentity.getPassword());
	      }

	      workbook.write(out);
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (Exception e) {
	      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
	    }
	  }

	  public static List<ExcelEntity> excelToTutorials(InputStream is) 
	  {
	    try 
	    {
	      Workbook workbook = new XSSFWorkbook(is);

	      Sheet sheet = workbook.getSheet(SHEET);
	      Iterator<Row> rows = sheet.iterator();

	      List<ExcelEntity> tutorials = new ArrayList<ExcelEntity>();

	      int rowNumber = 0;
	      while (rows.hasNext()) 
	      {
	        Row currentRow = rows.next();

	        // skip header
	        if (rowNumber == 0) 
	        {
	          rowNumber++;
	          continue;
	        }

	        excel<Cell> cellsInRow = currentRow.iterator();

	        ExcelEntity ex = new ExcelEntity();

	        int cellIdx = 0;
	        while (cellsInRow.hasNext())
	        {
	          Cell currentCell = cellsInRow.next();

	          switch (cellIdx) {
	          case 0:
	        	  ex.setId((int) currentCell.getNumericCellValue());
	            break;

	          case 1:
	        	  ex.setEmail(currentCell.getStringCellValue());
	            break;

	          case 2:
	        	  ex.setName(currentCell.getStringCellValue());
	            break;

	          case 3:
	        	  ex.setPassword(currentCell.getStringCellValue());
	            break;

	          default:
	            break;
	          }

	          cellIdx++;
	        }

	        tutorials.add(ex);
	      }

	      return tutorials;
	    } catch (Exception e) {
	      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
	    }
	  }
	}  

