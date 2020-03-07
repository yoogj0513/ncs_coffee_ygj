select user(), database();

select * from product;
select product_code , product_name from sale where product_code = 'A004';
select product_code from product where product_code = 'B001';

select  (select count(*)+1 from product where (price * sale_cnt) > (p.price * p.sale_cnt)) as '판매순위',
		(select count(*)+1 from product where round(((price * sale_cnt) - ceiling((price * sale_cnt) / 11)) * (margin_rate / 100)) 
			> round(((p.price * p.sale_cnt) - ceiling((p.price * p.sale_cnt) / 11)) * (p.margin_rate / 100))) as '마진순위',
		p.product_code as 제품코드 , s.product_name as 제품명, p.price as 제품단가, p.sale_cnt as 판매수량,
		(p.price * p.sale_cnt) - ceiling((p.price * p.sale_cnt) / 11) as 공급가액,
		ceiling((p.price * p.sale_cnt) / 11) as 부가세액,
		(p.price * p.sale_cnt) as 판매금액, 
		p.margin_rate as 마진율,
		round(((p.price * p.sale_cnt) - ceiling((p.price * p.sale_cnt) / 11)) * (p.margin_rate / 100)) as 마진액
from product p left join sale s on p.product_code = s.product_code
order by 판매순위;

-- 판매금액 순위
select  (select count(*)+1 from product where (price * sale_cnt) > (p.price * p.sale_cnt)) as 판매금액순위,
		p.product_code as 제품코드 , s.product_name as 제품명, p.price as 제품단가, p.sale_cnt as 판매수량,
		(p.price * p.sale_cnt) - ceiling((p.price * p.sale_cnt) / 11) as 공급가액,
		ceiling((p.price * p.sale_cnt) / 11) as 부가세액,
		(p.price * p.sale_cnt) as 판매금액, 
		p.margin_rate as 마진율,
		round(((p.price * p.sale_cnt) - ceiling((p.price * p.sale_cnt) / 11)) * (p.margin_rate / 100)) as 마진액
from product p left join sale s on p.product_code = s.product_code
order by 판매금액순위;

-- 마진액 순위
select  (select count(*)+1 from product where round(((price * sale_cnt) - ceiling((price * sale_cnt) / 11)) * (margin_rate / 100)) 
			> round(((p.price * p.sale_cnt) - ceiling((p.price * p.sale_cnt) / 11)) * (p.margin_rate / 100))) as 마진액순위,
		p.product_code as 제품코드 , s.product_name as 제품명, p.price as 제품단가, p.sale_cnt as 판매수량,
		(p.price * p.sale_cnt) - ceiling((p.price * p.sale_cnt) / 11) as 공급가액,
		ceiling((p.price * p.sale_cnt) / 11) as 부가세액,
		(p.price * p.sale_cnt) as 판매금액, 
		p.margin_rate as 마진율,
		round(((p.price * p.sale_cnt) - ceiling((p.price * p.sale_cnt) / 11)) * (p.margin_rate / 100)) as 마진액
from product p left join sale s on p.product_code = s.product_code
order by 마진액순위;

-- 합계
select 	sum((p.price * p.sale_cnt) - ceiling((p.price * p.sale_cnt) / 11)) as 공급가액,
		sum(ceiling((p.price * p.sale_cnt) / 11)) as 부가세액,
		sum((p.price * p.sale_cnt)) as 판매금액, 
		round(sum(((p.price * p.sale_cnt) - ceiling((p.price * p.sale_cnt) / 11)) * (p.margin_rate / 100))) as 마진액
from product p left join sale s on p.product_code = s.product_code;