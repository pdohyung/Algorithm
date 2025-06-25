# 세단, SUV인 차 중에서 22-11-01 ~ 22-11-30 대여 가능하고 30일간 대여 금액이 50만원 이상 200만원 미만인 자동차
select c.CAR_ID, c.CAR_TYPE, floor(daily_fee * (100 - discount_rate) / 100 * 30) as FEE
from CAR_RENTAL_COMPANY_CAR c
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN d
on c.car_type = d.car_type and duration_type = '30일 이상'
where car_id not in (
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where start_date <= date('2022-11-30') and end_date >= date('2022-11-01')
) 
and c.car_type in ('세단', 'SUV')
and daily_fee * (100 - discount_rate) / 100 * 30 between 500000 and 1999999
order by fee desc, car_type, car_id desc;
