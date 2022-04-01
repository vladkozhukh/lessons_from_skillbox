# m2_layout

# Вёрстка должна быть с отступами (все отступы в макете 16dp).
Видео про отступы: https://www.youtube.com/watch?v=QSYhEYJMUBE&feature=youtu.be

# CustomView должен встраиваться в main_activity.xml и отображаться при запуске приложения.

# Тексты внутри виджетов «Верхняя строчка» и «Нижняя строчка» должны настраиваться из кода MainActivity.
Например: из кода MainActivity настройте CustomView так, чтобы отобразилось «верхняя строчка, 
настроенная из кода», «нижняя строчка, настроенная из кода».

# Советы и рекомендации 

1. Чёрный квадрат можно сделать при помощи FrameLayout c таким бэкграундом:
android:background="@android:color/black"

2. Серый квадрат тоже сделайте с помощью FrameLayout background = @android:color/darker_gray
android:background="@android:color/darker_gray

3. Убедитесь, что верхняя и нижняя строчка не переносятся на новую строку, когда в них подставляется
длинный текст.
Например, попробуйте подставить
android:text="@tools:sample/lorem/random" // генерация случайного длинного текста

Чтобы текст не переносился, используйте атрибуты
android:lines="1" // 1 строка
android:ellipsize="end" // если не вмещается текст в конце идет обрыв, сокращение "слова..."

Попробуйте поменять значение атрибута ellipsize при длинном тексте, например на middle
(точки в середине текста), и посмотрите, что произойдет со значением текстового поля.