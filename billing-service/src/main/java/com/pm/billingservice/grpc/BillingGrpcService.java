package com.pm.billingservice.grpc;

import billing.BillingResponse;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase{

    private static final Logger log = LoggerFactory.getLogger(
            BillingGrpcService.class);

    @Override
    public void createBillingAccount(
            billing.BillingRequest billingRequest,
            StreamObserver<billing.BillingResponse> responseObserver) {

        log.info("createBillingAccount request received {}",billingRequest.toString());

        // Business logic - e.g save to database, perform calculation etc

        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("12345")
                .setStatus("Active")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
