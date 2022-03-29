-- DEPT 테이블의 정보 조회 ( COLUMN 명, NULL 설정, 자료형 )
    -- DEPTNO(부서번호) , DNAME(부서명) , LOC(위치)
DESC dept;

-- EMP 테이블의 정보 조회
    -- EMPNO(사원번호) , ENAME(사원명) , JOB(직책) , MGR(직속상관) , HIREDATE(입사일) , SAL(급여) , COMM(추가수당) , DEPTNO(부서번호)
DESC emp;

-- SALGRADE 테이블의 정보 조회
    -- GRADE(등급) , LOSAL(최저급여) , HISAL(최고급여)
DESC salgrade;

---------------------------------------d---------------------------------------------------------------------------------------------------------------------
-- 조회 (SELECT)
    -- 형식 : SELECT 칼럼명 ... FROM 테이블명;
------------------------------------------------------------------------------------------------------------------------------------------------------------
    SELECT deptno FROM dept;
    SELECT deptno, dname FROM dept;
    SELECT * FROM dept;
    SELECT * FROM emp;
    SELECT empno, ename, deptno FROM emp;
    SELECT deptno FROM emp;
    
        -- DISTINCT : 중복 데이터 제거 
            -- 형식 : SELECT DISTINCT 칼럼명 FROM 테이블명; ( 칼럼이 여러개인 경우, 모든 칼럼이 동일한 경우를 중복으로 판단한다 )
        SELECT DISTINCT deptno FROM emp;
        SELECT DISTINCT job, deptno FROM emp;
    
        -- ALAIS (별칭)
            -- 형식 : SELECT 칼럼 AS 별칭 FROM 테이블명 ( AS 생략 가능 , 별칭에 띄어쓰기를 넣을 경우 " " 에 감싼 상태로 입력한다 )
        SELECT ename AS 이름, sal, comm "추가 수당", sal * 12 + comm AS 연봉 FROM emp;
        
        -- ORDER BY : 원하는 순서로 출력 데이터 정렬 ( 동작 시간이 오래 걸림 )
            -- 형식 : SELECT 컬럼 FROM 테이블명 ORDER BY 컬럼명 정렬옵션(ASC-오름차순 , DESC-내림차순 , DEFAULT-ASC)
        SELECT ename, sal FROM emp ORDER BY sal DESC;
        SELECT ename, sal FROM emp ORDER BY sal;
        SELECT * FROM emp ORDER BY deptno ASC, sal DESC;
        
        -- WHERE : 특정한 조건을 기준으로 데이터 조회
            -- 형식 : SELECT 칼럼 FROM 테이블 WHERE 컬럼 = ?; ( 문자열 ' ' ) / ( && AND , || OR )
            -- 쿼리문은 대소문자를 구분하지 않지만, 데이터값은 구분한다.
        SELECT * FROM emp WHERE deptno = 30;
        SELECT * FROM emp WHERE empno = 7782;
        SELECT * FROM emp WHERE deptno = 30 AND job = 'SALESMAN';
        SELECT * FROM emp WHERE empno = 7499 AND deptno = 30;
        SELECT * FROM emp WHERE deptno = 30 OR job = 'CLERK';
        
------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        -- 연산자
            -- 산술연산자 ( + | - | * | / )
            SELECT * FROM emp WHERE sal * 12 = 36000;
            
            -- (등가)비교연산자 ( < | > | = | 같지 않다( != | <> | ^= ))
            SELECT * FROM emp WHERE sal >= 3000;
            SELECT * FROM emp WHERE ename >= 'F'; -- 문자 대소비교 (문자에 대해서도 비교 조회 가능)
            SELECT * FROM emp WHERE sal >= 2500 AND job = 'ANALYST';
            SELECT * FROM emp WHERE job = 'MANAGER' OR job = 'SALESMAN' OR job = 'CLERK';
            SELECT * FROM emp WHERE sal != 3000 AND sal <> 2000 AND sal ^= 3000;
            
            -- 논리(부정)연산자 ( NOT | AND | OR )
            SELECT * FROM emp WHERE NOT sal = 3000;
            
            -- IN 연산자 : "=" 의 의미와 같다.
            SELECT * FROM emp WHERE job IN('MANAGER', 'SALESMAN', 'CLERK');
            SELECT * FROM emp WHERE NOT job IN('MANAGER', 'SALESMAN', 'CLERK');
            SELECT * FROM emp WHERE deptno IN(10, 20);
            
            -- BETWEEN a AND b 연산자 
            SELECT * FROM emp WHERE sal BETWEEN 2000 AND 3000;
            SELECT * FROM emp WHERE sal NOT BETWEEN 2000 AND 3000;
            
            -- LIKE 연산자 / 와일드카드 ( % | _ ) : 유사값을 찾는 연산자
                -- 와일드카드 :  " _ " ( 어떤 값이든 상관없이 단 한개의 문자데이터 ) / " % " (어떤 값이든, 길이에 상관없는 모든 문자데이터)
            SELECT * FROM emp WHERE ename LIKE 'S%';
            SELECT * FROM emp WHERE ename LIKE '_L%';
            SELECT * FROM emp WHERE ename LIKE '%AM%';
            SELECT * FROM emp WHERE ename NOT LIKE '%AM%';
            
            -- IS NULL 연산자 : NULL 여부를 확인하는 연산자
            SELECT * FROM emp WHERE comm IS NULL;
            SELECT * FROM emp WHERE comm IS  NOT NULL;
            
            -- 집합연산자 (UNION:합집합 / MINUS:차집합 / INTERSECT:교집합)
                -- 집합연산이기 때문에, 컬럼명이 일치해야한다.
            SELECT * FROM emp WHERE deptno = 10 UNION SELECT * FROM emp WHERE deptno = 20;
            SELECT * FROM emp WHERE deptno = 10 UNION ALL SELECT * FROM emp WHERE deptno = 10;
            SELECT empno, ename, deptno FROM emp MINUS SELECT empno, ename, deptno FROM emp WHERE deptno = 10;
            SELECT empno, ename, deptno FROM emp INTERSECT SELECT empno, ename, deptno FROM emp WHERE deptno = 10;

-- [문제] ename이 s로 끝나는 사원 데이터 출력
    SELECT * FROM emp WHERE ename LIKE '%S';
-- [문제] 30번 부서에서 근무하고 있는 사원중에 직책이 'SALESMAN' 인 사원의 사원번호, 이름, 직책, 급여, 부서번호를 출력한다.
    SELECT empno, ename, job, sal, deptno FROM emp WHERE deptno = 30 AND job = 'SALESMAN';
-- [문제] 20번, 30번 부서에 근무하고 있는 사원중 급여가 2,000 초과인 사원을 다음 두 가지 방식의 SELECT문을 사용하여 사원번호, 이름, 직책, 급여, 부서번호를 출력하는 SQL 문을 작성하시오
    SELECT empno, ename, job, sal, deptno FROM emp WHERE deptno IN (20, 30) INTERSECT SELECT empno, ename, job, sal, deptno FROM emp WHERE sal > 2000;
    SELECT empno, ename, job, sal, deptno FROM emp WHERE deptno IN (20, 30) AND sal > 2000;
-- [문제] NOT BETWEEN a AND b 연산자를 쓰지 않고, 급여 열값이 2,000 이상 3,000 이하 범위 이외의 값을 가진 데이터만 출력하도록 SQL문을 작성하시오
    SELECT * FROM emp WHERE sal <=2000 OR sal >= 3000;
-- [문제] 사원 이름에 'E'가 포함되어 있는 30번 부서의 사원 중 급여가 1,000 ~ 2,000 사이가 아닌 사원 이름, 사원번호, 급여, 부서번호를 출력하는 SQL문을 작성하시오
    SELECT ename, empno, sal, deptno FROM emp WHERE ename LIKE '%E%' AND deptno = 30 AND sal NOT BETWEEN 1000 AND 2000;
-- [문제] 추가수당이 존재하지 않고, 상급자가 있고, 직책이 'MANAGER', 'CLERK' 인 사원중에서 사원 이름의 두번쨰 글자가 'L' 이 아닌 사원의 정보를 출력하는 SQL문을 작성하시오
    SELECT * FROM emp WHERE comm IS NULL AND mgr IS NOT NULL AND job IN ('MANAGER', 'CLERK') AND ename NOT LIKE '_L%';
    
    
    
------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 오라클 함수 (문자)
------------------------------------------------------------------------------------------------------------------------------------------------------------
    -- 대소문자 변경 : UPPER(), LOWER(), INITCAP()
    SELECT ename, LOWER(ename), INITCAP(ename), UPPER(LOWER(ename)) FROM emp;
    
    -- 문자열길이 : LENGTH():문자열 길이, LENGTHB():문자열 바이트 수
        -- § dual 테이블 > 임시 연산이나 함수의 결과값을 확인하는 용도로 사용
    SELECT LENGTH('하나둘셋abc'), LENGTHB('하나둘셋abc') FROM dual;
    SELECT ename, LENGTH(ename) FROM emp;
    SELECT * FROM emp WHERE LENGTH(job) >= 6;
    
    -- 문자열추출 : substr(원본데이터, 시작위치, [추출길이]) > 시작위치에 문자열이 없을경우 NULL 반환
    SELECT job, SUBSTR(job, 1, 2), SUBSTR(JOB, 3, 2), SUBSTR(job,6) FROM emp;
    
