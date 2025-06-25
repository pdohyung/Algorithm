-- 코드를 입력하세요
# with total t1 (
    
# )

# 17, 19, 22, 23, 24 25

# select * from food_product


select fo.PRODUCT_ID as PRODUCT_ID, PRODUCT_NAME, PRICE * SUM(AMOUNT) as TOTAL_SALES
from food_order fo
join food_product fp on fo.product_id = fp.product_id
where fo.produce_date between date('2022-05-01') and date('2022-05-31')
group by product_id
order by TOTAL_SALES desc, PRODUCT_ID;
