package com.olskrain.helloactivityhm;

import android.content.res.Resources;
import java.util.Calendar;

// Построитель фразы приветствия
public class BuilderGreetingPhrase {
    private int currentHour;        // Текущий час
    private GreetingStrings greetingPhrases;    // строки приветствия

    // Конструктор, здесь передадим ресурсы из активити и получим текущий час
    public BuilderGreetingPhrase(GreetingStrings greetingPhrases){
        this(greetingPhrases, Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
    }

    // Конструктор для тестирования
    BuilderGreetingPhrase(GreetingStrings greetingPhrases, int hour){
        currentHour = hour;
        this.greetingPhrases = greetingPhrases;
    }

    // Определение, какую-же строку надо сформировать
    public String get(){
        String helloer = greetingPhrases.getHelloer();
        if (5 <= currentHour && currentHour < 12 ){         // Если утро
            return String.format("%s %s!", greetingPhrases.getMorning(), helloer);
        }
        else if (12 <= currentHour && currentHour < 18){     // Если день
            return String.format("%s %s!", greetingPhrases.getAfternoon(), helloer);
        }
        else if (18 <= currentHour && currentHour < 21){      // Если вечер
            return String.format("%s %s!", greetingPhrases.getEvening(), helloer);
        }
        else {                                              // Если поздний вечер или ночь
            return String.format("%s %s!", greetingPhrases.getNight(), helloer);
        }
    }
}
