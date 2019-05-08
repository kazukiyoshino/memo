\encoding UTF-8;

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

/*6.2のcase文がjavaのif文・switch文に若干似ているため、
 * 理解は容易だが覚えるには慣れが必要(混ざってしまいそうになる)
 * 文字列結合'||'がややこしい*/


--以下、練習問題外-------------------------------------------------------

/*算術関数
 * abs(値)：絶対値
 * mod(被序数,序数)：剰余
 * round(対象,桁数)：四捨五入*/

/*文字列関数
 * || :連結
 * length(文字列)：文字長
 * lower(文字列)：小文字化
 * upper(文字列)：大文字化
 * replace(対象,置換前文字,置換後文字)：文字置換
 * substring(対象,from 開始地点, for 文字数)：左から〇字切り出し*/

/*日付関数
 * current_date：今日(実行時)の日付
 * current_time：今日(実行時)の時間
 * current_timestamp：上2つを合わせたもの
 * extract(日付要素,from 日付)：切り出し(日付要素=yearやmonthなど)*/

/*変換関数
 * cast(変換前数値,as 変換後の型)：キャスト
 * coalesce(数値,数値2,数値3…)：左から順に値を見て、nullでない値を返す
 * coalesce(null,null,1,null,2)ならば、1が返ってくる*/

/*述語
 * like 'パターンマッチング'：部分一致検索
 * between 数値 and 数値 ：範囲検索
 * is (not) null ：(非)nullであるかどうか
 * (not) in (数値,数値2…)：orの簡略記述
 * 列名 (not) in (サブクエリ) ：で複数の条件に使う値を変数的に持たせることが出来る*/

select shohin_mei,shiire_tanka,torokubi
from shohin
where shohin_id in (select shohin_id
						from shohin
						where hanbai_tanka<=500);


/*exists(相関サブクエリ)：レコードがあれば真を返す？
 * 大体(not)inで代用できる？
 * 慣習としてselect* を使う
 * 難解*/

/*case基本式
 * case when 評価式 then 行う式
 * 		when 評価式 then 行う式
 *		…
 *		else 行う式
 *end
 *※elseは省略非推奨、endは省略不可*/


--caseは行列変換に有効

select shohin_bunrui,sum(hanbai_tanka)
from shohin
group by shohin_bunrui;

select sum(case when shohin_bunrui='衣服' then hanbai_tanka else 0 end),
sum(case when shohin_bunrui='キッチン用品' then hanbai_tanka else 0 end),
sum(case when shohin_bunrui='事務用品' then hanbai_tanka else 0 end)
from shohin;


