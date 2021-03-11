package org.equilibrium.yandex.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

public class YandexQueueCredentialsProvider implements AWSCredentialsProvider {

    private String awsSecretKeyId;
    private String awsSecretAccessKey;

    public YandexQueueCredentialsProvider(String awsSecretKeyId, String awsSecretAccessKey) {
        this.awsSecretKeyId = awsSecretKeyId;
        this.awsSecretAccessKey = awsSecretAccessKey;
    }

    public String getAwsSecretAccessKey() {
        return awsSecretAccessKey;
    }

    public void setAwsSecretAccessKey(String awsSecretAccessKey) {
        this.awsSecretAccessKey = awsSecretAccessKey;
    }

    public String getAwsSecretKeyId() {
        return awsSecretKeyId;
    }

    public void setAwsSecretKeyId(String awsSecretKeyId) {
        this.awsSecretKeyId = awsSecretKeyId;
    }

    @Override
    public AWSCredentials getCredentials() {
        return new AWSCredentials() {
            @Override
            public String getAWSAccessKeyId() {
                return awsSecretKeyId;
            }

            @Override
            public String getAWSSecretKey() {
                return awsSecretAccessKey;
            }
        };
    }

    @Override
    public void refresh() {

    }
}
