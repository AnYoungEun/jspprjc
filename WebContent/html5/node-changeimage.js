function init(){ //초기화 함수
	
	var CImage = document.getElementById("change-image");
	
	CImage.onclick = changeImage;
}

function changeImage(){
	var img1 = document.getElementById("img1");
	var IN1 = document.getElementById("in1");
	var Style = document.getElementById("style");
	
	img1.src = IN1.value;
	img1.style.borderWidth = Style.value;
}

window.onload = init; // body부분이 로드된후 init를 실행하겠음