# FuelsApp

## Задание

Написать приложение, которое стартует с Splash экрана. На втором
экране происходит REST запрос где выводится список городов РФ, при
клике на название города переходим на следующий экран. На котором
под Statusbar в Toolbar вывести надпись «Период», где
горизонтально в ряд будет две иконки с календарем и датами в формате
«ДД.ММ.ГГГГ», ряд должен быть разделен на две части. Разделение
будет начала и конца периода, в конечном периоде должна стоять
Текущая дата, а в начальном -6 месяцев.
При старте этого экрана, должен происходить REST запрос на сервер,
чтобы получить Мок данные по стоимости каждой категории бензина на
этот период времени(текущая дата минус 6 месяцев) с передачей
названия города с предыдущего экрана, если приходит ошибка
- обрабатываем и показываем заглушку. Если приходит пустой список -
обрабатываем - показываем заглушку. При клике на элемент списка
открываем делатку и показываем сравнение цен на тот момент с текущим,
лучше в виде графика.
Один элемент списка - 1 день. Название топлива - цена за литр.


## Технологии

* Язык программирования Kotlin
* Jetpack Compose
* Compose, Flow, Coroutines, single Activity
* Retrofit c Moshi, JSON
* 

## Использование

1. Откройте приложение.
2. Выберите файл для загрузки в формате txt или fb2.
3. Укажите количество самых длинных неоднокоренных слов для поиска.
4. Нажмите кнопку "Выбрать файл".
5. Результаты будут выведены на экран в формате `<слово> <длина> <частота>` в порядке уменьшения длины.
6. Время работы функции поиска будет отображено на экране.

## Команда: NV

* Шиятов Наиль Дмитриевич - капитан команды
* Лашин Виктор Алексеевич
* Военный Никита Андреевич
* Пирко Владимир Владимирович