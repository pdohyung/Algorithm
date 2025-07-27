with recursive hours as (
    select 0 as hour
    union all
    select hour + 1 from hours where hour < 23
)

select hours.hour, count(a.animal_id) as COUNT
from hours
left join animal_outs a
on hours.hour = hour(a.datetime)
group by hours.hour
order by hours.hour;
