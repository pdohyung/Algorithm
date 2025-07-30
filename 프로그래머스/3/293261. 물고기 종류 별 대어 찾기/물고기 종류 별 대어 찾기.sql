select ID, FISH_NAME, LENGTH
from fish_info i
join (select fish_type, max(length) as mx
      from fish_info
      group by fish_type) m
on i.fish_type = m.fish_type
join fish_name_info n
on m.fish_type = n.fish_type
where length = mx
order by id
