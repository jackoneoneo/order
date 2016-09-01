package team.waibao.util;

import java.util.HashMap;
import java.util.Map;

public class StoreType {

	private static final String  typeOne = "快餐便当";
	private  static final String  typeTwo = "小吃夜宵";
	private static final String  typeThree = "甜品饮食";
	private static final String  typefour = "果蔬生鲜";
	private  static final String  typefifth = "特色菜系";
	private static final String  typeSix = "异国料理";
	
	private static Map<Integer,String> typeMap = new HashMap<Integer,String>();
	public static String getStoreType(int id){
		initTypeMap(typeMap);
		if(typeMap.get(id) != null)
			return typeMap.get(id);
		else
			return "";
	}

	private static void initTypeMap(Map<Integer,String> typeMap) {
		
		typeMap.put(1,typeOne );
		typeMap.put(2,typeTwo);
		typeMap.put(3,typeThree);
		typeMap.put(4,typefour );
		typeMap.put(5,typefifth);
		typeMap.put(6,typeSix);
	}
	
}
