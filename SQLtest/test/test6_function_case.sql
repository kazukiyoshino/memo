\encoding sjis;

-- p.227
--6.1 select文の実行と結果の確認

select shohin_mei,shiire_tanka
from shohin
where shiire_tanka not in(500,2800,5000);
--エラー発生せず、通常通りの結果に

select shohin_mei,shiire_tanka
from shohin
where shiire_tanka not in(500,2800,5000,null);
--表示なし、nullは危険

/*6.2 分類分け：販売単価が…
1000以下、1001以上から3000以下、3001以上*/

select sum(case when hanbai_tanka<=1000 then 1 else 0 end) as low_ price,
		sum(case when hanbai_tanka between 1001 and 3000 then 1 else 0 end) as mid_price,
		sum(case when hanbai_tanka>=3001 then 1 else 0 end) as high_price
from shohin;

/*6.2のcase文が若干難(javaのswitch文に若干似ているため、覚えるには時間が必要)
 * 逆に言えばswitch文の感覚が身に染みているため、かなり便利なように感じる
 * 文字列結合'||'がややこしい*/


--ex
