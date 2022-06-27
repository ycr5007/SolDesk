-- SQL 실행 순서
--  ⑤    select [Columns...] 
--  ①    from [tableName] 
--  ②    where (Condition) 
--  ③    group by [ColumnName]
--  ④    having (function Condition)
--  ⑥    order by [ColumnName] (desc|asc)



-- 1 ) 데이터 검색

SELECT
    *
FROM
    gmv_trend; -- 2017 ~ 2021년 3월 까지 전자상거래 추정 거래액 ( 단위 : 백만원 )

SELECT
    category,
    gmv
FROM
    gmv_trend;

SELECT DISTINCT
    category
FROM
    gmv_trend;

SELECT DISTINCT
    yyyy
FROM
    gmv_trend;

--------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 특정 연도의 매출액 탐색
--------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 2017년 매출액
SELECT
    *
FROM
    gmv_trend
WHERE
    yyyy = 2017;
-- 2019년 이후의 매출액
SELECT
    *
FROM
    gmv_trend
WHERE
    yyyy > 2019;
-- 2019년 ~ 2021년 사이의 매출액
SELECT
    *
FROM
    gmv_trend
WHERE
    yyyy BETWEEN 2019 AND 2021;
-- 2021년을 제외한 매출액
SELECT
    *
FROM
    gmv_trend
WHERE
    yyyy != 2021;

--------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 특정 품목의 매출액 탐색
--------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- category 가 ' 여행 및 교통서비스' 인 매출액
SELECT
    *
FROM
    gmv_trend
WHERE
    category = '여행 및 교통서비스';
-- category 가 ' 여행 및 교통서비스' 아닌 매출액
SELECT
    *
FROM
    gmv_trend
WHERE
    category != '여행 및 교통서비스';
-- category 가 ' 여행 및 교통서비스' 이거나 '컴퓨터 및 주변기기' 인 매출액
SELECT
    *
FROM
    gmv_trend
WHERE
    category = '여행 및 교통서비스'
    OR category = '컴퓨터 및 주변기기';
-- category 가 ' 여행 및 교통서비스' 아니거나 '컴퓨터 및 주변기기' 아닌 매출액
SELECT
    *
FROM
    gmv_trend
WHERE
    category != '여행 및 교통서비스'
    OR category != '컴퓨터 및 주변기기';
-- category 가 ' 패션 ' 이 들어간 매출액
SELECT
    *
FROM
    gmv_trend
WHERE
    category LIKE '%패션%';
-- category 가 ' 패션 ' 이 안들어간 매출액
SELECT
    *
FROM
    gmv_trend
WHERE
    category NOT LIKE '%패션%';

-- 2017 년도의 '여행 및 교통 서비스' 카테고리 추출
SELECT
    *
FROM
    gmv_trend
WHERE
        yyyy = 2017
    AND category = '여행 및 교통서비스';
-- 2018 년도 이거나, '컴퓨터 및 주변기기' 카테고리 추출
SELECT
    *
FROM
    gmv_trend
WHERE
    yyyy = 2018
    OR category = '컴퓨터 및 주변기기';
-- 2018 년 이고, gmv 가 100,000 보다 작고, gmv 가 10,000 보다 큰 매출액
SELECT
    *
FROM
    gmv_trend
WHERE
        yyyy = 2018
    AND gmv BETWEEN 10000 AND 100000;

--------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 품목별 매출액 분석
--------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- 카테고리별 매출액
SELECT
    category,
    SUM(gmv)
FROM
    gmv_trend
GROUP BY
    category;

-- 카테고리, 연도별 매출액
SELECT
    category,
    yyyy,
    SUM(gmv)
FROM
    gmv_trend
GROUP BY
    category,
    yyyy
ORDER BY
    category;
-- 전체 매출액
SELECT
    SUM(gmv)
FROM
    gmv_trend;

-- 매출액이 높은 주요 카테고리 확인
-- 특정 매출액 (50,000,000) 이상 카테고리 추출
SELECT
    category,
    SUM(gmv)
FROM
    gmv_trend
GROUP BY
    category
HAVING
    SUM(gmv) >= 50000000;

-- 매출액이 높은 순으로 연도, 월별 정렬
SELECT
    yyyy,
    mm,
    SUM(gmv)
FROM
    gmv_trend
GROUP BY
    yyyy,
    mm
ORDER BY
    SUM(gmv) DESC;

-- 매출액이 높은 순으로 카테고리 정렬 (desc)
SELECT
    category,
    SUM(gmv)
FROM
    gmv_trend
GROUP BY
    category
ORDER BY
    SUM(gmv) DESC;

--------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 주문 테이블
--------------------------------------------------------------------------------------------------------------------------------------------------------------------

SELECT
    *
FROM
    myorder;
-- 비회원 구매자 (userid 가 없는 주문내역 조회)
SELECT
    *
FROM
    myorder
WHERE
    userid IS NULL;

-- myorder itemid = item_id(num)
-- myoreder userid = myuser(userid)
SELECT
    *
