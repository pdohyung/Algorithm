select e.EMP_NO, EMP_NAME, GRADE, (SAL * RATE) as BONUS
from hr_employees as e
join (select emp_no, score_avg,
      case
        when score_avg >= 96 then 0.2
        when score_avg >= 90 then 0.15
        when score_avg >= 80 then 0.1
        else 0
      end as rate,
      case
        when score_avg >= 96 then 'S'
        when score_avg >= 90 then 'A'
        when score_avg >= 80 then 'B'
        else 'C'
      end as grade
      from (select emp_no, avg(score) as score_avg
            from hr_grade
            group by emp_no) as sub
     ) as g
on e.emp_no = g.emp_no
order by EMP_NO;
