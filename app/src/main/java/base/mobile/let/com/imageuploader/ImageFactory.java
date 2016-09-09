package base.mobile.let.com.imageuploader;

import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by raul.striglio on 09/09/16.
 */
public class ImageFactory {

    public static File newFile() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File imageFile;

        try {
            imageFile = File.createTempFile(imageFileName, ".jpg", storageDir);

        } catch (IOException e) {
            return null;
        }
        return imageFile;
    }

}
