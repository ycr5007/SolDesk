-- PL/SQL
-- SQL 만으로는 구현이 어렵거나 구현 불가능한 작업들을 수행하기 위해서 제공하는 프로그래밍 언어

-- 키워드
    -- DECLARE (선언부) : 변수, 상수, 커서 등을 선언 ( 선택 )
    -- BEGIN (실행부) : 조건문, 반복문, SELECT, DML, 함수 등을 정의 ( 필수 )
    -- EXCEPTION (예외처리부) : 오류(예외상황) 해결 ( 선택 )
    
    
-- 실행 결과를 화면에 출력하기위한 설정
    SET SERVEROUTPUT ON;
----------------------------------------------------------------------------------------------------------------------------    
    BEGIN
        -- HELLO 출력
        DBMS_OUTPUT.PUT_LINE('HELLO! PL/SQL');
    END;
    /
----------------------------------------------------------------------------------------------------------------------------
    DECLARE
        -- 변수선언
        V_EMPNO NUMBER(4) := 7788;
        V_ENAME VARCHAR2(10);
    BEGIN
        V_ENAME := 'SCOTT';
        DBMS_OUTPUT.PUT_LINE('V_EMPNO : ' || V_EMPNO);
        DBMS_OUTPUT.PUT_LINE('V_ENAME : ' || V_ENAME);
    END;
    /
----------------------------------------------------------------------------------------------------------------------------
    DECLARE
        -- 상수선언
        V_TAX CONSTANT NUMBER(1) := 3;
    BEGIN
        DBMS_OUTPUT.PUT_LINE('V_TAX : ' || V_TAX);
    END;
    /
----------------------------------------------------------------------------------------------------------------------------
    DECLARE
        -- 변수의 기본값 지정
        V_DEPTNO NUMBER(2) DEFAULT 10 ;
    BEGIN
        DBMS_OUTPUT.PUT_LINE('V_DEPTNO : ' || V_DEPTNO);
    END;
    /
----------------------------------------------------------------------------------------------------------------------------
    DECLARE
        -- NOT NULL 지정
        V_DEPTNO NUMBER(2) NOT NULL := NULL ;
    --    V_DEPTNO NUMBER(2) NOT NULL DEFAULT 20 ;
    BEGIN
        DBMS_OUTPUT.PUT_LINE('V_DEPTNO : ' || V_DEPTNO);
    END;
    /
----------------------------------------------------------------------------------------------------------------------------
    -- IF 조건문 ( IF ~ THEN / IF ~ THEN ~ ELSE / IF ~ THEN ~ ELSIF )
    DECLARE
        V_NUMBER NUMBER := 14;
    BEGIN
        IF MOD(V_NUMBER, 2) = 0 THEN 
            DBMS_OUTPUT.PUT_LINE('짝수');
        ELSE 
            DBMS_OUTPUT.PUT_LINE('홀수');
        END IF;
    END;
    /
    
    DECLARE
        V_NUMBER NUMBER := 87;
    BEGIN
        IF V_NUMBER >= 90 THEN 
            DBMS_OUTPUT.PUT_LINE('A 학점');
        ELSIF V_NUMBER >= 80 THEN 
            DBMS_OUTPUT.PUT_LINE('B 학점');
        ELSIF V_NUMBER >= 70 THEN 
            DBMS_OUTPUT.PUT_LINE('C 학점');
        ELSIF V_NUMBER >= 60 THEN 
            DBMS_OUTPUT.PUT_LINE('D 학점');
        ELSE 
            DBMS_OUTPUT.PUT_LINE('F 학점');
        END IF;
    END;
    /
----------------------------------------------------------------------------------------------------------------------------
    -- CASE ~ WITH 조건문
    DECLARE
        V_SCORE NUMBER := 77;
    BEGIN
        CASE TRUNC(V_SCORE / 10)
        WHEN 10 THEN
            DBMS_OUTPUT.PUT_LINE('A 학점');
        WHEN 9 THEN
            DBMS_OUTPUT.PUT_LINE('B 학점');
        WHEN 8 THEN
            DBMS_OUTPUT.PUT_LINE('C 학점');
        WHEN 7 THEN
            DBMS_OUTPUT.PUT_LINE('D 학점');
        ELSE
            DBMS_OUTPUT.PUT_LINE('F 학점');
        END CASE;
    END;
    /
