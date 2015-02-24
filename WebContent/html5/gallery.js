

/*window.addEventListener("load", function(){
	alert("test2");
});

window.addEventListener("load", function(){
	alert("test1");
});*/

function picClick(){
	alert(event.currentTarget.tagName);
	
	event.stopPropagation(); //버블링, 캡쳐링 막음
	event.preventDefault(); //태그가 가지는 기본행위를 막음

	if(event.target.tagName != "IMG") return; //빈공백 클릭하면 밑의 과정을 수행하지않는다 
	//IE10미만은 tagName대신 nodeName
	
	var img = document.createElement("img");
	img.src = event.target.src;
	img.style.height = "0px";
	
	img.addEventListener("show",function(e){
		alert("show show show")
	});
	
	//var box = document.getElementById("gallery-show-box");
	var box = document.querySelector(".gallery-show-box");
	
	var last;
	while (last = box.lastChild)
		box.removeChild(last);
	
	box.appendChild(img);
	
	move(img, "height", "250px", 1000, linear);
}

function move(target, property, to, duration, easing){
	if(target.style[property] == "")
		target.style[property] = "0px";
	
	var from = parseInt(target.style[property]);
	var to = parseInt(to);
//	to = from + to;  // 있으면 by(누적) 없으면 to(누적아님)
	var start = new Date;
	
	
	var id = setInterval(function(){
		var timePassed = new Date - start;
		var progress = timePassed / duration;
		
		if(progress >1)
			progress = 1;
		
		if(easing)
			target.style[property] = (from+(to-from)*easing(progress))+"px";
		else
			target.style[property] = (from+(to-from)*progress)+"px";
		
		if(progress == 1)
			clearInterval(id);
	},10);
};

function aa(progress){
	return Math.pow(progress,2);
}

function linear(progress){
	return progress;
}
/*function move(target,to){
	if(target.style.left == "")
		target.style.left = "0px";
	
	var from = parseInt(pics.style.left);
	var to = parseInt(to);
	to = to + from;
	
	var id = setInterval(function(){
		from += 1*(to<from ? -1:1);
		
		if(from == to){
			
		}
			clearInterval(id)
			
			pics.style.left = from + "px";
		
	}, 10);
}*/

window.addEventListener("load", function(){
	//var img = document.createElement("img"); //img를 한번만 만들어도 된다 - appendchild가 쌓이게된다 -
	
//	var pics = document.getElementById("gallery-pic-list");
//	var pic1 = document.getElementById("gallery.pic1"); // 구버전의 선택자
	
	var pics = document.querySelector("#gallery-pic-list");
	//var pic1 = document.querySelector("#gallery.pic1");
	
	var prevBtn = document.querySelector(".gallery-prev-button"); //버튼 이벤트
	var nextBtn = document.querySelector(".gallery-next-button");
	
//	pics.onclick = picClick;
	
	/*pics.addEventListener("click",picClick,true);
	pic1.addEventListener("click",picClick,true); // 캡쳐링 과정에서 처리*/
	
	pics.addEventListener("click",picClick,true);
	//pic1.addEventListener("click",picClick,true); // 버블링 과정에서 처리
	
	/*var id=setInterval(function(){
	 애니메이션을 위한 프레임 연산
		if(종료시점)
			clearInterval(id)
	},10);*/
	
	prevBtn.addEventListener("click", function(){
		move(pics, "left", -120, 500, aa);
		
	});
	
	nextBtn.addEventListener("click", function(){
		move(pics, "left", 120, 3000, linear);
	});
	
	/*var pic1 = document.getElementById("gallery.pic1");
	var pic2 = document.getElementById("gallery.pic2");
	var pic3 = document.getElementById("gallery.pic3");
	var pic4 = document.getElementById("gallery.pic4");
	var pic5 = document.getElementById("gallery.pic5");
	
	pic1.onclick = picClick;
	pic2.onclick = picClick;
	pic3.onclick = picClick;
	pic4.onclick = picClick;
	pic5.onclick = picClick;*/
		
});


/*window.addEventListener("load", function(){ // 이벤트 트리거(IE안됨)
	var fileButton = document.getElementById("file-button");
	window.addEventListener("click", function(){
		var event = new MouseEvent("click",{
			"view" : window,
			"bubbles" : true,
			"cancelable" : true
		})
		
		var file = document.getElementById("gallery-file");
		file.dispatchEvent(event);
	});
});*/

window.addEventListener("load", function(){ // 이벤트 트리거 구버전(IE됨)
	//var fileButton = document.getElementById("file-button");
	var fileButton = document.querySelector("#file-button");
	
	fileButton.addEventListener("click", function(){
		var event = document.createEvent("MouseEvent");
		event.initEvent("click",true,true); //event type, bubbles, canclable
		
		var file = document.querySelector("#gallery-file");
		file.dispatchEvent(event);
	});
});





