# 家族間タスク管理アプリ

## アプリ概要
家族間でしなければいけないorしてほしいタスクを管理できるアプリ。  
以下の情報を持ち、それぞれ登録、修正、削除ができる。  
タスク情報（依頼主、請負主、タスク、期限）  

## 作成背景
　家族間で頼んだ事や頼まれた事を口頭にて行っていたが、他の作業しており忘れてしまう事が何度か発生したので今回新しいアプリを作成しようと思いました。

## 主な使用技術
### バックエンド
- #### Java (Spring Boot):
 Spring Bootフレームワークを使用して、タスク管理APIやユーザー認証などのバックエンド処理を実装しています。  
タスクの追加、更新、削除、完了処理を実行します。Spring Securityも導入しております。ログインやユーザー認証に関する処理が含んでいます。  
OpenAPI仕様に基づいてAPIドキュメントを生成しています。

- #### Thymeleaf:
 。HTMLテンプレート内に動的なデータを挿入して、ユーザーにページを提供しています。  
タスクの管理ページやユーザー登録、ログインフォームがThymeleafを通して構築されています。

- #### MySQL:
 タスクやユーザーの情報を永続化するためのデータベースとしてMySQLを使用しています。  
タスクの管理、ユーザーの情報、完了済みタスクや履歴タスクのデータが保存されます。  

### フロントエンド
- #### HTML5 & CSS3:
 index.htmlのような静的ファイルを用いて、UIの基礎的な構造を構築しています。  
タスク管理ページのレイアウト、フォーム、ボタンのデザインをこれらの技術で構成しています。  

- #### JavaScript:
 フォームの動的な更新やモーダルダイアログでのタスクの編集に利用されています。  

- #### Swagger UI:
 APIのドキュメントをユーザーがブラウザで閲覧できるようにするため、Swagger UIを導入しています。これにより、openapi.ymlをもとにAPIエンドポイントの仕様が視覚的に確認できるようにしています。

### その他

- #### Docker:
 Dockerを使用してアプリケーション全体のコンテナ化を行い、開発・デプロイ環境の簡易化と移植性の向上を図っています。  
 
- #### GitHub Pages:
 静的なページホスティングとしてGitHub Pagesを利用しています。ここではSwagger UIをデプロイしてAPI仕様書を公開しています。  

- #### OpenAPI:
APIのドキュメンテーションおよび設計を行うためにOpenAPI（バージョン3.1.0）を使用しています。

### 技術スタックまとめ
- バックエンド: Java, Spring Boot, Spring Security, MySQL
- フロントエンド: HTML5, CSS3, JavaScript, Thymeleaf, Swagger UI
- その他: Docker, OpenAPI, GitHub Pages  
この技術スタックを通じて、タスク管理アプリケーションを構築し、APIの設計・ドキュメント化、認証、データベースとの連携などの処理が行われています。  

## アプリケーション概略図
![アプリケーション概要図](https://github.com/user-attachments/assets/ac789140-e7c3-42f7-adb5-9f0fda58c71d)


## アプリケーション機能一覧
|項目|概要|
|:--|---:|
|新規ユーザーの登録|新規ユーザーの登録|
|タスクの表示|タスク（未完了・完了）の情報を表示できる|
|新規タスクの登録|タスクの新規登録ができる|
|タスク情報修正|指定したタスクの情報を修正ができる|
|タスクの削除|指定したタスクの削除ができる|

## 使用イメージ
### 新規ユーザー登録

https://github.com/user-attachments/assets/0a495326-5475-4856-afb7-469bd28ea839

### ユーザーログイン

https://github.com/user-attachments/assets/19b04241-b88d-4e41-9a60-ec492cc5d6ae

### 新規タスクの登録・修正・削除・完了

https://github.com/user-attachments/assets/5f04a0a0-c398-4360-8ccf-00bfe8543bf2

### 完了済みタスクの完了・ユーザー履歴に移行

https://github.com/user-attachments/assets/c52c8800-77af-421c-8b4e-7cade2c7524d


## 設計書
### E-R図

![tasklist](https://github.com/user-attachments/assets/632ecd2c-c4f0-4246-8fd7-742bd598bf27)

API仕様書
[SwaggerによるAPI仕様書](



ローカルでのアプリケーション起動方法
Git, Java, Node.Js, Dockerをインストールする。

リポジトリをgit cloneする。
git clone https://github.com/rinna-kawaguchi/Equipment-Management-API.git

クローンしたディレクトリに移動する。

Dockerを起動する。
docker compose up

Spring Bootを起動する。
./gradlew bootRun

frontendディレクトリに移動する。
cd frontend/

依存関係をインストールし、Reactのアプリケーションを起動する。
npm install
npm start
（yarnがインストールされている場合は下記コマンドでも可）
yarn
yarn start

自動テスト
以下のテストコードを実装。

単体テスト
EquipmentServiceImpl, PlanServiceImpl, HistoryServiceImpl
EquipmentMapper, PlanMapper, HistoryMapper
結合テスト
EquipmentController, PlanController, HistoryController
自動テストの実行結果


作成スケジュール
当初の計画


実績


進捗状況の振り返り
当初２週間程度で作成する予定でしたが、結果的には１ヶ月程度かかってしまいました。

反省点

フロント側の実装時間の想定が甘かった
→ フロント側はバック側に比べて学習歴が浅く、思ったよりも時間がかかりました。 もっと自分の力量を見極めて計画を作成しなければいけないと感じました。
追加したい機能がどんどん出てきてしまった
→ 最低限の機能を実装したあと、追加したい機能や、修正したい箇所がどんどんでてきてしまいました。 まだ知識が浅いため、ひとつひとつを実現するのに時間がかかり、結果的に大幅な遅れに繋がってしまいました。 より良くするための改善ではあったものの、最低ラインまでできたら一旦リリースし、後から修正を加えていく方がよかったと感じました。
今後の展望
追加機能の実装 (Issues)
Spring Securityの導入
CDの導入
フロント側の自動テスト
フロント側のさまざまなスタイル調整
About
project for portfolio

Resources
 Readme
 Activity
Stars
 0 stars
Watchers
 1 watching
Forks
 0 forks
Report repository
Releases
No releases published
Packages
No packages published
Deployments
56
 github-pages last year
+ 55 deployments
Languages
Java
67.9%
 
TypeScript
31.1%
 
Other
1.0%
Footer
© 2024 GitHub, Inc.
Footer navigation
Terms
Privacy