-- [문제] emp 테이블의 모든 사원 이름을 세번쨰 글자부터 끝까지 출력
    SELECT SUBSTR(ename, 3) FROM emp;
    
    -- 특정 문자 위치 찾기 : INSTR(문자열데이터, 위치를 찾으려고 하는 문자, 시작위치, [시작위치로부터  찾는 문자의 위치])
    SELECT INSTR('ababcda', 'c'), INSTR('ababcda', 'a', 3), INSTR('ababcda', 'a',3, 2) FROM DUAL;
    SELECT * FROM emp WHERE INSTR(ename, 'S') > 0;
    
    -- 특정 문자를 다른 문자로 변경 : REPLACE(문자열데이터, 찾는문자, 변경문자)
    SELECT REPLACE('010-1234-5678', '-', '*') FROM dual;
     SELECT REPLACE('010-1234-5678', '-') FROM dual; -- 변경문자를 입력하지 않을 경우, 삭제 처리
     
     -- 문자열 연결 : CONCAT(문자열1, 문자열2) > 2 개만 허용, 중첩으로 사용가능
     SELECT CONCAT(empno, CONCAT(', ', ename)) FROM emp;
     SELECT empno||', '||ename FROM emp; -- > 문자열 연결 기호 ( || )
     
     -- TRIM(), LTRIM(), RTRIM() : 문자열 공백
     SELECT TRIM('   이것이   디비다   '), LTRIM('   이것이   디비다   '), RTRIM('   이것이   디비다   ') FROM DUAL;
------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 오라클 함수 (숫자)
------------------------------------------------------------------------------------------------------------------------------------------------------------
    -- ROUND() : 반올림
    SELECT ROUND(1234.5678), ROUND(1234.5678, 0), ROUND(1234.5678, 1), ROUND(1234.5678, 2), ROUND(1234.5678, -1), ROUND(1234.5678, -2) FROM dual;
    
    -- TRUNC() : 버림
    SELECT TRUNC(1234.5678), TRUNC(1234.5678, 0), TRUNC(1234.5678, 1), TRUNC(1234.5678, 2), TRUNC(1234.5678, -1), TRUNC(1234.5678, -2) FROM dual;
    
    -- CEIL() : 지정된 숫자보다 큰 정수 중에서 가장 작은 정수
    -- FLOOR() : 지정된 숫자보다 작은 정수 중에서 가장 큰 정수
     SELECT CEIL(3.14), Floor(3.14), CEIL(-3.14), FLOOR(-3.14) FROM dual;
     
    -- MOD() : 나머지
    SELECT MOD(15, 6), MOD(10, 2), MOD(11, 2) FROM dual;
    
------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 오라클 함수 (날짜) : 연산이 가능하다 ( + - ... )
------------------------------------------------------------------------------------------------------------------------------------------------------------
    -- SYSDATE : 22/03/21 > System Date ( 서버가 실행되고 있는곳의 데이터 )
    -- CURRENT_DATE : 22/03/21
    -- CURRENT_TIMESTAMP : 22/03/21 09:53:21.000000000 ASIA/SEOUL
    SELECT SYSDATE, CURRENT_DATE, CURRENT_TIMESTAMP FROM dual;
    SELECT SYSDATE AS now, SYSDATE - 1 AS yesterday, SYSDATE + 1 AS tomorrow FROM dual;
    
    -- ADD_MONTHS(date, int) : date 에서 int 개월 이후의 날짜
    SELECT SYSDATE, ADD_MONTHS(SYSDATE, 3) FROM DUAL;
    SELECT empno, ename, hiredate, ADD_MONTHS(hiredate, 240) FROM emp;
    SELECT * FROM emp WHERE ADD_MONTHS(hiredate, 540) > SYSDATE;
    
    -- MONTH_BETWEEN(date1, date2) : 두 날짜 데이터 간의 날짜 차이를 개월 수로 출력
        -- MONTHS_BETWEEN(hiredate, SYSDATE) > -495.142663157108721624850657108721624851    │
        -- MONTHS_BETWEEN(SYSDATE, hiredate) > 495.142663157108721624850657108721624851      │ > TRUNC(MONTHS_BETWEEN(SYSDATE, hiredate)) : 495 ( 개월수로 출력 )
    SELECT empno, ename, hiredate, sysdate, MONTHS_BETWEEN(hiredate, SYSDATE), MONTHS_BETWEEN(SYSDATE, hiredate), TRUNC(MONTHS_BETWEEN(SYSDATE, hiredate)) FROM emp;
    
    -- NEXT_DAY() : 특정 날짜를 기준으로 돌아오는 요일의 날짜 출력
    -- LAST_DAY() : 특정 날짜가 속한 달의 마지막 날짜 출력
    SELECT SYSDATE, NEXT_DAY(SYSDATE, '금요일'), LAST_DAY(SYSDATE) FROM dual;
    
------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 오라클 함수 (형변환) : ORACLE 내 자료형의 변환
------------------------------------------------------------------------------------------------------------------------------------------------------------
    SELECT empno, ename, empno + '500' FROM emp WHERE ename = 'SMITH'; -- 숫자 + '숫자 문자' > 자동으로 변환
    SELECT empno, ename, 'abcd' + empno FROM emp WHERE ename = 'SMITH'; -- invalid number ( 숫자 + '문자' ) > 에러 발생
     
    -- TO_CHAR() : 숫자, 날짜 데이터를 문자 데이터로 변환
    SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD HH24:MI:SS') FROM dual;
    SELECT TO_CHAR(SYSDATE, 'MM'), TO_CHAR(SYSDATE, 'MON'), TO_CHAR(SYSDATE, 'MONTH'), TO_CHAR(SYSDATE, 'DD'), TO_CHAR(SYSDATE, 'DY'), TO_CHAR(SYSDATE, 'DAY') FROM dual;
    SELECT TO_CHAR(SYSDATE, 'HH24:MI:SS'), TO_CHAR(SYSDATE, 'HH24:MI:SS AM'), TO_CHAR(SYSDATE, 'HH:MI:SS P.M.'), TO_CHAR(SYSDATE, 'HH:MI:SS') FROM dual;
    SELECT sal, TO_CHAR(sal, '$999,999') FROM emp;
    
    -- TO_NUMBER() : 문자 데이터를 숫자 데이터로 변환
    SELECT '1,300' + '1,500' FROM dual; -- invalid number
    SELECT TO_NUMBER('1,300', '999,999') + TO_NUMBER('1,500', '999,999') FROM dual;
    
    -- TO_DATE() : 문자 데이터를 날짜 데이터로 변환
    SELECT TO_DATE('2022-03-22', 'YYYY-MM-DD'), TO_DATE('20220322', 'YYYY-MM-DD') FROM dual;
    
        -- [연습] 1981 년 6 월 1 일 이후에 입사한 사원 정보조회
        SELECT * FROM emp WHERE hiredate > to_date('19810601', 'YYYY-MM-DD');
        
------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 오라클 함수 (NULL 처리)
------------------------------------------------------------------------------------------------------------------------------------------------------------
    SELECT empno, ename, sal, comm, sal + comm FROM emp;
    
    -- NVL(NULL 값 옆, NULL 인 경우 사용할 값)
    SELECT empno, ename, sal, comm, sal + NVL(comm, 0) FROM emp;
    
    -- NVL2(NULL 값 열, NULL 이 아닐 경우 사용할 값, NULL 인 경우 사용할 값)
     SELECT empno, ename, sal, NVL2(comm, 'O', 'X'), sal + NVL2(comm, sal * 12 + comm, sal * 12) FROM emp;
     
------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 오라클 함수 (DECODE 함수와 CASE 문)
------------------------------------------------------------------------------------------------------------------------------------------------------------
    -- DECODE( 대상이 될 열 OR 데이터
    --      조건 1, 조건1과 일치할 시 반환할 결과,
    --      조건 2, 조건2와 일치할 시 반환할 결과,
    --      DEFAULT 에 해당할 경우 반환할 결과
    -- )
    SELECT empno, ename, job, sal, DECODE(job, 
        'MANAGER', sal * 1.1,
        'SALESMAN', sal * 1.05,
        'ANALYST', sal,
        sal * 1.03) AS upsal FROM emp;
        
    -- CASE 대상이 될 열 OR 데이터
    --      WHEN 조건1 THEN 조건1과 일치할 시 반환할 결과
    --      WHEN 조건1 THEN 조건1과 일치할 시 반환할 결과
    --      ELSE DEFAULT 에 해당할 경우 반환할 결과
    --      END
    SELECT empno, ename, job, sal, CASE job
        WHEN 'MANAGER' THEN sal * 1.1
        WHEN 'SALESMAN' THEN sal * 1.05
        WHEN 'ANALYST' THEN sal
        ELSE sal * 1.03 
        END AS upsal FROM emp;
    
    -- 조건문에 직접 조건 대입 > DECODE() 에서 불가하지만, CASE에서는 가능
    SELECT empno, ename, job, sal, CASE
        WHEN comm IS NULL THEN '해당사항없음'
        WHEN comm = 0 THEN '수당없음'
        WHEN comm > 0 THEN '수당 : ' || comm END
        AS comm_text FROM emp;
        

