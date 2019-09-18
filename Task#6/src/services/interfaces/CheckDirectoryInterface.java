package services.interfaces;

import java.io.File;

public interface CheckDirectoryInterface extends CollectionServiceInterface {
    void readFiles(File file);
}
