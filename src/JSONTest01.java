import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.tjo.excel.ExcelDTO;


public class JSONTest01 {

	public static void main(String[] args) {
		ExcelDTO dto1 = new ExcelDTO(10, "박문수", 55, "광주광역시 서구 광천동", "010-5555-5555");
		ExcelDTO dto2 = new ExcelDTO(20, "이순신", 44, "광주광역시 서구 광천동", "010-5555-5555");
		ExcelDTO dto3 = new ExcelDTO(30, "홍길동", 33, "광주광역시 서구 광천동", "010-5555-5555");

		JSONArray arr = new JSONArray();
		
		JSONObject obj = new JSONObject();
		obj.put("member", dto1);
		arr.add(obj);
		
		obj = new JSONObject();
		obj.put("member", dto2);
		arr.add(obj);
		
		obj = new JSONObject();
		obj.put("member", dto3);
		arr.add(obj);
		
		String json = arr.toString();
		System.out.println(json);
		System.out.println("===========================================================");
		
		for (int i = 0; i < arr.size(); i++) {	//JSONArray size
			JSONObject jobj = arr.getJSONObject(i);
			jobj = jobj.getJSONObject("member");
			ExcelDTO dto = (ExcelDTO)JSONObject.toBean(jobj, ExcelDTO.class);
			System.out.print(dto.getNum() + "\t");
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getAge() + "\t");
			System.out.print(dto.getAddr() + "\t");
			System.out.println(dto.getTel());
		}
		System.out.println("===========================================================");
	}//main()
}//class
