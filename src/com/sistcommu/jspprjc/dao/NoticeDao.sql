--�Խñ� ��� ��ȸ
select * from notices order by regdate desc; 

--�Խù� ��ȸ
select * from notices where code=134;

--���� �������׿��� ���� ū code ���

	--����Ŭ
select decode(max(to_number(code)),null,0)+1 from notices;
select nvl(max(to_number(code)),0)+1 from notices;

	--����
select isnull(max(cast(code as int)),0)+1 from notices;

--20���� ���� ���ڵ带 ������ ������ �ۼ��Ͻÿ�.
--1������,2������
select * from NOTICES order by regdate desc;
select * from ( select rownum num, N.* from (select * from NOTICES order by regdate desc) N ) where num between 11 and 20;

--sql server
select n.* from (select (row_number() over (order by regdate desc)) num, notices.* from notices) n where n.num between 1 and 10;
select n.* from (select (row_number() over (order by regdate desc)) num, notices.* from notices) n where n.num between 1 and 10;
select n.* from (select (row_number() over (order by regdate desc)) num, notices.* from notices) n where n.num in 5;
select * from notices order by regdate desc;

--������
select top 1 * from notices where regdate > (select regdate from notices where code='237') order by regdate;

--������
select top 1 * from notices where regdate < (select regdate from notices where code='237') order by regdate desc;

delete * from notices;

select*from notices;
insert into notices values('139','����','��������ȣ','����ꤩ��', '2015-02-02', 5)

select count(*) from notices;

--sql server ��ȸ��

select * from noticefiles
select (row_number() over (order by regdate desc)) num,notices.* from notices;

select CAST(Code as int)+1 from noticefiles;

select * from members;
insert into members(mid,name,pwd,nicname,birth,email) values('youngeun','�ȿ���','duddms','�����ε�','1993-03-30','ayh303@gmail.com');
delete members where mid='youngeun'






select * from members