package com.example.yks93.actionbarcompat_shareactionprovider_copy.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by yks93 on 3/22/18.
 */

public class AssetProvider extends ContentProvider {

    public static String CONTENT_URI = "com.example.yks93.actionbarcompat_shareactionprovider_copy";

    @Override
    public boolean onCreate() {
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s,
                        @Nullable String[] strings1, @Nullable String s1) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    public AssetFileDescriptor openAssetFile(Uri uri, String mode) throws FileNotFoundException {
        final String assetName = uri.getLastPathSegment();

        if (TextUtils.isEmpty(assetName))
            throw new FileNotFoundException("File Not Found");

        try {
            AssetManager am = getContext().getAssets();
            return am.openFd(assetName);

        } catch(IOException e) {
            e.printStackTrace();
            return super.openAssetFile(uri, mode);
        }
    }

}
