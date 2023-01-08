package tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import main.gui.jMineralCalc;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class XLSfile {

	public XLSfile(){
	
	//aggiunto prova file excel
	
	
	HSSFWorkbook workbook = new HSSFWorkbook();
	
	HSSFSheet sheet = workbook.createSheet("test1");
	//Create a new row in current sheet
	Row row = sheet.createRow(0);
	//Create a new cell in current row
	Cell cell = row.createCell(0);
	//Set value to new value
	cell.setCellValue("primo valore testuale");
	try {
		workbook.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 try {
            FileOutputStream out = new FileOutputStream(new File("exit.xls"));
            workbook.write(out);
            out.close();
            jMineralCalc.getConsole().println("Excel written successfully..");
             
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	
	//fine prova
	 
	}
	
	
	public void addALine(){
		
		}
	
}
