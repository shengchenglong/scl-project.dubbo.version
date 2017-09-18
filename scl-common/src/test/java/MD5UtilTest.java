import org.junit.Test;

import com.scl.utils.MD5Util;

/**
 * 
 * ClassName: MD5UtilTest<br/>
 * Function: TODO ADD CLASS.<br/>
 * Date: 2017年2月10日 下午2:54:02<br/>
 * 
 * @author shengchenglong 
 * @version 
 * @since JDK 1.8
*
 */
public class MD5UtilTest {
	
	@Test
	public void test() {
		System.out.println(MD5Util.getMD5("scl9402212525"));
		System.out.println(MD5Util.bytesToHex("1BE61C0F1E5382154FC5AFE9C47445FF".getBytes()));
	}

}