-- [실습] emp 테이블에서 월 평균 근무일수(21.5), 근무시간(8) 하루급여(DAY_PAY), 시급(TIME_PAY), DAY_PAY 소수점 셋째자리에서 버리기, TIME_PAY 소수점 둘째자리에서 반올림
    SELECT empno, ename, sal, TRUNC(sal / 21.5, 2) AS DAY_PAY, ROUND(sal / (21.5 * 8), 1) AS TIME_PAY FROM emp;
    
-- [실습] emp 테이블에서 입사일 기준으로 3개월이 지난 후 첫 월요일에 정직원 되는 날짜 구함(YYYY-MM-DD), 추가수당 조회 NULL 인경우 'N/A'로 출력
    SELECT empno, ename, hiredate, NEXT_DAY(ADD_MONTHS(hiredate, 3), '월요일') AS R_JOB, CASE WHEN comm IS NULL THEN 'N/A' ELSE TO_CHAR(comm) END AS COMM FROM emp;
    SELECT empno, ename, hiredate, NEXT_DAY(ADD_MONTHS(hiredate, 3), '월요일') AS R_JOB, DECODE(comm, NULL, 'N/A', comm) AS COMM FROM emp;

-- [실습] emp 테이블의 mgr 기준으로 출력, 존재하지 않으면 '0000', 앞자리 75 > '5555', 앞자리 76 > '6666', 앞자리 77 > '7777', 앞자리 78 > '8888' 그 외는 mgr 출력
    SELECT empno, ename, mgr, CASE
    WHEN substr(mgr, 1, 2) = '75' THEN '5555'
    WHEN substr(mgr, 1, 2) = '76' THEN '6666'
    WHEN substr(mgr, 1, 2) = '77' THEN '7777'
    WHEN substr(mgr, 1, 2) = '78' THEN '8888'
    WHEN mgr IS NULL THEN '0000'
    ELSE TO_CHAR(mgr) END AS CHG_MGR
    FROM emp;
    
------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 오라클 함수 (다중행 함수, 그룹 함수)
------------------------------------------------------------------------------------------------------------------------------------------------------------
    -- SUM() : 합계
    SELECT SUM(comm) FROM emp;
    SELECT SUM(DISTINCT sal), SUM(sal) FROM emp;
    
    -- COUNT() : 수량
    SELECT COUNT(comm) FROM emp;
    SELECT COUNT(*) FROM emp;
    SELECT COUNT(*) FROM emp WHERE deptno = 30;
    
    -- MAX(), MIN(), AVG() : 최대, 최저, 평균
    SELECT MAX(sal) FROM emp;
    SELECT MIN(sal) FROM emp;
    SELECT MIN(hiredate) FROM emp WHERE deptno = 20;
    SELECT MAX(hiredate) FROM emp WHERE deptno= 20;
    SELECT ROUND(AVG(sal)) FROM emp WHERE deptno = 30;


        -- GROUP BY : 그룹함수를 사용할 경우, 결과값을 원하는 칼럼명으로 묶어 그룹화하여 출력    
            -- 형식 : SELECT GROUP_FUNCTION FROM 테이블 GROUP BY 칼럼명;
            SELECT deptno, AVG(sal) FROM emp; -- not a single-group group function > 개별 칼럼과 그룹함수는 함께 사용할 수 없다
            SELECT deptno, AVG(sal) FROM emp GROUP BY deptno; 
            SELECT deptno, job, AVG(sal) FROM emp GROUP BY deptno, job ORDER BY deptno;
            SELECT ename, deptno, AVG(sal) FROM emp GROUP BY deptno; -- not a GROUP BY expression > 조회하는 칼럼과 그룹화하는 칼럼은 반드시 일치해야한다.
            
        -- GROUP BY ~ HAVING : 그룹을 잡을 떄 조건을 주는 경우 사용
            -- 형식 : SELECT GROUP_FUNCTION FROM 테이블 GROUP BY 칼럼명 HAVING 조건
            SELECT deptno, job, AVG(sal) FROM emp GROUP BY deptno, job HAVING AVG(sal) >= 2000;
            -- HAVING ( 그룹화한 값에 제한 ) / WHERE ( 출력 대상 행을 제한 )
            SELECT deptno, job, AVG(sal) FROM emp GROUP BY deptno, job HAVING AVG(sal) >= 500 ORDER BY deptno, job;
            SELECT deptno, job, AVG(sal) FROM emp WHERE AVG(sal) >= 500; -- group function is not allowed here
            SELECT deptno, job, AVG(sal) FROM emp WHERE job = 'CLERK' GROUP BY deptno, job HAVING AVG(sal) >= 500 ORDER BY deptno, job;
            
            -- ① FROM > ② WHERE > ③ GROUP BY > ④ HAVING > ⑤ SELECT > ⑥ ORDER BY
            
-- [실습] 부서별, 평균급여, 최고급여, 최저급여, 사원수 출력( 평균급여는 소수점 제외 )
    SELECT deptno, TRUNC(AVG(sal)) AS AVG_SAL, MAX(sal) AS MAX_SAL, MIN(sal) AS MIN_SAL, COUNT(deptno) FROM emp GROUP BY deptno;
    
-- [실습] 같은 직책에 종사하는 사원이 3명 이상인 직책과 인원수를 출력하는 SQL문을 작성하시오
    SELECT job, COUNT(*) FROM emp GROUP BY job HAVING COUNT(*) >= 3;
    
-- [실습] 사원들의 입사연도(HIRE_YEAR)을 기준으로 부서별로 몇 명이 입사했는지 출력하는 SQL 문을 작성하시오.
    SELECT TO_CHAR(hiredate, 'YYYY') AS HIRE_YEAR, deptno, COUNT(*) AS cnt FROM emp GROUP BY TO_CHAR(hiredate, 'YYYY'), deptno;
    
------------------------------------------------------------------------------------------------------------------------------------------------------------
-- JOIN ~ ON : 여러 개의 테이블에서 데이터를 조회
    -- 조건 
        -- 두개를 연결해주는 칼럼이 있어야 한다. (참조키)
        
    -- 내부조인(INNER JOIN) (★)
        -- 등가조인, 단순조인
        -- 두 테이블 내 공통집합만 조회한다
    -- 외부조인(OUTER JOIN) (★)
        -- left outer join, right outer join, full outer join > 일치하지 않는것도 조회( left / right outer join 은 일치하지 않는 데이터의 위치 )
        -- 두 테이블 내에서 일치하지 않는 데이터도 조회한다.
    -- 자체조인(SELF JOIN)
        -- 자기 자신 두번 호출하여, 데이터를 비교, 조회한다.
    -- 상호조인
    -- UNION 조인
------------------------------------------------------------------------------------------------------------------------------------------------------------
    -- 내부조인 : 일치하는 컬럼을 기준으로 값 가져오기 ( 교집합 개념 )
        -- 형식 : SELECT x.X컬럼, y.Y컬럼 FROM X테이블 x, Y테이블 y WHERE x.공통컬럼 = y.공통컬럼;
        -- 형식 : SELECT x.X컬럼, y.Y컬럼 FROM X테이블 x (INNER) JOIN Y테이블 y ON x.공통컬럼 = y.공통컬럼;
    SELECT empno, ename, e.deptno, dname, loc FROM emp e, dept d WHERE e.deptno = d.deptno; -- 조회하고자 하는 테이블의 컬럼이 중복되는 경우, 반드시 테이블 별칭으로 지정을 해줘야한다.
    SELECT empno, ename, e.deptno, dname, loc FROM emp e INNER JOIN dept d ON e.deptno = d.deptno; -- 표준 문법

-- [실습] 부서번호가 일치하는 사원들의 정보 출력, 급여가 3000 이상만 출력
    SELECT empno, ename, e.deptno, dname, loc FROM emp e INNER JOIN dept d ON e.deptno = d.deptno AND sal >= 3000;
-- [실습] 부서번호가 일치하는 사원들의 정보 출력, 급여가 2500 이하, 사원번호 9999 이하인 사원 출력
    SELECT empno, ename, e.deptno, dname, loc FROM emp e JOIN dept d ON e.deptno = d.deptno AND e.sal <= 2500 AND e.empno <= 9999;
    SELECT empno, ename, e.deptno, dname, loc FROM emp e, dept d WHERE e.deptno = d.deptno AND e.sal <= 2500 AND e.empno <= 9999;


    -- 비등가조인 : 값이 범위의 형태로, 완전히 같은 값 X ( BETWEEN a AND b 사용 )
