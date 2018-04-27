package com.example.yks93.actionbarcompat_shareactionprovider_copy.content;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/**
 * Created by yks93 on 3/22/18.
 */

public class ContentItem {
    public static final int CONTENT_TYPE_IMAGE = 0;
    public static final int CONTENT_TYPE_TEXT = 1;

    public final int contentType;
    public final int contentResourceId;
    public final String contentAssetFilePath;

    /**
     * Creates a ContentItem with the specified type, referencing a resource id.
     *
     * @param type - One of {@link #CONTENT_TYPE_IMAGE} or {@link #CONTENT_TYPE_TEXT}
     * @param resourceId - Resource ID to use for this item's content
     */
    public ContentItem(int type, int resourceId) {
        contentType = type;
        contentResourceId = resourceId;
        contentAssetFilePath = null;
    }

    /**
     * Creates a ContentItem with the specified type, referencing an asset file path.
     * @param type - One of {@link #CONTENT_TYPE_IMAGE} or {@link #CONTENT_TYPE_TEXT}
     * @param assetFilePath - File path from the application's asset for this item's content
     */
    public ContentItem(int type, String assetFilePath) {
        contentType = type;
        contentAssetFilePath = assetFilePath;
        contentResourceId = 0;
    }

    /**
     * @return Uri to the content
     */
    public Uri getContentUri() {
        if (!TextUtils.isEmpty(contentAssetFilePath))
            return Uri.parse("content://" + AssetProvider.CONTENT_URI + "/" + contentAssetFilePath);
        else
            return null;
    }

    public Intent getShareIntent(Context context) {
        Intent intent = new Intent(Intent.ACTION_SEND);

        switch (contentType)
        {
            case CONTENT_TYPE_IMAGE:
                intent.setType("image/jpg");
                intent.putExtra(Intent.EXTRA_STREAM, getContentUri());
                return intent;

            case CONTENT_TYPE_TEXT:
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, context.getString(contentResourceId));
                return intent;
        }
    }

}
