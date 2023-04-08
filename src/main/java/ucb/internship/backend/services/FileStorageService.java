package ucb.internship.backend.services;

import org.springframework.web.multipart.MultipartFile;
import ucb.internship.backend.exceptions.FileStorageException;
import ucb.internship.backend.models.S3Object;

public interface FileStorageService {
    /**
     * uploads a file to S3
     *
     * @param file the file to upload
     * @return the file url
     * @throws FileStorageException if the service fails
     */
    private String upload(MultipartFile file) throws FileStorageException {
        return null;
    }

    /**
     * creates an S3 Object on the database
     * @param file the file to upload
     * @return the S3Object
     */
    public S3Object createObject(MultipartFile file) throws FileStorageException;
}
