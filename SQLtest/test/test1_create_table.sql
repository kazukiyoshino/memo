\encoding sjis;

--p.31
--1.1 create table
create table jyushoroku
(
toroku_bango integer not null,
namae varchar(128) not null,
jyusho varchar(256) not null,
tel_no char(10),
mail_address char(20),
primary key(toroku_bango)
);

--1.2 add column
alter table jyushoroku add column
yubin_bango char(8) not null;

\d jyushoroku;

--1.3 delete table
drop  table jyushoroku;

--1.4 restore
/*消したテーブル・定義変更の修復コマンドはなし。
RDBMSの機能で可能な場合が多いとのこと*/

--以下、練習問題外-------------------------------------------------------

/*ex.RENAME
alter table 現テーブル名 rename to 新テーブル名;*/