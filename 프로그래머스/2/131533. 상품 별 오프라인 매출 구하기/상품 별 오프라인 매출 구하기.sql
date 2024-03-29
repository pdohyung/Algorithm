-- 코드를 입력하세요
SELECT PRODUCT_CODE, SUM(SALES_AMOUNT) * PRICE as SALES
FROM PRODUCT as p, OFFLINE_SALE as o
WHERE p.PRODUCT_ID = o.PRODUCT_ID
GROUP BY PRODUCT_CODE
ORDER BY SALES DESC, PRODUCT_CODE ASC;