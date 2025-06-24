# 세단, SUV인 차 중에서 22-11-01 ~ 22-11-30 대여 가능하고 30일간 대여 금액이 50만원 이상 200만원 미만인 자동차
with t1 as (
    select car_id, car_type, daily_fee
    from CAR_RENTAL_COMPANY_CAR
    where car_id not in (
        select car_id
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where start_date <= date('2022-11-30') and end_date >= date('2022-11-01')
    )
    and car_type in ('세단', 'SUV')
), t3 as (
    select t1.car_id as CAR_ID, t1.car_type as CAR_TYPE, floor(daily_fee * (100 - discount_rate) / 100) * 30 as FEE
    from t1
    join CAR_RENTAL_COMPANY_DISCOUNT_PLAN t2 on t1.car_type = t2.car_type and duration_type = '30일 이상'
)

select *
from t3
where fee >= 500000 and fee < 2000000
order by fee desc, car_type, car_id desc;
