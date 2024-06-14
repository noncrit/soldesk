/*alert('연겱');*/

/*
	DialogBox(대화상자...?)
	alert, prompt, comfirm
	
	alert	: 일방적인 경고창, 어떤 메세지를 보여주는 기능
	alert('경고!');
	
	prompt	: 값을 입력받을 수 있음, 사용자에게 메세지를 보여주고 값을 입력받는 기능
	let name = prompt("이름을 입력하세요.");
	alert('안녕하세요, ${name}님 곧 퇴근입니다 ^^');
	alert(`안녕하세요, ${name}님 곧 퇴근입니다 ^^`);	//따옴표가 아니라 ` 백틱 써야 인식함
	
	prompt에 값을 넣지 않고 취소를 하면? => ${name} NULL이 그냥 출력됨
	값을 넣지 않을 경우를 대비해서 default 값을 넣어줄 수 있음 => 안내를 하거나 힌트를 주는 역할
	파라미터를 2개를 받을 수 있음( 보여줄 메세지, 입력받을 default 값)
	ex)
	let reservation = prompt("예약일을 입력해주세요.", "2024-06-");
	
	confirm	: 확인 받는 용도의 박스, 사용자에게 무언가 확인받기 위한 기능
	값	: 확인=>true / 취소=>false
	
	Dialog의 단점
	1. 박스가 떠있는 동안은 코드가 해당 줄에서 머무르게됨(코드 진행이 안됨)
	2. 스타일링 불가능! (위치, 모양을 정해줄 수 없음)
	3. 브라우저마다 박스창 모양이 다르다...
	
	=> 속도가 빠르고 간단하게 적용 할 수 있는 장점이 있어서 광범위하게 많이 쓰임
	

/*alert('경고!');*/

let name = prompt("이름을 입력하세요.");

alert(`안녕하세요, ${name}님 곧 퇴근입니다 ^^`);

let reservation = prompt("예약일을 입력해주세요.", "2024-06-");

let isAdult = confirm("당신은 성인입니까?");
alert(isAdult);

