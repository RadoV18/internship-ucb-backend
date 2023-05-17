package ucb.internship.backend.configs;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3AwsConfig {
    @Value("${aws.s3.accessKey}")
    private String id;

    @Value("${aws.s3.secret}")
    private String key;

    @Value("${aws.s3.region}")
    private String region;

    @Bean
    public AmazonS3 s3client() {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(id, key);
        return AmazonS3ClientBuilder.standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}
