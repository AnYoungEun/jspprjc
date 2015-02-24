function printresult(){
	var x,y;
	
	x = prompt("x값", 0);
	y = prompt("y값", 0);
	
	x = parseInt(x);
	y = parseInt(y);
	
	var btnPrint = document.getElementById("btn-print");
	btnPrint.value = x+y; // document 컨테이너에서 꺼내씀
}
// resultsss.onclick = printresult; // rewult가 정의되지않았다고 오류남

function init(){ //초기화 함수
	
	var btnPrint = document.getElementById("btn-print");
	btnPrint.onclick = printresult;
}

window.onload = init; // body부분이 로드된후 init를 실행하겠음