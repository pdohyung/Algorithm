-- 21년에 가입하고 상품을 구매한 회원 수 / 21년에 가입한 회원 수
-- 년/월별로 출력, 소수점 둘째자리에서 반올림
select year(sales_date) as YEAR, month(sales_date) as MONTH, count(distinct user_id) as PURCHASED_USERS, round(count(distinct user_id) / (select count(user_id) from user_info where year(joined) = 2021), 1) as PUCHASED_RATIO
from online_sale 
where user_id in (select user_id from user_info where year(joined) = 2021)
group by year, month
order by year, month;
