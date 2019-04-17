\encoding sjis;

/* p.68
このファイルのエンコード==utf-8・DB==Sjis
ファイル読み込みだとエラー・都度コピー＆ペーストだと正常に起動
2.0 テーブル作成*/
create table shohin
(
shohin_id char(4) not null,
shohin_mei varchar(100) not null,
shohin_bunrui varchar(32) not null,
hanbai_tanka integer,
shiire_tanka integer,
torokubi date,
primary key(shohin_id)
);
--テーブル確認
\d shohin;

--データ追加

begin transaction;

insert into shohin values('0001','Tシャツ','衣服',1000,500,'2009-09-20');
insert into shohin values('0002','穴あけパンチ','事務用品',500,320,'2009-09-11');
insert into shohin values('0003','カッターシャツ','衣服',4000,2800,null);
insert into shohin values('0004','包丁','キッチン用品',3000,2800,'2009-09-20');
insert into shohin values('0005','圧力鍋','キッチン用品',6800,5000,'2009-01-15');
insert into shohin values('0006','フォーク','キッチン用品',500,null,'2009-09-20');
insert into shohin values('0007','おろしがね','キッチン用品',880,790,'2008-04-28');
insert into shohin values('0008','ボールペン','事務用品',100,null,'2009-11-11');

commit;

--データ確認
select*
from shohin;
--今後のtest2～8はこのテーブルを基としている

--2.1 torokubiのselect
select shohin_mei,torokubi
from shohin
where torokubi >= '2009-04-28';

--2.2 select実行と確認
select *
from shohin
where shiire_tanka=null;

select *
from shohin
where shiire_tanka<>null;

select *
from shohin
where shohin_mei>null;
--どれも1行も表示されない

/*
2.3 同じ結果となるselect文(条件)を2つ
条件→hanbai_tanka-shiire_tanka>=500
条件2→shiire_tanka-hanbai_tanka<=-500
*/

--2.4 販売単価*0.9でも利益が100円以上出るもの

select shohin_mei,shohin_bunrui,hanbai_tanka*0.9-shiire_tanka as rieki
from shohin
where hanbai_tanka*0.9-shiire_tanka>=100;

--以下、練習問題外-------------------------------------------------------

--定数の出力

select '商品' as 商品,shohin_id,shohin_mei
from shohin;

--重複を省く

select distinct shohin_bunrui
from shohin;

--注意！nullを含む「単純な」演算は全てnull(空白)という結果になる

select(100+200)*3 as keisan;
select(100+null)*3 as keisan2;

/*'!='＝'<>'
null を比較に使いたいときは「is (not) null」
not 演算は有効な場合もあるが、大抵の場合には不要であり、非推奨*/

--下記はどちらも同じ結果
select shohin_mei,shohin_bunrui,hanbai_tanka
from shohin
where not hanbai_tanka <> 1000;

select shohin_mei,shohin_bunrui,hanbai_tanka
from shohin
where hanbai_tanka = 1000;


--andとorに注意

--下記は全く違う結果
select shohin_mei,shohin_bunrui,torokubi
from shohin
where shohin_bunrui = '事務用品';
and '2009-09-11'
or  '2009-09-20';

select shohin_mei,shohin_bunrui,torokubi
from shohin
where shohin_bunrui = '事務用品';
and ('2009-09-11'
or  '2009-09-20');

--SQLは3値論理、nullの真偽に注意