-- [실습] emp, salgrade 조인
    SELECT empno, ename, job, mgr, hiredate, e.sal, comm, deptno, s.grade FROM emp e JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal;
    
    -- 외부조인 ( 합집합 개념 )
        -- 형식 : SELECT x.X컬럼, y.Y컬럼 FROM X테이블 x LEFT OUTER JOIN Y테이블 y ON x.공통컬럼 = y.공통컬럼; > 왼쪽 테이블 기준으로, 반대쪽 테이블에 데이터가 없더라도 조회한다.
        -- 형식 : SELECT x.X컬럼, y.Y컬럼 FROM X테이블 x RIGHT OUTER JOIN Y테이블 y ON x.공통컬럼 = y.공통컬럼; > 오른쪽 테이블 기준으로, 반대쪽 테이블에 데이터가 없더라도 조회한다.
    SELECT e1.empno, e1.ename, e1.mgr, e2.empno AS MGR_EMPNO, e2.ename AS MGR_ENAME FROM emp e1 LEFT OUTER JOIN emp e2 ON e1.mgr = e2.empno;
    SELECT e1.empno, e1.ename, e1.mgr, e2.empno AS MGR_EMPNO, e2.ename AS MGR_ENAME FROM emp e1 RIGHT OUTER JOIN emp e2 ON e1.mgr = e2.empno;

    -- 자체조인 : 자기 자신 테이블을 조인
    SELECT e1.empno, e1.ename, e1.mgr, e2.empno AS MGR_EMPNO, e2.ename AS MGR_ENAME FROM emp e1 JOIN emp e2 ON e1.mgr = e2.empno;


-- [실습] 각 부서별 평균 급여, 최대급여, 최소급여, 사원수 출력(단, 부서코드, 부서명도 함께 조회한다.)
    SELECT d.deptno, dname, ROUND(AVG(sal)), MAX(sal), MIN(sal), COUNT(*) FROM emp e JOIN dept d ON e.deptno = d.deptno GROUP BY d.deptno, dname;
-- [실습] 모든 부서정보와 사원정보를 출력(부서번호, 부서명, 사원번호, 사원명, 직책, 급여), 부서번호의 오름차순, 사원번호의 오름차순
    SELECT e.deptno, dname, empno, ename, job, sal FROM emp e RIGHT OUTER JOIN dept d ON e.deptno = d.deptno ORDER BY d.deptno, e.empno;
    
    -- 3개의 테이블 조인
    SELECT e1.empno, e2.empno, e3.empno FROM emp e1 JOIN emp e2 ON e1.empno = e2.empno JOIN emp e3 ON e2.empno = e3.empno;
    
-- [실습] 모든 부서정보와 사원정보, 급여등급 정보, 각 사원의 직속 상관의 정보를 부서번호, 사원번호 순으로 정렬하여 출력하는 SQL 문을 작성하시오.
    SELECT e1.deptno, dname, e1.empno, e1.ename, e1.mgr, e1.sal, d.deptno AS deptno_1, losal, hisal, grade, e2.empno AS MGR_EMPNO, e2.ename AS MGR_ENAME 
    FROM emp e1 LEFT OUTER JOIN emp e2 ON e1.mgr = e2.empno RIGHT OUTER JOIN dept d ON e1.deptno = d.deptno LEFT OUTER JOIN salgrade s ON e1.sal BETWEEN s.losal AND s.hisal ORDER BY e1.deptno, e1.empno;
    -- ANSWER
        SELECT d.deptno, d.dname, e1.empno, e1.ename, e1.mgr, e1.sal, e1.deptno AS DEPTNO_1, s.losal, s.hisal, s.grade, e2.empno AS MGR_EMPNO, e2.ename AS MGR_ENAME 
        FROM emp e1 RIGHT OUTER JOIN dept d ON e1.deptno = d.deptno LEFT OUTER JOIN salgrade s ON e1.sal BETWEEN s.losal AND s.hisal LEFT OUTER JOIN emp e2 ON e1.mgr = e2.empno ORDER BY e1.deptno, e1.empno;
------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Sub QUERY : 쿼리문 안에 또 다른 쿼리문이 존재
    -- SELECT 조회할 열 FROM 테이블 WHERE 조건식 (SELECT 조회할 열 FROM 테이블명 WHERE 조건식);
    -- SELECT 조회할 열 FROM (SELECT 조회할 열 FROM 테이블 WHERE 조건식) WHERE 조건식;
    
    -- 실행 결과가 하나로 나오는 단일행 서브쿼리 사용 연산자 ( >, >=, <, <=, <, <>, ~=, !=, = ... )
        -- 비교하고자 하는 조건식 과 서브쿼리의 조회 컬럼의 형식이 일치해야 한다.
        
    -- 실행결과가 여러개로 나오는 다중행 서브쿼리 사용 연산자 ( IN, ANY(SOME), ALL, EXISTS )
        -- IN : 서브쿼리가 반환한 여러 결과 값 중에서 메인쿼리의 조건 값과 일치하면 TRUE 로 반환한다 ( = 의 개념 )
        -- ANY(SOME) : 서브쿼리가 반환한 여러 결과 값 중에서 메인쿼리의 조건식 중 하나라도 TRUE 라면 메인쿼리 조건식을 TRUE 로 반환한다. ( <, <=, =, >=, > ... 사용 가능 ) ( 모든 값에 대해 OR 조건식 )
        -- ALL : 서브쿼리가 반환한 여러 결과 값 중에서 메인쿼리의 조건식 모두 TRUE 라면 메인쿼리 조건식을 TRUE 로 반환한다.  ( 모든 값에 대해 AND 조건식)
        
    -- 다중 열 서브쿼리
        -- SELECT 조회할 열 FROM 테이블 WHERE (조건1, 조건2) 연산자 (SELECT 비교열1, 비교열2 FROM 테이블명 WHERE 조건식)
    
    -- FROM 절에 사용하는 서브쿼리 (인라인뷰) : 메모리 관리 차원에서 효율성 ↑
        -- 조회할 테이블을 미리 제한하여 데이터를 조회
        
------------------------------------------------------------------------------------------------------------------------------------------------------------
    -- 단일행 서브쿼리
    SELECT * FROM emp WHERE sal > (SELECT sal FROM emp WHERE ename = 'JONES');
    SELECT * FROM emp WHERE comm > (SELECT comm FROM emp WHERE ename = 'ALLEN');
    SELECT * FROM emp WHERE hiredate < (SELECT hiredate FROM emp WHERE ename = 'WARD');
    SELECT e.empno, e.ename, e.job, e.sal, d.deptno, d.dname, d.loc FROM emp e JOIN dept d ON e.deptno = d.deptno WHERE d.deptno = 20 AND e.sal > (SELECT AVG(sal) FROM emp);

    -- 다중행 서브쿼리
    SELECT * FROM emp WHERE sal IN (SELECT MAX(sal) FROM emp GROUP BY deptno);
    SELECT * FROM emp WHERE sal = ANY (SELECT MAX(sal) FROM emp GROUP BY deptno); -- IN 과 같은 역할
    SELECT * FROM emp WHERE sal < ANY (SELECT MAX(sal) FROM emp GROUP BY deptno);
    SELECT * FROM emp WHERE sal > ANY (SELECT DISTINCT sal FROM emp WHERE deptno = 30);
    SELECT * FROM emp WHERE sal < ALL (SELECT DISTINCT sal FROM emp WHERE deptno = 30);

    -- 다중열 서브쿼리
    SELECT * FROM emp WHERE (deptno, sal) IN (SELECT deptno, MAX(sal) FROM emp GROUP BY deptno);

    -- FROM 절에 사용하는 서브쿼리
    SELECT empno, ename, e10.deptno, dname, loc FROM (SELECT * FROM emp WHERE deptno = 10) e10, (SELECT * FROM dept) d WHERE e10.deptno = d.deptno;
    
-- [실습] 10번 부서에 근무하는 사원 중 30번 부서에는 존재하지 않는 직책을 가진 사원정보, 부서정보를 출력 (NOT IN)
    SELECT e.*, d.* FROM (SELECT * FROM emp WHERE deptno = 10) e JOIN dept d ON e.deptno = d.deptno WHERE  job NOT IN (SELECT job FROM emp WHERE deptno = 30);
-- [실습] 직책이 'SALESMAN' 인 사람들의 최고급여보다 높은 급여를 받는 사원들의 empno, ename, sal, grade 를 출력
    SELECT empno, ename, sal, grade FROM emp e JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal WHERE sal > ALL (SELECT sal  FROM emp WHERE job = 'SALESMAN');
    -- MAX() 사용
    SELECT empno, ename, sal, grade FROM emp e JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal WHERE sal > (SELECT MAX(sal) FROM emp WHERE job = 'SALESMAN');

