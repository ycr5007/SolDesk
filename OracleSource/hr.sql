-- hr ( 연습용 계정 )
-- scott 가 갖고 있는 데이터의 원본

-- [Q1] employees Table 전체 조회
    SELECT * FROM employees;
-- [Q2] employees Table 의 first_name, last_name, job_id 조회
    SELECT first_name, last_name, job_id FROM employees;
-- [Q3] employees Table 의 모든 열 조회 
-- 별칭 : employee_id > empno, manager_id > mgr, department_id > deptno
-- 정렬 : department_id 기준으로 내림차순, 부서 번호가 같다면 first_name을 기준으로 오름차순 정렬
    SELECT employee_id AS empno, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id AS mgr, department_id AS deptno FROM employees ORDER BY department_id DESC, first_name ASC;
-- [Q4] employee_id = 176 인 사원의 last_name, department_id 조회
    SELECT last_name, department_id FROM employees WHERE employee_id = 176;
-- [Q5] 연봉이 12,000 이상 되는 직원들의 last_name, salary 조회
    SELECT last_name, salary FROM employees WHERE salary >= 12000;
-- [Q6] 연봉이 5,000 ~ 12,000 범위 사이가 아닌 사원들 조회
    SELECT * FROM employees WHERE salary > 5000 AND salary < 12000;
-- [Q7] 20번 혹은 50번 부서에서 근무하는 모든 사원들의 last_name 및 department_id 조회 후, last_name 의 오름차순 department_id 의 오름차순으로 정렬
    SELECT last_name, department_id FROM employees WHERE department_id = 20 OR department_id = 50 ORDER BY last_name ASC, department_id ASC;
-- [Q8] 커미션을 받는 모든 사원들의 last_name, salary, commission_pct를 조회한다. 연봉의 내림차순, commission_pct 의 내림차순 정렬
    SELECT last_name, salary, commission_pct FROM employees WHERE commission_pct IS NOT NULL ORDER BY salary DESC, commission_pct DESC;
-- [Q9] 연봉이 2500, 3500, 7000이 아니며, 직업이 SA_REP, ST_CLERK 인 사원 정보 전체 조회
    SELECT * FROM employees WHERE NOT salary IN (2500, 3500, 7000) AND job_id IN ('SA_REP', 'ST_CLERK');
-- [Q10] '2008-02-20' ~ '2008-05-01' 사이에 고용된 사원들의 last_name, employee_id, hire_date 조회, hire_date 의 내림차순으로 정렬
    SELECT last_name, employee_id, hire_date FROM employees WHERE hire_date >= '2008-02-20' AND hire_date <= '2008-05-01' ORDER BY hire_date DESC;
    SELECT last_name, employee_id, hire_date FROM employees WHERE hire_date BETWEEN '2008-02-20' AND  '2008-05-01' ORDER BY hire_date DESC;
-- [Q11] '2004'년도에 고용된 모든 사람들의 last_name, hire_date를 조회하여 입사일 기준으로 오름차순 정렬
    SELECT last_name, hire_date FROM employees WHERE hire_date BETWEEN '2003-12-31' AND '2005-01-01' ORDER BY hire_date ASC;
    SELECT last_name, hire_date FROM employees WHERE hire_date LIKE '04%' ORDER BY hire_date ASC;
    
-- [Q12] '2004'년도에 고용된 모든 사람들의 last_name, hire_date를 조회하여 입사일 기준으로 오름차순 정렬
    SELECT last_name, hire_date FROM employees WHERE hire_date LIKE '04%' ORDER BY hire_date ASC;
-- [Q13] last_name 에 'u' 가 포함되는 사원들의 사번 및 last_name 조회
    SELECT employee_id, last_name FROM employees WHERE last_name LIKE '%u%';
-- [Q14] last_name 의네번째 글자가  'a' 인 사원들의 사번 및 last_name 조회
    SELECT employee_id, last_name FROM employees WHERE last_name LIKE '___a%';
-- [Q15] last_name 에 'a'  혹은 'e' 가 들어있는 사원들의 사번 및 last_name 조회 후 last_name 오름차순 정렬
    SELECT employee_id, last_name FROM employees WHERE last_name LIKE '%a%' OR last_name LIKE '%e%' ORDER BY last_name ASC;
-- [Q16] last_name 에 'a'  와 'e' 가 들어있는 사원들의 사번 및 last_name 조회 후 last_name 오름차순 정렬
    SELECT employee_id, last_name FROM employees WHERE last_name LIKE '%a%' AND last_name LIKE '%e%' ORDER BY last_name ASC;
