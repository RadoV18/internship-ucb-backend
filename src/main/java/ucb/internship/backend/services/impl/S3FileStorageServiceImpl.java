package ucb.internship.backend.services.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ucb.internship.backend.exceptions.FileStorageException;
import ucb.internship.backend.models.S3Object;
import ucb.internship.backend.repositories.S3ObjectRepository;
import ucb.internship.backend.services.FileStorageService;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Service
public class S3FileStorageServiceImpl implements FileStorageService {
    @Autowired
    private AmazonS3 amazonS3;

    @Autowired
    private S3ObjectRepository s3ObjectRepository;

    @Value("${aws.s3.bucket}")
    private String bucket;

    public S3FileStorageServiceImpl() {
    }

    public S3FileStorageServiceImpl(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    private String upload(MultipartFile file) throws FileStorageException {
        try {
            // file name
            UUID uuid = UUID.randomUUID();
            String fileName = uuid.toString();

            String extension = Objects.requireNonNull(file.getContentType().split("/")[1]);
            fileName += ("." + extension);

            // file metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(file.getContentType());
            objectMetadata.setContentLength(file.getSize());

            // upload file
            amazonS3.putObject(bucket, fileName, file.getInputStream(), objectMetadata);
            return amazonS3.getUrl(bucket, fileName).toString();
        } catch (IOException ex) {
            throw new FileStorageException("Error al guardar la imagen.", ex);
        }
    }

    @Override
    public S3Object createObject(MultipartFile file) throws FileStorageException {
        // save the image in the file storage
        String url = upload(file);
        // save the image data in the database
        S3Object s3Object = new S3Object();
        s3Object.setUrl(url);
        s3Object.setStatus(true);
        return s3ObjectRepository.save(s3Object);
    }

}
