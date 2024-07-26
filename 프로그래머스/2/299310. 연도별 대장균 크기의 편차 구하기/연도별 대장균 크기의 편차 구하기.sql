-- 코드를 작성해주세요
WITH T1(maxc, year) AS (
    SELECT MAX(size_of_colony) AS maxc, YEAR(differentiation_date) AS year
    FROM ecoli_data
    GROUP BY YEAR(differentiation_date)
)

SELECT YEAR(E.DIFFERENTIATION_DATE) AS YEAR, ABS(maxc - SIZE_OF_COLONY) AS YEAR_DEV, ID
FROM ECOLI_DATA E JOIN T1 ON year(E.DIFFERENTIATION_DATE) = T1.year
ORDER BY YEAR, YEAR_DEV;