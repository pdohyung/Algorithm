with front as (
    select sum(code) as fc from skillcodes where category = 'Front End'
), 
python as (
    select code as pc from skillcodes where name = 'Python'
),
csharp as (
    select code as csc from skillcodes where name = 'C#'
)

select 
    case
        when skill_code & fc != 0 and skill_code & pc != 0 then 'A'
        when skill_code & csc != 0 then 'B'
        when skill_code & fc != 0 then 'C'
        else null
    end as GRADE,
    ID,
    EMAIL
from developers d
join front join python join csharp
having grade is not null
order by grade, id;
