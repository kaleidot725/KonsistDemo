# KonsistDemo

Konsist の最小設定を入れた Android サンプルプロジェクトです。

Jetpack Compose で作成したシンプルな Android アプリに、Konsist を JUnit の unit test として追加しています。

## 構成

- Android application module: `app`
- Package: `com.example.konsistdemo`
- UI: Jetpack Compose
- Test: JUnit
- Architecture lint: Konsist

## 必要な環境

- JDK 17
- Android SDK
- Android SDK Platform 36

## Konsist の設定

Konsist は `testImplementation` として追加しています。

```kotlin
testImplementation(libs.konsist)
```

依存関係のバージョンは `gradle/libs.versions.toml` で管理しています。

```toml
konsist = "0.17.3"
konsist = { module = "com.lemonappdev:konsist", version.ref = "konsist" }
```

最小の Konsist テストは `app/src/test/java/com/example/konsistdemo/KonsistTest.kt` にあります。

```kotlin
class KonsistTest {
  @Test
  fun `production classes reside in the app package`() {
    Konsist
      .scopeFromProduction()
      .classes()
      .assertTrue { it.resideInPackage("com.example.konsistdemo..") }
  }
}
```

このテストでは、production code の class が `com.example.konsistdemo` package 配下にあることを検査します。

## ビルド

```sh
./gradlew build
```

## Unit Test

```sh
./gradlew testDebugUnitTest
```

Konsist のテストもこの unit test に含まれます。

## APK 生成

```sh
./gradlew assembleDebug
```

生成された debug APK は次の場所に出力されます。

```text
app/build/outputs/apk/debug/app-debug.apk
```
