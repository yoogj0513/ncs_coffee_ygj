select * from sale;
select * from product;

insert into sale values
('A001', '아메리카노'),
('A002', '카푸치노'),
('A003', '헤이즐넛'),
('A004', '에스프레소'),
('B001', '딸기쉐이크'),
('B002', '후르츠와인'), 
('B003', '팥빙수'),
('B004', '아이스초코');

insert into product(product_code, price, sale_cnt, margin_rate) values
('A001', 4500, 150, 10),
('A002', 3800, 140, 15),
('B001', 5200, 250, 12),
('B002', 4300, 110, 11);