\encoding UTF-8;

/*p.144
4.1 結果：commitされていないため、何も表示されない

4.2 結果：商品idがprimary key ならば、
まったく同じ数字が存在してしまうため不可

4.3 shohinsaekiをつくり、shohinデータ＋saekiテーブルを作成
(hanbai_tanka-shiire_tanka)*/
create table shohinsaeki
(
shohin_id char(4) not null,
shohin_mei varchar(100) not null,
hanbai_tanka integer,
shiire_tanka integer,
saeki integer,
primary key(shohin_id)
);

insert into shohinsaeki(shohin_id,shohin_mei,hanbai_tanka,shiire_tanka,saeki)
select shohin_id,shohin_mei,hanbai_tanka,shiire_tanka,hanbai_tanka-shiire_tanka
from shohin;


--4.4 idが0003の販売単価を3000にし、saekiの再計算
update shohinsaeki
set hanbai_tanka=3000
where shohin_id='0003';

update shohinsaeki
set  saeki = hanbai_tanka-shiire_tanka
where shohin_id='0003';

--4.3のinsertのみやや難

--以下、練習問題外-------------------------------------------------------

--列名省略時のdefault値設定方法がわからない

/*copy作成方法(4.3insert文)

insert into コピー先テーブル名 (コピー先列名)
select コピー元列名
from コピー元テーブル名

※制約・型に注意*/

--delete=内部データの削除・drop=DB・テーブルの削除

--deleteやupdateもwhereなどで条件付き(探索型)が可能

/*トランザクション：ACID特性
 * ・Atomicity：全て更新か、全て更新破棄か
 * ・Consistency：制約を満たすように(制約違反の場合、その文「のみ」無かったことになる)
 * ・Isolation：更新されるまでは、その更新は干渉を受けない(見えない)
 * ・Durability：終了後、その時点でのデータ状態が保証される性質(復旧の手段を持っている事)
 */




