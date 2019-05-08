\encoding UTF-8;

/*p.261
7.1 select文の実行・確認:shohinがそのまま(shohinをshohinと集合させているため)*/

select *
from shohin
union
select *
from shohin
intersect
select*
from shohin
order by shohin_id;

--7.2 NULLを不明に置き換える(coalesce)

--tenposhohin作成(本来は6章で作るものだが、練習問題を優先しているためここで初めて作成した)

create table tenposhohin
(tenpo_id char(4) not null,
tenpo_mei varchar(200) not null,
shohin_id char (4) not null,
suryo integer not null,
primary key(tenpo_id,shohin_id));

begin transaction;

insert into tenposhohin values('000A','東京','0001',30);
insert into tenposhohin values('000A','東京','0002',50);
insert into tenposhohin values('000A','東京','0003',15);
insert into tenposhohin values('000B','名古屋','0002',30);
insert into tenposhohin values('000B','名古屋','0003',120);
insert into tenposhohin values('000B','名古屋','0004',20);
insert into tenposhohin values('000B','名古屋','0006',10);
insert into tenposhohin values('000B','名古屋','0007',40);
insert into tenposhohin values('000C','大阪','0003',20);
insert into tenposhohin values('000C','大阪','0004',50);
insert into tenposhohin values('000C','大阪','0006',90);
insert into tenposhohin values('000C','大阪','0007',70);
insert into tenposhohin values('000D','福岡','0001',100);

commit;

--集合させ、置き換える

select coalesce(tenposhohin.tenpo_id,'不明') as tenpo_id,
		coalesce(tenposhohin.tenpo_mei,'不明') as tenpo_mei,
		shohin.shohin_id,
		shohin.shohin_mei,
		shohin.hanbai_tanka
from tenposhohin right outer join shohin
on tenposhohin.shohin_id = shohin.shohin_id
order by tenpo_id;

/*7.2の結果が回答と違う
coalesceを覚えられるかどうか、
概念としては易しいと感じた*/

--以下、練習問題外-------------------------------------------------------

/*集合演算　制約：対象となる… p.232
 * 1.レコードの列数が一致
 * 2.データ型が一致(castで合わせてもok)
 * 3.order byは1つだけ
 *
 *--行(レコード)を連結する
 *・union：重複行を除いて集合し,表示
 *・all：重複行を除かず集合して表示
 *・intersect：共通部分のみ表示
 *・except：先に書いたテーブルから後に書いたテーブルの行を除いて表示
 *
 *--列を連結する
 *・inner join：ある列を橋渡しとし、橋渡し対象列の両方に存在しているデータのみを表示
 *・outer join：ある列を橋渡しとし、どちらかにデータがあればすべて表示、不明部分はnull補完
 *・cross join：直積による結合
 *
 *クロス結合の理解が弱い