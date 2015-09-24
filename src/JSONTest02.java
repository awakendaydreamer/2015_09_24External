import java.util.ArrayList;
import java.util.HashMap;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.tjo.excel.ExcelDTO;


public class JSONTest02 {

	public static void main(String[] args) {
		ExcelDTO dto1 = new ExcelDTO(10, "박문수", 55, "광주광역시 서구 광천동", "010-5555-5555");
		ExcelDTO dto2 = new ExcelDTO(20, "이순신", 44, "광주광역시 서구 광천동", "010-5555-5555");
		ExcelDTO dto3 = new ExcelDTO(30, "홍길동", 33, "광주광역시 서구 광천동", "010-5555-5555");
		
		ArrayList<ExcelDTO> list = new ArrayList<ExcelDTO>();
		list.add(dto1);
		list.add(dto2);
		list.add(dto3);
		
		JSONArray arr = JSONArray.fromObject(list);
		System.out.println(arr.toString());
		System.out.println("===========================================================");
		
		for (int i = 0; i < arr.size(); i++) {	//JSONArray size
			JSONObject jobj = arr.getJSONObject(i);
			ExcelDTO dto = (ExcelDTO)JSONObject.toBean(jobj, ExcelDTO.class);
			System.out.print(dto.getNum() + "\t");
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getAge() + "\t");
			System.out.print(dto.getAddr() + "\t");
			System.out.println(dto.getTel());
			
		}
		System.out.println("===========================================================");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("member", arr);
		JSONObject obj = JSONObject.fromObject(map);
		JSONArray jrr = obj.getJSONArray("member");
		System.out.println(map.toString());
		System.out.println("===========================================================");
		
		for (int i = 0; i < jrr.size(); i++) {	//JSONArray size
			JSONObject jobj = jrr.getJSONObject(i);
			ExcelDTO dto = (ExcelDTO)JSONObject.toBean(jobj, ExcelDTO.class);
			System.out.print(dto.getNum() + "\t");
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getAge() + "\t");
			System.out.print(dto.getAddr() + "\t");
			System.out.println(dto.getTel());
		}
		System.out.println("===========================================================");
	}//main()
	
}