------------------------------------------------------------------------------------------------------------------------------------------------------------
-- DML(데이터 조작어 : 삽입, 삭제, 수정)
    -- COMMIT(커밋) : 데이터베이스에 최종 반영
    -- ROLLBACK(롤백) : 현재 반영된 것을 되돌림

    -- 삽입 ( INSERT )
        -- 형식 : INSERT INTO 테이블(칼럼1, 칼럼2 ... ) VALUES(데이터1, 데이터2 ...);
        -- 형식 : INSERT INTO 테이블 VALUES(데이터1, 데이터2 ...) >> 테이블의 모든 컬럼에 데이터 삽입
        
        -- 삽입 시, 문자·날짜 데이터는  ' ' 로 감싼다.
        -- 해당 열에 대해 데이터를 삽입하지 않을 경우, 해당 열에 대해 NULL 로 대입한다.
------------------------------------------------------------------------------------------------------------------------------------------------------------
    -- 연습용 테이블 생성
    CREATE TABLE dept_temp AS SELECT * FROM dept; -- deptno(NUMBER(2)) / dname(VARCHAR2(14)) / loc(VARCHAR2(13))
        -- 테이블의 구조만 복사
    CREATE TABLE emp_temp AS SELECT * FROM emp WHERE 1<>1; -- empno(NUMBER(4)) / ename(VARCHAR2(10)) / job(VARCHAR2(9)) / mgr(NUMBER(4)) / hiredate(DATE) / sal(NUMBER(7, 2)) / comm(NUMBER(7, 2)) / deptno(NUMBER(2))
    
    INSERT INTO dept_temp(deptno, dname, loc) VALUES(50, 'DATABASAE', 'SEOUL');
    INSERT INTO dept_temp VALUES(60, 'NETWORK', 'BUSAN');
    INSERT INTO dept_temp(deptno, dname) VALUES(70, 'JAVA');
    INSERT INTO dept_temp VALUES(80, 'PYTHON', NULL);
    
    -- INSERT ERROR
        INSERT INTO dept_temp VALUES(800, 'NETWORK', 'BUSAN'); -- value larger than specified precision allowed for this column ( 컬럼의 데이터 크기보다 더 큰 데이터가 삽입 됨 )
        INSERT INTO dept_temp VALUES('NET', 'NETWORK', 'BUSAN'); -- invalid number ( 데이터 타입이 일치하지 않음, 문자에 숫자를 입력하는 경우 자동으로 문자형으로 저장 )
        INSERT INTO dept_temp(deptno, dname) VALUES(80, 'PYTHON', NULL); -- too many values ( 삽입하고자 하는 테이블 컬럼보다, 데이터가 많음 )

    desc emp_temp;

    INSERT INTO emp_temp(empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES(9999, '홍길동', 'MANAGER', NULL, '2021-01-05', 5000, 1000, 10);
    INSERT INTO emp_temp(empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES(8888, '성춘향', 'MANAGER', 9999, sysdate, 4000, 500, 20);

-- [실습] emp 테이블에서 부서번호가 20 번인 사원들만 emp_temp 로 삽입
    INSERT INTO emp_temp SELECT * FROM emp WHERE deptno = 20;
    SELECT * FROM emp WHERE deptno = 20;
-- [실습] emp 테이블에서 salgrade 테이블을 참조하여, 등급이 1인 사원을 emp_temp 에 추가
    INSERT INTO emp_temp VAULES (SELECT e.* FROM emp e JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal WHERE grade = 1);
    SELECT e.* FROM emp e JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal WHERE grade = 1;

------------------------------------------------------------------------------------------------------------------------------------------------------------
-- DML(데이터 조작어 : 삽입, 삭제, 수정)
    -- 수정 ( UPDATE )
        -- 형식 : UPDATE 테이블 SET 변경 컬럼 = 값, 변경 컬럼 = 값 ... WHERE 조건식;
        -- WHERE 가 없으면, 모든 행에 대해 수정 작업
------------------------------------------------------------------------------------------------------------------------------------------------------------

    UPDATE dept_temp SET loc = 'SEOUL'; -- 모든 행의 loc 를 'SEOUL' 로 수정
    UPDATE dept_temp SET loc = 'BUSAN' WHERE deptno = 50;
    UPDATE emp_temp SET comm = 300 WHERE sal <= 3000;
    UPDATE emp_temp SET sal = 1500 WHERE empno = 7369;

-- [실습] dept 테이블에서 부서번호가 40번인 부서명과 지역 추출하여 dept_temp 테이블을 수정
    UPDATE dept_temp SET (dname, loc) = (SELECT dname, loc FROM dept WHERE deptno = 40);
    SELECT dname, loc FROM dept WHERE deptno = 40;
-- [실습] dname 이 'OPERATIONS'인 부서번호를 추출하여, 추출된 부서번호와 일치하는 부서번호의 지역을 'SEOUL' 로 수정
    UPDATE dept_temp SET loc = 'SEOUL' WHERE deptno = (SELECT deptno FROM dept WHERE dname = 'OPERATIONS'); 

------------------------------------------------------------------------------------------------------------------------------------------------------------
-- DML(데이터 조작어 : 삽입, 삭제, 수정)
    -- 삭제 ( DELETE )
        -- 형식 : DELETE FROM 테이블 WHERE 조건;
        -- 형식 : DELETE 테이블 WHERE 조건;
        -- 형식 : DELETE FROM 테이블 조건;
------------------------------------------------------------------------------------------------------------------------------------------------------------

    DELETE FROM emp_temp WHERE job = 'ANALYST';
    DELETE emp_temp; -- 모든 내용만 삭제 ( 테이블 구조는 남김 )


-- [실습] emp_temp 에서 급여등급이 3이고, 20번 부서의 사원만 삭제
    DELETE FROM emp_temp WHERE empno in (SELECT empno FROM emp_temp e JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal WHERE e.deptno = 20 AND s.grade = 3);
    SELECT empno FROM emp_temp e JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal WHERE e.deptno = 20 AND s.grade = 3;


    SELECT * FROM dept_temp; -- dept_temp INSERT 확인용 SELECT 문
    SELECT * FROM emp_temp; -- emp_temp INSERT 확인용 SELECT 문


-- [실습] 실습을 위하여 기존 테이블을 이용하여 테이블을 생성한다.
-- ① EMP 테이블의 내용을 이용하여 EXAM_EMP 생성
    CREATE TABLE exam_emp AS SELECT * FROM emp;
        INSERT INTO exam_emp VALUES(7201, 'TEST_USER1', 'MANAGER', 7788, '2016-01-02', 4500, null, 50);
        INSERT INTO exam_emp VALUES(7202, 'TEST_USER2', 'CLERK', 7201, '2016-02-21', 1800, null, 50);
        INSERT INTO exam_emp VALUES(7203, 'TEST_USER3', 'ANALYST', 7201, '2016-04-11', 3400, null, 60);
        INSERT INTO exam_emp VALUES(7204, 'TEST_USER4', 'SALESMAN', 7201, '2016-05-31', 2700, 300, 60);
        INSERT INTO exam_emp VALUES(7205, 'TEST_USER5', 'CLERK', 7201, '2016-07-20', 2600, null, 70);
        INSERT INTO exam_emp VALUES(7206, 'TEST_USER6', 'CLERK', 7201, '2016-09-08', 2600, null, 70);
        INSERT INTO exam_emp VALUES(7207, 'TEST_USER7', 'LECTURER', 7201, '2016-10-28', 2300, null, 80);
        INSERT INTO exam_emp VALUES(7208, 'TEST_USER8', 'STUDENT', 7201, '2018-03-09', 1200, null, 80);

        SELECT * FROM exam_emp;
-- ② DEPT 테이블의 내용을 이용하여 EXAM_DEPT 생성
    CREATE TABLE exam_dept AS SELECT * FROM dept;
    
        SELECT * FROM exam_dept;
-- ③ SALGRADE 테이블의 내용을 이용하여 EXAM_SALGRADE 생성
    CREATE TABLE exam_salgrade AS SELECT * FROM salgrade;
    
        SELECT * FROM exam_salgrade;

    -- [실습_1] EXAM_EMP에 속한 사원 중, 50번 부서에서 근무하는 사원들의 평균급여보다 많은 급여를 받고 있는 사원들을 70번 부서로 옮기는 SQL문 작성
    UPDATE exam_emp SET deptno = 70 WHERE sal > (SELECT AVG(sal) FROM exam_emp WHERE deptno = 50);
    -- [실습_2] EXAM_EMP에 속한 사원 중, 60번 부서의 사원 중에서 입사일이 가장 빠른 사원보다 늦게 입사한 사원의 급여를 10% 인상하고 80번 부서로 옮기는 SQL 문 작성
    UPDATE exam_emp SET deptno = 80, sal = sal * 1.1 WHERE empno IN (SELECT empno FROM exam_emp WHERE hiredate > (SELECT MIN(hiredate) FROM exam_emp WHERE deptno = 60));
    UPDATE exam_emp SET sal = sal * 1.1, deptno = 80 WHERE hiredate > (SELECT MIN(hiredate) FROM exam_emp WHERE deptno = 60);
    -- [실습_3] EXAM_EMP에 속한 사원 중, 급여등급이 5인 사원을 삭제하는 SQL 문 작성
    DELETE FROM exam_emp WHERE empno IN (SELECT empno FROM exam_emp e JOIN exam_salgrade s ON e.sal BETWEEN s.losal AND s.hisal WHERE s.grade = 5);

------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Transaction(트랜잭션 : 분할 할 수 없는 최소 수행단위) > 관계형 DB 에서 하나의 작업 또는 밀접하게 관련(ex))계좌이체 : A계좌(-) , B계좌(+))되어 있는 작업수행을 위해 나눌 수 없는 최소 수행 단위
    -- 하나의 트랜잭션 내에 있는 여러 명령어(DML)를 한번에 수행하여 작업을 완료(COMMIT)하거나 아예 모두 수행하지 않는 상태(ROLLBACK)로 만듦
    -- TCL (Transaction Control Language)
        -- COMMIT : 트랜잭션 반영
        -- ROLLBACK : 트랜잭션 취소