----------------------------------------------------------------------------------------------------------------------------
    -- LOOP ~ END LOOP 반복문
    DECLARE
        V_DEPTNO NUMBER(2) := 0 ;
    BEGIN
        LOOP
            DBMS_OUTPUT.PUT_LINE('현재 V_DEPTNO : ' || V_DEPTNO);
            V_DEPTNO := V_DEPTNO + 1;
            EXIT WHEN V_DEPTNO > 4;
        END LOOP;
    END;
    /
----------------------------------------------------------------------------------------------------------------------------
    -- WHILE LOOP ~ END LOOP 반복문
    DECLARE
        V_DEPTNO NUMBER(2) := 0 ;
    BEGIN
        WHILE V_DEPTNO < 4 LOOP
            DBMS_OUTPUT.PUT_LINE('현재 V_DEPTNO : ' || V_DEPTNO);
            V_DEPTNO := V_DEPTNO + 1;
        END LOOP;
    END;
    /
----------------------------------------------------------------------------------------------------------------------------
    -- FOR LOOP
    BEGIN
        -- FOR 변수 IN 시작값 .. 종료값 LOOP : 반복문을 통해서 시작값 ~ 종료값 까지 실행한다. ( 0 > 4)
        FOR i IN 0..4 LOOP
            DBMS_OUTPUT.PUT_LINE('현재 i : ' || i);
        END LOOP;
    END;
    /
    
    BEGIN
        -- REVERSE : 시작값과 종료값의 위치를 바꿔 실행 ( 4 > 0 )
        FOR i IN REVERSE 0..4 LOOP
            DBMS_OUTPUT.PUT_LINE('현재 i : ' || i);
        END LOOP;
    END;
    /
    
    -- [실습] 숫자 1 ~ 10 까지 출력
        BEGIN
            FOR i IN 0..10 LOOP
                IF MOD(i, 2) = 1 THEN
                    FOR j IN 0..10 LOOP
                        DBMS_OUTPUT.PUT_LINE( i || ' * ' || j || ' = ' || i * j);
                    END LOOP;
                    DBMS_OUTPUT.PUT_LINE(' ');
                END IF;
            END LOOP;
        END;
        /
----------------------------------------------------------------------------------------------------------------------------
    -- 변수의 값을 특정 테이블의 Column 값을 참조
    DECLARE
        v_deptno dept.deptno%TYPE := 50;
    BEGIN
        dbms_output.put_line('v_deptno : ' || v_deptno);
    END;
    /
    
    DECLARE
        v_dept_row dept%ROWTYPE;
    BEGIN
        SELECT deptno, dname, loc INTO v_dept_row FROM dept WHERE deptno=40;
        DBMS_OUTPUT.PUT_LINE('DEPTNO : ' || v_dept_row.deptno);
        DBMS_OUTPUT.PUT_LINE('DNAME : ' || v_dept_row.dname);
        DBMS_OUTPUT.PUT_LINE('LOC : ' || v_dept_row.loc);
    END;
    /
----------------------------------------------------------------------------------------------------------------------------
    -- Cursor
        -- (SELECT INTO 방식 : 결과값이 하나일 때 사용가능)
        -- 걀과값이 몇 개인지 알 수 없을 경우 CURSOR 사용
        
        -- 1) 명시적 커서
            -- DECLARE : 커서 선언
            -- OPEN : 커서 열기
            -- FETCH : 커서에서 읽어온 데이터 사용
            -- CLOSE : 커서 닫기
            
        DECLARE
            -- 커서 데이터를 입력할 변수 선언
            v_dept_row dept%ROWTYPE;
            -- 커서 선언
            CURSOR c1 IS
                SELECT deptno, dname, loc
                FROM dept
                WHERE deptno = 40;
        BEGIN
            -- 커서 열기
            OPEN c1;
            
            -- 읽어온 데이터 사용
            FETCH c1 INTO v_dept_row;
            
            DBMS_OUTPUT.PUT_LINE('DEPTNO : ' || v_dept_row.deptno);
            DBMS_OUTPUT.PUT_LINE('DNAME : ' || v_dept_row.dname);
            DBMS_OUTPUT.PUT_LINE('LOC : ' || v_dept_row.loc);
            
            -- 커서 닫기
            CLOSE c1;
        END;
        /
