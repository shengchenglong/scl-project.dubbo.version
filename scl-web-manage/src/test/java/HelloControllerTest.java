import com.alibaba.dubbo.config.annotation.Reference;
import com.scl.user.domain.SysUser;
import com.scl.user.service.SysUserService;
import com.scl.utils.UuidUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.scl.ApplicationBootStrap;
import com.scl.resultType.MsgBean;

/**
 * 
 * @author shengchenglong
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationBootStrap.class)
@WebAppConfiguration
public class HelloControllerTest {

	private TestRestTemplate template = new TestRestTemplate();

	@Reference(group = "user")
	private SysUserService sysUserService;
	
	public int port = 8082;

	@Test
	public void test1() {
		String url = "http://localhost:" + port + "/user/resource/doEdit";
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("id", "1");
		map.add("name", "name");
		map.add("code", "code");
		map.add("type", "button");
		map.add("url", "//");
		map.add("permission", "//");
		map.add("parentCode", "resource");
		MsgBean result = template.postForObject(url, map, MsgBean.class);
		System.out.println(result);
	}


	public void addUser() {
		SysUser user = new SysUser();
		user.setId(UuidUtil.generateID());
		user.setIsDelete(0);
		user.setIsLocked(0);
		user.setPassword("");
	}

}
