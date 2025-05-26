# JavaPlayground
Javaを使うリポジトリ。


## gitの設定
git cloneした後、以下の手順でコンテナ内へsshキーを配置します。

### 1. ホストマシンの SSH キーを確認
ホストマシンに SSH キーが存在するか確認します（通常は ~/.ssh/id_rsa または ~/.ssh/id_ed25519）。
```
ls ~/.ssh
```

### 2. SSH キーを Dev Container にコピー
ホストマシンから Dev Container に SSH キーをコピーします。
<コンテナID>には、実際のコンテナ ID を入力してください(`docker ps`で！)。
```
docker cp ~/.ssh/id_ed25519 <コンテナID>:/root/.ssh/id_ed25519
docker cp ~/.ssh/id_ed25519.pub <コンテナID>:/root/.ssh/id_ed25519.pub
```

### 3. SSH キーのパーミッションを修正
コンテナ内で以下を実行して、SSH キーのパーミッションを適切に設定します。
```
chmod 600 ~/.ssh/id_ed25519
chmod 644 ~/.ssh/id_ed25519.pub
```

### GitHub に接続できるか確認
コンテナ内で以下を実行して、GitHub に接続できるか確認します。
```
ssh -T git@github.com
```