package bookstore;

import com.qsd.bookstore.dto.UserByLogin;
import com.qsd.bookstore.util.JwtUtil;
import com.qsd.bookstore.vo.ShopVo;

/**
 * @Description 
 * @Author Esion
 * @Data 2020年6月12日
 */

public class Test {
	
	public static void main(String[] args){
//		String sign = JwtUtil.sign(new UserByLogin("admin", "123456"));
//		System.out.println(sign);
//		boolean verify = JwtUtil.verify(sign);
//		System.out.println(verify);
		System.out.println(new ShopVo(200, "success").toJSONString());
	}
	
}
