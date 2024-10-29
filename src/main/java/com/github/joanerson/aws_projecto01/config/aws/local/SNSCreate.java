package com.github.joanerson.aws_projecto01.config.aws.local;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.Topic;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
@Log4j2
public class SNSCreate {
    private final String productEventsTopic;
    private final AmazonSNS amazonSNS;

    public SNSCreate() {
        this.amazonSNS = AmazonSNSClient.builder()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:4566", Regions.US_EAST_1.getName()))
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .build();

        CreateTopicRequest createTopicRequest = new CreateTopicRequest("product-events");
        this.productEventsTopic = this.amazonSNS.createTopic(createTopicRequest).getTopicArn();;
        log.info("SNS topic ARN:{}", this.productEventsTopic);
    }

    @Bean
    public AmazonSNS snsClient(){
        return this.amazonSNS;
    }

    @Bean(name = "productEventsTopic")
    public Topic snsProductEventsTopic() {
        return new Topic().withTopicArn(productEventsTopic);
    }
}