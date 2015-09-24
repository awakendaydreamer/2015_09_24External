import java.io.FileInputStream;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ExcelTest {

	public static void main(String[] args) {
		String path = "D:\\study_java\\workspace\\External\\member.xls";
		HSSFWorkbook wb = null;	//워크북(파일) 클래스
		HSSFSheet ws = null;	//워크시트 클래스
		HSSFRow row = null;		//행
		HSSFCell cell = null;	//열(행과 열의 교차점)
		
		try {
			FileInputStream fis = new FileInputStream(path);
			wb = new HSSFWorkbook(fis);	//엑셀 파일과 연동
			fis.close();
			ws = wb.getSheetAt(0);	//워크북에서 첫번째 시트를 읽는다.
			String[] data = new String[5];
			if (ws != null) {
				int sRow = 1;					//시작행(원래 index는 0부터 시작) : 제목행을 제외하고 가져오자
				int eRow = ws.getLastRowNum();	//마지막행
				System.out.println("번호 \t 이름 \t 나이 \t 주소 \t\t 전화번호");
				int sCol = 0;					//시작열(첫번째 항목)
				int eCol = ws.getRow(0).getLastCellNum();	//마지막열(행우선이므로 행을 먼저 가져오고 열을 가져온다)
				
				
				for (int i = sRow; i < eRow; i++) {		//행
					row = ws.getRow(i);
					for (int j = sCol; j < eCol; j++) {	//열
						cell = row.getCell(j);
						if (cell == null) {	//셀이 비워있으면 다음 반목문을 실행(다음셀로 이동)
							continue;
						}else{	//값이 입력되어 있으면, 셀에 입력된 데이터의 타입을 확인(문자, 수치)
							int type = cell.getCellType();	//셀의 데이터 타입이 숫자면 0을 리턴
							if (type == 0) {
								data[j] = (int)cell.getNumericCellValue()+"";	//수치형의 자료 → 문자형변환("")
							}else{
								data[j] = cell.getStringCellValue();	//문자형의 자료는 셀에 입력된 값을 그대로 가져와라
							}//if
						}//if
					}//for j

					for (String str : data) {
						System.out.print(str + "\t");
					}
					System.out.println();
				}//for i
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
