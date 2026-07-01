//当日の日付を表示するjs六曜は外部APIを使用
//https://kayosystem.blogspot.com/2010/07/web.html
//httpsからの取得なのでデプロイ時に表示されない可能性有

window.addEventListener("DOMContentLoaded", () => {
    const box = document.getElementById("todayBox");

    if (!box) {
        return;
    }

    const today = new Date();
    const year = today.getFullYear();
    const month = today.getMonth() + 1;
    const day = today.getDate();

    fetch(`http://jqreki.appspot.com/qreki/${year}/${month}/${day}`)
        .then(res => res.json())
        .then(data => {
            box.textContent = `本日：${year}年${month}月${day}日　六曜：${data.rokuyo}`;
        })
        .catch(() => {
            box.textContent = `本日：${year}年${month}月${day}日`;
        });
});