
import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
public class JxlReader {

	public static void main(String[] args) {
		//member.xls 파일의 내용을 읽어서 출력
		
		try {
			//WorkBook 찾는다(읽기)
			//			String path = "D:\\study_java\\workspace\\External\\member.xls";
			Workbook workbook = Workbook.getWorkbook(new File("member.xls"));
			
			//Worksheet 찾는다(읽기)
			Sheet sheet = workbook.getSheet(0);
			
			//Cell 찾는다(읽기)
			int i = 0;
			while(true){
				try {
					Cell cell = sheet.getCell(0,i);
					System.out.println(cell.getContents());
					i++;
				} catch (Exception e) {
//					e.printStackTrace();
					break;
				}
			}
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}//main()
}//class
