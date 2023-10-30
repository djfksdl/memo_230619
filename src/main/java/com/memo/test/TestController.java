package com.memo.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.memo.post.mapper.PostMapper;

@Controller
public class TestController {
	@Autowired
	PostMapper postMapper;
	//1. string + response body - >html
	@ResponseBody
	@GetMapping("/test1")
	public String test1() {
		return "hello world";
	}
	
	//2. map + response body -> json
	@ResponseBody
	@GetMapping("/test2")
	public Map<String , Object> test2(){
		Map<String , Object> map = new HashMap<>();
		map.put("a", 100);
		map.put("b", 200);
		return map;
	}
	
	
	//3. JSP -> html
	//build.gradel 2줄 추가
	// 폴더 만들기 src/main/webapp/WEB-INF/jsp
	// application.yml  prifix, suffix
	@GetMapping("/test3")
	public String test3() {
//		src/main/webapp/WEB-INF/jsp
		return "test/test";
	}
	
	//4. DB 연동 resopnse body -> json
	// SnsApplicationDb설정 안보는 설정 제거
	// DatabaeConfig 클래스 추가
	// application.yml DB 접속 정보 추가
	
	// resources/mappers xml
	// logback-spring.xml 추가(쿼리 로그)
	@ResponseBody
	@GetMapping("/test4")
	public List<Map<String, Object>> test4() {
		return postMapper.selectPostList(); // json
	}

}