------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    CREATE TABLE dept_tcl AS SELECT * FROM dept;
    
    
    -- 트랜잭션과 관련있는 명령어 ( DML )
    INSERT INTO dept_tcl VALUES(50, 'DATABASE', 'SEOUL');
    UPDATE dept_tcl SET loc = 'BUSAN' WHERE deptno = 40;
    DELETE FROM dept_tcl WHERE dname = 'RESEARCH';
        -- 하나의 트랜잭션 단위 ( COMMIT 이전에는 확정이 되지 않은 상태, ROLLBACK 하면 작업 이전 상태로 복원 )

    -- Session : 어떤 활동을 위한 시간이나 기간
    -- Database Session : 데이터베이스 점속을 시작으로 여러 데이터베이스에서 작업을 수행한 후 접송 종료
        -- DB Session 다수 생성 가능
        -- 서로 다른 세션의 경우, COMMIT 명령어 실행 전까지 다른 세션에 영향을 주지 않음
        -- LOCK : 한 세션에서 트랜잭션을 처리하지 않은 상태로, 다른 세션에서 또 다른 트랜잭션을 생성할 경우 LOCK 발생 ( 처리하지 않은 트랜잭션을 COMMIT 해주면 다른 세션의 트랜잭션이 시작된다. )
        -- ∴ TCL 은 DB 세션 단위로 이루어지며, 하나의 세션에서 SQL 문 처리 후 COMMIT 까지 실행을 해야 최종적으로 모든 DB 세션에 반영이 된다
            -- SQL Command Line : conn DB ID / DB password
                    -- SQL 문 입력 가능
                
    DELETE FROM dept_tcl WHERE deptno = 50;
    UPDATE dept_tcl SET loc='SEOUL' WHERE deptno = 30;
    
        
    SELECT * FROM dept_tcl;
    
    ROLLBACK;
    
    COMMIT;

------------------------------------------------------------------------------------------------------------------------------------------------------------
-- DDL( : 데이터 정의어 ) : 객체( TABLE, SEQUENCE, VIEW ... ) 생성(CREATE), 변경(ALTER), 삭제(DROP) § COMMIT 필요 X
------------------------------------------------------------------------------------------------------------------------------------------------------------
    -- 테이블 생성 ( CREATE )
        -- 형식
        --    CREATE TABLE table_name(
        --        Column NAME DATATYPE,
        --        Column NAME DATATYPE,
        --        Column NAME DATATYPE);

        -- 테이블명 규칙
            -- ① 문자로 시작 ( 첫 글자는 무조건 문자, 숫자 X )
            -- ② 너무 길지 않은 문자
            -- ③ 같은 사용자 소유의 테이블명 중복 불가
            -- ④ 영문자 사용 ( 한글, 특수문자 사용가능하지만 주로 사용되지는 않음 (단, 특수문자 '_' 의경우 자주 사용 ))
            -- ⑤ SQL 키워드는 테이블명으로 사용 불가 (SELECT, DROP, WHERE ...)

        -- DATATYPE ( 자료형 )
            -- 문자 
                    -- CHAR(N) - 고정길이, N의 BYTE 를 갖는 문자 DATA (한글 3BYTE, 영문 1BYTE);
                    -- VARCHAR2(N) - 가변길이, 최대 N의 BYTE를 갖고 있으나, 문자데이터의 길이에 맞춰 메모리 할당 ( ★ )
                    -- NCHAR(N) - 고정길이, UNICODE 지원 ( 한글, 영어 모두 N개의 길이를 가질 수 있음 )
                    -- NVARCHAR2(N) - 가변길이, UNICODE를 지원하며, 최대 N의 길이를 지원하며, 문자 길이에 맞춰 메모리 할당
            -- 숫자
                    -- NUMBER(숫자1, 숫자2) : 숫자1 ( 자릿수 ), 숫자2 (소수점 자릿수) ( ★ )
                        -- ex ) empno NUMBER(4) : 숫자로 4자리 허용
                        --        price NUMBER(7, 2) : 숫자로 7자리 허용, 소수점 자리는 2자리 허요
                        --        job NUMBER : 저장 데이터 크기에 맞게 자동조절 (가변)
            -- 날짜
                    -- DATE : 연, 월, 일, 시, 분, 초 표기 ( ★ )
                    -- TIMESTAMP : 연, 월, 일, 시, 분, 초 표기 + 밀리 초 표기

    CREATE TABLE emp_ddl(
        empno NUMBER(4),
        ename VARCHAR2(10),
        job VARCHAR2(9),
        mgr NUMBER(4),
        hiredate DATE,
        sal number(7, 2),
        comm number(7, 2),
        deptno number(2));
        
        -- 다른 테이블의 모든 데이터를 복사하는 방법
            -- CREATE TABLE table_name AS SELECT * FROM 복사할 테이블;
        -- 다른 테이블의 구조만 복사하는 방법
            -- CREATE TABLE table_name AS SELECT * FROM 복사할 테이블 WHERE 1<>1; 
            
    -- 테이블 제거 (DROP)
    DROP TABLE emp_ddl;
    
    -- 테이블 변경 (ALTER) : 테이블 내 데이터가 있을 때, 변경할 경우 현재 데이터의 자료의 길이와 맞지 않다면 변경 불가
        -- Column 추가 ; ADD
        ALTER TABLE emp_ddl ADD hp VARCHAR2(20);
        -- Column 명 변경 : RENAME COLUMN ~ TO
        ALTER TABLE emp_ddl RENAME COLUMN hp TO tel;
        -- Column 자료형 변경 : MODIFY
        ALTER TABLE emp_ddl MODIFY empno NUMBER(5);
        -- Column 삭제 : DROP COLUMN
        ALTER TABLE emp_ddl DROP COLUMN tel;
        
    -- Table 명 변경 : RNAME
    RENAME emp_ddl TO emp_rename;
        
        -- Table Default 설정
            CREATE TABLE table_default(
                login_id VARCHAR2(20) PRIMARY KEY,
                login_pwd VARCHAR2(20) DEFAULT '1234',
                tel VARCHAR2(20)); 
                
            -- DML
            INSERT INTO table_default VALUES('test_id1', null, '000-1111-2222'); -- NULL 을 명시하면, NULL 값 삽입
            INSERT INTO table_default(login_id, tel) VALUES('test_id2', '000-1111-2222'); -- NULL을 명시하지 않고 공백으로 두면, DEFAULT 값이 삽입된다.

            SELECT * FROM table_default;
        
    desc emp_ddl;
    
-- [실습] emp_hw 테이블 생성
    CREATE TABLE emp_hw (
        id CHAR(8),
        name NVARCHAR2(10),
        addr NVARCHAR2(50),
        nation NCHAR(4),
        email VARCHAR2(50),
        age NUMBER(7, 2));
        
-- [실습] emp_hw 테이블 변경
    -- 1 . emp_hw 테이블에 BIGO 열 추가 (가변형 문자열, 길이 20)
        ALTER TABLE emp_hw ADD BIGO VARCHAR2(20);
    -- 2 . emp_hw 테이블의 BIGO 열 크기를 30으로 변경
        ALTER TABLE emp_hw MODIFY BIGO VARCHAR2(30);
    -- 3 . emp_hw 테이블의 BIGO 열 이름을 REMARK로 변경
        ALTER TABLE emp_hw RENAME COLUMN BIGO TO REMARK;
        
        desc emp_hw;
        
------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 제약조건 ( 테이블의 특정 열에 지정하여, DB에 입력되는 데이터를 제어한다 )
        -- 데이터의 입력, 수정, 삭제 영향을 주어 (데이터의 무결성(정확성, 일관성) 유지)
    -- NOT NULL : 지정한 열에 NULL 을 허용하지 않음
    -- UNIQUE : 지정한 열이 유일한 값을 가져야 함
    -- PRIMARY KEY : 지정한 열이 유일한 값이면서, NULL이 아님 ( 하나의 COLUMN 만 지정 ) 
    -- FOREIGN KEY : 다른 테이블의 열을 참조하여 존재하는 값만 입력 가능
    -- CHECL : 설정한 조건식을 만족하는 데이터만 입력 가능
    
    -- 접속한 DB 세션이 사용한 모든 제약조건 확인 가능
    SELECT * FROM user_constraints;
