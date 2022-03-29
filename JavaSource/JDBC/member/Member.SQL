-- JAVA 에서의 DB 편집기
--		Window - Show View - Other - (Data Management _ Data Source Explorer) - DB CONNECTION 정보 입력 (버전, Host 서버주소 , url, id, password)

-- JAVADB 실슬용 계정

-- TEST

CREATE TABLE emp(
    empno number(2));

DROP TABLE emp;

-- 제약조건 확인 SQL
    SELECT * FROM user_constraints;

-- MEMBER 의 ID SEQUENCE
CREATE SEQUENCE member_seq;

-- MEMBER 테이블
    -- JAVA 서비스에서 MEMBER 를 관리할 TABLE
CREATE TABLE member(
    id NUMBER(8) CONSTRAINT member_pk PRIMARY KEY,
    name VARCHAR2(20) NOT NULL,
    addr VARCHAR2(50) NOT NULL,
    email VARCHAR2(30) NOT NULL,
    age NUMBER(3));
    
SELECT * FROM member;

