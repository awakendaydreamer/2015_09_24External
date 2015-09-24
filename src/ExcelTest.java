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
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
