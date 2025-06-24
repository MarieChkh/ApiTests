<a href="https://ifellow.ru/"><img height="52" src="media/reqres.PNG" width="175"/></a>

<h1 >Демопроект по автоматизации тестирования для <a href="https://reqres.in/">reqres</a></h1>

## ☑️ Содержание:

- Технологии и инструменты
- Список проверок, реализованных в тестах
- Запуск тестов (сборка в Jenkins) и из терминала
- Allure-отчет
- Allure-testops
- Уведомление в Telegram о результатах прогона тестов
- Видео пример прохождения тестов


<a id="tools"></a>
## :ballot_box_with_check:Технологии и инструменты:

## Технологии и инструменты
<p>
  <a href="https://www.jetbrains.com/idea/"><img alt="IntelliJ IDEA" src="media/Idea.svg" width="50" height="50"></a>
  <a href="https://github.com/"><img alt="GitHub" src="media/GitHub.svg" width="50" height="50"></a>
  <a href="https://www.java.com/"><img alt="Java" src="media/Java.svg" width="50" height="50"></a>
  <a href="https://gradle.org/"><img alt="Gradle" src="media/Gradle.svg" width="50" height="50"></a>
  <a href="https://junit.org/junit5/"><img alt="JUnit 5" src="media/Junit5.svg" width="50" height="50"></a>
  <a href="https://rest-assured.io/"><img alt="Rest Assured" src="media/RestAssured.svg" width="50" height="50"></a>
  <a href="https://selenide.org/"><img alt="Selenide" src="media/Selenide.svg" width="50" height="50"></a>
  <a href="https://aerokube.com/selenoid/"><img alt="Selenoid" src="media/Selenoid.svg" width="50" height="50"></a>
  <a href="https://www.jenkins.io/"><img alt="Jenkins" src="media/Jenkins.svg" width="50" height="50"></a>
  <a href="https://github.com/allure-framework/"><img alt="Allure Report" src="media/Allure.svg" width="50" height="50"></a>
  <a href="https://qameta.io/"><img alt="Allure TestOps" src="media/Allure_TO.svg" width="50" height="50"></a>
  <a href="https://telegram.org/"><img alt="Telegram" src="media/Telegram.svg" width="50" height="50"></a>
</p>


## :ballot_box_with_check:Реализованные проверки:

- Проверка заголовка главной страницы
- В разделе меню 'О компании' проверяем наличие заголовка
- В разделе меню 'Продукты' проверяем наличие заголовка
- В разделе меню 'Карьера' проверяем наличие заголовка
- В разделе меню 'Партнеры' проверяем наличие заголовка

## <img alt="Jenkins" height="25" src="media/Jenkins.svg" width="25"/> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/Students/job/18-lom14-betcity/)


<p align="center">  
<img src="media/screenshorts/jenkinssborka.PNG" alt="Jenkins" width="950"/></a>  
</p>


## :ballot_box_with_check: Параметры сборки в Jenkins:

- browser (браузер, по умолчанию chrome)
- browserVersion (версия браузера, по умолчанию 127.0)
- browserSize (размер окна браузера, по умолчанию 1920x1080)


## Команды для запуска из терминала

Локальный запуск:
```bash  
gradle clean ifellow_test
```
Запуск с параметрами:
```bash  
-Dbrowser=chrome -DbrowserVersion=127.0 -DbrowserSize=1920x1080
```
Удаленный запуск через Jenkins:
```bash  
clean
ifellow_test
-Dbrowser=${browser} 
-DbrowserVersion=${browserVersion} 
-DremoteUrl="https://user1:1234@${remoteUrl}/wd/hub" 
-DbrowserSize=${browserSize}
```

## <img alt="Allure" height="25" src="media/Allure.svg" width="25"/></a>  <a name="Allure"></a>Allure Report	</a>


## Основная страница отчёта

<p align="center">  
<img title="Allure Overview Dashboard" src="media/screenshorts/allurereportscreen.PNG" width="850">  
</p>  

## Тест-кейсы

<p align="center">  
<img title="Allure Tests" src="media/screenshorts/testcase.PNG" width="850">  
</p>
____

## <img alt="Allure" height="25" src="media/Allure_TO.svg" width="25"/></a> Allure-testops
На Dashboard в Allure TestOps удобно отслеживать статистику по тестам: сколько добавлено, какие ручные, а какие автоматизированы. Платформа позволяет легко запускать нужные тесты, анализировать результаты и управлять тестированием в одном месте — это значительно упрощает работу команды и повышает её эффективность.
____
<p align="center">  
<img title="Allure Overview Dashboard" src="media/screenshorts/allureToscreen.PNG" width="550">  
</p>

____

## <img alt="Allure" height="25" src="media/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота
____
<p align="center">  
<img title="Allure Overview Dashboard" src="media/screenshorts/telegramscreen.PNG" width="550">  
</p>

____
## <img alt="Selenoid" height="25" src="media/Selenoid.svg" width="25"/></a> Примеры видео выполнения тестов на Selenoid
____
<p align="center">
<img title="Selenoid Video" src="media/video/video.gif" width="550" height="350"  alt="video">   
</p>