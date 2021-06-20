package CKT.Ministop.Apk.database;

import androidx.room.TypeConverter;

import java.util.Date;


public class DateConverters {

    @TypeConverter
    public Long getTimeStamp(Date date) {
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public Date getDate(Long timeStamp) {
        return timeStamp == 0 ? null : new Date(timeStamp);
    }
}
