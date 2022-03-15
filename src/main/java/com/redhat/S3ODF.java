package com.redhat;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import javax.inject.Inject;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.SdkHttpConfigurationOption;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.ListObjectsRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Object;
import software.amazon.awssdk.utils.AttributeMap;

@Command(name = "greeting", mixinStandardHelpOptions = true)
public class S3ODF implements Runnable {

    @Inject
    S3Client client;

    @Parameters(paramLabel = "<operation>", defaultValue = "test", description = "Operation to perform")
    String operation;

    String src;
    String target;

    @Override
    public void run() {
        
                SdkHttpClient httpClient = UrlConnectionHttpClient
                .builder()
                .buildWithDefaults(AttributeMap.builder()
                        .put(SdkHttpConfigurationOption.TRUST_ALL_CERTIFICATES, Boolean.TRUE)
                        .build());
        
       /* CreateBucketRequest createBucketRequest = CreateBucketRequest.builder().bucket("bucket").build();*/
        
        /*client.createBucket(createBucketRequest);*/
        operation=client.listBuckets().toString();

        System.out.printf("%s\n", operation);
    }

}
