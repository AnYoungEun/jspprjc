/*function f1(){
	alert(this);
}

new f1();*/


function NoticeDao(){
	
}

NoticeDao.prototype = {
	getNotices : function(page,callback){
		var oReq = new XMLHttpRequest();
		if(oReq) {

			oReq.onreadystatechange = function(){
				if (oReq.readyState == 4) {

					var data2 = 1;
					var data = eval(oReq.responseText);
					callback(data, data2);
					//console.log(oReq.responseText);
				}
			}

			oReq.open("GET", "data.jsp?p="+page, true);   /*false면 동기 true면 비동기 */ 
			oReq.send();
			
		}
	}
};

var noticeDao = new NoticeDao();
noticeDao.getNotices(1,function(data, data2){
	alert(data2);
	alert(data[1].title);
});
/*function Exam(){
	this.kor = 0;
	this.eng = 0;
	this.math = 0;
	
	this.total = function(){
		return this.kor + this.eng + this.math;
	}
	this.avg = function(){
		return this.total()/3;
	}
}

Exam.prototype = {
	cnt : 0,
	total : function(){
		this.cnt++;
		return this.kor + this.eng + this.math;
	},
	
	avg : function(){
		return this.total() / 3;
	}
}

var ex1 = new Exam();
ex1.kor = 30;
ex1.eng = 40;
ex1.math = 50;
ex1.total();
alert(ex1.cnt);

var ex2 = new Exam();
ex2.kor = 30;
ex2.eng = 40;
ex2.math = 50;
ex2.total();
alert(ex1.cnt);

var ex3 = new Exam();
ex3.kor = 30;
ex3.eng = 40;
ex3.math = 50;
ex3.total();
alert(ex1.cnt);*/