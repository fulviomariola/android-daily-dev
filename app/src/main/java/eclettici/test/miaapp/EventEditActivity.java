package eclettici.test.miaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalTime;

public class EventEditActivity extends AppCompatActivity {

    private EditText eventNameET;
    private TextView evenDateTV, evenTimeTV;

    private LocalTime time;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        initWidgets();
        time = LocalTime.now();
        evenDateTV.setText("Data: " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        evenTimeTV.setText("Orario: " + CalendarUtils.formattedTime(time));
    }

    private void initWidgets()
    {
        eventNameET = findViewById(R.id.eventNameET);
        evenDateTV = findViewById(R.id.evenDateTV);
        evenTimeTV = findViewById(R.id.evenTimeTV);
    }

    public void saveEventAction(View view)
    {
        String eventName = eventNameET.getText().toString();
        Event newEvent = new Event(eventName,CalendarUtils.selectedDate, time);
        Event.eventList.add(newEvent);
        finish();
    }
}