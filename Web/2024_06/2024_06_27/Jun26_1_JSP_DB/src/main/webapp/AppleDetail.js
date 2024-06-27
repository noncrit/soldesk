function goAppleDetail(origin){
	
	location.href="AppleDetailController?a_ORIGIN="+origin;

}

function deleteApple(origin){
	let t = confirm(`${origin} 사과 정말 지우실건가요?`);
	
	if(t){
		location.href="AppleDeleteController?a_ORIGIN="+origin;
	}
}