------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    -- NOT NULL 제약조건
        CREATE TABLE table_notnull(
            login_id VARCHAR2(20) NOT NULL,
            login_pwd VARCHAR2(20) NOT NULL,
            tel VARCHAR2(20)); 
        
        desc table_notnull;
        
        -- DML
        INSERT INTO table_notnull VALUES('test_id_01', null, '010-1234-5678'); -- cannot insert NULL > 에러발생
        INSERT INTO table_notnull(login_id, tel) VALUES('test_id_01', '010-1234-5678'); -- cannot insert NULL 
        INSERT INTO table_notnull(login_id, login_pwd) VALUES('test_id_01', '12345'); -- COLUMN tel 은 NOT NULL 제약조건이 없어 정상 작동
        UPDATE table_notnull SET login_pwd = NULL WHERE login_id = 'test_id_01'; -- cannot update ("SCOTT"."TABLE_NOTNULL"."LOGIN_PWD") to NULL
        UPDATE table_notnull SET tel = '000-1234-1111' WHERE login_id = 'test_id_01';
    
    -- UNIQUE 제약조건
        CREATE TABLE table_unique(
            login_id VARCHAR2(20) UNIQUE,
            login_pwd VARCHAR2(20) NOT NULL,
            tel VARCHAR2(20)); 
            
        desc table_unique;
            
        -- DML
        INSERT INTO table_unique(login_id, login_pwd, tel) VALUES('test_id_01', '12345', '000-1111-2222');
        INSERT INTO table_unique(login_id, login_pwd, tel) VALUES('test_id_01', '99999', '000-1111-2222'); -- unique constraint (SCOTT.SYS_C007016) violated > UNIQUE 제약조건 위배
        INSERT INTO table_unique(login_id, login_pwd, tel) VALUES(NULL, '99999', '000-1111-2222'); -- login_id 컬럼에 NOT NULL 제악조건은 없기 때문에 정상 작동
        
    -- PRIMARY KEY(PK) 제약조건 ( NOT NULL + UNIQUE )
         CREATE TABLE table_pk(
            login_id VARCHAR2(20) PRIMARY KEY,
            login_pwd VARCHAR2(20) NOT NULL,
            tel VARCHAR2(20)); 
            
        CREATE TABLE table_pk2(
            login_id VARCHAR2(20) PRIMARY KEY,
            login_pwd VARCHAR2(20) PRIMARY KEY,
            tel VARCHAR2(20)); -- table can have only one primary key > PK 는 1개만 지정 가능
        
        --DML
        INSERT INTO table_pk(login_id, login_pwd, tel) VALUES('test_id_01', '12345', '000-1111-2222');
        INSERT INTO table_pk(login_id, login_pwd, tel) VALUES('test_id_01', '12345', '000-1111-2222'); -- unique constraint (SCOTT.SYS_C007021) violated
        INSERT INTO table_pk(login_id, login_pwd, tel) VALUES(NULL, '12345', '000-1111-2222'); -- cannot insert NULL into ("SCOTT"."TABLE_PK"."LOGIN_ID")

        
    -- FOREIGN KEY(FK) 제약조건
        -- 참조하는 테이블의 열이 갖고 있는 값만 가져온다
            -- 조건
                -- 참조하고하는 테이블의 PK Column 값을 참조해야한다.
        CREATE TABLE dept_fk(
            deptno NUMBER(2) CONSTRAINT deptfk_deptno_pk PRIMARY KEY,
            dname VARCHAR2(20),
            loc VARCHAR2(13));
            
        CREATE TABLE emp_fk(
            empno NUMBER(4) CONSTRAINT empfk_empno_pk PRIMARY KEY,
            ename VARCHAR2(10),
            deptno NUMBER(2) CONSTRAINT empfk_deptno_fk REFERENCES dept_fk(deptno));
        
        -- DML
        INSERT INTO emp_fk VALUES(7899, 'HONG', 20); -- integrity constraint (SCOTT.EMPFK_DEPTNO_FK) violated - parent key not found > 부모키( 참조하고자 하는 테이블의 기본키 )
            -- 부모테이블의 데이터가 먼저 삽입된 후, 자식테이블에서 해당 테이블의 키를 참조한다.
        INSERT INTO dept_fk VALUES(10, 'DATABASE', 'SEOUL');
        INSERT INTO emp_fk VALUES(7899, 'HONG', 10); -- 부모테이블의 deptno (10) 을 참조하여 가져왔기 때문에, 정상작동
        
        -- 삭제시 발생하는 문제
        DELETE FROM dept_fk WHERE deptno = 10; -- integrity constraint (SCOTT.EMPFK_DEPTNO_FK) violated - child record found > 자식테이블에서 해당 키를 참조하고 있기 때문에 삭제 불가
            -- 자식테이블의 참조하고 있는 데이터를 모두 삭제한 후, 부모테이블의 데이터를 삭제
        DELETE FROM emp_fk WHERE deptno = 10;
        DELETE FROM dept_fk WHERE deptno = 10; -- 자식테이블의 참조하고 있는 deptno (10) 데이터를 삭제했기 때문에, 정상작동 
        
            -- 부모 데이터를 삭제할 때 참조하고 있는 데이터도 함께 삭제 : ON DELETE CASCADE (부모테이블 열 데이터 삭제시 참조 데이터 함께 삭제)
                -- ex ) 게시판의 댓글 관리
            CREATE TABLE dept_fk2(
                deptno NUMBER(2) CONSTRAINT deptfk2_deptno_pk PRIMARY KEY,
                dname VARCHAR2(20),
                loc VARCHAR2(13));
                
            CREATE TABLE emp_fk2(
                empno NUMBER(4) CONSTRAINT empfk2_empno_pk PRIMARY KEY,
                ename VARCHAR2(10),
                deptno NUMBER(2) CONSTRAINT empfk2_deptno_fk REFERENCES dept_fk2(deptno) ON DELETE CASCADE);
                
                -- DML
                INSERT INTO dept_fk2 VALUES(10, 'DATABASE', 'SEOUL');
                INSERT INTO emp_fk2 VALUES(7899, 'HONG', 10);
                
                DELETE FROM dept_fk2 WHERE deptno = 10; -- dept_fk2 를 참조하고 있는 emp_fk2 데이터도 함꼐 삭제 됨
                SELECT * FROM emp_fk2;
            -- 부모 데이터를 삭제할 때 참조하고 있는 데이터를 NULL 로 수정 : ON DELETE SET NULL (부모테이블 열 데이터 삭제시 참조 데이터 NULL 로 수정)
            CREATE TABLE dept_fk3(
                deptno NUMBER(2) CONSTRAINT deptfk3_deptno_pk PRIMARY KEY,
                dname VARCHAR2(20),
                loc VARCHAR2(13));
                
            CREATE TABLE emp_fk3(
                empno NUMBER(4) CONSTRAINT empfk3_empno_pk PRIMARY KEY,
                ename VARCHAR2(10),
                deptno NUMBER(2) CONSTRAINT empfk3_deptno_fk REFERENCES dept_fk3(deptno) ON DELETE SET NULL);
        
                -- DML
                INSERT INTO dept_fk3 VALUES(10, 'DATABASE', 'SEOUL');
                INSERT INTO emp_fk3 VALUES(7899, 'HONG', 10);
                
                DELETE FROM dept_fk3 WHERE deptno = 10; -- dept_fk2 를 참조하고 있는 emp_fk2 데이터가 NULL 로 수정 됨
                SELECT * FROM emp_fk3;
        
    -- CHECK ( DB 에서 작업하는 것보다, 서버측(JavaScript) 에서 주로 처리 )
        CREATE TABLE tbl_check(
            login_id VARCHAR2(20) CONSTRAINT tblck_lgnid_pk PRIMARY KEY,
            login_pwd VARCHAR2(20) CONSTRAINT tblck_lgnpwd_ck CHECK (LENGTH(login_pwd) > 3),
            tel VARCHAR2(20)); 
        
        -- DML
        INSERT INTO tbl_check VALUES('test_id1', '123', '010-1234-5555'); -- check constraint (SCOTT.TBLCK_LGNPWD_CK) violated > (LENGTH(login_pwd) > 3)
        INSERT INTO tbl_check VALUES('test_id1', '1234', '010-1234-5555'); -- login_pwd 가 4자리로, 조건 충족 > 정상 작동
        
        
        
    -- 제약조건명 지정 ( 지정하지 않을경우, DB 에서 자동으로 name 값을 부여하여 지정된다. (SYS_C007010) )
     CREATE TABLE table_notnull2(
        login_id VARCHAR2(20) CONSTRAINT tblnn2_lgnid_nn NOT NULL,
        login_pwd VARCHAR2(20) CONSTRAINT tblnn2_lgnpwd_nn NOT NULL,
        tel VARCHAR2(20));
    CREATE TABLE table_unique2(
            login_id VARCHAR2(20) CONSTRAINT tblun2_lgnid_unq UNIQUE,
            login_pwd VARCHAR2(20) CONSTRAINT tblun2_lgnpwd_nn NOT NULL,
            tel VARCHAR2(20)); 
    CREATE TABLE table_pk2(
            login_id VARCHAR2(20) CONSTRAINT tblpk2_lgnid_pk PRIMARY KEY,
            login_pwd VARCHAR2(20) CONSTRAINT tblpk2_lgnpwd_nn NOT NULL,
            tel VARCHAR2(20)); 
            
        -- 제약조건 지정 방식
        CREATE TABLE table_con(
            login_id VARCHAR2(20),
            login_pwd VARCHAR2(20),
            tel VARCHAR2(20),
            CONSTRAINT tblcon_pk PRIMARY KEY(login_id),
            UNIQUE(login_pwd)); 
            
    -- 제약조건 추가
    ALTER TABLE table_notnull MODIFY(tel NOT NULL); -- cannot enable (SCOTT.) - null values found ( 내부 데이터에 NULL 값이 존재하기 때문에 )
    ALTER TABLE table_unique2 MODIFY(tel UNIQUE);
    -- 제약조건 이름 변경
    ALTER TABLE table_notnull2 RENAME CONSTRAINT tblnn2_lgnid_nn TO tblnn2_id_nn;
    -- 제약조건 삭제
    ALTER TABLE table_notnull2 DROP CONSTRAINT tblnn2_id_nn;
    
