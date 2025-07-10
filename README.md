<a href="https://ifellow.ru/"><img height="52" src="media/reqres.PNG" width="175"/></a>

<h1 >Демопроект по автоматизации тестирования для <a href="https://reqres.in/">reqres</a></h1>

## ☑️ Содержание:

- Технологии и инструменты
- Список проверок, реализованных в тестах
- Запуск тестов в Jenkins и из терминала
- Allure-отчет
- Allure TestOps-отчет
- Уведомление в Telegram о результатах прогона тестов


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
  <a href="https://www.jenkins.io/"><img alt="Jenkins" src="media/Jenkins.svg" width="50" height="50"></a>
  <a href="https://github.com/allure-framework/"><img alt="Allure Report" src="media/Allure.svg" width="50" height="50"></a>
  <a href="https://qameta.io/"><img alt="Allure TestOps" src="media/Allure_TO.svg" width="50" height="50"></a>
  <a href="https://telegram.org/"><img alt="Telegram" src="media/Telegram.svg" width="50" height="50"></a>
</p>


## :ballot_box_with_check:Реализованные проверки:

- ### Авторизация
- 🔑 Успешный вход и проверка токена
- 🔒 Неудачные попытки входа с невалидным эмейлом и паролем, отсутствием пароля или эмейла

### Пользователи
- ✅ Корретное обновление имени и работы пользователя
- ✅ Корретное обновление имени и работы пользователя(patch)
- ✅ Невалидные данные пользователя в апдейте

## <img alt="Jenkins" height="25" src="media/Jenkins.svg" width="25"/> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/Api_tests/)


<p align="center">  
<img src="media/screenshorts/Apijenkinssborka.PNG" alt="Jenkins" width="950"/></a>  
</p>


## :ballot_box_with_check: Параметры сборки в Jenkins:

- browser (браузер, по умолчанию chrome)
- browserVersion (версия браузера, по умолчанию 127.0)
- browserSize (размер окна браузера, по умолчанию 1920x1080)


## Команды для запуска из терминала

Локальный запуск:
```bash  
gradle clean Api_test
```
``
Удаленный запуск через Jenkins:
```bash  
clean
Api_test
```

## <img alt="Allure" height="25" src="media/Allure.svg" width="25"/></a>  <a name="Allure"></a>Allure Report	</a>


## Основная страница отчёта

<p align="center">  
<img title="Allure Overview Dashboard" src="media/screenshorts/ApiAllureReportScreen.PNG" width="850">  
</p>  

## Тест-кейсы

<p align="center">  
<img title="Allure Tests" src="media/screenshorts/ApiAllureScreen.PNG" width="850">  
</p>
____

## <img alt="Allure" height="25" src="media/Allure_TO.svg" width="25"/></a> Allure-testops
На Dashboard в Allure TestOps удобно отслеживать статистику по тестам: сколько добавлено, какие ручные, а какие автоматизированы. Платформа позволяет легко запускать нужные тесты, анализировать результаты и управлять тестированием в одном месте — это значительно упрощает работу команды и повышает её эффективность.
____
<p align="center">  
<img title="Allure Overview Dashboard" src="media/screenshorts/ApiTestopsScreen.PNG" width="550">  
</p>

____

## <img alt="Allure" height="25" src="media/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота
____
<p align="center">  
<img title="Allure Overview Dashboard" src="media/screenshorts/ApiTelegramScreen.png" width="550">  
</p>