FROM
    myorder o
    LEFT OUTER JOIN myuser  u ON o.userid = u.usernum;
-- item category_id = category(num)
SELECT
    *
FROM
    item     i
    LEFT OUTER JOIN category c ON i.category_id = c.num;

-- 상품별 매출액 집계 후 매출액 높은순으로 정렬
SELECT
    item_name,
    SUM(gmv)
FROM
         myorder o
    JOIN item i ON o.itemid = i.num
GROUP BY
    item_name
ORDER BY
    SUM(gmv) DESC;

SELECT
    i.num,
    category_id,
    cate1,
    cate2,
    cate3
FROM
         item i
    JOIN category c ON i.category_id = c.num;

SELECT
    cate1,
    cate2,
    cate3,
    SUM(gmv)
FROM
         myorder o
    JOIN (
        SELECT
            i.num,
            category_id,
            cate1,
            cate2,
            cate3
        FROM
                 item i
            JOIN category c ON i.category_id = c.num
    ) j ON o.itemid = j.num
GROUP BY
    cate1,
    cate2,
    cate3;

-- 성별 매출액
SELECT
    gender,
    cate1,
    cate2,
    cate3,
    SUM(gmv)
FROM
         myorder o
    JOIN myuser   u ON o.userid = u.usernum
    JOIN item     i ON o.itemid = i.num
    JOIN category c ON i.category_id = c.num
GROUP BY
    gender,
    cate1,
    cate2,
    cate3
ORDER BY
    gender DESC;

-- 성별 + 연령대 매출액
SELECT
    gender,
    age_band,
    SUM(gmv)
FROM
         myorder o
    JOIN myuser u ON o.userid = u.usernum
GROUP BY
    gender,
    age_band
ORDER BY
    gender DESC,
    age_band ASC;

-- 남성이 구매하는 ITEM
SELECT
    item_name,
    SUM(gmv)
FROM
         myorder o
    JOIN myuser u ON o.userid = u.usernum
    JOIN item   i ON o.itemid = i.num
WHERE
    u.gender = 'M'
GROUP BY
    itemid,
    item_name;

-- 내부조인, 외부조인
SELECT
    gender,
    age_band,
    SUM(gmv)
FROM
         myuser u
    JOIN myorder o ON u.usernum = o.userid
GROUP BY
    gender,
    age_band;

SELECT
    gender,
    age_band,
    SUM(gmv)
FROM
    myorder o
    LEFT OUTER JOIN myuser  u ON o.userid = u.usernum
GROUP BY
    gender,
    age_band;

-- number 타입 --> 문자열
SELECT
    dt,
    to_char(dt)                  AS yyyymmdd, -- 형변환
    substr(to_char(dt), 0, 4)    AS yyyy, -- 문자열 자르기 ( 연도 추출 ) 
    substr(to_char(dt), 5, 2)    AS mm, -- 문자열 자르기 ( 월 추출 )
    substr(to_char(dt), 7, 2)    AS dd, -- 문자열 자르기 ( 일 추출 ) 
    substr(to_char(dt), 0, 4)
    || '/'
    || substr(to_char(dt), 5, 2)
    || '/'
    || substr(to_char(dt), 7, 2) AS formatdate
FROM
    myorder;

-- order 테이블의 userid 가 null 인경우 다른값으로 변경한 후 추출 ( nvl() )
SELECT
    userid,
    nvl(to_char(userid), 'NA')
FROM
    myorder;

SELECT
    nvl(gender, 'NA'),
    nvl(age_band, 'NA'),
    SUM(gmv)
FROM
    myorder o
    LEFT OUTER JOIN myuser  u ON o.userid = u.usernum
GROUP BY
    gender,
    age_band
ORDER BY
    gender,
    age_band;

-- 프로그래밍 개념 적용
SELECT
    gender
FROM
    myuser;

SELECT
    gender,
    CASE gender
        WHEN 'M' THEN
            '남성'
        WHEN 'F' THEN
            '여성'
        ELSE
            'NA'
    END AS 성별
FROM
    myuser;

SELECT
    gender,
    CASE age_band
        WHEN '20~24' THEN
            '20s'
        WHEN '25~29' THEN
            '20s'
        WHEN '30~34' THEN
            '30s'
        WHEN '35~39' THEN
            '30s'
        WHEN '40~44' THEN
            '40s'
        ELSE
            'NA'
    END AS age_band,
    SUM(gmv)
FROM
    myorder o
    LEFT OUTER JOIN myuser  u ON o.userid = u.usernum
GROUP BY
    gender,
    age_band
ORDER BY
    gender,
    age_band;

-- TOP 3 , 그 외 매출액 비교
SELECT
    category,
    SUM(gmv)
FROM
    (
        SELECT
            CASE
                WHEN cate1 IN ( '스커트', '티셔츠', '원피스' ) THEN
                    'TOP3'
                ELSE
                    'OTHERS'
            END      AS category,
            SUM(gmv) AS gmv
        FROM
                 myorder o
            JOIN item     i ON o.itemid = i.num
            JOIN category c ON i.category_id = c.num
        GROUP BY
            cate1
    )
