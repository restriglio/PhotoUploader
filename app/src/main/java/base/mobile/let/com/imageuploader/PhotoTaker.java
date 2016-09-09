package base.mobile.let.com.imageuploader;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import android.provider.MediaStore;

import java.io.File;


public class PhotoTaker {

    public static final int REQUEST_TAKE_PHOTO = 101;

    private final Activity mActivity;

    public PhotoTaker(Activity activity) {
        mActivity = activity;
    }

    public boolean takePhoto(File outputFile) {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(mActivity.getPackageManager()) != null) {
            if (outputFile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(outputFile));
                mActivity.startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
                return true;
            }
        }
        return false;
    }
}