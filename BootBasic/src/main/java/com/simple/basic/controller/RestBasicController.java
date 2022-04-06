package com.simple.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simple.basic.command.RestVO;

@RestController
public class RestBasicController {
	
	//프로듀스 해당타입으로 사용자에게 응답하겟다는뜻
	@GetMapping( value = "/hello", produces = "text/plain; charset=utf-8" )
	public String hello() {
		
		System.out.println("rest api실행됨");
		
		return "안뇽?";
	}
	
	//produces생략하면 기본으로 json형식을 가짐
	//jackson-databind라이브러리 필수 (부트에는 기본으로 라이브러리를 가지고있음)
	@GetMapping( value =  "/getObject", produces = "application/json; charset=utf-8" )
	public RestVO getObject() {
		
		return new RestVO(1, "홍길동", "테스트"); 
	}
	
	@GetMapping("/getCollection")
	public ArrayList<RestVO> getCollection() {
		
		ArrayList<RestVO> list = new ArrayList<>();
		
		for(int i =1; i <= 10; i++) {
			RestVO vo = RestVO.builder().num(1)
										.name("홍길동" + i)
										.id("test" + i)
										.build();
			list.add(vo);
		}
		
		return list;
		
	}
	
	//map의 형태로 반환
	@GetMapping("/getMap")
	public HashMap<String, Object> getMap() {
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("msg", "성공!");
		map.put("data", new RestVO(1, "홍길동", "test"));
		
		return map;
		
	}
	
	///////////데이터를 받는 방법////////////////////
	
	//http:/localhost:8181/getData?key=홍길동&bno=1
	//get방식으로 데이터를 받음
	//리퀘스트파람은 데이터를 필수값으로 넘겨줘야 함
	@GetMapping("/getData")
	public RestVO getData( @RequestParam("key") String key,
						   @RequestParam("bno") int bno) {
		
		System.out.println(key);
		System.out.println(bno);
		
		return new RestVO(1, "홍길동", "테스트");
		
	}
	
	//http:/localhost:8181/getPath/asc/desc/1
	//get방식으로 데이터를 받음
	//url주소의 /값/값/값 형태로 받음
	@GetMapping("/getPath/{sort}/{rank}/{page}")
	public RestVO getPath( @PathVariable("sort") String sort,
						   @PathVariable("rank") String rank,
						   @PathVariable("page") String page) {
		
		System.out.println(sort);
		System.out.println(rank);
		System.out.println(page);
		
		return new RestVO(1, "홍길동", "테스트");
		
	}
	
	//post방식은 @requestbody으로 json을 매핑
	//데이터를 보낼때(화면에서) 해당형식을 반드시 기술.
	@PostMapping("/getJSON")
	public RestVO getJSON(@RequestBody RestVO vo) {
		
		System.out.println(vo.toString());
		
		return new RestVO(1, "홍길동", "테스트");
	}
	
	//post방식 - map을 통해 받기
	@PostMapping("/getResult")
	public RestVO getResult(@RequestBody HashMap<String, Object> map) {
		
		System.out.println(map.toString());
		
		return new RestVO(1, "홍길동", "테스트");
	}
	
	@PostMapping(value = "/getResult2", consumes = "text/plain")
	public RestVO getResult(@RequestBody String data) {

		System.out.println(data);
		
		return new RestVO(1, "홍길동", "테스트");
	}
	
	///////////응답 문서를 직접선언////////////////
	@PostMapping("/createResponse")
	public ResponseEntity<RestVO> createResponse(@RequestBody HashMap<String, Object> map) {
		
		System.out.println(map.toString());
		
		RestVO vo = new RestVO(1, "홍길동", "테스트"); //데이터
		HttpHeaders headers = new HttpHeaders(); //헤더
		headers.add("Authorization", "JSON WEB TOKEN");
		headers.add("Access-Control-Allow-Origin", "true");

		
		ResponseEntity<RestVO> res = new ResponseEntity<RestVO>(vo, headers, HttpStatus.OK); //(데이터,headers,상태)
		
		
		return res;
	}
	
	/////////////////
	//jquery학습후 restAPI확인
	
	//produce - json형식으로 보낸다
//	@CrossOrigin("*")
//	@CrossOrigin("http://127.0.0.1:5501") //post방식은 ip:port가 동일해야 요청을 허용하는데, 서버가 다르다면 특정서버의 요청을 허용해야 요청처리를 받을수있음
//	@PostMapping(value = "/ajaxTest01", produces = "application/json")
//	public ArrayList<RestVO> ajaxTest01(@RequestBody RestVO vo) {
//		
//		System.out.println(vo.toString());
//		
//		ArrayList<RestVO> list = new ArrayList<>();
//		for(int i = 1; i <= 10; i++) {
//			RestVO t = RestVO.builder()
//							  .name("홍길동" + i)
//							  .id("aa123" + i)
//							  .num(i)
//							  .build();
//			list.add(t);
//		}
//		
//		return list;
//	}
	
	//xml형식으로 반환 - jackson-xml라이브러리 필요함
	@CrossOrigin("http://127.0.0.1:5501") //post방식은 ip:port가 동일해야 요청을 허용하는데, 서버가 다르다면 특정서버의 요청을 허용해야 요청처리를 받을수있음
	@PostMapping(value = "/ajaxTest01", produces = "application/xml")
	public ArrayList<RestVO> ajaxTest01(@RequestBody RestVO vo) {
		
		System.out.println(vo.toString());
		
		ArrayList<RestVO> list = new ArrayList<>();
		for(int i = 1; i <= 10; i++) {
			RestVO t = RestVO.builder()
							  .name("홍길동" + i)
							  .id("aa123" + i)
							  .num(i)
							  .build();
			list.add(t);
		}
		
		return list;
	}
	
	
	
	

}