-- [Q17] 매니저가 없는 사원들의 last_name, job_id 조회
    SELECT last_name, job_id FROM employees WHERE MANAGER_ID IS NULL;
-- [Q18] ST_CLERK 인 JOB_ID 를 가진 사원이 없는 부서 id 조회 (단, 부서번호가 NULL인 값은 제외한다.)
    SELECT DISTINCT department_id FROM employees WHERE job_id NOT IN ('ST_CLERK') AND department_id IS NOT NULL;
-- [Q19] commission_pct 가 NULL이 아닌 사원들 중에서 commission = salary * commission_pct 를 구하여, employee_id, first_name 와 함께 출력
    SELECT employee_id, first_name, salary * commission_pct AS commision FROM employees WHERE commission_pct IS NOT NULL;
-- [Q20] first_name이 'Curtis' 인 사람의 first_name, last_name, phone_number, job_id 조회 (단, job_id의 결과는 소문자로 출력)
    SELECT first_name, last_name, phone_number, LOWER(job_id) FROM employees WHERE first_name = 'Curtis';
-- [Q21] 부서번호가 60, 70, 80, 90인 사원들의 employee_id, first_name, last_name, department_id, job_id 조회하기 (단, job_id가 IT_PROG 인 사원의 경우 프로그래머로 변경하여 출력)
    SELECT  employee_id, first_name, last_name, department_id, REPLACE(job_id, 'IT_PROG', 'PROGRAMMER') FROM employees WHERE department_id IN (60, 70, 80, 90);