-- [실습] DEPT_CONST 테이블과 EMP_CONST 테이블을 다음과 같은 특성 및 제약조건을 지정하여 생성
    CREATE TABLE dept_const(
        deptno NUMBER(2) CONSTRAINT deptconst_deptno_pk PRIMARY KEY,
        dname VARCHAR2(14) CONSTRAINT deptconst_dname_unq UNIQUE,
        loc VARCHAR2(13) CONSTRAINT deptconst_loc_nn NOT NULL);
        
    CREATE TABLE emp_const(
        empno NUMBER(2) CONSTRAINT empconst_empno_pk PRIMARY KEY,
        ename VARCHAR2(10) CONSTRAINT empconst_ename_nn NOT NULL,
        job VARCHAR2(9),
        tel VARCHAR2(20) CONSTRAINT empconst_tel_unq UNIQUE,
        hiredate DATE,
        sal NUMBER(7, 2) CONSTRAINT empconst_sal_chk CHECK (sal BETWEEN 1000 AND 9999),
        comm NUMBER(7, 2),
        deptno NUMBER(2) CONSTRAINT empconst_deptno_fk REFERENCES dept_const(deptno));

------------------------------------------------------------------------------------------------------------------------------------------------------------
-- SEQUENCE (시퀀스) : 규칙에 따라 순번을 생성 ( 단독 객체 )
    -- 형식 : CREATE SEQUENCE sequence_name;
    
    --           CREATE SEQUENCE sequence_name
    --               INCREMENT BY 증감 값
    --               START WITH 시작 값
    --               MAXVALUE 최대 값
    --               MINVALUE 최소 값
    --               NOCYCLE ( 최대값 도달 시, 순환 여부 )  > sequence DEPT_SEQ.NEXTVAL exceeds MAXVALUE and cannot be instantiated 최대 값 도달 시 순환을 하지 않기 때문에 MAXVALUE 에 막힘
    --               CACHE 2;
    
    -- 사용 : sequence_name.NEXTVAL > 규칙에 맞는 다음 값
    --          sequence_name.CURRVAL > 마지막으로 사용된 값
    
    
    -- SEQUENCE 정보
        -- CREATED	22/03/25 >>>> 생성 날짜
        -- LAST_DDL_TIME	22/03/25 >>>> 마지막 사용 날짜
        -- SEQUENCE_OWNER	SCOTT >>>> 소유 계정
        -- SEQUENCE_NAME	DEPT_SEQ >>>> 지정 이름
        -- MIN_VALUE	1 >>>> 최소 값
        -- MAX_VALUE	9999999999999999999999999999 >>>> 최대 값
        -- INCREMENT_BY	1 >>>> 증감 값
        -- CYCLE_FLAG	N >>>> 최대 값 도달 시 순환 여부 (Y : CYCLE / N : NOCYCLE)
        -- ORDER_FLAG	N
        -- CACHE_SIZE	20 >>>> 시퀀스가 생성할 번호를 메모리에 미리 할당해 놓은 수를 지정
        -- LAST_NUMBER	1
------------------------------------------------------------------------------------------------------------------------------------------------------------

    CREATE SEQUENCE dept_seq; -- 단독 객체 ( 테이블에 종속되지 않음 )
    
    CREATE TABLE dept_sequence AS SELECT * FROM dept WHERE 1<>1;
    
    SELECT * FROM dept_sequence;
    
    INSERT INTO dept_sequence(deptno, dname, loc) VALUES(dept_seq.NEXTVAL, 'ORACLEDATABASEANDJAVA', 'SEOUL'); -- INSERT 실패 시, NEXTVAL 로 발행한 숫자를 스킵하고, 새로운 번호를 발행한다.
    INSERT INTO dept_sequence(deptno, dname, loc) VALUES(dept_seq.NEXTVAL, 'DATABASE', 'SEOUL');

    SELECT dept_seq.CURRVAL FROM dual;
    
    DROP SEQUENCE dept_seq;

    -- 옵션지정 생성
    CREATE SEQUENCE dept_seq
        INCREMENT BY 10
        START WITH 10
        MAXVALUE 90
        MINVALUE 0
        NOCYCLE
        CACHE 2;
        
    ALTER SEQUENCE dept_seq INCREMENT BY 3 MAXVALUE 99 CYCLE; -- ALTER 실행 시점, 마지막 인덱스 값에서 INCREMENT 값이 바뀐다. 
    
    COMMIT;
    
------------------------------------------------------------------------------------------------------------------------------------------------------------
-- VIEW (뷰) : 가상 테이블 - 하나 이상의 테이블을 조회하는 SELECT 문을 저장한 객체 ( 단독 객체 )
    -- SELECT 결과문 ( JOIN, SubQUERY ) 을 저장하여 개발자가 원할떄 불러올 수 있는 객체
    -- 사용이유
        -- 편리성 ↑ ( SELECT 문의 복잡도를 완화 )
        -- 보안성 ↑ ( 테이블의 특정 열을 노출하고 싶지 않은 경우 )
            -- TABLE에서 COLUMN 마다의 접근을 제한할 수 없기 때문에, 사용하고자 하는 COLUMN 으로 VIEW 를 만들어 불필요한 데이터를 비공개처리
    
    -- 형식 : CREATE VIEW view_name AS (SELECT 쿼리문);
    
    -- 생성된 뷰의 속성 확인
        SELECT * FROM user_updatable_columns WHERE table_name='VM_EMP20'; -- OWNER / TABLE_NAME / COLUMN_NAME / UPDATABLE / INSERTABLE / DELETABLE
    
    -- 생성 옵션 ( 원본데이터 수정 )
        -- WITH READ ONLY : 뷰를 통해 원본을 수정하지 않음 (읽기전용)
        --
        CREATE VIEW vm_emp_read AS SELECT empno, ename, job FROM emp WITH READ ONLY;
        SELECT * FROM user_updatable_columns WHERE table_name='VM_EMP_READ';
        INSERT INTO vm_emp_read(empno, ename, job) VALUES(8001, 'TEST', 'MANAGER'); -- cannot perform a DML operation on a read-only view ( 읽기전용 뷰 )
------------------------------------------------------------------------------------------------------------------------------------------------------------
    CREATE VIEW vm_emp20 AS (SELECT empno, ename, job, deptno FROM emp WHERE deptno = 20);
        -- An attempt was made to perform a database operation without the necessary privileges. > 권한 X
        
    SELECT * FROM vm_emp20;
    SELECT * FROM emp;
    
    INSERT into vm_emp20(empno, ename, job, deptno) VALUES(8000, 'TEST', 'MANAGER', 20); -- 원본 테이블에도 변화가 생김 ( 뷰와 테이블은 서로 연결된 상태 )
    
    DROP VIEW vm_emp20;
    DROP VIEW vm_emp_read;
    
    
------------------------------------------------------------------------------------------------------------------------------------------------------------
-- INDEX (인덱스) : 빠른 검색을 위한 객체 ( 단독 객체 )
    -- 인덱스 사용 여부에 따라 Table Full Scan, Index Scan
    -- 형식 : CREATE INDEX index_name ON table_name(column_name1 asc, column_name2 desc ... );
    
    
    -- INDEX 사용으로 검색 속도를 올릴수는 있지만, 상황에 따라 큰 효율이 없을 수도 있다.
    
    -- 사용자가 갖고 있는 인덱스 확인
    SELECT * FROM user_indexes; -- PK 로 설정된 값들은 인덱스로 사용됨
    -- INDEX가 설정된 COLUMN 조회
    SELECT * FROM user_ind_columns;
    SELECT * FROM user_tables;
    SELECT * FROM user_constraints;
    SELECT * FROM user_views;
------------------------------------------------------------------------------------------------------------------------------------------------------------
    CREATE INDEX idx_emp_sal ON emp(sal);
    SELECT * FROM emp;
    
    DROP INDEX idx_emp_sal;
    
