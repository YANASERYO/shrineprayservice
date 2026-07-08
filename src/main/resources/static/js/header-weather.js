window.addEventListener("DOMContentLoaded", () => {
  const weatherBox = document.getElementById("weatherBox");

  if (!weatherBox) {
    return;
  }

  const latitude = 33.90;
  const longitude = 130.81;

  fetch(`https://api.open-meteo.com/v1/forecast?latitude=${latitude}&longitude=${longitude}&current=temperature_2m,weather_code&timezone=Asia%2FTokyo`)
    .then(res => res.json())
    .then(data => {
      const current = data.current;
      const temperature = current.temperature_2m;
      const weatherCode = current.weather_code;

      const weatherText = convertWeatherCode(weatherCode);

      weatherBox.textContent = `若松区：${temperature}℃　${weatherText}`;
    })
    .catch(() => {
      weatherBox.textContent = "天気情報を取得できません";
    });
});

function convertWeatherCode(code) {
  if (code === 0) {
    return "快晴";
  }

  if (code >= 1 && code <= 3) {
    return "くもり";
  }

  if (code >= 45 && code <= 48) {
    return "霧";
  }

  if (
    (code >= 51 && code <= 67) ||
    (code >= 80 && code <= 82)
  ) {
    return "雨";
  }

  if (
    (code >= 71 && code <= 77) ||
    (code >= 85 && code <= 86)
  ) {
    return "雪";
  }

  if (code >= 95 && code <= 99) {
    return "雷雨";
  }

  return "天気不明";
}