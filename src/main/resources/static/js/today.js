//当日の日付を表示するjs六曜は外部APIを使用
//https://kayosystem.blogspot.com/2010/07/web.html
//httpsからの取得なのでデプロイ時に表示されない可能性有

console.log("today.js 読み込みOK");

window.addEventListener("DOMContentLoaded", () => {
    console.log("DOMContentLoaded 実行");

    const box = document.getElementById("todayBox");
    console.log("todayBox:", box);

    if (!box) {
        console.log("todayBox が見つかりません");
        return;
    }

    const today = new Date();
    const year = today.getFullYear();
    const month = today.getMonth() + 1;
    const day = today.getDate();

    fetch(`http://jqreki.appspot.com/qreki/${year}/${month}/${day}`)
        .then(res => res.json())
        .then(data => {
            console.log("六曜API取得成功:", data);
            box.textContent = `本日：${year}年${month}月${day}日　六曜：${data.rokuyo}`;
        })
        .catch(error => {
            console.log("六曜API取得失敗:", error);
            box.textContent = `本日：${year}年${month}月${day}日`;
        });
});