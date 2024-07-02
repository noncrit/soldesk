package com.kim.jul021;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		return "home";
	}
	
}

/*
servlet Context.xml
<beans:property name="prefix" value="/WEB-INF/views/" />
<beans:property name="suffix" value=".jsp" />
xml 파일의 beans 태그에서 접두어 /WEB-INF/views/ + 중간경로 "home" + 접미어 .jsp 가 합쳐진 형태로
/WEB-INF/views/home.jsp 라는 views 파일 경로로 이동해서
클라이언트에게 응답을 해주는 형태

@:Annotation
사전적 의미 : 주석
실제 사용하고자 하는 의도 : 코드사이에 주석처럼 쓰이면서도 특정한 기능을 수행
-코드 작성 문법 에러를 체크하도록 정보를 제공
-개발 툴이 코드를 자동으로 생성 할 수 있도록 도와줌
-실행시에 특정한 기능을 수행하도록 도와줌

종류

1. @Bean : 개발자가 직접 제어가 불가능한 외부 라이브러리 등을 Bean으로 만들 때 사용
2. @Autowired : 속성, setter, 생성자에서 사용하며, 타입에 따라서 Bean을 주입해 준다.
3. @Controller : Spring에서의 Controller 역할 - View(화면, jsp)를 return 해주는게 목적
4. @RestController : Controller 중에서 View 쪽으로 응답하지 않는 컨트롤러, data(xml, json 등)을 return 해주는 게 목적
5. @ResponseBody : 자바 객체를 http 요청의 Body 내용으로 매핑시켜주는 역할을 함 / RestController = Controller + ResponseBody
6. @Service : 비즈니스 로직을 수행하는 Class를 나타낼 때 사용
비즈니스 로직 : 사용자 눈에는 안보이지만, 사용자가 원하는 결과물을 올바르게 노출 할 수 있도록 짜여진 코드 (ex M에서 만든 기능들)
7. @xmlRootElement / @xmlElement : OXM(Object Xml Mapping)을 하기 위해 사용
	특정 데이터를 xml 형태로 만들어줌
Object -> xml : 마샬링(Marshalling)
xml -> Object : 언마샬링(Unmashalling)

xmlRootElement : JavaBean 객체의 Class명 위에 명시
xmlElement : JavaBean 객체의 setter에 명시

8. @RequestMapping : 요청에 따라 어떤 Controller, 어떤 Method가 처리될 지 매핑하기 위해서 사용

파라미터
value : 요청받을 주소(url)을 설정
method : 어떤 요청으로 받을지  설정(GET,POST,PUT,DELETE,FETCH)
W3C(표준 개발 기구, World Wide Web Consortium)에서 의구심을 갖기 시작 PUT, DELETE, FETCH 안쓰고도 GET, POST로 구현되는데
굳이 저 친구들을 써야 할까?

8. @RequestParam : 요청 파라미터 설정
*/