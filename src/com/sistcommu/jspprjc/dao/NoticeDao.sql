--게시글 목록 조회
select * from notices order by regdate desc; 

--게시물 조회
select * from notices where code=134;

--현재 공지사항에서 가장 큰 code 얻기

	--오라클
select decode(max(to_number(code)),null,0)+1 from notices;
select nvl(max(to_number(code)),0)+1 from notices;

	--시퀄
select isnull(max(cast(code as int)),0)+1 from notices;

--20개씩 나눈 레코드를 얻어오는 쿼리를 작성하시오.
--1페이지,2페이지
select * from NOTICES order by regdate desc;
select * from ( select rownum num, N.* from (select * from NOTICES order by regdate desc) N ) where num between 11 and 20;

--sql server
select n.* from (select (row_number() over (order by regdate desc)) num, notices.* from notices) n where n.num between 1 and 10;
select n.* from (select (row_number() over (order by regdate desc)) num, notices.* from notices) n where n.num between 1 and 10;
select n.* from (select (row_number() over (order by regdate desc)) num, notices.* from notices) n where n.num in 5;
select * from notices order by regdate desc;

--이전글
select top 1 * from notices where regdate > (select regdate from notices where code='237') order by regdate;

--다음글
select top 1 * from notices where regdate < (select regdate from notices where code='237') order by regdate desc;

delete * from notices;

select*from notices;
insert into notices values('139','루룰루','하히후헤호','루루루룰ㄹ룰', '2015-02-02', 5)

select count(*) from notices;

--sql server 조회문

select * from noticefiles
select (row_number() over (order by regdate desc)) num,notices.* from notices;

select CAST(Code as int)+1 from noticefiles;

select * from members;
insert into members(mid,name,pwd,nicname,birth,email) values('youngeun','안영은','duddms','영은인데','1993-03-30','ayh303@gmail.com');
delete members where mid='youngeun'






select * from members