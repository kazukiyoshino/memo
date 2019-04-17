\encoding sjis;


/*3.1 間違い探し p.109
select shohin_id,sum(shohin_mei)
from shohin
group by shohin_bunrui
where torokubi>'2009-09-01';

間違い箇所
1.sum対象が文字
2.where文とgroup by文の位置が逆
3.selectとgroup byの指定列が一致していない

3.2 select 販売単価の合計が仕入れ単価の1.5倍のみ表示*/
select shohin_bunrui,sum(hanbai_tanka),sum(shiire_tanka)
from shohin
group by shohin_bunrui--重要.p84参照
having sum(hanbai_tanka)>sum(shiire_tanka)*1.5;


--3.3 どんなorder byだったか

select *
from shohin
order by torokubi desc,hanbai_tanka asc;

--若干難

--以下、練習問題外-------------------------------------------------------

--ex.集約関数

--集約関数は、count(*)のみ「null」を無視しない
select *
from shohin;

select
'shiire_tankaの計算結果' as 計算方法,
count(*),
count(shiire_tanka),
sum(shiire_tanka),
avg(shiire_tanka),
max(shiire_tanka),
min(shiire_tanka),
count(distinct shiire_tanka)
from shohin;

/*group byの制約
使用の際、select文には、
・定数
・集約関数
・group byで指定した列名
のみ使用可能 p.88参照*/