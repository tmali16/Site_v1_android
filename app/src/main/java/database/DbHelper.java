package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

/**
 * Created by Ali on 09.06.2018.
 */

public class DbHelper extends SQLiteOpenHelper {
    public static final String CONTENT_AUTHORITY = "com.cache";
    public static final Uri BASE_CINTENT_URI = Uri.parse("content://"+CONTENT_AUTHORITY);
    private static String DB_NAME = "responsed_data.db";
    private static int VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PostTable.Requests.CREATIONS_REQUEST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(PostTable.Requests.DROP_REQUEST);
        onCreate(db);
    }
}
