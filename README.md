## OpenProject Time track ##

Проект создан для регистрации времени за месяц черен GUI сервиса openproject

Запускать на **Java17**

## Конфигурация запуска ##

⚠️Убедитесь, что подключен ВПН

Чтобы настроить конфигурацию запуска, нужно выбрать `Edit Configurations... -> 
Edit configuration templates... -> Application -> Environment Variables`

Через кнопку `+` добавьте переменные среды
- **login** - ваш логин в Open Project
- **password** - ваш пароль в Open Project
- **company** - название вашей компании, которая отражается в URL Open Project

## Конфигурация параметров заполнения ##

Для того, чтобы настроить параметры заполнения, изменяйте параметры в файле src/main/resources/config.properties

```properties
url.template=https://openproject.{}.com
hours=4

work.project_code=4085
work.activity=Testing
#vacation
#work.project_code=45
#work.activity=Absence
work.comment=Auto Testing

date.first_day=01.07.2024
date.last_day=12.07.2024
```

**url.template** - шаблон адреса страницы Open Project, не менять

**work.project_code** - код проекта, указан спава от предложенных результатов при заполнении поля Work package со
знаком `#`. ⚠️вводите только числовое значения, без знака

**work.activity** - значение, которое заполяняется в поле Activity

**work.comment** - любой комментарий. поле может остаться пустым

**date.first_day** - первый заполняемый день в формате `dd.MM.yyyy`

**date.last_day** - последний заполняемый день в формате `dd.MM.yyyy`. Если нужно заполнить один день, то вписывается дата
из **date.first_day** 

## Запуск ##

Для запуска используем метод _main()_ класса _com.openproject.LogTime_

☝️Если необходимо ввести код подтверждения то у вас на это есть 3 минуты. В этом случае не забудьте сами нажать кнопку "Sign in"