-- [Q22] job_id 가 'AD_PRES', 'PU_CLERK' 인 사원들의 employee_id, first_name, last_name, department_id, job_id 조회하기 (단, 사원명은 first_name 과 last_name을 연결하여 출력
    SELECT employee_id, first_name || last_name, department_id, job_id FROM employees WHERE job_id IN ('AD_PRES', 'PU_CLERK');
-- [Q23] 부서 80의 각 사원에 대해 적용가능한 세율(TAX_RATE)을 표시
    SELECT last_name, salary, CASE
        WHEN salary BETWEEN 0 AND 1999 THEN 0
        WHEN salary BETWEEN 2000 AND 3999 THEN 0.09
        WHEN salary BETWEEN 4000 AND 5999 THEN 0.2
        WHEN salary BETWEEN 6000 AND 7999 THEN 0.3
        WHEN salary BETWEEN 8000 AND 9999 THEN 0.4
        WHEN salary BETWEEN 10000 AND 11999 THEN 0.42
        WHEN salary BETWEEN 12000 AND 13999 THEN 0.44
        WHEN salary >= 14000 THEN 0.45 END AS TAX_RATE FROM employees WHERE department_id = 80;
    -- ANSWER
        SELECT last_name, salary, DECODE(TRUNC(salary / 2000),
            0, 0.00,
            1, 0.09,
            2, 0.20,
            3, 0.30,
            4, 0.40,
            5, 0.42,
            6, 0.44,
            0.45) AS TAX_RATE FROM employees WHERE department_id = 80;
-- [Q24] 회사 내의 최대연봉 및 최소연봉 차 출력
    SELECT MAX(salary) - MIN(salary) FROM employees;
-- [Q25] 매니저로 근무하는 사원들의 총 숫자 출력
    SELECT COUNT(DISTINCT manager_id) FROM employees;
-- [Q26] 부서별 직원수를 구하여, 부서번호의 오름차순으로 출력
    SELECT department_id, COUNT(*) FROM employees GROUP BY department_id ORDER BY department_id;
-- [Q27] 부서별 급여의 평균 연봉 출력(부서번호별 오름차순)
    SELECT department_id, ROUND(AVG(salary)) FROM employees GROUP BY department_id ORDER BY department_id;
-- [Q28] 동일한 직업을 가진 사원들의 수 출력
    SELECT job_id, COUNT(*) FROM employees GROUP BY job_id;
-- [Q29] 자신의 담당 매니저의 고용일보다 빠른 입사자 찾기 (employees 셀프 조인)
    SELECT e1.employee_id, CONCAT(e1.first_name, e1.last_name), e1.hire_date, e1.manager_id, CONCAT(e2.first_name, e2.last_name), e2.hire_date 
    FROM employees e1 JOIN employees e2 ON e1.employee_id = e2.manager_id WHERE e1.hire_date > e2.hire_date;
    -- ANSWER
        SELECT e1.employee_id, e1.hire_date AS 입사일, e1.manager_id, e2.hire_date AS 매니저입사일 
        FROM employees e1 JOIN employees e2 ON e1.manager_id = e2.employee_id WHERE e1.hire_date < e2.hire_date ORDER BY e1.employee_id;
-- [Q30] 도시 이름이 T로 시작하는 지역에 사는 사원들의 사번, last_name, department_id, city 출력(employees departments locations 테이블 조인)
    SELECT e.employee_id, e.last_name, d.department_id, l.city 
    FROM employees e JOIN departments d ON e.department_id = d.department_id JOIN locations l ON d.location_id = l.location_id WHERE city LIKE 'T%';
    -- ANSWER
        SELECT employee_id, last_name, d.department_id, city
        FROM employees e JOIN departments d ON e.department_id = d.department_id JOIN locations l ON d.location_id = l.location_id WHERE city LIKE 'T%';
-- [Q31] 위치 ID 가 1700 인 사원들의 employee_id, last_name, department_id, salary 출력 (employees, departments 테이블 조인)
    SELECT employee_id, last_name, e.department_id, salary FROM employees e JOIN departments d ON e.department_id = d.department_id WHERE d.location_id = 1700;
    -- ANSWER
        SELECT employee_id, last_name, e.department_id, salary FROM employees e JOIN departments d ON e.department_id = d.department_id WHERE d.location_id = 1700;
-- [Q32] 각 부서별 평균 연봉(0.00), 사원 수 조회 (department_name, location_id, sal_avg, cnt 출력 (employees, departments 조인)
    SELECT d.department_name, d.location_id, ROUND(AVG(salary), 2) AS SAL_AVG, COUNT(*) AS CNT 
    FROM employees e JOIN departments d ON e.department_id = d.department_id GROUP BY d.department_name, d.location_id;
    -- ANSWER
        SELECT department_name, location_id, ROUND(AVG(salary), 2) AS SAL_AVG, COUNT(*) AS CNT
        FROM employees e JOIN departments d ON e.department_id = d.department_id GROUP BY department_name, location_id ORDER BY location_id;
-- [Q33] Executive 부서에 근무하는 모든 사원들의 department_id, last_name, job_id 출력 (employees, deaprtments 조인)
    SELECT d.department_id, last_name, job_id FROM employees e JOIN departments d ON e.department_id = d.department_id WHERE d.department_name = 'Executive';
    -- ANSWER
        SELECT d.department_id, last_name, job_id FROM employees e JOIN departments d ON e.department_id = d.department_id WHERE d.department_name = 'Executive';
-- [Q34] 기존의 직업을 여전히 가지고 있는 사원들의 employee_id, job_id 출력 ( job_history 내부 조인)
    SELECT e1.employee_id, e1.job_id FROM employees e1 JOIN job_history j ON e1.employee_id = j.employee_id JOIN employees e2 ON j.employee_id = e2.employee_id WHERE j.job_id = e2.job_id;
    -- ANSWER
        SELECT e.employee_id, e.job_id FROM employees e JOIN job_history j ON e.employee_id = j.employee_id WHERE e.job_id = j.job_id;
-- [Q35] 각 사원별 소속부서에서 자신보다 늦게 고용되었으나, 보다 많은 연봉을 받는 사원이 department_id, last_name, salary, hire_date 출력 (employees 셀프 조인)
    SELECT e1.department_id, e1.last_name, e1.salary, e1.hire_date, e2.department_id, e2.last_name, e2.salary, e2.hire_date 
    FROM employees e1 JOIN employees e2 ON e1.department_id = e2.department_id WHERE e1.hire_date > e2.hire_date AND e1.salary > e2.salary;
    -- ANSWER
        SELECT DISTINCT e2.department_id, e2.last_name, e2.salary, e2.hire_date
        FROM employees e1 JOIN employees e2 ON e1.department_id = e2.department_id WHERE e1.hire_date < e2.hire_date AND e1.salary < e2.salary ORDER BY e2.department_id;
        
        
-- INDEX
    CREATE TABLE indextbl AS SELECT DISTINCT first_name, last_name, hire_date FROM employees;
    
    SELECT * FROM indextbl;
    
    SELECT * FROM indextbl WHERE first_name = 'JACK';
    
    CREATE INDEX idx_indextbl_firstname on indextbl(first_name);
    
    COMMIT;