----------------------------------------------------------------------------------------------------------------------------
    -- Cursor LOOP ~ END LOOP ( Cursor 로 불러온 행이 여러행인 경우 )
        DECLARE
            v_dept_row dept%ROWTYPE;
            CURSOR c1 IS
                SELECT deptno, dname, loc
                FROM dept;
        BEGIN
            OPEN c1;
            -- 모든 행을 읽기위한 작업 (반복)
            LOOP
                FETCH c1 INTO v_dept_row;
                
                -- 읽어온 커서에서 다음 행이 없을 때 까지
                EXIT WHEN c1%NOTFOUND;
                
                DBMS_OUTPUT.PUT_LINE('DEPTNO : ' || v_dept_row.deptno);
                DBMS_OUTPUT.PUT_LINE('DNAME : ' || v_dept_row.dname);
                DBMS_OUTPUT.PUT_LINE('LOC : ' || v_dept_row.loc);
                
            END LOOP;
            CLOSE c1;
        END;
        /
----------------------------------------------------------------------------------------------------------------------------
    -- Cursor FOR LOOP > 변수 선언 , 커서 열기, 커서 닫기 생략, FETCH 생략
        DECLARE
            CURSOR c1 IS
                SELECT deptno, dname, loc
                FROM dept;
        BEGIN
            -- FOR > 자동 OPEN , FETCH, CLOSE, 변수 선언
            FOR c1_rec IN c1 LOOP
            
                DBMS_OUTPUT.PUT_LINE('DEPTNO : ' || c1_rec.deptno ||
                ' DNAME : ' || c1_rec.dname ||
                ' LOC : ' || c1_rec.loc);
                
            END LOOP;
        END;
        /
----------------------------------------------------------------------------------------------------------------------------
        DECLARE
            -- 사용자가 입력한 부서 번호를 저장하는 변수 선언
            v_deptno DEPT.DEPTNO%TYPE;
        
            -- 명시적 커서 선언
            CURSOR c1(p_deptno DEPT.DEPTNO%TYPE) IS
                SELECT deptno, dname, loc
                FROM dept
                WHERE deptno = p_deptno;
        BEGIN
            
            -- input_deptno 에 부서번호 입력받고 v_deptno에 대입
            v_deptno := &input_deptno;
            
            FOR c1_rec IN c1(v_deptno) LOOP
            
                DBMS_OUTPUT.PUT_LINE('DEPTNO : ' || c1_rec.deptno ||
                ' DNAME : ' || c1_rec.dname ||
                ' LOC : ' || c1_rec.loc);
                
            END LOOP;
        END;
        /
----------------------------------------------------------------------------------------------------------------------------
    -- 묵시적 커서 : 커서 선언 없이 사용 
        -- SELECT ~ INTO / DML (UPDATE / DELETE / INSERT)
        -- SQL%ROWCOUNT : 묵시적 커서 안에 추출된 행이 있으면 행의 수 출력
        -- SQL%FOUND : 묵시적 커서 안에 추출된 행이 있으면 TRUE, 없으면 FALSE
        -- SQL%ISOPEN : 자동으로 SQL 문을 실행한 후 CLOSE 되기 떄문에 항상 FALSE
        -- SQL%NOTFOUND : 커서안에 추출된 행이 있으면 TRUE, 없으면 FALSE
        
        BEGIN
            UPDATE dept_temp SET dname = 'DATABASE' WHERE deptno = 60;
            DBMS_OUTPUT.PUT_LINE('갱신된 행의 수 : ' || SQL%ROWCOUNT);
            
            IF SQL%FOUND THEN
                DBMS_OUTPUT.PUT_LINE('갱신 대상 행 존재 여부 : TRUE');
            ELSE
                DBMS_OUTPUT.PUT_LINE('갱신 대상 행 존재 여부 : FALSE');
            END IF;
            
            IF SQL%ISOPEN THEN
                DBMS_OUTPUT.PUT_LINE('커서의 OPEN 여부 : TRUE');
            ELSE
                DBMS_OUTPUT.PUT_LINE('커서의 OPEN 여부 : FALSE');
            END IF;
        END;
        /
