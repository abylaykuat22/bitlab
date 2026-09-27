- `<html lang="en">`: Начало HTML документа с указанием языка страницы.
- `<head>`: Контейнер для метаданных и заголовков документа.
    - `<meta charset="UTF-8">`: Устанавливает кодировку символов страницы как UTF-8.
    - `<title>`: Заголовок документа.
- `<body>`: Основное содержимое документа.
    - `<h1>`, `<h2>`, `<h3>`, `<h4>`, `<h5>`, `<h6>`: Заголовки различных уровней.
    - `<br>`: Перевод строки.
    - `<p>`: Параграф текста.
    - `<img>`: Вставка изображения.
    - `<a>`: Ссылка.
    - `<input>`: Поле ввода.
        - `type="text"`, `type="email"`, `type="password"`, `type="number"`, `type="date"`, `type="datetime-local"`: Типы полей ввода.
    - `<button>`: Кнопка.
    - `<ol>`: Нумерованный список.
        - `<li>`: Элемент нумерованного списка.
    - `<ul>`: Маркированный список.
        - `<li>`: Элемент маркированного списка.
    - `<table>`: Таблица.
        - `<thead>`, `<tbody>`: Секции таблицы.
        - `<tr>`: Строка таблицы.
        - `<th>`: Заголовок ячейки таблицы.
        - `<td>`: Ячейка таблицы.

Пример:
```html
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>BITLAB</title>
</head>
<body>
<h1>SALEM</h1>
<h2>SALEM</h2>
<h3>SALEM</h3>
<h4>SALEM</h4>
<h5>SALEM</h5>
<h6>SALEM</h6>
<br>
<p>
  Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
  tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
  quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
  consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
  cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
  proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
</p>
<img src="https://lh3.googleusercontent.com/u/1/docs/ADP-6oEDsvIrSMLc9H2lSmuKHlpPfra4M08SqCzYHwfwgO-x4RRkoVPNNch2-HZsZc3UHG7x4CciabuVIgHL-p-ASnA7WF76FU6SbU5X79xXBqhsmuN5RJvFZwHYNoC5dHBPo15xhKu3ehfkvq7sDuB8SyizNLvhs2X-bby1Tr8wpeH1GO5o-dVwTn_wz72j0HLZtGdIpZ7n8VSNqHpxvv8WHK2e2GCDszzNUrR-gB5BAx5BCSWRdDKR46Lie1zuapP6c1p9chdFfhXJAmRZUZm4EyDWdY4gYUe174UlnEy6B_B8OSpyUOAOTL85L369lCaAK4t1pdQB6CBpUlsalxSJpqpB6RqrFJfbgSmeGWxR3vddYUSJimZZA93o0mlkmyp4UzCbOzfWNPTZCFIqjb7ar9QN4TDhUnwPaREKc_wVSfy1FfduECwzGlvzp_nHUeEw4uDxowKveaEGECmzmCmAxDdF_hqLwhEVNNk0MBaYWWj4c-BEfrqYySdFzjKtsRuIuOdOImiHASk9F9SlKdNx0lpt5BF1SgTWbpBCz0CUc_uAbVwNkgtV0M6YdT2taMQf8b2ZTmzjfWFIaIWgKi318KuE_Y_0EM_D33Cc30g3Z30PWocByFhuGEKl4LsG7YoYg1VZhzHPj48k7kr9nOt_ZCvvToA2qJUOaWaJxOgqb5LH-HSuPKQvh1uBOwUAs2rWOe9fMOP5_S3Ef4YpS-Hxzjd_zj-eu5-kCf84r_MxvR-HaAH9y4kjVY5RZyPSPvCj_l14CbaF095ov4nCFua4HD4DDkQclmOHZZlnYh372tY6DhKdpbw-2gAKvpQfHsDXRxXx7flyz2oSYke_XX0H8oLObiJg_bppbFB6Gixv-_SsHXg8yfUJ02r8NkVWYYtCXSjXRnb28Pt6JZsAZ3xK4ycg53P1RKK69UmSi7z20WK8kU4g20bPGMmT8qQ">
<a href="https://www.kinopoisk.ru">KINOPOISK</a><br><br>
ИМЯ: <input type="text" value="Tom" placeholder="Введите имя: "><br><br>
ПОЧТА: <input type="email"><br><br>
ПАРОЛЬ: <input type="password"><br><br>
ВОЗРАСТ: <input type="number" step="10" max="100" min="-100"><br><br>
ДАТА: <input type="date"><br><br>
ВРЕМЯ: <input type="datetime-local"><br><br>
МУЖЧИНА: <input type="radio" name="gender"><br><br>
ЖЕНЩИНА: <input type="radio" name="gender"><br><br>
ФАЙЛ: <input type="file">
<button>Кнопка</button>

<ol>
  <li>Java</li>
  <li>HTML</li>
  <li>CSS</li>
  <li>JAVA SCRIPT</li>
</ol>

<ul>
  <li>C#</li>
  <li>C++</li>
  <li>SCALA</li>
  <li>GO</li>
</ul>

<table border="1px" cellpadding="10px">
  <thead>
    <tr>
      <th>ИМЯ</th>
      <th>ВОЗРАСТ</th>
      <th>ПОЛ</th>
      <th>ГОРОД</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Даниял</td>
      <td>18</td>
      <td>Мужской</td>
      <td>Алматы</td>
    </tr>
    <tr>
      <td>Нурсултан</td>
      <td>18</td>
      <td>Мужской</td>
      <td>Астана</td>
    </tr>
    <tr>
      <td>Икрам</td>
      <td>18</td>
      <td>Мужской</td>
      <td>Астана</td>
    </tr>
  </tbody>
</table>
</body>
</html>


```
