-- SQL 실행 순서
--  ⑤    select [Columns...] 
--  ①    from [tableName] 
--  ②    where (Condition) 
--  ③    group by [ColumnName]
--  ④    having (function Condition)
--  ⑥    order by [ColumnName] (desc|asc)



-- 1 ) 데이터 검색

select * from gmv_trend; -- 2017 ~ 2021년 3월 까지 전자상거래 추정 거래액 ( 단위 : 백만원 )

select category, gmv from gmv_trend;

select distinct category from gmv_trend;

select distinct yyyy from gmv_trend;

--------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 특정 연도의 매출액 탐색
--------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 2017년 매출액
select * from gmv_trend where yyyy = 2017;
-- 2019년 이후의 매출액
select * from gmv_trend where yyyy > 2019;
-- 2019년 ~ 2021년 사이의 매출액
select * from gmv_trend where yyyy between 2019 and 2021;
-- 2021년을 제외한 매출액
select * from gmv_trend where yyyy != 2021;

--------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 특정 품목의 매출액 탐색
--------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- category 가 ' 여행 및 교통서비스' 인 매출액
select * from gmv_trend where category = '여행 및 교통서비스';
-- category 가 ' 여행 및 교통서비스' 아닌 매출액
select * from gmv_trend where category != '여행 및 교통서비스';
-- category 가 ' 여행 및 교통서비스' 이거나 '컴퓨터 및 주변기기' 인 매출액
select * from gmv_trend where category = '여행 및 교통서비스' OR category = '컴퓨터 및 주변기기';
-- category 가 ' 여행 및 교통서비스' 아니거나 '컴퓨터 및 주변기기' 아닌 매출액
select * from gmv_trend where category != '여행 및 교통서비스' OR category != '컴퓨터 및 주변기기';
-- category 가 ' 패션 ' 이 들어간 매출액
select * from gmv_trend where category like '%패션%';
-- category 가 ' 패션 ' 이 안들어간 매출액
select * from gmv_trend where category not like '%패션%';

-- 2017 년도의 '여행 및 교통 서비스' 카테고리 추출
select * from gmv_trend where yyyy = 2017 and category = '여행 및 교통서비스';
-- 2018 년도 이거나, '컴퓨터 및 주변기기' 카테고리 추출
select * from gmv_trend where yyyy = 2018 or category = '컴퓨터 및 주변기기';
-- 2018 년 이고, gmv 가 100,000 보다 작고, gmv 가 10,000 보다 큰 매출액
select * from gmv_trend where yyyy = 2018 and gmv between 10000 and 100000;

--------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 품목별 매출액 분석
--------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- 카테고리별 매출액
select category, sum(gmv) from gmv_trend group by category;

-- 카테고리, 연도별 매출액
select category, yyyy, sum(gmv) from gmv_trend group by category, yyyy order by category;
-- 전체 매출액
select sum(gmv) from gmv_trend;

-- 매출액이 높은 주요 카테고리 확인
-- 특정 매출액 (50,000,000) 이상 카테고리 추출
select category, sum(gmv) from gmv_trend group by category having sum(gmv) >= 50000000;

-- 매출액이 높은 순으로 연도, 월별 정렬
select yyyy, mm, sum(gmv) from gmv_trend group by yyyy, mm order by sum(gmv) desc;

-- 매출액이 높은 순으로 카테고리 정렬 (desc)
select category, sum(gmv) from gmv_trend group by category order by sum(gmv) desc;

--------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 주문 테이블
--------------------------------------------------------------------------------------------------------------------------------------------------------------------

select * from myorder;
-- 비회원 구매자 (userid 가 없는 주문내역 조회)
select * from myorder where userid is null;

-- myorder itemid = item_id(num)
-- myoreder userid = myuser(userid)
select * from myorder o left outer join myuser u on o.userid = u.usernum;
-- item category_id = category(num)
select * from item i left outer join category c on i.category_id = c.num;

-- 상품별 매출액 집계 후 매출액 높은순으로 정렬
select item_name, sum(gmv) from myorder o join item i on o.itemid = i.num group by item_name order by sum(gmv) desc;
select i.num, category_id, cate1, cate2, cate3 from item i join category c on i.category_id = c.num;
select cate1, cate2, cate3, sum(gmv) from myorder o join (select i.num, category_id, cate1, cate2, cate3 from item i join category c on i.category_id = c.num) j on o.itemid = j.num group by cate1, cate2, cate3;

-- 성별 매출액
select gender, cate1, cate2, cate3 , sum(gmv) from 
myorder o join myuser u on o.userid = u.usernum
join item i on o.itemid = i.num
join category c on i.category_id = c.num
group by gender, cate1, cate2, cate3
order by gender desc;

-- 성별 + 연령대 매출액
select gender,age_band, sum(gmv) from 
myorder o join myuser u on o.userid = u.usernum
group by gender, age_band
order by gender desc, age_band asc;

-- 남성이 구매하는 ITEM
select item_name, sum(gmv) from
myorder o join myuser u on o.userid = u.usernum
join item i on o.itemid = i.num where u.gender = 'M' group by itemid, item_name;

-- 내부조인, 외부조인
select gender, age_band, sum(gmv) from
myuser u join myorder o on u.usernum = o.userid 
group by gender, age_band;

select gender, age_band, sum(gmv) from 
myorder o left outer join myuser u on o.userid = u.usernum
group by gender, age_band;

-- number 타입 --> 문자열
select 
dt, 
to_char(dt) as yyyymmdd, -- 형변환
SUBSTR(to_char(dt), 0, 4) as yyyy, -- 문자열 자르기 ( 연도 추출 ) 
SUBSTR(to_char(dt), 5, 2) as mm, -- 문자열 자르기 ( 월 추출 )
SUBSTR(to_char(dt), 7, 2) as dd -- 문자열 자르기 ( 일 추출 ) 
from myorder;