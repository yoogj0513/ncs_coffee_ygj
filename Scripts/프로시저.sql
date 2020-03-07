select user(), database();

select * from product;

-- 프로시저 (proc_order_price)
drop procedure if exists proc_order_price;
delimiter $$
create procedure proc_order_price(in in_order varchar(10))
begin
	declare result_order varchar(10);
	
	set result_order = in_order;

	case in_order
		when 'priceRank' then
			-- 판매금액 순위
			select  (select count(*)+1 from product where (price * sale_cnt) > (p.price * p.sale_cnt)) as ranking,
					p.product_code as code , s.product_name as name, p.price as price, p.sale_cnt as sale_cnt,
					(p.price * p.sale_cnt) - ceiling((p.price * p.sale_cnt) / 11) as supply,
					ceiling((p.price * p.sale_cnt) / 11) as addition,
					(p.price * p.sale_cnt) as sale_sum, 
					p.margin_rate as margin_rate,
					round(((p.price * p.sale_cnt) - ceiling((p.price * p.sale_cnt) / 11)) * (p.margin_rate / 100)) as margin_sum
			from product p left join sale s on p.product_code = s.product_code
			order by ranking;
		when 'marginRank' then
			-- 마진액 순위
			select  (select count(*)+1 from product where round(((price * sale_cnt) - ceiling((price * sale_cnt) / 11)) * (margin_rate / 100)) 
						> round(((p.price * p.sale_cnt) - ceiling((p.price * p.sale_cnt) / 11)) * (p.margin_rate / 100))) as ranking,
					p.product_code as code , s.product_name as name, p.price as price, p.sale_cnt as sale_cnt,
					(p.price * p.sale_cnt) - ceiling((p.price * p.sale_cnt) / 11) as supply,
					ceiling((p.price * p.sale_cnt) / 11) as addition,
					(p.price * p.sale_cnt) as sale_sum, 
					p.margin_rate as margin_rate,
					round(((p.price * p.sale_cnt) - ceiling((p.price * p.sale_cnt) / 11)) * (p.margin_rate / 100)) as margin_sum
			from product p left join sale s on p.product_code = s.product_code
			order by ranking;
	end case;
end $$
delimiter ;

call proc_order_price('priceRank'); 
call proc_order_price('marginRank');

-- 프로시저(proc_sum)
drop procedure if exists proc_sum;
delimiter $$
create procedure proc_sum()
begin
	select 	sum((p.price * p.sale_cnt) - ceiling((p.price * p.sale_cnt) / 11)) as supply_sum,
			sum(ceiling((p.price * p.sale_cnt) / 11)) as addition_sum,
			sum((p.price * p.sale_cnt)) as sale_amount_sum, 
			round(sum(((p.price * p.sale_cnt) - ceiling((p.price * p.sale_cnt) / 11)) * (p.margin_rate / 100))) as margin_amount_sum
	from product p left join sale s on p.product_code = s.product_code;
end $$
delimiter ;

call proc_sum();
