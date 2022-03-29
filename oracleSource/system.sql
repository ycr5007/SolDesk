-- SQL 의 특징
    -- SQL 구문은 대소문자 구분이 없다. ( 단, 구분을 위해 SQL 기능 KEYWORD만 대문자로 변경해주는 HOTKEY 가 있다 (CTRL + F7) )
        -- 단, 비밀번호는 대소문자를 구분한다.

-- DCL (DBA 의 권한 관리)

-- hr 사용자의 비밀번호 변경
ALTER USER hr IDENTIFIED BY hr ACCOUNT UNLOCK; -- ACCOUNT UNLOCK : 잠긴 계정을 푼다 ( 연속해서 비밀번호 틀림 ... )

-- Oracle Database 의 특징
    -- 테이블, 인덱스, 뷰 ... 여러가지 객체가 사용자별로 생성되고 관리
    -- 사용자 (스키마 : 데이터베이스 구조 범위)
    
    -- 사용자 생성
        -- CREATE USER id IDENTIFIED BY password;
        CREATE USER test1 IDENTIFIED BY 12345;
    
    -- 사용자 권한 부여 ( 권한 미부여 시 : user TEST1 lacks CREATE SESSION privilege; logon denied )
    -- 권한 관리 (DBA - 시스템 권한)
        -- USER
            -- CREATE USER : 사용자 생성 권한
            -- ALTER USER : 생성된 사용자의 정보 수정 권한
            -- DROP USER : 생성된 사용자의 삭제 권한
        -- SESSION
            -- CREATE SESSION : 데이터베이스 접속 권한
            -- ALTER SESSION : 데이터베이스 접속 상태에서 환경 값 변경 권한
        -- TABLE
            -- CREATE TABLE : 자신의 테이블 생성 권한
            -- CREATE ANY TABLE : 임의의 스키마 소유 테이블 생성 권한
            -- ALTER ANY TABLE : 임의의 스키마 소유 테이블 수정 권한
            -- DROP ANY TABLE : 임의의 스키마 소유 테이블 삭제 권한
            
        -- SESSION 접속 권한 부여
        GRANT CREATE SESSION TO test1;
        
        -- TABLE 생성 권한
        GRANT CREATE TABLE TO test1;
        
    
    -- ROLE : 여러 권한들의 묶음
        GRANT RESOURCE, CONNECT TO test1;
            -- RESOURCE : SEQUENCE, TABLE, TRIGGER .. 객체 생성 권한의 묶음
            -- CONNECT : CREATE SESSION
            
    -- 사용자 비밀번호 변경
        ALTER USER test1 IDENTIFIED BY 54321;
        
    -- 사용자 삭제 ( 계정 내 다른 데이터가 있다면, 삭제 불가 (CASCADE 명령어 추가) ) / 연결상태에서 삭제 불가
        DROP USER test1 CASCADE;
        
        
    -- 수업 중 실습에 사용할 계정
    CREATE USER javadb IDENTIFIED BY 12345;
    GRANT RESOURCE, CONNECT TO javadb;
    
    -- scott 에게 VIEW 생성 권한 부여
    GRANT CREATE VIEW TO scott;
    
    
    -- SELF_STUDY 연습용 계정
    CREATE USER practice IDENTIFIED BY orcl1234;
    GRANT RESOURCE, CONNECT TO practice;
    