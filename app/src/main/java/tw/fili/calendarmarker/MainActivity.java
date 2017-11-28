package tw.fili.calendarmarker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<EventDay> events = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, 11, 5);
        events.add(new EventDay(calendar, R.drawable.porkcutlet1229));

        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setEvents(events);

        calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(EventDay eventDay) {
                Calendar calendar = eventDay.getCalendar();
                String s = calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DAY_OF_MONTH);
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT )
                        .show();
            }
        });
    }
}
