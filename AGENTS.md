# Open Water Detector repository instructions

- `version`はSemVerで管理する。既存のバージョン番号を上書きして使い回さず、修正はpatch、後方互換の機能追加はminor、破壊的変更はmajorを繰り上げる。
- リリースまたは配布用jarを作る前に、`gradle.properties`の`version`を次の適切な番号へ更新する。
- 変更は作業単位ごとにこまめにコミットする。
