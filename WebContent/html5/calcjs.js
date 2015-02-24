function init(){ //초기화 함수
	
	var btnSum = document.getElementById("btn-sum");
	btnSum.onclick = btnSumClick;
}

function btnSumClick(){
	var txtX = document.getElementById("txt-x");
	var txtY = document.getElementById("txt-y");
	var txtSum = document.getElementById("txt-sum");
	
	tempSum = parseInt(txtX.value)+parseInt(txtY.value);
	txtSum.value = tempSum; 
}

window.onload = init; // body부분이 로드된후 init를 실행하겠음