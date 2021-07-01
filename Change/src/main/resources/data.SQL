CREATE TABLE TAUX_CHANGE(id bigint, devise_src varchar, devise_dest varchar,date_cotation TIMESTAMP, taux decimal);
insert into taux_change (id,devise_src,devise_dest,date_cotation,taux)
values(10001,'EUR','USD','2021-05-21',1.17);
insert into taux_change(id,devise_src,devise_dest,date_cotation,taux)
values(10002,'EUR','JPY','2021-05-21',130);
insert into taux_change(id,devise_src,devise_dest,date_cotation,taux)
values(10003,'USD','GBP','2021-05-21',0.75);
insert into taux_change (id,devise_src,devise_dest,date_cotation,taux)
values(10004,'EUR','USD','2021-05-20',1.18);