GROUP BY
    category;

SELECT
    item_concept,
    SUM(gmv)
FROM
    (
        SELECT
            item_name,
            CASE
                WHEN item_name LIKE '%깜찍%' THEN
                    '깜찍 컨셉'
                WHEN item_name LIKE '%청순%' THEN
                    '청순 컨셉'
                WHEN item_name LIKE '%시크%' THEN
                    '시크 컨셉'
                WHEN item_name LIKE '%기본%' THEN
                    '기본 컨셉'
                ELSE
                    '미분류'
            END      AS item_concept,
            SUM(gmv) AS gmv
        FROM
                 myorder o
            JOIN item i ON o.itemid = i.num
        GROUP BY
            item_name
    )
GROUP BY
    item_concept
ORDER BY
    SUM(gmv) DESC;

-- 날짜 함수
SELECT
    to_char(sysdate, 'yyyy-mm-dd')
FROM
    dual;

SELECT
    add_months(sysdate, - 2)
FROM
    dual;

SELECT
    sysdate + 20
FROM
    dual;

-- 최근 1년동안의 매출액
SELECT
    add_months(sysdate, - 12)
FROM
    dual;

SELECT
    yyyy,
    mm,
    to_date(concat(yyyy, mm), 'yyyymm')
FROM
    gmv_trend;

SELECT
    *
FROM
    gmv_trend
WHERE
    add_months(sysdate, - 24) <= to_date(concat(yyyy, mm), 'yyyymm');

-- 할인율, 이익율, 판매가 계산
SELECT
    dt,
    orderid,
    userid,
    itemid,
    price,
    unitsold,
    gmv,
    product_profit,
    discount,
    discount / gmv       AS discount_rate,
    gmv - discount       AS paid_amount,
    product_profit / gmv AS product_margin,
    total_profit / gmv   AS total_margin
FROM
    myorder;

-- 인당 평균 구매수량 = 총 판매수량 / 총 고객 수
SELECT
    item_name,
    SUM(o.unitsold)                                  AS unitsold,
    COUNT(DISTINCT userid)                           AS user_cnt,
    round(SUM(unitsold) / COUNT(DISTINCT userid), 2) AS avg_unitsold_per_customer,
    round(SUM(gmv) / COUNT(DISTINCT userid), 2)      AS avg_gmv_per_customer
FROM
         myorder o
    JOIN item i ON o.itemid = i.num
GROUP BY
    item_name
ORDER BY
    avg_unitsold_per_customer DESC;


-- 인당 구매금액이 높은 성별 / 연령대
SELECT
    gender,
    age_band,
    SUM(gmv)                                    AS gmv,
    COUNT(DISTINCT o.userid)                    AS user_cnt,
    round(SUM(gmv) / COUNT(DISTINCT userid), 2) AS avg_gmv_per_customer
FROM
         myorder o
    JOIN myuser u ON o.userid = u.usernum
GROUP BY
    gender,
    age_band
ORDER BY
    avg_gmv_per_customer DESC;

-- 하루동안 2 개 이상의 상품( 동일한 상품 제외 ) 을 구매한 고객은 주로 어떤 상품을 구매했을까 ?
SELECT
    cate3,
    item_name,
    price,
    COUNT(DISTINCT o.userid) AS user_cnt,
    SUM(gmv)                 AS gmv
FROM
         myorder o
    JOIN item     i ON o.itemid = i.num
    JOIN category c ON i.category_id = c.num
    JOIN (
        SELECT
            userid,
            COUNT(DISTINCT itemid) AS item_cnt
        FROM
                 myorder o
            JOIN myuser u ON o.userid = u.usernum
        GROUP BY
            userid
        HAVING
            COUNT(DISTINCT itemid) >= 2
    )        user_list ON o.userid = user_list.userid
GROUP BY
    cate3,
    item_name,
    price
ORDER BY
    user_cnt DESC;
    
-- 하루동안 2개 이상의 제품을 구매한 고객의 성연령 비율?
SELECT
    gender,
    age_band,
    COUNT(DISTINCT o.userid)               AS user_cnt,
    round(COUNT(DISTINCT
        CASE
            WHEN user_list.userid IS NOT NULL THEN
                user_list.userid
            ELSE
                NULL
        END
    ) / COUNT(DISTINCT o.userid) * 100, 1) AS user_percent
FROM
         myorder o
    JOIN myuser u ON o.userid = u.usernum
    LEFT JOIN (
        SELECT
            o.userid,
            COUNT(DISTINCT itemid) AS item_cnt
        FROM
                 myorder o
            JOIN myuser u ON o.userid = u.usernum
        GROUP BY
            userid
        HAVING
            COUNT(DISTINCT itemid) >= 2
    )      user_list ON o.userid = user_list.userid
GROUP BY
    gender,
    age_band;