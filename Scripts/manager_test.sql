select * from `member`;

desc member;

insert into member
values(2, password('1111'), '짱수린짱', 27, '여자', 'test@test.co.kr');


select id, passwd, name, age, gender, email from member where id = 1 and passwd = password('1111');

insert into member
values('admin', password('1111'), '전수린', 27, '여자', 'admin@test.co.kr');

select id, passwd, name, age, gender, email from member where id = 3 and passwd = password('1111');

select id, passwd, name, age, gender, email from member;

delete from member where id = '4';


update member set id = '2', passwd = password('1111'), name = '짱짱짱수린', age = 54, gender = '여자', email = 'surin@test.co.kr' where id = '2';