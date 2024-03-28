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
url.template = https://openproject.{}.com

is_vacation = false

hours = 8

work.project_code = 660
work.activity = Testing
work.comment = Auto Testing

vacation.project_code = 45
vacation.activity = Absence
vacation.comment =

date.first_day = 01.03.2024
date.last_day = 31.03.2024
```

**url.template** - шаблон адреса страницы Open Project, не менять

**is_vacation** - eсли заполняемые дни являются отпуском - поставьте `true`, в противном случае `false`;

**work.project_code** - код проекта, указан спава от предложенных результатов при заполнении поля Work package со
знаком `#`. ⚠️вводите только числовое значения, без знака

**work.activity** - значение, которое заполяняется в поле Activity

**work.comment** - любой комментарий. поле может остаться пустым

Все поля **vacation** заполняются аналогично полям work, значения выбираются для отпуска

**date.first_day** - первый заполняемый день в формате `dd.MM.yyyy`

**date.last_day** - последний заполняемый день в формате `dd.MM.yyyy`. Если нужно заполнить один день, то вписывается дата
из **date.first_day** 

