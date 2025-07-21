-- 코드를 입력하세요


select b.author_id as AUTHOR_ID, author_name as AUTHOR_NAME, category AS CATEGORY, sum(price * total) AS TOTAL_SALES
from book b 
join author a
on b.author_id = a.author_id
join (select book_id, sum(sales) as total
from book_sales
where date_format(sales_date, "%Y-%m") = "2022-01"
group by book_id) s
on b.book_id = s.book_id
group by b.author_id, category
order by AUTHOR_ID, CATEGORY DESC;