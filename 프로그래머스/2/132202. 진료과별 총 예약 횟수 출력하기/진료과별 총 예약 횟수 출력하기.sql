-- 코드를 입력하세요
SELECT MCDP_CD as 진료과코드, COUNT(APNT_YMD) as 5월예약건수
FROM APPOINTMENT
WHERE APNT_YMD LIKE '%22-05%'
GROUP BY 진료과코드
ORDER BY 5월예약건수, 진료과코드;