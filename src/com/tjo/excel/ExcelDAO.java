package com.tjo.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private ArrayList<ExcelDTO> list = new ArrayList<ExcelDTO>();
	private ExcelDTO dto;
	 
	public ExcelDAO() {
	}
	
	public void fileOutExcel(){
		//
		try {
			conn = SingleConn.getConnect();
			String sql = "select * from member order by num asc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				String tel = rs.getString("tel");
				
				dto = new ExcelDTO(num, name, age, addr, tel);
				list.add(dto);
				System.out.println(num +"\t"+ name +"\t"+ age +"\t"+ addr +"\t"+ tel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Excel File 생성단계
		Workbook wb = new HSSFWorkbook();//apach꺼로 workbook 생성 임포트시키기
		Sheet ws = wb.createSheet("member");	//apach꺼로 worksheet 생성
		Row row = null;
		Cell cell = null;
		
		row = ws.createRow(0);
		cell = row.createCell(0);//A열
		cell.setCellValue("NUM");
		cell = row.createCell(1);//B열
		cell.setCellValue("NAME");
		cell = row.createCell(2);//C열
		cell.setCellValue("AGE");
		cell = row.createCell(3);//D열
		cell.setCellValue("ADDR");
		cell = row.createCell(4);//E열
		cell.setCellValue("TEL");
		for (int i = 0; i < list.size(); i++) {
			row = ws.createRow(i + 1);//2행
			cell = row.createCell(0);//A열
			cell.setCellValue(list.get(i).getNum());
			cell = row.createCell(1);//B열
			cell.setCellValue(list.get(i).getName());
			cell = row.createCell(2);//C열
			cell.setCellValue(list.get(i).getAge());
			cell = row.createCell(3);//D열
			cell.setCellValue(list.get(i).getAddr());
			cell = row.createCell(4);//E열
			cell.setCellValue(list.get(i).getTel());
		}
		
		try {
			File file = new File("fileOutExcel.xls");
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//fileOutExcel()
	
	
	
	
}//class
