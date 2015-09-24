import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;



public class JxlWriter01 {

	public static void main(String[] args) {
		//data01.xls 파일에 기록
		try {
			//Workbook 생성 → File 생성
			WritableWorkbook wb = Workbook.createWorkbook(new File("data01.xls"));
			
			//Worksheet 생성
			WritableSheet ws1 = wb.createSheet("Test01", 0); //0번시트에 Test01 이라는 이름을 주겠다
			WritableSheet ws2 = wb.createSheet("Test02", 1); //1번시트에 Test02 이라는 이름을 주겠다
			WritableSheet ws3 = wb.createSheet("Test03", 2); //2번시트에 Test03 이라는 이름을 주겠다
			
			//Cell 생성
			for (int i = 0; i < 100; i++) {
				Label label = new Label(0, i, "Data" + i);
				ws1.addCell(label);
				//ws2.addCell(label);
				//ws3.addCell(label);
			}
			wb.write();
			wb.close();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//main()
}//class
