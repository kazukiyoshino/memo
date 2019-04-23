\encoding UTF-8;

/*p.176
5.1 条件を満たすビューを作成
条件1：販売単価が1000以上
条件2：登録日が2009-09-20
条件3：列は商品名、販売単価、登録日*/

create view viewrensy5_1 as
select shohin_mei,hanbai_tanka,torokubi
from shohin
where hanbai_tanka>=1000 and torokubi= '2009-09-20';

/*5.2 データ追加と結果の確認：エラー発生

insert into viewrenshu5_1 values('ナイフ',300,'2009-11-02')
=not null 制約

5.3 p177を満たすselect文を考える*/

select shohin_id,shohin_mei,shohin_bunrui,hanbai_tanka,
(select avg(hanbai_tanka)
from shohin) as hanbai_tanka_all
from shohin;

--5.4 p177を満たすようにビューを持つ(条件は5.1と同じ)

select shohin_id,shohin_mei,shohin_bunrui,hanbai_tanka,

(select avg(hanbai_tanka)
from shohin s2
where s1.shohin_bunrui = s2 shohin_bunrui --相関サブクエリp.172参照、分類ごとにスカラ値を出している
group by s2 syohin_bunrui)

as hanbai_tanka_all
from shohin;

/*ビューは大変便利・感覚としては絞り込み条件の保存
5-3 avgの記述に注意
5-4 サブクエリ・やや難*/

--以下、練習問題外-------------------------------------------------------

/*ビュー作成方法
create view view名(付けたければviewの列名)
as
select文
from 対象テーブル
その他(where・groupなど)

・ビューにビューを重ねる行為は非推奨
・order byは使えない
・viewとtableは連動しているため、更新に制限がかかる*/

/*サブクエリ
 * from内にview定義に使用するようなselect文を挿入する
 * From=参照対象*/
/*スカラ・サブクエリ→計算可能な単一の数値となるサブクエリのこと
 *スカラ・サブクエリはほぼあらゆるところに作成可能
 *複数行(値)を返すとただのサブクエリ、注意
 */


