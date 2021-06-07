package apc.mobprog.mobilenetworkidentifier;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MobNumber.class}, version = 1)
public abstract class MobNumberRoomDatabase extends RoomDatabase {

    public abstract MobNumberDao mobNumberDao();

    private static MobNumberRoomDatabase INSTANCE;

    static MobNumberRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MobNumberRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(),
                                    MobNumberRoomDatabase.class,
                                    "mobilenumber_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