----------------------------------------------------------------------------------------------------------------------------
    -- 저장 서브 프로그램 (이름지정, 저장, 저장할 때 한 번 컴파일, 공유해서 사용 가능, 다른 응용프로그램에서 호출 가능 )
        -- 1 . 저장 프로시저 : SQL 문에서는 사용 불가
        -- 2 . 저장 함수 : SQL 문에서 사용 가능
        -- 3 . 트리거 : 특정상황이 발생할 떄 자동으로 연달아 수행할 기능을 구현하는데 사용
            -- ex ) 휴면계정, 동의 시 정상화, 비동의 시 비활성화 처리...
            --          회원 탈퇴, DB에서 바로 삭제하는 것이 아니라, 따로 테이블을 만들어 유예 테이블로 옮기는 등 자동 관리 시스템 
        -- 4 . 패키지 : 저장서브 프로그램을 그룹화 할 때 사용
        
----------------------------------------------------------------------------------------------------------------------------
    -- 프로시저
----------------------------------------------------------------------------------------------------------------------------
        -- 생성
            CREATE PROCEDURE pro_noparam 
                IS
                    v_empno NUMBER(4) := 7788;
                    v_ename VARCHAR2(10);
                BEGIN
                    v_ename := 'SCOTT';
                    DBMS_OUTPUT.PUT_LINE('V_EMPNO : ' || v_empno);
                    DBMS_OUTPUT.PUT_LINE('V_ENAME : ' || v_ename);
                END;
                /
                -- 같은 이름으로 프로시저가 존재할 경우, 프로시저 재정의 ( OR REPLACE )
            -- 매개변수를 받아오는 프로시저 ( IN )
                CREATE OR REPLACE PROCEDURE pro_param_in 
                    (
                        param1 IN NUMBER,
                        param2 NUMBER,
                        param3 NUMBER := 3,                
                        param4 NUMBER DEFAULT 4
                    )
                    IS
                    BEGIN
                        DBMS_OUTPUT.PUT_LINE('param1 : ' || param1);
                        DBMS_OUTPUT.PUT_LINE('param2 : ' || param2);
                        DBMS_OUTPUT.PUT_LINE('param3 : ' || param3);
                        DBMS_OUTPUT.PUT_LINE('param4 : ' || param4);
                    END;
                    /
                    -- IN : 기본값으로 생략 가능하다 ( 값을 매개변수로 받아옴 )
            -- 반환값이 있는 프로시저 ( OUT )
                CREATE OR REPLACE PROCEDURE pro_param_out
                    (
                        in_empno IN EMP.EMPNO%TYPE,
                        out_ename OUT EMP.ENAME%TYPE,
                        out_sal OUT EMP.SAL%TYPE
                    )
                    IS
                    BEGIN
                        SELECT ename, sal INTO out_ename, out_sal FROM emp WHERE empno = in_empno;
                    END;
                    /
                    -- OUT : 값을 return  해줌
            -- 매개변수와 반환값이 동시에 있는 변수 ( IN / OUT )
                CREATE OR REPLACE PROCEDURE pro_param_in_out
                    (
                        in_out_no IN OUT NUMBER
                    )
                    IS
                    BEGIN
                        in_out_no := in_out_no * 2;
                    END;
                    /
        -- 실행
            EXECUTE pro_noparam;
            EXECUTE pro_param_in(1, 2);
            EXECUTE pro_param_in(5, 6, 7, 8);
            EXECUTE pro_param_in(1); -- wrong number or types of arguments in call to 'PRO_PARAM_IN' > 매개변수의 값이 일치하지 않음
            
        -- 다른 PL/SQL 블록(BEGIN ~ END)에서 프로시저 실행 가능
            BEGIN
                pro_noparam;
            END;
            /
            
            -- OUT 모드
            DECLARE
                v_ename EMP.ENAME%TYPE;
                v_sal EMP.SAL%TYPE;
            BEGIN
                pro_param_out(7369, v_ename, v_sal);
                DBMS_OUTPUT.PUT_LINE('ENAME : ' || v_ename);
                DBMS_OUTPUT.PUT_LINE('SAL : ' || v_sal);
            END;
            /
            
            -- IN / OUT 모드
            DECLARE
                no NUMBER;
            BEGIN
                no := 5;
                pro_param_in_out(no);
                DBMS_OUTPUT.PUT_LINE('no : ' || no);
            END;
            /
