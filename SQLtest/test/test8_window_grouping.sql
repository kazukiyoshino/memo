\encoding sjis;
/*p.291
8.1 select文の実行、結果の確認*/

select shohin_id,shohin_mei,hanbai_tanka,
max (hanbai_tanka) over (order by shohin_id)
as current_max_tanka
from shohin;

8.2 p.291の条件を満たすSQL文

select torokubi, shohin_mei,hanbai_tanka,
sum(hanbai_tanka)over(order by torokubi nulls first)
from shohin;

/*高度処理：8.2 over以下が難