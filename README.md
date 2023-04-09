## 使用技術
### Http通信
- Ktor Client

### DIコンテナ
- Koin

## ライブラリをGithubPackagesにあげる
```
// ./gradlew clean
// ./gradlew assembleRelease assembleDebug
// 上のコマンドでリフレッシュした後で、


./gradlew publish
```

## デバッグ
ライブラリのバージョンに"-debug"を付け足すと、debug版のライブラリを使える
