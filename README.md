Тестовое задание в Компанию Idea Platform

Задание:
В приложенном файле flights_and_forecast.json содержится
информация о рейсах между городами (см. поле "flights"), и о
прогнозе погоды в указанных городах (см. поле "forecast").
Описание полей рейса:
 no - номер рейса;
 departure - время отправления по МЕСТНОМУ времени;
 from - город отправления;
 to - город назначения;
 duration - время полета в часах.
Описание полей прогноза погоды:
 time - МЕСТНОЕ время;
 wind - скорость ветра в м/с;
 visibility - видимость в метрах.
Погода считается летной, если скорость ветра не превышает 30 м/с
и видимость не менее 200 м.
Рейс выполняется по расписанию, если наблюдается летная погода в
городе отправления в момент вылета и в городе назначения в
момент прилета.
Рейс отменяется во всех остальных случаях.
Задание:
Написать программу на языке Java, которая для каждого рейса
выведет информацию о его статусе в формате:
Номер рейса | Город отправления -> Город назначения | Статус
Пример вывода:
F1 | moscow -> novosibirsk | по расписанию
F2 | moscow -> omsk | отменен
...
Ответом на задание считается:
Сообщение/файл с выводом информации по рейсам и листинг кода.

Как тестировать:
1) Склонировать проект
git clone --recurse-submodules github.com/M437A/testTaskIdeaPlatform
2) Запустить
3) Сделать Get запрос по адресу http://localhost:8080/api используя следующий json:
{
    "flights":[
        {
            "no": "F1",
            "departure": 5,
            "from": "moscow",
            "to": "novosibirsk",
            "duration": 4
        },
        {
            "no": "F2",
            "departure": 5,
            "from": "moscow",
            "to": "omsk",
            "duration": 3
        },
        {
            "no": "F3",
            "departure": 6,
            "from": "omsk",
            "to": "novosibirsk",
            "duration": 1
        },
        {
            "no": "F4",
            "departure": 6,
            "from": "novosibirsk",
            "to": "omsk",
            "duration": 1
        },
        {
            "no": "F5",
            "departure": 8,
            "from": "novosibirsk",
            "to": "moscow",
            "duration": 4
        },
        {
            "no": "F6",
            "departure": 6,
            "from": "omsk",
            "to": "moscow",
            "duration": 3
        },
        {
            "no": "F7",
            "departure": 8,
            "from": "moscow",
            "to": "novosibirsk",
            "duration": 4
        },
        {
            "no": "F8",
            "departure": 9,
            "from": "moscow",
            "to": "omsk",
            "duration": 3
        },
        {
            "no": "F9",
            "departure": 16,
            "from": "omsk",
            "to": "novosibirsk",
            "duration": 1
        },
        {
            "no": "F10",
            "departure": 12,
            "from": "omsk",
            "to": "novosibirsk",
            "duration": 1
        }
    ],
    "forecast":{
        "moscow":[
            {"time": 0, "wind": 18, "visibility": 150},
            {"time": 1, "wind": 22, "visibility": 210},
            {"time": 2, "wind": 25, "visibility": 180},
            {"time": 3, "wind": 33, "visibility": 180},
            {"time": 4, "wind": 29, "visibility": 190},
            {"time": 5, "wind": 27, "visibility": 220},
            {"time": 6, "wind": 35, "visibility": 211},
            {"time": 7, "wind": 28, "visibility": 198},
            {"time": 8, "wind": 22, "visibility": 100},
            {"time": 9, "wind": 10, "visibility": 300},
            {"time": 10, "wind": 14, "visibility": 400},
            {"time": 11, "wind": 19, "visibility": 500},
            {"time": 12, "wind": 40, "visibility": 210},
            {"time": 13, "wind": 32, "visibility": 700},
            {"time": 14, "wind": 24, "visibility": 300},
            {"time": 15, "wind": 22, "visibility": 280},
            {"time": 16, "wind": 18, "visibility": 100},
            {"time": 17, "wind": 16, "visibility": 200},
            {"time": 18, "wind": 37, "visibility": 300},
            {"time": 19, "wind": 22, "visibility": 300},
            {"time": 20, "wind": 10, "visibility": 100},
            {"time": 21, "wind": 4, "visibility": 90},
            {"time": 22, "wind": 0, "visibility": 10},
            {"time": 23, "wind": 5, "visibility": 100},
            {"time": 24, "wind": 18, "visibility": 300}
        ],
        "novosibirsk":[
            {"time": 0, "wind": 18, "visibility": 150},
            {"time": 1, "wind": 22, "visibility": 210},
            {"time": 2, "wind": 25, "visibility": 180},
            {"time": 3, "wind": 33, "visibility": 180},
            {"time": 4, "wind": 29, "visibility": 190},
            {"time": 5, "wind": 27, "visibility": 220},
            {"time": 6, "wind": 35, "visibility": 211},
            {"time": 7, "wind": 28, "visibility": 198},
            {"time": 8, "wind": 22, "visibility": 100},
            {"time": 9, "wind": 10, "visibility": 300},
            {"time": 10, "wind": 14, "visibility": 400},
            {"time": 11, "wind": 19, "visibility": 500},
            {"time": 12, "wind": 35, "visibility": 210},
            {"time": 13, "wind": 28, "visibility": 700},
            {"time": 14, "wind": 24, "visibility": 300},
            {"time": 15, "wind": 22, "visibility": 280},
            {"time": 16, "wind": 18, "visibility": 100},
            {"time": 17, "wind": 16, "visibility": 200},
            {"time": 18, "wind": 37, "visibility": 300},
            {"time": 19, "wind": 22, "visibility": 300},
            {"time": 20, "wind": 10, "visibility": 100},
            {"time": 21, "wind": 4, "visibility": 90},
            {"time": 22, "wind": 0, "visibility": 10},
            {"time": 23, "wind": 5, "visibility": 100},
            {"time": 24, "wind": 18, "visibility": 300}
        ],
        "omsk":[
            {"time": 0, "wind": 18, "visibility": 210},
            {"time": 1, "wind": 22, "visibility": 210},
            {"time": 2, "wind": 25, "visibility": 1000},
            {"time": 3, "wind": 33, "visibility": 1100},
            {"time": 4, "wind": 29, "visibility": 2000},
            {"time": 5, "wind": 27, "visibility": 2000},
            {"time": 6, "wind": 35, "visibility": 500},
            {"time": 7, "wind": 28, "visibility": 300},
            {"time": 8, "wind": 22, "visibility": 189},
            {"time": 9, "wind": 40, "visibility": 100},
            {"time": 10, "wind": 24, "visibility": 200},
            {"time": 11, "wind": 33, "visibility": 500},
            {"time": 12, "wind": 40, "visibility": 210},
            {"time": 13, "wind": 32, "visibility": 700},
            {"time": 14, "wind": 24, "visibility": 300},
            {"time": 15, "wind": 22, "visibility": 280},
            {"time": 16, "wind": 18, "visibility": 100},
            {"time": 17, "wind": 16, "visibility": 200},
            {"time": 18, "wind": 37, "visibility": 300},
            {"time": 19, "wind": 22, "visibility": 300},
            {"time": 20, "wind": 10, "visibility": 100},
            {"time": 21, "wind": 15, "visibility": 90},
            {"time": 22, "wind": 22, "visibility": 10},
            {"time": 23, "wind": 26, "visibility": 100},
            {"time": 24, "wind": 20, "visibility": 300}
        ]
    }
}

Результат будет в логах и в виде ответного джейсона
![image](https://github.com/M437A/testTaskIdeaPlatform/assets/105558638/d370a1b9-786d-487b-8eaa-5360eb793b08)