----------------------------------------------------------------------------------------------------------------------------
    -- 트리거 : 특정 테이블에 원하지 않는 상황 발생 시 제한 가능
--        CREATE OR REPLACE TRIGGER name [BEFORE | AFTER] [INSERT | UPDATE | DELETE] ON table_name
--        DECLARE
--        BEGIN
--        END;
--        /
----------------------------------------------------------------------------------------------------------------------------
    CREATE TABLE emp_trg AS SELECT * FROM emp;
    -- INSERT 작업 실행 시 TRIGGER 발생 ( 주말에 사원정보 변경이 일어날 시, 에러발생 )
        CREATE OR REPLACE TRIGGER emp_trg_weekend BEFORE INSERT OR UPDATE OR DELETE ON emp_trg
        BEGIN
            IF TO_CHAR(sysdate, 'DY') IN ('토', '일') THEN
                IF INSERTING THEN
                    RAISE_APPLICATION_ERROR(-30000, '주말 사원정보 추가 불가');
                ELSIF UPDATING THEN
                    RAISE_APPLICATION_ERROR(-30001, '주말 사원정보 수정 불가');
                ELSIF DELETING THEN
                    RAISE_APPLICATION_ERROR(-30002, '주말 사원정보 삭제 불가');
                ELSE
                    RAISE_APPLICATION_ERROR(-30003, '주말 사원정보 변경 불가');
                END IF;
            END IF;
        END;
        /
        
        UPDATE emp_trg SET sal = 3600 WHERE empno = 7369; -- error number argument to raise_application_error of -30001 is out of range
        DELETE FROM emp_trg WHERE empno = 7369; -- error number argument to raise_application_error of -30002 is out of range
        
        
    -- 트리거 발생 저장 테이블 ( DBA 가 트리거 발생 현황을 확인할 수 있도록 하는 테이블 )
    CREATE TABLE EMP_TRG_LOG(       
        TABLENAME VARCHAR2(20),     -- DML이 수행된 테이블
        DML_TYPE VARCHAR2(10),        -- DML 명령어 종류
        EMPNO NUMBER(4),                  -- DML 대상이 된 사원번호
        USER_NAME VARCHAR2(30),      -- DML 을 수행한 USER 명
        CHANGE_DATE DATE);               -- DML 시도 날짜
        
    CREATE OR REPLACE TRIGGER emp_trg_weekend_log AFTER INSERT OR UPDATE OR DELETE ON emp_trg
    FOR EACH ROW -- 영향받는 모든행에 대해, 각각 행별로 실행
        BEGIN
            IF INSERTING THEN
                INSERT INTO emp_trg_log VALUES('EMP_TRG', 'INSERT', :new.empno, SYS_CONTEXT('USERENV', 'SESSION_USER'), sysdate);
            ELSIF UPDATING THEN
                INSERT INTO emp_trg_log VALUES('EMP_TRG', 'UPDATE', :old.empno, SYS_CONTEXT('USERENV', 'SESSION_USER'), sysdate);
            ELSIF DELETING THEN
                INSERT INTO emp_trg_log VALUES('EMP_TRG', 'DELETE', :old.empno, SYS_CONTEXT('USERENV', 'SESSION_USER'), sysdate);
            END IF;
        END;
        /
        
        INSERT INTO emp_trg VALUES(9999, 'TEST_TMP', 'CLERK', 7788, '2018-03-03', 1200, NULL, 20);
        DELETE FROM emp_trg WHERE empno = 9999;
        COMMIT;
        SELECT * FROM emp_trg_log;
        
        DROP TRIGGER emp_trg_weekend_log;