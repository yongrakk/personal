DROP TABLE c1member;
DROP TABLE c1board;
DROP TABLE playlist;
DROP TABLE comments;
DROP TABLE c1reply;
DROP SEQUENCE c1board_seq;
DROP SEQUENCE c1reply_seq;
DROP SEQUENCE comments_seq;
CREATE TABLE c1member(
    userid varchar2(100) PRIMARY KEY
    ,userpwd varchar2(100) NOT NULL
    ,username varchar2(100) NOT NULL
    ,useremail varchar2(100) NOT NULL
    );
    
CREATE TABLE c1board(
boardnum NUMBER PRIMARY KEY
,userid varchar2(100) NOT NULL
,title varchar2(200) NOT NULL
,boardtext varchar2(2000) NOT NULL
,hitcount number default 0
,regdate date default sysdate 
,originalfile varchar2(200) 
,savedfile varchar2(100)
);
CREATE TABLE playlist(
playlistnum number PRIMARY KEY
,userid varchar2(100) NOT NULl
,playlisttitle varchar2(300) NOT NULL
,thumnail varchar2(300) NOT NULL
,videoid varchar2(300) NOT NULL
);
CREATE TABLE c1reply(
replynum number PRIMARY KEY
,boardnum number NOT NULL
,userid varchar2(100) NOT NULL
,replytext varchar2(1000) NOT NULL
,regdate date default sysdate 
);
CREATE TABLE comments(
commentsnum number PRIMARY KEY
,username varchar2(100) NOT NULL
,useremail varchar2(100) NOT NULL
,regdate date default sysdate 
,commenttext varchar2(2000) NOT NULL
);
CREATE SEQUENCE comments_seq;
CREATE SEQUENCE c1board_seq;
CREATE SEQUENCE c1reply_seq;

INSERT INTO c1member values(
'myid' , '1234', '사용자' ,'abcd@gogo.com');

INSERT INTO comments values(
comments_seq.nextval, '방문자1' , 'visit@first.com',sysdate, 'Its a Funny Page !! I reallay interesting them!');

COMMIT;