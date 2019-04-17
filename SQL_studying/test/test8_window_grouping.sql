\encoding sjis;
/*p.291
8.1 select文の実行、結果の確認*/

select shohin_id,shohin_mei,hanbai_tanka,
max (hanbai_tanka) over (order by shohin_id)
as current_max_tanka
from shohin;

8.2 p.291の条件を満たすSQL文

select torokubi, shohin_mei,hanbai_tanka,
sum(hanbai_tanka)over(order by torokubi nulls first)--nullが最初、torokubi昇順、「累計」と呼ばれる集計p.273
from shohin;

--高度処理：8.2 over以下が難

--以下、練習問題外-------------------------------------------------------

/*ウィンドウ関数=OLAP関数(OnLine Analytical Processing)
 * ウィンドウ関数 over (partition by 列 order by ソート列)※partitionは省略可能
 *
 * ウィンドウ関数=集約関数・ウィンドウ専用関数
 * rank：順位付け*/

select shohin_id,shohin_mei,hanbai_tanka,hanbai_tanka-shiire_tanka as rieki,
rank() over(order by hanbai_tanka-shiire_tanka desc nulls last)
from shohin;

--集約関数をウィンドウにすると、現在行+上のみのレコードが集計対象==「累計」と呼ばれるロジックになる
select shohin_id,shohin_mei,hanbai_tanka,
sum(hanbai_tanka) over(order by shohin_id)
from shohin;

--フレーム指定-ex.移動平均
/*
 *・rows：行
 *・preceding：前(2の場合、自分+1行前+2行前)
 *・forrowing：後
 */
 select shohin_id,shohin_mei,hanbai_tanka,
 	avg (hanbai_tanka) over (order by shohin_id between rows  2 preceding and 2 following)
 from shohin;

--over内はあくまで計算順序、並べ替えは別に行う

 select shohin_id,shohin_mei,hanbai_tanka,torokubi,
 	rank () over (order by hanbai_tanka desc)
 from shohin
 order by shohin_id ;

 --grouping演算子：合計と集計を同時に行う(group by+合計)その際の便利な関数

 --rollup：全合計＋group byで分けたそれぞれの合計(条件が2つ以上の場合は小計も)p.284

 select shohin_bunrui, torokubi, sum(hanbai_tanka)
 from shohin
 group by rollup(shohin_bunrui,torokubi)
 order by shohin_bunrui;

 --grouping：超集合で生じたnullには1、以外は0

 select grouping(shohin_bunrui),grouping(torokubi),sum(hanbai_tanka)
 from shohin
 group by rollup(shohin_bunrui,torokubi)
 order by shohin_bunrui;

--groupingを利用して合計・小計に名前を付ける
 select case when grouping(shohin_bunrui) = 1
 				then 'shohin_bunrui　合計'
 				else shohin_bunrui end,
 		case when grouping(torokubi) = 1
 				then 'torokubi 合計'
 				else cast(torokubi as varchar(16)) end,--caseの戻り値型は全ての分岐で一致しないとエラー
 		sum(hanbai_tanka)
 from shohin
 group by rollup(shohin_bunrui,torokubi)
 order by (shohin_bunrui,torokubi);

 --cube：全ての可能なgroup by区内の2つの組み合わせを小計する

 select case when grouping(shohin_bunrui) = 1
 				then 'shohin_bunrui　合計'
 				else shohin_bunrui end,
 		case when grouping(torokubi) = 1
 				then 'torokubi 合計'
 				else cast(torokubi as varchar(16)) end,
 		sum(hanbai_tanka)
 from shohin
 group by cube(shohin_bunrui,torokubi)
 order by (shohin_bunrui,torokubi);

 --grouping set：cubeとrollupで求めた結果の一部だけを表示
 --それぞれを単独で集約キーとしたい場合

 select case when grouping(shohin_bunrui) = 1
 				then 'shohin_bunrui 合計'
 				else shohin_bunrui end,
 		case when grouping(torokubi) = 1
 				then 'torokubi 合計'
 				else cast(torokubi as varchar(16)) end,
 		sum(hanbai_tanka)
 from shohin
 group by grouping sets(shohin_bunrui,torokubi)
 order by (shohin_bunrui,torokubi);

 --rollup(左から順に表示・集約キーを追加・表示を繰り返す)
 --cube(単独・組み合わせ・全てを表示)
 --grouping set(指定した条件のもののみ、上記はそれぞれ単独で抜き出した場合のコード)

 --全章において、語句・構文の混濁に注意
