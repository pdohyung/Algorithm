select rv.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, SCORE
from (select rest_id, round(avg(review_score), 2) as score
      from rest_review
      group by rest_id) rv
join rest_info re
on rv.rest_id = re.rest_id
where address like '서울%'
order by score desc, favorites desc;
