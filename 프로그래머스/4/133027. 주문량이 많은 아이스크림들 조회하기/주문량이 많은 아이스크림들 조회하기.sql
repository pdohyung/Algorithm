WITH t1 as (
    select shipment_id, flavor, sum(total_order) as total_order
    from july
    group by flavor
), t2 as (
    select shipment_id, flavor, sum(total_order) as total_order
    from first_half
    group by flavor
)

select t1.flavor
from t1
join t2 
on t1.shipment_id = t2.shipment_id
order by (t1.total_order + t2.total_order) desc
limit 3;