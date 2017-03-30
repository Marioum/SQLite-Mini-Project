package com.example.media_tech.eeeexx;

import android.provider.BaseColumns;

/**
 * Created by Media_Tech on 24/11/2016.
 */
public class DatabaseContact {
    public interface Os extends BaseColumns{
        String tableName="ostable";
        String columnName="name";
        String columnNameType="TEXT";
        String columnNbuser="nbuser";
        String columnNbuserType="number";
        String columnNbversion="nbversion";
        String columnNbversionType="number";
        String columnNbsmart="nbsmart";
        String columnNbsmartType="number";
    }

}
