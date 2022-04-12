m8_quiz_animation

как установить lottie
0. Прописываем в градл:
   def lottieVersion = "3.4.0"
   implementation "com.airbnb.android:lottie:$lottieVersion"
   
1. качаем нужный нам шаблон из сайта https://lottiefiles.com/
   
2. устанавливаем его по пути создав директорию \app\src\main\res\raw
   
3. переносим его в эту директорию, файл для удобства переименовываем:
   ..raw\crew_spencer_question.json
   
4. Прописываем его в нужной вам разметке:
   ..src/main/res/layout/fragment_first.xml
   
5. <com.airbnb.lottie.LottieAnimationView
   app:lottie_rawRes="@raw/crew_spencer_question"   - применяем загруженный lottie
   app:lottie_autoPlay="true"                       - автовоспроизведение
   app:lottie_loop="true"                           - повтор после окончания показа
   android:alpha="0"                                - прозрачность значение от 0 до 1
   />
