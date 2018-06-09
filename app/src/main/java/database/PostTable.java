package database;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import retrofit2.http.POST;
import util.PostsGetSet;

/**
 * Created by Ali on 09.06.2018.
 */

public class PostTable {
    PostsGetSet col = new PostsGetSet();
    public static final Uri URI = DbHelper.BASE_CINTENT_URI.buildUpon().appendPath(Requests.TABLE_NAME).build();

    public static void save(Context context, @NonNull PostsGetSet postsGetSet) {
        context.getContentResolver().insert(URI, toContentValues(postsGetSet));
    }
    public static void save(Context context, @NonNull List<PostsGetSet> postsGetSets){
        ContentValues[] values = new ContentValues[postsGetSets.size()];
        for (int i = 0; i < postsGetSets.size(); i++){
            values[i] = toContentValues(postsGetSets.get(i));
        }
        context.getContentResolver().bulkInsert(URI, values);
    }
    @NonNull
    public static ContentValues toContentValues(@NonNull PostsGetSet postsGetSet){
        ContentValues values = new ContentValues();
        values.put(columns.id, postsGetSet.getId());
        values.put(columns.name, postsGetSet.getName());
        values.put(columns.age, postsGetSet.getAge());
        values.put(columns.phone, postsGetSet.getPhone());
        values.put(columns.boob, postsGetSet.getBoob());
        values.put(columns.height, postsGetSet.getHeight());
        values.put(columns.weight, postsGetSet.getWeight());
        values.put(columns.note, postsGetSet.getNote());
        values.put(columns.appart_1, postsGetSet.getAppart_1());
        values.put(columns.appart_2, postsGetSet.getAppart_2());
        values.put(columns.appart_Naigth, postsGetSet.getAppart_Naigth());
        values.put(columns.outside_1, postsGetSet.getOutside_1());
        values.put(columns.outside_2, postsGetSet.getOutside_2());
        values.put(columns.appart_Naigth, postsGetSet.getOutside_Nigth());
        return values;
    }
//    @NonNull
//    public static PostsGetSet fromCursor(@NonNull Cursor cursor){
//
//    }
    public interface Requests {
        String TABLE_NAME = PostTable.class.getSimpleName();
        String CREATIONS_REQUEST = "CREATE TABLE "+TABLE_NAME+" ("
                +columns.id            +" INTEGER       NOT NULL,"
                +columns.name          +" VARCHAR (100) NOT NULL,"
                +columns.age           +" VARCHAR (10)  NOT NULL,"
                +columns.phone         +" VARCHAR (12)  NOT NULL,"
                +columns.boob          +" REAL,"
                +columns.height        +" INTEGER,"
                +columns.weight        +" INTEGER,"
                +columns.note          +" TEXT,"
                +columns.image_1       +" VARCHAR (100),"
                +columns.image_2       +" VARCHAR (100),"
                +columns.image_3       +" VARCHAR (100),"
                +columns.image_4       +" VARCHAR (100),"
                +columns.image_5       +" VARCHAR (100),"
                +columns.appart_1      +" VARCHAR (10)  NOT NULL,"
                +columns.appart_2      +" VARCHAR (10)  NOT NULL,"
                +columns.appart_Naigth +" VARCHAR (10)  NOT NULL,"
                +columns.outside_1     +" VARCHAR (10)  NOT NULL,"
                +columns.outside_2     +" VARCHAR (10)  NOT NULL,"
                +columns.outside_Nigth +" VARCHAR (10)  NOT NULL,"
                +columns.sauna_1       +" VARCHAR (10)  NOT NULL,"
                +columns.sauna_2       +" VARCHAR (10)  NOT NULL,"
                +columns.sauna_Nigth   +" VARCHAR (10)  NOT NULL,"
                +columns.engleash      +" INTEGER       NOT NULL,"
                +columns.eye           +" INTEGER       NOT NULL,"
                +columns.hair          +" VARCHAR (30)  NOT NULL,"
                +columns.types         +" VARCHAR (30)  NOT NULL,"
                +columns.status        +" VARCHAR (30)  NOT NULL,);";

        String DROP_REQUEST = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
    public interface columns{
        String id = "id";
        String name = "name";
        String phone = "phone";
        String age = "age";
        String height = "height";
        String weight = "weight";
        String boob = "boob";
        String note = "note";
        String eye = "eye";
        String types = "types";
        String hair = "hair";
        String image_1 = "image_1";
        String image_2 = "image_2";
        String image_3 = "image_3";
        String image_4 = "image_4";
        String image_5 = "image_5";
        String appart_1 = "appart_1";
        String appart_2 = "appart_2";
        String appart_Naigth = "appart_Naigth";
        String outside_1 = "outside_1";
        String outside_2 = "outside_2";
        String outside_Nigth = "outside_Nigth";
        String sauna_1 = "sauna_1";
        String sauna_2 = "sauna_2";
        String sauna_Nigth = "sauna_Nigth";
        String engleash = "eye";
        String status = "status";

    }
}
