import java.io.File;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class JxlWriter02 {

	public static void main(String[] args) {
		// data02.xls 파일 생성 → 5개의 열에 내용을 입력, 서식적용
		try {
			//Workbook, Worksheet 생성
			WritableWorkbook wb = Workbook.createWorkbook(new File("data02.xls"));
			WritableSheet ws = wb.createSheet("member", 0);
			
			//엑셀파일 작성시 서식지정
			WritableCellFormat dataFormat = new WritableCellFormat();
			dataFormat.setAlignment(Alignment.CENTRE); //수평 가운데 맞춤
			dataFormat.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.RED);//테두리선
			dataFormat.setBackground(Colour.IVORY);	//셀 배경
			
			//열 너비 지정
			ws.setColumnView(3, 20);	//D열의 너비(ADDR)
			ws.setColumnView(4, 20); 	//E열의 너비(TEL)
			
			//입력자료 정의
			String[][] data = new String[][]{
					{"NUM", "NAME","AGE", "ADDR", "TEL"},
					{"1", "홍길동", "33", "광주시 서구 광천동", "010-1111-1111"},
					{"2", "박문수", "44", "광주시 남구 봉선동", "010-2222-2222"},
					{"3", "이순신", "55", "광주시 북구 용봉동", "010-3333-3333"}
			};
			
			//셀에 자료 입력(쓰기)
			for (int row = 0; row < data.length; row++) {
				for (int col = 0; col < data[row].length; col++) {
					Label label = new Label(col, row, data[row][col], dataFormat);
					ws.addCell(label);
				}
			}
			wb.write();
			wb.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
